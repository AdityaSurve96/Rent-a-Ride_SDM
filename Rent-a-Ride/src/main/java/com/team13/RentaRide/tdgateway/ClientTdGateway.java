package com.team13.RentaRide.tdgateway;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Map;

import com.team13.RentaRide.utils.DatabaseUtils;

import com.team13.RentaRide.utils.DatabaseUtils;

public class ClientTdGateway {
	public boolean insertClientRecord(Map<String, Object> client_parameterMap) {

		Connection connection = DatabaseUtils.getDbConnection();
		String query = "INSERT INTO Client VALUES (default, ?,?,?,?,?)";

		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
		} catch (SQLException e1) {
			System.out.println(DatabaseUtils.CREATE_STATEMENT_ERROR_MESSAGE);
			e1.printStackTrace();
			return false;
		}
		try {
			statement.setInt(1, (Integer) client_parameterMap.get("CLIENT_ID"));
			statement.setInt(2, (Integer) client_parameterMap.get("DRIVER_LICENCE_NUMBER"));
			statement.setInt(3, (Integer) client_parameterMap.get("CLIENT_FIRST_NAME"));
			statement.setInt(4, (Integer) client_parameterMap.get("CLIENT_LAST_NAME"));
			statement.setInt(5, (Integer) client_parameterMap.get("CLIENT_PHONE_NUMBER"));
			LocalDate licenceExpiryDate = (LocalDate) client_parameterMap.get("CLIENT_LICENCE_EXPIRY_DATE");
			statement.setDate(6, java.sql.Date.valueOf(licenceExpiryDate));
			
		} catch (SQLException e) {
			System.out.println(DatabaseUtils.PARAMETER_ERROR_MESSAGE);
			e.printStackTrace();
			return false;
		}

		try {
			statement.execute();
		} catch (SQLException e) {
			System.out.println(DatabaseUtils.QUERY_EXECUTION_ERROR_MESSAGE);
			e.printStackTrace();
			return false;
		}

		System.out.println(DatabaseUtils.QUERY_SUCCESSFUL_MESSAGE);
		return true;
	}

	public ResultSet getAllClients() {

		Connection connection = DatabaseUtils.getDbConnection();
		StringBuilder query = getSelectQuery();

		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println(DatabaseUtils.CREATE_STATEMENT_ERROR_MESSAGE);
			e.printStackTrace();
			return null;
		}
		ResultSet client_resultSet = null;
		try {
			client_resultSet = statement.executeQuery(query.toString());
		} catch (SQLException e) {
			System.out.println(DatabaseUtils.QUERY_EXECUTION_ERROR_MESSAGE);
			e.printStackTrace();
			return null;
		}
		System.out.println(DatabaseUtils.QUERY_SUCCESSFUL_MESSAGE);
		return client_resultSet;
	}

	
	private StringBuilder getSelectQuery() {
		StringBuilder view_client = new StringBuilder();
		view_client.append("select * from Clients");
		return view_client;
	}


}
