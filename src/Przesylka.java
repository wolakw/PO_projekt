public class Przesylka implements Gabaryt{
    private double dlugosc;
    private double szerokosc;
    private double wysokosc;
    private double waga;
    private String zawartosc;
    private Klient nadawca;
    private Klient odbiorca;

    public Przesylka(double dlugosc, double szerokosc, double wysokosc, double waga, String zawartosc, Klient nadawca,
                     Klient odbiorca){
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
        this.waga = waga;
        this.zawartosc = zawartosc;
        this.nadawca = nadawca;
        this.odbiorca = odbiorca;
    }

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
