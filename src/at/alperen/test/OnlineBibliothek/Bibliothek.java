package at.alperen.test.OnlineBibliothek;

import at.alperen.test.OnlineBibliothek.Medien.Book;

import java.util.ArrayList;

public class Bibliothek {
    private ArrayList<Book> books = new ArrayList<>();

    public void addMedia(Book l) {

        books.add(l);
    }

    public ArrayList<Book> getAllMedia() {

        return books;
    }

    public Book getMediaByID(int id) {
        for (Book l : books) {
            if (l.getId() == id) return l;
        }
        return null;
    }

    public void add(Book l) {
        books.add(l);
        System.out.println(l.getTitle() + " - " + l.getBeschreibung() + " wurde hinzugefügt!");
    }
}
