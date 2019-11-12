package com.team13.RentaRide;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.team13.RentaRide.tdgateway.DatabaseCreator;
import com.team13.RentaRide.utils.PropertyFileReaderUtils;

@SpringBootApplication
public class RentARideApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentARideApplication.class, args);
		DatabaseCreator.testDb();

	}

	

}