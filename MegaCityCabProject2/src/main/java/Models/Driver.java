package Models;

public class Driver {
	private String driverId;
    private String name;
    private String licenseNumber;
    private String phone;
    private String status;

    // Constructor
    public Driver(String driverId, String name, String licenseNumber, String phone, String status) {
        this.driverId = driverId;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.phone = phone;
        this.status = status;
    }

  
    public String getDriverId()
    { 
    	return driverId;
    }
    public String getName() 
    {
    	return name;
    }
    public String getLicenseNumber() 
    {
    	return licenseNumber;
    }
    public String getPhone() 
    {
    	return phone; 
    }
    public String getStatus() 
    {
    	return status;
    }

    
    public void setDriverId(String driverId) 
    {
    	this.driverId = driverId;
    }
    public void setName(String name)
    {
    	this.name = name;
    }
    public void setLicenseNumber(String licenseNumber) 
    {
    	this.licenseNumber = licenseNumber; 
    }
    public void setPhone(String phone) 
    {
    	this.phone = phone;
    }
    public void setStatus(String status) 
    {
    	this.status = status; 
    }


}
