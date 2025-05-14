package at.alperen.test.Amazon.Products;

import at.alperen.test.Amazon.Interfaces.Product;

import java.awt.*;

public class Phone implements Product {
    private int ID;
    private int Price;
    private String Title;
    private String Description;


    public Phone(int ID, int price, String title, String description) {
        this.ID = ID;
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
        return "Phone";
    }

    @Override
    public String getDescription() {
        return "";
    }
}
