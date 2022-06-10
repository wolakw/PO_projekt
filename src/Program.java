import java.time.LocalDate;

public class Program {
    public static void main(String[] args){
        //System.out.println("Test1");

        Firma firma = new Firma("Pocztex", LocalDate.of(1990,10,01),"Kwiatowa 10");
        Kurier kurier = new Kurier("Janusz", "Polak",1);
        Przesylka p1 =new Przesylka(1);
        Przesylka p2 =new Przesylka(2);
        Przesylka p3 =new Przesylka(3);
        Przesylka p4 =new Przesylka(4);
        Przesylka p5 =new Przesylka(5);
        Przesylka p6 =new Przesylka(6);
        Przesylka p7 =new Przesylka(7);
        Przesylka p8 =new Przesylka(8);

        firma.dodajPrzesylke(p1);
        firma.dodajPrzesylke(p8);
        firma.dodajPrzesylke(p4);
        firma.dodajPrzesylke(p2);
        firma.dodajPrzesylke(p6);

        firma.drukujPrzesylki();

        firma.przydzielPrzesylke(p1,kurier);
        firma.przydzielPrzesylke(p4,kurier);

        firma.drukujPrzesylki();

        kurier.drukujPosiadane();
    }
}
