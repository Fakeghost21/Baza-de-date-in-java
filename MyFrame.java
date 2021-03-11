package GUI;

import Domain.Apartament;
import Domain.Minori;
import Domain.Pensionari;
import Domain.Persoana;
import Repository.Repository;
import Services.ApartamenteServices;
import Services.MinoriServices;
import Services.PensionariService;
import Services.PersoanaAdultaService;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;

public class MyFrame extends JFrame implements ActionListener {
    JButton buton1,buton2,buton3,buton4,addAp,deleteAp,updateAp,showAp,back,adaugare,stergere,modificare;
    JButton addA,deleteA,updateA,showA,addM,deleteM,updateM,showM,addP,deleteP,updateP,showP;
    JButton backAp,backPens,backMinori,backPers;
    JTextField numar,nume,persoane,suprafata,numar2;
    JLabel error;
    public static Repository r1 = new Repository();
    public static Repository r2 = new Repository();
    public static Repository r3 = new Repository();
    public static Repository r4 = new Repository();
    public static ApartamenteServices ap = new ApartamenteServices(r1);
    public static PersoanaAdultaService pA = new PersoanaAdultaService(r2);
    public static PensionariService pS = new PensionariService(r3);
    public static MinoriServices m = new MinoriServices(r4);
    //public static ApartamenteFrame apF = new ApartamenteFrame();

    public MyFrame(){
        ap.setFile("Apartamente.txt");
        pA.setFile("Persoane(18-65).txt");
        pS.setFile("Persoane_pensionare.txt");
        m.setFile("Persoane_minore.txt");
        this.FramePrincipal();
    }

    public void FramePrincipal(){
        this.getContentPane().removeAll();
        this.repaint();

        buton1 = new JButton("Apartamente");
        buton1.setBounds(200,100,200,100); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        buton1.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        buton1.setFocusable(false); //asa nu se va focusa continutul butonului dupa prima sa executie,respectiv textul nu va fi incadrat
        buton1.setBackground(Color.BLACK);
        buton1.setForeground(Color.cyan);

        buton2 = new JButton("Persoane(18-65)");
        buton2.setBounds(200,250,200,100); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        buton2.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        buton2.setFocusable(false); //asa nu se va focusa continutul butonului dupa prima sa executie,respectiv textul nu va fi incadrat
        buton2.setBackground(Color.BLACK);
        buton2.setForeground(Color.cyan);

        buton3 = new JButton("Minori");
        buton3.setBounds(200,400,200,100); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        buton3.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        buton3.setFocusable(false); //asa nu se va focusa continutul butonului dupa prima sa executie,respectiv textul nu va fi incadrat
        buton3.setBackground(Color.BLACK);
        buton3.setForeground(Color.cyan);

        buton4 = new JButton("Pensionari");
        buton4.setBounds(200,550,200,100); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        buton4.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        buton4.setFocusable(false); //asa nu se va focusa continutul butonului dupa prima sa executie,respectiv textul nu va fi incadrat
        buton4.setBackground(Color.BLACK);
        buton4.setForeground(Color.cyan);

        this.setVisible(true); //clasa MyFrame mosteneste clasa JFrame,rin urmare se poate folosi referinta this pentru a acesa metodele clasei JFrame
        this.setTitle("Administrare Bloc");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//by default se ascunde doar gui-ul si ruleaza in fundal,dar asa se opreste executia
        this.setSize(1440,900);
        this.setResizable(false);
        ImageIcon img = new ImageIcon("C:\\Users\\danid\\OneDrive\\Desktop\\-\\JavaProjects\\AdministrareBloc\\src\\BlackBlocks.png");
        //ImageIcon img2 = new ImageIcon("C:\\Users\\danid\\OneDrive\\Desktop\\-\\JavaProjects\\AdministrareBloc\\src\\DarkBlue.png");
        this.setIconImage(img.getImage()); //imaginea aplicatiei,frame-ului central(coltul di  ddreapta sus)
        //this.setContentPane(new ImagePanel(img2.getImage()));
        try {
            String file = "C:\\Users\\danid\\OneDrive\\Desktop\\-\\JavaProjects\\AdministrareBloc\\src\\Nice.png";
            this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(file)))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //this.getContentPane().setBackground(new Color(182, 236, 236)); //setare culoare bakground
        this.setLayout(null); //by default se foloseste BorderLayout care organizeaza componentele,setat pe null mutarea componentelor se face maual
        this.add(buton1);
        this.add(buton2);
        this.add(buton3);
        this.add(buton4);

    }
    
    public void ApartamenteFRame()
    {
        this.getContentPane().removeAll();
        this.repaint();
        this.setTitle("Admninistrare bloc - Meniu Apartamente");

        back = new JButton("BACK");
        back.setBounds(10,10,80,50); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        back.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        back.setFocusable(false);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.cyan);

        addAp = new JButton("ADD");
        addAp.setBounds(200,100,200,100); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        addAp.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        addAp.setFocusable(false);
        addAp.setBackground(Color.BLACK);
        addAp.setForeground(Color.cyan);

        deleteAp = new JButton("DELETE");
        deleteAp.setBounds(200,210,200,100); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        deleteAp.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        deleteAp.setFocusable(false);
        deleteAp.setBackground(Color.BLACK);
        deleteAp.setForeground(Color.cyan);

        updateAp = new JButton("UPDATE");
        updateAp.setBounds(200,320,200,100); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        updateAp.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        updateAp.setFocusable(false);
        updateAp.setBackground(Color.BLACK);
        updateAp.setForeground(Color.cyan);

        showAp = new JButton("SHOW ALL");
        showAp.setBounds(200,430,200,100); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        showAp.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        showAp.setFocusable(false);
        showAp.setBackground(Color.BLACK);
        showAp.setForeground(Color.cyan);

        //this.setSize(620,630);

        this.add(back);
        this.add(addAp);
        this.add(deleteAp);
        this.add(updateAp);
        this.add(showAp);

    }

    public void AdultiFRame()
    {
        this.getContentPane().removeAll();
        this.repaint();
        this.setTitle("Admninistrare bloc - Meniu Apartamente");

        back = new JButton("BACK");
        back.setBounds(10,10,80,50); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        back.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        back.setFocusable(false);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.cyan);

        addA = new JButton("ADD");
        addA.setBounds(200,100,200,100); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        addA.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        addA.setFocusable(false);
        addA.setBackground(Color.BLACK);
        addA.setForeground(Color.cyan);

        deleteA = new JButton("DELETE");
        deleteA.setBounds(200,210,200,100); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        deleteA.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        deleteA.setFocusable(false);
        deleteA.setBackground(Color.BLACK);
        deleteA.setForeground(Color.cyan);

        updateA = new JButton("UPDATE");
        updateA.setBounds(200,320,200,100); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        updateA.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        updateA.setFocusable(false);
        updateA.setBackground(Color.BLACK);
        updateA.setForeground(Color.cyan);

        showA = new JButton("SHOW ALL");
        showA.setBounds(200,430,200,100); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        showA.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        showA.setFocusable(false);
        showA.setBackground(Color.BLACK);
        showA.setForeground(Color.cyan);

        //this.setSize(620,630);

        this.add(back);
        this.add(addA);
        this.add(deleteA);
        this.add(updateA);
        this.add(showA);

    }

    public void MinoriFRame()
    {
        this.getContentPane().removeAll();
        this.repaint();
        this.setTitle("Admninistrare bloc - Meniu Apartamente");

        back = new JButton("BACK");
        back.setBounds(10,10,80,50); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        back.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        back.setFocusable(false);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.cyan);

        addM = new JButton("ADD");
        addM.setBounds(200,100,200,100); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        addM.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        addM.setFocusable(false);
        addM.setBackground(Color.BLACK);
        addM.setForeground(Color.cyan);

        deleteM = new JButton("DELETE");
        deleteM.setBounds(200,210,200,100); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        deleteM.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        deleteM.setFocusable(false);
        deleteM.setBackground(Color.BLACK);
        deleteM.setForeground(Color.cyan);

        updateM = new JButton("UPDATE");
        updateM.setBounds(200,320,200,100); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        updateM.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        updateM.setFocusable(false);
        updateM.setBackground(Color.BLACK);
        updateM.setForeground(Color.cyan);

        showM = new JButton("SHOW ALL");
        showM.setBounds(200,430,200,100); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        showM.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        showM.setFocusable(false);
        showM.setBackground(Color.BLACK);
        showM.setForeground(Color.cyan);

        //this.setSize(620,630);

        this.add(back);
        this.add(addM);
        this.add(deleteM);
        this.add(updateM);
        this.add(showM);

    }

    public void PensonariFRame()
    {
        this.getContentPane().removeAll();
        this.repaint();
        this.setTitle("Admninistrare bloc - Meniu Apartamente");

        back = new JButton("BACK");
        back.setBounds(10,10,80,50); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        back.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        back.setFocusable(false);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.cyan);

        addP = new JButton("ADD");
        addP.setBounds(200,100,200,100); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        addP.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        addP.setFocusable(false);
        addP.setBackground(Color.BLACK);
        addP.setForeground(Color.cyan);

        deleteP = new JButton("DELETE");
        deleteP.setBounds(200,210,200,100); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        deleteP.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        deleteP.setFocusable(false);
        deleteP.setBackground(Color.BLACK);
        deleteP.setForeground(Color.cyan);

        updateP = new JButton("UPDATE");
        updateP.setBounds(200,320,200,100); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        updateP.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        updateP.setFocusable(false);
        updateP.setBackground(Color.BLACK);
        updateP.setForeground(Color.cyan);

        showP = new JButton("SHOW ALL");
        showP.setBounds(200,430,200,100); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        showP.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        showP.setFocusable(false);
        showP.setBackground(Color.BLACK);
        showP.setForeground(Color.cyan);

        //this.setSize(620,630);

        this.add(back);
        this.add(addP);
        this.add(deleteP);
        this.add(updateP);
        this.add(showP);

    }

    public void ApartamenteShowAll()
    {
        this.getContentPane().removeAll();
        this.repaint();
        this.setTitle("Administrare bloc - Tabel apartamente");

//        private int nrApartament = -1;
//        private String numeProprietar = null;
//        private int nrPersoane = 0;
//        private float suprafata = 0;

        backAp = new JButton("BACK");
        backAp.setBounds(10,10,80,50); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        backAp.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        backAp.setFocusable(false);
        backAp.setBackground(Color.BLACK);
        backAp.setForeground(Color.cyan);

        DefaultTableCellRenderer right = new DefaultTableCellRenderer();
        right.setHorizontalAlignment(JLabel.RIGHT);

        String[] coloane = new String[]{"Numar Apartamente", "Nume Proprietar", "Numar Persoane", "Suprafata"};
        int linii = ap.getAll().getSize();
        Object [][] data = new Object[linii][4];
        for(int i =0;i<linii;i++)
        {
            data[i][0] = ((Apartament)ap.getAll().getElemFromPos(i)).getNrApartament();
            data[i][1] = ((Apartament)ap.getAll().getElemFromPos(i)).getNumeProprietar();
            data[i][2] = ((Apartament)ap.getAll().getElemFromPos(i)).getNrPersoane();
            data[i][3] = ((Apartament)ap.getAll().getElemFromPos(i)).getSuprafata();
        }
//        DefaultTableModel table_model=new DefaultTableModel();
//        table_model.setDataVector(data,coloane);
        JTable table = new JTable(data,coloane)
        {
            public boolean isCellEditable(int data,int coloane)
            {
                return false;
            }

        };
        table.setFillsViewportHeight(true);
        //table.setBounds(0,70,560,linii * 40 + 40);
        table.setPreferredSize(new Dimension(560,linii * 40));
        table.setBackground(Color.BLACK);
        table.setForeground(Color.cyan);
        table.setSelectionBackground(Color.cyan);
        table.setGridColor(Color.BLUE);
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.lightGray);
        //header.setForeground(Color.black);
        TableColumnModel column;
        //TableColumn column = null;
        for (int i = 0; i < 5; i++) {
            column = table.getColumnModel();
            table.setRowHeight(40);
            if (i == 0) {
                column.getColumn(i).setPreferredWidth(140);
                //third column is bigger
            }
            if(i == 1){
                column.getColumn(i).setPreferredWidth(160);
            }
            if(i == 2){
                column.getColumn(i).setPreferredWidth(160);
                column.getColumn(i).setCellRenderer(right);
            }
            if(i == 3){
                column.getColumn(i).setPreferredWidth(100);
                column.getColumn(i).setCellRenderer(right);
            }
        }
        JScrollPane jp = new JScrollPane(table);
        jp.setPreferredSize(new Dimension(560,500));
        //jp.setBounds(0,0,560,linii * 40 + 40);
        jp.setForeground(Color.BLACK);
        JPanel panel = new JPanel();
        panel.add(jp);
        panel.setBounds(10,60,560,500);
        panel.setBackground(Color.BLACK);
        this.add(panel);
        this.add(backAp);
    }

    public void AdultiShowAll()
    {
        this.getContentPane().removeAll();
        this.repaint();
        this.setTitle("Administrare bloc - Tabel apartamente");


        backPers = new JButton("BACK");
        backPers.setBounds(10,10,80,50); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        backPers.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        backPers.setFocusable(false);
        backPers.setBackground(Color.BLACK);
        backPers.setForeground(Color.cyan);

        DefaultTableCellRenderer right = new DefaultTableCellRenderer();
        right.setHorizontalAlignment(JLabel.RIGHT);

        String[] coloane = new String[]{"Numele", "Apartament", "Data nasterii", "Profesie"};
        int linii = pA.getAll().getSize();
        Object [][] data = new Object[linii][4];
        for(int i =0;i<linii;i++)
        {
            data[i][0] = ((Persoana)pA.getAll().getElemFromPos(i)).getNumePersoana();
            data[i][1] = ((Persoana)pA.getAll().getElemFromPos(i)).getApartament();
            data[i][2] = ((Persoana)pA.getAll().getElemFromPos(i)).dataToString();
            data[i][3] = ((Persoana)pA.getAll().getElemFromPos(i)).getLocMunca();
        }
//        DefaultTableModel table_model=new DefaultTableModel();
//        table_model.setDataVector(data,coloane);
        JTable table = new JTable(data,coloane)
        {
            public boolean isCellEditable(int data,int coloane)
            {
                return false;
            }

        };
        table.setFillsViewportHeight(true);
        //table.setBounds(0,70,560,linii * 40 + 40);
        table.setPreferredSize(new Dimension(560,linii * 40));
        table.setBackground(Color.BLACK);
        table.setForeground(Color.cyan);
        table.setSelectionBackground(Color.cyan);
        table.setGridColor(Color.BLUE);
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.lightGray);
        //header.setForeground(Color.black);
        TableColumnModel column;
        //TableColumn column = null;
        for (int i = 0; i < 5; i++) {
            column = table.getColumnModel();
            table.setRowHeight(40);
            if (i == 0) {
                column.getColumn(i).setPreferredWidth(140);
                //third column is bigger
            }
            if(i == 1){
                column.getColumn(i).setPreferredWidth(160);
                column.getColumn(i).setCellRenderer(right);
            }
            if(i == 2){
                column.getColumn(i).setPreferredWidth(160);

            }
            if(i == 3){
                column.getColumn(i).setPreferredWidth(100);
            }
        }
        JScrollPane jp = new JScrollPane(table);
        jp.setPreferredSize(new Dimension(560,500));
        //jp.setBounds(0,0,560,linii * 40 + 40);
        jp.setForeground(Color.BLACK);
        JPanel panel = new JPanel();
        panel.add(jp);
        panel.setBounds(10,60,560,500);
        panel.setBackground(Color.BLACK);
        this.add(panel);
        this.add(backPers);
    }

    public void MinoriShowAll()
    {
        this.getContentPane().removeAll();
        this.repaint();
        this.setTitle("Administrare bloc - Tabel apartamente");

//        private int nrApartament = -1;
//        private String numeProprietar = null;
//        private int nrPersoane = 0;
//        private float suprafata = 0;

        backMinori = new JButton("BACK");
        backMinori.setBounds(10,10,80,50); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        backMinori.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        backMinori.setFocusable(false);
        backMinori.setBackground(Color.BLACK);
        backMinori.setForeground(Color.cyan);

        DefaultTableCellRenderer right = new DefaultTableCellRenderer();
        right.setHorizontalAlignment(JLabel.RIGHT);
        //nume, nrAp, data, buletin, sc, parinti
        String[] coloane = new String[]{"Numele", "Apartamentul", "Data nasterii","Scoala","Parintii"};
        int linii = m.getAll().getSize();
        Object [][] data = new Object[linii][5];
        for(int i =0;i<linii;i++)
        {
            data[i][0] = ((Minori)m.getAll().getElemFromPos(i)).getNumePersoana();
            data[i][1] = ((Minori)m.getAll().getElemFromPos(i)).getApartament();
            data[i][2] = ((Minori)m.getAll().getElemFromPos(i)).dataToString();
            data[i][3] = ((Minori)m.getAll().getElemFromPos(i)).getScoala();
            data[i][4] = ((Minori)m.getAll().getElemFromPos(i)).getParinti();
        }
//        DefaultTableModel table_model=new DefaultTableModel();
//        table_model.setDataVector(data,coloane);
        JTable table = new JTable(data,coloane)
        {
            public boolean isCellEditable(int data,int coloane)
            {
                return false;
            }

        };
        table.setFillsViewportHeight(true);
        //table.setBounds(0,70,560,linii * 40 + 40);
        table.setPreferredSize(new Dimension(870,linii * 40));
        table.setBackground(Color.BLACK);
        table.setForeground(Color.cyan);
        table.setSelectionBackground(Color.cyan);
        table.setGridColor(Color.BLUE);
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.lightGray);
        //header.setForeground(Color.black);
        TableColumnModel column;
        //TableColumn column = null;
        for (int i = 0; i < 5; i++) {
            column = table.getColumnModel();
            table.setRowHeight(40);
            if (i == 0) {
                column.getColumn(i).setPreferredWidth(200);
                //third column is bigger
            }
            if(i == 1){
                column.getColumn(i).setPreferredWidth(100);
                column.getColumn(i).setCellRenderer(right);
            }
            if(i == 2){
                column.getColumn(i).setPreferredWidth(120);
            }
            if(i == 3){
                column.getColumn(i).setPreferredWidth(200);
            }
            if(i == 4)
            {
                column.getColumn(i).setPreferredWidth(250);
            }
        }
        JScrollPane jp = new JScrollPane(table);
        jp.setPreferredSize(new Dimension(870,500));
        //jp.setBounds(0,0,560,linii * 40 + 40);
        jp.setForeground(Color.BLACK);
        JPanel panel = new JPanel();
        panel.add(jp);
        panel.setBounds(10,60,870,500);
        panel.setBackground(Color.BLACK);
        this.add(panel);
        this.add(backMinori);
    }

    public void PensionariShowAll()
    {
        this.getContentPane().removeAll();
        this.repaint();
        this.setTitle("Administrare bloc - Tabel apartamente");

//        private int nrApartament = -1;
//        private String numeProprietar = null;
//        private int nrPersoane = 0;
//        private float suprafata = 0;

        backPens = new JButton("BACK");
        backPens.setBounds(10,10,80,50); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        backPens.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        backPens.setFocusable(false);
        backPens.setBackground(Color.BLACK);
        backPens.setForeground(Color.cyan);

        DefaultTableCellRenderer right = new DefaultTableCellRenderer();
        right.setHorizontalAlignment(JLabel.RIGHT);
        //old.getNumePersoana(), old.getApartament(), old.getData(), old.getPensie(), old.isDizabilitat(), stats

        String[] coloane = new String[]{"Numele", "Apartament", "Data nasterii", "Pensia", "Dizabilitat","Status ingrijire"};
        int linii = pS.getAll().getSize();
        Object [][] data = new Object[linii][6];
        for(int i =0;i<linii;i++)
        {
            String diz = "Nu",in = "Nu";
            data[i][0] = ((Pensionari)pS.getAll().getElemFromPos(i)).getNumePersoana();
            data[i][1] = ((Pensionari)pS.getAll().getElemFromPos(i)).getApartament();
            data[i][2] = ((Pensionari)pS.getAll().getElemFromPos(i)).dataToString();
            data[i][3] = ((Pensionari)pS.getAll().getElemFromPos(i)).getPensie();
            if(((Pensionari)pS.getAll().getElemFromPos(i)).isDizabilitat())
                diz = "Da";
            if(((Pensionari)pS.getAll().getElemFromPos(i)).isIngrijit())
                in = "Da";
            data[i][4] = diz;
            data[i][5] = in;
        }
//        DefaultTableModel table_model=new DefaultTableModel();
//        table_model.setDataVector(data,coloane);
        JTable table = new JTable(data,coloane)
        {
            public boolean isCellEditable(int data,int coloane)
            {
                return false;
            }

        };
        table.setFillsViewportHeight(true);
        //table.setBounds(0,70,560,linii * 40 + 40);
        table.setPreferredSize(new Dimension(660,linii * 40));
        table.setBackground(Color.BLACK);
        table.setForeground(Color.cyan);
        table.setSelectionBackground(Color.cyan);
        table.setGridColor(Color.BLUE);
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.lightGray);
        //header.setForeground(Color.black);
        TableColumnModel column;
        //TableColumn column = null;
        //old.getNumePersoana(), old.getApartament(), old.getData(), old.getPensie(), old.isDizabilitat(), stats
        for (int i = 0; i < 6; i++) {
            column = table.getColumnModel();
            table.setRowHeight(40);
            if (i == 0) {
                column.getColumn(i).setPreferredWidth(200);
                //third column is bigger
            }
            if(i == 1){
                column.getColumn(i).setPreferredWidth(80);
                column.getColumn(i).setCellRenderer(right);
            }
            if(i == 2){
                column.getColumn(i).setPreferredWidth(120);
                //column.getColumn(i).setCellRenderer(right);
            }
            if(i == 3){
                column.getColumn(i).setPreferredWidth(100);
                column.getColumn(i).setCellRenderer(right);
            }
            if(i == 4){
                column.getColumn(i).setPreferredWidth(80);
                //column.getColumn(i).setCellRenderer(right);
            }
            if(i == 5){
                column.getColumn(i).setPreferredWidth(80);
                //column.getColumn(i).setCellRenderer(right);
            }
        }
        JScrollPane jp = new JScrollPane(table);
        jp.setPreferredSize(new Dimension(660,500));
        //jp.setBounds(0,0,560,linii * 40 + 40);
        jp.setForeground(Color.BLACK);
        JPanel panel = new JPanel();
        panel.add(jp);
        panel.setBounds(10,60,660,500);
        panel.setBackground(Color.BLACK);
        this.add(panel);
        this.add(backPens);
    }

    public void ApartamenteAdd()
    {
        this.getContentPane().removeAll();
        this.repaint();
        this.setTitle("Administrare bloc - Adaugare apartament");

        backAp = new JButton("BACK");
        backAp.setBounds(10,10,80,50); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        backAp.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        backAp.setFocusable(false);
        backAp.setBackground(Color.BLACK);
        backAp.setForeground(Color.cyan);

        numar = new JTextField("Numar:");
        nume = new JTextField("Nume proprietar:");
        persoane = new JTextField("Nr persoane:");
        suprafata = new JTextField("Suprafata:");

        adaugare = new JButton("Adaugare");
        adaugare.setBounds(200,520,100,80);
        adaugare.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        adaugare.setFocusable(false);
        adaugare.setBackground(Color.BLACK);
        adaugare.setForeground(Color.cyan);

        numar.setBounds(10,130,80,60);
        numar.setBackground(Color.BLACK);
        numar.setForeground(Color.cyan);
        numar.setCaretColor(Color.CYAN);
        numar.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                numar.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(numar.getText().equals("")) {
                    numar.setText("Numar:");
                }
            }
        });

        nume.setBounds(10,220,300,60);
        nume.setBackground(Color.BLACK);
        nume.setForeground(Color.cyan);
        nume.setCaretColor(Color.CYAN);
        nume.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                nume.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(nume.getText().equals("")) {
                    nume.setText("Nume proprietar:");
                }
            }
        });
        //nume.setPreferredSize(new Dimension(300,60));

        persoane.setBounds(10,320,100,60);
        persoane.setBackground(Color.BLACK);
        persoane.setForeground(Color.cyan);
        persoane.setCaretColor(Color.CYAN);
        persoane.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                persoane.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(persoane.getText().equals("")) {
                    persoane.setText("Nr persoane:");
                }
            }
        });

        suprafata.setBounds(10,420,120,60);
        suprafata.setBackground(Color.BLACK);
        suprafata.setForeground(Color.cyan);
        suprafata.setCaretColor(Color.CYAN);
        suprafata.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                suprafata.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(suprafata.getText().equals("")) {
                    suprafata.setText("Suprafata:");
                }
            }
        });

        this.add(backAp);
        this.add(adaugare);
        this.add(numar);
        this.add(nume);
        this.add(persoane);
        this.add(suprafata);
        //this.setSize(600,620);
    }

    public void ApartamenteDelete()
    {
        this.getContentPane().removeAll();
        this.repaint();
        this.setTitle("Administrare bloc - Sergere apartament");
        numar2 = new JTextField("Numar:");

        backAp = new JButton("BACK");
        backAp.setBounds(10,10,80,50); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        backAp.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        backAp.setFocusable(false);
        backAp.setBackground(Color.BLACK);
        backAp.setForeground(Color.cyan);


        stergere = new JButton("Stergere");
        stergere.setBounds(200,480,100,80);
        stergere.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        stergere.setFocusable(false);
        stergere.setBackground(Color.BLACK);
        stergere.setForeground(Color.cyan);

        numar2.setBounds(10,110,80,60);
        numar2.setBackground(Color.BLACK);
        numar2.setForeground(Color.cyan);
        numar2.setCaretColor(Color.CYAN);
        numar2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                numar2.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });

        this.add(backAp);
        this.add(stergere);
        this.add(numar2);
        //this.setSize(600,620);
    }

    public void ApartamenteUpdate()
    {
        this.getContentPane().removeAll();
        this.repaint();
        this.setTitle("Administrare bloc - Schimbarea proprietarului unui apartament");

        numar = new JTextField("Numar:");
        nume = new JTextField("Numele noului proprietar");

        backAp = new JButton("BACK");
        backAp.setBounds(10,10,80,50); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        backAp.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        backAp.setFocusable(false);
        backAp.setBackground(Color.BLACK);
        backAp.setForeground(Color.cyan);

        numar.setBounds(10,100,80,60);
        numar.setBackground(Color.BLACK);
        numar.setForeground(Color.cyan);
        numar.setCaretColor(Color.CYAN);
        numar.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                numar.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(numar.getText().equals("")) {
                    numar.setText("Numar:");
                }
            }
        });

        nume.setBounds(10,200,320,60);
        nume.setBackground(Color.BLACK);
        nume.setForeground(Color.cyan);
        nume.setCaretColor(Color.CYAN);
        nume.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                nume.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(nume.getText().equals("")) {
                    nume.setText("Numele noului proprietar:");
                }
            }
        });

        modificare = new JButton("Modificare");
        modificare.setBounds(200,480,100,80);
        modificare.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        modificare.setFocusable(false);
        modificare.setBackground(Color.BLACK);
        modificare.setForeground(Color.cyan);

        this.add(backAp);
        this.add(numar);
        this.add(nume);
        this.add(modificare);

    }

    public void ecranErori() {
        this.getContentPane().removeAll();
        this.repaint();
        this.setTitle("Eroare");
        try {
            String file2 = "C:\\Users\\danid\\OneDrive\\Desktop\\-\\JavaProjects\\AdministrareBloc\\src\\error.png";
            this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(file2)))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon img = new ImageIcon("C:\\Users\\danid\\OneDrive\\Desktop\\-\\JavaProjects\\AdministrareBloc\\src\\erno.png");
        //ImageIcon img2 = new ImageIcon("C:\\Users\\danid\\OneDrive\\Desktop\\-\\JavaProjects\\AdministrareBloc\\src\\DarkBlue.png");
        this.setIconImage(img.getImage());

        error = new JLabel("Numar invalid!");

        back = new JButton("BACK");
        back.setBounds(10,10,80,50); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
        back.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
        back.setFocusable(false);
        back.setBackground(Color.BLACK);

        back.setForeground(Color.cyan);

        //error = new JLabel("Eroare fratele meu!");
        error.setBounds(560,430,400,80);
//        error.setVerticalAlignment(SwingConstants.CENTER);
//        error.setHorizontalAlignment(SwingConstants.CENTER);
        error.setBackground(Color.BLACK);
        error.setForeground(Color.cyan);
        error.setFont(new Font("Calibri", Font.PLAIN,40));
        //error.setFont();

        this.add(error);
        this.add(back);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buton1) //se verifica obiectul returnat de eveniment(click)
        {

            //Main.menuApartamente();
            ApartamenteFRame();

        }

        if(e.getSource() == buton2)
        {
            AdultiFRame();
        }

        if(e.getSource() == buton3)
        {
            MinoriFRame();
        }

        if(e.getSource() == buton4)
        {
            PensonariFRame();
        }

        if(e.getSource() == back)
        {
            this.FramePrincipal();
        }

        if(e.getSource() == showAp)
        {
            ApartamenteShowAll();
        }

        if(e.getSource() == showA)
        {
            AdultiShowAll();
        }

        if(e.getSource() == showM)
        {
            MinoriShowAll();
        }

        if(e.getSource() == showP)
        {
            PensionariShowAll();
        }

        if(e.getSource() == addAp)
        {
            ApartamenteAdd();
        }

        if(e.getSource() == deleteAp)
        {
            ApartamenteDelete();
        }

        if(e.getSource() == adaugare)
        {
            int nr = Integer.parseInt(numar.getText());
            if (ap.searchForApartament(nr) != null)
            {
                ecranErori();
            }
            else {
                int nrPers = Integer.parseInt(persoane.getText());
                float sup = Float.parseFloat(suprafata.getText());
                Apartament apNou = new Apartament(nr, nume.getText(), nrPers, sup);
                ap.add(apNou);
                ApartamenteShowAll();
            }

        }

        if(e.getSource() == stergere)
        {
            int nr = Integer.parseInt(numar2.getText());
            if(ap.searchForApartament(nr) == null) {
                //System.out.println(ap.searchForApartament(nr) == null);
                ecranErori();
            }
            else {
                ap.delete(ap.searchForApartament(nr));
                ApartamenteShowAll();
            }
        }

        if(e.getSource() == updateAp)
        {
            ApartamenteUpdate();
        }

        if(e.getSource() == modificare)
        {
            int nr = Integer.parseInt(numar.getText());
            if(ap.searchForApartament(nr) == null) {
                ecranErori();
            }
            else {
                String numeProprietar = nume.getText();
                Apartament apartOld = (Apartament) ap.searchForApartament(nr);
                Apartament newAp = new Apartament(apartOld.getNrApartament(), numeProprietar, apartOld.getNrPersoane(), apartOld.getSuprafata());
                ap.update(apartOld, newAp);
                ApartamenteShowAll();
            }
        }

        if(e.getSource() == backAp)
        {
            ApartamenteFRame();
        }

        if(e.getSource() == backPers)
        {
            AdultiFRame();
        }

        if(e.getSource() == backPens)
        {
            PensonariFRame();
        }

        if(e.getSource() == backMinori)
        {
            MinoriFRame();
        }
    }


}
