package com.team13.RentaRide.model;

import java.math.BigDecimal;

public class RentedCar {
	
	private Car rentedCar;
	private Client carsClient;
	
	public RentedCar(Car rentedCar, Client carsClient) {
		super();
		this.rentedCar = rentedCar;
		this.carsClient = carsClient;
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
	
	@Override
	public String toString() {
		return "RentedCar [rentedCar=" + rentedCar + ", carsClient=" + carsClient + "]";
	}
	
	
}
	