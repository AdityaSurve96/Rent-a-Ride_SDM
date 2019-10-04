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
	
	@RequestMapping("/helloworld")
	public ModelAndView showLoginPage(){
		
		return new ModelAndView("index");
	}
	
//	@RequestMapping("/l",method = RequestMethod.POST)
//	public ModelAndView showWelcomePage(@RequestParam String name, @RequestParam String password){
//		
//		ModelAndView modelAndView = null;
//		
//		 try {
//		       
//		       modelAndView = new ModelAndView("welcome.jsp");
//		       modelAndView.addObject("name", name);
//		       modelAndView.addObject("password", password);
//		    } catch(IndexOutOfBoundsException e) {
//		       System.out.println("PROBLEMMMMMMMMMMMMMMM2s");
//		    }
//		    return modelAndView;
//	
//	}
//
}
