package at.alperen.test.AmazonBeispiel.GUIS;

import at.alperen.test.AmazonBeispiel.*;
import at.alperen.test.AmazonBeispiel.Products.*;

import java.util.Scanner;

public class GUI1 implements GUI {
    private Store store;
    private Cart cart;
    private Scanner scanner = new Scanner(System.in);

    public GUI1(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    @Override
    public void start() {
        while (true) {
            System.out.println("""
            \n🛍️  Willkommen bei Javazon!
            1. Alle Produkte anzeigen
            2. Gesamtwert anzeigen
            3. Produkt in Warenkorb (per ID)
            4. Warenkorb anzeigen
            5. Beenden
            """);

            int input = scanner.nextInt();

            switch (input) {
                case 1 -> showAllProducts();
                case 2 -> allProductsInStock();
                case 3 -> addToCard();
                case 4 -> showCard();
                case 5 -> {
                    System.out.println("👋 Ciao!");
                    return;
                }
                default -> System.out.println("Ungültige Eingabe!");
            }
        }
    }

    @Override
    public void showAllProducts() {
        for (Product p : store.getProducts()) {
            System.out.println("#" + p.getID() + " - " + p.getName() + " | " + p.getDescription());
        }
    }

    @Override
    public void allProductsInStock() {
        float sum = 0;
        for (Product p : store.getProducts()) {
            if (p instanceof Shoe s) sum += s.getPrice();
            if (p instanceof Phone ph) sum += ph.getPrice();
        }
        System.out.println("📦 Gesamtwert aller Produkte: €" + sum);
    }

    @Override
    public void addToCard() {
        System.out.print("📥 Produkt-ID eingeben: ");
        int id = scanner.nextInt();
        Product p = store.getProductByID(id);
        if (p != null) {
            cart.add(p);
        } else {
            System.out.println("❌ Produkt nicht gefunden!");
        }
    }

    @Override
    public void showCard() {
        cart.showCart();
        System.out.println("💰 Gesamtwert im Warenkorb: €" + cart.getTotal());
    }
}
