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
	Integer index=0;
	@RequestMapping("/carDetailView1")
	public ModelAndView showCarDetails1(@RequestParam String licensePlateInput1) {
		index = Integer.parseInt(licensePlateInput1);
		List<Car> carsList = DataStore.getAllCars();
		//		CarHolder chold = CarHolder.getInstance();
		//		 = chold.getCars();

		Car aCarObject = carsList.get((index-1));

		ModelAndView modelAndView = showCarView(aCarObject);

		return modelAndView;
	}
	@RequestMapping("/carDetailView2")
	public ModelAndView showCarDetails2(@RequestParam String licensePlateInput2) {

		index = Integer.parseInt(licensePlateInput2);
		List<Car> carsList = DataStore.getAllCars();
		//		CarHolder chold = CarHolder.getInstance();
		//		 = chold.getCars();

		Car aCarObject = carsList.get((index-1));


		ModelAndView modelAndView = showCarView(aCarObject);

		return modelAndView;

	}

	@RequestMapping("/carDetailView3")
	public ModelAndView showCarDetails3(@RequestParam String licensePlateInput3) {

		index = Integer.parseInt(licensePlateInput3);

		List<Car> carsList = DataStore.getAllCars();
		//		CarHolder chold = CarHolder.getInstance();
		//		 = chold.getCars();

		Car aCarObject = carsList.get((index-1));

		ModelAndView modelAndView = showCarView(aCarObject);

		return modelAndView;
	}
	
	
	@RequestMapping("/carDetailView4")
	public ModelAndView showCarDetails4(@RequestParam String licensePlateInput4) {

		index = Integer.parseInt(licensePlateInput4);
		List<Car> carsList = DataStore.getAllCars();
		//		CarHolder chold = CarHolder.getInstance();
		//		 = chold.getCars();
		Car aCarObject = carsList.get((index-1));

		ModelAndView modelAndView = showCarView(aCarObject);

		return modelAndView;
	}
	
	
	@RequestMapping("/carDetailView5")
	public ModelAndView showCarDetails5(@RequestParam String licensePlateInput5) {

		index = Integer.parseInt(licensePlateInput5);

		List<Car> carsList = DataStore.getAllCars();
		//		CarHolder chold = CarHolder.getInstance();
		//		 = chold.getCars();
		Car aCarObject = carsList.get((index-1));

		ModelAndView modelAndView = showCarView(aCarObject);

		return modelAndView;


	}

	@RequestMapping("/back")
	public ModelAndView showPreviousCar() {
		System.out.println("FROM PREV "+index);
		List<Car> allCars = DataStore.getAllCars();
	
		if( index > 1 ) {

			Car prevCar = allCars.get((index-2));
			index = index - 1 ;
			System.out.println("FROM PREV NEW "+index);
			ModelAndView modelAndView = showCarView(prevCar);
			return modelAndView;
		}

		else {
			Car sameCar = allCars.get((index-1));
			ModelAndView modelAndView = showCarView(sameCar);
			return modelAndView;
		}
	}


	@RequestMapping("/next")
	public ModelAndView showNextCar() {
		System.out.println("FROM NEXT "+index);
		List<Car> allCars2 = DataStore.getAllCars();

		if( index < 5 ) {

			Car nextCar = allCars2.get((index));
			index = index + 1 ;
			System.out.println("FROM NEXT NEW "+index);
			ModelAndView modelAndView = showCarView(nextCar);
			return modelAndView;
		}
		else {
			Car sameCar = allCars2.get((index-1));
			ModelAndView modelAndView = showCarView(sameCar);
			return modelAndView;
		}

	}
	public ModelAndView showCarView(Car c) {
		ModelAndView modelAndView= new ModelAndView("CarDetails");

		modelAndView.addObject("price",c.getPrice());
		modelAndView.addObject("CarModel",c.getModel());
		modelAndView.addObject("CarMake",c.getMake());
		modelAndView.addObject("CarYear",c.getYear());
		modelAndView.addObject("CarType",c.getType());
		modelAndView.addObject("CarLicensePlate",c.getLicensePlateNumber());
		modelAndView.addObject("CarColor",c.getColor());
		modelAndView.addObject("CarAvail",c.getAvailableToRentOrNot());
		modelAndView.addObject("CarAvailablity",c.isAvailable());
		String rentedOrNot = c.isAvailable() ? "Rent" : "RENTED"; 
		modelAndView.addObject("showRentOrNot",rentedOrNot);

		return modelAndView;
	}
	

}
