package Domain;

public class Apartament implements Elements{
    private int nrApartament = -1;
    private String numeProprietar = null;
    private int nrPersoane = 0;
    private float suprafata = 0;

    public Apartament(){

    }

    public Apartament(int nrApartament,String numeProprietar,int nrPersoane,float suprafata)    //Constructor cu parametrii
    {
        this.nrApartament = nrApartament;
        this.numeProprietar = numeProprietar;
        this.nrPersoane = nrPersoane;
        this.suprafata = suprafata;
    }


    public String getNumeProprietar() {
        return numeProprietar;
    }

    public void setNumeProprietar(String numeProprietar) {
        this.numeProprietar = numeProprietar;
    }

    public int getNrPersoane() {
        return nrPersoane;
    }

    public void setNrPersoane(int nrPersoane) {
        this.nrPersoane = nrPersoane;
    }

    public float getSuprafata() {
        return suprafata;
    }

    public void setSuprafata(float suprafata) {
        this.suprafata = suprafata;
    }

    public int getNrApartament() {
        return nrApartament;
    }

    public void setNrApartament(int nrApartament) {
        this.nrApartament = nrApartament;
    }

    @Override
    public void copy(Elements e) {
        this.suprafata = ((Apartament)e).suprafata;
        this.nrPersoane = ((Apartament) e).nrPersoane;
        this.numeProprietar = ((Apartament) e).numeProprietar;
        this.nrApartament = ((Apartament) e).nrApartament;
    }

    @Override
    public boolean compare(Elements e) {
        return(this.nrApartament == ((Apartament) e).nrApartament);
    }

    @Override
    public String tostring()
    {
        return this.nrApartament + "," + this.numeProprietar + "," + this.nrPersoane + "," + this.suprafata;
    }
}
