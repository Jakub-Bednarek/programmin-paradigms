package zad3;

import zad1.EmptyQueueException;

public interface IQueueS<T> {
    boolean isEmpty();
    T dequeue() throws EmptyQueueException;
    void enqueue(T element);
    int size();
    T first() throws EmptyQueueException;
    void clear() throws EmptyQueueException;
}
