package Servlet;

import Models.Booking;
import Models.Customer;
import Services.BookingService;
import Services.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PrintBillServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private BookingService bookingService = new BookingService();
    private CustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check if user is logged in
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("login");
            return;
        }

        String bookingId = request.getParameter("id");

        if (bookingId == null || bookingId.trim().isEmpty()) {
            request.setAttribute("error", "Booking ID is required");
            request.getRequestDispatcher("viewBookings").forward(request, response);
            return;
        }

        try {
            Booking booking = bookingService.getBookingWithBillingById(bookingId);

            if (booking == null) {
                request.setAttribute("error", "Booking not found");
                request.getRequestDispatcher("viewBookings").forward(request, response);
                return;
            }

            // Get customer details for this booking
            Customer customer = customerService.getCustomerById(booking.getCustomerId());

            request.setAttribute("booking", booking);
            request.setAttribute("customer", customer);
            request.setAttribute("currentDate", new java.util.Date());

            request.getRequestDispatcher("printBill.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error retrieving booking details: " + e.getMessage());
            request.getRequestDispatcher("viewBookings").forward(request, response);
        }
    }
}
