package at.alperen.test.CarDealerBeispiel.Products;

public class Car implements Vehicle {
    public int Id;
    public String Brand;
    public String Model;
    public float price;


    public Car(int id, String brand, String model, float price) {
        Id = id;
        Brand = brand;
        Model = model;
        this.price = price;
    }

    public void numberOfDoors(String number) {
        System.out.println("The car has" + number + " doors in Car");
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
