<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>View Customers</title>
    <link rel="stylesheet" type="text/css" href="css/viewCustomersstyles.css">
</head>
<body>
    <h1>Customer List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Customer ID</th>
                <th>Name</th>
                <th>Address</th>
                <th>NIC</th>
                <th>Phone</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="customer" items="${customers}">
                <tr>
                    <td>${customer.customerId}</td>
                    <td>${customer.name}</td>
                    <td>${customer.address}</td>
                    <td>${customer.nic}</td>
                    <td>${customer.phone}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
