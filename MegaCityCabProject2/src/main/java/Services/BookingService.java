package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    // Get booking by ID
    public Booking getBookingById(String bookingId) {
        String query = "SELECT * FROM bookings WHERE bookingId = ?";

        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, bookingId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Booking(
                        rs.getString("bookingId"),
                        rs.getString("customerId"),
                        rs.getString("pickupLocation"),
                        rs.getString("destination"),
                        rs.getString("carId"),
                        rs.getString("driverId"),
                        rs.getString("status")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Get all bookings
    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM bookings";

        try (Connection conn = getConnection();
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

    // Method in BookingService
    public Booking getBookingWithBillingById(String bookingId) {
        String query = "SELECT * FROM bookings WHERE bookingId = ?";

        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, bookingId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Create booking with billing details
                    Booking booking = new Booking(
                        rs.getString("bookingId"),
                        rs.getString("customerId"),
                        rs.getString("pickupLocation"),
                        rs.getString("destination"),
                        rs.getString("carId"),
                        rs.getString("driverId"),
                        rs.getString("status"),
                        rs.getTimestamp("bookingDate"),
                        rs.getDouble("distance"),
                        rs.getDouble("baseFare"),
                        rs.getDouble("taxes"),
                        rs.getDouble("discounts"),
                        rs.getDouble("totalAmount")
                    );

                    // If some values are missing, calculate them
                    if (booking.getTotalAmount() == 0 && booking.getDistance() > 0) {
                        booking.calculateTotalFare();
                    }

                    return booking;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
