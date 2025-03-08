package Servlet;

import Services.CustomerService;
import Models.Customer;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AddCustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private CustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Display the form for adding a customer
        request.getRequestDispatcher("addCustomerForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get parameters from the form
        String customerId = request.getParameter("customerId");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String nic = request.getParameter("nic");
        String phone = request.getParameter("phone");

        // Basic validation
        if (customerId == null || customerId.trim().isEmpty() ||
            name == null || name.trim().isEmpty() ||
            address == null || address.trim().isEmpty() ||
            nic == null || nic.trim().isEmpty() ||
            phone == null || phone.trim().isEmpty()) {

            // Set error message and forward back to the form
            request.setAttribute("error", "All fields are required.");
            request.getRequestDispatcher("addCustomerForm.jsp").forward(request, response);
            return;
        }

        // Create the Customer object
        Customer customer = new Customer(customerId, name, address, nic, phone);
        
        // Add the customer using CustomerService
        try {
            customerService.addCustomer(customer);
            response.sendRedirect("viewCars.jsp");  // Redirect to view cars page after registration
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error adding customer: " + e.getMessage());
            request.getRequestDispatcher("addCustomerForm.jsp").forward(request, response);
        }
    }
}