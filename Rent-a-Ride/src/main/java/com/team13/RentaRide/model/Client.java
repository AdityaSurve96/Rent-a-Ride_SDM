package com.team13.RentaRide.model;

import java.time.LocalDate;

public class Client {
	
	protected Integer client_id;
	
	private String driverLicenceNumber;
	private String clientFirstName;
	private String clientLastName;
	private String phoneNumber;
	private LocalDate licenceExpiryDate;
	
	public Integer getId() {
		return client_id;
	}
	public void setId(Integer client_id) {
		this.client_id = client_id;
	}
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
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public LocalDate getLicenceExpiryDate() {
		return licenceExpiryDate;
	}
	public void setLicenceExpiryDate(LocalDate licenceExpiryDate) {
		this.licenceExpiryDate = licenceExpiryDate;
	}

	


}
