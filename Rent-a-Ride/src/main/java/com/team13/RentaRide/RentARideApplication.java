package com.team13.RentaRide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.team13.RentaRide.utils.DataStore;

@SpringBootApplication
public class RentARideApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentARideApplication.class, args);
		DataStore ds = DataStore.getInstance();
	}
	
	
	
}