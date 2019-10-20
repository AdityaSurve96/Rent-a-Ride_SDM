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
public class AdminLoginController {

	@RequestMapping("/AdminLoginPage")
	public ModelAndView showLoginPage() {
		return new ModelAndView("AdminLoginPage");
	}

	@RequestMapping(value = "/tryToLoginAsAdmin", method = RequestMethod.POST)
	public ModelAndView showWelcomePage(@RequestParam String email, @RequestParam String password) {

		boolean flag = false;
		List<Admin> admins = DataStore.getAdmins();

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

	}

}
