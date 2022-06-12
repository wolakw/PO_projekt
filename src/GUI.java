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

    // Przesyłka ------------------------
    private JPanel panelP;
    private JLabel PLdodaj;
    private JLabel PLfirma;
    private JComboBox PCfirmy;
    private JButton PBdodaj;
    public static ArrayList<Firma> firmy = new ArrayList<>();

    public GUI() {
        initFirma();

        initKurier();

        initPrzesylka();

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

        buttonPdodaj(e);
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

        KBposiadane = new JButton("Pokaż posiadane przesyłki");
        KBposiadane.addActionListener(this);

        KBdostarczone = new JButton("Pokaż dostarczone przesyłki");
        KBdostarczone.addActionListener(this);

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
        panelK.setBounds(250, 250, 250, 250);
        panelK.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panelK.setLayout(new GridLayout(0, 1));
        panelK.add(KLwybierz);
        panelK.add(KCfirmy2);
        panelK.add(KCkurierzy);
        panelK.add(KBposiadane);
        panelK.add(KBdostarczone);
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
                    throw new Exception("Nie podano nazwy");
                }
                if (data == null || data.isEmpty()){
                    throw new Exception("Nie podano daty");
                }
                if (adres == null || adres.isEmpty()){
                    throw new Exception("Nie podano adresu");
                }

                String[] dataPodziel = data.split(",");
                String rok = dataPodziel[0];
                String miesiac = dataPodziel[1];
                String dzien = dataPodziel[2];

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
        } catch (Exception ex) {
            System.out .println(ex.getMessage());
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
        if (e.getSource() == FBusun) {
            String nazwa = FTusun.getText();
            for (Firma f : firmy) {
                if (nazwa.equalsIgnoreCase(f.getNazwa())) {
                    System.out.println("\nUsunięto firme " + f.getNazwa());
                    firmy.remove(f);
                    FCpokazFirme.removeItem(f.getNazwa());
                    PCfirmy.removeItem(f.getNazwa());
                    KCfirmy.removeItem(f.getNazwa());
                    KCfirmy2.removeItem(f.getNazwa());
                    break;
                }
                FTusun.setText("");
            }
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
                        System.out.println("\nDodano kuriera o id(" + k.getId() + ") do firmy " + f.getNazwa());
                        f.pokazKurierow();
                    }
                }
                KTimie.setText(" ");
                KTnazwisko.setText(" ");
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
                    System.out.println("\nDodano przesyłkę o id(" + p.getId() + ") do firmy " + f.getNazwa());
                    f.drukujPrzesylki();
                    break;
                }
            }
        }
    }
}