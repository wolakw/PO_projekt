/**
 * Klasa pochodna po Przesylka
 */
public class List extends Przesylka {

    /**
     * Konstruktor
     * @param id Id przesylki
     */
    public List(int id) {
        super(id);
    }

    /**
     * Metoda dodajaca Przesylke do listy listow
     * @param f Firma
     * @param p Przesylka
     */
    public void dodajLP(Firma f, Przesylka p){
        f.listy.add((List) p);
        f.dodajPrzesylke(p);
    }
}
