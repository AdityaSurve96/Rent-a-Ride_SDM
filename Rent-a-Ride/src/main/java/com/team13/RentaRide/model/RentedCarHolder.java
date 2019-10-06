package com.team13.RentaRide.model;

import java.util.ArrayList;

public final class RentedCarHolder {

    private static RentedCarHolder instance;
    private static ArrayList<RentedCar> rentedCarList ;
    private RentedCarHolder() {
    	rentedCarList = new ArrayList<RentedCar>();
    }

    public static RentedCarHolder getInstance(){
        if(instance == null)
            instance = new RentedCarHolder();
        return instance;
    }
    
    public void addRentals(Car c, Client cl) {
		
		RentedCar rc = new RentedCar(c, cl);
		rentedCarList.add(rc);
		
	}

	public ArrayList<RentedCar> getRentals(){

		return rentedCarList;
	}


	
}
