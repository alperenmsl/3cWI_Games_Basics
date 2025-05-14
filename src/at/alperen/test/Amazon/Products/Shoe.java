package at.alperen.test.Amazon.Products;

import at.alperen.test.Amazon.Interfaces.Product;

import java.awt.*;

public class Shoe implements Product {
    private Color color;
    private int ID;
    private int Price;
    private String Title;
    private String Description;


    public Shoe(int ID, int price, String title, String description, Color color) {
        this.ID = ID;
        this.color = color;
        Price = price;
        Title = title;
        Description = description;
    }

    @Override
    public int getID() {
        return this.ID;
    }

    @Override
    public int getPrice() {
        return this.Price;
    }

    @Override
    public String getTitle() {
        return "Shoes";
    }

    @Override
    public String getDescription() {
        return "";
    }

    public Color getColor() {
        return this.color;
    }
}
