package com.team13.RentaRide.model;

import java.math.BigDecimal;

public class RentedCar {
	
	private Car rentedCar;
	private Client carsClient;
	private String dueDate;
	public RentedCar(Car rentedCar, Client carsClient, String dueDate) {
		super();
		this.rentedCar = rentedCar;
		this.carsClient = carsClient;
		this.dueDate = dueDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
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
	