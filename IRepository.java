package Repository;

import Domain.Elements;
import Domain.VectorElemente;

public interface IRepository {
    void saveToFile(); //salveaza in fisier
    void loadFromFile(); //in functie de numele fisierului preia datele din fisier
    void setFileName(String fileName);
    void add(Elements objNew); //adauga element in repo
    void update(Elements newObj,Elements oldObj); //Inlocuieste al doilea parametru cu primul in repo
    int getSize();
    void delete(Elements obj); //sterge obiectul primit ca parametru
    boolean contains(Elements obj); //verifica daca exista elementul din parametru in repo
    Elements getElemPos(int pos); //Returneaza elementul de pe pozitia data in parametru
    VectorElemente getAll(); //returneaza vectorul de elemente
}
