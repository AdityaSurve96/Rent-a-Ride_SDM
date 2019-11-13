package com.team13.RentaRide.model;

import java.time.LocalDate;
import java.util.Date;

public class ReservedCar extends BookedCar {

	public ReservedCar(Car car, Client associatedClient, LocalDate startDate, LocalDate dueDate, Integer id,
			Date bookingTimestamp) {
		super(car, associatedClient, startDate, dueDate, id, bookingTimestamp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ReservedCar [id=" + id + ", getBookingTimestamp()=" + getBookingTimestamp() + ", getCar()=" + getCar()
				+ ", getAssociatedClient()=" + getAssociatedClient() + ", getStartDate()=" + getStartDate()
				+ ", getDueDate()=" + getDueDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
