package com.team13.RentaRide.model;

import java.util.ArrayList;

public class ClerksHolder {

	private static ClerksHolder ch;
	private static ArrayList<Clerk> clerkList ;

	private ClerksHolder() {
		clerkList= new ArrayList<Clerk>();
	}
	
	 public static ClerksHolder getInstance() {
		if(ch == null) {
			ch = new ClerksHolder();
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
