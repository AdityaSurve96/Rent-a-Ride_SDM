package com.team13.RentaRide.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team13.RentaRide.model.Admin;
import com.team13.RentaRide.utils.DataStore;

@Controller
public class AdminOperationsController {

	@RequestMapping("/AdminLoginPage")
	public ModelAndView showLoginPage() {
		return new ModelAndView("AdminLoginPage");
	}

	@RequestMapping("/manageCatalog")
	public ModelAndView showCarCatalogPage() {

		ModelAndView modelAndView = new ModelAndView("CarCatalog");

		return modelAndView;
	}

	@RequestMapping("/showRentals")
	public ModelAndView showClientManagementPage() {

		ModelAndView modelAndView = new ModelAndView("RentalRecordsPage");

		return modelAndView;
	}

	@RequestMapping(value = "/tryToLoginAsAdmin", method = RequestMethod.POST)
	public ModelAndView showWelcomePage(@RequestParam String email, @RequestParam String password) {
		System.out.println("here**************");
		try {
			boolean flag = false;
			List<Admin> admins = DataStore.getAdmins();
			System.out.println("admins: " + admins);

			for (Admin admin : admins) {
				if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
					flag = true;
					break;
				}
			}

			if (flag) {
				ModelAndView modelAndView = new ModelAndView("AdminHomePage");
				return modelAndView;

			}
			ModelAndView modelAndView = new ModelAndView("AdminLoginPage");
			modelAndView.addObject("errorMessage", "INVALID LOGIN! Please try again.");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/registerAdmin", method = RequestMethod.POST)
	public ModelAndView registerClerk(@RequestParam String email, @RequestParam String password) {

		if (!email.isEmpty() && !password.isEmpty()) {
			DataStore.getAdmins().add(new Admin(email, password));
			return new ModelAndView("AdminLoginPage");
		}

		ModelAndView modelAndView = new ModelAndView("AdminRegisterPage");
		modelAndView.addObject("errorMessage", "Invalid UserId/Password, try again!");
		return modelAndView;

	}

	@RequestMapping(value = "/adminManageCatalog", method = RequestMethod.GET)
	public ModelAndView adminManageCatalog() {
		return new ModelAndView("AdminCarCatalogPage", "cars", DataStore.getInstance().getAllCars());
	}

	@RequestMapping(value = "/adminViewRentals", method = RequestMethod.POST)
	public ModelAndView adminViewRentals() {

		ModelAndView modelAndView = new ModelAndView("AdminViewRentalsPage");
		return modelAndView;

	}

}
