package com.team13.RentaRide.tdgateway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.team13.RentaRide.utils.PropertyFileReaderUtils;

public class DatabaseCreator {

	public static void testDb() {
		Properties dbProperties = PropertyFileReaderUtils.getProperties();

		String user = dbProperties.getProperty("db.username");
		String password = dbProperties.getProperty("db.password");
		String schemaName = dbProperties.getProperty("db.schema");
//		String url = "jdbc:mysql://localhost:3306/" + schemaName + "?useSSL=false";
		String urlShort = "jdbc:mysql://localhost/";

		
		String createDb = "CREATE DATABASE IF NOT EXISTS RentARideDatabase";
		
		String useDb = "USE "+schemaName+";";
		
		
		String createTableAdmin  = "CREATE TABLE IF NOT EXISTS  Admin (ID int, Email varchar(255), Password varchar(255) );";
		
		
		String createTableClerk  = "CREATE TABLE IF NOT EXISTS  Clerk (ID int, Email varchar(255), Password varchar(255) );";
		
		
		String createTableCar    = "CREATE TABLE IF NOT EXISTS  Car   (ID int, licensePlateNumber varchar(30), make varchar(20), model varchar(20), type varchar(20), color varchar(20), year int(4), description varchar(255), price DECIMAL(3,2), availableReservedOrRented varchar(20));";
		
		
		String createTableClient = "CREATE TABLE IF NOT EXISTS  Client  (ID int, driverLicenceNumber varchar(30), clientFirstName varchar(30), clientLastName varchar(30), phoneNumber varchar(10), licenceExpiryDate Date);";
		
		
		try (Connection con = DriverManager.getConnection(urlShort, user, password);
				) 
		{
			
			Statement st1 = con.createStatement();
			st1.execute(createDb);	
		
			Statement st2 = con.createStatement();
			st2.execute(useDb);	
			
			Statement st3 = con.createStatement();
			st3.execute(createTableAdmin);
			
			Statement st4 = con.createStatement();
			st4.execute(createTableClerk);
			
			Statement st5 = con.createStatement();
			st5.execute(createTableCar);
			
			Statement st6 = con.createStatement();
			st6.execute(createTableClient);
			
	
			
			
			System.out.println("Tables created");

		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}
}
