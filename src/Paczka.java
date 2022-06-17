/**
 * Klasa pochodna po Przesylka
 */
public class Paczka extends Przesylka {

    /**
     * Konstruktor
     * @param id Id przesylki
     */
    public Paczka(int id) {
        super(id);
    }

    /**
     * Metoda dodajaca Przesylke do listy paczek
     * @param f Firma
     * @param p Przesylka
     */
    public void dodajLP(Firma f, Przesylka p){
        f.paczki.add((Paczka) p);
        f.dodajPrzesylke(p);
    }


}