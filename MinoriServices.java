package Services;

import Domain.Elements;
import Domain.Minori;
import Domain.Persoana;
import Domain.VectorElemente;
import Repository.Repository;

public class MinoriServices {
    private Repository r;

    public MinoriServices(Repository r)
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

    public Minori searchNume(String nume) //Cauta o persoana dupa nume si o returneaza,null daca nu se gaseste
    {
        for(int i =0;i<getAll().getSize();i++)
        {
            if(((Minori)this.r.getElemPos(i)).getNumePersoana().equals(nume))
                return ((Minori)this.r.getElemPos(i));
        }
        return null;
    }

    public void deletePersAp(int nr) //Sterge persoana cu un anumit numar de apartament
    {
        int i = 0;
        while(i<this.r.getSize())
        {
            if(((Minori)this.r.getElemPos(i)).getApartament() == nr)
            {this.r.delete(this.r.getElemPos(i));
                i--;}
            i++;

        }
        this.r.saveToFile();

    }
}
