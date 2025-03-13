<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Booking</title>
    <link rel="stylesheet" href="bookingstyles.css">
    <style>
        .form-container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        
        h2 {
            color: #333;
            text-align: center;
        }
        body {
                display: flex;
                justify-content: center;
                align-items: center;
                min-height: 100vh;
                background: url('images/background.jpg') no-repeat center center/cover;
                padding: 20px;
              }
        

        .form-section {
            margin-bottom: 20px;
            padding-bottom: 15px;
            border-bottom: 1px solid #ddd;
        }

        h3 {
            color: #333;
            margin-top: 10px;
        }

        .form-row {
            display: flex;
            flex-wrap: wrap;
            margin: 0 -10px;
        }

        .form-group {
            flex: 1;
            min-width: 200px;
            padding: 0 10px;
            margin-bottom: 15px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        input, select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        .error-message {
            color: red;
            margin-top: 10px;
        }
    </style>
</head>
<body>

    <h2>New Customer Booking</h2>

    <!-- Display error message if any -->
    <c:if test="${not empty error}">
        <div class="error-message">
            <strong>${error}</strong>
        </div>
    </c:if>

    <div class="form-container">
        <form action="addBooking" method="post">
            <div class="form-section">
                <h3>Booking Information</h3>
                <div class="form-row">
                    <div class="form-group">
                        <label for="bookingId">Order Number:</label>
                        <input type="text" id="bookingId" name="bookingId" required>
                    </div>
                </div>
            </div>

            <div class="form-section">
                <h3>Customer Details</h3>
                <div class="form-row">
                    <div class="form-group">
                        <label for="customerId">Customer ID:</label>
                        <input type="text" id="customerId" name="customerId" required>
                    </div>
                    <div class="form-group">
                        <label for="customerName">Customer Name:</label>
                        <input type="text" id="customerName" name="customerName" required>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group">
                        <label for="address">Address:</label>
                        <input type="text" id="address" name="address" required>
                    </div>
                    <div class="form-group">
                        <label for="phone">Telephone Number:</label>
                        <input type="text" id="phone" name="phone" required>
                    </div>
                </div>
            </div>

            <div class="form-section">
                <h3>Trip Details</h3>
                <div class="form-row">
                    <div class="form-group">
                        <label for="pickupLocation">Pickup Location:</label>
                        <input type="text" id="pickupLocation" name="pickupLocation" required>
                    </div>
                    <div class="form-group">
                        <label for="destination">Destination:</label>
                        <input type="text" id="destination" name="destination" required>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group">
                        <label for="carId">Car ID:</label>
                        <input type="text" id="carId" name="carId" required>
                    </div>
                    <div class="form-group">
                        <label for="driverId">Driver ID:</label>
                        <input type="text" id="driverId" name="driverId" required>
                    </div>
                </div>

                <div class="form-group">
                    <label for="status">Status:</label>
                    <select id="status" name="status" required>
                        <option value="pending">Pending</option>
                        <option value="confirmed">Confirmed</option>
                        <option value="in-progress">In Progress</option>
                        <option value="completed">Completed</option>
                        <option value="cancelled">Cancelled</option>
                    </select>
                </div>
            </div>

            <button type="submit">Create Booking</button>
        </form>
    </div>

    <p style="text-align: center; margin-top: 20px;">
        <a href="viewBookings.jsp">View All Bookings</a> |
        <a href="ViewCarsServlet">Back to Cars</a>
    </p>

    <script>
        // You can add client-side validation here if needed
    </script>
</body>
</html>
