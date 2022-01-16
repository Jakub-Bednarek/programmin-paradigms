package zad4;

public class TwoWayLinkedList<E> {
    public class Element{
        private E value;
        private Element next;
        private Element previous;

        public Element(E value) { this.value = value; }

        public Element getNext() { return next; }

        public void setNext( Element next ) { this.next = next; }

        public Element getPrevious() { return previous; }

        public void setPrevious( Element previous ) { this.previous = previous; }

        public E getValue() { return this.value; }

        public void setValue(E value) { this.value = value; }

        public void insertWithoutChangingNext(Element element){
            element.setPrevious(this);
            this.setNext(element);
        }

        public void insertAfter(Element element){
            element.setNext(this.getNext());
            element.setPrevious(this);
            this.setNext(element);
        }

        public void insertBefore(Element element){
            element.setNext(this);
            element.setPrevious(this.getPrevious());
            this.getPrevious().setNext(element);
            this.setPrevious(element);
        }

        public void remove(){
            this.getNext().setPrevious(this.getPrevious());
            this.getPrevious().setNext(this.getNext());
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null) return false;

            if(obj.getClass() != this.getClass()) return false;

            Element e = (Element)obj;

            return this.getValue().equals(e.getValue());
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    private Element head;

    public TwoWayLinkedList(){
        head = null;
    }

    private Element getElement(int index){
        Element element = head;

        int counter = 0;

        while(element.getNext() != null && counter < index){
            element = element.getNext();
            counter++;
        }

        if(index != counter){
            throw new ArrayIndexOutOfBoundsException();
        }

        return element;
    }

    private Element getElement(Element e){
        Element element = head;

        while(element != null && !element.value.equals(e.value)){
            element = element.getNext();
        }

        if(element.value.equals(e.value)){
            return element;
        }

        return null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void clear() {
        head = null;
    }

    public Element get(int index){
        return getElement(index);
    }

    public E set(int index, E value){
        Element element = getElement(index);

        if(element != null){
            E retValue = element.getValue();
            element.setValue(value);

            return retValue;
        }

        return null;
    }

    public boolean add(E value){
        Element newElement = new Element(value);

        if(head == null){
            head = newElement;
            return true;
        }

        Element current = head;
        while(current.getNext() != null){
            current = current.getNext();
        }

        current.insertAfter(newElement);

        return true;
    }

    public boolean add(int index, E value){
        Element newElement = new Element(value);

        if(index == 0){
            head.insertAfter(newElement);
        } else{
            Element element = getElement(index - 1);
            element.insertAfter(newElement);
        }

        return true;
    }

    public int indexOf(E value){
        Element element = head;

        int counter = 0;
        while(element != null && !element.getValue().equals(value)){
            element = element.getNext();
            counter++;
        }

        if(element != null && element.getValue().equals(value)){
            return counter;
        }

        return -1;
    }

    public int size(){
        Element element = head;

        int counter = 0;
        while(element != null){
            counter++;
            element = element.getNext();
        }

        return counter;
    }

    public boolean remove(E value) {
        Element elem = getElement(new Element(value));

        if(elem == null) return false;

        elem.remove();

        return true;
    }

    public void printList(){
        Element element = head;
        StringBuffer buffer = new StringBuffer();

        while(element != null){
            buffer.append(element.getValue() + ", ");
            element = element.getNext();
        }

        System.out.println(buffer.toString());
    }
}
