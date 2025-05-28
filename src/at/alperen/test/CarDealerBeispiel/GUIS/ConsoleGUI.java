package at.alperen.test.CarDealerBeispiel.GUIS;

import at.alperen.test.AmazonBeispiel.Products.Product;
import at.alperen.test.CarDealerBeispiel.*;
import at.alperen.test.CarDealerBeispiel.Products.Car;
import at.alperen.test.CarDealerBeispiel.Products.Motorcycle;
import at.alperen.test.CarDealerBeispiel.Products.Vehicle;


import java.util.Scanner;

public class ConsoleGUI implements GUI {

    private Dealer dealer;
    private Cart cart;
    private Scanner scanner = new Scanner(System.in);


    public ConsoleGUI(Cart cart, Dealer dealer) {
        this.cart = cart;
        this.dealer = dealer;
    }

    @Override
    public void start() {
        while (true) {
            System.out.println("""
            \n🛍️  Willkommen bei AlperenCarDealer!
            1. Alle Autos und Motorräder anzeigen
            2. Gesamtwert anzeigen
            3. Produkt in Warenkorb (per ID)
            4. Warenkorb anzeigen
            5. Beenden
            """);

            int input = scanner.nextInt();

            switch (input) {
                case 1 -> showAllVehicles();
                case 2 -> showTotalValue();
                case 3 -> addToCardById();
                case 4 -> showCart();
                case 5 -> {
                    System.out.println("👋 Ciao!");
                    return;
                }
                default -> System.out.println("Ungültige Eingabe!");
            }
        }
    }

    @Override
    public void showAllVehicles() {
        for (Vehicle v : dealer.getAllVehicles()) {
            System.out.println("#" + v.getId() + " - " + v.getBrand() + " | " + v.getModel());
        }
    }

    @Override
    public void showTotalValue() {
        float sum = 0;
        for (Vehicle v : dealer.getAllVehicles()) {
            if (v instanceof Car c) sum += c.getPrice();
            if (v instanceof Motorcycle mc) sum += mc.getPrice();
        }
        System.out.println("📦 Gesamtwert aller Vehicles: €" + sum);
    }

    @Override
    public void addToCardById() {
        System.out.print("📥 Produkt-ID eingeben: ");
        int id = scanner.nextInt();
        Vehicle v = dealer.getVehicleByID(id);
        if (v != null) {
            cart.add(v);
        } else {
            System.out.println("❌ Produkt nicht gefunden!");
        }
    }

    @Override
    public void showCart() {
        cart.showCart();
        System.out.println("💰 Gesamtwert im Warenkorb: €" + cart.getTotal());
    }

//    Menü mit den Optionen:
//
//    Alle Fahrzeuge anzeigen
//
//    Gesamtwert anzeigen
//
//    Fahrzeug über ID zum Warenkorb hinzufügen
//
//    Warenkorb anzeigen
//
//    Beenden
}
