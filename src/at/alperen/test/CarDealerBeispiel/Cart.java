package at.alperen.test.CarDealerBeispiel;


import at.alperen.test.CarDealerBeispiel.Products.Car;
import at.alperen.test.CarDealerBeispiel.Products.Motorcycle;
import at.alperen.test.CarDealerBeispiel.Products.Vehicle;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Vehicle> cartItems = new ArrayList<>();

    public void add(Vehicle v) {
        cartItems.add(v);
        System.out.println("✅ " + v.getBrand() +" "+ v.getModel()+" in den Warenkorb gelegt!");
    }

    public void showCart() {
        System.out.println("🛒 Dein Warenkorb:");
        for (Vehicle v : cartItems) {
            System.out.println("- " + v.getBrand() + ": " + v.getModel());
        }
    }

    public float getTotal() {
        float total = 0;
        for (Vehicle v : cartItems) {
            if (v instanceof Car c) total += c.getPrice();
            if (v instanceof Motorcycle mc) total += mc.getPrice();
        }
        return total;
    }
}
