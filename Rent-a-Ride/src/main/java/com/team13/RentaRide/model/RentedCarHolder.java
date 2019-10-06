package com.team13.RentaRide.model;

import java.util.ArrayList;
import java.util.List;

public final class RentedCarHolder {

    private static RentedCarHolder instance;
    private static List<RentedCar> rentedCarList ;
    private RentedCarHolder() {
    	rentedCarList = new ArrayList<RentedCar>();
    }

    public static RentedCarHolder getInstance(){
        if(instance == null)
            instance = new RentedCarHolder();
        return instance;
    }
    
    public void addRentals(Car c, Client cl , String dueDate) {
		
		RentedCar rc = new RentedCar(c, cl, dueDate);
		rentedCarList.add(rc);
		
	}

	public List<RentedCar> getRentals(){

		return rentedCarList;
	}


	
}
