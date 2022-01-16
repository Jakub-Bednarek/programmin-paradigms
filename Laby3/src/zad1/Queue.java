package zad1;

public class Queue<T> implements IQueue<T>{
    private int topIndex;
    private T[] array;

    public Queue(int size){
        topIndex = 0;
        array = (T[])(new Object[size]);
    }

    @Override
    public boolean isEmpty() {
        return topIndex == 0;
    }

    @Override
    public boolean isFull() {
        return topIndex == array.length;
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        T value = first();

        moveArrayToLeft();

        return value;
    }

    @Override
    public void enqueue(T element) throws FullQueueException {
        if(!isFull())
            array[topIndex++] = element;
        else
            throw new FullQueueException();
    }

    @Override
    public int size() {
        return topIndex;
    }

    @Override
    public T first() throws EmptyQueueException {
        if(!isEmpty())
            return array[0];
        else
            throw new EmptyQueueException();
    }

    @Override
    public void clear() throws EmptyQueueException {
        for(int i = 0; i < size(); i++){
            array[i] = null;
        }

        topIndex = 0;
    }

    private void moveArrayToLeft(){
        for(int i = 0; i < size() - 1; i++){
            array[i] = array[i + 1];
        }

        array[size() - 1] = null;
        topIndex--;
    }
}
