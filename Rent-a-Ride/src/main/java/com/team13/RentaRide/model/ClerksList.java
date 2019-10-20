package com.team13.RentaRide.model;

import java.util.ArrayList;

public class ClerksList {

	private static ClerksList ch;
	private static ArrayList<Clerk> clerkList ;

	private ClerksList() {
		clerkList= new ArrayList<Clerk>();
	}
	
	 public static ClerksList getInstance() {
		if(ch == null) {
			ch = new ClerksList();
		}
		return ch;
	}
	 
	 
	public void addClerks(String email, String password) {
		
		Clerk c = new Clerk(email, password);
		
		clerkList.add(c);
	}

	public ArrayList<Clerk> getRegisteredClerks(){

		return clerkList;
	}


}
