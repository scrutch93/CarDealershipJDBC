package com.pluralsight.dealership;

import org.apache.commons.dbcp2.BasicDataSource;

import java.util.ArrayList;
import java.util.List;

public class App
{
    static BasicDataSource dataSource;

    public static void main( String[] args )
    {
        String username = "root";
        String password = System.getenv("MY_DB_PASSWORD");

        dataSource = new BasicDataSource();

        dataSource.setUrl("jdbc:mysql://localhost:3306/cardealerships");
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        DataManager dataManager = new DataManager(dataSource);

//        List<Vehicle> vehicles = dataManager.getVehicleByRange(0, 25000.00);
//
//       vehicles.forEach(System.out::println);

        UserInterface userInterface = new UserInterface();

        userInterface.home();

    }
}
