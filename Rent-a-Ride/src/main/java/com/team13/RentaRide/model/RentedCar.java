package com.team13.RentaRide.model;

import java.math.BigDecimal;
import java.util.Date;

public class RentedCar {
	
	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	private Car rentedCar;
	private Client carsClient;
	private Date dueDate;
	private String operation;
	public RentedCar(Car rentedCar, Client carsClient, Date dueDate) {
		
		super();
		this.rentedCar = rentedCar;
		this.carsClient = carsClient;
		this.dueDate = dueDate;
		
		
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Car getRentedCar() {
		return rentedCar;
	}

	public void setRentedCar(Car rentedCar) {
		this.rentedCar = rentedCar;
	}

	public Client getCarsClient() {
		return carsClient;
	}

	public void setCarsClient(Client carsClient) {
		this.carsClient = carsClient;
	}
	

	
	
}
	