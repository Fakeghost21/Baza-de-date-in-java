package Repository;


import Domain.*;

import java.io.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Repository implements IRepository{
    private VectorElemente v; //CRUD-ul este aplicat cu functii directe din vector
    private String fileName = null;

    public Repository()
    {
        v = new VectorElemente(1);
    }

    public Repository(String fileName){
        v = new VectorElemente(1);
        this.fileName = fileName;
    }

    @Override
    public void setFileName(String file)
    {
        this.fileName = file;
    }

    @Override
    public void loadFromFile()
    {

        if(this.fileName.equals("Apartamente.txt"))
        {
            try { BufferedReader fisIn =
                    new BufferedReader(new FileReader(
                            "C:\\Users\\danid\\OneDrive\\Desktop\\-\\JavaProjects\\AdministrareBloc\\src\\Domain\\Apartamente.txt"));
                String s;
                while((s = fisIn.readLine())!= null){
                    String[] felii =s.split(",");
                    int nr=Integer.parseInt(felii[0]);
                    String numeProprietar = felii[1];
                    int nrPersoane = Integer.parseInt(felii[2]);
                    float suprafata = Float.parseFloat(felii[3]);
                    Apartament a = new Apartament(nr,numeProprietar,nrPersoane,suprafata);
                    this.v.add(a);
                }
                fisIn.close();

            } // try
            catch(Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            } // catch //citiri valorile vectorului
        }

        if(this.fileName.equals("Persoane(18-65).txt"))
        {
            try { BufferedReader fisIn =
                    new BufferedReader(new FileReader(
                            "C:\\Users\\danid\\OneDrive\\Desktop\\-\\JavaProjects\\AdministrareBloc\\src\\Domain\\Persoane(18-65).txt"));
                String s;
                while((s = fisIn.readLine())!= null){
                    String[] felii =s.split(",");
                    String nume =felii[0];
                    int nrAp = Integer.parseInt(felii[1]);
                    String[] dati = felii[2].split("-");
                    int zi = Integer.parseInt(dati[0]);
                    int luna = Integer.parseInt(dati[1]) - 1;
                    int an = Integer.parseInt(dati[2]);
                    GregorianCalendar data = new GregorianCalendar(an,luna,zi);
                    String meserie = felii[3];
                    Persoana p = new Persoana(nume,nrAp,data,meserie);
                    this.v.add(p);
                }
                fisIn.close();

            } // try
            catch(Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            } // catch //citiri valorile vectorului
        }

        if(this.fileName.equals("Persoane_pensionare.txt"))
        {
            try { BufferedReader fisIn =
                    new BufferedReader(new FileReader(
                            "C:\\Users\\danid\\OneDrive\\Desktop\\-\\JavaProjects\\AdministrareBloc\\src\\Domain\\Persoane_pensionare.txt"));
                String s;
                while((s = fisIn.readLine())!= null){
                    String[] felii =s.split(",");
                    String nume =felii[0];
                    int nrAp = Integer.parseInt(felii[1]);
                    String[] dati = felii[2].split("-");
                    int zi = Integer.parseInt(dati[0]);
                    int luna = Integer.parseInt(dati[1]) - 1;
                    int an = Integer.parseInt(dati[2]);
                    GregorianCalendar data = new GregorianCalendar(an,luna,zi);
                    float pensie = Float.parseFloat(felii[3]);
                    boolean diz;
                    diz = felii[4].equals("true");
                    boolean i;
                    i = felii[5].equals("true");
                    Pensionari p = new Pensionari(nume,nrAp,data,pensie,diz,i);
                    this.v.add(p);
                }
                fisIn.close();

            } // try
            catch(Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            } // catch //citiri valorile vectorului
        }

        if(this.fileName.equals("Persoane_minore.txt"))
        {
            try { BufferedReader fisIn =
                    new BufferedReader(new FileReader(
                            "C:\\Users\\danid\\OneDrive\\Desktop\\-\\JavaProjects\\AdministrareBloc\\src\\Domain\\Persoane_minore.txt"));
                String s;
                while((s = fisIn.readLine())!= null){
                    String[] felii =s.split(",");
                    String nume =felii[0];
                    int nrAp = Integer.parseInt(felii[1]);
                    String[] dati = felii[2].split("-");
                    int zi = Integer.parseInt(dati[0]);
                    int luna = Integer.parseInt(dati[1]) - 1;
                    int an = Integer.parseInt(dati[2]);
                    GregorianCalendar data = new GregorianCalendar(an,luna,zi);
                    boolean buletin = felii[3].equals("true");
                    String sc = felii[4];
                    String parinti = felii[5];
                    Minori m = new Minori(nume,nrAp,data,buletin,sc,parinti);
                    this.v.add(m);
                }
                fisIn.close();

            } // try
            catch(Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            } // catch //citiri valorile vectorului
        }
    }


    @Override
    public void saveToFile()
    {
        try {
            String directory = "C:\\Users\\danid\\OneDrive\\Desktop\\-\\JavaProjects\\AdministrareBloc\\src\\Domain\\";
            BufferedWriter fisOut =
                    new BufferedWriter(new FileWriter(
                            directory + fileName));
            for(int i = 0;i<this.v.getSize();i++)
            {
                fisOut.write(v.getElemFromPos(i).tostring() + "\n");
            }
            fisOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Elements objNew) {
        this.v.add(objNew);
        this.saveToFile();
    }

    @Override
    public void update(Elements newObj, Elements oldObj) {
        for(int i = 0;i<this.v.getSize();i++)
            if(v.getElemFromPos(i) != null)
                if(v.getElemFromPos(i).compare(newObj))
                    v.getElemFromPos(i).copy(newObj);
        this.saveToFile();

    }

    @Override
    public int getSize() {
        return v.getSize();
    }

    @Override
    public void delete(Elements obj) {
        this.v.delete(obj);
        this.saveToFile();
    }

    @Override
    public boolean contains(Elements obj) {
        return this.v.contains(obj);
    }

    @Override
    public Elements getElemPos(int pos) {
        return this.v.getElemFromPos(pos);
    }

    @Override
    public VectorElemente getAll()
    {
        return this.v;
    }

}
