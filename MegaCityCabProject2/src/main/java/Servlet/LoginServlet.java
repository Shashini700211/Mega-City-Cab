package Servlet;

import Services.UserService;
import Models.User;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // Create a logger instance
    private static final Logger logger = Logger.getLogger(LoginServlet.class.getName());
    
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // If user is already logged in, redirect to home page
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            response.sendRedirect("home.jsp");
        } else {
            // Otherwise, show login page
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Basic validation
        if (username == null || username.trim().isEmpty() || 
            password == null || password.trim().isEmpty()) {
            
            request.setAttribute("error", "Username and password are required");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
            return;
        }
        
        try {
            // Use UserService to properly authenticate with BCrypt
            User authenticatedUser = userService.authenticateUser(username, password);
            
            if (authenticatedUser != null) {
                // Create a session for this user
                HttpSession session = request.getSession();
                session.setAttribute("user", authenticatedUser);
                session.setAttribute("username", authenticatedUser.getUsername());
                session.setAttribute("userEmail", authenticatedUser.getEmail());
                session.setAttribute("userRole", authenticatedUser.getRole());
                
                logger.log(Level.INFO, "User logged in: {0}", username);
                
                // Redirect to home page after successful login
                response.sendRedirect("home.jsp");
            } else {
                // Authentication failed
                request.setAttribute("error", "Invalid username or password");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error during login", e);
            request.setAttribute("error", "An error occurred during login");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }
}