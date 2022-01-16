package zad2;

public interface IStack<T> {
    boolean isEmpty();
    T pop() throws EmptyStackException;
    void push(T element);
    void clear();
    int size();
    T top() throws EmptyStackException;
}
