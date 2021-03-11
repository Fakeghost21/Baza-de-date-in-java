package controller;


import Domain.*;
import Repository.Repository;
import Services.ApartamenteServices;
import Services.MinoriServices;
import Services.PensionariService;
import Services.PersoanaAdultaService;
import View.Afisare;

import javax.swing.*;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
    public static Repository r1 = new Repository();
    public static Repository r2 = new Repository();
    public static Repository r3 = new Repository();
    public static Repository r4 = new Repository();
    public static ApartamenteServices ap = new ApartamenteServices(r1);
    public static PersoanaAdultaService pA = new PersoanaAdultaService(r2);
    public static PensionariService pS = new PensionariService(r3);
    public static MinoriServices m = new MinoriServices(r4);
    private JButton menuApartament;
    private JButton menuAdulti;
    private JButton menuPensionari;
    private JButton menuMinori;
    private JPanel panel;

    public static void addAp() { //Adauga un apartament de la tastatura in fisier,aruncand o eroare daca acel apartament exista deja in fisier
        try {
            Scanner S = new Scanner(System.in);
            System.out.print("Introduceti un apartament : ");
            String line = S.nextLine();
            while (!line.equals("")) {
                String[] felii = line.split(",");
                int nr = Integer.parseInt(felii[0]);
                String numeProprietar = felii[1];
                int nrPersoane = Integer.parseInt(felii[2]);
                float suprafata = Float.parseFloat(felii[3]);
                Apartament a = new Apartament(nr, numeProprietar, nrPersoane, suprafata);
                if (ap.searchForApartament(nr) != null)
                    throw new Exception();
                ap.add(a);

                System.out.print("Introduceti un apartament : ");
                line = S.nextLine();
            }
        } catch (Exception e) {
            System.out.println("Acest apartament este deja adaugat(numarul sau)");
            System.out.print("Doriti sa adaugati alt apartament : "); //Utilizatorul este intrebat daca doreste sa repete procesul
            Scanner S = new Scanner(System.in);
            String opt = S.nextLine();
            if (opt.equals("DA") || opt.equals("Da") || opt.equals("da"))
                addAp();
        }
    }

    public static void addPersAulta() {
        try {   //Adauga o persoana intre 18-65,crescand totodata numarul de persoane la apartamentul
            Scanner S = new Scanner(System.in); //cu numarul introdus,daca apartamentul nu exista se arunca eroare
            System.out.print("Introduceti o persoana(18 - 65) : ");
            String line = S.nextLine();
            while (!line.equals("")) {
                String[] felii = line.split(",");
                String nume = felii[0];
                int nrAp = Integer.parseInt(felii[1]);
                String[] dati = felii[2].split("-");
                int zi = Integer.parseInt(dati[0]);
                int luna = Integer.parseInt(dati[1]) - 1;
                int an = Integer.parseInt(dati[2]);
                GregorianCalendar data = new GregorianCalendar(an, luna, zi);
                String meserie = felii[3];
                if (ap.searchForApartament(nrAp) == null)
                    throw new Exception();
                Apartament Ap = (Apartament) ap.searchForApartament(nrAp);
                Ap.setNrPersoane(Ap.getNrPersoane() + 1);
                ap.update((Apartament) ap.searchForApartament(nrAp), Ap);
                Persoana p = new Persoana(nume, nrAp, data, meserie);
                pA.add(p);

                System.out.print("Introduceti o persoana(18-65) : ");
                line = S.nextLine();

            }
        } catch (Exception e) {
            System.out.println("Apartament invalid");
            addPersAulta();
        }

    }

    public static void addPersPens() {
        try {
            Scanner S = new Scanner(System.in);
            System.out.print("Introduceti o persoana aflata la pensie : ");
            String line = S.nextLine();
            while (!line.equals("")) {
                String[] felii = line.split(",");
                String nume = felii[0];
                int nrAp = Integer.parseInt(felii[1]);
                String[] dati = felii[2].split("-");
                int zi = Integer.parseInt(dati[0]);
                int luna = Integer.parseInt(dati[1]) - 1;
                int an = Integer.parseInt(dati[2]);
                GregorianCalendar data = new GregorianCalendar(an, luna, zi);
                float pensie = Float.parseFloat(felii[3]);
                boolean diz;
                diz = felii[4].equals("true");
                boolean i;
                i = felii[5].equals("true");
                if (ap.searchForApartament(nrAp) == null)
                    throw new Exception();
                Apartament Ap = (Apartament) ap.searchForApartament(nrAp);
                Ap.setNrPersoane(Ap.getNrPersoane() + 1);
                ap.update(ap.searchForApartament(nrAp), Ap);
                Pensionari p = new Pensionari(nume, nrAp, data, pensie, diz, i);
                pS.add(p);

                System.out.print("Introduceti o persoana aflata la pensie : ");
                line = S.nextLine();

            }
        } catch (Exception e) {
            System.out.println("Numarul apartamentului introdus este invalid");
            addPersPens();
        }
    }

    public static void addPersMinora() {
        try {
            Scanner S = new Scanner(System.in);
            System.out.print("Introduceti o persoana cu varsta sub 18 ani : ");
            String line = S.nextLine();
            while (!line.equals("")) {
                String[] felii = line.split(",");
                String nume = felii[0];
                int nrAp = Integer.parseInt(felii[1]);
                String[] dati = felii[2].split("-");
                int zi = Integer.parseInt(dati[0]);
                int luna = Integer.parseInt(dati[1]) - 1;
                int an = Integer.parseInt(dati[2]);
                GregorianCalendar data = new GregorianCalendar(an, luna, zi);
                boolean buletin = felii[3].equals("peste 14 ani");
                String sc = felii[4];
                String parinti = felii[5];
                if (ap.searchForApartament(nrAp) == null)
                    throw new Exception();
                Apartament Ap = (Apartament) ap.searchForApartament(nrAp);
                Ap.setNrPersoane(Ap.getNrPersoane() + 1);
                ap.update(ap.searchForApartament(nrAp), Ap);
                Minori M = new Minori(nume, nrAp, data, buletin, sc, parinti);
                m.add(M);

                System.out.print("Introduceti o persoana cu varsta sub 18 ani : ");
                line = S.nextLine();

            }
        } catch (Exception e) {
            System.out.println("Numarul apartamentului introdus este invalid");
            addPersMinora();
        }
    }

    public static void deleteAp() //sterge apartamentul itrodus cat si toate persoanele care locuiau in acel apartament
    {
        try {
            Scanner S = new Scanner(System.in);
            System.out.print("Care este numarul apartamentului dorit : ");
            int nr = Integer.parseInt(S.nextLine());
            if (ap.searchForApartament(nr) == null)
                throw new Exception();
            ap.delete(ap.searchForApartament(nr));
            pA.deletePersAp(nr);
            pS.deletePersAp(nr);
            m.deletePersAp(nr);
        } catch (Exception e) {
            System.out.println("Mai incearca!");
            deleteAp();
        }

    }

    public static void modifiAp() //schimba proprietarul unui apartament
    {
        try {
            Scanner S = new Scanner(System.in);
            System.out.print("Care este numarul apartamentului dorit : ");
            int nr = Integer.parseInt(S.nextLine());
            if (ap.searchForApartament(nr) == null)
                throw new Exception();
            Apartament old = (Apartament) ap.searchForApartament(nr);
            System.out.print("Introduceti numele noului proprietar : ");
            String proprietar = S.nextLine();
            Apartament newAp = new Apartament(old.getNrApartament(), proprietar, old.getNrPersoane(), old.getSuprafata());
            ap.update(old, newAp);
        } catch (Exception e) {
            System.out.println("Mai incearca!");
            modifiAp();
        }
    }

    public static void deleteAdult() //Sterge o persoana,iar numarul de persoane de la apartamentul respectiv scade
    {
        try {
            Scanner S = new Scanner(System.in);
            System.out.print("Care este numele persoanei : ");
            String nume = S.nextLine();
            if (pA.searchNume(nume) == null)
                throw new Exception();
            Apartament Ap = (Apartament) ap.searchForApartament(pA.searchNume(nume).getApartament());
            Ap.setNrPersoane(Ap.getNrPersoane() - 1);
            ap.update(ap.searchForApartament(pA.searchNume(nume).getApartament()), Ap);
            pA.delete(pA.searchNume(nume));
        } catch (Exception e) {
            System.out.println("Mai incearca!");
            deleteAdult();
        }

    }

    public static void modifiAdult() //schimbare a locului de munca a unei persoae
    {
        try {
            Scanner S = new Scanner(System.in);
            System.out.print("Care este numele persoanei :");
            String nume = S.nextLine();
            if (pA.searchNume(nume) == null)
                throw new Exception();
            Persoana old = pA.searchNume(nume);
            System.out.print("Introduceti noua meserie : ");
            String meserie = S.nextLine();
            Persoana newP = new Persoana(old.getNumePersoana(), old.getApartament(), old.getData(), meserie);
            pA.update(old, newP);
        } catch (Exception e) {
            System.out.println("Mai incearca!");
            modifiAdult();
        }
    }

    public static void deletePensionar() {
        try {
            Scanner S = new Scanner(System.in);
            System.out.print("Care este numele persoanei : ");
            String nume = S.nextLine();
            if (pS.searchNume(nume) == null)
                throw new Exception();
            Apartament Ap = (Apartament) ap.searchForApartament(pS.searchNume(nume).getApartament());
            Ap.setNrPersoane(Ap.getNrPersoane() - 1);
            ap.update(ap.searchForApartament(pS.searchNume(nume).getApartament()), Ap);
            pS.delete(pS.searchNume(nume));
        } catch (Exception e) {
            System.out.println("Mai incearca!");
            deletePensionar();
        }

    }

    public static void modifiPensionar() //schimbare a statusului unei persoane aflate la pensie
    {
        try {
            Scanner S = new Scanner(System.in);
            System.out.print("Care este numele persoanei : ");
            String sp = S.nextLine();
            if (pS.searchNume(sp) == null)
                throw new Exception();
            Pensionari old = pS.searchNume(sp);
            System.out.print("Introduceti noul status(Sprijinit DA,altfel NU : ");
            String status = S.nextLine();
            boolean stats = false;
            if (status.equals("DA") || status.equals("Da") || status.equals("da"))
                stats = true;
            Pensionari newPens = new Pensionari(old.getNumePersoana(), old.getApartament(), old.getData(), old.getPensie(), old.isDizabilitat(), stats);

            pS.update(old, newPens);
        } catch (Exception e) {
            System.out.println("Mai incearca!");
            modifiAp();
        }
    }

    public static void deleteMinor() {
        try {
            Scanner S = new Scanner(System.in);
            System.out.print("Care este numele persoanei : ");
            String nume = S.nextLine();
            if (m.searchNume(nume) == null)
                throw new Exception();
            Apartament Ap = (Apartament) ap.searchForApartament(m.searchNume(nume).getApartament());
            Ap.setNrPersoane(Ap.getNrPersoane() - 1);
            ap.update(ap.searchForApartament(m.searchNume(nume).getApartament()), Ap);
            m.delete(m.searchNume(nume));
        } catch (Exception e) {
            System.out.println("Mai incearca!");
            deleteMinor();
        }

    }

    public static void modifiMinor() //schimbarea scolii unui minor
    {
        try {
            Scanner S = new Scanner(System.in);
            System.out.print("Care este numele persoanei : ");
            String sp = S.nextLine();
            if (m.searchNume(sp) == null)
                throw new Exception();
            Minori old = m.searchNume(sp);
            System.out.print("Introduceti noua scoala : ");
            String scoala = S.nextLine();
            Minori newM = new Minori(old.getNumePersoana(), old.getApartament(), old.getData(), old.isBuletin(), scoala, old.getParinti());
            m.update(old, newM);
        } catch (Exception e) {
            System.out.println("Mai incearca!");
            modifiMinor();
        }
    }

    public static int menu() {
        System.out.println("1.Apartamente :");
        System.out.println("2.Fisierul cu persoanele cu varsta intre 18 si 65 :");
        System.out.println("3.Fisierul cu persoane aflate la pensie :");
        System.out.println("4.Fisierul cu persoane minore :");
        System.out.println("0.Iesire :");
        return (citIntreg("Optiunea:"));

    }

    public static int menuApartamente() {
        System.out.println("1.Adaugare :");
        System.out.println("2.Stergere :");
        System.out.println("3.Modificare :");
        System.out.println("4.Cautare apartament :");
        System.out.println("5.Afisare :");
        System.out.println("0.Iesire :");
        return (citIntreg("Optiunea:"));

        //return 0;
    }

    public static int menuAdulti() {
        System.out.println("1.Adaugare :");
        System.out.println("2.Stergere :");
        System.out.println("3.Modificare :");
        System.out.println("4.Afisare :");
        System.out.println("0.Iesire :");
        return (citIntreg("Optiunea:"));

    }

    public static int menuPensionari() {
        System.out.println("1.Adaugare :");
        System.out.println("2.Stergere :");
        System.out.println("3.Modificare :");
        System.out.println("4.Afisare :");
        System.out.println("0.Iesire :");
        return (citIntreg("Optiunea:"));

    }

    public static int menuMinori() {
        System.out.println("1.Adaugare :");
        System.out.println("2.Stergere :");
        System.out.println("3.Modificare :");
        System.out.println("4.Afisare :");
        System.out.println("0.Iesire :");
        return (citIntreg("Optiunea:"));

    }

    public static void search() {
        Scanner S = new Scanner(System.in);
        System.out.print("Care este numarul apartamentului cautat : ");
        int nr = Integer.parseInt(S.nextLine());
        System.out.println(ap.searchForApartament(nr).tostring());
    }

    /*
    private static Apartament cautaApartament(Repository r)
    {

    }

    public static void addPersoanaAdulta(Repository r)
    {
        try { BufferedReader fisIn =
                new BufferedReader(new FileReader(
                        "C:\\Users\\danid\\OneDrive\\Desktop\\-\\JavaProjects\\AdministrareBloc\\src\\Domain\\Persoane(18-65).txt"));
            String s;
            while((s = fisIn.readLine())!= null){
                String[] felii =s.split(",");
                String nume = felii[0];
                int nrAp = Integer.parseInt(felii[1]);

                int nrPersoane = Integer.parseInt(felii[2]);
                float suprafata = Float.parseFloat(felii[3]);
                Apartament a = new Apartament(nr,numeProprietar,nrPersoane,suprafata);
                r.add(a);
            }
            System.out.println("O meeeeers!");
            fisIn.close();

        } // try
        catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } // catch //citiri valorile vectorului
    }
*/

    public static int citIntreg(String sir) { //Citirea unui intreg,respectiv pentru citirea optiunii de la meniu
        try {
            System.out.print(sir);
            Scanner S = new Scanner(System.in);
            return S.nextInt();
        } catch (Exception E) {
            System.out.println("Ai gresit, mai incearca");
            return citIntreg(sir);
        }
    }

    public static void main(String[] args) {
        /*
        GregorianCalendar gc = new GregorianCalendar(2000, 1,21);
        System.out.println(gc.get(Calendar.MONTH));
        Repository r1 = new Repository();
        ApartamenteServices s1 = new ApartamenteServices(r1);
        addAp(s1);
        Apartament ap = new Apartament(9,"George Bucluc",3,48);
        System.out.println(r1.getElemPos(0).tostring());
        */

//        ap.setFile("Apartamente.txt");
//        //loadFromFile(r1);
//        addAp();
//        Afisare.afisareApartamente(ap);
//        System.out.println("\n");
//
//        pA.setFile("Persoane(18-65).txt");
//        //loadFromFile(r2);
//        addPersAulta();
//        Afisare.afisareAdulti(pA);
//        System.out.println("\n");
//
//        pS.setFile("Persoane_pensionare.txt");
//        addPersPens();
//        Afisare.afisarePensionari(pS);
//        System.out.println("\n");
//
//        m.setFile("Persoane_minore.txt");
//        addPersMinora();
//        Afisare.afisareMinori(m);



        int opt = menu();
        int opt2;
        ap.setFile("Apartamente.txt");
        pA.setFile("Persoane(18-65).txt");
        pS.setFile("Persoane_pensionare.txt");
        m.setFile("Persoane_minore.txt");
        while (opt != 0) {
            switch (opt) {
                case 1:
                    Afisare.afisareApartamente(ap);
                    opt2 = menuApartamente();
                    while (opt2 != 0) {
                        switch (opt2) {
                            case 1:
                                addAp();
                                break;
                            case 2:
                                deleteAp();
                                break;
                            case 3:
                                modifiAp();
                                break;
                            case 4:
                                search();
                                break;
                            case 5:
                                Afisare.afisareApartamente(ap);
                                break;
                        }
                        opt2 = menuApartamente();
                    }
                    break;
                case 2:
                    Afisare.afisareAdulti(pA);
                    opt2 = menuAdulti();
                    while (opt2 != 0) {
                        switch (opt2) {
                            case 1:
                                addPersAulta();
                                break;
                            case 2:
                                deleteAdult();
                                break;
                            case 3:
                                modifiAdult();
                                break;
                            case 4:
                                Afisare.afisareAdulti(pA);
                                break;
                        }
                        opt2 = menuAdulti();
                    }
                    break;
                case 3: {
                    Afisare.afisarePensionari(pS);
                    opt2 = menuPensionari();
                    while (opt2 != 0) {
                        switch (opt2) {
                            case 1:
                                addPersPens();
                                break;
                            case 2:
                                deletePensionar();
                                break;
                            case 3:
                                modifiPensionar();
                                break;
                            case 4:
                                Afisare.afisarePensionari(pS);
                                break;
                        }
                        opt2 = menuPensionari();
                    }

                    break;
                }
                case 4: {
                    Afisare.afisareMinori(m);
                    opt2 = menuMinori();
                    while (opt2 != 0) {
                        switch (opt2) {
                            case 1:
                                addPersMinora();
                                break;
                            case 2:
                                deleteMinor();
                                break;
                            case 3:
                                modifiMinor();
                                break;
                            case 4:
                                Afisare.afisareMinori(m);
                                break;
                        }
                        opt2 = menuMinori();
                    }

                    break;                      //procentul de petrol din totalul de petrol importat de catre toate tarile
                }

            }
            opt = menu();
        }
        System.out.println("Program terminat ");
    }

}




