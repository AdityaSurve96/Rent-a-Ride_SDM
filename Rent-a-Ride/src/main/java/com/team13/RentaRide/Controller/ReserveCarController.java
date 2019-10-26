package com.team13.RentaRide.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team13.RentaRide.model.Car;
import com.team13.RentaRide.model.Client;
import com.team13.RentaRide.model.RentedCar;
import com.team13.RentaRide.model.RentedCarList;
import com.team13.RentaRide.model.ReservedCar;
import com.team13.RentaRide.utils.DataStore;

@Controller
public class ReserveCarController {

	@RequestMapping(value= "/rentThisCar")
	public ModelAndView showCarRentingPage(@RequestParam String licensePlate) {
		DataStore ds = DataStore.getInstance();
		List<Car> carsList = ds.getAllCars();
		
		Car c=null;
		for (Car car : carsList) {
			if(car.getLicensePlateNumber().equals(licensePlate)) {

				c = car;
				break;

			}
		}

		ModelAndView modelAndView;
		modelAndView = new ModelAndView("RentCarForClient");
		modelAndView.addObject("carLicenseNumber", c.getLicensePlateNumber());
		return modelAndView;

	}
	
	@RequestMapping(value= "/reserveThisCar")
	public ModelAndView showCarReservingPage(@RequestParam String licensePlate) {
		DataStore ds = DataStore.getInstance();
		List<Car> carsList = ds.getAllCars();
		
		Car c=null;
		for (Car car : carsList) {
			if(car.getLicensePlateNumber().equals(licensePlate)) {

				c = car;
				break;

			}
		}

		ModelAndView modelAndView;
		modelAndView = new ModelAndView("ReserveCarForClient");
		modelAndView.addObject("licensePlateNumber", c.getLicensePlateNumber());
		return modelAndView;

	}
	

	
	@RequestMapping(value = "/searchThisClient",  method = RequestMethod.POST)
	public ModelAndView searchClient(@RequestParam String driverLicenceNumber, @RequestParam String CarLicenseNo) {
		ModelAndView modelAndView =null;
		System.out.println(CarLicenseNo);
		Client c=null;
		DataStore ds = DataStore.getInstance();
		List<Client> clients = ds.getAllClients();
		boolean flag =false;
		for (Client client : clients) {
			String clientsDriverLicenceNumber = client.getDriverLicenceNumber();
			if(clientsDriverLicenceNumber.equals(driverLicenceNumber)) {
				c=client;
				flag=true;
				break;
				
			}
			
		}
		if(flag) {
			modelAndView= new ModelAndView("ReserveCarForClient");
			modelAndView.addObject("licensePlateNumber",CarLicenseNo);
			modelAndView.addObject("driverLicenseNumber",c.getDriverLicenceNumber());
			modelAndView.addObject("clientFirstName", c.getClientFirstName());
			modelAndView.addObject("clientLastName", c.getClientLastName());
			modelAndView.addObject("phoneNumber",c.getPhoneNumber());
			modelAndView.addObject("licenceExpiryDate", c.getLicenceExpiryDate());
			return modelAndView;
		}
		else {
			modelAndView = new ModelAndView("ReserveCarForClient");
			modelAndView.addObject("licensePlateNumber",CarLicenseNo);
			modelAndView.addObject("driverLicenseNumber",driverLicenceNumber);
			modelAndView.addObject("clientNotFoundMessage", "Client does not exist already. Please enter the client details manually");
			return modelAndView;
		}
		
		
		
	}
	
	
	
	
	@RequestMapping(value ="/carReserved",  method = RequestMethod.POST)
	public ModelAndView showRentedCars(@RequestParam String clientFirstName,  @RequestParam String clientLastName,
									   @RequestParam String phoneNumber,      @RequestParam String driverLicenceNumber,
									   @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate licenceExpiryDate, 
									   
									   @RequestParam String CarLicenseNo,
									   
									   @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dropoffDate,
									   @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate pickupDate) {
		

		System.out.println(dropoffDate);
		
		
		
		String licnum = CarLicenseNo;
		DataStore ds = DataStore.getInstance();
		List<Car> carsList = ds.getAllCars();
		
		Car c=null;
		
		for (Car car : carsList) {
			String lic = car.getLicensePlateNumber();

			if(lic.equals(licnum)) {
				car.setAvailableReservedOrRented("RESERVED");
				c = car;
				break;
				
			}
		}

		List<Client> existingClients = ds.getAllClients();
		Client cl=null;
		List<ReservedCar> resCars = ds.getReservedCars();
		boolean flag =false;
		for (Client client : existingClients) {
			if(client.getDriverLicenceNumber().equals(driverLicenceNumber)) {
				flag =true;
				cl = client;
				break;
			}
		}
		
		if(!flag) {
			cl= new Client();
			cl.setClientFirstName(clientFirstName);
			cl.setClientLastName(clientLastName);
			cl.setPhoneNumber(phoneNumber);
			cl.setDriverLicenceNumber(driverLicenceNumber);
			cl.setLicenceExpiryDate(licenceExpiryDate);
		}
		ModelAndView modelAndView = new ModelAndView("ViewReservedCars");
		ReservedCar resCar = new ReservedCar(c,cl , pickupDate, dropoffDate);
		resCars.add(resCar);
	
		modelAndView.addObject("reservations", resCars);
		return modelAndView;
		

	}



	
	
	@RequestMapping(value = "/backToCarCatalog")
	public ModelAndView goToCarCatalog() {

		ModelAndView modelAndView  = new ModelAndView("CarCatalog");
		
		DataStore ds = DataStore.getInstance();
		List<Car> carsList = ds.getAllCars();
		
		modelAndView.addObject("cars", carsList);
		
		return modelAndView;


	}
	
	
	
	
	
	
	@RequestMapping(value= "/backToRentedCarList")
	public ModelAndView showRentedCarsPage() {
		
		ModelAndView modelAndView = new ModelAndView("RentedCarList");
		DataStore ds= DataStore.getInstance();
		modelAndView.addObject("rentals", ds.getRentedCars());
		return modelAndView;
 		
	}
	
	@RequestMapping(value= "/backToReservedCarList")
	public ModelAndView showReservedCarsPage() {
		
		ModelAndView modelAndView = new ModelAndView("ViewReservedCars");
		DataStore ds = DataStore.getInstance();
		modelAndView.addObject("reservations", ds.getReservedCars());
		return modelAndView;
 		
	}
	
	
	
	
	
	
	
	


}






