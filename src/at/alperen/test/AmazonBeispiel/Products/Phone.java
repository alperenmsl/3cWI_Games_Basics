package at.alperen.test.AmazonBeispiel.Products;

import java.awt.*;

public class Phone implements Product {

    private int id;
    private String name;
    private String description;
    private float price;

    public Phone(float price, String description, String name, int id) {
        this.price = price;
        this.description = description;
        this.name = name;
        this.id = id;
    }

    public float getPrice() {
        return this.price;
    }

    public void call(String number) {
        System.out.println("📞 Calling " + number + "...");
    }


    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
