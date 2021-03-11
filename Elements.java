package Domain;

public interface Elements {
    void copy(Elements e); //Copiaza toti parametrii obieectelor care implementeaza aceasta interfata
    boolean compare(Elements e);    //Compara parametrii obiectelor care implementeaza aceasta interfata
    String tostring(); //Transforma obiectul intr-un string de afisat si usor de inteles utilizatorului
}
