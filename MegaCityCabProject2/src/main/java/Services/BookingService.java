package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Models.Booking;



public class BookingService {
    private static final String URL = "jdbc:mysql://localhost:3306/cab_booking_system?characterEncoding=utf8&serverTimezone=UTC&useSSL=false&verifyServerCertificate=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456789abcd";

    // Private method to get database connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // Method that uses getConnection()
    public void addBooking(Booking booking) {
        String sql = "INSERT INTO bookings (bookingId, customerId, pickupLocation, destination, carId, driverId, status) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection(); // ✅ Now using getConnection()
             PreparedStatement stmt = conn.prepareStatement(sql)) {

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
}