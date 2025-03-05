package Models;

public class Booking {
    private String bookingId;
    private String customerId;
    private String pickupLocation;
    private String destination;
    private String carId;
    private String driverId;
    private String status;

    // Constructor
    public Booking(String bookingId, String customerId, String pickupLocation, String destination, String carId, String driverId, String status)
{
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.pickupLocation = pickupLocation;
        this.destination = destination;
        this.carId = carId;
        this.driverId = driverId;
        this.status = status;
    }

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
    
    
}
