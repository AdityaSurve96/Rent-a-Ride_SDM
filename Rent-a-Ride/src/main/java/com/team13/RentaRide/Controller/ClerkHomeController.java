package com.team13.RentaRide.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.team13.RentaRide.model.Car;
import com.team13.RentaRide.model.Client;
import com.team13.RentaRide.model.RentedCar;
import com.team13.RentaRide.model.RentedCarList;

import com.team13.RentaRide.utils.DataStore;

@Controller
public class ClerkHomeController {
	
	@RequestMapping("/viewCarCatalog")
	public ModelAndView showCarCatalogPage() {
		
		ModelAndView modelAndView = new ModelAndView("CarCatalog");

		DataStore ds = DataStore.getInstance();
		
		modelAndView.addObject("cars", ds.getAllCars());

		return modelAndView;
	}
	
	@RequestMapping("/showClientManagement")
	public ModelAndView showClientManagementPage() {
		
		ModelAndView modelAndView = new ModelAndView("ClientManagementPage");
		DataStore ds = DataStore.getInstance();
		List<Client> clientList = ds.getAllClients();
		modelAndView.addObject("clients", clientList);
		return modelAndView;
	}
	

}
