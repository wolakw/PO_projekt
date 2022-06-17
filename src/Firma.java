import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Klasa przechowujace informacje na temat firmy
 */
public class Firma {
    private String nazwa;
    private LocalDate dataZalozenia;
    private String adres;
    public ArrayList<Kurier> kurierzy;
    public ArrayList<Przesylka> przesylki;
    ArrayList<Paczka> paczki;
    ArrayList<List> listy;

    /**
     * Getter nazwy firmy
     * @return Nazwa firmy
     */
    public String getNazwa() {
        return nazwa;
    }

    /**
     * Setter nazwy firmy
     * @param nazwa Nazwa firmy
     */
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    /**
     * Getter daty zalozenia firmy
     * @return Data zalozenia firmy
     */
    public LocalDate getDataZalozenia() {
        return dataZalozenia;
    }

    /**
     * Setter daty zalozenia firmy
     * @param dataZalozenia Data zalozenia firmy
     */
    public void setDataZalozenia(LocalDate dataZalozenia) {
        this.dataZalozenia = dataZalozenia;
    }

    /**
     * Getter adresu firmy
     * @return Adres firmy
     */
    public String getAdres() {
        return adres;
    }

    /**
     * Setter adresu firmy
     * @param adres Adres firmy
     */
    public void setAdres(String adres) {
        this.adres = adres;
    }

    /**
     * Konstruktor
     * @param nazwa Nazwa firmy
     * @param dataZal Data zalozenia firmy
     * @param adres Adres firmy
     */
    public Firma(String nazwa, LocalDate dataZal, String adres) {
        this.nazwa = nazwa;
        this.dataZalozenia = dataZal;
        this.adres = adres;
        kurierzy = new ArrayList<>();
        przesylki = new ArrayList<>();
        paczki = new ArrayList<>();
        listy = new ArrayList<>();
    }

    /**
     * Metoda dodajaca przesylke do listy
     * @param p Przesylka
     */
    public void dodajPrzesylke(Przesylka p){
        przesylki.add(p);
    }

    /**
     * Metoda przydzielajaca przesylke kurierowi
     * @param p Przesylka
     * @param k Kurier
     */
    public void przydzielPrzesylke(Przesylka p, Kurier k) {
        k.posiadane.add(p);
        przesylki.remove(p);
    }

    /**
     * Metoda wypisujaca przesylki
     */
    public void drukujPrzesylki() {
        System.out.println("\nPrzesylki w magazynie firmy " + getNazwa() + ": ");

        if (przesylki.isEmpty())
            System.out.println("Brak przesyłek");

        for(Przesylka p : przesylki) {
            System.out.println("Id przesylki: " + p.getId());
        }
    }

    /**
     * Metoda dodajaca kuriera
     * @param k Kurier
     */
    public void dodajKuriera(Kurier k) {
        kurierzy.add(k);
    }

    /**
     * Metoda wypisujaca kurierow firmy
     */
    public void pokazKurierow() {
        System.out.println("\nKurierzy przypisani do firmy " + getNazwa() + ": ");

        if (kurierzy.isEmpty())
            System.out.println("Brak przypisanych kurierow");

        for (Kurier k : kurierzy) {
            System.out.println(k.getImie() + " " + k.getNazwisko() + " id(" + k.getId() + ")");
        }
    }

    /**
     * Metoda wypisujaca dane firmy
     * @return Dane firmy
     */
    public String toString() {
        return "\nNazwa firmy: " + getNazwa() +
                "\nData założenia: " + getDataZalozenia() +
                "\nAdres: " + getAdres();
    }
}