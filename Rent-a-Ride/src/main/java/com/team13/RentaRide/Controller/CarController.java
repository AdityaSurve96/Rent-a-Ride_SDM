package com.team13.RentaRide.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.team13.RentaRide.utils.DataStore;

@Controller
public class CarController {

	@RequestMapping(value = "/carList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ModelAndView getFilteredCarInfo(HttpServletRequest request, HttpServletResponse response) {

		String type = request.getParameter("type");
		String model = request.getParameter("model");

		System.out.println("******************" + type);
		System.out.println("******************" + model);

		return new ModelAndView("flightList", "lists", DataStore.getAllCars());

	}

}
