package com.team13.RentaRide.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.team13.RentaRide.model.Car;
import com.team13.RentaRide.model.Client;
import com.team13.RentaRide.model.RentedCar;
import com.team13.RentaRide.model.RentedCarList;

public final class DataStore {
	
	
    private static DataStore instance;
    private static List<Car> carList ;
    private DataStore() {
    	carList = new ArrayList<Car>();
    	Car c1 = new Car();
		c1.setAvailable(true);
		c1.setColor("Red");
		c1.setDescription("Newly renovated and refurbished");
		c1.setLicensePlateNumber("E07 FFN");
		c1.setMake("Volvo");
		c1.setModel("D6");
		c1.setPrice(BigDecimal.valueOf(25.55d));
		c1.setType("Sedan");
		c1.setYear(2011);
		c1.setAvailableToRentOrNot(c1.isAvailable());
	
		// CAR 2
		Car c2 = new Car();
		c2.setAvailable(true);
		c2.setColor("Blue");
		c2.setDescription("Good for a mountain trip");
		c2.setLicensePlateNumber("T57 335");
		c2.setMake("BMW");
		c2.setModel("X6");
		c2.setPrice(BigDecimal.valueOf(55.55d));
		c2.setType("SUV");
		c2.setYear(2009);
		c2.setAvailableToRentOrNot(c2.isAvailable());
	
		// CAR 3
		Car c3 = new Car();
		c3.setAvailable(true);
		c3.setColor("Black");
		c3.setDescription("Good for a long weekend");
		c3.setLicensePlateNumber("C66 478");
		c3.setMake("BMW");
		c3.setModel("X3");
		c3.setPrice(BigDecimal.valueOf(25.90d));
		c3.setType("SUV");
		c3.setYear(2010);
		c3.setAvailableToRentOrNot(c3.isAvailable());
		
		// CAR 4
		Car c4 = new Car();
		c4.setAvailable(true);
		c4.setColor("White");
		c4.setDescription("Perfect for a backpacking trip");
		c4.setLicensePlateNumber("A44 223");
		c4.setMake("Chevrolet");
		c4.setModel("Cruze");
		c4.setPrice(BigDecimal.valueOf(34.5d));
		c4.setType("SUV");
		c4.setYear(2017);
		c4.setAvailableToRentOrNot(c4.isAvailable());
		
		// CAR 5
		Car c5 = new Car();
		c5.setAvailable(true);
		c5.setColor("Green");
		c5.setDescription("Available with Infant car seat");
		c5.setLicensePlateNumber("F55 604");
		c5.setMake("Mitsubishi");
		c5.setModel("Mirage");
		c5.setPrice(BigDecimal.valueOf(19.12d));
		c5.setType("SUV");
		c5.setYear(2012);
		c5.setAvailableToRentOrNot(c5.isAvailable());
		
		carList.add(c1);
		carList.add(c2);
		carList.add(c3);
		carList.add(c4);
		carList.add(c5);
    }

    public static DataStore getInstance(){
        if(instance == null)
            instance = new DataStore();
        return instance;
    }

	public List<Car> getAllCars(){

		return carList;
	}

	
	
	
	
	
	
	
	
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public static List<Car> getAllCars() { List<Car> cars = new ArrayList<>();
	 * 
	 * // CAR 1 Car c1 = new Car(); c1.setAvailable(true); c1.setColor("Red");
	 * c1.setDescription("Newly renovated and refurbished");
	 * c1.setLicensePlateNumber("E07 FFN"); c1.setMake("Volvo"); c1.setModel("D6");
	 * c1.setPrice(BigDecimal.valueOf(25.55d)); c1.setType("Sedan");
	 * c1.setYear(2011); c1.setAvailableToRentOrNot(c1.isAvailable());
	 * 
	 * // CAR 2 Car c2 = new Car(); c2.setAvailable(false); c2.setColor("Blue");
	 * c2.setDescription("Good for a mountain trip");
	 * c2.setLicensePlateNumber("T57 335"); c2.setMake("BMW"); c2.setModel("X6");
	 * c2.setPrice(BigDecimal.valueOf(55.55d)); c2.setType("SUV"); c2.setYear(2009);
	 * c2.setAvailableToRentOrNot(c2.isAvailable());
	 * 
	 * // CAR 3 Car c3 = new Car(); c3.setAvailable(true); c3.setColor("Black");
	 * c3.setDescription("Good for a long weekend");
	 * c3.setLicensePlateNumber("C66 478"); c3.setMake("BMW"); c3.setModel("X3");
	 * c3.setPrice(BigDecimal.valueOf(25.90d)); c3.setType("SUV"); c3.setYear(2010);
	 * c3.setAvailableToRentOrNot(c3.isAvailable());
	 * 
	 * // CAR 4 Car c4 = new Car(); c4.setAvailable(true); c4.setColor("White");
	 * c4.setDescription("Perfect for a backpacking trip");
	 * c4.setLicensePlateNumber("A44 223"); c4.setMake("Chevrolet");
	 * c4.setModel("Cruze"); c4.setPrice(BigDecimal.valueOf(34.5d));
	 * c4.setType("SUV"); c4.setYear(2017);
	 * c4.setAvailableToRentOrNot(c4.isAvailable());
	 * 
	 * // CAR 5 Car c5 = new Car(); c5.setAvailable(false); c5.setColor("Green");
	 * c5.setDescription("Available with Infant car seat");
	 * c5.setLicensePlateNumber("F55 604"); c5.setMake("Mitsubishi");
	 * c5.setModel("Mirage"); c5.setPrice(BigDecimal.valueOf(19.12d));
	 * c5.setType("SUV"); c5.setYear(2012);
	 * c5.setAvailableToRentOrNot(c5.isAvailable());
	 * 
	 * cars.add(c1); cars.add(c2); cars.add(c3); cars.add(c4); cars.add(c5); return
	 * cars;
	 * 
	 * }
	 */
	
	
	
	
	
	

}
