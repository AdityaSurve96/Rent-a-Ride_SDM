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

import com.team13.RentaRide.mapper.CarDataMapper;
import com.team13.RentaRide.mapper.ClientDataMapper;
import com.team13.RentaRide.mapper.RentedCarDataMapper;
import com.team13.RentaRide.mapper.ReservedCarDataMapper;
import com.team13.RentaRide.model.Car;
import com.team13.RentaRide.model.Client;
import com.team13.RentaRide.model.RentedCar;
import com.team13.RentaRide.model.ReservedCar;
import com.team13.RentaRide.utils.DataStore;

/**
 * 
 * @author Admin
 *
 */

@Controller
public class ReservationAndRentalController {

	ClientDataMapper clientDataMapper = new ClientDataMapper();
	CarDataMapper carDataMapper = new CarDataMapper();
	RentedCarDataMapper rentedCarDataMapper = new RentedCarDataMapper();

	String page = null;

	ReservedCarDataMapper reservedCarMapper = new ReservedCarDataMapper();

	/**
	 * 
	 * @param licensePlate
	 * @return
	 */

	@RequestMapping(value = "/rentThisCar")
	public ModelAndView showCarRentingPage(@RequestParam String licensePlate) {
		ModelAndView modelAndView;
		modelAndView = new ModelAndView("RentCarForClient");
		modelAndView.addObject("licensePlateNumber", licensePlate);
		modelAndView.addObject("pickUpDate", LocalDate.now());
		return modelAndView;
	}

	/**
	 * 
	 * @param licensePlate
	 * @return
	 */
	@RequestMapping(value = "/reserveThisCar")
	public ModelAndView showCarReservingPage(@RequestParam String licensePlate) {
		ModelAndView modelAndView;
		modelAndView = new ModelAndView("ReserveCarForClient");
		modelAndView.addObject("licensePlateNumber", licensePlate);
		return modelAndView;

	}

	/**
	 * 
	 * @param driverLicenceNumber
	 * @param CarLicenseNo
	 * @return
	 */
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

	/**
	 * 
	 * @param clientFirstName
	 * @param clientLastName
	 * @param phoneNumber
	 * @param driverLicenceNumber
	 * @param licenceExpiryDate
	 * @param CarLicenseNo
	 * @param dropoffDate
	 * @param pickupDate
	 * @return
	 */
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

		Client client = clientDataMapper.getClientByDrivingLicense(driverLicenceNumber);

		if (!flag) {
			cl = createNewClient(clientFirstName, clientLastName, phoneNumber, driverLicenceNumber, licenceExpiryDate);
		}

		ReservedCar resCar = new ReservedCar(null, c, cl, pickupDate, dropoffDate, new Date());

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

	/**
	 * 
	 * @param carLicencePlateNumber
	 * @return
	 */
	@RequestMapping(value = "/cancelThisReservation")
	public ModelAndView cancelSelectedReservation(@RequestParam String carLicencePlateNumber) {

		reservedCarMapper.deleteCarReservationByLicense(carLicencePlateNumber);
		List<ReservedCar> resCars = reservedCarMapper.getAllReservedCars();
		return new ModelAndView("ViewReservedTransactions", "reservations", resCars);
	}

	/**
	 * 
	 * @param carLicencePlateNumber
	 * @return
	 */
	@RequestMapping(value = "/handleTheReturnThisRental")
	public ModelAndView returnSelectedRental(@RequestParam String carLicensePlateNumber) {

		rentedCarDataMapper.handleReturnOfVehicle(carLicensePlateNumber);
		Car c = new Car();
		c.setAvailableReservedOrRented("Available");
		c.setLicensePlateNumber(carLicensePlateNumber);
		carDataMapper.modifyCarRecord(c);

		List<RentedCar> renCars = rentedCarDataMapper.getAllRentedCars();
		ModelAndView modelAndView = new ModelAndView("ViewRentalTransactions", "rentals", renCars);
		return modelAndView;
	}

	/**
	 * 
	 * @param clientFirstName
	 * @param clientLastName
	 * @param phoneNumber
	 * @param driverLicenceNumber
	 * @param licenceExpiryDate
	 * @param CarLicenseNo
	 * @param dropoffDate
	 * @param pickupDate
	 * @return
	 */
	@RequestMapping(value = "/carRented", method = RequestMethod.POST)
	public ModelAndView showRentedCars(@RequestParam String clientFirstName, @RequestParam String clientLastName,
			@RequestParam String phoneNumber, @RequestParam String driverLicenceNumber,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate licenceExpiryDate,
			@RequestParam String CarLicenseNo,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dropoffDate,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate pickupDate) {

		Car selectedCar = carDataMapper.getCarByLicenseNumber(CarLicenseNo);
		if (selectedCar == null) {
			System.out.println("No car found with license " + CarLicenseNo);
			return null;
		}
		Client selectedClient = clientDataMapper.getClientByDrivingLicense(driverLicenceNumber);
		if (selectedClient == null) {
			selectedClient = createNewClient(clientFirstName, clientLastName, phoneNumber, driverLicenceNumber,
					licenceExpiryDate);
		}

		RentedCar rentedCar = createRentedCarObject(dropoffDate, pickupDate, selectedCar, selectedClient);
		rentedCarDataMapper.addRentedCarRecord(rentedCar);
		return new ModelAndView("ViewRentalTransactions", "rentals", reservedCarMapper.getAllReservedCars());

	}

	private RentedCar createRentedCarObject(LocalDate dropoffDate, LocalDate pickupDate, Car selectedCar,
			Client selectedClient) {
		RentedCar renCar = new RentedCar(null, selectedCar, selectedClient, pickupDate, dropoffDate, new Date());
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
			System.out.println("Error while setting booking date time");
			e.printStackTrace();
		}
		return renCar;
	}

	private Client createNewClient(String clientFirstName, String clientLastName, String phoneNumber,
			String driverLicenceNumber, LocalDate licenceExpiryDate) {
		Client selectedClient;
		selectedClient = new Client();
		selectedClient.setClientFirstName(clientFirstName);
		selectedClient.setClientLastName(clientLastName);
		selectedClient.setPhoneNumber(phoneNumber);
		selectedClient.setDriverLicenceNumber(driverLicenceNumber);
		selectedClient.setLicenceExpiryDate(licenceExpiryDate);
		return selectedClient;
	}

	@RequestMapping(value = "/backToCarCatalog")
	public ModelAndView goToCarCatalog() {

		ModelAndView modelAndView = new ModelAndView("CarCatalog");
		modelAndView.addObject("cars", carDataMapper.getAllCars());
		return modelAndView;

	}

	@RequestMapping(value = "/backToRentedCarList")
	public ModelAndView showRentedCarsPage() {

		ModelAndView modelAndView = new ModelAndView("ViewRentalTransactions");
		modelAndView.addObject("rentals", rentedCarDataMapper.getAllRentedCars());
		return modelAndView;

	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/backToReservedCarList")
	public ModelAndView showReservedCarsPage() {

		ModelAndView modelAndView = new ModelAndView("ViewReservedTransactions");
//		DataStore ds = DataStore.getInstance();

		modelAndView.addObject("reservations", reservedCarMapper.getAllReservedCars());
		return modelAndView;

	}

}
