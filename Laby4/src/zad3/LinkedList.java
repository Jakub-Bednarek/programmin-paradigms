package zad3;

public class LinkedList<E> {
    public class Element{
        private E value;
        private Element next = null;

        public Element(E value){
            this.value = value;
        }

        public E getValue(){
            return value;
        }

        public void setValue(E value){
            this.value = value;
        }

        public Element getNext(){
            return next;
        }

        public void setNext(Element next){
            this.next = next;
        }
    }

    private Element head;
    private Element tail;

    public LinkedList() { head = null; tail = null; }

    boolean isEmpty() { return head == null; }

    public void clear() { head = null; }

    public int size() {
        if(head == null){
            return 0;
        }

        int size = 0;
        Element element = head;
        while(element != null){
            element = element.getNext();
            size++;
        }

        return size;
    }

    public E get(int index){
        if(head == null){
            return null;
        }

        int pos = 0;
        Element element = head;
        while(pos != index){
            element = element.getNext();
            pos++;
        }

        return element.getValue();
    }

    public void addEnd(E value){
        Element newElement = new Element(value);

        if(head == null){
            head = new Element(value);
            tail = head;

            return;
        }

        tail.setNext(newElement);
        tail = tail.getNext();
    }

    public Element deleteIndex(int pos){
        if(head == null){
            return null;
        }

        if(pos == 0){
            Element element = head;
            head = head.getNext();

            return element;
        }

        Element element = head;
        int currentPos = 0;
        while(currentPos != pos - 1){
            element = element.getNext();
            currentPos++;
        }

        Element next = element.getNext();
        element.setNext(next.getNext());

        if(currentPos == size() - 1){
            tail = next;
        }

        return next;
    }
}
