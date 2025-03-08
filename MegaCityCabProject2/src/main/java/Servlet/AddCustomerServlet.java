package Servlet;

import Services.CustomerService;
import Models.Customer;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AddCustomerServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	    
	    private CustomerService customerService = new CustomerService();

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String customerId = request.getParameter("customerId");
	        String name = request.getParameter("name");
	        String address = request.getParameter("address");
	        String nic = request.getParameter("nic");
	        String phone = request.getParameter("phone");

	        Customer customer = new Customer(customerId, name, address, nic, phone);
	        customerService.addCustomer(customer);
	        
	        response.sendRedirect("viewCustomers.jsp");  // Redirect to view customers page after adding
	    }
	

}
