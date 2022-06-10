public class Kurier {
    private String imie;
    private String nazwisko;
    private int id;

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Kurier(String imie, String nazwisko, int id) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.id = id;
    }
}
