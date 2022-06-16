import java.time.LocalDate;
public class Program {
    private static GUI gui;
    public static void main(String[] args) {
        dane(gui);
        gui = new GUI();
    }
    public static void dane(GUI g) {
        Firma firma1 = new Firma("Poczta Polska", LocalDate.of(1900, 12, 01), "Malinowa 101");
        Firma firma2 = new Firma("DPD", LocalDate.of(1940, 04, 10), "Kozacka 40");
        Firma firma3 = new Firma("Pocztex", LocalDate.of(1990, 10, 01), "Kwiatowa 10");

        gui.firmy.add(firma1);
        gui.firmy.add(firma2);
        gui.firmy.add(firma3);

        Przesylka p1 = new Przesylka(1);
        Przesylka p2 = new Przesylka(2);
        Przesylka p3 = new Przesylka(3);
        Przesylka p4 = new Przesylka(4);
        Przesylka p5 = new Przesylka(5);
        Przesylka p6 = new Przesylka(6);
        Przesylka p7 = new Przesylka(7);
        Przesylka p8 = new Przesylka(8);
        Przesylka p9 = new Przesylka(9);
        Przesylka p10 = new Przesylka(10);

        Kurier k1 = new Kurier("Janusz","Polak",1);
        Kurier k2 = new Kurier("Tadeusz","Gancarz",2);
        Kurier k3 = new Kurier("Tomasz","Mąciel",3);

        Kurier k4 = new Kurier("Filip","Trałka",1);
        Kurier k5 = new Kurier("Przemysław","Maciej",2);
        Kurier k6 = new Kurier("Konrad","Topol",3);

        Kurier k7 = new Kurier("Marcin","Sobol",1);
        Kurier k8 = new Kurier("Robert","Walczak",2);
        Kurier k9 = new Kurier("Jan","Jeleń",3);

        firma1.dodajPrzesylke(p1);
        firma1.dodajPrzesylke(p2);
        firma1.dodajPrzesylke(p3);
        firma1.dodajPrzesylke(p4);
        firma1.dodajPrzesylke(p5);
        firma1.dodajPrzesylke(p6);
        firma1.dodajPrzesylke(p7);
        firma1.dodajPrzesylke(p8);
        firma1.dodajPrzesylke(p9);
        firma1.dodajPrzesylke(p10);

        firma2.dodajPrzesylke(p1);
        firma2.dodajPrzesylke(p2);
        firma2.dodajPrzesylke(p3);
        firma2.dodajPrzesylke(p4);
        firma2.dodajPrzesylke(p5);
        firma2.dodajPrzesylke(p6);
        firma2.dodajPrzesylke(p7);
        firma2.dodajPrzesylke(p8);
        firma2.dodajPrzesylke(p9);
        firma2.dodajPrzesylke(p10);

        firma3.dodajPrzesylke(p1);
        firma3.dodajPrzesylke(p2);
        firma3.dodajPrzesylke(p3);
        firma3.dodajPrzesylke(p4);
        firma3.dodajPrzesylke(p5);
        firma3.dodajPrzesylke(p6);
        firma3.dodajPrzesylke(p7);
        firma3.dodajPrzesylke(p8);
        firma3.dodajPrzesylke(p9);
        firma3.dodajPrzesylke(p10);

        firma1.dodajKuriera(k1);
        firma1.dodajKuriera(k2);
        firma1.dodajKuriera(k3);

        firma2.dodajKuriera(k4);
        firma2.dodajKuriera(k5);
        firma2.dodajKuriera(k6);

        firma3.dodajKuriera(k7);
        firma3.dodajKuriera(k8);
        firma3.dodajKuriera(k9);

        firma2.przydzielPrzesylke(p1,k4);
        firma2.przydzielPrzesylke(p2,k4);
        firma2.przydzielPrzesylke(p3,k4);
        firma2.przydzielPrzesylke(p4,k4);

        k4.dostarcz(p1);
        k4.dostarcz(p2);
    }
}
