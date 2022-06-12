import java.util.ArrayList;

public class Kurier {
    private String imie;
    private String nazwisko;
    private int id;
    private ArrayList<Przesylka> dostarczone;
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
        dostarczone = new ArrayList<>();
        posiadane = new ArrayList<>();
    }

    public void dostarcz(Przesylka p) {
        posiadane.remove(p);
        dostarczone.add(p);
    }

    public void drukujDostarczone() {
        System.out.println("\nPrzesylki dostarczone przez kuriera " + getImie() + " " + getNazwisko() + " o id(" + getId() + "): ");

        if (dostarczone.isEmpty())
            System.out.println("Brak dostarczonych przesyłek");

        for(Przesylka p : dostarczone) {
            System.out.println("Id przesylki: " + p.getId());
        }
    }

    public void drukujPosiadane() {
        System.out.println("\nPrzesylki posiadane przez kuriera " + getImie() + " " + getNazwisko() + " o id(" + getId() + "): ");

        if (posiadane.isEmpty())
            System.out.println("Brak przesyłek");

        for(Przesylka p : posiadane) {
            System.out.println("Id przesylki: " + p.getId());
        }
    }
}