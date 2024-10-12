package l2t16.l2t16;

public class Restaurant {
  // Private fields to encapsulate the restaurant and meal details.
  private String restaurantName;          // The name of the restaurant
  private int restaurantContactNumber;    // The contact number of the restaurant
  private String restaurantLocation;      // The location of the restaurant
  private String mealName;                // The name of the meal ordered
  private String specialInstructions;     // Any special instructions for the meal
  private double mealPrice;               // The price of a single meal
  private int quantity;                   // The quantity of meals ordered

  // Constructor to initialise the Restaurant object with all the relevant details.
  public Restaurant(String restaurantName, int restaurantContactNumber, String restaurantLocation,
                    String mealName, String specialInstructions, double mealPrice, int quantity) {
    this.restaurantName = restaurantName;
    this.restaurantContactNumber = restaurantContactNumber;
    this.restaurantLocation = restaurantLocation;
    this.mealName = mealName;
    this.specialInstructions = specialInstructions;
    this.mealPrice = mealPrice;
    this.quantity = quantity;
  }

  // Getter method for the restaurant's name.
  public String getRestaurantName() {
    return restaurantName;
  }

  // Getter method for the restaurant's contact number.
  public int getRestaurantContactNumber() {
    return restaurantContactNumber;
  }

  // Getter method for the restaurant's location.
  public String getRestaurantLocation() {
    return restaurantLocation;
  }

  // Getter method for special instructions (if any).
  public String getSpecialInstructions() {
    return specialInstructions;
  }

  // Method to calculate the total price for the order by multiplying the price by the quantity.
  public double getMealPrice() {
    return mealPrice * quantity;
  }

  // toString method provides a formatted string representing the meal and quantity for display.
  public String toString() {
    return quantity + " x " + mealName + " (R" + String.format("%.2f", mealPrice) + ")";
  }
}
