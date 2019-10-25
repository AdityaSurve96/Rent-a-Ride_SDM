package com.team13.RentaRide.Controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team13.RentaRide.model.Car;

import com.team13.RentaRide.utils.DataStore;

@Controller
public class CarDetailsController {
	

	Car c=null;
	
	@RequestMapping("/carDetailView")
	public ModelAndView showCarDetails1(@RequestParam String licensePlateInput) {
		String carNumber = licensePlateInput;
		DataStore ds = DataStore.getInstance();
		List<Car> carsList = ds.getAllCars();
		
		
		
		for (Car car : carsList) {
			String lic = car.getLicensePlateNumber();

			if(lic.equals(carNumber)) {
				c = car;
				break;
				
			}
		}

		ModelAndView modelAndView = showCarView(c);

		return modelAndView;
	}
	
	
	

	@RequestMapping("/back")
	public ModelAndView showPreviousCar() {

		DataStore ds = DataStore.getInstance();
		List<Car> carsList = ds.getAllCars();
		Integer index=0;
		index= carsList.indexOf(c);
		if( index > 0 ) {
			
			Car prevCar = carsList.get((index-1));
			c=prevCar;
			
			ModelAndView modelAndView = showCarView(prevCar);
			return modelAndView;
		}

		else {
			Car sameCar = c;
			ModelAndView modelAndView = showCarView(sameCar);
			return modelAndView;
		}
	}


	@RequestMapping("/next")
	public ModelAndView showNextCar() {
		
		DataStore ds = DataStore.getInstance();
		List<Car> carsList = ds.getAllCars();
		Integer index=0;
		index= carsList.indexOf(c);
		if( index < (carsList.size()-1) ) {
			
			
			Car nextCar = carsList.get(index+1);
			c=nextCar;
//			Car nextCar = carsList.get((index));
//			index = index + 1 ;
//			System.out.println("FROM NEXT NEW "+index);
			ModelAndView modelAndView = showCarView(nextCar);
			return modelAndView;
		}
		else {
			Car sameCar = c;
			ModelAndView modelAndView = showCarView(sameCar);
			return modelAndView;
		}

	}
	
	@RequestMapping("/backtoCarCatalog")
	public ModelAndView showCarCatalogPage() {
		
		ModelAndView modelAndView = new ModelAndView("CarCatalog");
		DataStore ds = DataStore.getInstance();
		
		modelAndView.addObject("cars", ds.getAllCars());
		
		return modelAndView;
	}



//	
//	@RequestMapping("/SearchClient")
//	public ModelAndView searchThisClient(@RequestParam String)
//	
	
	
	
	
	public ModelAndView showCarView(Car c) {
		ModelAndView modelAndView= new ModelAndView("CarDetails");

		modelAndView.addObject("price",c.getPrice());
		modelAndView.addObject("CarModel",c.getModel());
		modelAndView.addObject("CarMake",c.getMake());
		modelAndView.addObject("CarYear",c.getYear());
		modelAndView.addObject("CarType",c.getType());
		modelAndView.addObject("CarLicensePlate",c.getLicensePlateNumber());
		modelAndView.addObject("CarColor",c.getColor());
		
		
		if(c.getAvailableReservedOrRented().equals("AVAILABLE")) {
			modelAndView.addObject("canReserveOrNot", "Reserve Now");
			modelAndView.addObject("canRentOrNot",    "Rent Now");
		}
		else if(c.getAvailableReservedOrRented().equals("Reserved"))
		{
			modelAndView.addObject("canReserveOrNot", "Already Reserved");
			modelAndView.addObject("canRentOrNot",    "Cannot Rent Now");
			modelAndView.addObject("disableOrNo" , "disabled");
		}
		else {
			modelAndView.addObject("canReserveOrNot", "Cannot Reserve Now");
			modelAndView.addObject("canRentOrNot",    "Already Rented");
			modelAndView.addObject("disableOrNo" , "disabled");
		}
		return modelAndView;
	}
	

}
