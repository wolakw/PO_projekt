import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class GUI implements ActionListener {
    private JFrame frame;
    private JPanel panel;

    // Firma ------------------
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

    // Przesyłka ------------------------
    private JLabel PLdodaj;
    private JLabel PLfirma;
    private JComboBox PCfirmy;
    private JButton PBdodaj;

    public static ArrayList<Firma> firmy = new ArrayList<>();

    public GUI() {
        frame = new JFrame();

        // Firma -------------------------------------------------------
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

        FLpokazFirme = new JLabel("Pokaż dane firmy, wybierz z listy");
        FCpokazFirme = new JComboBox();
        for (Firma f : firmy) {
            FCpokazFirme.addItem(f.getNazwa());
        }
        FCpokazFirme.addActionListener(this);

        FLpokazFirmy = new JLabel("Pokaż dane wszytkich firm");
        FBpokazFirmy = new JButton("Pokaż dane firm");
        FBpokazFirmy.addActionListener(this);

        FLusun = new JLabel("Usuń firmę, wprowadź nazwę");
        FTusun = new JTextField();
        FBusun = new JButton("Usuń firmę");
        FBusun.addActionListener(this);

        // Przesyłka --------------------------------------------------------------

        PLdodaj = new JLabel("Dodaj paczkę do firmy");

        PLfirma = new JLabel("Firma do, której przydzielana jest paczka");
        PCfirmy = new JComboBox();
        for (Firma f : firmy) {
            PCfirmy.addItem(f.getNazwa());
        }
        PCfirmy.addActionListener(this);

        PBdodaj = new JButton("Dodaj przesyłkę");
        PBdodaj.addActionListener(this);

        // -----------------------------------------------------------------------


        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        // Firma -----------------------------------------------------------------------------
        panel.add(FLdodaj);
        panel.add(FLnazwa);
        panel.add(FTnazwa);
        panel.add(FLdata);
        panel.add(FTdata);
        panel.add(FLadres);
        panel.add(FTadres);
        panel.add(FBdodajFirme);

        panel.add(FLpokazFirme);
        panel.add(FCpokazFirme);

        panel.add(FLpokazFirmy);
        panel.add(FBpokazFirmy);

        panel.add(FLusun);
        panel.add(FTusun);
        panel.add(FBusun);

        // Przesyłka -----------------------------------------------------------------------------------

        panel.add(PLdodaj);
        panel.add(PLfirma);
        panel.add(PCfirmy);
        panel.add(PBdodaj);

        // ---------------------------------------------------------------------------------------------

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("System zarządzania firmami kurierskimi");
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == FBdodajFirme) {
            String nazwa = FTnazwa.getText();
            String data = FTdata.getText();
            String adres = FTadres.getText();

            String[] dataPodziel = data.split(",");
            String rok = dataPodziel[0];
            String miesiac = dataPodziel[1];
            String dzien = dataPodziel[2];

            Firma f = new Firma(nazwa, LocalDate.of(Integer.parseInt(rok), Integer.parseInt(miesiac), Integer.parseInt(dzien)), adres);
            System.out.println("Dodano firme " + f.getNazwa());
            firmy.add(f);
            FCpokazFirme.addItem(f.getNazwa());
            PCfirmy.addItem(f.getNazwa());
            FTnazwa.setText("");
            FTdata.setText("");
            FTadres.setText("");
        }

        if (e.getSource() == FBpokazFirmy) {
            System.out.println("\nLista firm: ");

            if (firmy.isEmpty())
                System.out.println("Brak firm");

            for (Firma f : firmy) {
                System.out.println(f.toString());
            }
        }

        if (e.getSource() == FCpokazFirme) {
            String nazwa = (String) FCpokazFirme.getSelectedItem();
            for (Firma f : firmy) {
                if (nazwa.equals(f.getNazwa())) {
                    System.out.println("\nDane dla firmy " + f.getNazwa() + ":");
                    System.out.println(f.toString());
                    break;
                }
            }
        }


        if (e.getSource() == FBusun) {
            String nazwa = FTusun.getText();
            for (Firma f : firmy) {
                if (nazwa.equals(f.getNazwa())) {
                    System.out.println("\nUsunięto firme " + f.getNazwa());
                    firmy.remove(f);
                    FCpokazFirme.removeItem(f.getNazwa());
                    PCfirmy.removeItem(f.getNazwa());
                    break;
                }
                FTusun.setText("");
            }
        }

        if (e.getSource() == PBdodaj) {
            int id = 0;

            for (Firma f : firmy) {
                if (PCfirmy.getSelectedItem().equals(f.getNazwa())) {
                    for (Przesylka p : f.przesylki) {
                        if (p.getId()>id) {
                            id = p.getId();
                        }
                    }
                    Przesylka p = new Przesylka(id+1);
                    f.dodajPrzesylke(p);
                    System.out.println("\nDodano przesyłkę o id(" + p.getId() + ") do firmy " + f.getNazwa());
                    f.drukujPrzesylki();
                    break;
                }
            }
        }
    }
}