package com.team13.RentaRide.model;

import java.time.LocalDate;
import java.util.Date;

public class BookedCar {
	
	protected Integer id;
	private Car car;
	private Client associatedClient;
	private LocalDate startDate;
	private LocalDate dueDate;
	private Date bookingTimestamp;
	
	

	public Date getBookingTimestamp() {
		return bookingTimestamp;
	}


	public void setBookingTimestamp(Date bookingTimestamp) {
		this.bookingTimestamp = bookingTimestamp;
	}


	public Car getCar() {
		return car;
	}

	
	public void setCar(Car car) {
		this.car = car;
	}


	public Client getAssociatedClient() {
		return associatedClient;
	}


	public void setAssociatedClient(Client associatedClient) {
		this.associatedClient = associatedClient;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public LocalDate getDueDate() {
		return dueDate;
	}


	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}


	public BookedCar(Car car, Client associatedClient, LocalDate startDate, LocalDate dueDate) {
		super();
		this.car = car;
		this.associatedClient = associatedClient;
		this.startDate = startDate;
		this.dueDate = dueDate;
	}

}
