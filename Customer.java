package l2t07;

public class Customer {
  private int orderNumber;
  private String customerName;
  private int customerContactNumber;
  private String customerAddress;
  private String customerLocation;
  private String customerEmail;

  // Constructor to initialise the customer details.
  public Customer(int orderNumber, String customerName, int customerContactNumber,
                  String customerAddress, String customerLocation, String customerEmail) {
    this.orderNumber = orderNumber;
    this.customerName = customerName;
    this.customerContactNumber = customerContactNumber;
    this.customerAddress = customerAddress;
    this.customerLocation = customerLocation;
    this.customerEmail = customerEmail;
  }

  // Getter method for customerAddress.
  public String getCustomerAddress() {
    return customerAddress;
  }

  public String toString() {
    return "Order Number: " + orderNumber +
        "\nCustomer: " + customerName +
        "\nEmail: " + customerEmail +
        "\nPhone Number: 0" + customerContactNumber +
        "\nLocation: " + customerLocation;
  }
}
