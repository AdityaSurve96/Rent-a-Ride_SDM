package com.team13.RentaRide.model;

import java.time.LocalDate;
import java.util.Date;

public class RentedCar extends BookedCar {

	public RentedCar(Car car, Client associatedClient, LocalDate startDate, LocalDate dueDate, Integer id,
			Date bookingTimestamp) {
		super(car, associatedClient, startDate, dueDate, id, bookingTimestamp);
		// TODO Auto-generated constructor stub
	}

}
