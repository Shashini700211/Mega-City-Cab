<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
                                        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                                        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
                                        <!DOCTYPE html>
                                        <html lang="en">
                                        <head>
                                            <meta charset="UTF-8">
                                            <meta name="viewport" content="width=device-width, initial-scale=1.0">
                                            <title>Booking Details - MegaCity Cab Service</title>
                                            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
                                            <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
                                            <style>
                                                * {
                                                    margin: 0;
                                                    padding: 0;
                                                    box-sizing: border-box;
                                                    font-family: 'Poppins', sans-serif;
                                                }

                                                body {
                                                    display: flex;
                                                    justify-content: center;
                                                    align-items: center;
                                                    min-height: 100vh;
                                                    background: url('images/background.jpg') no-repeat center center/cover;
                                                    padding: 20px;
                                                }

                                                .details-container {
                                                    background: rgba(255, 255, 255, 0.15);
                                                    backdrop-filter: blur(10px);
                                                    border-radius: 15px;
                                                    padding: 30px;
                                                    width: 800px;
                                                    box-shadow: 0px 4px 20px rgba(0, 0, 0, 0.2);
                                                }

                                                h2 {
                                                    text-align: center;
                                                    font-size: 28px;
                                                    font-weight: 600;
                                                    color: #333;
                                                    margin-bottom: 20px;
                                                }

                                                .section {
                                                    margin-bottom: 20px;
                                                    padding: 20px;
                                                    background: rgba(255, 255, 255, 0.3);
                                                    border-radius: 8px;
                                                    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.08);
                                                }

                                                .section h3 {
                                                    margin-top: 0;
                                                    border-bottom: 1px solid rgba(255, 255, 255, 0.4);
                                                    padding-bottom: 10px;
                                                    color: #333;
                                                    font-weight: 600;
                                                    display: flex;
                                                    align-items: center;
                                                }

                                                .section h3 i {
                                                    margin-right: 10px;
                                                    color: #ff4b2b;
                                                }

                                                .detail-row {
                                                    display: flex;
                                                    margin-bottom: 15px;
                                                }

                                                .detail-label {
                                                    width: 40%;
                                                    font-weight: bold;
                                                    color: #333;
                                                }

                                                .detail-value {
                                                    width: 60%;
                                                    color: #333;
                                                }

                                                .actions {
                                                    display: flex;
                                                    justify-content: space-between;
                                                    margin-top: 25px;
                                                }

                                                .actions a {
                                                    padding: 12px 20px;
                                                    background: linear-gradient(to right, grey, #ff4b2b);
                                                    color: white;
                                                    text-decoration: none;
                                                    border-radius: 8px;
                                                    font-weight: 500;
                                                    transition: 0.3s;
                                                    text-align: center;
                                                }

                                                .actions a:hover {
                                                    background: linear-gradient(to right, #ff4b2b, #ff416c);
                                                    transform: translateY(-2px);
                                                }

                                                .total-amount {
                                                    font-weight: bold;
                                                    color: #ff4b2b;
                                                    font-size: 1.2em;
                                                }
                                            </style>
                                        </head>
                                        <body>
                                            
                                            <div class="details-container">
                                                <h2>Booking Details</h2>

                                                <div class="section">
                                                    <h3><i class="fas fa-ticket-alt"></i> Booking Information</h3>
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
                                                    <h3><i class="fas fa-user"></i> Customer Details</h3>
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
                                                    <h3><i class="fas fa-route"></i> Trip Details</h3>
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
                                                    <h3><i class="fas fa-file-invoice-dollar"></i> Billing Details</h3>
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
                                                    <a href="viewBookings"><i class="fas fa-arrow-left"></i> Back to Bookings</a>
                                                    <a href="printBill?id=${booking.bookingId}"><i class="fas fa-print"></i> Print Bill</a>
                                                </div>
                                            </div>
                                        </body>
                                        </html>
