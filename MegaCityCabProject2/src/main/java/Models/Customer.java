package Models;

public class Customer {
	private String customerId;
    private String name;
    private String address;
    private String nic;
    private String phone;
    private String email;

    // Constructor
    public Customer(String customerId, String name, String address, String nic, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.nic = nic;
        this.phone = phone;
    }
    
    // Constructor with email
    public Customer(String customerId, String name, String address, String nic, String phone, String email) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.nic = nic;
        this.phone = phone;
        this.email = email;
    }

    // Existing getters
    public String getCustomerId() 
    {
    	return customerId; 
    }
    public String getName() 
    { 
    	return name; 
    }
    public String getAddress() 
    { 
    	return address; 
    }
    public String getNic() 
    {
    	return nic; 
    }
    public String getPhone() 
    { 
    	return phone; 
    }
    
    // New getter for email
    public String getEmail()
    {
        return email;
    }

    // Existing setters
    public void setCustomerId(String customerId)  
    { 
    	this.customerId = customerId; 
    }
    public void setName(String name) 
    { 
    	this.name = name;
    }
    public void setAddress(String address) 
    { 
    	this.address = address; 
    }
    public void setNic(String nic) 
    { 
    	this.nic = nic;
    }
    public void setPhone(String phone) 
    { 
    	this.phone = phone; 
    }
    
    // New setter for email
    public void setEmail(String email)
    {
        this.email = email;
    }
}
