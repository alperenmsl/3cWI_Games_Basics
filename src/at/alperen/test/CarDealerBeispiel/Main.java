package at.alperen.test.CarDealerBeispiel;

import at.alperen.test.CarDealerBeispiel.GUIS.ConsoleGUI;
import at.alperen.test.CarDealerBeispiel.Products.Car;
import at.alperen.test.CarDealerBeispiel.Products.Motorcycle;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Dealer dealer = new Dealer();
        Cart cart = new Cart();

        dealer.addVehicle(new Car(1, "Mercedes-Benz", "E350 W212", 12500.00f));
        dealer.addVehicle(new Motorcycle(2, "Kawasaki", "Ninja", 15899.99f));

        ConsoleGUI gui = new ConsoleGUI(cart, dealer);
        gui.start();
    }
}
