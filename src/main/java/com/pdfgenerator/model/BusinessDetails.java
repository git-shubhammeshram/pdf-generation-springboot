package com.pdfgenerator.model;
import jakarta.persistence.Embeddable;

@Embeddable
public class BusinessDetails {

    private String businessName;
    private String address;
    private String contactNumber;

    // Getters and setters
    
    public BusinessDetails() {
		// TODO Auto-generated constructor stub
	}
    
    

	public BusinessDetails(String businessName, String address, String contactNumber) {
		super();
		this.businessName = businessName;
		this.address = address;
		this.contactNumber = contactNumber;
	}



	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
    
    
    
}
