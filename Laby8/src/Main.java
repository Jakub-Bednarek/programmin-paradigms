public class Main {
    public static void main(String[] args){
        HashTableDouble<String> ht = new HashTableDouble<>();

        System.out.println("Przed:");
        ht.dump();
        ht.put(15, "Jakub");
        ht.put(22, "Tomasz");
        ht.put(34, "Anna");
        ht.put(23, "Zbigniew");
        System.out.println("\n\nPołowa:");
        ht.dump();
        ht.put(23, "Grzegorz");
        ht.put(123874, "Karolina");
        ht.put(9485, "Hania");
        ht.put(98434, "Edward");
        System.out.println("\n\nPo wstawieniu:");
        ht.dump();

        System.out.println(ht);
        System.out.println(ht.get(23));
        System.out.println(ht.get(9485));
        System.out.println(ht.get(9435));
        System.out.println(ht.containsKey(34));
        System.out.println(ht.containsKey(98434));
        System.out.println(ht.containsKey(16));

        ht.resize(40);
        System.out.println(ht);
    }

    void testFor65(){

    }

    void testFor8(){

    }

    void testFor95(){

    }
}
