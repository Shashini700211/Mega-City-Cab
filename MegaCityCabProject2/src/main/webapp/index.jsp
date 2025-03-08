<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MegaCity Cab Service</title>
    <meta http-equiv="refresh" content="0; url=${pageContext.request.session.getAttribute('user') != null ? 'viewCars.jsp' : 'Login.jsp'}">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
            padding-top: 100px;
        }
        .loader {
            border: 5px solid #f3f3f3;
            border-top: 5px solid #3498db;
            border-radius: 50%;
            width: 50px;
            height: 50px;
            animation: spin 1s linear infinite;
            margin: 20px auto;
        }
        @keyframes spin {
            0% { transform: rotate(0deg); }
            100% { transform: rotate(360deg); }
        }
    </style>
</head>
<body>
    <h2>Welcome to MegaCity Cab Service</h2>
    <p>Redirecting you to the appropriate page...</p>
    <div class="loader"></div>
    
    <script>
        // Backup JavaScript redirect in case the meta refresh doesn't work
        window.onload = function() {
            <% if(session.getAttribute("user") != null) { %>
                window.location.href = "viewCars.jsp";
            <% } else { %>
                window.location.href = "Login.jsp";
            <% } %>
        }
    </script>
</body>
</html>