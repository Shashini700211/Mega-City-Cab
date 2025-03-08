package Servlet;

import Services.DriverService;
import Models.Driver;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AddDriverServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
    
    private DriverService driverService = new DriverService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String driverId = request.getParameter("driverId");
        String name = request.getParameter("name");
        String licenseNumber = request.getParameter("licenseNumber");
        String phone = request.getParameter("phone");
        String status = request.getParameter("status");

        Driver driver = new Driver(driverId, name, licenseNumber, phone, status);
        driverService.addDriver(driver);
        
        response.sendRedirect("viewDrivers.jsp");  // Redirect to view drivers page after adding
    }


}
