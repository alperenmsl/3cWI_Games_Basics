package at.alperen.test.CarDealerBeispiel;

import at.alperen.test.CarDealerBeispiel.Products.Car;
import at.alperen.test.CarDealerBeispiel.Products.Motorcycle;
import at.alperen.test.CarDealerBeispiel.Products.Vehicle;

import java.util.ArrayList;

public class Dealer {
//    Erstelle eine Klasse Dealer
//    Verwalte eine Liste aller Fahrzeuge.
//
//    Ermögliche das Hinzufügen von Fahrzeugen.
//
//    Ermögliche die Suche nach einem Fahrzeug per ID.
//
//    Berechne den Gesamtwert aller Fahrzeuge im Bestand.
//
//    Gib alle Fahrzeuge übersichtlich aus.

    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return vehicles;
    }

    public Vehicle getVehicleByID(int id) {
        for (Vehicle v : vehicles) {
            if (v.getId() == id) return v;
        }
        return null;
    }



}
