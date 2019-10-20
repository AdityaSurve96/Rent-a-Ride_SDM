package com.team13.RentaRide.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team13.RentaRide.model.ClerksList;


@Controller
public class AdminRegisterController {


	@RequestMapping("/tryToRegisterAdmin")
	public ModelAndView showRegisterClerkPage() {

		return new ModelAndView("AdminRegisterPage");

	}


	@RequestMapping(value = "/registerAdmin" , method = RequestMethod.POST)
	public ModelAndView registerClerk(@RequestParam String email, @RequestParam String password){

		ClerksList ch = ClerksList.getInstance();
		ch.addClerks(email,password);
		return new ModelAndView("AdminLoginPage");
	}


}
