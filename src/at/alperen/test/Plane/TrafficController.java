package at.alperen.test.Plane;

import at.alperen.test.Plane.Klassen.Plane;
import java.util.ArrayList;

public class TrafficController {
    private ArrayList<Plane> planes;

    public TrafficController() {
        this.planes = new ArrayList<>();
    }

    public void addPlane(Plane plane) {
        planes.add(plane);
    }

    public void printAllPlanes() {
        if (planes.isEmpty()) {
            System.out.println("Es sind keine Flugzeuge vorhanden");
        } else {
            for (Plane p : planes) {
                System.out.println(p.toString());
            }
        }
    }

    public void informPeopleOnAllPlanes(String message) {
        for (Plane p : planes) {
            p.informPassengers(message);
        }
    }
}
