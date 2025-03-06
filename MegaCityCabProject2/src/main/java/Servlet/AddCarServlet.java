package Servlet;

import Services.CarService;
import Models.Car;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;


public class AddCarServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
    
    private CarService carService = new CarService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String carId = request.getParameter("carId");
        String model = request.getParameter("model");
        String registrationNumber = request.getParameter("registrationNumber");
        String status = request.getParameter("status");

        Car car = new Car(carId, model, registrationNumber, status);
        carService.addCar(car);
        
        response.sendRedirect("viewCars.jsp");  // Redirect to view cars page after adding
    }


}
