package com.team13.RentaRide.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team13.RentaRide.model.Car;
import com.team13.RentaRide.model.Clerk;
import com.team13.RentaRide.model.ClerksList;
import com.team13.RentaRide.utils.DataStore;

@Controller

public class ClerkLoginController {

	@RequestMapping("/ClerkLoginPage")
	public ModelAndView showLoginPage() {
		return new ModelAndView("ClerkLoginPage");
	}

	@RequestMapping(value = "/tryTologinAsClerk", method = RequestMethod.POST)
	public ModelAndView showWelcomePage(@RequestParam String email, @RequestParam String password) {

		boolean flag = false;
		Clerk c = new Clerk(email, password);
		ClerksList chold = ClerksList.getInstance();
		ArrayList<Clerk> clerks = chold.getRegisteredClerks();

		for (Clerk clerk : clerks) {
			if (c.getEmail().equals(clerk.getEmail()) && c.getPassword().equals(clerk.getPassword())) {
				flag = true;
				break;
			}
		}

		if (flag) {
			ModelAndView modelAndView = new ModelAndView("ClerkHomePage");
			// DataStore ds = DataStore.getInstance();
			//
			// modelAndView.addObject("cars", ds.getAllCars());

			return modelAndView;

		}
		ModelAndView modelAndView = new ModelAndView("ClerkLoginPage");
		modelAndView.addObject("errorMessage", "INVALID LOGIN! Please try again.");
		return modelAndView;

	}

}
