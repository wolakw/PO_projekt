import java.util.ArrayList;

public class Kurier {
    private String imie;
    private String nazwisko;
    private int id;
    private ArrayList<Przesylka> dostraczone;
    public ArrayList<Przesylka> posiadane;

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
        dostraczone = new ArrayList<>();
        posiadane = new ArrayList<>();
    }

    public void dostarcz(Przesylka p, Kurier k) {
        posiadane.remove(p);
        dostraczone.remove(p);
    }

    public void drukujDostarczone() {
        System.out.println("Przesylki dostarczone: ");
        for(Przesylka p : dostraczone) {
            System.out.println(p);
        }
    }

    public void drukujPosiadane() {
        System.out.println("\nPrzesylki posiadane: ");
        for(Przesylka p : posiadane) {
            System.out.println("Id przesylki: " + p.getId());
        }
    }
}