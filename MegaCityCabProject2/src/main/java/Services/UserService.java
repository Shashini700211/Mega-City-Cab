package Services;

import Models.User;
import java.sql.*;
import org.mindrot.jbcrypt.BCrypt;

public class UserService {
    private static final String URL = "jdbc:mysql://localhost:3306/cab_booking_system?characterEncoding=utf8&serverTimezone=UTC&useSSL=false&verifyServerCertificate=false";
    private static final String USER = "root"; 
    private static final String PASSWORD = "123456789abcd"; 

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    // Register a new user
    public boolean registerUser(User user) {
        String query = "INSERT INTO users (username, email, password, role, customerId) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            
            // Hash the password before storing
            String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, hashedPassword);
            stmt.setString(4, user.getRole());
            stmt.setString(5, user.getCustomerId());
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        user.setId(generatedKeys.getInt(1));
                        return true;
                    }
                }
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Authenticate a user by username
    public User authenticateUser(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ?";
        
        try (Connection conn = getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, username);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Get the stored hashed password
                    String storedHash = rs.getString("password");
                    
                    // Check if the provided password matches the stored hash
                    if (BCrypt.checkpw(password, storedHash)) {
                        // Password is correct, create and return user object
                        return new User(
                            rs.getInt("id"),
                            rs.getString("username"),
                            rs.getString("email"),
                            storedHash, // Don't store the plaintext password
                            rs.getString("role"),
                            rs.getString("customerId")
                        );
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // Authentication failed
        return null;
    }
    
    // Original email-based authentication method for backward compatibility
    public User authenticateUserByEmail(String email, String password) {
        String query = "SELECT * FROM users WHERE email = ?";
        
        try (Connection conn = getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, email);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Get the stored hashed password
                    String storedHash = rs.getString("password");
                    
                    // Check if the provided password matches the stored hash
                    if (BCrypt.checkpw(password, storedHash)) {
                        // Password is correct, create and return user object
                        return new User(
                            rs.getInt("id"),
                            rs.getString("username"),
                            rs.getString("email"),
                            storedHash, // Don't store the plaintext password
                            rs.getString("role"),
                            rs.getString("customerId")
                        );
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // Authentication failed
        return null;
    }
    
    // Get user by username
    public User getUserByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ?";
        
        try (Connection conn = getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, username);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getString("customerId")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    // Get user by email
    public User getUserByEmail(String email) {
        String query = "SELECT * FROM users WHERE email = ?";
        
        try (Connection conn = getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, email);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getString("customerId")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
}