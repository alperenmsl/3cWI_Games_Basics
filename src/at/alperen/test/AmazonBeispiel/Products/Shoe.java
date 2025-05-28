package at.alperen.test.AmazonBeispiel.Products;

import java.awt.*;

public class Shoe implements Product {
    private int id;
    private String name;
    private String description;
    private float price;
    private Color color;

    public Shoe(float price, String description, String name, int id, Color color) {
        this.price = price;
        this.description = description;
        this.name = name;
        this.id = id;
        this.color = color;
    }


    public float getPrice() {
        return this.price;
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

    public Color getColor(){
        return this.color;
    }
}
