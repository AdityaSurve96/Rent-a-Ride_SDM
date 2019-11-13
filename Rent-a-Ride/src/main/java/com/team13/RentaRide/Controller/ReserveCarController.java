package com.team13.RentaRide.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team13.RentaRide.mapper.ReservedCarDataMapper;
import com.team13.RentaRide.model.Car;
import com.team13.RentaRide.model.Client;
import com.team13.RentaRide.model.RentedCar;
import com.team13.RentaRide.model.ReservedCar;
import com.team13.RentaRide.utils.DataStore;

@Controller
public class ReserveCarController {

	String page = null;
	ReservedCarDataMapper reservedCarMapper = new ReservedCarDataMapper();

	@RequestMapping(value = "/rentThisCar")
	public ModelAndView showCarRentingPage(@RequestParam String licensePlate) {
		DataStore ds = DataStore.getInstance();
		List<Car> carsList = ds.getAllCars();
		page = "CreateRental";
		Car c = null;
		for (Car car : carsList) {
			if (car.getLicensePlateNumber().equals(licensePlate)) {

				c = car;
				break;

			}
		}

		ModelAndView modelAndView;
		modelAndView = new ModelAndView("RentCarForClient");
		modelAndView.addObject("licensePlateNumber", c.getLicensePlateNumber());
		modelAndView.addObject("pickUpDate", LocalDate.now());
		return modelAndView;

	}

	@RequestMapping(value = "/reserveThisCar")
	public ModelAndView showCarReservingPage(@RequestParam String licensePlate) {
		DataStore ds = DataStore.getInstance();
		List<Car> carsList = ds.getAllCars();
		page = "CreateReservation";
		Car c = null;
		for (Car car : carsList) {
			if (car.getLicensePlateNumber().equals(licensePlate)) {

				c = car;
				break;

			}
		}

		ModelAndView modelAndView;
		modelAndView = new ModelAndView("ReserveCarForClient");
		modelAndView.addObject("licensePlateNumber", c.getLicensePlateNumber());
		return modelAndView;

	}

	@RequestMapping(value = "/searchThisClient", method = RequestMethod.POST)
	public ModelAndView searchClient(@RequestParam String driverLicenceNumber, @RequestParam String CarLicenseNo) {
		ModelAndView modelAndView = null;
		System.out.println(CarLicenseNo);
		Client c = null;
		DataStore ds = DataStore.getInstance();
		List<Client> clients = ds.getAllClients();
		boolean flag = false;
		for (Client client : clients) {
			String clientsDriverLicenceNumber = client.getDriverLicenceNumber();
			if (clientsDriverLicenceNumber.equals(driverLicenceNumber)) {
				c = client;
				flag = true;
				break;

			}

		}
		if (flag) {
			if (page == "CreateReservation") {
				modelAndView = new ModelAndView("ReserveCarForClient");

			} else if (page == "CreateRental") {
				modelAndView = new ModelAndView("RentCarForClient");
				modelAndView.addObject("pickUpDate", LocalDate.now());
			}

			modelAndView.addObject("licensePlateNumber", CarLicenseNo);
			modelAndView.addObject("driverLicenseNumber", c.getDriverLicenceNumber());
			modelAndView.addObject("clientFirstName", c.getClientFirstName());
			modelAndView.addObject("clientLastName", c.getClientLastName());
			modelAndView.addObject("phoneNumber", c.getPhoneNumber());
			modelAndView.addObject("licenceExpiryDate", c.getLicenceExpiryDate());
			return modelAndView;
		} else {
			if (page == "CreateReservation") {
				modelAndView = new ModelAndView("ReserveCarForClient");
			} else if (page == "CreateRental") {
				modelAndView = new ModelAndView("RentCarForClient");
				modelAndView.addObject("pickUpDate", LocalDate.now());
			}

			modelAndView.addObject("licensePlateNumber", CarLicenseNo);
			modelAndView.addObject("driverLicenseNumber", driverLicenceNumber);
			modelAndView.addObject("clientNotFoundMessage",
					"Client does not exist already. Please enter the client details manually");
			return modelAndView;
		}

	}

	@RequestMapping(value = "/carReserved", method = RequestMethod.POST)
	public ModelAndView showReservedCars(@RequestParam String clientFirstName, @RequestParam String clientLastName,
			@RequestParam String phoneNumber, @RequestParam String driverLicenceNumber,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate licenceExpiryDate,

			@RequestParam String CarLicenseNo,

			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dropoffDate,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate pickupDate) {

		System.out.println(dropoffDate);

		String licnum = CarLicenseNo;
		DataStore ds = DataStore.getInstance();
		List<Car> carsList = ds.getAllCars();

		Car c = null;

		for (Car car : carsList) {
			String lic = car.getLicensePlateNumber();

			if (lic.equals(licnum)) {
				car.setAvailableReservedOrRented("Reserved");
				c = car;
				break;

			}
		}

		List<Client> existingClients = ds.getAllClients();
		Client cl = null;
		List<ReservedCar> resCars = reservedCarMapper.getAllReservedCars();
		boolean flag = false;
		for (Client client : existingClients) {
			if (client.getDriverLicenceNumber().equals(driverLicenceNumber)) {
				flag = true;
				cl = client;
				break;
			}
		}

		if (!flag) {
			cl = new Client();
			cl.setClientFirstName(clientFirstName);
			cl.setClientLastName(clientLastName);
			cl.setPhoneNumber(phoneNumber);
			cl.setDriverLicenceNumber(driverLicenceNumber);
			cl.setLicenceExpiryDate(licenceExpiryDate);
		}

		ReservedCar resCar = new ReservedCar(c, cl, pickupDate, dropoffDate, null, new Date());

		Date d1;
		Date d2;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String d = null;
		d1 = new Date();
		d = sdf.format(d1);
		try {
			d2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(d);
			resCar.setBookingTimestamp(d2);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		resCars.add(resCar);
		ModelAndView modelAndView = new ModelAndView("ViewReservedTransactions", "reservations", resCars);

		return modelAndView;

	}

	@RequestMapping(value = "/cancelThisReservation")
	public ModelAndView cancelSelectedReservation(@RequestParam String carLicencePlateNumber) {

		DataStore ds = DataStore.getInstance();
		List<ReservedCar> resCars = ds.getReservedCars();
		List<Car> allCars = ds.getAllCars();
		for (ReservedCar reservedCar : resCars) {
			if (reservedCar.getCar().getLicensePlateNumber().equals(carLicencePlateNumber)) {
				for (Car car : allCars) {
					if (car.equals(reservedCar.getCar())) {
						car.setAvailableReservedOrRented("Available");
						resCars.remove(reservedCar);
						break;
					}
				}

			}
			break;
		}

		ModelAndView modelAndView = new ModelAndView("ViewReservedTransactions", "reservations", resCars);
		return modelAndView;
	}

	@RequestMapping(value = "/handleTheReturnThisRental")
	public ModelAndView returnSelectedRental(@RequestParam String carLicencePlateNumber) {

		DataStore ds = DataStore.getInstance();
		List<RentedCar> renCars = ds.getRentedCars();
		List<Car> allCars = ds.getAllCars();
		for (RentedCar rentedCar : renCars) {
			if (rentedCar.getCar().getLicensePlateNumber().equals(carLicencePlateNumber)) {
				for (Car car : allCars) {
					if (car.equals(rentedCar.getCar())) {
						car.setAvailableReservedOrRented("Available");
						renCars.remove(rentedCar);
						break;
					}
				}

			}
			break;
		}

		ModelAndView modelAndView = new ModelAndView("ViewRentalTransactions", "rentals", renCars);
		return modelAndView;
	}

	@RequestMapping(value = "/carRented", method = RequestMethod.POST)
	public ModelAndView showRentedCars(@RequestParam String clientFirstName, @RequestParam String clientLastName,
			@RequestParam String phoneNumber, @RequestParam String driverLicenceNumber,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate licenceExpiryDate,

			@RequestParam String CarLicenseNo,

			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dropoffDate,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate pickupDate) {

		System.out.println(dropoffDate);

		String licnum = CarLicenseNo;
		DataStore ds = DataStore.getInstance();
		List<Car> carsList = ds.getAllCars();
		Car c = null;

		for (Car car : carsList) {
			String lic = car.getLicensePlateNumber();

			if (lic.equals(licnum)) {
				car.setAvailableReservedOrRented("Rented");
				c = car;
				break;

			}
		}

		List<Client> existingClients = ds.getAllClients();
		Client cl = null;
		List<RentedCar> renCars = ds.getRentedCars();
		boolean flag = false;
		for (Client client : existingClients) {
			if (client.getDriverLicenceNumber().equals(driverLicenceNumber)) {
				flag = true;
				cl = client;
				break;
			}
		}

		if (!flag) {
			cl = new Client();
			cl.setClientFirstName(clientFirstName);
			cl.setClientLastName(clientLastName);
			cl.setPhoneNumber(phoneNumber);
			cl.setDriverLicenceNumber(driverLicenceNumber);
			cl.setLicenceExpiryDate(licenceExpiryDate);
		}

		RentedCar renCar = new RentedCar(c, cl, pickupDate, dropoffDate, 1000, new Date());

		Date d1;
		Date d2;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String d = null;
		d1 = new Date();
		d = sdf.format(d1);
		try {
			d2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(d);
			renCar.setBookingTimestamp(d2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		renCars.add(renCar);
		ModelAndView modelAndView = new ModelAndView("ViewRentalTransactions", "rentals", renCars);

		return modelAndView;

	}

	@RequestMapping(value = "/backToCarCatalog")
	public ModelAndView goToCarCatalog() {

		ModelAndView modelAndView = new ModelAndView("CarCatalog");

		DataStore ds = DataStore.getInstance();
		List<Car> carsList = ds.getAllCars();

		modelAndView.addObject("cars", carsList);

		return modelAndView;

	}

	@RequestMapping(value = "/backToRentedCarList")
	public ModelAndView showRentedCarsPage() {

		ModelAndView modelAndView = new ModelAndView("ViewRentalTransactions");
		DataStore ds = DataStore.getInstance();
		modelAndView.addObject("rentals", ds.getRentedCars());
		return modelAndView;

	}

	@RequestMapping(value = "/backToReservedCarList")
	public ModelAndView showReservedCarsPage() {

		ModelAndView modelAndView = new ModelAndView("ViewReservedTransactions");
		DataStore ds = DataStore.getInstance();
		modelAndView.addObject("reservations", ds.getReservedCars());
		return modelAndView;

	}

}
