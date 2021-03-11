package Domain;

public class VectorElemente {
    private int size;
    private int capacity;
    private Elements[] elem;

    public VectorElemente(int c)
    {
        size = 0;
        capacity = c;
        elem = new Elements[capacity];
    }

    private void doubleTheCapacity()//dubleaza capacitatea vectorului de elemente,mutandu-le intr-un array auxiliar cu dubla
    {                                // capacitate si apoi din nou in array-ul de elemente din vector
        Elements[] aux = new Elements[this.capacity*2];
        for(int i = 0;i<this.size;i++)
        {
            aux[i] = this.elem[i];
        }
        this.elem = aux;
        this.capacity = this.capacity*2;
    }

    public void add(Elements e)
    {
        if(size == capacity)    //daca nu mai este spatiu in vector capacitatea acestuia se dubleaza si apoi se adauga
            doubleTheCapacity();
        elem[this.size++] = e;
    }

    public void delete(Elements e)
    {
        int index = 0;
        for(int i = 0;i<this.size;i++)  //cauta pozitia elementului de sters
        {
            if(elem[i].compare(e)) {
                index = i;
                break;
            }
        }
        for(int i = index;i<this.size - 1;i++) //de la pozitia elementului de sters toate elementele se muta cu o pozitie in spate
            elem[i].copy(elem[i+1]);
        this.size--;
    }

    public int getSize()
    {
        return this.size;
    }

    public Elements getElemFromPos(int index) //returneaza elemntul din vector de la o anumita pozitie,null daca nu se gaseste
    {
        for(int i = 0;i<this.size;i++)
        {
            if(i == index)
                return elem[i];
        }
        return null;
    }

    public boolean contains(Elements e) //true daca exista elemntul introdus ca parametru,false altfel
    {
        for(int i = 0;i< this.size;i++)
            if(elem[i].compare(e))
                return true;
        return false;
    }
}
