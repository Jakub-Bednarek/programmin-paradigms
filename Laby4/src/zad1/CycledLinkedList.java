package zad1;


public class CycledLinkedList<E> implements IList<E> {
    private Element<E> head;

    public CycledLinkedList(){
        head = null;
    }

    @Override
    public void addEnd(E e) {
        Element<E> newElement = new Element<>(e);
        newElement.setNext(head);

        if(head == null){
            head = newElement;
            newElement.setNext(head);
        } else {
            Element element = head;

            while(element.getNext() != head) {
                element = element.getNext();
            }

            element.setNext(newElement);
        }
    }

    @Override
    public void insert(int pos, E e) {
        int currentPos = 0;
        Element element = head;

        while(currentPos != pos - 1){
            element = element.getNext();
            currentPos++;
        }

        Element next = element.getNext();
        Element newElement = new Element<>(e);
        element.setNext(newElement);
        newElement.setNext(next);
    }

    @Override
    public E get(int pos) {
        int currentPos = 0;
        Element<E> element = head;

        if(head.getNext() == head){
            return head.getValue();
        }

        while(currentPos != pos){
            element = element.getNext();
            currentPos++;
        }

        return element.getValue();
    }

    @Override
    public void set(int pos, E e) {
        int currentPos = 0;
        Element<E> element = head;

        if(head == null){
            return;
        }

        if(head.getNext() == head){
            head.setValue(e);
        }

        while(currentPos != pos){
            element = element.getNext();
            currentPos++;
        }

        element.setValue(e);
    }

    @Override
    public boolean contains(E e) {
        Element<E> element = head;

        if(head == null){
            return false;
        }

        do{
            if(element.getValue().equals(e)){
                return true;
            }

            element = element.getNext();
        } while(element != head);

        return false;
    }

    @Override
    public int size() {
        if(head == null){
            return 0;
        }

        int size = 0;
        Element<E> element = head;
        do{
            size++;
            element = element.getNext();
        } while(element != head);

        return size;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public Element deleteIndex(int pos) {
        if(head == null){
            return null;
        }

        if(pos == 0){
            Element<E> element = head;
            head = head.getNext();

            deleteIndex(size() - 1);
            return element;
        }

        Element<E> element = head;
        int currentPos = 0;
        while(currentPos < pos - 1){
            element = element.getNext();
            currentPos++;
        }

        Element<E> next = element.getNext();
        element.setNext(next.getNext());

        return next;
    }

    @Override
    public boolean delete(E e) {
        if(head == null){
            return false;
        }

        Element<E> element = head;
        while(!element.getNext().getValue().equals(e) && element.getNext() != head){
            element = element.getNext();
        }

        if(element.getNext().getValue().equals(e)){
            Element<E> next = element.getNext();
            element.setNext(next.getNext());

            return true;
        }

        return false;
    }

    @Override
    public E deleteEl(Element e) {
        if(head == null){
            return null;
        }

        Element<E> element = head;
        while(!element.getNext().equals(e) && element.getNext() != head){
            element = element.getNext();
        }

        if(element.getNext().equals(e)){
            Element<E> next = element.getNext();
            element.setNext(next.getNext());

            return next.getValue();
        }

        return null;
    }

    public void printList(){
        Element<E> element = head;

        if(head == null){
            System.out.println("[]");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        while(element.getNext() != head){
            buffer.append(element.getValue() + ", ");
            element = element.getNext();
        }

        buffer.append(element.getValue() + "]");

        System.out.println(buffer.toString());
    }
}
