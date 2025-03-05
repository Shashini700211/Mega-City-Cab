package Services;

import Models.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverService {
	 private static final String URL = "jdbc:mysql://localhost:3306/cab_booking_system?characterEncoding=utf8&serverTimezone=UTC&useSSL=false&verifyServerCertificate=false";
	    private static final String USER = "root"; 
	    private static final String PASSWORD = "123456789abcd"; 

	    private Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }
	    
	    
       // Add a new driver
	    public void addDriver(Driver driver) {
	        String query = "INSERT INTO drivers (driverId, name, licenseNumber, phone, status) VALUES (?, ?, ?, ?, ?)";

	        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
	            stmt.setString(1, driver.getDriverId());
	            stmt.setString(2, driver.getName());
	            stmt.setString(3, driver.getLicenseNumber());
	            stmt.setString(4, driver.getPhone());
	            stmt.setString(5, driver.getStatus());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Get all drivers
	    public List<Driver> getAllDrivers() {
	        List<Driver> drivers = new ArrayList<>();
	        String query = "SELECT * FROM drivers";

	        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
	            while (rs.next()) {
	                drivers.add(new Driver(
	                        rs.getString("driverId"),
	                        rs.getString("name"),
	                        rs.getString("licenseNumber"),
	                        rs.getString("phone"),
	                        rs.getString("status")
	                ));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return drivers;
	    }
	

}
