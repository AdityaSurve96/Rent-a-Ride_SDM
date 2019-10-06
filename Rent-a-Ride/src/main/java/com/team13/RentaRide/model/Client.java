package com.team13.RentaRide.model;


public class Client {
	
	private String driverLicenceNumber;
	private String clientFirstName;
	private String clientLastName;
	private Integer phoneNumber;
	private String licenceExpiryDate;
	
	
	
	
	
	public String getDriverLicenceNumber() {
		return driverLicenceNumber;
	}
	public void setDriverLicenceNumber(String driverLicenceNumber) {
		this.driverLicenceNumber = driverLicenceNumber;
	}
	public String getClientFirstName() {
		return clientFirstName;
	}
	public void setClientFirstName(String clientFirstName) {
		this.clientFirstName = clientFirstName;
	}
	public String getClientLastName() {
		return clientLastName;
	}
	public void setClientLastName(String clientLastName) {
		this.clientLastName = clientLastName;
	}
	
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getLicenceExpiryDate() {
		return licenceExpiryDate;
	}
	public void setLicenceExpiryDate(String licenceExpiryDate) {
		this.licenceExpiryDate = licenceExpiryDate;
	}

	public Client(String driverLicenceNumber, String clientFirstName, String clientLastName, Integer phoneNumber,
			String licenceExpiryDate) {
		super();
		this.driverLicenceNumber = driverLicenceNumber;
		this.clientFirstName = clientFirstName;
		this.clientLastName = clientLastName;
		this.phoneNumber = phoneNumber;
		this.licenceExpiryDate = licenceExpiryDate;
	
	}


}
