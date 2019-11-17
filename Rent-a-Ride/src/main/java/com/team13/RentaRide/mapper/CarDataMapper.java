package com.team13.RentaRide.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.team13.RentaRide.model.Car;
import com.team13.RentaRide.tdgateway.CarTdGateway;
import com.team13.RentaRide.utils.DatabaseUtils;

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

	public boolean deleteCarRecord(String carLicensePlateNumber) {
		try {

			return carGateway.deleteCarRecord(carLicensePlateNumber);

		} catch (Exception e) {
			System.out.println("Error while deleting a car record in the database");
			e.printStackTrace();
			return false;
		}
	}

	public boolean modifyCarRecord(Car carObj) {
		try {
			HashMap<String, Object> parameterMap = new HashMap<>();

			if (carObj.getYear() == null && carObj.getColor() == null) {
				parameterMap.put("AVAILABLE_RESERVED_RENTED", carObj.getAvailableReservedOrRented());
			} else {
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
			}
			return carGateway.modifyCarRecord(parameterMap);

		} catch (Exception e) {
			System.out.println("Error while modifying a car record in the database");
			e.printStackTrace();
			return false;
		}
	}

	public List<Car> getAllCars() {

		ResultSet resultSet = carGateway.findAllCars();

		if (resultSet == null) {
			return new ArrayList<Car>();
		}

		List<Car> allCars = new ArrayList<Car>();

		try {
			allCars = parseResultSet(resultSet);
		} catch (Exception e) {
			System.out.println(DatabaseUtils.QUERY_EXECUTION_ERROR_MESSAGE);
			e.printStackTrace();
			return new ArrayList<Car>();
		}

		return allCars;

	}

	public List<Car> parseResultSet(ResultSet resultSet) throws SQLException {

		List<Car> allCars = new ArrayList<Car>();

		while (resultSet.next()) {

			Car car = new Car();
			car.setId(resultSet.getInt(1));
			car.setLicensePlateNumber(resultSet.getString(2));
			car.setMake(resultSet.getString(3));
			car.setModel(resultSet.getString(4));
			car.setType(resultSet.getString(5));
			car.setColor(resultSet.getString(6));
			car.setYear(resultSet.getInt(7));
			car.setDescription(resultSet.getString(8));
			car.setPrice(resultSet.getBigDecimal(9));
			car.setAvailableReservedOrRented(resultSet.getString(10));

			allCars.add(car);

		}
		return allCars;

	}

	public Car getCarByLicenseNumber(String licensePlateNumber) {
		ResultSet result = carGateway.getCarByLicensePlateNumber(licensePlateNumber);
		Car car = new Car();
		try {
			car.setId(result.getInt(1));
			car.setLicensePlateNumber(licensePlateNumber);
			car.setMake(result.getString(3));
			car.setModel(result.getString(4));
			car.setType(result.getString(5));
			car.setColor(result.getString(6));
			car.setYear(result.getInt(7));
			car.setDescription(result.getString(8));
			car.setPrice(result.getBigDecimal(9));
			car.setAvailableReservedOrRented(result.getString(10));
			return car;
		} catch (SQLException e) {
			System.out.println("Error while setting parameters to ");
			e.printStackTrace();
			return null;
		}

	}

}
