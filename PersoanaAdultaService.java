package Services;

import Domain.Apartament;
import Domain.Elements;
import Domain.Persoana;
import Domain.VectorElemente;
import Repository.Repository;

public class PersoanaAdultaService {
    private Repository r;

    public PersoanaAdultaService(Repository r)
    {
        this.r = r;
    }

    public void add(Elements objNew){
        this.r.add(objNew);
    }

    public void delete(Elements objDel)
    {
        this.r.delete(objDel);
    }

    public void update(Elements old,Elements newObj)
    {
        this.r.update(newObj,old);
    }

    public VectorElemente getAll()
    {
        return this.r.getAll();
    }

    public void setFile(String file)
    {
        this.r.setFileName(file);
        this.r.loadFromFile();
    }

    public Persoana searchNume(String nume)
    {
        for(int i =0;i<getAll().getSize();i++)
        {
            if(((Persoana)this.r.getElemPos(i)).getNumePersoana().equals(nume))
                return ((Persoana)this.r.getElemPos(i));
        }
        return null;
    }

    public void deletePersAp(int nr)
    {
        int i = 0;
        while(i<this.r.getSize())
        {
            if(((Persoana)this.r.getElemPos(i)).getApartament() == nr)
            {this.r.delete(this.r.getElemPos(i));
            i--;}
            i++;

        }
        this.r.saveToFile();

    }
}
