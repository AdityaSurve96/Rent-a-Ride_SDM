package com.team13.RentaRide.Controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team13.RentaRide.model.Car;

@Controller

public class LoginController {

	@RequestMapping("/LoginClerk")	
	public ModelAndView showLoginPage() {
		return new ModelAndView("Login");
	}

	@RequestMapping(value = "/LoginClerk", method = RequestMethod.POST)
	public ModelAndView showWelcomePage(@RequestParam String name, @RequestParam String password) {

		ModelAndView modelAndView = null;
			
			
			
			modelAndView = new ModelAndView("car-catalog-info-page");
//			modelAndView.addObject("name", name);
//			modelAndView.addObject("password", password);

			Car car1 = new Car();
			car1.setModel("Aston Martin E");
			car1.setColor("Red");
			car1.setMake("Make1");
			car1.setYear(2017);

			Car car2 = new Car();
			car2.setModel("X5");
			
			car2.setMake("BMW");
			car2.setColor("Black");
			car2.setYear(2018);
			
			
			Car car3 = new Car();
			car3.setModel("D6");
			car3.setType("SUV");
			car3.setMake("Volvo");
			car3.setColor("Blue");
			car3.setYear(2018);

			ArrayList<Car> cars = new ArrayList<>();

			cars.add(car1);
			cars.add(car3);
			
		

			modelAndView.addObject("cars", cars);
			
			return modelAndView;

		
		
	}
	
 	@RequestMapping("/registerClient")
 	public ModelAndView showRegisterClientPage() {
 		
 		return new ModelAndView("RegisterClient");

 	}


}
