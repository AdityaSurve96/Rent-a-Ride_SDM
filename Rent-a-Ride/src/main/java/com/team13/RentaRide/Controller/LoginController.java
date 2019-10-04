package com.team13.RentaRide.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;	


@Controller

public class LoginController {
	
	@RequestMapping("/LoginPage")
	public ModelAndView showLoginPage(){
		
		return new ModelAndView("Login");
	}
	

	@RequestMapping("/registerClient")
	public ModelAndView showRegisterClientPage(){
		
		return new ModelAndView("RegisterClient");
	}
}
