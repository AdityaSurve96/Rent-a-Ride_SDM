package com.team13.RentaRide.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team13.RentaRide.utils.DataStore;


@Controller
public class ClerkRegisterController {
	
	
	@RequestMapping("/tryToRegisterAsClerk")
	public ModelAndView showRegisterClerkPage() {

		return new ModelAndView("ClerkRegisterPage");

	}
	

	@RequestMapping(value = "/clerkRegistered" , method = RequestMethod.POST)
	public ModelAndView registerClerk(@RequestParam String email, @RequestParam String password) {

		DataStore ds = DataStore.getInstance();
		ds.addClerk(email, password);
		
		return new ModelAndView("ClerkLoginPage");
	}


}
