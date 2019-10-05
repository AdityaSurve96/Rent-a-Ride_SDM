package com.team13.RentaRide.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.team13.RentaRide.model.ClerksHolder;
import com.team13.RentaRide.utils.DataStore;

@Controller


public class ModifyCarController {
	
	@RequestMapping(value = "/Modify" , method = RequestMethod.POST)
	public ModelAndView Modify(@RequestParam String driverLicenceNumber, @RequestParam String licensePlateNumber,@RequestParam String firstName, @RequestParam String lastName,@RequestParam String phoneNumber){

		return new ModelAndView("car-catalog-info-page");
	}
	
	
	
	@RequestMapping(value = "/Delete" , method = RequestMethod.POST)
	public ModelAndView Modify(@RequestParam String driverLicenceNumber, @RequestParam String licensePlateNumber,@RequestParam String firstName, @RequestParam String lastName,@RequestParam String phoneNumber){

		return new ModelAndView("car-catalog-info-page");
	}
	
	
	
	
	
	
	
	
}
