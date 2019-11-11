package com.team13.RentaRide;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.team13.RentaRide.utils.PropertyFileReaderUtils;

@SpringBootApplication
public class RentARideApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentARideApplication.class, args);
		testDb();

	}

	private static void testDb() {
		Properties dbProperties = PropertyFileReaderUtils.getProperties();

		String user = dbProperties.getProperty("db.username");
		String password = dbProperties.getProperty("db.password");
		String schemaName = dbProperties.getProperty("db.schema");
		String url = "jdbc:mysql://localhost:3306/" + schemaName + "?useSSL=false";

		String author = "Trygve Gulbranssen";
		String sql = "INSERT INTO Authors(Name) VALUES(?)";

		try (Connection con = DriverManager.getConnection(url, user, password);
				PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, author);
			pst.executeUpdate();

			System.out.println("A new author has been inserted");

		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}

}