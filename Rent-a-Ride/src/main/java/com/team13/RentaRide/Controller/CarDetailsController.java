package com.team13.RentaRide.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team13.RentaRide.mapper.CarDataMapper;
import com.team13.RentaRide.model.Car;

/**
 * Controller for Car
 * 
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

	CarDataMapper carDataMapper = new CarDataMapper();
	private static List<Car> cars = new ArrayList<Car>();
	private Car currentCar = null;

	@RequestMapping("/carDetailView")
	public ModelAndView showCarDetails(@RequestParam String licensePlateInput) {
		cars = carDataMapper.getAllCars();
		currentCar = carDataMapper.getCarByLicenseNumber(licensePlateInput);
		return showCarView(currentCar);
	}

	@RequestMapping("/back")
	public ModelAndView showPreviousCar() {

		Integer index = cars.indexOf(currentCar);
		if (index > 0) {

			Car prevCar = cars.get((index - 1));
			currentCar = prevCar;
			ModelAndView modelAndView = showCarView(prevCar);
			return modelAndView;
		}

		else {
			Car sameCar = currentCar;
			ModelAndView modelAndView = showCarView(sameCar);
			return modelAndView;
		}
	}

	@RequestMapping("/next")
	public ModelAndView showNextCar() {

		System.out.println("cars now : " + cars);
		System.out.println("checking currentCar: " + currentCar);
		Integer index = cars.indexOf(currentCar);
		System.out.println("index of current car " + index);
		if (index < (cars.size() - 1)) {
			Car nextCar = cars.get(index + 1);
			currentCar = nextCar;
			ModelAndView modelAndView = showCarView(nextCar);
			return modelAndView;
		} else {
			Car sameCar = currentCar;
			ModelAndView modelAndView = showCarView(sameCar);
			return modelAndView;
		}

	}

	@RequestMapping("/backtoCarCatalog")
	public ModelAndView showCarCatalogPage() {
		ModelAndView modelAndView = new ModelAndView("CarCatalog");
		modelAndView.addObject("cars", carDataMapper.getAllCars());
		return modelAndView;
	}

	/**
	 * @param car car object is passed to check the availability of the car
	 * @return model and view of car.
	 */

	public ModelAndView showCarView(Car car) {
		ModelAndView modelAndView = new ModelAndView("CarDetails", "car", car);

		if (car.getAvailableReservedOrRented().equals("Available")) {
			modelAndView.addObject("canReserveOrNot", "Reserve Now");
			modelAndView.addObject("canRentOrNot", "Rent Now");
		} else if (car.getAvailableReservedOrRented().equals("Reserved")) {
			modelAndView.addObject("canReserveOrNot", "Already Reserved");
			modelAndView.addObject("canRentOrNot", "Cannot Rent Now");
			modelAndView.addObject("disableOrNo", "disabled");
		} else {
			modelAndView.addObject("canReserveOrNot", "Cannot Reserve Now");
			modelAndView.addObject("canRentOrNot", "Already Rented");
			modelAndView.addObject("disableOrNo", "disabled");
		}
		return modelAndView;
	}

}
