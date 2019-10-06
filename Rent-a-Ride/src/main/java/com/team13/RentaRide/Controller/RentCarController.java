package com.team13.RentaRide.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team13.RentaRide.model.Car;
import com.team13.RentaRide.model.Client;
import com.team13.RentaRide.model.RentedCar;
import com.team13.RentaRide.model.RentedCarHolder;
import com.team13.RentaRide.utils.DataStore;

@Controller
public class RentCarController {

	@RequestMapping(value= "/rentTheSelectedCartrue")
	public ModelAndView showCarRentalPage(@RequestParam String licensePlate) {
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
	
	@RequestMapping(value= "/rentTheSelectedCarfalse")
	public ModelAndView showCatalogPage(@RequestParam String licensePlate) {
		DataStore ds = DataStore.getInstance();
		List<Car> carsList = ds.getAllCars();
		
		

		ModelAndView modelAndView;
		modelAndView = new ModelAndView("car-catalog-info-page");
		modelAndView.addObject("cars", carsList);
		return modelAndView;

	}

	@RequestMapping(value ="/RentCarForClient",  method = RequestMethod.POST)
	public ModelAndView showRentedCars(@RequestParam String clientFirstName,@RequestParam String clientLastName,
			@RequestParam String phoneNumber,@RequestParam String driverLicenceNumber,
			@RequestParam String licenceExpiryDate, @RequestParam String CarLicenseNoForForm,
			@RequestParam String dueDate) {

		String licnum = CarLicenseNoForForm;
		DataStore ds = DataStore.getInstance();
		List<Car> carsList = ds.getAllCars();
		Car c=null;
		for (Car car : carsList) {
			String lic = car.getLicensePlateNumber();

			if(lic.equals(licnum)) {

				c = car;
				break;

			}
		}

		Integer phnumber = Integer.parseInt(phoneNumber);

		Client cl = new Client(driverLicenceNumber, clientFirstName, clientLastName, phnumber, licenceExpiryDate );
		ModelAndView modelAndView = new ModelAndView("RentedCarList");
		RentedCarHolder rh = RentedCarHolder.getInstance();
		rh.addRentals(c, cl,dueDate);

		modelAndView.addObject("rentals", rh.getRentals());
		
		return modelAndView;

	}



	@RequestMapping(value = "/backToCarCatalog")
	public ModelAndView goToCarCatalog() {

		ModelAndView modelAndView  = new ModelAndView("car-catalog-info-page");
		
		RentedCarHolder rh = RentedCarHolder.getInstance();
		List<RentedCar> renCars = rh.getRentals();
		
		DataStore ds = DataStore.getInstance();
		List<Car> carsList = ds.getAllCars();
	
		
		for (RentedCar rencar : renCars) {
			Car rC = rencar.getRentedCar();
			
			for (Car car : carsList) {
				if(rC.getLicensePlateNumber().equals(car.getLicensePlateNumber())) {
					
					car.setAvailable(false);
					car.setAvailableToRentOrNot(car.isAvailable());
				}
			}
		}

		modelAndView.addObject("cars", carsList);
	
		return modelAndView;


	}
	
	
	@RequestMapping(value= "/backToRentedCarList")
	public ModelAndView showRentedCarPage() {
		
		ModelAndView modelAndView = new ModelAndView("RentedCarList");
		
		RentedCarHolder  rh = RentedCarHolder.getInstance();
		modelAndView.addObject("rentals", rh.getRentals());
		
		return modelAndView;
 		
	}
}





