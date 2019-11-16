package com.team13.RentaRide.Controller;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team13.RentaRide.model.Clerk;
import com.team13.RentaRide.model.Client;
import com.team13.RentaRide.utils.DataStore;

/**
 * 
 * @author Admin
 *
 */
@Controller
public class ClerkOperationController {
	/**
	 * 
	 * @return
	 */
	

	@RequestMapping("/tryToRegisterAsClerk")
	public ModelAndView showRegisterClerkPage() {

		return new ModelAndView("ClerkRegisterPage");

	}
	/**
	 * 
	 * @param email
	 * @param password
	 * @return
	 */

	@RequestMapping(value = "/clerkRegistered", method = RequestMethod.POST)
	public ModelAndView registerClerk(@RequestParam String email, @RequestParam String password) {

		DataStore ds = DataStore.getInstance();
		ds.addClerk(email, password);

		return new ModelAndView("ClerkLoginPage");
	}
/**
 * 
 * @return
 */
	@RequestMapping("/viewCarCatalog")
	public ModelAndView showCarCatalogPage() {

		ModelAndView modelAndView = new ModelAndView("CarCatalog");

		DataStore ds = DataStore.getInstance();

		modelAndView.addObject("cars", ds.getAllCars());

		return modelAndView;
	}

	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/showClientManagement")
	public ModelAndView showClientManagementPage() {

		ModelAndView modelAndView = new ModelAndView("ClientManagementPage");
		DataStore ds = DataStore.getInstance();
		List<Client> clientList = ds.getAllClients();
		modelAndView.addObject("clients", clientList);
		return modelAndView;
	}
/**
 * 
 * @return
 */
	@RequestMapping("/ClerkLoginPage")
	public ModelAndView showLoginPage() {
		return new ModelAndView("ClerkLoginPage");
	}
/**
 * 
 * @param email
 * @param password
 * @return
 */
	@RequestMapping(value = "/tryTologinAsClerk", method = RequestMethod.POST)
	
	public ModelAndView showWelcomePage(@RequestParam String email, @RequestParam String password) {

		boolean flag = false;
		Clerk c = new Clerk(email, password);
		DataStore ds = DataStore.getInstance();
		List<Clerk> clerks = ds.getRegisteredClerks();

		for (Clerk clerk : clerks) {
			if (c.getEmail().equals(clerk.getEmail()) && c.getPassword().equals(clerk.getPassword())) {
				flag = true;
				break;
			}
		}

		if (flag) {
			ModelAndView modelAndView = new ModelAndView("ClerkHomePage");

			return modelAndView;

		}
		ModelAndView modelAndView = new ModelAndView("ClerkLoginPage");
		modelAndView.addObject("errorMessage", "INVALID LOGIN! Please try again.");
		return modelAndView;

	}

}
