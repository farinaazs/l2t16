package l2t16.l2t16;

import java.io.*;
import java.util.*;

public class Driver {
  // Private fields for encapsulation: Driver's name, location, and current load (number of orders).
  private String driverName;
  private String driverLocation;
  private int driverLoad;

  // Constructor to initialise a Driver object with a name, location, and load.
  public Driver(String driverName, String driverLocation, int driverLoad) {
    this.driverName = driverName;
    this.driverLocation = driverLocation;
    this.driverLoad = driverLoad;
  }

  // Getter method for driverName. This allows access to the private field 'driverName'.
  public String getDriverName() {
    return driverName;
  }

  // Getter method for driverLocation. Provides access to the private field 'driverLocation'.
  public String getDriverLocation() {
    return driverLocation;
  }

  // Getter method for driverLoad. Allows other classes to access 'driverLoad'.
  public int getDriverLoad() {
    return driverLoad;
  }

  // toString method provides a string representation of the Driver object.
  public String toString() {
    return "Driver Name: " + driverName +
        "\nLocation: " + driverLocation +
        "\nLoad: " + driverLoad;
  }

  // Static method to load driver data from a file.
  // The file contains driver info (name, location, and load).
  // Returns a List of Driver objects.
  public static List<Driver> loadDriversFromFile(String filename) throws IOException {
    // List to hold the Driver objects created from the file data.
    List<Driver> drivers = new ArrayList<>();

    // Try-with-resources to ensure the file reader is automatically closed.
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      // Reads each line of the file, and splits the line into name, location, and load.
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(", ");
        String name = parts[0];
        String location = parts[1];
        int load = Integer.parseInt(parts[2]);

        // Add a new Driver object to the list with the parsed data.
        drivers.add(new Driver(name, location, load));
      }
    }

    // Return the list of drivers created from the file data.
    return drivers;
  }
}
