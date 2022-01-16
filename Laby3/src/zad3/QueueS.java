package zad3;

import zad1.EmptyQueueException;
import zad1.FullQueueException;
import zad2.Stack;

public class QueueS<T> implements IQueueS<T>, Cloneable {
    private Stack<T> main;
    private Stack<T> helper;
    private int topIndex;

    public QueueS()
    {
        main = new Stack<>();
        helper = new Stack<>();
        topIndex = 0;
    }

    @Override
    public boolean isEmpty() {
        return main.isEmpty();
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if(isEmpty())
            throw new EmptyQueueException();

        topIndex--;
        return removeFirstItem();
    }

    @Override
    public void enqueue(T element) throws FullQueueException {
        main.push(element);

        topIndex++;
    }

    @Override
    public int size() {
        return topIndex;
    }

    @Override
    public T first() throws EmptyQueueException {
       return getFirstItem();
    }

    @Override
    public void clear() throws EmptyQueueException {
        main.clear();
        topIndex = 0;
    }

    @Override
    public QueueS<T> clone() throws CloneNotSupportedException {
        try{
            return (QueueS<T>)super.clone();
        } catch(CloneNotSupportedException e){
            System.out.println("Clone not available");
            return null;
        }
    }

    private T getFirstItem(){
        helper.clear();

        int currentSize = main.size() - 1;
        for(int i = 0; i < currentSize; i++){
            helper.push(main.pop());
        }

        T element = main.pop();
        helper.push(element);
        main = reverseStack(helper);

        return element;
    }

    private T removeFirstItem()
    {
        helper.clear();

        int currentSize = main.size() - 1;
        for(int i = 0; i < currentSize; i++){
            helper.push(main.pop());
        }

        T element = main.pop();
        main = reverseStack(helper);

        return element;
    }

    public Stack<T> reverseStack(Stack<T> stack)
    {
        Stack<T> second = new Stack<>();

        while(!stack.isEmpty()){
            second.push(stack.pop());
        }

        return second;
    }
}
