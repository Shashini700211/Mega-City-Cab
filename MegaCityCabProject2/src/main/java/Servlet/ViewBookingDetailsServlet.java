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

public class ViewBookingDetailsServlet extends HttpServlet {
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

            // If billing details are missing, calculate them
            if (booking.getTotalAmount() == 0) {
                // Default values for demo purposes
                booking.setDistance(15.5); // 15.5 km
                booking.setBaseFare(500.0); // Base fare for the trip
                booking.setTaxes(booking.getBaseFare() * 0.08); // 8% tax
                booking.setDiscounts(0.0); // No discount
                booking.calculateTotalFare();
            }

            // Get customer details for this booking
            Customer customer = customerService.getCustomerById(booking.getCustomerId());

            request.setAttribute("booking", booking);
            request.setAttribute("customer", customer);
            request.getRequestDispatcher("bookingDetails.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error retrieving booking details: " + e.getMessage());
            request.getRequestDispatcher("viewBookings").forward(request, response);
        }
    }
}
