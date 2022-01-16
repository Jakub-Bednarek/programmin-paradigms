package zad1;


public class Element<T> {
    private T value;
    private Element next;

    public Element(T value) { this.value = value; }

    public T getValue() { return value; }

    public void setValue(T val) { value = val; }

    public Element getNext() { return next; }

    public void setNext(Element element) { next = element; }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;

        if(obj.getClass() != this.getClass()) return false;

        Element e = (Element)obj;

        return this.getValue().equals(e.getValue());
    }
}

