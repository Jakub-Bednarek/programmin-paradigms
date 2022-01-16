package zad2;

public class Stack<T> implements IStack<T>{
    private int topIndex;
    private T[] array;

    public Stack(){
        topIndex = 0;
        array = (T[])(new Object[10]);
    }

    @Override
    public boolean isEmpty() {
        return topIndex == 0;
    }

    @Override
    public T pop() throws EmptyStackException {
        if(!isEmpty()){
            if(size() <= array.length * 0.25)
                halfSize();

            return array[--topIndex];
        }

        throw new EmptyStackException();
    }

    @Override
    public void push(T element) {
        if(size() >= array.length * 0.75)
            enlarge();

        array[topIndex++] = element;
    }

    @Override
    public int size() {
        return topIndex;
    }

    @Override
    public T top() throws EmptyStackException {
        if(!isEmpty())
            return array[topIndex - 1];

        throw new EmptyStackException();
    }

    @Override
    public void clear() {
        for(int i = 0; i < topIndex; i++) {
            array[i] = null;
        }

        topIndex = 0;
    }

    private void enlarge(){
        T[] newArray = (T[])(new Object[array.length * 2]);

        for(int i = 0; i < size(); i++){
            newArray[i] = array[i];
        }

        array = newArray;

        //System.out.println("Powiększanie stosu, nowa wielkość: " + array.length);
    }

    private void halfSize(){
        T[] newArray = (T[])(new Object[array.length / 2]);

        for(int i = 0; i < size(); i++){
            newArray[i] = array[i];
        }

        array = newArray;

        //System.out.println("Pomniejszanie stosu, nowa wielkość: " + array.length);
    }
}
