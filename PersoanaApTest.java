/*
package Domain;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class PersoanaApTest {


    @Test
    public void testConstructor(){
        Apartament ap = new Apartament(7,"Boaba Ioan",3,45);
        GregorianCalendar gc = new GregorianCalendar(2000, Calendar.JANUARY,21);
        Persoana p = new Persoana("Boaba Grigore",ap,gc,"Carrefour");
        assert(p.getLocMunca().equals("Carrefour"));
        assert(p.getNumePersoana().equals("Boaba Grigore"));
        assert(p.getNumeProprietar().equals("Boaba Ioan"));
        assert(p.getData().get(Calendar.DATE) == 21);
        assert(p.getApartament().getNrApartament() == 7);
        assert(p.getApartament().getNrPersoane() == 3);
        assert(p.getApartament().getNumeProprietar().equals("Boaba Ioan"));
        assert(p.getApartament().getSuprafata() == 45);
        System.out.println("Testele au ruat cu succes pentru constructor");
    }

    @Test
    public void testComparare(){
        Apartament ap1 = new Apartament(7,"Boaba Ioan",3,45);
        GregorianCalendar gc1 = new GregorianCalendar(2000, Calendar.JANUARY,21);
        Persoana p1 = new Persoana("Boaba Grigore",ap1,gc1,"Carrefour");

        Apartament ap2 = new Apartament(9,"Boaba Ioan Marcel",3,48);
        GregorianCalendar gc2 = new GregorianCalendar(2001, Calendar.MARCH,23);
        Persoana p2 = new Persoana("Boaba Randalf",ap2,gc2,"Zugrav");

        Apartament ap3 = new Apartament(7,"Boaba Ioan",3,45);
        GregorianCalendar gc3 = new GregorianCalendar(2000, Calendar.JANUARY,21);
        Persoana p3 = new Persoana("Boaba Grigore",ap1,gc3,"Carrefour");

        assert (!p1.compare(p2));
        assert (!p3.compare(p2));
        assert (p1.compare(p3));
        System.out.println("Testele au ruat cu succes pentru comparator");
    }

    @Test
    public void testCopiere()
    {

        Apartament ap3 = new Apartament(7,"Boaba Ioan",3,45);
        GregorianCalendar gc3 = new GregorianCalendar(2000, Calendar.JANUARY,21);
        Persoana p3 = new Persoana("Boaba Grigore",ap3,gc3,"Carrefour");

        Apartament ap4 = new Apartament();
        Persoana p4 = new Persoana();

        ap4.copy(ap3);
        p4.copy(p3);
        assert (p4.compare(p3));
    }

}
*/