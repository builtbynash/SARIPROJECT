// CLASS #1: Product
// REQUIREMENT: at least 2 fields and 2 methods (not counting getters/setters)
public class Product {

    // FIELDS (3)
    private String name;
    private double price;
    private int stock;

    // Constructor
    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // Getters (hindi kasama sa bilang ng methods)
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    // METHOD #1: sell
    // Binabawasan ang stock ng inventory mo. Magrereturn ng false kung kulang ang stock o invalid ang qty.
    public boolean sell(int qty) {
        if (qty <= 0 || qty > stock) {
            return false;
        }
        stock -= qty;
        return true;
    }

    // METHOD #2: restock
    // Dinadagdagan ang stock ng inverntory mo. Return false kung invalid ang qty.
    public boolean restock(int qty) {
        if (qty <= 0) {
            return false;
        }
        stock += qty;
        return true;
    }

    // METHOD #3: isLowStock
    // True kapag 5 pababa na lang ang stock.
    public boolean isLowStock() {
        return stock <= 5;
    }
}