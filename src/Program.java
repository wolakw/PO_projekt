import java.time.LocalDate;

/**
 * Klasa w której wywoływany jets program
 */
public class Program {
    private static GUI gui;

    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {
        dane(gui);
        gui = new GUI();
    }

    /**
     * Metoda uzupelniająca program przykładowymi danymi
     * @param g
     */
    public static void dane(GUI g) {

        Firma firma1 = new Firma("Poczta Polska", LocalDate.of(1900, 12, 01), "Malinowa 101");
        Firma firma2 = new Firma("DPD", LocalDate.of(1940, 04, 10), "Kozacka 40");
        Firma firma3 = new Firma("Pocztex", LocalDate.of(1990, 10, 01), "Kwiatowa 10");
        Firma firma4 = new Firma("FedEx", LocalDate.of(1971, 05, 05), "Krucza 16/22");

        gui.firmy.add(firma1);
        gui.firmy.add(firma2);
        gui.firmy.add(firma3);
        gui.firmy.add(firma4);

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
        Przesylka li1 = new List(11);
        Przesylka pa1 = new Paczka(12);
        Przesylka li2 = new List(13);
        Przesylka pa2 = new Paczka(14);
        Przesylka li3 = new List(15);
        Przesylka pa3 = new Paczka(16);
        Przesylka li4 = new List(17);
        Przesylka pa4 = new Paczka(18);
        Przesylka li5 = new List(19);
        Przesylka pa5 = new Paczka(20);

        Kurier k1 = new Kurier("Janusz","Polak",1);
        Kurier k2 = new Kurier("Tadeusz","Gancarz",2);
        Kurier k3 = new Kurier("Tomasz","Mąciel",3);

        Kurier k4 = new Kurier("Piotr","Fontyk",1);
        Kurier k5 = new Kurier("Filip","Trałka",2);
        Kurier k6 = new Kurier("Przemysław","Maciej",3);

        Kurier k7 = new Kurier("Konrad","Topol",1);
        Kurier k8 = new Kurier("Tymoteusz","Sowa",2);
        Kurier k9 = new Kurier("Marcin","Sobol",3);

        Kurier k10 = new Kurier("Robert","Walczak",1);
        Kurier k11 = new Kurier("Jan","Jeleń",2);
        Kurier k12 = new Kurier("Karol","Drzewo",3);

        firma1.dodajPrzesylke(p5);
        firma1.dodajPrzesylke(p6);
        firma1.dodajPrzesylke(p7);
        li1.dodajLP(firma1,li1);

        firma2.dodajPrzesylke(p1);
        firma2.dodajPrzesylke(p2);
        firma2.dodajPrzesylke(p3);
        firma2.dodajPrzesylke(p4);
        pa1.dodajLP(firma2,pa1);
        li2.dodajLP(firma2,li2);

        firma3.dodajPrzesylke(p8);
        firma3.dodajPrzesylke(p9);
        firma3.dodajPrzesylke(p10);
        pa2.dodajLP(firma3,pa2);
        li3.dodajLP(firma3,li3);

        pa3.dodajLP(firma4,pa3);
        li4.dodajLP(firma4,li4);
        pa4.dodajLP(firma4,pa4);
        li5.dodajLP(firma4,li5);
        pa5.dodajLP(firma4,pa5);

        firma1.dodajKuriera(k1);
        firma1.dodajKuriera(k2);
        firma1.dodajKuriera(k3);

        firma2.dodajKuriera(k4);
        firma2.dodajKuriera(k5);
        firma2.dodajKuriera(k6);

        firma3.dodajKuriera(k7);
        firma3.dodajKuriera(k8);
        firma3.dodajKuriera(k9);

        firma4.dodajKuriera(k10);
        firma4.dodajKuriera(k11);
        firma4.dodajKuriera(k12);

        firma2.przydzielPrzesylke(p1,k4);
        firma2.przydzielPrzesylke(p2,k4);
        firma2.przydzielPrzesylke(p3,k4);
        firma2.przydzielPrzesylke(p4,k4);

        firma4.przydzielPrzesylke(pa3,k10);
        firma4.przydzielPrzesylke(li4,k11);
        firma4.przydzielPrzesylke(pa4,k11);

        k11.dostarcz(li4);
        k4.dostarcz(p1);
        k4.dostarcz(p2);
    }
}
