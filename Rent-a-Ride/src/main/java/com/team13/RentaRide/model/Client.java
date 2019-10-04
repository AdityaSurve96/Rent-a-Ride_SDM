package com.team13.RentaRide.model;

public class Client {
	
	private String licenceNumber;
	private String clientName;
	private int phoneNumber;
	private int licenceExpiryDate;
	private String emailID;
	public String getLicenceNumber() {
		return licenceNumber;
	}
	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Client [licenceNumber=");
		builder.append(licenceNumber);
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
