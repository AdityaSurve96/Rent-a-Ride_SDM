package com.team13.RentaRide.Controller;

import java.text.SimpleDateFormat;
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

		List<Car> cars = DataStore.getAllCars();
		Car c=null;
		for (Car car : cars) {
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
	
	@RequestMapping(value ="/RentCarForClient",  method = RequestMethod.POST)
	public ModelAndView showRentedCars(@RequestParam String clientFirstName,@RequestParam String clientLastName,
									   @RequestParam String phoneNumber,@RequestParam String driverLicenceNumber,
									   @RequestParam String licenceExpiryDate, @RequestParam String CarLicenseNoForForm) {
		
		String licnum = CarLicenseNoForForm;
		List<Car> cars = DataStore.getAllCars();
		Car c=null;
		for (Car car : cars) {
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
		rh.addRentals(c, cl);
		
		modelAndView.addObject("rentals", rh.getRentals());
		
		return modelAndView;
		
		
		
	
		
	}
}


	


