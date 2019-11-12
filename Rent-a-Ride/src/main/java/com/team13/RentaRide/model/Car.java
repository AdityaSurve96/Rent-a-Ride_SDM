package com.team13.RentaRide.model;

import java.math.BigDecimal;

public class Car {

	protected Integer id;
	private String licensePlateNumber;

	private String make;
	private String model;
	private String type;
	private String color;
	private Integer year;
	private String description;
	private BigDecimal price;
	private String availableReservedOrRented;


	public String getAvailableReservedOrRented() {
		return availableReservedOrRented;
	}

	public void setAvailableReservedOrRented(String availableReservedOrRented) {
		this.availableReservedOrRented = availableReservedOrRented;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getLicensePlateNumber() {
		return licensePlateNumber;
	}

	public void setLicensePlateNumber(String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [make=" + make + ", model=" + model + ", type=" + type + ", licenseNumber=" + licensePlateNumber
				+ ", color=" + color + ", description=" + description + ", price=" + price + ", year=" + year + "]";
	}

}
