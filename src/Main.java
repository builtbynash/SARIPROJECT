import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    // REQUIREMENT: user input na hindi nagc-crash
    // Inuulit ang tanong hanggang tamang integer ang ilagay.
    static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Maling input. Numero lang po.");
            }
        }
    }

    static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Maling input. Numero lang po.");
            }
        }
    } 

    public static void main(String[] args) {
        Store store = new Store("SariTrack - Aling Nena's Sari-Sari Store");

        // Sample products
        store.addProduct(new Product("Lucky Me", 15.00, 20));
        store.addProduct(new Product("Coke Sakto", 12.00, 10));
        store.addProduct(new Product("Itlog", 9.00, 4));

        int choice;
        do {
            System.out.println("\n===== " + store.getStoreName() + " =====");
            System.out.println("1. Tingnan ang inventory");
            System.out.println("2. Magdagdag ng Produkto");
            System.out.println("3. Magbenta");
            System.out.println("4. Mag-restock");
            System.out.println("5. Total Sales");
            System.out.println("0. Exit");
            choice = readInt("Piliin: ");

            switch (choice) {
                case 1:
                    store.showInventory();
                    break;
                case 2:
                    System.out.print("Pangalan: ");
                    String name = sc.nextLine().trim();
                    if (name.isEmpty()) {
                        System.out.println("Hindi pwedeng walang kang pangalan.");
                        break;
                    }
                    double price = readDouble("Presyo: ");
                    int stock = readInt("Stock: ");
                    if (price <= 0 || stock < 0) {
                        System.out.println("Invalid price/stock.");
                        break;
                    }
                    store.addProduct(new Product(name, price, stock));
                    System.out.println("Naidagdag na!");
                    break;
                case 3:
                    System.out.print("Pangalan ng produkto: ");
                    String sellName = sc.nextLine().trim();
                    int qty = readInt("Ilan: ");
                    store.sellProduct(sellName, qty);
                    break;
                case 4:
                    System.out.print("Pangalan ng produkto: ");
                    String rName = sc.nextLine().trim();
                    Product p = store.findProduct(rName);
                    if (p == null) {
                        System.out.println("Hindi ko mahanap ang produkto.");
                        break;
                    }
                    int rQty = readInt("Ilan ang idadagdag: ");
                    if (p.restock(rQty)) {
                        System.out.println("Na-restock na!");
                    } else {
                        System.out.println("Mali nilagay mong input, Numero lang po.");
                    }
                    break;
                case 5:
                    System.out.printf("Total sales: P%.2f%n", store.getTotalSales());
                    break;
                case 0:
                    System.out.println("Salamat po! Bili po kayo ulit next time!");
                    break;
                default:
                    System.out.println("Walang ganyang option.");
            }
        } while (choice != 0);
    }
}