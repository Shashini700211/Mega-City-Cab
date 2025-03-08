<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>View Drivers</title>
</head>
<body>
    <h1>Driver List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Driver ID</th>
                <th>Name</th>
                <th>License Number</th>
                <th>Phone</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="driver" items="${drivers}">
                <tr>
                    <td>${driver.driverId}</td>
                    <td>${driver.name}</td>
                    <td>${driver.licenseNumber}</td>
                    <td>${driver.phone}</td>
                    <td>${driver.status}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
