package com.team13.RentaRide.model;

public class RentCar {
	private String licenseNumber;
	private String clientName;
	private String clientMobile;
	private String clientDriversLicence;
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientMobile() {
		return clientMobile;
	}
	public void setClientMobile(String clientMobile) {
		this.clientMobile = clientMobile;
	}
	public String getClientDriversLicence() {
		return clientDriversLicence;
	}
	public void setClientDriversLicence(String clientDriversLicence) {
		this.clientDriversLicence = clientDriversLicence;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RentCar [licenseNumber=");
		builder.append(licenseNumber);
		builder.append(", clientName=");
		builder.append(clientName);
		builder.append(", clientMobile=");
		builder.append(clientMobile);
		builder.append(", clientDriversLicence=");
		builder.append(clientDriversLicence);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
