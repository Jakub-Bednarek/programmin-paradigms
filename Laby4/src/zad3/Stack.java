package zad3;

import java.util.EmptyStackException;

public class Stack<E> {
    private LinkedList<E> list;

    public Stack(){
        list = new LinkedList<>();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public E pop() throws EmptyStackException {
        try{
            return list.deleteIndex(list.size() - 1).getValue();
        } catch(NullPointerException e){
            throw new EmptyStackException();
        }
    }

    public void push(E element){
        list.addEnd(element);
    }

    public int size(){
        return list.size();
    }

    public E top(){
        return list.get(list.size() - 1);
    }
}
