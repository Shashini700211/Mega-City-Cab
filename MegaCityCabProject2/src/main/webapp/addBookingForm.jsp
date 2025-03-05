<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Booking</title>
    <link rel="stylesheet" href="bookingstyles.css">
</head>
<body>
    <h2>Add New Booking</h2>

    <!-- Display error message if any -->
    <c:if test="${not empty error}">
        <div style="color: red;">
            <strong>${error}</strong>
        </div>
    </c:if>

    <form action="addBooking" method="post">
        <label for="bookingId">Booking ID:</label>
        <input type="text" id="bookingId" name="bookingId" required><br><br>

        <label for="customerId">Customer ID:</label>
        <input type="text" id="customerId" name="customerId" required><br><br>

        <label for="pickupLocation">Pickup Location:</label>
        <input type="text" id="pickupLocation" name="pickupLocation" required><br><br>

        <label for="destination">Destination:</label>
        <input type="text" id="destination" name="destination" required><br><br>

        <label for="carId">Car ID:</label>
        <input type="text" id="carId" name="carId" required><br><br>

        <label for="driverId">Driver ID:</label>
        <input type="text" id="driverId" name="driverId" required><br><br>

        <label for="status">Status:</label>
        <select id="status" name="status" required>
            <option value="pending">Pending</option>
            <option value="completed">Completed</option>
        </select><br><br>

        <button type="submit">Add Booking</button>
    </form>

    <a href="viewBookings.jsp">View Bookings</a>
</body>
</html>
