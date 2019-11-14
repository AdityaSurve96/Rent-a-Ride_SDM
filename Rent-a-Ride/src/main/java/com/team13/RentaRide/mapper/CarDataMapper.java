package com.team13.RentaRide.mapper;

import java.util.HashMap;

import com.team13.RentaRide.model.Car;
import com.team13.RentaRide.tdgateway.CarTdGateway;

public class CarDataMapper {
	
	CarTdGateway carGateway = new CarTdGateway();

	public boolean addCarRecord(Car carObj) {
		try {
			HashMap<String, Object> parameterMap = new HashMap<>();

			parameterMap.put("CAR_ID", carObj.getId());
			parameterMap.put("LICENSE_PLATE_NUMBER", carObj.getLicensePlateNumber());
			parameterMap.put("MAKE", carObj.getMake());
			parameterMap.put("MODEL", carObj.getModel());
			parameterMap.put("TYPE", carObj.getType());
			parameterMap.put("COLOR", carObj.getColor());
			parameterMap.put("YEAR", carObj.getYear());
			parameterMap.put("DESCRIPTION", carObj.getDescription());
			parameterMap.put("PRICE", carObj.getPrice());
			parameterMap.put("AVAILABLE_RESERVED_RENTED", carObj.getAvailableReservedOrRented());



			return carGateway.insertCarRecord(parameterMap);
		} catch (Exception e) {
			System.out.println("Error while inserting a reserved car record in the database");
			e.printStackTrace();
			return false;
		}
	}

}
