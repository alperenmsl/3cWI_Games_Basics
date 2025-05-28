package at.alperen.test.OnlineBibliothek.Medien;

public class Hoerbuecher implements Book {

    public int Id;
    public String Title;
    public String Beschreibung;
    public float Preis;

    public Hoerbuecher(int id, String title, String beschreibung, float preis) {
        Id = id;
        Title = title;
        Beschreibung = beschreibung;
        Preis = preis;
    }

    public void playSample(String sample) {
        System.out.println("Spielt folgendes Sample: " + sample);
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
