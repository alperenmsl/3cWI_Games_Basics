package at.alperen.test.AmazonBeispiel;

import at.alperen.test.AmazonBeispiel.Products.Product;

import java.util.ArrayList;

public class Store {
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public Product getProductByID(int id) {
        for (Product p : products) {
            if (p.getID() == id) return p;
        }
        return null;
    }
}
