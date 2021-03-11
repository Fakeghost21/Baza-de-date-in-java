/*
package Repository;

import Domain.Apartament;
import Domain.Persoana;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TesteRepo {
    @Test
    public void testFunctionalitati()
    {
        Repository r = new Repository();
        Repository r2 = new Repository();
        Apartament ap1 = new Apartament(7,"Boaba Ioan",3,45);
        GregorianCalendar gc1 = new GregorianCalendar(2000, Calendar.JANUARY,21);
        Persoana p1 = new Persoana("Boaba Grigore",ap1,gc1,"Carrefour");

        Apartament ap2 = new Apartament(9,"Boaba Ioan Marcel",3,48);
        GregorianCalendar gc2 = new GregorianCalendar(2001, Calendar.MARCH,23);
        Persoana p2 = new Persoana("Boaba Randalf",ap2,gc2,"Zugrav");

        Apartament ap3 = new Apartament(7,"Boaba Ioan",3,45);
        GregorianCalendar gc3 = new GregorianCalendar(2000, Calendar.JANUARY,21);
        Persoana p3 = new Persoana("Boaba Grigore",ap1,gc3,"Carrefour");

        Apartament ap4 = new Apartament(21,"Harfa Pavel",5,82);
        GregorianCalendar gc4 = new GregorianCalendar(1978, Calendar.AUGUST,30);
        Persoana p4 = new Persoana("Harfa Grigore",ap1,gc3,"IT Tester");

        assert (r.getSize() == 0);
        r.add(p1);
        assert (r.contains(p1));
        assert (r.getElemPos(0).compare(p1));
        assert (r.getSize() == 1);
        r.add(p2);
        r.add(p3);
        assert(r.getSize() == 3);
        r.update(p4,p1);
        assert (r.getElemPos(0).compare(p4));
        assert(r.contains(p4));
        r.delete(p4);
        assert(r.getSize() == 2);
        assert(!r.contains(p4));

        r2.add(ap2);
        r2.add(ap3);
        r2.add(ap4);
        r2.delete(ap3);
        assert (r2.contains(ap3)); //ap4 devine ap3
        assert(r2.getSize() == 2);

        Repository f = new Repository("Teste.txt");
        f.add(ap1);
        f.add(ap2);
        f.delete(ap1);
        f.update(ap4,ap1);

    }
}
*/