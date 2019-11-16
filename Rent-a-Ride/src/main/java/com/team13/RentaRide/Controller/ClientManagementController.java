package com.team13.RentaRide.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team13.RentaRide.model.Client;
import com.team13.RentaRide.utils.DataStore;
/**
 * 
 * @author Admin
 *
 */

@Controller

public class ClientManagementController {
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/createNewClient")
	public ModelAndView createClientRecord() {

		ModelAndView modelAndView = new ModelAndView("CreateNewClientRecord");

		return modelAndView;
	}
/**
 * 
 * @param driverLicenceNumber
 * @param clientFirstName
 * @param clientLastName
 * @param phoneNumber
 * @param licenceExpiryDate
 * @return
 */
	@RequestMapping("/goToClientManagementPageAfterCreation")
	public ModelAndView confirmCreationOfClient(@RequestParam String driverLicenceNumber,
			@RequestParam String clientFirstName, @RequestParam String clientLastName, @RequestParam String phoneNumber,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate licenceExpiryDate) {
		Client c = new Client();
		c.setClientFirstName(clientFirstName);
		c.setClientLastName(clientLastName);
		c.setDriverLicenceNumber(driverLicenceNumber);
		c.setLicenceExpiryDate(licenceExpiryDate);
		c.setPhoneNumber(phoneNumber);

		DataStore ds = DataStore.getInstance();
		ds.getAllClients().add(c);
		ModelAndView modelAndView = new ModelAndView("ClientManagementPage", "clients", ds.getAllClients());

		return modelAndView;
	}
/**
 * 
 * @param driverLicenceNumberForModify
 * @return
 */
	@RequestMapping("/gotoModifyClientRecord")
	public ModelAndView showClientModificationPage(@RequestParam String driverLicenceNumberForModify) {

		Client c = null;
		DataStore ds = DataStore.getInstance();
		List<Client> clients = ds.getAllClients();

		for (Client client : clients) {
			String clientsDriverLicenceNumber = client.getDriverLicenceNumber();
			if (clientsDriverLicenceNumber.equals(driverLicenceNumberForModify)) {
				c = client;

				break;
			}
		}
		ModelAndView modelAndView = new ModelAndView("ModifyClientRecord", "client", c);

		return modelAndView;
	}
/**
 * 
 * @param driverLicenceNumberForDelete
 * @return
 */
	@RequestMapping("/gotoDeleteClientRecord")
	public ModelAndView deleteClientRecord(@RequestParam String driverLicenceNumberForDelete) {

		DataStore ds = DataStore.getInstance();
		List<Client> clients = ds.getAllClients();
		for (Client client : clients) {
			if (client.getDriverLicenceNumber().equals(driverLicenceNumberForDelete)) {
				clients.remove(client);
				break;
			}
		}
		ModelAndView modelAndView = new ModelAndView("ClientManagementPage", "clients", clients);

		return modelAndView;
	}
/**
 * 
 * @param driverLicenseNumber
 * @param clientFirstName
 * @param clientLastName
 * @param phoneNumber
 * @param licenceExpiryDate
 * @return
 */
	@RequestMapping(value = "/gotoClientManagementPageAfterModification", method = RequestMethod.POST)
	public ModelAndView confirmClientRecordModify(@RequestParam String driverLicenseNumber,
			@RequestParam String clientFirstName, @RequestParam String clientLastName, @RequestParam String phoneNumber,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate licenceExpiryDate) {

		for (Client currentClient : DataStore.getInstance().getAllClients()) {
			if (currentClient.getDriverLicenceNumber().equals(driverLicenseNumber)) {
				currentClient.setClientFirstName(clientFirstName);
				currentClient.setClientLastName(clientLastName);
				currentClient.setDriverLicenceNumber(driverLicenseNumber);
				currentClient.setLicenceExpiryDate(licenceExpiryDate);
				currentClient.setPhoneNumber(phoneNumber);

				break;
			}
		}

		ModelAndView modelAndView = new ModelAndView("ClientManagementPage", "clients",
				DataStore.getInstance().getAllClients());

		return modelAndView;
	}

}
