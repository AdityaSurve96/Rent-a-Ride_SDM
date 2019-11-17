package com.team13.RentaRide.Controller;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team13.RentaRide.model.Car;
import com.team13.RentaRide.utils.DataStore;
/**
 * Controller for Car
 * @author team 13
 *
 */

@Controller
public class CarDetailsController {
	/**
	 * The controller for car has different operations like:
	 * <li>Can browse detailed view of car</li>
	 * <li>check availability of car</li>
	 * <li>view the precious or next detailed view of car</li>
	 * <li>can go back to car catalog</li>
	 */

	Car c=null;
	
	@RequestMapping("/carDetailView")
	public ModelAndView showCarDetails(@RequestParam String licensePlateInput) {
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
	/**
	 * @param c car object is passed to check the availability of the car
	 * @return model and view of car.
	 */
	
	
	public ModelAndView showCarView(Car c) {
		ModelAndView modelAndView= new ModelAndView("CarDetails","car",c);
		
		if(c.getAvailableReservedOrRented().equals("Available")) {
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
