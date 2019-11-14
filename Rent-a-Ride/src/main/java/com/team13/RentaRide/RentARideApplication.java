package com.team13.RentaRide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.team13.RentaRide.tdgateway.DatabaseCreator;
import com.team13.RentaRide.utils.DataStore;

@SpringBootApplication
public class RentARideApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentARideApplication.class, args);
		DatabaseCreator.testDb();

		DataStore ds = DataStore.getInstance();

		// TEST CODE

//		Car c1 = new Car();
//		c1.setId(1000);
//		c1.setAvailableReservedOrRented("Available");
//		c1.setColor("Red");
//		c1.setDescription("Newly renovated and refurbished");
//		c1.setLicensePlateNumber("E07 FFN");
//		c1.setMake("Volvo");
//		c1.setModel("D6");
//		c1.setPrice(BigDecimal.valueOf(25.55d));
//		c1.setType("Sedan");
//		c1.setYear(2011);
//
//		Client cl1 = new Client();
//		cl1.setId(1000);
//		cl1.setDriverLicenceNumber("ABCD20162040");
//		cl1.setClientFirstName("Richard");
//		cl1.setClientLastName("Pariath");
//		cl1.setPhoneNumber("5147272191");
//		cl1.setLicenceExpiryDate(LocalDate.of(2040, 12, 24));
//
//		ReservedCar reservedCar = new ReservedCar(c1, cl1, LocalDate.of(2019, 11, 15), LocalDate.of(2019, 11, 20));
//
//		ReservedCarDataMapper mapper = new ReservedCarDataMapper();
//		mapper.addReservedCarRecord(reservedCar);

//		System.out.println("** reservedcars \n\n\n "
//				+ mapper.getAllReservedCarsByDates(LocalDate.of(2019, 11, 15), LocalDate.of(2019, 11, 20)));

	}

}