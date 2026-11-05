import java.util.ArrayList;

// CLASS #2: Store
// REQUIREMENT: at least 2 fields and 2 methods (not counting getters/setters)
public class Store {

    // FIELDS (3)
    private String storeName;
    private ArrayList<Product> products;   // REQUIREMENT: ArrayList
    private double totalSales;

    public Store(String storeName) {
        this.storeName = storeName;
        this.products = new ArrayList<>();
        this.totalSales = 0;
    }

    public String getStoreName() { return storeName; }
    public double getTotalSales() { return totalSales; }

    // METHOD #1: addProduct
    public void addProduct(Product p) {
        products.add(p);
    }

    // METHOD #2: showInventory
    public void showInventory() {
        if (products.isEmpty()) {
            System.out.println("Walang laman ang inventory ni SariTrack.");
            return;
        }
        System.out.println("\n--- INVENTORY: " + storeName + " ---");
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            String alert = p.isLowStock() ? "  [LOW STOCK!]" : "";
            System.out.printf("%d. %-15s P%-8.2f Stock: %d%s%n",
                    i + 1, p.getName(), p.getPrice(), p.getStock(), alert);
        }
    }

    // METHOD #3: findProduct (case-insensitive)
    public Product findProduct(String name) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    // METHOD #4: sellProduct
    public boolean sellProduct(String name, int qty) {
        Product p = findProduct(name);
        if (p == null) {
            System.out.println("Hindi mahanap ang produkto.");
            return false;
        }
        if (!p.sell(qty)) {
            System.out.println("Kulang ang stock.");
            return false;
        }
        double total = p.getPrice() * qty;
        totalSales += total;
        System.out.printf("Nabenta!%nTotal: P%.2f%n", total);
        return true;
    }
}