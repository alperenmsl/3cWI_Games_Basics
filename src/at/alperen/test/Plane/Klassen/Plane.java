package at.alperen.test.Plane.Klassen;

import java.util.ArrayList;

public class Plane {
    private String name;
    private Position position;
    private ArrayList<Passenger> passengers = new ArrayList<>();

    public Plane(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public void informPassengers(String message) {
        for (Passenger p : passengers) {
            p.inform(message);
        }
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

}
