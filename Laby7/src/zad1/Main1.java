package zad1;

public class Main1 {
    public static void main(String[] args){
        HeapPriorityQueue<Integer> pQueue = new HeapPriorityQueue<>(new IntegerComparator());
        pQueue.enqueue(15);
        pQueue.enqueue(35);
        pQueue.enqueue(7);
        pQueue.enqueue(3);
        pQueue.enqueue(26);
        pQueue.enqueue(12);

        System.out.println("Kolejka po dodaniu elementów: " + pQueue);

        pQueue.delete(1);

        System.out.println("Kolejka po usunięciu elementu o indeksie 1: " + pQueue);

        pQueue.delete(4);

        System.out.println("Kolejka po usunięciu elementu o indeksie 1: " + pQueue);

        pQueue.changePriority(3, 30);

        System.out.println("Kolejka po zmianie priorytetu elementu o indeksie 3: " + pQueue);

        System.out.println("Kolejka po posortowaniu: " + pQueue.getSortedList());
    }
}
