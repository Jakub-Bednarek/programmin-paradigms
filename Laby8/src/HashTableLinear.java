public class HashTableLinear<V>{
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
    public HashTableLinear(){
        array = (Element<V>[])new Element[size];
    }

    public V get(int key){
        int hashIndex = HashingFunction.hash(key) % size;
        int cycles = 0;

        while(array[hashIndex] != null){
            if(array[hashIndex].key == key)
                return array[hashIndex].value;

            if(cycles == size)
                return null;

            hashIndex++;
            hashIndex %= 20;
            cycles++;
        }
        return null;
    }

    public void put(int key, V value) throws FullHashTableException{
        if(size() == size)
            throw new FullHashTableException();

        int hashIndex = HashingFunction.hash(key) % size;

        while(array[hashIndex] != null){
            hashIndex++;
            hashIndex %= size;
        }

        array[hashIndex] = new HashTableLinear.Element(key, value);
    }

    public boolean containsKey(int key){
        int hashIndex = HashingFunction.hash(key) % size;
        int cycles = 0;

        while(array[hashIndex] != null){
            if(array[hashIndex].key == key){
                return true;
            }

            if(cycles == size)
                return false;

            hashIndex++;
            cycles++;
        }

        return false;
    }

    public int size(){
        int currentSize = 0;
        for(Element val : array){
            if(val != null){
                currentSize++;
            }
        }

        return currentSize;
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
