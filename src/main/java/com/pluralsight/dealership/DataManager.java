package com.pluralsight.dealership;

import java.sql.*;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


public class DataManager {

    private DataSource dataSource;

    public DataManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Vehicle> getVehicleByRange(double minPrice, double maxPrice) {

        List<Vehicle> vehicleList = new ArrayList<>();

        String sql = "SELECT * FROM vehicles v\n" +
                "JOIN sales_contracts s ON v.VIN = s.VIN\n" +
                "WHERE sale_price BETWEEN ? AND ?;";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setDouble(1, minPrice);
            preparedStatement.setDouble(2,maxPrice);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int vehicleId = resultSet.getInt("vehicle_id");
                int year = resultSet.getInt("year");
                int mileage = resultSet.getInt("mileage");
                int sold = resultSet.getInt("SOLD");

                String VIN = resultSet.getString("VIN");
                String make = resultSet.getString("make");
                String model = resultSet.getString("model");
                String color = resultSet.getString("Color");
                String fuelType = resultSet.getString("fuel_type");
                String transmissionType = resultSet.getString("transmission_type");

               Vehicle vehicle = new Vehicle(vehicleId,year,  mileage,  sold,  VIN,  make,  model,  color,  fuelType,  transmissionType);
               vehicleList.add(vehicle);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return vehicleList;



    }
    public List<Vehicle> getVehicleByMakeModel(String inputMake, String inputModel) {

        List<Vehicle> vehicleList = new ArrayList<>();

        String sql = "SELECT * FROM vehicles \n" +
                "WHERE make = ? AND model = ?;";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1,inputMake);
            preparedStatement.setString(2,inputModel);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int vehicleId = resultSet.getInt("vehicle_id");
                int year = resultSet.getInt("year");
                int mileage = resultSet.getInt("mileage");
                int sold = resultSet.getInt("SOLD");

                String VIN = resultSet.getString("VIN");
                String make = resultSet.getString("make");
                String model = resultSet.getString("model");
                String color = resultSet.getString("Color");
                String fuelType = resultSet.getString("fuel_type");
                String transmissionType = resultSet.getString("transmission_type");

                Vehicle vehicle = new Vehicle(vehicleId,year,  mileage,  sold,  VIN,  make,  model,  color,  fuelType,  transmissionType);
                vehicleList.add(vehicle);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return vehicleList;



    }
    public List<Vehicle> getVehicleByYearRange(int minYear, int maxYear) {

        List<Vehicle> vehicleList = new ArrayList<>();

        String sql = "SELECT * FROM vehicles v\n" +
                "WHERE year BETWEEN ? AND ?;";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1,minYear);
            preparedStatement.setInt(2,maxYear);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int vehicleId = resultSet.getInt("vehicle_id");
                int year = resultSet.getInt("year");
                int mileage = resultSet.getInt("mileage");
                int sold = resultSet.getInt("SOLD");

                String VIN = resultSet.getString("VIN");
                String make = resultSet.getString("make");
                String model = resultSet.getString("model");
                String color = resultSet.getString("Color");
                String fuelType = resultSet.getString("fuel_type");
                String transmissionType = resultSet.getString("transmission_type");


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return vehicleList;



    }

    public void addVehicle(int year, int mileage, int sold, String VIN, String make, String model, String color, String fuelType, String transmissionType) throws SQLException {
        String insert = "INSERT INTO vehicles (year,  mileage,  sold,  VIN,  make,  model,  Color,  fuel_type,  transmission_type) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insert)) {

            preparedStatement.setInt(1, year);
            preparedStatement.setInt(2, mileage);
            preparedStatement.setInt(3, sold);
            preparedStatement.setString(4, VIN);
            preparedStatement.setString(5, make);
            preparedStatement.setString(6, model);
            preparedStatement.setString(7, color);
            preparedStatement.setString(8, fuelType);
            preparedStatement.setString(9, transmissionType);
            // Execute the insert
            int rows = preparedStatement.executeUpdate();

            Vehicle vehicle = new Vehicle(vehicleId,year,  mileage,  sold,  VIN,  make,  model,  color,  fuelType,  transmissionType);
            vehicleList.add(vehicle);

            System.out.printf("Rows updated: %d\n", rows);

            // Retrieve the auto-generated keys
//            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
//                if (generatedKeys.next()) {
//                    int shipperID = generatedKeys.getInt(1);
//                    System.out.println("Generated ShipperID: " + shipperID);
//                } else {
//                    System.out.println("Failed to retrieve the generated ShipperID.");
//                }
//            }
        }
    }



//    public void deleteVehicle(String vin) throws SQLException {
//
//        String delete = "DELETE FROM vehicles WHERE VIN = ?";
//
//        try(Connection connection = dataSource.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(delete)){
//
//
//
//            int rows = preparedStatement.executeUpdate();
//
//            System.out.printf("Rows deleted %d\n", rows);
//        }

    }



}
