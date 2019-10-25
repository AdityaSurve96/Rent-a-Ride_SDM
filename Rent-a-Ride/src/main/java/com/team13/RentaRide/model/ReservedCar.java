package com.team13.RentaRide.model;

import java.time.LocalDate;

public class ReservedCar extends BookedCar{

	public ReservedCar(Car car, Client associatedClient, LocalDate startDate, LocalDate dueDate) {
		super(car, associatedClient, startDate, dueDate);
		// TODO Auto-generated constructor stub
	}

}
