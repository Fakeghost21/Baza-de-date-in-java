//package GUI;
//
//import Domain.Apartament;
//import Repository.Repository;
//import Services.ApartamenteServices;
//
//import javax.swing.*;
//import javax.swing.table.DefaultTableCellRenderer;
//import javax.swing.table.JTableHeader;
//import javax.swing.table.TableColumnModel;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.FocusEvent;
//import java.awt.event.FocusListener;
//
//public class ApartamenteFrame extends JFrame implements ActionListener {
//    JButton addAp,deleteAp,updateAp,showAp,back,adaugare,stergere,modificare;
//    JTextField numar,nume,persoane,suprafata,numar2;
//    MyFrame mf = new MyFrame();
//    public static Repository r1 = new Repository();
//    //public static Repository r1 = new Repository();
//    public static ApartamenteServices ap = new ApartamenteServices(r1);
//
//    public ApartamenteFrame(){
//        ap.setFile("Apartamente.txt");
//        //this.ApartamenteFRame();
//    }
//
//    public void ApartamenteFRame()
//    {
//        //ap.setFile("Apartamente.txt");
////        this.getContentPane().removeAll();
////        this.repaint();
//        mf.getContentPane().removeAll();
//        mf.repaint();
//        mf.setTitle("Admninistrare bloc - Meniu Apartamente");
//
//        back = new JButton("BACK");
//        back.setBounds(10,10,80,50); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
//        back.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
//        back.setFocusable(false);
//        back.setBackground(Color.BLACK);
//        back.setForeground(Color.cyan);
//
//        addAp = new JButton("ADD");
//        addAp.setBounds(200,100,200,100); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
//        addAp.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
//        addAp.setFocusable(false);
//        addAp.setBackground(Color.BLACK);
//        addAp.setForeground(Color.cyan);
//
//        deleteAp = new JButton("DELETE");
//        deleteAp.setBounds(200,210,200,100); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
//        deleteAp.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
//        deleteAp.setFocusable(false);
//        deleteAp.setBackground(Color.BLACK);
//        deleteAp.setForeground(Color.cyan);
//
//        updateAp = new JButton("UPDATE");
//        updateAp.setBounds(200,320,200,100); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
//        updateAp.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
//        updateAp.setFocusable(false);
//        updateAp.setBackground(Color.BLACK);
//        updateAp.setForeground(Color.cyan);
//
//        showAp = new JButton("SHOW ALL");
//        showAp.setBounds(200,430,200,100); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
//        showAp.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
//        showAp.setFocusable(false);
//        showAp.setBackground(Color.BLACK);
//        showAp.setForeground(Color.cyan);
//
//        //this.setSize(620,630);
//
//        mf.add(back);
//        mf.add(addAp);
//        mf.add(deleteAp);
//        mf.add(updateAp);
//        mf.add(showAp);
//
//
//    }
//
//    public void ApartamenteShowAll()
//    {
//        mf.getContentPane().removeAll();
//        mf.repaint();
//        mf.setTitle("Administrare bloc - Tabel apartamente");
//
////        private int nrApartament = -1;
////        private String numeProprietar = null;
////        private int nrPersoane = 0;
////        private float suprafata = 0;
//
//        back = new JButton("BACK");
//        back.setBounds(10,10,80,50); //fara un layout setam manual pozitia butonului pe axele x si y cat si dimensiunea
//        back.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
//        back.setFocusable(false);
//        back.setBackground(Color.BLACK);
//        back.setForeground(Color.cyan);
//
//        DefaultTableCellRenderer right = new DefaultTableCellRenderer();
//        right.setHorizontalAlignment(JLabel.RIGHT);
//
//        String[] coloane = new String[]{"Numar Apartamente", "Nume Proprietar", "Numar Persoane", "Suprafata"};
//        int linii = ap.getAll().getSize();
//        Object [][] data = new Object[linii][4];
//        for(int i =0;i<linii;i++)
//        {
//            data[i][0] = ((Apartament)ap.getAll().getElemFromPos(i)).getNrApartament();
//            data[i][1] = ((Apartament)ap.getAll().getElemFromPos(i)).getNumeProprietar();
//            data[i][2] = ((Apartament)ap.getAll().getElemFromPos(i)).getNrPersoane();
//            data[i][3] = ((Apartament)ap.getAll().getElemFromPos(i)).getSuprafata();
//        }
////        DefaultTableModel table_model=new DefaultTableModel();
////        table_model.setDataVector(data,coloane);
//        JTable table = new JTable(data,coloane)
//        {
//            public boolean isCellEditable(int data,int coloane)
//            {
//                return false;
//            }
//
//        };
//        table.setFillsViewportHeight(true);
//        //table.setBounds(0,70,560,linii * 40 + 40);
//        table.setPreferredSize(new Dimension(560,linii * 40));
//        table.setBackground(Color.BLACK);
//        table.setForeground(Color.cyan);
//        table.setSelectionBackground(Color.cyan);
//        table.setGridColor(Color.BLUE);
//        JTableHeader header = table.getTableHeader();
//        header.setBackground(Color.lightGray);
//        //header.setForeground(Color.black);
//        TableColumnModel column;
//        //TableColumn column = null;
//        for (int i = 0; i < 5; i++) {
//            column = table.getColumnModel();
//            table.setRowHeight(40);
//            if (i == 0) {
//                column.getColumn(i).setPreferredWidth(140);
//                //third column is bigger
//            }
//            if(i == 1){
//                column.getColumn(i).setPreferredWidth(160);
//            }
//            if(i == 2){
//                column.getColumn(i).setPreferredWidth(160);
//                column.getColumn(i).setCellRenderer(right);
//            }
//            if(i == 3){
//                column.getColumn(i).setPreferredWidth(100);
//                column.getColumn(i).setCellRenderer(right);
//            }
//        }
//        JScrollPane jp = new JScrollPane(table);
//        jp.setPreferredSize(new Dimension(560,500));
//        //jp.setBounds(0,0,560,linii * 40 + 40);
//        jp.setForeground(Color.BLACK);
//        JPanel panel = new JPanel();
//        panel.add(jp);
//        panel.setBounds(10,60,560,500);
//        panel.setBackground(Color.BLACK);
//        mf.add(panel);
//        mf.add(back);
//    }
//
//    public void ApartamenteAdd()
//    {
//        mf.getContentPane().removeAll();
//        mf.repaint();
//        .setTitle("Administrare bloc - Adaugare apartament");
//        numar = new JTextField("Numar:");
//        nume = new JTextField("Nume proprietar:");
//        persoane = new JTextField("Nr persoane:");
//        suprafata = new JTextField("Suprafata:");
//
//        adaugare = new JButton("Adaugare");
//        adaugare.setBounds(200,480,100,80);
//        adaugare.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
//        adaugare.setFocusable(false);
//        adaugare.setBackground(Color.BLACK);
//        adaugare.setForeground(Color.cyan);
//
//        numar.setBounds(10,10,80,60);
//        numar.setBackground(Color.BLACK);
//        numar.setForeground(Color.cyan);
//        numar.setCaretColor(Color.CYAN);
//        numar.addFocusListener(new FocusListener() {
//            @Override
//            public void focusGained(FocusEvent e) {
//                numar.setText("");
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//                if(numar.getText().equals("")) {
//                    numar.setText("Numar:");
//                }
//            }
//        });
//
//        nume.setBounds(10,130,300,60);
//        nume.setBackground(Color.BLACK);
//        nume.setForeground(Color.cyan);
//        nume.setCaretColor(Color.CYAN);
//        nume.addFocusListener(new FocusListener() {
//            @Override
//            public void focusGained(FocusEvent e) {
//                nume.setText("");
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//                if(nume.getText().equals("")) {
//                    nume.setText("Nume proprietar:");
//                }
//            }
//        });
//        //nume.setPreferredSize(new Dimension(300,60));
//
//        persoane.setBounds(10,250,100,60);
//        persoane.setBackground(Color.BLACK);
//        persoane.setForeground(Color.cyan);
//        persoane.setCaretColor(Color.CYAN);
//        persoane.addFocusListener(new FocusListener() {
//            @Override
//            public void focusGained(FocusEvent e) {
//                persoane.setText("");
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//                if(persoane.getText().equals("")) {
//                    persoane.setText("Nr persoane:");
//                }
//            }
//        });
//
//        suprafata.setBounds(10,370,120,60);
//        suprafata.setBackground(Color.BLACK);
//        suprafata.setForeground(Color.cyan);
//        suprafata.setCaretColor(Color.CYAN);
//        suprafata.addFocusListener(new FocusListener() {
//            @Override
//            public void focusGained(FocusEvent e) {
//                suprafata.setText("");
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//                if(suprafata.getText().equals("")) {
//                    suprafata.setText("Suprafata:");
//                }
//            }
//        });
//
//        this.add(adaugare);
//        this.add(numar);
//        this.add(nume);
//        this.add(persoane);
//        this.add(suprafata);
//        //this.setSize(600,620);
//    }
//
//    public void ApartamenteDelete()
//    {
//        mf.REPAINT();
//        this.setTitle("Administrare bloc - Sergere apartament");
//        numar2 = new JTextField("Numar:");
//
//        stergere = new JButton("Stergere");
//        stergere.setBounds(200,480,100,80);
//        stergere.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
//        stergere.setFocusable(false);
//        stergere.setBackground(Color.BLACK);
//        stergere.setForeground(Color.cyan);
//
//        numar2.setBounds(10,10,80,60);
//        numar2.setBackground(Color.BLACK);
//        numar2.setForeground(Color.cyan);
//        numar2.setCaretColor(Color.CYAN);
//        numar2.addFocusListener(new FocusListener() {
//            @Override
//            public void focusGained(FocusEvent e) {
//                numar2.setText("");
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//            }
//        });
//
//
//        this.add(stergere);
//        this.add(numar2);
//        //this.setSize(600,620);
//    }
//
//    public void ApartamenteUpdate()
//    {
//        this.getContentPane().removeAll();
//        this.repaint();
//        this.setTitle("Administrare bloc - Schimbarea proprietarului unui apartament");
//
//        numar = new JTextField("Numar:");
//        nume = new JTextField("Numele noului proprietar");
//
//        numar.setBounds(10,10,80,60);
//        numar.setBackground(Color.BLACK);
//        numar.setForeground(Color.cyan);
//        numar.setCaretColor(Color.CYAN);
//        numar.addFocusListener(new FocusListener() {
//            @Override
//            public void focusGained(FocusEvent e) {
//                numar.setText("");
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//                if(numar.getText().equals("")) {
//                    numar.setText("Numar:");
//                }
//            }
//        });
//
//        nume.setBounds(10,130,320,60);
//        nume.setBackground(Color.BLACK);
//        nume.setForeground(Color.cyan);
//        nume.setCaretColor(Color.CYAN);
//        nume.addFocusListener(new FocusListener() {
//            @Override
//            public void focusGained(FocusEvent e) {
//                nume.setText("");
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//                if(nume.getText().equals("")) {
//                    nume.setText("Numele noului proprietar:");
//                }
//            }
//        });
//
//        modificare = new JButton("Modificare");
//        modificare.setBounds(200,480,100,80);
//        modificare.addActionListener(this); //deoarece clasa implementeaza ActionListner se foloseste referinta this
//        modificare.setFocusable(false);
//        modificare.setBackground(Color.BLACK);
//        modificare.setForeground(Color.cyan);
//
//        this.add(numar);
//        this.add(nume);
//        this.add(modificare);
//
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if(e.getSource() == back)
//        {
//            mf.FramePrincipal();
//        }
//
//        if(e.getSource() == showAp)
//        {
//            this.ApartamenteShowAll();
//        }
//
//        if(e.getSource() == addAp)
//        {
//            this.ApartamenteAdd();
//        }
//
//        if(e.getSource() == deleteAp)
//        {
//            this.ApartamenteDelete();
//        }
//
//        if(e.getSource() == adaugare)
//        {
//            int nr = Integer.parseInt(numar.getText());
//            if (ap.searchForApartament(nr) != null)
//            {
//                mf.ecranErori();
//            }
//            else {
//                int nrPers = Integer.parseInt(persoane.getText());
//                float sup = Float.parseFloat(suprafata.getText());
//                Apartament apNou = new Apartament(nr, nume.getText(), nrPers, sup);
//                ap.add(apNou);
//                this.ApartamenteShowAll();
//            }
//
//        }
//
//        if(e.getSource() == stergere)
//        {
//            int nr = Integer.parseInt(numar2.getText());
//            if(ap.searchForApartament(nr) == null) {
//                //System.out.println(ap.searchForApartament(nr) == null);
//                mf.ecranErori();
//            }
//            else {
//                ap.delete(ap.searchForApartament(nr));
//                this.ApartamenteShowAll();
//            }
//        }
//
//        if(e.getSource() == updateAp)
//        {
//            this.ApartamenteUpdate();
//        }
//
//        if(e.getSource() == modificare)
//        {
//            int nr = Integer.parseInt(numar.getText());
//            if(ap.searchForApartament(nr) == null) {
//                mf.ecranErori();
//            }
//            else {
//                String numeProprietar = nume.getText();
//                Apartament apartOld = (Apartament) ap.searchForApartament(nr);
//                Apartament newAp = new Apartament(apartOld.getNrApartament(), numeProprietar, apartOld.getNrPersoane(), apartOld.getSuprafata());
//                ap.update(apartOld, newAp);
//                this.ApartamenteShowAll();
//            }
//        }
//    }
//}
