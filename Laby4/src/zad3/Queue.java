package zad3;

public class Queue<E> {
    private LinkedList<E> list;

    public Queue() { list = new LinkedList<>(); }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void enqueue(E element){
        list.addEnd(element);
    }

    public E dequeue() throws EmptyQueueException {
        try{
            return list.deleteIndex(0).getValue();
        } catch(NullPointerException e){
            throw new EmptyQueueException();
        }
    }

    public E first(){
        return list.get(0);
    }

    public int size(){
        return list.size();
    }


}
