package at.alperen.test.AmazonBeispiel;

import at.alperen.test.AmazonBeispiel.Products.Phone;
import at.alperen.test.AmazonBeispiel.Products.Product;
import at.alperen.test.AmazonBeispiel.Products.Shoe;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> cartItems = new ArrayList<>();

    public void add(Product p) {
        cartItems.add(p);
        System.out.println("✅ " + p.getName() + " in den Warenkorb gelegt!");
    }

    public void showCart() {
        System.out.println("🛒 Dein Warenkorb:");
        for (Product p : cartItems) {
            System.out.println("- " + p.getName() + ": " + p.getDescription());
        }
    }

    public float getTotal() {
        float total = 0;
        for (Product p : cartItems) {
            if (p instanceof Shoe s) total += s.getPrice();
            if (p instanceof Phone ph) total += ph.getPrice();
        }
        return total;
    }
}
