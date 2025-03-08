package Servlet;

import Services.BookingService;
import Services.CustomerService;
import Models.Booking;
import Models.Customer;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddBookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(AddBookingServlet.class.getName());
    private BookingService bookingService = new BookingService();
    private CustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Display the booking form
        request.getRequestDispatcher("addBookingForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get parameters from the form
        String bookingId = request.getParameter("bookingId");
        String customerId = request.getParameter("customerId");
        String customerName = request.getParameter("customerName");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String pickupLocation = request.getParameter("pickupLocation");
        String destination = request.getParameter("destination");
        String carId = request.getParameter("carId");
        String driverId = request.getParameter("driverId");
        String status = request.getParameter("status");

        // Validate required fields
        if (bookingId == null || bookingId.trim().isEmpty() ||
            customerId == null || customerId.trim().isEmpty() ||
            customerName == null || customerName.trim().isEmpty() ||
            address == null || address.trim().isEmpty() ||
            phone == null || phone.trim().isEmpty() ||
            pickupLocation == null || pickupLocation.trim().isEmpty() ||
            destination == null || destination.trim().isEmpty() ||
            carId == null || carId.trim().isEmpty() ||
            driverId == null || driverId.trim().isEmpty() ||
            status == null || status.trim().isEmpty()) {

            logger.log(Level.WARNING, "Invalid booking form submission: Missing required fields.");
            request.setAttribute("error", "All fields are required.");
            request.getRequestDispatcher("addBookingForm.jsp").forward(request, response);
            return;
        }

        try {
            // Check if customer exists, if not create a new customer
            Customer customer = customerService.getCustomerById(customerId);
            if (customer == null) {
                customer = new Customer(customerId, customerName, address, "", phone);
                customerService.addCustomer(customer);
                logger.log(Level.INFO, "New customer created: {0}", customerId);
            }

            // Create the Booking object
            Booking booking = new Booking(bookingId, customerId, pickupLocation, destination, carId, driverId, status);

            // Add the booking
            bookingService.addBooking(booking);
            logger.log(Level.INFO, "Booking added successfully: {0}", bookingId);

            response.sendRedirect("viewBookings.jsp");  // Redirect to view bookings page
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error while processing booking", e);
            request.setAttribute("error", "There was an error processing your booking: " + e.getMessage());
            request.getRequestDispatcher("addBookingForm.jsp").forward(request, response);
        }
    }
}
