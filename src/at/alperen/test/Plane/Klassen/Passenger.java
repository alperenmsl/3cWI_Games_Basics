package at.alperen.test.Plane.Klassen;

public class Passenger{

    public String firstName;
    public String lastName;

    public Passenger(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void inform(String message) {
        System.out.println(firstName + " " + lastName + " was informerd: " + message);
    }
}
