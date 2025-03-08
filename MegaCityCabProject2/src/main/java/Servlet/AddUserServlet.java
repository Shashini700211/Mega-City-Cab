package Servlet;

import Services.UserService;
import Services.CustomerService;
import Models.User;
import Models.Customer;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(AddUserServlet.class.getName());
    
    private UserService userService = new UserService();
    private CustomerService customerService = new CustomerService();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Display the form for adding a user
        request.getRequestDispatcher("Register.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get parameters from the form
        String fullName = request.getParameter("User_FullName");
        String username = request.getParameter("User_Username");
        String email = request.getParameter("User_Email");
        String password = request.getParameter("User_Password");
        String confirmPassword = request.getParameter("User_Confirm_Password");
        String nic = request.getParameter("User_NIC");
        String address = request.getParameter("User_Address");
        String phone = request.getParameter("User_Telephone_Number");
        
        // Basic validation
        if (fullName == null || fullName.trim().isEmpty() ||
            username == null || username.trim().isEmpty() ||
            email == null || email.trim().isEmpty() ||
            password == null || password.trim().isEmpty() ||
            confirmPassword == null || confirmPassword.trim().isEmpty() ||
            nic == null || nic.trim().isEmpty() ||
            address == null || address.trim().isEmpty() ||
            phone == null || phone.trim().isEmpty()) {
            
            request.setAttribute("error", "All fields are required");
            request.getRequestDispatcher("Register.jsp").forward(request, response);
            return;
        }
        
        if (!password.equals(confirmPassword)) {
            request.setAttribute("error", "Passwords do not match");
            request.getRequestDispatcher("Register.jsp").forward(request, response);
            return;
        }
        
        try {
            // Check if username already exists
            if (userService.getUserByUsername(username) != null) {
                request.setAttribute("error", "Username already exists");
                request.getRequestDispatcher("Register.jsp").forward(request, response);
                return;
            }
            
            // Check if email already exists
            if (userService.getUserByEmail(email) != null) {
                request.setAttribute("error", "Email already exists");
                request.getRequestDispatcher("Register.jsp").forward(request, response);
                return;
            }
            
            // Generate a unique customer ID
            String customerId = "CUS" + UUID.randomUUID().toString().substring(0, 8);
            
            // Create the Customer object
            Customer customer = new Customer(customerId, fullName, address, nic, phone, email);
            
            // Add the customer
            boolean customerAdded = customerService.addCustomer(customer);
            
            if (customerAdded) {
                // Create the User object with role "customer"
                User user = new User(username, email, password, "customer", customerId);
                
                // Register the user
                boolean userRegistered = userService.registerUser(user);
                
                if (userRegistered) {
                    // Set a success message
                    request.getSession().setAttribute("message", "Registration successful! Please log in.");
                    response.sendRedirect("Login.jsp");
                    return;
                }
            }
            
            // If we get here, something went wrong
            request.setAttribute("error", "Failed to register user");
            request.getRequestDispatcher("Register.jsp").forward(request, response);
            
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error during user registration", e);
            request.setAttribute("error", "Error during registration: " + e.getMessage());
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        }
    }
}