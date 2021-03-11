package View;

public class CapTabel {
    public static void capTabelApartament()
    {
        String ap = "| Numarul | Numele proprietarului | Numarul de persoane | Suprafata |";
        String linii="=====================================================================";
        System.out.println(linii);
        System.out.println(ap);
        System.out.println(linii);
    }

    public static void capTabelAuli()
    {
        String ap = "|         Nume         | Numarul apartamentului | Data de nastere |     Loc de munca    |";
        String linii="=========================================================================================";
        System.out.println(linii);
        System.out.println(ap);
        System.out.println(linii);
    }

    public static void capTabelPensionari()
    {
        String ap = "|         Nume         | Numarul apartamentului | Data de nastere | Pensie | Dizabilitat | Sprijinit |";
        String linii="======================================================================================================";
        System.out.println(linii);
        System.out.println(ap);
        System.out.println(linii);
    }

    public static void capTabelMinori()
    {
        String ap = "|         Nume         | Numarul apartamentului | Data de nastere | Buletin |      Scoala      |                Parinti             |";
        String linii="=====================================================================================================================================";
        System.out.println(linii);
        System.out.println(ap);
        System.out.println(linii);
    }
}
