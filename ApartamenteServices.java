package Services;

import Domain.Apartament;
import Domain.Elements;
import Domain.VectorElemente;
import Repository.Repository;

public class ApartamenteServices {
    private Repository r;

    public ApartamenteServices(Repository r)
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

    public Elements searchForApartament(int nr) //Returneaza apartamentul cu numarul introdus la parametru,null daca u se gaseste
    {
        for(int i =0;i<getAll().getSize();i++)
        {
            if(((Apartament)this.r.getElemPos(i)).getNrApartament() == nr)
                return (this.r.getElemPos(i));
        }
    return null;
    }
/*
    public Elements searchForSurface(int surface) //returneaza apartamentul cu o anumita suprafata
    {
        for(int i =0;i<getAll().getSize();i++)
        {
            if(((Apartament)this.r.getElemPos(i)).getSuprafata() == surface)
                return (this.r.getElemPos(i));
        }
        return null;
    }


 */
    public void setFile(String file) //seteaza fisierul din care se va lucra si executa load from file
    {
        this.r.setFileName(file);
        this.r.loadFromFile();
    }

}
