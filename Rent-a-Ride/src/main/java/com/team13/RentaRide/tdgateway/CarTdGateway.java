package com.team13.RentaRide.tdgateway;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import com.team13.RentaRide.utils.DatabaseUtils;

public class CarTdGateway {

	public boolean insertCarRecord(Map<String, Object> parameterMap) {

		Connection connection = DatabaseUtils.getDbConnection();
		String query = "INSERT INTO Car VALUES (default, ?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
		} catch (SQLException e1) {
			System.out.println(DatabaseUtils.CREATE_STATEMENT_ERROR_MESSAGE);
			e1.printStackTrace();
			return false;
		}
		try {
			
			statement.setInt(1, (Integer) parameterMap.get("CAR_ID"));
			statement.setString(2, (String) parameterMap.get("LICENSE_PLATE_NUMBER"));
			statement.setString(3, (String) parameterMap.get("MAKE"));
			statement.setString(4, (String) parameterMap.get("MODEL"));
			statement.setString(5, (String) parameterMap.get("TYPE"));
			
			statement.setString(6, (String) parameterMap.get("COLOR"));
			statement.setInt(7, (Integer) parameterMap.get("YEAR"));
			statement.setString(8, (String) parameterMap.get("DESCRIPTION"));
			statement.setBigDecimal(9, (BigDecimal) parameterMap.get("PRICE"));
			statement.setString(10, (String) parameterMap.get("AVAILABLE_RESERVED_RENTED"));
			
			
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

}

