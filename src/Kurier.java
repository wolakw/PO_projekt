import java.util.ArrayList;

/**
 * Klasa przechowujaca informacje na temat kuriera
 */
public class Kurier {
    private String imie;
    private String nazwisko;
    private int id;
    public ArrayList<Przesylka> dostarczone;
    public ArrayList<Przesylka> posiadane;

    /**
     * Getter imienia
     * @return Imie kuriera
     */
    public String getImie() {
        return imie;
    }

    /**
     * Setter imienia
     * @param imie Imie kuriera
     */
    public void setImie(String imie) {
        this.imie = imie;
    }

    /**
     * Getter nazwiska
     * @return Nazwisko kuriera
     */
    public String getNazwisko() {
        return nazwisko;
    }

    /**
     * Setter nazwiska
     * @param nazwisko Nazwisko kuriera
     */
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    /**
     * Getter id kuriera
     * @return Id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter id kuriera
     * @param id Id kuriera
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Konstruktor
     * @param imie Imię kuriera
     * @param nazwisko Nazwisko kuriera
     * @param id Id kuriera
     */
    public Kurier(String imie, String nazwisko, int id) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.id = id;
        dostarczone = new ArrayList<>();
        posiadane = new ArrayList<>();
    }

    /**
     * Metoda odpowiadajaca za dostarczenie przesylki
     * @param p Przesylka
     */
    public void dostarcz(Przesylka p) {
        posiadane.remove(p);
        dostarczone.add(p);
    }

    /**
     * Metoda wypisujaca dostarczone przez kuriera przesylki
     */
    public void drukujDostarczone() {
        System.out.println("\nPrzesylki dostarczone przez kuriera " + getImie() + " " + getNazwisko() + " o id(" + getId() + "): ");

        if (dostarczone.isEmpty())
            System.out.println("Brak dostarczonych przesyłek");

        for(Przesylka p : dostarczone) {
            System.out.println("Id przesylki: " + p.getId());
        }
    }

    /**
     * Metoda wypisujaca posiadane przez kuriera przesylki
     */
    public void drukujPosiadane() {
        System.out.println("\nPrzesylki posiadane przez kuriera " + getImie() + " " + getNazwisko() + " o id(" + getId() + "): ");

        if (posiadane.isEmpty())
            System.out.println("Brak przesyłek");

        for(Przesylka p : posiadane) {
            System.out.println("Id przesylki: " + p.getId());
        }
    }

    /**
     * Metoda wypisujaca dane kuriera
     * @return Dane kuriera
     */
    public String toString() {
        return "\n" + getImie() + " " + getNazwisko() + " id(" + getId() + ")";
    }
}