package at.alperen.test.Plane;

import at.alperen.test.Plane.Klassen.Passenger;
import at.alperen.test.Plane.Klassen.Plane;
import at.alperen.test.Plane.Klassen.Position;

public class Main {
    public static void main(String[] args) {
        TrafficController controller = new TrafficController();

        Plane AlperenAir = new Plane("AlperenAirline", new Position(10, 20));
        AlperenAir.addPassenger(new Passenger("Cihan", "Sahin"));
        AlperenAir.addPassenger(new Passenger("Cengo", "Kong"));

        controller.addPlane(AlperenAir);

        controller.printAllPlanes();

        controller.informPeopleOnAllPlanes("Anschnallen Bitte");
    }
}
