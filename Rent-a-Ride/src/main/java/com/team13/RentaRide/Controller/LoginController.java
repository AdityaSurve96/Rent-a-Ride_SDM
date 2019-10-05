package com.team13.RentaRide.Controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team13.RentaRide.model.Car;
import com.team13.RentaRide.model.Clerk;
import com.team13.RentaRide.model.ClerksHolder;
import com.team13.RentaRide.utils.DataStore;

@Controller

public class LoginController {

	@RequestMapping("/LoginClerk")
	public ModelAndView showLoginPage() {
		return new ModelAndView("Login");
	}

	@RequestMapping(value = "/loginAsClerk", method = RequestMethod.POST)
	public ModelAndView showWelcomePage(@RequestParam String email, @RequestParam String password) {

		boolean flag = false;
		Clerk c = new Clerk(email, password);
		ClerksHolder chold = ClerksHolder.getInstance();
		ArrayList<Clerk> clerks = chold.getRegisteredClerks();

		for (Clerk clerk : clerks) {
			if (c.getEmail().equals(clerk.getEmail()) && c.getPassword().equals(clerk.getPassword())) {
				flag = true;
				break;
			}
		}

		if (flag) {
			ModelAndView modelAndView;
			modelAndView = new ModelAndView("car-catalog-info-page");
			modelAndView.addObject("cars", DataStore.getAllCars());
			return modelAndView;

		}
		ModelAndView modelAndView = new ModelAndView("Login");
		modelAndView.addObject("errorMessage","INVALIDLOGIN!.. Please try again");
		return modelAndView;

	}

}
