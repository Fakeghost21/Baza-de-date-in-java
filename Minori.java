package Domain;

import java.util.GregorianCalendar;

public class Minori extends Persoana{
    private boolean buletin;
    private String scoala;
    private String parinti;

    public Minori(String nume, int nrAp, GregorianCalendar data, boolean b,String sc,String parinti)
    {
        super(nume,nrAp,data);
        this.buletin = b;
        this.scoala = sc;
        this.parinti = parinti;
    }

    public boolean isBuletin() {
        return buletin;
    }

    public void setBuletin(boolean buletin) {
        this.buletin = buletin;
    }

    public String getScoala() {
        return scoala;
    }

    public void setScoala(String scoala) {
        this.scoala = scoala;
    }

    public String getParinti() {
        return parinti;
    }

    public void setParinti(String parinti) {
        this.parinti = parinti;
    }

    @Override
    public void copy(Elements e)
    {
        this.nume = ((Minori) e).nume;
        this.data = ((Minori) e).data;
        this.nrAp = ((Minori) e).nrAp;
        this.parinti = ((Minori) e).parinti;
        this.scoala = ((Minori) e).scoala;
        this.buletin = ((Minori) e).buletin;

    }

    @Override
    public boolean compare(Elements e)
    {
        return(this.nrAp == (((Minori) e).nrAp) && this.data.equals(((Minori) e).data) &&
                this.nume.equals(((Minori) e).nume) && this.parinti.equals(((Minori) e).parinti));
    }

    @Override
    public String tostring(){
        String b;
        if(!this.buletin)
        {
            b = "sub 14 ani";
        }
        else b = "peste 14 ani";
        return this.nume + "," + nrAp + "," + this.dataToString() + "," + b + "," + this.parinti +
                "," + this.scoala;
    }
}
