package com.team13.RentaRide.model;

public class Client {
	
	private String driverLicence;
	private String firstName;
	private String lastName;
	private int mobile;
	private int licenceExpiryDate;
	private String emailID;
	
	
	
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
	
	
	public String getLicenceNumber() {
		return driverLicence;
	}
	public void setLicenceNumber(String driverlicence) {
		this.driverLicence = driverlicence;
	}
	
	public int getmobile() {
		return mobile;
	}
	public void setmobile(int mobile) {
		this.mobile = mobile;
	}
	public int getLicenceExpiryDate() {
		return licenceExpiryDate;
	}
	public void setLicenceExpiryDate(int licenceExpiryDate) {
		this.licenceExpiryDate = licenceExpiryDate;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Client [driverlicence=");
		builder.append(driverLicence);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", mobile=");
		builder.append(mobile);
		builder.append(", licenceExpiryDate=");
		builder.append(licenceExpiryDate);
		builder.append(", emailID=");
		builder.append(emailID);
		builder.append("]");
		return builder.toString();
	}
}
