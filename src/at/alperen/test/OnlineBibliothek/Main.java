package at.alperen.test.OnlineBibliothek;

import at.alperen.test.OnlineBibliothek.GUIS.GUI1;
import at.alperen.test.OnlineBibliothek.GUIS.GUI2;
import at.alperen.test.OnlineBibliothek.Medien.Hoerbuecher;
import at.alperen.test.OnlineBibliothek.Medien.Romane;

public class Main {
    public static void main(String[] args) {
        Bibliothek bibliothek = new Bibliothek();

        bibliothek.addMedia(new Romane(1, "Gregs Tage Buch", "Das ist ein Kinder Roman", "Roman", 15.99f));
        bibliothek.addMedia(new Hoerbuecher(2, "Löcher", "Ein Hörbuch über das Buch Löcher", 19.99f));


        GUI1 gui1 = new GUI1(bibliothek);
        //gui1.start();

        GUI2 gui2 = new GUI2(bibliothek);
        gui2.start();

    }
}
