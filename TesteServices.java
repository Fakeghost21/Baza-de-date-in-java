package Services;

import Domain.Apartament;
import Repository.Repository;
import org.junit.Test;

public class TesteServices {
    @Test
    public void testApartamente()
    {
        Repository r = new Repository();
        ApartamenteServices s = new ApartamenteServices(r);
        Apartament ap1 = new Apartament(7,"Boaba Ioan",3,45);
        Apartament ap2 = new Apartament(9,"Boaba Marcel",3,48);
        Apartament ap3 = new Apartament(71,"Boaba Ioanel",5,49);
        Apartament ap4 = new Apartament(21,"Harfa Pavel",5,82);
        s.add(ap1);
        s.add(ap2);
        s.add(ap3);
        s.add(ap4);

        Apartament ap5 = new Apartament(9,"Boaba Marcel",3,48);
        Apartament ap6 = new Apartament(7,"Boaba Ioan",3,45);
        assert(s.getAll().getSize() == 4);
        assert(s.searchForApartament(7)!=null);
        assert(s.getAll().getElemFromPos(0).compare(ap1));
        assert(s.getAll().contains(ap5));
        for(int i = 0;i<s.getAll().getSize();i++)
            System.out.println(s.getAll().getElemFromPos(i).tostring());
        s.delete(ap2);
        assert(s.getAll().getSize() == 3);
        assert(!s.getAll().contains(ap5));
        s.update(ap1,ap5);
        for(int i = 0;i<s.getAll().getSize();i++)
            System.out.println(s.getAll().getElemFromPos(i).tostring());
        assert(s.searchForApartament(7)==null);
        //assert(s.searchForApartament(7) == null);
        //assert(s.getAll().contains(ap2));
    }
}
