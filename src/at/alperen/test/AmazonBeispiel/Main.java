package at.alperen.test.AmazonBeispiel;

import at.alperen.test.AmazonBeispiel.GUIS.*;
import at.alperen.test.AmazonBeispiel.Products.*;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();

        store.addProduct(new Shoe(99.99f, "Bequemer Sportschuh", "Nike Air Max", 1, Color.BLACK));
        store.addProduct(new Phone(399.99f, "Smartphone mit guter Kamera", "Samsung Galaxy", 2));

        GUI1 gui = new GUI1(store, cart);
        gui.start();
    }
}
