/**
 * Klasa przechowujaca informacje na temat przesylki
 */
public class Przesylka implements Gabaryt{
    private double dlugosc;
    private double szerokosc;
    private double wysokosc;
    private double waga;
    private String zawartosc;
    private int id;

    /**
     * Getter id
     * @return id Id przesylki
     */
    public int getId() {
        return id;
    }

    /**
     * Setter id
     * @param id Id przesylki
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Konstruktor
     * @param id Id przesylki
     */
    public Przesylka(int id) {
        this.id = id;
    }

    /**
     * Konstruktor
     * @param dlugosc Dlugosc przesylki
     * @param szerokosc Szerokosc przesylki
     * @param wysokosc Wysokosc przesylki
     * @param waga Waga przesylki
     * @param zawartosc Zawartosc przesylki
     */
    public Przesylka(double dlugosc, double szerokosc, double wysokosc, double waga, String zawartosc){
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
        this.waga = waga;
        this.zawartosc = zawartosc;

    }

    /**
     *
     * @param f Firma
     * @param p Przesylka
     */
    public void dodajLP(Firma f, Przesylka p){

    }

    /**
     * Metoda znajdujaca gabaryt przesylki
     * @return Gabaryt przesylki
     */
    @Override
    public String znajdzGabaryt() {
        double v = dlugosc*szerokosc*wysokosc;
        double A = 19456;
        double B = 46208;
        double C = 99712;

        if (this.waga > 50){
            return "niestandardowa";
        }
        else if (v < A){
            return "A";
        }
        else if (v < B){
            return "B";
        }
        else if (v < C){
            return "C";
        }
        else{
            return "niestandardowa";
        }

    }
}