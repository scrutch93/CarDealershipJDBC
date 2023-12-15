package com.pluralsight.dealership;

import java.util.List;
import java.util.Scanner;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import static com.pluralsight.dealership.App.dataSource;

public class UserInterface {

    static Scanner input = new Scanner(System.in);

    static DataManager dataManager = new DataManager(dataSource);

    public void home(){
        System.out.println("Welcome to SA motors. What would you like to do?");
        System.out.println(" 1) Find vehicles within price range.");
        System.out.println(" 2) Find vehicles by make/model.");
        System.out.println(" 3) Find vehicles by year range");
        System.out.println(" 4) Find vehicles by color");
        System.out.println(" 5) Find vehicles by mileage range");
        System.out.println(" 6) Find vehicles by type(car,truck, SUV,van)");
        System.out.println(" 7) List ALL vehicles");
        System.out.println(" 8) Add a vehicle");
        System.out.println(" 9) Remove a vehicle");
        System.out.println(" 10) Quit");

       String selection = input.nextLine();

        switch (selection){
            case "1":
                priceRangeSearch();
                break;
            case "2":
                makeModelSearch();
                break;
            case "3":
                yearSearch();
                break;

            case "4":
                break;

            case "5":
                break;

            case "6":
                break;

            case "7":
                break;

            case "8":
                break;

            case "9":
                break;

            case "10":
                System.exit((0));

            default:
                System.out.println("Not a valid selection");

        }





    }
    public void priceRangeSearch(){

        System.out.println("You have opted to search by price range. ");

        System.out.println("Enter min price: ");
        double minPrice = input.nextDouble();

        System.out.println("Enter max price: ");
        double maxPrice = input.nextDouble();

        List<Vehicle> vehicleList = dataManager.getVehicleByRange(minPrice, maxPrice);

        vehicleList.forEach(System.out::println);

    }
    public void makeModelSearch(){

        System.out.println("You have opted to search by make and model. ");

        System.out.println("Enter make: ");
        String inputMake = input.next();

        System.out.println("Enter model: ");
        String inputModel = input.next();

        List<Vehicle> vehicleList = dataManager.getVehicleByMakeModel(inputMake, inputModel);

        vehicleList.forEach(System.out::println);

    }

    public void yearSearch(){

        System.out.println("You have opted to search by yeah. ");

        System.out.println("Enter min year: ");
        int minYear = input.nextInt();

        System.out.println("Enter max year: ");
        int maxYear = input.nextInt();

        List<Vehicle> vehicleList = dataManager.getVehicleByYearRange(minYear, maxYear);

        vehicleList.forEach(System.out::println);

    }

    public void addVehicle(){
        System.out.println("You have opted to add a vehicle.");

        System.out.println("Enter year: ");
        int year = input.nextInt();

        System.out.println("Enter make: ");
        String make = input.next();

        System.out.println("Enter model: ");
        String model = input.next();

        System.out.println("Enter color: ");
        String color = input.next();

        System.out.println("Enter mileage: ");
        int mileage = input.nextInt();

        System.out.println("Enter fuel type: ");
        String fuelType = input.next();

        System.out.println("Enter transmission type: ");
        String transmissionType = input.next();

        System.out.println("Enter not sold [0] or sold [1] : ");
        int sold = input.nextInt();

        System.out.println("Enter VIN: ");
        String vin = input.next();






    }



    public void removeVehicle(){
        System.out.println("You have opted to remove a vehicle.");

        System.out.println("Please enter the VIN of the vehicle you would like to delete: ");
        String vin = input.next();




    }

}
