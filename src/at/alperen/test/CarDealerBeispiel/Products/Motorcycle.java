package at.alperen.test.CarDealerBeispiel.Products;

public class Motorcycle implements Vehicle {
    public int Id;
    public String Brand;
    public String Model;
    public float price;


    public Motorcycle(int id, String brand, String model, float price) {
        Id = id;
        Brand = brand;
        Model = model;
        this.price = price;
    }

    public void helmetType(String type) {
        System.out.println("It is " + type + "Helmet");
    }

    public float getPrice() {
        return this.price;
    }

    @Override
    public int getId() {
        return this.Id;
    }

    @Override
    public String getBrand() {
        return this.Brand;
    }

    @Override
    public String getModel() {
        return this.Model;
    }
}
