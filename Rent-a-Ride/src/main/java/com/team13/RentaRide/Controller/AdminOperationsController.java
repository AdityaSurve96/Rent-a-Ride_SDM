package com.team13.RentaRide.Controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team13.RentaRide.mapper.AdminDataMapper;

import com.team13.RentaRide.mapper.ReservedCarDataMapper;

import com.team13.RentaRide.mapper.CarDataMapper;
import com.team13.RentaRide.mapper.RentedCarDataMapper;
import com.team13.RentaRide.model.Admin;
import com.team13.RentaRide.model.Car;
import com.team13.RentaRide.model.RentedCar;
import com.team13.RentaRide.model.ReservedCar;
import com.team13.RentaRide.utils.DataStore;
/**
 * The controller for Admin Operations.
 * @author team 13 
 *
 */

@Controller
public class AdminOperationsController {


	private CarDataMapper carDataMapper = new CarDataMapper();
	
	private RentedCarDataMapper rentedCarDataMapper = new RentedCarDataMapper();

	
	/**
	 * <p>The different Admin operations controlled by this classes are mentioned as follows</p>
	 * <ol>
	 * <li>Successful login of Admin </li>
	 *  <li>Manage the Car catalog </li>
	 *  <li>Viewing Rental Cars </li>
	 *  <li>Viewing Reserved Cars </li>
	 *  <li>Viewing Returned Cars </li>
	 *  <li>Viewing Cancelled Cars </li>
	 * </ol>
	 */


	private AdminDataMapper adminDataMapper = new AdminDataMapper();
	private ReservedCarDataMapper reservedCarMapper = new ReservedCarDataMapper();

	@RequestMapping("/AdminLoginPage")
	public ModelAndView showLoginPage() {
		return new ModelAndView("AdminLoginPage");
	}

	@RequestMapping("/manageCatalog")
	public ModelAndView showCarCatalogPage() {

		ModelAndView modelAndView = new ModelAndView("CarCatalog");

		return modelAndView;
	}

	@RequestMapping("/adminViewRentals")
	public ModelAndView showRentals() {

		ModelAndView modelAndView = new ModelAndView("AdminViewRentalTransactions", "rentals",
				rentedCarDataMapper.getAllRentedCars());

		return modelAndView;
	}

	@RequestMapping("/adminViewReservations")
	public ModelAndView showReservations() {

		List<ReservedCar> cars = reservedCarMapper.getAllReservedCars();

		return new ModelAndView("AdminViewReservedTransactions", "reservations", cars);
	}

	@RequestMapping(value = "/tryToLoginAsAdmin", method = RequestMethod.POST)
	/**
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	public ModelAndView showWelcomePage(@RequestParam String email, @RequestParam String password) {
		System.out.println("here**************");
		try {
			boolean flag = false;
			List<Admin> admins = adminDataMapper.getAllAdminRecords();
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
	/**
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	public ModelAndView registerAdmin(@RequestParam String email, @RequestParam String password) {

		if (!email.isEmpty() && !password.isEmpty()) {
			
			
			
			Admin admin = new Admin(email, password);
			adminDataMapper.addAdminRecord(admin);
			
			//DataStore.getAdmins().add(admin);
			return new ModelAndView("AdminLoginPage");
		}

		ModelAndView modelAndView = new ModelAndView("AdminRegisterPage");
		modelAndView.addObject("errorMessage", "Invalid UserId/Password, try again!");
		return modelAndView;

	}

	@RequestMapping(value = "/adminManageCatalog", method = RequestMethod.GET)
	public ModelAndView adminManageCatalog() {
		return new ModelAndView("AdminCarCatalogPage", "cars", carDataMapper.getAllCars());
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
	/**
	 * 
	 * @param licensePlateNumber
	 * @param carDescription
	 * @param carModel
	 * @param carType
	 * @param carMake
	 * @param carYear
	 * @param carColor
	 * @param carPrice
	 * @return
	 */
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
			
			carDataMapper.addCarRecord(car);
			
			DataStore.getInstance().getAllCars().add(car);
			return new ModelAndView("AdminCarCatalogPage", "cars", DataStore.getInstance().getAllCars());
		} catch (Exception e) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("errorMessage", "Error while adding the Car, " + e.getMessage());
			return modelAndView;
		}
	}

	@RequestMapping(value = "/editCar")
	/**
	 * 
	 * @param currentLicensePlateNumber
	 * @return
	 */
	public ModelAndView editCar(@RequestParam String currentLicensePlateNumber) {
		System.out.println("licensePlateNumber: " + currentLicensePlateNumber);
		Car currentCar = null;
		boolean flag = false;
		ModelAndView modelAndView = null;
		for (Car car : carDataMapper.getAllCars()) {
			if (car.getLicensePlateNumber().equals(currentLicensePlateNumber)) {
				currentCar = car;
				break;
			}
		}
		List<RentedCar> renCars = rentedCarDataMapper.getAllRentedCars();
		List<ReservedCar> resCars = reservedCarMapper.getAllReservedCars();
		for (ReservedCar reservedCar : resCars) {
			if (reservedCar.getCar().equals(currentCar)) {
				flag = true;
				break;
			}
		}
		for (RentedCar rentedCar : renCars) {
			if (rentedCar.getCar().equals(currentCar)) {
				flag = true;
				break;
			}
		}

		modelAndView = new ModelAndView("EditCarPage", "car", currentCar);
		if (flag) {

			modelAndView.addObject("editDecide", "Cannot Edit Car Details, Car cuurently Booked");

			modelAndView.addObject("readOnly", "readonly");
			modelAndView.addObject("disableOrNo", "disabled");

		} else {
			modelAndView.addObject("editDecide", "Edit Car Details");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/saveCarChanges", method = RequestMethod.POST)
	/**
	 * 
	 * @param car
	 * @return
	 */
	public ModelAndView saveCarChanges(Car car) {

		for (Car currentCar : carDataMapper.getAllCars()) {
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
		return new ModelAndView("AdminCarCatalogPage", "cars", carDataMapper.getAllCars());
	}

	@RequestMapping(value = "/deleteCar")
	public ModelAndView deleteCar(@RequestParam String currentLicensePlateNumber) {

		boolean flag = false;
		ModelAndView modelAndView = null;
		Car currentCar = null;
		for (Car car : carDataMapper.getAllCars()) {
			if (car.getLicensePlateNumber().equals(currentLicensePlateNumber)) {
				currentCar = car;
				break;
			}
		}
		List<RentedCar> renCars = rentedCarDataMapper.getAllRentedCars();
		List<ReservedCar> resCars = reservedCarMapper.getAllReservedCars();

		for (ReservedCar reservedCar : resCars) {
			if (reservedCar.getCar().equals(currentCar)) {
				flag = true;
				break;
			}
		}
		for (RentedCar rentedCar : renCars) {
			if (rentedCar.getCar().equals(currentCar)) {
				flag = true;
				break;
			}
		}
		List<Car> allCars = carDataMapper.getAllCars();
		if (flag) {

			modelAndView = new ModelAndView("AdminCarCatalogPage", "cars", allCars);
			modelAndView.addObject("errorMessage", "Cannot delete vehicle now  as it is currently booked");
			return modelAndView;
		} else {

			allCars.remove(currentCar);
			return new ModelAndView("AdminCarCatalogPage", "cars", allCars);
		}
	}

	@RequestMapping(value = "/backToAdminReservedCarList")
	public ModelAndView showAdminReservedCarsPage() {

		ModelAndView modelAndView = new ModelAndView("AdminViewReservedTransactions");
		DataStore ds = DataStore.getInstance();
		modelAndView.addObject("reservations", reservedCarMapper.getAllReservedCars());
		return modelAndView;

	}

	@RequestMapping(value = "/backToAdminRentedCarList")
	public ModelAndView showAdminRentedCarsPage() {

		ModelAndView modelAndView = new ModelAndView("AdminViewRentalTransactions");
		DataStore ds = DataStore.getInstance();
		modelAndView.addObject("rentals", rentedCarDataMapper.getAllRentedCars());
		return modelAndView;

	}

	@RequestMapping(value = "/backToAdminCarCatalog")
	public ModelAndView goToAdminCarCatalog() {

		ModelAndView modelAndView = new ModelAndView("AdminCarCatalogPage", "cars",
				carDataMapper.getAllCars());

		DataStore ds = DataStore.getInstance();
		List<Car> carsList = ds.getAllCars();

		modelAndView.addObject("cars", carsList);

		return modelAndView;
	}

	@RequestMapping(value = "/filterReservationRecordsForAdmin", method = RequestMethod.POST)
	/**
	 * 
	 * @param licensePlateNumberInput
	 * @param drivingLicenseNumberInput
	 * @param dueDateFilter
	 * @param pickupDateFilter
	 * @return
	 */
	public ModelAndView filterReservationRecordsForAdmin(@RequestParam String licensePlateNumberInput,
			@RequestParam String drivingLicenseNumberInput,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dueDateFilter,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate pickupDateFilter) {
		
		System.out.println("licensePlateNumberInput: " + licensePlateNumberInput);
		ModelAndView modelAndView = new ModelAndView("AdminViewReservedTransactions");

		List<ReservedCar> reservedCars = reservedCarMapper.getAllReservedCars();

		List<ReservedCar> reservedCarsToSend = new ArrayList<>();

		for (ReservedCar car : reservedCars) {

			if (!StringUtils.isEmpty(licensePlateNumberInput)
					&& !licensePlateNumberInput.equals(car.getCar().getLicensePlateNumber())) {
				continue;
			}

			if (!StringUtils.isEmpty(drivingLicenseNumberInput)
					&& !drivingLicenseNumberInput.equals(car.getAssociatedClient().getDriverLicenceNumber())) {
				continue;
			}

			if (dueDateFilter != null && !dueDateFilter.equals(car.getDueDate())) {
				continue;
			}

			if (pickupDateFilter != null && !pickupDateFilter.equals(car.getStartDate())) {
				continue;
			}
			reservedCarsToSend.add(car);

		}

		modelAndView.addObject("reservations", reservedCarsToSend);
		return modelAndView;

	}
/**
 * 
 * @param licensePlateNumberInput
 * @param drivingLicenseNumberInput
 * @param dueDateFilter
 * @param pickupDateFilter
 * @return
 */
	@RequestMapping(value = "/filterRentalRecordsForAdmin", method = RequestMethod.POST)
	public ModelAndView filterRentalRecordsForAdmin(@RequestParam String licensePlateNumberInput,
			@RequestParam String drivingLicenseNumberInput,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dueDateFilter,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate pickupDateFilter) {
		
		System.out.println("licensePlateNumberInput: " + licensePlateNumberInput);

		ModelAndView modelAndView = new ModelAndView("AdminViewRentalTransactions");
		List<RentedCar> rentals = DataStore.getInstance().getRentedCars();

		List<RentedCar> rentalsToSend = new ArrayList<>();

		for (RentedCar rental : rentals) {
			if (!StringUtils.isEmpty(licensePlateNumberInput)
					&& !licensePlateNumberInput.equals(rental.getCar().getLicensePlateNumber())) {
//				System.out.println("setting model add false");
				continue;
			}

			if (!StringUtils.isEmpty(drivingLicenseNumberInput)
					&& !drivingLicenseNumberInput.equals(rental.getAssociatedClient().getDriverLicenceNumber())) {
//				System.out.println("setting model add false");
				continue;
			}

			if (dueDateFilter != null && !dueDateFilter.equals(rental.getDueDate())) {
//				System.out.println("setting model add false");
				continue;
			}

			if (pickupDateFilter != null && !pickupDateFilter.equals(rental.getStartDate())) {
//				System.out.println("setting model add false");
				continue;
			}
			rentalsToSend.add(rental);

		}

		modelAndView.addObject("rentals", rentalsToSend);
		return modelAndView;

	}
}
