import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class GUI implements ActionListener {
    private JFrame frame;

    // Firma ------------------
    private JPanel panelFdodaj;
    private JPanel panelFpokaz;
    private JPanel panelFusun;
    private JLabel FLdodaj;
    private JLabel FLnazwa;
    private JTextField FTnazwa;
    private JLabel FLdata;
    private JTextField FTdata;
    private JLabel FLadres;
    private JTextField FTadres;
    private JButton FBdodajFirme;
    private JLabel FLpokazFirme;
    private JComboBox FCpokazFirme;
    private JLabel FLpokazFirmy;
    private JButton FBpokazFirmy;
    private JLabel FLusun;
    private JTextField FTusun;
    private JButton FBusun;

    // Kurier -------------------------------
    private JPanel panelKdodaj;
    private JPanel panelK;
    private JLabel KLdodaj;
    private JLabel KLimie;
    private JTextField KTimie;
    private JLabel KLnazwisko;
    private JTextField KTnazwisko;
    private JLabel KLfirmy;
    private JComboBox KCfirmy;
    private JButton KBdodaj;
    private JLabel KLwybierz;
    private JComboBox KCfirmy2;
    private JComboBox KCkurierzy;
    private JButton KBposiadane;
    private JButton KBdostarczone;
    private JLabel KLprzesWFirm;
    private JComboBox KCpaczkiF;
    private JButton KBprzydziel;
    private JLabel KLdostarcz;
    private JTextField KTdostarcz;
    private JButton KBdostarcz;

    // Przesyłka ------------------------
    private JPanel panelP;
    private JLabel PLdodaj;
    private JLabel PLfirma;
    private JComboBox PCfirmy;
    private JButton PBdodaj;

    // Zapis ---------------------------
    private JPanel panelZ;
    private JLabel ZLzapisz;
    private JButton ZBzapisz;
    public static ArrayList<Firma> firmy = new ArrayList<>();

    public GUI() {
        initFirma();

        initKurier();

        initPrzesylka();

        initZapis();

        initFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buttonFdodaj(e);

        buttonFpokaz(e);

        buttonFpokaz1(e);

        buttonFusun(e);

        buttonKdodaj(e);

        buttonKfirmy(e);

        buttonKposiadane(e);

        buttonKdostarczone(e);

        buttonKprzydziel(e);

        buttonKdostarcz(e);

        buttonPdodaj(e);

        buttonZapis(e);
    }
    public void initFirma() {
        FLdodaj = new JLabel("Dodaj firmę");
        FLnazwa = new JLabel("Nazwa");
        FTnazwa = new JTextField();
        FTnazwa.setPreferredSize(new Dimension(250, 40));

        FLdata = new JLabel("Data zalożenia (rrrr,mm,dd)");
        FTdata = new JTextField();
        FTdata.setPreferredSize(new Dimension(250, 40));

        FLadres = new JLabel("Adres");
        FTadres = new JTextField();
        FTadres.setPreferredSize(new Dimension(250, 40));

        FBdodajFirme = new JButton("Dodaj firmę");
        FBdodajFirme.addActionListener(this);

        FLpokazFirmy = new JLabel("Pokaż liste wszytkich firm");
        FBpokazFirmy = new JButton("Pokaż liste firm");
        FBpokazFirmy.addActionListener(this);

        FLpokazFirme = new JLabel("Pokaż dane firmy, wybierz z listy");
        FCpokazFirme = new JComboBox();
        for (Firma f : firmy) {
            FCpokazFirme.addItem(f.getNazwa());
        }
        FCpokazFirme.addActionListener(this);

        FLusun = new JLabel("Usuń firmę, wprowadź nazwę");
        FTusun = new JTextField();
        FBusun = new JButton("Usuń firmę");
        FBusun.addActionListener(this);


        panelFdodaj = new JPanel();
        panelFdodaj.setBounds(0, 0, 250, 250);
        panelFdodaj.setBorder(BorderFactory.createEmptyBorder(30, 30, 15, 15));
        panelFdodaj.setLayout(new GridLayout(0, 1));

        panelFdodaj.add(FLdodaj);
        panelFdodaj.add(FLnazwa);
        panelFdodaj.add(FTnazwa);
        panelFdodaj.add(FLdata);
        panelFdodaj.add(FTdata);
        panelFdodaj.add(FLadres);
        panelFdodaj.add(FTadres);
        panelFdodaj.add(FBdodajFirme);

        panelFpokaz = new JPanel();
        panelFpokaz.setBounds(0,250,250,250);
        panelFpokaz.setBorder(BorderFactory.createEmptyBorder(15,30,15,15));
        panelFpokaz.setLayout(new GridLayout(0,1));

        panelFpokaz.add(FLpokazFirmy);
        panelFpokaz.add(FBpokazFirmy);

        panelFpokaz.add(FLpokazFirme);
        panelFpokaz.add(FCpokazFirme);

        panelFusun = new JPanel();
        panelFusun.setBounds(0,500,250,250);
        panelFusun.setBorder(BorderFactory.createEmptyBorder(15,30,30,15));
        panelFusun.setLayout(new GridLayout(0,1));

        panelFusun.add(FLusun);
        panelFusun.add(FTusun);
        panelFusun.add(FBusun);
    }
    public void initKurier() {
        KLdodaj = new JLabel("Dodaj Kuriera do firmy");

        KLimie = new JLabel("Imię");
        KTimie = new JTextField();

        KLnazwisko = new JLabel("Nazwisko");
        KTnazwisko = new JTextField();

        KLfirmy = new JLabel("Firmy");
        KCfirmy = new JComboBox();
        for (Firma f : firmy) {
            KCfirmy.addItem(f.getNazwa());
        }
        KCfirmy.addActionListener(this);

        KBdodaj = new JButton("Dodaj kuriera");
        KBdodaj.addActionListener(this);

        KLwybierz = new JLabel("Wybierz kuriera");
        KCfirmy2 = new JComboBox();
        for (Firma f : firmy) {
            KCfirmy2.addItem(f.getNazwa());
        }
        KCfirmy2.addActionListener(this);

        KCkurierzy = new JComboBox();
        for (Firma f : firmy) {
            if (KCfirmy2.getSelectedItem().equals(f.getNazwa())) {
                for (Kurier k : f.kurierzy) {
                    KCkurierzy.addItem(k.getImie() + " " + k.getNazwisko());
                }
            }
        }
        KCkurierzy.addActionListener(this);

        KBposiadane = new JButton("Pokaż posiadane przesyłki");
        KBposiadane.addActionListener(this);

        KBdostarczone = new JButton("Pokaż dostarczone przesyłki");
        KBdostarczone.addActionListener(this);

        KLprzesWFirm = new JLabel("Przesyłki w firmie");
        KCpaczkiF = new JComboBox<>();
        for (Firma f : firmy) {
            if (KCfirmy2.getSelectedItem().equals(f.getNazwa())) {
                for (Przesylka p : f.przesylki) {
                    KCpaczkiF.addItem("Przesyłka id(" + p.getId() + ")");
                }
            }
        }
        KBprzydziel = new JButton("Przydziel przesyłkę do kuriera");
        KBprzydziel.addActionListener(this);

        KLdostarcz = new JLabel("Id paczek wprowadzane po spacji");
        KTdostarcz = new JTextField();
        KBdostarcz = new JButton("Dostarcz przesyłkę");
        KBdostarcz.addActionListener(this);

        panelKdodaj = new JPanel();
        panelKdodaj.setBounds(250, 0, 250, 250);
        panelKdodaj.setBorder(BorderFactory.createEmptyBorder(30, 15, 15, 15));
        panelKdodaj.setLayout(new GridLayout(0, 1));

        panelKdodaj.add(KLdodaj);

        panelKdodaj.add(KLimie);
        panelKdodaj.add(KTimie);

        panelKdodaj.add(KLnazwisko);
        panelKdodaj.add(KTnazwisko);

        panelKdodaj.add(KLfirmy);
        panelKdodaj.add(KCfirmy);

        panelKdodaj.add(KBdodaj);

        panelK = new JPanel();
        panelK.setBounds(250, 250, 250, 500);
        panelK.setBorder(BorderFactory.createEmptyBorder(15, 15, 30, 15));
        panelK.setLayout(new GridLayout(0, 1));
        panelK.add(KLwybierz);
        panelK.add(KCfirmy2);
        panelK.add(KCkurierzy);
        panelK.add(KBposiadane);
        panelK.add(KBdostarczone);

        panelK.add((KLprzesWFirm));
        panelK.add(KCpaczkiF);
        panelK.add(KBprzydziel);

        panelK.add(KLdostarcz);
        panelK.add(KTdostarcz);
        panelK.add(KBdostarcz);
    }
    public void initPrzesylka() {
        PLdodaj = new JLabel("Dodaj paczkę do firmy");

        PLfirma = new JLabel("Firma do, której przydzielana jest paczka");
        PCfirmy = new JComboBox();
        for (Firma f : firmy) {
            PCfirmy.addItem(f.getNazwa());
        }
        PCfirmy.addActionListener(this);

        PBdodaj = new JButton("Dodaj przesyłkę");
        PBdodaj.addActionListener(this);

        panelP = new JPanel();
        panelP.setBounds(500, 0, 250, 250);
        panelP.setBorder(BorderFactory.createEmptyBorder(30, 15, 15, 30));
        panelP.setLayout(new GridLayout(0, 1));

        panelP.add(PLdodaj);
        panelP.add(PLfirma);
        panelP.add(PCfirmy);
        panelP.add(PBdodaj);
    }
    public void initZapis() {
        ZLzapisz = new JLabel("Zapisz dane do pliku");
        ZBzapisz = new JButton("Zapisz");
        ZBzapisz.addActionListener(this);

        panelZ = new JPanel();
        panelZ.setBounds(500, 250, 250, 250);
        panelZ.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 30));
        panelZ.setLayout(new GridLayout(0, 1));

        panelZ.add(ZLzapisz);
        panelZ.add(ZBzapisz);
    }
    public void initFrame() {
        frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(750, 750);
        frame.add(panelFdodaj);
        frame.add(panelFpokaz);
        frame.add(panelFusun);
        frame.add(panelKdodaj);
        frame.add(panelK);
        frame.add(panelP);
        frame.add(panelZ);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("System zarządzania firmami kurierskimi");
        //frame.pack();
        frame.setVisible(true);
    }
    public void buttonFdodaj(ActionEvent e) {
        try {
            if (e.getSource() == FBdodajFirme) {
                String nazwa = FTnazwa.getText();
                String data = FTdata.getText();
                String adres = FTadres.getText();

                if (nazwa == null || nazwa.isEmpty()){
                    throw new IllegalArgumentException("Nie podano nazwy");
                }
                if (data == null || data.isEmpty()){
                    throw new IllegalArgumentException("Nie podano daty");
                }
                if (adres == null || adres.isEmpty()){
                    throw new IllegalArgumentException("Nie podano adresu");
                }

                String[] dataPodziel = data.split(",");
                String rok = dataPodziel[0];
                String miesiac = dataPodziel[1];
                String dzien = dataPodziel[2];

                if (rok.length() < 1 || rok.length() > 4) {
                    throw new IllegalArgumentException("Błędna data");
                }

                if (miesiac.length() < 1 || miesiac.length() > 2 || Integer.parseInt(miesiac) < 1 || Integer.parseInt(miesiac) > 12) {
                    throw new IllegalArgumentException("Błędna data");
                }

                if (dzien.length() < 1 || dzien.length() > 2 || Integer.parseInt(dzien) < 1 || Integer.parseInt(dzien) > 31) {
                    throw new IllegalArgumentException("Błędna data");
                }

                Firma f = new Firma(nazwa, LocalDate.of(Integer.parseInt(rok), Integer.parseInt(miesiac), Integer.parseInt(dzien)), adres);
                System.out.println("Dodano firme " + f.getNazwa());
                firmy.add(f);
                FCpokazFirme.addItem(f.getNazwa());
                PCfirmy.addItem(f.getNazwa());
                KCfirmy.addItem(f.getNazwa());
                KCfirmy2.addItem(f.getNazwa());
                FTnazwa.setText("");
                FTdata.setText("");
                FTadres.setText("");
            }
        } catch (IllegalArgumentException ex) {
            System.out .println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Błedna data");
        }
    }
    public void buttonFpokaz(ActionEvent e) {
        if (e.getSource() == FBpokazFirmy) {
            System.out.println("\nLista firm: ");

            if (firmy.isEmpty())
                System.out.println("Brak firm");

            for (Firma f : firmy) {
                System.out.println(f.toString());
            }
        }
    }
    public void buttonFpokaz1(ActionEvent e) {
        if (e.getSource() == FCpokazFirme) {
            String nazwa = (String) FCpokazFirme.getSelectedItem();
            for (Firma f : firmy) {
                if (nazwa.equals(f.getNazwa())) {
                    System.out.println("\nDane dla firmy " + f.getNazwa() + ":");
                    System.out.println(f.toString());
                    f.pokazKurierow();
                    f.drukujPrzesylki();
                    break;
                }
            }
        }
    }
    public void buttonFusun(ActionEvent e) {
        try {
            if (e.getSource() == FBusun) {
                String nazwa = FTusun.getText();

                if(nazwa == null || nazwa.isEmpty()) {
                    throw new Exception("Nie podano firmy");
                }

                boolean czyZnaleziono = false;
                for (Firma f : firmy) {
                    if (nazwa.equalsIgnoreCase(f.getNazwa())) {
                        System.out.println("\nUsunięto firme " + f.getNazwa());
                        firmy.remove(f);
                        FCpokazFirme.removeItem(f.getNazwa());
                        PCfirmy.removeItem(f.getNazwa());
                        KCfirmy.removeItem(f.getNazwa());
                        KCfirmy2.removeItem(f.getNazwa());
                        FTusun.setText("");
                        czyZnaleziono = true;
                        break;
                    }
                }

                if (!czyZnaleziono) {
                    throw new Exception("Brak firmy w systemie");
                }
            }
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void buttonKdodaj(ActionEvent e) {
        try {
            if (e.getSource() == KBdodaj) {
                String imie = KTimie.getText();
                String nazwisko = KTnazwisko.getText();
                int id = 0;

                if (imie == null || imie.isEmpty()) {
                    throw new Exception("Nie podano imienia");
                }

                if (nazwisko == null || nazwisko.isEmpty()) {
                    throw new Exception("Nie podano nazwiska");
                }

                for (Firma f : firmy) {
                    if (KCfirmy.getSelectedItem().equals(f.getNazwa())) {
                        for (Kurier k : f.kurierzy) {
                            if (k.getId() > id) {
                                id = k.getId();
                            }
                        }
                        Kurier k = new Kurier(imie, nazwisko, id + 1);
                        f.kurierzy.add(k);
                        System.out.println("Dodano kuriera o id(" + k.getId() + ") do firmy " + f.getNazwa());
                    }
                }
                KTimie.setText("");
                KTnazwisko.setText("");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void buttonKfirmy(ActionEvent e) {
        if (e.getSource() == KCfirmy2) {
            String nazwa = (String) KCfirmy2.getSelectedItem();
            for (Firma f : firmy) {
                if (nazwa.equals(f.getNazwa())) {
                    KCkurierzy.removeAllItems();
                    for (Kurier k : f.kurierzy) {
                        KCkurierzy.addItem(k.getImie() + " " + k.getNazwisko());
                    }

                    KCpaczkiF.removeAllItems();
                    for (Przesylka p : f.przesylki) {
                        KCpaczkiF.addItem("Przesyłka id(" + p.getId() + ")");
                    }
                }
            }
        }
    }
    public void buttonKposiadane(ActionEvent e) {
        if (e.getSource() == KBposiadane) {
            String kurier = (String) KCkurierzy.getSelectedItem();
            for (Firma f : firmy) {
                for (Kurier k : f.kurierzy) {
                    if (kurier.equals(k.getImie() + " " + k.getNazwisko())){
                        k.drukujPosiadane();
                    }
                }
            }
        }
    }
    public void buttonKdostarczone(ActionEvent e) {
        if (e.getSource() == KBdostarczone) {
            String kurier = (String) KCkurierzy.getSelectedItem();
            for (Firma f : firmy) {
                for (Kurier k : f.kurierzy) {
                    if (kurier.equals(k.getImie() + " " + k.getNazwisko())){
                        k.drukujDostarczone();
                    }
                }
            }
        }
    }
    public void buttonKprzydziel(ActionEvent e) {
        if (e.getSource() == KBprzydziel) {
            String firma = (String) KCfirmy2.getSelectedItem();
            String kurier = (String) KCkurierzy.getSelectedItem();
            String id = (String) KCpaczkiF.getSelectedItem();
            for (Firma f : firmy) {
                if (firma.equals(f.getNazwa())) {
                    for (Kurier k : f.kurierzy) {
                        if (kurier.equals(k.getImie() + " " + k.getNazwisko())) {
                            for (Przesylka p : f.przesylki) {
                                if (id.equals("Przesyłka id(" + p.getId() + ")")) {
                                    f.przydzielPrzesylke(p, k);
                                    KCpaczkiF.removeItem("Przesyłka id(" + p.getId() + ")");
                                    System.out.println("Przypisano przesyłkę o id(" + p.getId() + ") z firmy " + f.getNazwa() + " do kuriera " + k.getImie() + " " + k.getNazwisko());
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public void buttonKdostarcz(ActionEvent e) {
        try {
            if (e.getSource() == KBdostarcz) {
                String dane = KTdostarcz.getText();
                if (dane == null || dane.isEmpty()) {
                    throw new Exception("Nie podano przesylek do dostarczenia");
                }

                String firma = (String) KCfirmy2.getSelectedItem();
                String kurier = (String) KCkurierzy.getSelectedItem();
                String[] podzielone = dane.split(" ");

                for (String id : podzielone) {
                    for (Firma f : firmy) {
                        if (firma.equals(f.getNazwa())) {
                            for (Kurier k : f.kurierzy) {
                                if (kurier.equals(k.getImie() + " " + k.getNazwisko())) {
                                    for (Przesylka p : k.posiadane) {
                                        if (Integer.parseInt(id) == p.getId()) {
                                            k.dostarcz(p);
                                            System.out.println("Dostarczono przesylke id(" + p.getId() + ") przez kuriera " + k.getImie() + " " + k.getNazwisko());
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                KTdostarcz.setText("");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void buttonPdodaj(ActionEvent e) {
        if (e.getSource() == PBdodaj) {
            int id = 0;

            for (Firma f : firmy) {
                if (PCfirmy.getSelectedItem().equals(f.getNazwa())) {
                    for (Przesylka p : f.przesylki) {
                        if (p.getId() > id) {
                            id = p.getId();
                        }
                    }
                    Przesylka p = new Przesylka(id + 1);
                    f.dodajPrzesylke(p);
                    System.out.println("Dodano przesyłkę o id(" + p.getId() + ") do firmy " + f.getNazwa());
                    break;
                }
            }
        }
    }
    public void buttonZapis(ActionEvent e) {
        if (e.getSource() == ZBzapisz) {
            System.out.println("elo");
        }
    }
}