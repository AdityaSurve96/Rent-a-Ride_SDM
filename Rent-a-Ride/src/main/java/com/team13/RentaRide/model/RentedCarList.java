package com.team13.RentaRide.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class RentedCarList {

    private static RentedCarList instance;
    private static List<RentedCar> rentedCarList ;
    private RentedCarList() {
    	rentedCarList = new ArrayList<RentedCar>();
    }

    public static RentedCarList getInstance(){
        if(instance == null)
            instance = new RentedCarList();
        return instance;
    }
    
    public void addRentals(Car c, Client cl , LocalDate dueDate) {
    	LocalDate currentDate = LocalDate.now();
    	System.out.println(currentDate);
		String cancelReturn = ((dueDate).isBefore(currentDate)) ? "RETURN" : "CANCEL" ;
    	
		RentedCar rc = new RentedCar(c, cl, dueDate);
		rc.setOperation(cancelReturn);
		rentedCarList.add(rc);
		
	}

	public List<RentedCar> getRentals(){

		return rentedCarList;
	}


	
}
