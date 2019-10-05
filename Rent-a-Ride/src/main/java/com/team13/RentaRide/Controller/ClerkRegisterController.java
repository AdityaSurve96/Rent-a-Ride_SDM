package com.team13.RentaRide.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team13.RentaRide.model.ClerksHolder;


@Controller
public class ClerkRegisterController {


	@RequestMapping("/registerClerk")
	public ModelAndView showRegisterClerkPage() {

		return new ModelAndView("RegisterClerk");

	}


	@RequestMapping(value = "/clerkRegistered" , method = RequestMethod.POST)
	public ModelAndView registerClerk(@RequestParam String email, @RequestParam String password){

		ClerksHolder ch = ClerksHolder.getInstance();
		ch.addClerks(email,password);
		return new ModelAndView("Login");
	}


}
