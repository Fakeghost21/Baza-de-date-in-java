package View;

import Domain.Apartament;
import Domain.Minori;
import Domain.Pensionari;
import Domain.Persoana;
import Services.ApartamenteServices;
import Services.MinoriServices;
import Services.PensionariService;
import Services.PersoanaAdultaService;

public class Afisare {
    public static void afisareApartamente(ApartamenteServices ap)
    {
        CapTabel.capTabelApartament();
        int i = 0;
        while (i < ap.getAll().getSize()) {
            System.out.format("|%-9d|%-23s|%21d|%11.2f|\n", ((Apartament)ap.getAll().getElemFromPos(i)).getNrApartament(),
                    ((Apartament)ap.getAll().getElemFromPos(i)).getNumeProprietar(),((Apartament)ap.getAll().getElemFromPos(i)).getNrPersoane(),
            ((Apartament)ap.getAll().getElemFromPos(i)).getSuprafata());    //afisare formatata
            i++;
        }
        String linii="=====================================================================";
        System.out.println(linii);
    }

    public static void afisareAdulti(PersoanaAdultaService p)
    {
        CapTabel.capTabelAuli();
        int i = 0;
        while(i < p.getAll().getSize())
        {
            System.out.format("|%-22s|%24d|%-17s|%-21s|\n", ((Persoana)p.getAll().getElemFromPos(i)).getNumePersoana(),
                    ((Persoana)p.getAll().getElemFromPos(i)).getApartament(),((Persoana)p.getAll().getElemFromPos(i)).dataToString(),
                    ((Persoana)p.getAll().getElemFromPos(i)).getLocMunca());
            i++;
        }
        String linii="=========================================================================================";
        System.out.println(linii);
    }

    public static void afisarePensionari(PensionariService pS)
    {
        CapTabel.capTabelPensionari();
        int i = 0;
        while(i < pS.getAll().getSize())
        {
            System.out.format("|%-22s|%24d|%-17s|%8.2f|%-13s|%-11s|\n", ((Pensionari)pS.getAll().getElemFromPos(i)).getNumePersoana(),
                    ((Pensionari)pS.getAll().getElemFromPos(i)).getApartament(),((Pensionari)pS.getAll().getElemFromPos(i)).dataToString(),
                    ((Pensionari)pS.getAll().getElemFromPos(i)).getPensie(),((Pensionari)pS.getAll().getElemFromPos(i)).isDizabilitat(),
                    ((Pensionari)pS.getAll().getElemFromPos(i)).isIngrijit());
            i++;
        }
        String linii="======================================================================================================";
        System.out.println(linii);
    }

    public static void afisareMinori(MinoriServices m)
    {
        CapTabel.capTabelMinori();
        int i = 0;
        while(i < m.getAll().getSize())
        {
            System.out.format("|%-22s|%24d|%-17s|%9s|%-19s|%-35s|\n", ((Minori)m.getAll().getElemFromPos(i)).getNumePersoana(),
                    ((Minori)m.getAll().getElemFromPos(i)).getApartament(),((Minori)m.getAll().getElemFromPos(i)).dataToString(),
                    ((Minori)m.getAll().getElemFromPos(i)).isBuletin(),((Minori)m.getAll().getElemFromPos(i)).getScoala(),
                    ((Minori)m.getAll().getElemFromPos(i)).getParinti());
            i++;
        }
        String linii="=====================================================================================================================================";
        System.out.println(linii);
    }

}
