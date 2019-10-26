package com.team13.RentaRide.Controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team13.RentaRide.model.Admin;
import com.team13.RentaRide.model.Car;
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

	@RequestMapping(value = "/addNewCarPage", method = RequestMethod.POST)
	public ModelAndView addNewCarPage() {

		return new ModelAndView("CreateNewCarPage");
	}

	@RequestMapping(value = "/addNewCar", method = RequestMethod.POST)
	public ModelAndView addNewCar(@RequestParam String licensePlateNumber, @RequestParam String carDescription,
			@RequestParam String carModel, @RequestParam String carType, @RequestParam String carMake,
			@RequestParam String carYear, @RequestParam String carColor, @RequestParam String carPrice) {

		try {
			Car car = new Car();
			car.setAvailableReservedOrRented("Available");
			car.setColor(carColor);
			car.setDescription(carDescription);
			car.setLicensePlateNumber(licensePlateNumber);
			car.setMake(carMake);
			car.setModel(carModel);
			car.setPrice(new BigDecimal(carPrice));
			car.setType(carType);
			car.setYear(Integer.valueOf(carYear));
			System.out.println("created car: " + car);
			DataStore.getInstance().getAllCars().add(car);
			return new ModelAndView("AdminCarCatalogPage", "cars", DataStore.getInstance().getAllCars());
		} catch (Exception e) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("errorMessage", "Error while adding the Car, " + e.getMessage());
			return modelAndView;
		}
	}

	@RequestMapping(value = "/editCar")
	public ModelAndView editCar(@RequestParam String currentLicensePlateNumber) {
		System.out.println("licensePlateNumber: " + currentLicensePlateNumber);
		Car currentCar = null;

		for (Car car : DataStore.getInstance().getAllCars()) {
			if (car.getLicensePlateNumber().equals(currentLicensePlateNumber)) {
				currentCar = car;
				break;
			}
		}

		ModelAndView modelAndView = new ModelAndView("EditCarPage", "car", currentCar);
		return modelAndView;
	}

	@RequestMapping(value = "/saveCarChanges", method = RequestMethod.POST)
	public ModelAndView saveCarChanges(Car car) {

		for (Car currentCar : DataStore.getInstance().getAllCars()) {
			if (currentCar.getLicensePlateNumber().equals(car.getLicensePlateNumber())) {
				currentCar.setColor(car.getColor());
				currentCar.setDescription(car.getDescription());
				currentCar.setMake(car.getMake());
				currentCar.setModel(car.getModel());
				currentCar.setPrice(car.getPrice());
				currentCar.setType(car.getType());
				currentCar.setYear(car.getYear());
				break;
			}
		}
		return new ModelAndView("AdminCarCatalogPage", "cars", DataStore.getInstance().getAllCars());
	}

	@RequestMapping(value = "/deleteCar")
	public ModelAndView deleteCar(@RequestParam String currentLicensePlateNumber) {

		List<Car> tempCars = new ArrayList<Car>();
		tempCars.addAll(DataStore.getInstance().getAllCars());
		int index = 0;
		for (Car tempCar : tempCars) {
			if (tempCar.getLicensePlateNumber().equals(currentLicensePlateNumber)) {
				DataStore.getInstance().getAllCars().remove(index);
				break;
			}
			index++;
		}

		return new ModelAndView("AdminCarCatalogPage", "cars", DataStore.getInstance().getAllCars());
	}

}
