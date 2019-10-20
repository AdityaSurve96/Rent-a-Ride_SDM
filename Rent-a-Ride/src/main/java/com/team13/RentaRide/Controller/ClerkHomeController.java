package com.team13.RentaRide.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClerkHomeController {
	
	@RequestMapping("/viewCarCatalog")
	public ModelAndView showCarCatalogPage() {
		
		ModelAndView modelAndView = new ModelAndView("CarCatalog");
		
		return modelAndView;
	}
	
	@RequestMapping("/showClientManagement")
	public ModelAndView showClientManagementPage() {
		
		ModelAndView modelAndView = new ModelAndView("ClientManagementPage");
		
		return modelAndView;
	}
	

}
