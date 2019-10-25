package com.team13.RentaRide.utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.team13.RentaRide.model.Admin;
import com.team13.RentaRide.model.Car;
import com.team13.RentaRide.model.Clerk;
import com.team13.RentaRide.model.Client;
import com.team13.RentaRide.model.RentedCar;
import com.team13.RentaRide.model.ReservedCar;

public final class DataStore {

	private static DataStore instance;

	private static List<Clerk> clerks;
	private static List<Admin> admins;
	private static List<Client> clients;

	private static List<Car> carList;
	private static List<RentedCar> rentedCars;
	private static List<ReservedCar> reservedCars;

	
	private DataStore() {

		clients = new ArrayList<Client>();
		clerks = new ArrayList<Clerk>();
		admins = new ArrayList<Admin>();
		carList = new ArrayList<Car>();
		rentedCars = new ArrayList<RentedCar>();
		reservedCars = new ArrayList<ReservedCar>();
		
		addSomeAdmins();
		addSomeClerks();
		addSomeClients();
		addSomeCarstoList();
		addSomeCarstoRentedCars();
		addSomeCarstoReservedCars();
	}


	public static DataStore getInstance() {
		
		if (instance == null)
			instance = new DataStore();
		return instance;
	}

	
	public void addClerk(String email, String password) {

		Clerk c = new Clerk(email, password);

		clerks.add(c);
	}

	
	public void addAdmin(String email, String password) {

		Admin a = new Admin(email, password);

		admins.add(a);
	}
	

	
	
	
	
	public static List<Admin> getAdmins() {
		return admins;
	}


	public List<Clerk> getRegisteredClerks(){

		return clerks;
	}

	public List<Client> getAllClients(){
		return clients;
	}

	public List<ReservedCar> getReservedCars(){
		return reservedCars;
	}

	public List<RentedCar> getRentedCars(){
		return rentedCars;
	}

	public List<Car> getAllCars() {

		return carList;
	}



	private void addSomeClients() {


		Client cl1 = new Client();
		cl1.setDriverLicenceNumber("ABCD20162040");
		cl1.setClientFirstName("Richard");
		cl1.setClientLastName("Pariath");
		cl1.setPhoneNumber("5147272191");
		cl1.setLicenceExpiryDate(LocalDate.of(2040, 12, 24));

		Client cl2 = new Client();
		cl2.setDriverLicenceNumber("EFGH20172030");
		cl2.setClientFirstName("Thelma");
		cl2.setClientLastName("Gomes");
		cl2.setPhoneNumber("5628261413");
		cl2.setLicenceExpiryDate(LocalDate.of(2030, 06, 21));

		Client cl3 = new Client();
		cl3.setDriverLicenceNumber("IJKL20262045");
		cl3.setClientFirstName("James");
		cl3.setClientLastName("Albert");
		cl3.setPhoneNumber("7826789987");
		cl3.setLicenceExpiryDate(LocalDate.of(2034, 11, 01));

		clients.add(cl1);
		clients.add(cl2);
		clients.add(cl3);

	}


	private void addSomeClerks() {



		Clerk clk1 = new Clerk("clerk1@gmail.com", "clerk1_2019");
		Clerk clk2 = new Clerk("clerk2@gmail.com", "clerk2_2019");
		Clerk clk3=  new Clerk("clerk3@gmail.com", "clerk3_2019");

		clerks.add(clk1);
		clerks.add(clk2);
		clerks.add(clk3);


	}


	private void addSomeAdmins() {



		Admin ad1 = new Admin("admin1@gmail.com", "admin1_2019");
		Admin ad2 = new Admin("admin2@gmail.com", "admin2_2019");
		Admin ad3 = new Admin("admin3@gmail.com", "admin3_2019");

		admins.add(ad1);
		admins.add(ad2);
		admins.add(ad3);

	}


	public void addSomeCarstoRentedCars() {
			
	}

	public void addSomeCarstoReservedCars() {
			
	}


	public void addSomeCarstoList() {

		//CAR 1
		Car c1 = new Car();
		c1.setAvailableReservedOrRented("Available");
		c1.setColor("Red");
		c1.setDescription("Newly renovated and refurbished");
		c1.setLicensePlateNumber("E07 FFN");
		c1.setMake("Volvo");
		c1.setModel("D6");
		c1.setPrice(BigDecimal.valueOf(25.55d));
		c1.setType("Sedan");
		c1.setYear(2011);


		// CAR 2
		Car c2 = new Car();
		c2.setAvailableReservedOrRented("Reserved");
		c2.setColor("Blue");
		c2.setDescription("Good for a mountain trip");
		c2.setLicensePlateNumber("T57 335");
		c2.setMake("BMW");
		c2.setModel("X6");
		c2.setPrice(BigDecimal.valueOf(55.55d));
		c2.setType("SUV");
		c2.setYear(2009);


		// CAR 3
		Car c3 = new Car();
		c3.setAvailableReservedOrRented("Rented");
		c3.setColor("Black");
		c3.setDescription("Good for a long weekend");
		c3.setLicensePlateNumber("C66 478");
		c3.setMake("BMW");
		c3.setModel("X3");
		c3.setPrice(BigDecimal.valueOf(25.90d));
		c3.setType("SUV");
		c3.setYear(2010);


		// CAR 4
		Car c4 = new Car();
		c4.setAvailableReservedOrRented("AVAILABLE");
		c4.setColor("White");
		c4.setDescription("Perfect for a backpacking trip");
		c4.setLicensePlateNumber("A44 223");
		c4.setMake("Chevrolet");
		c4.setModel("Cruze");
		c4.setPrice(BigDecimal.valueOf(34.5d));
		c4.setType("SUV");
		c4.setYear(2017);


		// CAR 5
		Car c5 = new Car();
		c5.setAvailableReservedOrRented("AVAILABLE");
		c5.setColor("Purple");
		c5.setDescription("Available with Infant car seat");
		c5.setLicensePlateNumber("A33 J88");
		c5.setMake("Audi");
		c5.setModel("A3");
		c5.setPrice(BigDecimal.valueOf(49.12d));
		c5.setType("Sedan");
		c5.setYear(2011);


		// CAR 6
		Car c6 = new Car();
		c6.setAvailableReservedOrRented("AVAILABLE");
		c6.setColor("Red");
		c6.setDescription("Available with Infant car seat");
		c6.setLicensePlateNumber("Z55 817");
		c6.setMake("RAM");
		c6.setModel("RAM 1500");
		c6.setPrice(BigDecimal.valueOf(29.12d));
		c6.setType("SUV");
		c6.setYear(2017);

		// CAR 7
		Car c7 = new Car();
		c7.setAvailableReservedOrRented("Reserved");
		c7.setColor("Black");
		c7.setDescription("Available with Infant car seat");
		c7.setLicensePlateNumber("AAA 111");
		c7.setMake("Ford");
		c7.setModel("Focus");
		c7.setPrice(BigDecimal.valueOf(32.12d));
		c7.setType("Sedan");
		c7.setYear(2014);

		// CAR 8
		Car c8 = new Car();
		c8.setAvailableReservedOrRented("Rented");
		c8.setColor("White");
		c8.setDescription("Available with Infant car seat");
		c8.setLicensePlateNumber("1F1 224");
		c8.setMake("Mercedez Benz");
		c8.setModel("A-class");
		c8.setPrice(BigDecimal.valueOf(54.12d));
		c8.setType("Sedan");
		c8.setYear(2013);

		// CAR 9
		Car c9 = new Car();
		c9.setAvailableReservedOrRented("Reserved");
		c9.setColor("White");
		c9.setDescription("Available with Infant car seat");
		c9.setLicensePlateNumber("GG1 604");
		c9.setMake("Dodge");
		c9.setModel("Charger");
		c9.setPrice(BigDecimal.valueOf(15.12d));
		c9.setType("Sedan");
		c9.setYear(2016);

		// CAR 10
		Car c10 = new Car();
		c10.setAvailableReservedOrRented("Rented");
		c10.setColor("Blue");
		c10.setDescription("Available with Infant car seat");
		c10.setLicensePlateNumber("K3J 14F");
		c10.setMake("Dodge");
		c10.setModel("Challenger");
		c10.setPrice(BigDecimal.valueOf(49.12d));
		c10.setType("Sedan");
		c10.setYear(2018);




		carList.add(c1);
		carList.add(c2);
		carList.add(c3);
		carList.add(c4);
		carList.add(c5);
		carList.add(c6);
		carList.add(c7);
		carList.add(c8);
		carList.add(c9);
		carList.add(c10);
	}








	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public static List<Car> getAllCars() { List<Car> cars = new
	 * ArrayList<>();
	 * 
	 * // CAR 1 Car c1 = new Car(); c1.setAvailable(true); c1.setColor("Red");
	 * c1.setDescription("Newly renovated and refurbished");
	 * c1.setLicensePlateNumber("E07 FFN"); c1.setMake("Volvo");
	 * c1.setModel("D6"); c1.setPrice(BigDecimal.valueOf(25.55d));
	 * c1.setType("Sedan"); c1.setYear(2011);
	 * c1.setAvailableToRentOrNot(c1.isAvailable());
	 * 
	 * // CAR 2 Car c2 = new Car(); c2.setAvailable(false); c2.setColor("Blue");
	 * c2.setDescription("Good for a mountain trip");
	 * c2.setLicensePlateNumber("T57 335"); c2.setMake("BMW");
	 * c2.setModel("X6"); c2.setPrice(BigDecimal.valueOf(55.55d));
	 * c2.setType("SUV"); c2.setYear(2009);
	 * c2.setAvailableToRentOrNot(c2.isAvailable());
	 * 
	 * // CAR 3 Car c3 = new Car(); c3.setAvailable(true); c3.setColor("Black");
	 * c3.setDescription("Good for a long weekend");
	 * c3.setLicensePlateNumber("C66 478"); c3.setMake("BMW");
	 * c3.setModel("X3"); c3.setPrice(BigDecimal.valueOf(25.90d));
	 * c3.setType("SUV"); c3.setYear(2010);
	 * c3.setAvailableToRentOrNot(c3.isAvailable());
	 * 
	 * // CAR 4 Car c4 = new Car(); c4.setAvailable(true); c4.setColor("White");
	 * c4.setDescription("Perfect for a backpacking trip");
	 * c4.setLicensePlateNumber("A44 223"); c4.setMake("Chevrolet");
	 * c4.setModel("Cruze"); c4.setPrice(BigDecimal.valueOf(34.5d));
	 * c4.setType("SUV"); c4.setYear(2017);
	 * c4.setAvailableToRentOrNot(c4.isAvailable());
	 * 
	 * // CAR 5 Car c5 = new Car(); c5.setAvailable(false);
	 * c5.setColor("Green");
	 * c5.setDescription("Available with Infant car seat");
	 * c5.setLicensePlateNumber("F55 604"); c5.setMake("Mitsubishi");
	 * c5.setModel("Mirage"); c5.setPrice(BigDecimal.valueOf(19.12d));
	 * c5.setType("SUV"); c5.setYear(2012);
	 * c5.setAvailableToRentOrNot(c5.isAvailable());
	 * 
	 * cars.add(c1); cars.add(c2); cars.add(c3); cars.add(c4); cars.add(c5);
	 * return cars;
	 * 
	 * }
	 */

}
