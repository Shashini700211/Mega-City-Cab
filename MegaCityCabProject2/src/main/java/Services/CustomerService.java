package Services;

import Models.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
	private static final String URL = "jdbc:mysql://localhost:3306/cab_booking_system?characterEncoding=utf8&serverTimezone=UTC&useSSL=false&verifyServerCertificate=false";
    private static final String USER = "root"; 
    private static final String PASSWORD = "123456789abcd"; 

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Add a new customer
    public boolean addCustomer(Customer customer) {
        String query = "INSERT INTO customers (customerId, name, address, nic, phone) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, customer.getCustomerId());
            stmt.setString(2, customer.getName());
            stmt.setString(3, customer.getAddress());
            stmt.setString(4, customer.getNic());
            stmt.setString(5, customer.getPhone());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get all customers
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM customers";

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                customers.add(new Customer(
                        rs.getString("customerId"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("nic"),
                        rs.getString("phone")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
    
    // Authenticate a customer
    public boolean authenticateCustomer(String email, String password) {
        // For demo purposes, let's authenticate with hardcoded credentials
        // In a real application, you would check against your database
        
        // This is a simple example - in production, you should use proper password hashing
        if ("admin@example.com".equals(email) && "password123".equals(password)) {
            return true;
        }
        
        // For now, since our customer table doesn't have email/password fields,
        // we'll use this simple check. In a real app, you would query the database.
        String query = "SELECT * FROM customers WHERE customerId = ?";
        
        try (Connection conn = getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                // If a record exists, we'll consider it authenticated
                // In a real app, you'd compare hashed passwords here
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get customer by ID
    public Customer getCustomerById(String customerId) {
        String query = "SELECT * FROM customers WHERE customerId = ?";

        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, customerId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Customer(
                        rs.getString("customerId"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("nic"),
                        rs.getString("phone")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
