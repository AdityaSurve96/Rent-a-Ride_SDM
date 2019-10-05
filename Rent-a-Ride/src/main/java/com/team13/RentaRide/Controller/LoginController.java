package com.team13.RentaRide.Controller;

import java.math.BigDecimal;
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

		Car car1 = new Car();
		car1.setModel("Aston Martin E");
		car1.setType("SUV");
		car1.setMake("Make1");
		car1.setColor("Red");
		car1.setYear(2017);
		car1.setPrice(new BigDecimal(200.0d));
		car1.setAvailable(true);

		Car car2 = new Car();
		car2.setModel("X5");
		car2.setType("SUV");
		car2.setMake("BMW");
		car2.setColor("Black");
		car2.setYear(2018);
		car2.setPrice(new BigDecimal(300.0d));
		car2.setAvailable(false);

		Car car3 = new Car();
		car3.setModel("D6");
		car3.setType("SUV");
		car3.setMake("Volvo");
		car3.setColor("Blue");
		car3.setYear(2018);
		car3.setPrice(new BigDecimal(300.0d));
		car3.setAvailable(false);

		ArrayList<Car> cars = new ArrayList<>();

		cars.add(car1);
		cars.add(car2);
		cars.add(car3);

		modelAndView.addObject("cars", cars);

		return modelAndView;

	}

	@RequestMapping("/registerClient")
	public ModelAndView showRegisterClientPage() {

		return new ModelAndView("RegisterClient");

	}

}
