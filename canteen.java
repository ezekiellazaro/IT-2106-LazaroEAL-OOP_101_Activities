import java.util.Scanner;

public class canteen {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Menu setup (at least five items) - Filipino food items
        String[] itemNames = {"Adobo", "Sinigang", "Pancit", "Lumpia", "Halo-Halo"};
        double[] itemPrices = {80.00, 120.00, 100.00, 70.00, 90.00};

        // Order summary trackers
        int totalItems = 0;
        double totalBeforeDiscount = 0.0;
        double totalDiscount = 0.0;
        double finalAmount = 0.0;

        System.out.println("=====  M E N U  =====");
        for (int i = 0; i < itemNames.length; i++) {
            System.out.printf("%d. %-12s - Php %.2f%n", i + 1, itemNames[i], itemPrices[i]);
        }

        char orderAgain;
        do {
            System.out.println();

            int itemNumber = -1;
            int quantity = -1;
            boolean validItem;
            boolean validQuantity;

            System.out.print("Enter item number: ");
            try {
                itemNumber = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                itemNumber = -1;
            }
            validItem = itemNumber >= 1 && itemNumber <= itemNames.length;

            System.out.print("Enter quantity: ");
            try {
                quantity = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                quantity = -1;
            }
            validQuantity = quantity >= 1 && quantity <= 10;

            if (!validItem || !validQuantity) {
                System.out.println();
                System.out.println("Invalid order! Please enter a valid item and quantity.");
            } else {
                System.out.print("Are you a student? (Y/N): ");
                String studentInput = sc.nextLine().trim().toUpperCase();
                boolean isStudent = studentInput.startsWith("Y");

                double subtotal = itemPrices[itemNumber - 1] * quantity;

                // Determine discount rate
                double discountRate;
                if (isStudent && subtotal >= 500) {
                    discountRate = 0.15;
                } else if (isStudent) {
                    discountRate = 0.10;
                } else if (subtotal >= 500) {
                    discountRate = 0.05;
                } else {
                    discountRate = 0.0;
                }

                double discount = subtotal * discountRate;
                double orderTotal = subtotal - discount;

                System.out.println();
                System.out.printf("Subtotal: Php %.2f%n", subtotal);
                System.out.printf("Discount: Php %.2f%n", discount);
                System.out.printf("Order total: Php %.2f%n", orderTotal);

                // Update summary (only for valid orders)
                totalItems += quantity;
                totalBeforeDiscount += subtotal;
                totalDiscount += discount;
                finalAmount += orderTotal;
            }

            System.out.println();
            System.out.print("Do you want to order again? (Y/N): ");
            String again = sc.nextLine().trim().toUpperCase();
            orderAgain = again.isEmpty() ? 'N' : again.charAt(0);

        } while (orderAgain == 'Y');

        System.out.println();
        System.out.println("===== ORDER SUMMARY =====");
        System.out.println("Total items: " + totalItems);
        System.out.printf("Total before discount: Php %.2f%n", totalBeforeDiscount);
        System.out.printf("Total discount: Php %.2f%n", totalDiscount);
        System.out.printf("Final amount: Php %.2f%n", finalAmount);
        System.out.println("Thank you for ordering!");

        sc.close();
    }
}