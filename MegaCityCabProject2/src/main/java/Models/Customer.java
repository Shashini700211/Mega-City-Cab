package Models;

public class Customer {
	private String customerId;
    private String name;
    private String address;
    private String nic;
    private String phone;

    // Constructor
    public Customer(String customerId, String name, String address, String nic, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.nic = nic;
        this.phone = phone;
    }

    
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


}
