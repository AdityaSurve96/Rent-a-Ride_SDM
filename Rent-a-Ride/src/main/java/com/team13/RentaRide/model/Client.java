package com.team13.RentaRide.model;

public class Client {
	
	private String driverLicenceNumber;
	private String clientFirstName;
	private String clientLastName;
	private String driverLicenseNumber;
	private String clientName;
	private Integer phoneNumber;
	private Integer licenceExpiryDate;
	private String emailID;
	
	
	
	
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
	public String getDriverLicenseNumber() {
		return driverLicenseNumber;
	}
	public void setDriverLicenseNumber(String driverLicenseNumber) {
		this.driverLicenseNumber = driverLicenseNumber;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getLicenceExpiryDate() {
		return licenceExpiryDate;
	}
	public void setLicenceExpiryDate(Integer licenceExpiryDate) {
		this.licenceExpiryDate = licenceExpiryDate;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public Client(String driverLicenceNumber, String clientFirstName, String clientLastName, Integer phoneNumber,
			Integer licenceExpiryDate, String emailID) {
		super();
		this.driverLicenceNumber = driverLicenceNumber;
		this.clientFirstName = clientFirstName;
		this.clientLastName = clientLastName;
		this.phoneNumber = phoneNumber;
		this.licenceExpiryDate = licenceExpiryDate;
		this.emailID = emailID;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Client [licenceNumber=");
		builder.append(driverLicenseNumber);
		builder.append(", clientName=");
		builder.append(clientName);
		builder.append(", phoneNumber=");
		builder.append(phoneNumber);
		builder.append(", licenceExpiryDate=");
		builder.append(licenceExpiryDate);
		builder.append(", emailID=");
		builder.append(emailID);
		builder.append("]");
		return builder.toString();

	}

}
