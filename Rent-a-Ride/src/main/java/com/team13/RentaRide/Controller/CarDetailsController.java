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
	

}
