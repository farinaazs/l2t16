package l2t16.l2t16;

import java.io.*;
import java.util.*;

public class QuickFoods {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("\n--------- Welcome to the Quick Foods App! ---------\n");

    try {
      Customer customer = captureCustomerDetails(sc);
      System.out.println("\n------------ Customer Details Captured ------------\n");

      Restaurant restaurant = captureRestaurantDetails(sc);
      System.out.println("\n----------- Restaurant Details Captured -----------\n");

      // Load drivers from drivers.txt
      List<Driver> drivers = Driver.loadDriversFromFile("src\\l2t16\\l2t16\\drivers-info.txt");

      // Find the most suitable driver
      Driver assignedDriver = findDriverForRestaurant(drivers, restaurant);

      // Generate invoice or handle unavailable drivers
      if (assignedDriver != null) {
        generateInvoice(customer, restaurant, assignedDriver);
      } else {
        handleUnavailableDrivers();
      }

    } catch (IOException e) {
      System.out.println("Error reading drivers or writing invoice: " + e.getMessage());
    } catch (NumberFormatException e) {
      System.out.println("Invalid input. Please enter the correct data type: " + e.getMessage());
    } finally {
      sc.close();
    }
  }

  // Capture and return Customer details.
  private static Customer captureCustomerDetails(Scanner sc) {
    System.out.println("Enter Order Number: ");
    int orderNumber = Integer.parseInt(sc.nextLine());

    System.out.println("Enter Customer Name: ");
    String customerName = sc.nextLine();

    System.out.println("Enter Customer Contact Number: ");
    int customerContactNumber = Integer.parseInt(sc.nextLine());

    System.out.println("Enter Customer Address: ");
    String customerAddress = sc.nextLine();

    System.out.println("Enter Customer Location: ");
    String customerLocation = sc.nextLine();

    System.out.println("Enter Customer Email: ");
    String customerEmail = sc.nextLine();

    return new Customer(orderNumber, customerName, customerContactNumber,
        customerAddress, customerLocation, customerEmail);
  }

  // Capture and return Restaurant details.
  private static Restaurant captureRestaurantDetails(Scanner sc) {
    System.out.println("Enter Restaurant Name: ");
    String restaurantName = sc.nextLine();

    System.out.println("Enter Restaurant Contact Number: ");
    int restaurantContactNumber = Integer.parseInt(sc.nextLine());

    System.out.println("Enter Restaurant Location: ");
    String restaurantLocation = sc.nextLine();

    System.out.println("Enter Meal Name: ");
    String mealName = sc.nextLine();

    System.out.println("Enter Special Instructions (or leave blank): ");
    String specialInstructions = sc.nextLine();

    System.out.println("Enter Meal Price: ");
    double mealPrice = Double.parseDouble(sc.nextLine());

    System.out.println("Enter Quantity: ");
    int quantity = Integer.parseInt(sc.nextLine());

    return new Restaurant(restaurantName, restaurantContactNumber, restaurantLocation, mealName,
        specialInstructions, mealPrice, quantity);
  }

  // Find driver for restaurant.
  private static Driver findDriverForRestaurant(List<Driver> drivers, Restaurant restaurant) {
    Driver selectedDriver = null;

    for (Driver driver : drivers) {
      if (driver.getDriverLocation().equalsIgnoreCase(restaurant.getRestaurantLocation())) {
        if (selectedDriver == null || driver.getDriverLoad() < selectedDriver.getDriverLoad()) {
          selectedDriver = driver;
        }
      }
    }

    return selectedDriver;
  }

  // Generate and print the invoice.
  private static void generateInvoice(Customer customer, Restaurant restaurant, Driver driver)
      throws IOException {
    String invoice = customer + "\n\n" +
        "You have ordered the following from " + restaurant.getRestaurantName() + " in " +
        restaurant.getRestaurantLocation() + ":\n\n" +
        restaurant + "\n" +
        (restaurant.getSpecialInstructions().isEmpty() ? "" : "\nSpecial instructions: " +
            restaurant.getSpecialInstructions() + "\n") +
        "\nTotal: R" + String.format("%.2f", restaurant.getMealPrice()) + "\n\n" +
        driver.getDriverName() + " is nearest to the restaurant and will deliver to:\n\n" +
        customer.getCustomerAddress() + "\n\n" +
        "If you need to contact the restaurant, their number is 0" +
        restaurant.getRestaurantContactNumber() + ".\n";

    writeToFile("src\\l2t16\\l2t16\\invoice.txt", invoice);
    System.out.println(invoice);
  }

  // Handle unavailable drivers.
  private static void handleUnavailableDrivers() throws IOException {
    String message = "Sorry! Our drivers are too far away to deliver to your location.";
    System.out.println(message);
    writeToFile("src\\l2t16\\l2t16\\invoice.txt", message);
  }

  // Write content to file.
  private static void writeToFile(String fileName, String content) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
      writer.write(content);
    }
  }
}