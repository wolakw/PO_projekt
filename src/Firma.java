import java.time.LocalDate;
import java.util.ArrayList;

public class Firma {
    private String nazwa;
    private LocalDate dataZalozenia;
    private String adres;
    public ArrayList<Kurier> kurierzy;
    public ArrayList<Przesylka> przesylki;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public LocalDate getDataZalozenia() {
        return dataZalozenia;
    }

    public void setDataZalozenia(LocalDate dataZalozenia) {
        this.dataZalozenia = dataZalozenia;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Firma(String nazwa, LocalDate dataZal, String adres) {
        this.nazwa = nazwa;
        this.dataZalozenia = dataZal;
        this.adres = adres;
        kurierzy = new ArrayList<>();
        przesylki = new ArrayList<>();
    }
    public void dodajPrzesylke(Przesylka p){
        przesylki.add(p);
    }

    public void przydzielPrzesylke(Przesylka p, Kurier k) {
        k.posiadane.add(p);
        przesylki.remove(p);
    }

    public void drukujPrzesylki() {
        System.out.println("\nPrzesylki w magazynie firmy " + getNazwa() + ": ");

        if (przesylki.isEmpty())
            System.out.println("Brak przesyłek");

        for(Przesylka p : przesylki) {
            System.out.println("Id przesylki: " + p.getId());
        }
    }

    public void dodajKuriera(Kurier k) {
        kurierzy.add(k);
    }

    public void pokazKurierow() {
        System.out.println("\nKurierzy przypisani do firmy " + getNazwa() + ": ");

        if (kurierzy.isEmpty())
            System.out.println("Brak przypisanych kurierow");

        for (Kurier k : kurierzy) {
            System.out.println(k.getImie() + " " + k.getNazwisko() + " id(" + k.getId() + ")");
        }
    }

    public String toString() {
        return "\nNazwa firmy: " + getNazwa() +
                "\nData założenia: " + getDataZalozenia() +
                "\nAdres: " + getAdres();
    }
}