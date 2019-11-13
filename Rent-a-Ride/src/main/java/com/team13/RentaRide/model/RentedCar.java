package com.team13.RentaRide.model;

import java.time.LocalDate;
import java.util.Date;

public class RentedCar extends BookedCar {

	public RentedCar(Integer id,Car car, Client associatedClient, LocalDate startDate, LocalDate dueDate, 
			Date bookingTimestamp) {
		super( id,car, associatedClient, startDate, dueDate, bookingTimestamp);
		// TODO Auto-generated constructor stub
	}

}
