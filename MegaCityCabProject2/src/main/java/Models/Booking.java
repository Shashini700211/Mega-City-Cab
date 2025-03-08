package Models;

import java.sql.Timestamp;

public class Booking {
    private String bookingId;
    private String customerId;
    private String pickupLocation;
    private String destination;
    private String carId;
    private String driverId;
    private String status;
    private Timestamp bookingDate;
    private double distance;
    private double baseFare;
    private double taxes;
    private double discounts;
    private double totalAmount;

    // Constructor
    public Booking(String bookingId, String customerId, String pickupLocation, String destination, String carId, String driverId, String status) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.pickupLocation = pickupLocation;
        this.destination = destination;
        this.carId = carId;
        this.driverId = driverId;
        this.status = status;
    }
    
    // Full constructor with billing details
    public Booking(String bookingId, String customerId, String pickupLocation, String destination, String carId, 
                   String driverId, String status, Timestamp bookingDate, double distance, double baseFare, 
                   double taxes, double discounts, double totalAmount) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.pickupLocation = pickupLocation;
        this.destination = destination;
        this.carId = carId;
        this.driverId = driverId;
        this.status = status;
        this.bookingDate = bookingDate;
        this.distance = distance;
        this.baseFare = baseFare;
        this.taxes = taxes;
        this.discounts = discounts;
        this.totalAmount = totalAmount;
    }

    // Existing getters
    public String getBookingId() 
    {
    	return bookingId;
    }
    public String getCustomerId()
    {
    	return customerId; 
    }
    public String getPickupLocation() 
    { 
    	return pickupLocation; 
    }
    public String getDestination() 
    { 
    	return destination;
    }
    public String getCarId() 
    {
    	return carId; 
    }
    public String getDriverId() 
    { 
    	return driverId; 
    }
    public String getStatus() 
    { 
    	return status; 
    }
    
    // New getters for billing
    public Timestamp getBookingDate() {
        return bookingDate;
    }
    
    public double getDistance() {
        return distance;
    }
    
    public double getBaseFare() {
        return baseFare;
    }
    
    public double getTaxes() {
        return taxes;
    }
    
    public double getDiscounts() {
        return discounts;
    }
    
    public double getTotalAmount() {
        return totalAmount;
    }

    // Existing setters
    public void setBookingId(String bookingId)
    { 
    	this.bookingId = bookingId; 
    }
    public void setCustomerId(String customerId) 
    { 
    	this.customerId = customerId; 
    }
    public void setPickupLocation(String pickupLocation) 
    { 
    	this.pickupLocation = pickupLocation; 
    }
    public void setDestination(String destination) 
    { 
    	this.destination = destination; 
    }
    public void setCarId(String carId) 
    { 
    	this.carId = carId; 
    }
    public void setDriverId(String driverId) 
    { 
    	this.driverId = driverId; 
    }
    public void setStatus(String status) 
    { 
    	this.status = status; 
    }
    
    // New setters for billing
    public void setBookingDate(Timestamp bookingDate) {
        this.bookingDate = bookingDate;
    }
    
    public void setDistance(double distance) {
        this.distance = distance;
    }
    
    public void setBaseFare(double baseFare) {
        this.baseFare = baseFare;
    }
    
    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }
    
    public void setDiscounts(double discounts) {
        this.discounts = discounts;
    }
    
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    // Calculate total fare
    public void calculateTotalFare() {
        this.totalAmount = this.baseFare + this.taxes - this.discounts;
    }
}

