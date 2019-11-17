package com.team13.RentaRide.tdgateway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
/**
 * <h3>Clerk Table Data Gateway</h3>
 * @author team 13
 */

import com.team13.RentaRide.utils.DatabaseUtils;

public class ClerkTdGateway {
	/**
	 * 
	 * @param hmClerk
	 * @throws @return
	 */

	public boolean insertClerkRecord(Map<String, Object> hmClerk) {

		Connection connection = DatabaseUtils.getDbConnection();
		String query = "INSERT INTO Clerk VALUES (default, ?,?)";

		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
		} catch (SQLException e2) {
			System.out.println(DatabaseUtils.CREATE_STATEMENT_ERROR_MESSAGE);
			e2.printStackTrace();
			return false;
		}

		try {
			statement.setString(1, (String) hmClerk.get("EMAIL"));
			statement.setString(2, (String) hmClerk.get("PASSWORD"));
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

	/**
	 * 
	 * @return
	 */

	public ResultSet getAllClerkRecords() {

		StringBuilder query = getSelectQuery();

		Connection connection = DatabaseUtils.getDbConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println(DatabaseUtils.CREATE_STATEMENT_ERROR_MESSAGE);
			e.printStackTrace();
			return null;
		}

		ResultSet resultSet = null;
		try {
			resultSet = statement.executeQuery(query.toString());
		} catch (SQLException e) {
			System.out.println(DatabaseUtils.QUERY_EXECUTION_ERROR_MESSAGE);
			e.printStackTrace();
			return null;
		}

		System.out.println(DatabaseUtils.QUERY_SUCCESSFUL_MESSAGE);
		return resultSet;
	}

	/**
	 * 
	 * @return
	 */

	private StringBuilder getSelectQuery() {
		StringBuilder query = new StringBuilder();
		query.append("select id, email, password");
		query.append(" from clerk");
		return query;
	}

	public ResultSet getClerkByEmailPassword(String email, String password) {

		StringBuilder query = getSelectQuery();
		query.append(" where email = '" + email + "'");
		query.append(" and password = '" + password + "'");
		
		Statement statement = null;
		try {
			Connection connection = DatabaseUtils.getDbConnection();
			statement = connection .createStatement();
		} catch (SQLException e) {
			System.out.println(DatabaseUtils.CREATE_STATEMENT_ERROR_MESSAGE);
			e.printStackTrace();
			return null;
		}

		ResultSet resultSet = null;
		try {
			resultSet = statement.executeQuery(query.toString());
		} catch (SQLException e) {
			System.out.println(DatabaseUtils.QUERY_EXECUTION_ERROR_MESSAGE);
			e.printStackTrace();
			return null;
		}

		System.out.println(DatabaseUtils.QUERY_SUCCESSFUL_MESSAGE);
		return resultSet;
	}

}
