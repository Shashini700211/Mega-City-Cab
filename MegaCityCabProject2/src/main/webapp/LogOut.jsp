<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="javax.servlet.*" %>

<%
    // Destroy the session
    if (session != null) {
        session.invalidate();
    }

    // Redirect to the main menu (index.jsp)
    response.sendRedirect("index.jsp");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Logging Out...</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin: 50px;
        }
        .message {
            font-size: 20px;
            color: #333;
        }
    </style>
</head>
<body>
    <p class="message">Logging out... Redirecting to the main menu.</p>
</body>
</html>
