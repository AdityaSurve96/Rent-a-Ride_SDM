package com.team13.RentaRide.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ClientRegisterController {

	
	@RequestMapping("/registerClient")
	public ModelAndView showLoginPage(){
		
		return new ModelAndView("RegisterClient");
	}
	
}
