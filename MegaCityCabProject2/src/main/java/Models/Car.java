package Models;

public class Car {
	private String carId;
    private String model;
    private String registrationNumber;
    private String status;

    // Constructor
    public Car(String carId, String model, String registrationNumber, String status) {
        this.carId = carId;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.status = status;
    }

    
    public String getCarId() 
    { 
    	return carId; 
    }
    public String getModel() 
    { 
    	return model; 
    }
    public String getRegistrationNumber() 
    { 
    	return registrationNumber; 
    }
    public String getStatus() 
    { 
    	return status; 
    }

    
    public void setCarId(String carId) 
    { 
    	this.carId = carId; 
    }
    public void setModel(String model) 
    { 
    	this.model = model;
    }
    public void setRegistrationNumber(String registrationNumber) 
    {
    	this.registrationNumber = registrationNumber; 
    }
    public void setStatus(String status) 
    { 
    	this.status = status; 
    }


}
