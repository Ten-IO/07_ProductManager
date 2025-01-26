package lab07;

import java.util.Scanner;

public class DisplayProductManagement {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ProductManager product = new ProductManager();
        String name = "";

        while (true) {
            System.out.print("""
                    ------------------------- Menu -------------------------
                      1. Add product
                      2. Find product
                      3. Remove product
                      4. Update product
                      5. Count product(s)
                      0. Exit
                    --------------------------------------------------------
                    >> Pick an option :        """);
            int input = scan.nextInt();
            scan.nextLine();
            
            switch (input) {
                case 1:
                    System.err.println(">> Adding product");
                    System.out.print("Product name: ");
                    name = scan.nextLine();
                    System.out.print("price: ");
                    double price = scan.nextDouble();
                    scan.nextLine();
                    System.out.println("discount: ");
                    double discount = scan.nextDouble();
                    scan.nextLine();
                    int initCount = product.getCount();
                    product.addProduct(name, price, discount);
                    int updateCount = product.getCount();
                    if (initCount < updateCount) {
                        System.out.println("Succeed");
                    } else {
                        System.out.println("Failed to add product");
                    }
                    break;
                case 2:
                    System.out.println(">> Finding product");
                    System.out.print("Product name:\n>");
                    name = scan.nextLine();
                    int index = product.findProduct(name);
                    if (index >= 0) {
                        System.out.println("Product found");
                        System.out.println("Detailed :");
                        Product temp = product.removeProduct(name);
                        System.out.printf("%-20s %7.2f %7.2f%n", temp.getName(), temp.getPrice(), temp.getDiscount());
                        product.addProduct(temp.getName(), temp.getPrice(), temp.getDiscount());
                    } else {
                        System.out.println("Product not in list !");
                    }
                    break;
                case 3:
                    System.out.println(">> Removing product");
                    System.out.print("Product name to remove\n>");
                    name = scan.nextLine();
                    Product temp = product.removeProduct(name);
                    if (temp != null) {
                        System.out.println(temp.getName() + "successfully removed");
                        System.out.println("Current amount: " + product.getCount());
                    }
                    break;
                case 4:
                    System.out.println(">> Updating product");
                    System.out.print("Product name: ");
                    name = scan.nextLine();
                    System.out.print("->  NEW name: ");
                    String newName = scan.nextLine();
                    System.out.print("NEW price: ");
                    double newPrice = scan.nextDouble();
                    scan.nextLine();
                    System.out.print("NEW discount: ");
                    double newDiscount = scan.nextDouble();
                    scan.nextLine();
                    boolean feedback = product.updateProduct(name, newName, newPrice, newDiscount);
                    if (feedback == true) {
                        System.out.println("Update confirmed");
                    } else {
                        System.out.println("failed to update");
                    }
                    break;
                case 5:
                    System.out.println("Your current product(s) amount: " + product.getCount());
                    break;
                case 0:
                    System.out.println("Exiting program ... ");
                    return;
                default:
                    System.out.println("Invalid option -- Please try again!");
            }
            scan.close();
        }
    }
}
