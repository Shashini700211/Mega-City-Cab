package Services;

import Models.Booking;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BookingService {
	private static final String URL = "jdbc:mysql://localhost:3306/cab_booking_system?characterEncoding=utf8&serverTimezone=UTC&useSSL=false&verifyServerCertificate=false";
    private static final String USER = "root";
    private static final String PASSWORD = "123456789abcd"; 
    
 // Establish the connection to the database
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
        
    // Add new booking
    public void addBooking(Booking booking) {
        String query = "INSERT INTO bookings (bookingId, customerId, pickupLocation, destination, carId, driverId, status) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, booking.getBookingId());
            stmt.setString(2, booking.getCustomerId());
            stmt.setString(3, booking.getPickupLocation());
            stmt.setString(4, booking.getDestination());
            stmt.setString(5, booking.getCarId());
            stmt.setString(6, booking.getDriverId());
            stmt.setString(7, booking.getStatus());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve all bookings
    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM bookings";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                bookings.add(new Booking(
                    rs.getString("bookingId"),
                    rs.getString("customerId"),
                    rs.getString("pickupLocation"),
                    rs.getString("destination"),
                    rs.getString("carId"),
                    rs.getString("driverId"),
                    rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }


}
