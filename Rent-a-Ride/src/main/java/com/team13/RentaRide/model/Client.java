package com.team13.RentaRide.model;

public class Client {
	
	private String driverLicenceNumber;
	private String clientFirstName;
	private String clientLastName;
	private int phoneNumber;
	private int licenceExpiryDate;
	private String emailID;
	
	public String getdriverLicenceNumber() {
		return driverLicenceNumber;
	}
	public void setLicenceNumber(String licenceNumber) {
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
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	public Client(String driverLicenceNumber, String clientFirstName, String clientLastName, int phoneNumber,
			int licenceExpiryDate, String emailID) {
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
		return "Client [driverLicenceNumber=" + driverLicenceNumber + ", clientFirstName=" + clientFirstName
				+ ", clientLastName=" + clientLastName + ", phoneNumber=" + phoneNumber + ", licenceExpiryDate="
				+ licenceExpiryDate + ", emailID=" + emailID + "]";
	}

}
