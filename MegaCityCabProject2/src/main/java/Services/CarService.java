package Services;

import Models.Car;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarService {
	private static final String URL = "jdbc:mysql://localhost:3306/cab_booking_system?characterEncoding=utf8&serverTimezone=UTC&useSSL=false&verifyServerCertificate=false";
    private static final String USER = "root"; 
    private static final String PASSWORD = "123456789abcd"; 

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Add a new car
    public void addCar(Car car) {
        String query = "INSERT INTO cars (carId, model, registrationNumber, status) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, car.getCarId());
            stmt.setString(2, car.getModel());
            stmt.setString(3, car.getRegistrationNumber());
            stmt.setString(4, car.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all cars
    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        String query = "SELECT * FROM cars";

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                cars.add(new Car(
                        rs.getString("carId"),
                        rs.getString("model"),
                        rs.getString("registrationNumber"),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }


}
