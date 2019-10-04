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

			
			modelAndView = new ModelAndView("car-info");
//			modelAndView.addObject("name", name);
//			modelAndView.addObject("password", password);

			Car car1 = new Car();
			car1.setName("Aston Martin E");
			car1.setColor("Red");
			car1.setYear(2017);

			Car car2 = new Car();
			car2.setName("BMW CT4");
			car2.setColor("Blue");
			car2.setYear(2018);

			ArrayList<Car> cars = new ArrayList<>();

			cars.add(car1);
			cars.add(car2);
			
		

			modelAndView.addObject("cars", cars);
			
			return modelAndView;

		
		
	}

}
