package com.team13.RentaRide.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team13.RentaRide.model.Car;
import com.team13.RentaRide.utils.DataStore;

@Controller
public class CarController {

	@RequestMapping(value = "/filterCars", method = RequestMethod.POST)
	public ModelAndView getFilteredCarInfo(@RequestParam String modelInput, @RequestParam String typeInput,
			@RequestParam String makeInput, @RequestParam String colorInput, @RequestParam String yearInput,
			@RequestParam Integer yearOffset) {

		DataStore ds = DataStore.getInstance();
		
		List<Car> cars = ds.getAllCars();
		List<Car> carsToSend = new ArrayList<>();
		Integer yearFilter = !StringUtils.isEmpty(yearInput) ? Integer.valueOf(yearInput) : 0;

		for (Car car : cars) {

			System.out.println("Checking modelInput" + modelInput + " and car model" + car.getModel());
			if (!StringUtils.isEmpty(modelInput) && !modelInput.equals(car.getModel())) {
				System.out.println("setting model add false");
				continue;
			}
			System.out.println("Checking typeInput " + typeInput + " and car type" + car.getType());

			if (!StringUtils.isEmpty(typeInput) && !typeInput.equals(car.getType())) {
				System.out.println("setting type add false");
				continue;
			}
			System.out.println("Checking makeInput " + makeInput + " and car make" + car.getMake());

			if (!StringUtils.isEmpty(makeInput) && !makeInput.equals(car.getMake())) {
				System.out.println("setting make add false");
				continue;
			}
			System.out.println("Checking colorInput " + colorInput + " and car color" + car.getColor());

			if (!StringUtils.isEmpty(colorInput) && !colorInput.equals(car.getColor())) {
				System.out.println("setting make color false");
				continue;
			}
			System.out.println("Checking yearInput " + yearInput + " and car year" + car.getYear());
			System.out.println("yearOffset " + yearOffset);

			if (yearOffset == null && !StringUtils.isEmpty(yearInput)
					&& !Integer.valueOf(yearInput).equals(car.getYear())) {
				System.out.println("setting year add false");
				continue;

			} else if (yearOffset != null && yearOffset < 0) {
				System.out.println("yearFilter - yearOffset  =  " + (yearFilter - yearOffset));
				if (!(car.getYear() >= yearFilter + yearOffset && car.getYear() <= yearFilter)) {
					continue;
				}
			} else if (yearOffset != null && yearOffset > 0) {
				if (!(car.getYear() <= yearFilter + yearOffset && car.getYear() >= yearFilter)) {
					continue;
				}
			}

			carsToSend.add(car);
		}

		return new ModelAndView("CarCatalog", "cars", carsToSend);

	}

}
