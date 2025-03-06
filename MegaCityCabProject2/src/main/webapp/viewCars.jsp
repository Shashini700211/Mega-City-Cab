<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>View Cars</title>
    <link rel="stylesheet" type="text/css" href="css/viewCarsstyles.css">
</head>

<body>

    <h1>Car List</h1>
    
    <table border="1">
        <thead>
            <tr>
                <th>Car ID</th>
                <th>Model</th>
                <th>Registration Number</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="car" items="${cars}">
                <tr>
                    <td>${car.carId}</td>
                    <td>${car.model}</td>
                    <td>${car.registrationNumber}</td>
                    <td>${car.status}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
