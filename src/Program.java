import java.time.LocalDate;

public class Program {
    private static GUI gui;

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
    }
    public static void main(String[] args) {
        dane(gui);
        gui = new GUI();
        System.out.println("Hello");
    }
}
