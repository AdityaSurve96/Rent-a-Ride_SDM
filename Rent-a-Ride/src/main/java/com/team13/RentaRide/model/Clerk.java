package com.team13.RentaRide.model;

public class Clerk extends User{

	public Clerk(String email, String password) {
		super(email, password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Clerk [email=" + getEmail() + ", password=" + getPassword() + "]";
	}	
}
