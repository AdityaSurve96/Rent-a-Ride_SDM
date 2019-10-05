package com.team13.RentaRide.model;

public class RentCar {
	private String carLicenceNumber;
	private String clientFirstName;
	private String clientLastName;
	private String clientMobile;
	private String clientDriversLicence;
	private Integer licenceExpiryDate;
	
	public String getCarLicenceNumber() {
		return carLicenceNumber;
	}

	public void setCarLicenceNumber(String carLicenceNumber) {
		this.carLicenceNumber = carLicenceNumber;
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

	public Integer getLicenceExpiryDate() {
		return licenceExpiryDate;
	}

	public void setLicenceExpiryDate(Integer licenceExpiryDate) {
		this.licenceExpiryDate = licenceExpiryDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RentCar [carLicenceNumber=");
		builder.append(carLicenceNumber);
		builder.append(", clientFirstName=");
		builder.append(clientFirstName);
		builder.append(", clientLastName=");
		builder.append(clientLastName);
		builder.append(", clientMobile=");
		builder.append(clientMobile);
		builder.append(", clientDriversLicence=");
		builder.append(clientDriversLicence);
		builder.append("]");
		return builder.toString();
	}
}
