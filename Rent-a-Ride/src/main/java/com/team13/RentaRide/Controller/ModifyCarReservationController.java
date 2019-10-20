package com.team13.RentaRide.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team13.RentaRide.model.Car;
import com.team13.RentaRide.model.Client;
import com.team13.RentaRide.model.RentedCar;
import com.team13.RentaRide.model.RentedCarList;
import com.team13.RentaRide.utils.DataStore;

@Controller
public class ModifyCarReservationController {




	@RequestMapping(value = "/gotoRentalsPageAfterModify" , method = RequestMethod.POST)
	public ModelAndView ModifyRental(@RequestParam String CarLicenseNoForForm, @RequestParam String clientFirstName, 
			@RequestParam String clientLastName, @RequestParam String phoneNumber,
			@RequestParam String driverLicenceNumber, @RequestParam String licenceExpiryDate,
			@RequestParam String dueDate){

		Date  dueDateinDateFormat=null;
		try {
			dueDateinDateFormat=new SimpleDateFormat("yyyy/MM/dd").parse(dueDate);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		
		ModelAndView modelAndView = new ModelAndView("RentedCarList");
		Car theCar=null;
		Client theClient=null;
		RentedCarList rh = RentedCarList.getInstance();
		List<RentedCar> carList = rh.getRentals();
		RentedCar rc=null;
		for (RentedCar rentedCar : carList) {
			if(rentedCar.getRentedCar().getLicensePlateNumber().equals(CarLicenseNoForForm)) {
				theCar = rentedCar.getRentedCar();
				theClient = rentedCar.getCarsClient();
				rc = rentedCar;
				break;
			}
		}

		theClient.setClientFirstName(clientFirstName);
		theClient.setClientLastName(clientLastName);
		theClient.setDriverLicenceNumber(driverLicenceNumber);
		theClient.setLicenceExpiryDate(licenceExpiryDate);
		theClient.setPhoneNumber(Integer.parseInt(phoneNumber));
		
		rc.setDueDate(dueDateinDateFormat);

		Date currentDate = new Date();

		String cancelReturn = ((currentDate).compareTo(dueDateinDateFormat) >=0) ? "RETURN" : "CANCEL" ;
    	
		rc.setOperation(cancelReturn);
		
		
		
		
		modelAndView.addObject("rentals", rh.getRentals());

		return modelAndView;
	}


	@RequestMapping(value = "/gotoRentalsPageAfterDelete" , method = RequestMethod.POST)
	public ModelAndView DeleteRentals(@RequestParam String CarLicenseNoForForm, @RequestParam String clientFirstName, 
			@RequestParam String clientLastName, @RequestParam String phoneNumber,
			@RequestParam String driverLicenceNumber, @RequestParam String licenceExpiryDate,
			@RequestParam String dueDate){

		RentedCarList rh = RentedCarList.getInstance();
		List<RentedCar> rentedList = rh.getRentals();
		
		RentedCar deletedRental = null;

		for (RentedCar rentedItem : rentedList) {

			if(rentedItem.getRentedCar().getLicensePlateNumber().equals(CarLicenseNoForForm)) {
				rentedList.remove(rentedItem);
				deletedRental = rentedItem;
				deletedRental.getRentedCar().setAvailable(true);
				deletedRental.getRentedCar().setAvailableToRentOrNot(true);
				break;
			}
		}

		DataStore d = DataStore.getInstance();
		List<Car> cars =  d.getAllCars();

		ModelAndView modelAndView = new ModelAndView("RentedCarList");

		modelAndView.addObject("rentals",rh.getRentals());

		return modelAndView;
	}






}
