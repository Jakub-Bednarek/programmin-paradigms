package zad1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HeapPriorityQueue<T> {
    private List<T> list;
    private final Comparator<T> comparator;

    public HeapPriorityQueue(Comparator<T> comparator){
        this.list = new ArrayList<>();
        this.comparator = comparator;
    }

    public void enqueue(T value){
        list.add(value);
        swim(list.size() - 1);
    }

    public T dequeue() throws EmptyQueueException {
        if(list.isEmpty())
            throw new EmptyQueueException();
        T result = list.get(0);

        if(list.size() > 1){
            list.set(0, list.get(list.size() - 1));
            sink(0);
        }

        list.remove(list.size() - 1);
        return result;
    }

    public void changePriority(int index, T priority) throws IndexOutOfBoundsException{
        if(index > list.size() - 1)
            throw new IndexOutOfBoundsException();

        int result = comparator.compare(list.get(index), priority);
        list.set(index, priority);

        if(result > 0){
            sink(index);
        } else if(result < 0){
            swim(index);
        }
    }

    public void delete(int index){
        swap(index, list.size() - 1);
        list.remove(list.size() - 1);

        if(!((index + 1 ) * 2 >= list.size())){
            sink(index);
        }
    }

    public List<T> getSortedList(){
        List<T> sorted = new ArrayList<>();

        while(list.size() > 0){
            sorted.add(0, list.get(0));
            swap(0, list.size() - 1);
            list.remove(list.size() - 1);

            sink(0);
        }

        list = sorted;

        return list;
    }

    public void clear() {
        list.clear();
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public T first() throws EmptyQueueException {
        if(list.isEmpty())
            throw new EmptyQueueException();
        else
            return list.get(0);
    }

    private void swap(int index1, int index2){
        T temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    private void swim(int index){
        int parent;

        while(index != 0 && comparator.compare(list.get(index), list.get(parent = (index - 1) / 2)) > 0){
            swap(index, parent);
            index = parent;
        }
    }

    private void sink(int index){
        boolean isDone = false;
        int child;

        while(!isDone && (child = 2 * index + 1) < list.size()){
            if(child < list.size() - 1 && comparator.compare(list.get(child), list.get(child + 1)) < 0){
                ++child;
            }
            if(comparator.compare(list.get(index), list.get(child)) < 0){
                swap(index, child);
                index = child;
            } else {
                isDone = true;
            }
        }
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
