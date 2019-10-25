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
		modelAndView.addObject("carLicenseNumber", c.getLicensePlateNumber());
		return modelAndView;

	}
	

	
	@RequestMapping(value = "/searchThisClient",  method = RequestMethod.POST)
	public ModelAndView searchClient(@RequestParam String driverLicenceNumber) {
		
		ModelAndView modelAndView = new ModelAndView("ReserveCarForClient");
		Client c=null;
		DataStore ds = DataStore.getInstance();
		List<Client> clients = ds.getAllClients();
		
		for (Client client : clients) {
			String clientsDriverLicenceNumber = client.getDriverLicenceNumber();
			if(clientsDriverLicenceNumber.equals(driverLicenceNumber)) {
				c=client;
				break;
			}
		}
		
		modelAndView.addObject("clientFirstName", c.getClientFirstName());
		modelAndView.addObject("clientLastName", c.getClientLastName());
		modelAndView.addObject("phoneNumber",c.getPhoneNumber());
		modelAndView.addObject("licenceExpiryDate", c.getLicenceExpiryDate());
		
		
		return modelAndView;
		
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

	
		Client cl = new Client();
		cl.setClientFirstName(clientFirstName);
		cl.setClientLastName(clientLastName);
		cl.setPhoneNumber(phoneNumber);
		cl.setDriverLicenceNumber(driverLicenceNumber);
		cl.setLicenceExpiryDate(licenceExpiryDate);
		
		ModelAndView modelAndView = new ModelAndView("ViewReservedCars");
		
		List<ReservedCar> resCars = ds.getReservedCars();
		
		ReservedCar resCar = new ReservedCar(c, cl, pickupDate, dropoffDate);
		
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
	public ModelAndView showRentedCarPage() {
		
		ModelAndView modelAndView = new ModelAndView("RentedCarList");
		
		RentedCarList  rh = RentedCarList.getInstance();
		modelAndView.addObject("rentals", rh.getRentals());

		
		return modelAndView;
 		
	}
	
	
	
	
	@RequestMapping(value = "/modifyCarDetailView1" , method = RequestMethod.POST)
	public ModelAndView Modify1(@RequestParam String modifyCarNumber1){
		
		Integer index  = Integer.parseInt(modifyCarNumber1);
		ModelAndView modelAndView = setFieldforModification(index);
			
		return modelAndView;
	}
	@RequestMapping(value = "/modifyCarDetailView2" , method = RequestMethod.POST)
	public ModelAndView Modify2(@RequestParam String modifyCarNumber2){
		
		Integer index  = Integer.parseInt(modifyCarNumber2);
		ModelAndView modelAndView = setFieldforModification(index);
			
		return modelAndView;
	}
	@RequestMapping(value = "/modifyCarDetailView3" , method = RequestMethod.POST)
	public ModelAndView Modify3(@RequestParam String modifyCarNumber3){
		
		Integer index  = Integer.parseInt(modifyCarNumber3);
		ModelAndView modelAndView = setFieldforModification(index);
			
		return modelAndView;
	}
	@RequestMapping(value = "/modifyCarDetailView4" , method = RequestMethod.POST)
	public ModelAndView Modify4(@RequestParam String modifyCarNumber4){
		
		Integer index  = Integer.parseInt(modifyCarNumber4);
		ModelAndView modelAndView = setFieldforModification(index);
			
		return modelAndView;
	}
	@RequestMapping(value = "/modifyCarDetailView5" , method = RequestMethod.POST)
	public ModelAndView Modify5(@RequestParam String modifyCarNumber5){
		
		Integer index  = Integer.parseInt(modifyCarNumber5);
		ModelAndView modelAndView = setFieldforModification(index);
			
		return modelAndView;
	}

	
	
	
	
	
	
	@RequestMapping(value = "/deleteCarDetailView1" , method = RequestMethod.POST)
	public ModelAndView CancelReturn1(@RequestParam String deleteCarNumber1){
		
		Integer index  = Integer.parseInt(deleteCarNumber1);
		ModelAndView modelAndView = setFieldforCancel(index);
			
		return modelAndView;
	}	
	
	
	@RequestMapping(value = "/deleteCarDetailView2" , method = RequestMethod.POST)
	public ModelAndView CancelReturn2(@RequestParam String deleteCarNumber2){
		
		Integer index  = Integer.parseInt(deleteCarNumber2);
		ModelAndView modelAndView = setFieldforCancel(index);
			
		return modelAndView;
	}	
	
	
	@RequestMapping(value = "/deleteCarDetailView3" , method = RequestMethod.POST)
	public ModelAndView CancelReturn3(@RequestParam String deleteCarNumber3){
		
		Integer index  = Integer.parseInt(deleteCarNumber3);
		ModelAndView modelAndView = setFieldforCancel(index);
			
		return modelAndView;
	}
	
	@RequestMapping(value = "/deleteCarDetailView4" , method = RequestMethod.POST)
	public ModelAndView CancelReturn4(@RequestParam String deleteCarNumber4){
		
		Integer index  = Integer.parseInt(deleteCarNumber4);
		ModelAndView modelAndView = setFieldforCancel(index);
			
		return modelAndView;
	}
	
	@RequestMapping(value = "/deleteCarDetailView5" , method = RequestMethod.POST)
	public ModelAndView CancelReturn5(@RequestParam String deleteCarNumber5){
		
		Integer index  = Integer.parseInt(deleteCarNumber5);
		ModelAndView modelAndView = setFieldforCancel(index);
			
		return modelAndView;
	}
	
	
	
	
	public ModelAndView setFieldforModification(Integer index) {
		
		ModelAndView modelAndView = new ModelAndView("Modify");
		RentedCarList rh = RentedCarList.getInstance();
		List<RentedCar> rentedCarList = rh.getRentals();
		RentedCar rCar = rentedCarList.get(index-1);
		Car theCar = rCar.getRentedCar();
		Client theClient = rCar.getCarsClient();
		modelAndView.addObject("carLicenseNumber",theCar.getLicensePlateNumber());
		modelAndView.addObject("clientFirstName",theClient.getClientFirstName());
		modelAndView.addObject("clientLastName",theClient.getClientLastName());
		modelAndView.addObject("phoneNumber",theClient.getPhoneNumber());
		modelAndView.addObject("driverLicenceNumber",theClient.getDriverLicenceNumber());
		modelAndView.addObject("licenceExpiryDate",theClient.getLicenceExpiryDate());
		modelAndView.addObject("dueDate",rCar.getDueDate());
	
		return modelAndView;
		
	}
	
	
public ModelAndView setFieldforCancel(Integer index) {
		
		ModelAndView modelAndView = new ModelAndView("CancelReturn");
		RentedCarList rh = RentedCarList.getInstance();
		List<RentedCar> rentedCarList = rh.getRentals();
		RentedCar rCar = rentedCarList.get(index-1);
//		Car theCar = rCar.getRentedCar();
//		Client theClient = rCar.getCarsClient();
//		modelAndView.addObject("carLicenseNumber",theCar.getLicensePlateNumber());
//		modelAndView.addObject("clientFirstName",theClient.getClientFirstName());
//		modelAndView.addObject("clientLastName",theClient.getClientLastName());
//		modelAndView.addObject("phoneNumber",theClient.getPhoneNumber());
//		modelAndView.addObject("driverLicenceNumber",theClient.getDriverLicenceNumber());
//		modelAndView.addObject("licenceExpiryDate",theClient.getLicenceExpiryDate());
		modelAndView.addObject("dueDate",rCar.getDueDate());
	
		return modelAndView;
		
	}
}






