package at.alperen.test.OnlineBibliothek.GUIS;


import at.alperen.test.OnlineBibliothek.Bibliothek;
import at.alperen.test.OnlineBibliothek.Medien.Book;

import java.util.Scanner;

public class GUI1 implements LibraryManager {


    private Scanner scanner = new Scanner(System.in);
    private Bibliothek bibliothek;

    public GUI1(Bibliothek bibliothek) {
        this.bibliothek = bibliothek;
    }

    @Override
    public void start() {
        while (true) {
            System.out.println("""
                    \n Willkommen bei AlperenBibliothek!
                    1. Alle Medien anzeigen
                    2. Gesamtwert anzeigen
                    3. Produkt Ausleihen (per ID)
                    4. Beenden
                    """);

            int input = scanner.nextInt();

            switch (input) {
                case 1 -> getAllMedia();
                case 2 -> calculateTotalMediaValue();
                case 3 -> addMedia();
                case 4 -> {
                    System.out.println("Aufwiedersehen");
                    return;
                }
                default -> System.out.println("Ungültige Eingabe!");
            }
        }
    }

    @Override
    public void getAllMedia() {
        for (Book l : bibliothek.getAllMedia()) {
            System.out.println("#" + l.getId() + " - " + l.getTitle() + " - " + l.getBeschreibung());
        }
    }

    @Override
    public void calculateTotalMediaValue() {
        float sum = 0;
        for (Book book : bibliothek.getAllMedia()) {
            sum += book.getPrice();
        }
        System.out.println("Gesamtwert aller Bücher: " + sum + "€");
    }

    @Override
    public void addMedia() {
        System.out.print("Buch ID eingeben: ");
        int id = scanner.nextInt();
        Book l = bibliothek.getMediaByID(id);
        if (l != null) {
            bibliothek.add(l);
        } else {
            System.out.println("Buch nicht gefunden!");
        }
    }
}
