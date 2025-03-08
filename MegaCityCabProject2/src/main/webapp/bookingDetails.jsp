<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
                            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                            <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
                            <!DOCTYPE html>
                            <html lang="en">
                            <head>
                                <meta charset="UTF-8">
                                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                                <title>Booking Details</title>
                                <link rel="stylesheet" href="bookingstyles.css">
                                <style>
                                    .details-container {
                                        max-width: 800px;
                                        margin: 0 auto;
                                        padding: 20px;
                                        background-color: #f9f9f9;
                                        border-radius: 8px;
                                        box-shadow: 0 0 10px rgba(0,0,0,0.1);
                                    }
                                    .section {
                                        margin-bottom: 20px;
                                        padding: 15px;
                                        background-color: white;
                                        border-radius: 5px;
                                        box-shadow: 0 2px 5px rgba(0,0,0,0.05);
                                    }
                                    .section h3 {
                                        margin-top: 0;
                                        border-bottom: 1px solid #eee;
                                        padding-bottom: 10px;
                                        color: #333;
                                    }
                                    .detail-row {
                                        display: flex;
                                        margin-bottom: 10px;
                                    }
                                    .detail-label {
                                        width: 40%;
                                        font-weight: bold;
                                    }
                                    .detail-value {
                                        width: 60%;
                                    }
                                    .actions {
                                        display: flex;
                                        justify-content: space-between;
                                        margin-top: 20px;
                                    }
                                    .actions a {
                                        padding: 10px 15px;
                                        background-color: #4CAF50;
                                        color: white;
                                        text-decoration: none;
                                        border-radius: 4px;
                                    }
                                    .actions a:hover {
                                        background-color: #45a049;
                                    }
                                    .total-amount {
                                        font-weight: bold;
                                        color: #d9534f;
                                        font-size: 1.1em;
                                    }
                                </style>
                            </head>
                            <body>
                                <%
                                // Check if user is logged in
                                if (session.getAttribute("user") == null) {
                                    response.sendRedirect("login");
                                    return;
                                }
                                %>

                                <h2>Booking Details</h2>

                                <div class="details-container">
                                    <div class="section">
                                        <h3>Booking Information</h3>
                                        <div class="detail-row">
                                            <div class="detail-label">Booking ID:</div>
                                            <div class="detail-value">${booking.bookingId}</div>
                                        </div>
                                        <div class="detail-row">
                                            <div class="detail-label">Booking Date:</div>
                                            <div class="detail-value">
                                                <fmt:formatDate value="${booking.bookingDate}" pattern="yyyy-MM-dd HH:mm:ss" />
                                            </div>
                                        </div>
                                        <div class="detail-row">
                                            <div class="detail-label">Status:</div>
                                            <div class="detail-value">${booking.status}</div>
                                        </div>
                                    </div>

                                    <div class="section">
                                        <h3>Customer Details</h3>
                                        <div class="detail-row">
                                            <div class="detail-label">Customer ID:</div>
                                            <div class="detail-value">${customer.customerId}</div>
                                        </div>
                                        <div class="detail-row">
                                            <div class="detail-label">Name:</div>
                                            <div class="detail-value">${customer.name}</div>
                                        </div>
                                        <div class="detail-row">
                                            <div class="detail-label">Phone:</div>
                                            <div class="detail-value">${customer.phone}</div>
                                        </div>
                                    </div>

                                    <div class="section">
                                        <h3>Trip Details</h3>
                                        <div class="detail-row">
                                            <div class="detail-label">Pickup Location:</div>
                                            <div class="detail-value">${booking.pickupLocation}</div>
                                        </div>
                                        <div class="detail-row">
                                            <div class="detail-label">Destination:</div>
                                            <div class="detail-value">${booking.destination}</div>
                                        </div>
                                        <div class="detail-row">
                                            <div class="detail-label">Car ID:</div>
                                            <div class="detail-value">${booking.carId}</div>
                                        </div>
                                        <div class="detail-row">
                                            <div class="detail-label">Driver ID:</div>
                                            <div class="detail-value">${booking.driverId}</div>
                                        </div>
                                    </div>

                                    <div class="section">
                                        <h3>Billing Details</h3>
                                        <div class="detail-row">
                                            <div class="detail-label">Distance:</div>
                                            <div class="detail-value">${booking.distance} km</div>
                                        </div>
                                        <div class="detail-row">
                                            <div class="detail-label">Base Fare:</div>
                                            <div class="detail-value">Rs. ${booking.baseFare}</div>
                                        </div>
                                        <div class="detail-row">
                                            <div class="detail-label">Taxes:</div>
                                            <div class="detail-value">Rs. ${booking.taxes}</div>
                                        </div>
                                        <div class="detail-row">
                                            <div class="detail-label">Discounts:</div>
                                            <div class="detail-value">- Rs. ${booking.discounts}</div>
                                        </div>
                                        <div class="detail-row">
                                            <div class="detail-label">Total Amount:</div>
                                            <div class="detail-value total-amount">Rs. ${booking.totalAmount}</div>
                                        </div>
                                    </div>

                                    <div class="actions">
                                        <a href="viewBookings">Back to Bookings</a>
                                        <a href="printBill?id=${booking.bookingId}" target="_blank">Print Bill</a>
                                    </div>
                                </div>
                            </body>
                            </html>
