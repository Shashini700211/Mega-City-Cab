package Servlet;

import Services.CarService;
import Models.Car;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;


public class ViewCarsServlet extends HttpServlet{
	 private static final long serialVersionUID = 1L;
	    
	    private CarService carService = new CarService();

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Fetch all cars from the service
	        List<Car> carList = carService.getAllCars();
	        
	        // Set cars list in request scope
	        request.setAttribute("cars", carList);
	        
	        // Forward to viewCars.jsp
	        RequestDispatcher dispatcher = request.getRequestDispatcher("viewCars.jsp");
	        dispatcher.forward(request, response);
	    }
	

}
