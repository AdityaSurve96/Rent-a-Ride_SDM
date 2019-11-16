package com.team13.RentaRide.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.team13.RentaRide.model.Client;
import com.team13.RentaRide.tdgateway.ClientTdGateway;
import com.team13.RentaRide.utils.DatabaseUtils;

public class ClientDataMapper {
	ClientTdGateway client_gateway = new ClientTdGateway();

	public boolean addClientRecord(Client client) {
		try {
			HashMap<String, Object> client_parameterMap = new HashMap<>();
			
			client_parameterMap.put("CLIENT_ID", client.getId());
			client_parameterMap.put("DRIVER_LICENCE_NUMBER", client.getDriverLicenceNumber());
			client_parameterMap.put("CLIENT_FIRST_NAME",client.getClientFirstName() );
			client_parameterMap.put("CLIENT_LAST_NAME", client.getClientLastName());
			client_parameterMap.put("CLIENT_PHONE_NUMBER", client.getPhoneNumber());
			client_parameterMap.put("CLIENT_LICENCE_EXPIRY_DATE", client.getLicenceExpiryDate());

			return client_gateway.insertClientRecord(client_parameterMap);
		} catch (Exception e) {
			System.out.println("Error while inserting a client record in the database");
			e.printStackTrace();
			return false;
		}
	}

	
	
	
	
	public boolean deleteClientRecord(String driverLicenceNumber) {
		try {
			return client_gateway.deleteClient(driverLicenceNumber);
			
			
		} catch (Exception e) {
			System.out.println("Error while deleting a client record in the database");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean modifyClientRecord(Client client) {
			try {
				HashMap<String, Object> client_parameterMap = new HashMap<>();
				
				client_parameterMap.put("CLIENT_ID", client.getId());
				client_parameterMap.put("DRIVER_LICENCE_NUMBER", client.getDriverLicenceNumber());
				client_parameterMap.put("CLIENT_FIRST_NAME",client.getClientFirstName() );
				client_parameterMap.put("CLIENT_LAST_NAME", client.getClientLastName());
				client_parameterMap.put("CLIENT_PHONE_NUMBER", client.getPhoneNumber());
				client_parameterMap.put("CLIENT_LICENCE_EXPIRY_DATE", client.getLicenceExpiryDate());

				return client_gateway.modifyClient(client_parameterMap);
			} 
			catch (Exception e) 
			{
				System.out.println("Error while modifying a client record in the database");
				e.printStackTrace();
				return false;
			}
			
	}
	
	
	
	
	
	
	public List<Client> getAllClients(){

		ResultSet client_resultSet = client_gateway.getAllClients();
		if (client_resultSet == null) {
			return new ArrayList<>();
		}

		List<Client> client_data = new ArrayList<>();
		try {
			client_data = parseClientResultSet(client_resultSet);
		} catch (SQLException e) {
			System.out.println(DatabaseUtils.QUERY_EXECUTION_ERROR_MESSAGE);
			e.printStackTrace();
			return new ArrayList<>();
		}

		return client_data;

	}

	private List<Client> parseClientResultSet(ResultSet client_resultSet) throws SQLException {
		List<Client> client_data = new ArrayList<>();
		while (client_resultSet.next()) {

			Client client = new Client();
			client.setId(client_resultSet.getInt(1));
			client.setDriverLicenceNumber(client_resultSet.getString(2));
			client.setClientFirstName(client_resultSet.getString(3));
			client.setClientLastName(client_resultSet.getString(4));
			client.setPhoneNumber(client_resultSet.getString(5));
			client.setLicenceExpiryDate(client_resultSet.getDate(6).toLocalDate());
			
			client_data.add(client);

		}
		return client_data;
	}



}
