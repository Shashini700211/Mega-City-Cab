package Servlet;

import Services.BookingService;
import Models.Booking;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddBookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // Create a logger instance
    private static final Logger logger = Logger.getLogger(AddBookingServlet.class.getName());

    private BookingService bookingService = new BookingService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Display the form for adding a booking (optional)
        request.getRequestDispatcher("addBookingForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get parameters from the form
        String bookingId = request.getParameter("bookingId");
        String customerId = request.getParameter("customerId");
        String pickupLocation = request.getParameter("pickupLocation");
        String destination = request.getParameter("destination");
        String carId = request.getParameter("carId");
        String driverId = request.getParameter("driverId");
        String status = request.getParameter("status");

        // Basic validation of the form fields
        if (bookingId == null || bookingId.trim().isEmpty() ||
            customerId == null || customerId.trim().isEmpty() ||
            pickupLocation == null || pickupLocation.trim().isEmpty() ||
            destination == null || destination.trim().isEmpty() ||
            carId == null || carId.trim().isEmpty() ||
            driverId == null || driverId.trim().isEmpty() ||
            status == null || status.trim().isEmpty()) {

            // Log error and show an error message to the user
            logger.log(Level.WARNING, "Invalid booking form submission: Missing required fields.");
            request.setAttribute("error", "All fields are required.");
            request.getRequestDispatcher("addBookingForm.jsp").forward(request, response);
            return;
        }

        // Create the Booking object
        Booking booking = new Booking(bookingId, customerId, pickupLocation, destination, carId, driverId, status);
        
        // Attempt to add the booking using the BookingService
        try {
            bookingService.addBooking(booking);
            logger.log(Level.INFO, "Booking added successfully: {0}", bookingId);
            response.sendRedirect("viewBookings.jsp");  // Redirect to view bookings page
        } catch (Exception e) {
        	
            // Log the error
            logger.log(Level.SEVERE, "Error while adding booking", e);
            
            
            // Set the error message in request scope and forward to the form page
            request.setAttribute("error", "There was an error processing your booking.");
            request.getRequestDispatcher("addBookingForm.jsp").forward(request, response);
        }
    }
}
