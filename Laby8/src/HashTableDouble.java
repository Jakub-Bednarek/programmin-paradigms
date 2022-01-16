public class HashTableDouble<V>{
    private class Element<V>{
        public int key;
        public V value;

        public Element(int key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return this.value.toString();
        }
    }
    private Element<V>[] array;
    private int size = 20;
    private int currentSize = 0;

    @SuppressWarnings("unchecked")
    public HashTableDouble(){
        array = (Element<V>[])new Element[size];
    }

    public V get(int key){
        int hashIndex = HashingFunction.hash(key) % size;
        int cycles = 0;

        for(int i = 0; array[hashIndex] != null; i++){
            if(array[hashIndex].key == key)
                return array[hashIndex].value;

            if(cycles == size)
                return null;

            hashIndex += i * HashingFunction.hash(key + i);
            hashIndex %= 20;
            cycles++;
        }

        return null;
    }

    public void put(int key, V value) throws FullHashTableException{
        if(size() == size)
            throw new FullHashTableException();

        int hashIndex = HashingFunction.hash(key) % size;

        for(int i = 0; array[hashIndex] != null; i++){
            hashIndex += i * HashingFunction.hash(key + i);
            hashIndex %= size;
        }

        array[hashIndex] = new Element<>(key, value);
    }

    public boolean containsKey(int key){
        int hashIndex = HashingFunction.hash(key) % size;
        int cycles = 0;

        for(int i = 0; array[hashIndex] != null; i++){
            if(array[hashIndex].key == key)
                return true;

            if(cycles == size)
                return false;

            hashIndex += i * HashingFunction.hash(key + i);
            hashIndex %= 20;
            cycles++;
        }

        return false;
    }

    public int size(){
        int currentSize = 0;
        for(Element<V> val : array){
            if(val != null){
                currentSize++;
            }
        }

        return currentSize;
    }

    public boolean isEmpty(){
        for(Element val : array){
            if(val != null){
                return false;
            }
        }

        return true;
    }

    public void dump(){
        for(Element val : array){
            System.out.println(val);
        }
    }

    public void resize(int newSize) throws BadSizeException{
        if(newSize < size())
            throw new BadSizeException();
        Element<V>[] oldArray = array;
        array = (Element<V>[])new Element[size];

        for(Element<V> e : oldArray){
            if(e != null)
                put(e.key, e.value);
        }
    }

    @Override
    public String toString() {
        StringBuffer buff = new StringBuffer();

        for(Element val : array){
            if(val != null){
                buff.append(val + " ");
            }
        }

        return buff.toString();
    }
}
