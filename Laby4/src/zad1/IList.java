package zad1;

public interface IList<E> {
    void addEnd(E e);
    void insert(int pos, E e);
    E get(int pos);
    void set(int pos, E e);
    boolean contains(E e);
    int size();
    void clear();
    Element deleteIndex(int pos);
    boolean delete(E e);
    E deleteEl(Element e);
}
