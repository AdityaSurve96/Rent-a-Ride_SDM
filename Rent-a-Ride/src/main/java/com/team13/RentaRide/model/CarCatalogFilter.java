package com.team13.RentaRide.model;

public class CarCatalogFilter {

	private String model;
	private String type;
	private String make;
	private String year;
	private String color;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CarCatalogFilter [model=");
		builder.append(model);
		builder.append(", type=");
		builder.append(type);
		builder.append(", make=");
		builder.append(make);
		builder.append(", year=");
		builder.append(year);
		builder.append(", color=");
		builder.append(color);
		builder.append("]");
		return builder.toString();
	}

}
