package Domain;

import java.util.GregorianCalendar;

public class Pensionari extends Persoana {
    private float pensie;
    private boolean dizabilitat;
    private boolean ingrijit;

    public Pensionari(String nume,int nrAp,GregorianCalendar data,float pensie,boolean dez,
                      boolean ingrijit){
        super(nume,nrAp,data);
        this.pensie = pensie;
        this.dizabilitat = dez;
        this.ingrijit = ingrijit;

    }

    @Override
    public void copy(Elements e)
    {
       if(e instanceof Pensionari)
       {
           this.nume = ((Pensionari) e).nume;
           this.data = ((Pensionari) e).data;
           this.nrAp = ((Pensionari) e).nrAp;
           this.ingrijit = ((Pensionari) e).ingrijit;
           this.dizabilitat = ((Pensionari) e).dizabilitat;
           this.pensie = ((Pensionari) e).pensie;
       }

    }

    @Override
    public boolean compare(Elements e)
    {
        if(e instanceof  Pensionari)
            return(this.nume.equals(((Pensionari) e).nume));
        return false;
    }

    @Override
    public String tostring()
    {
        return this.nume + "," + nrAp + "," + this.dataToString() + "," + this.pensie +
                "," + this.dizabilitat + "," + this.ingrijit;
    }


    public float getPensie() {
        return pensie;
    }

    public void setPensie(float pensie) {
        this.pensie = pensie;
    }

    public boolean isDizabilitat() {
        return dizabilitat;
    }

    public void setDizabilitat(boolean dizabilitat) {
        this.dizabilitat = dizabilitat;
    }

    public boolean isIngrijit() {
        return ingrijit;
    }

    public void setIngrijit(boolean ingrijit) {
        this.ingrijit = ingrijit;
    }
}
