package at.alperen.test.OnlineBibliothek.Medien;

public class Romane implements Book {

    public int Id;
    public String Title;
    public String Beschreibung;
    public String Genre;
    public float Preis;

    public Romane(int id, String title, String beschreibung, String genre, float preis) {
        Id = id;
        Title = title;
        Beschreibung = beschreibung;
        Genre = genre;
        Preis = preis;
    }

    public String getGenre() {
        return this.Genre;
    }

    public float getPrice() {
        return this.Preis;
    }

    @Override
    public int getId() {
        return this.Id;
    }

    @Override
    public String getTitle() {
        return this.Title;
    }

    @Override
    public String getBeschreibung() {
        return this.Beschreibung;
    }
}
