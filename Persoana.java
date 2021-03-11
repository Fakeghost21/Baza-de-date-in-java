package Domain;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Persoana implements Elements {
    protected String nume = null;
    protected int nrAp = -1;
    protected GregorianCalendar data = null;
    private String locMunca = null;

    public Persoana()
    {

    }

    public Persoana(String nume,int nrAp,GregorianCalendar data)   //Constructor cu parametrii,respectiv primii 3 parametrii
    {
        this.nume = nume;
        this.nrAp = nrAp;
        this.data = data;
    }

    public Persoana(String nume,int nrAp,GregorianCalendar data,String munca) //Constructor cu parametrii,respectiv toti
    {                                                                       //toti parametrii
        this(nume,nrAp,data);    //utilizarea constructorului anterior
        this.locMunca = munca;
    }

    public String dataToString()
    {
        return this.data.get(Calendar.DATE) + "-" + (this.data.get(Calendar.MONTH) + 1) + "-" + this.data.get(Calendar.YEAR);
    }

    @Override
    public void copy(Elements e)
    {
        this.nume = ((Persoana) e).nume;
        this.data = ((Persoana) e).data;
        this.locMunca = ((Persoana) e).locMunca;
        this.nrAp = ((Persoana) e).nrAp;
    }

    @Override
    public boolean compare(Elements e)
    {
        return(this.nume.equals(((Persoana) e).nume));
    }

    @Override
    public String tostring(){
        return this.nume + "," + nrAp + "," + this.dataToString() + "," + this.locMunca;
    }


    public String getLocMunca() {
        return locMunca;
    }

    public void setLocMunca(String locMunca) {
        this.locMunca = locMunca;
    }

    public int getApartament()
    {
        return nrAp;
    }

    public void setApartament(int ap) {
        this.nrAp = ap;
    }

    public GregorianCalendar getData() {
        return data;
    }

    public void setData(GregorianCalendar data) {
        this.data = data;
    }

    public String getNumePersoana(){
        return this.nume;
    }

    public void setNumeLocatar(String nume){
        this.nume = nume;
    }

}
