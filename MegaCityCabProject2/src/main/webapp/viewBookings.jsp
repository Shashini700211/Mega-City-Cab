<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Bookings</title>
    <link rel="stylesheet" href="bookingstyles.css">
</head>
<body>
    <h2>All Bookings</h2>

    <c:if test="${not empty error}">
        <div class="error-message">
            <strong>${error}</strong>
        </div>
    </c:if>

    <c:if test="${empty bookings}">
        <p>No bookings available.</p>
    </c:if>

    <table border="1">
        <thead>
            <tr>
                <th>Booking ID</th>
                <th>Customer ID</th>
                <th>Pickup Location</th>
                <th>Destination</th>
                <th>Car ID</th>
                <th>Driver ID</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="booking" items="${bookings}">
                <tr>
                    <td>${booking.bookingId}</td>
                    <td>${booking.customerId}</td>
                    <td>${booking.pickupLocation}</td>
                    <td>${booking.destination}</td>
                    <td>${booking.carId}</td>
                    <td>${booking.driverId}</td>
                    <td>${booking.status}</td>
                    <td>
                        <a href="viewBookingDetails?id=${booking.bookingId}">View Details</a>
                    </td>
                </tr>
