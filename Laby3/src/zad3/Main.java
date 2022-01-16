package zad3;

import zad1.EmptyQueueException;
import zad2.Stack;

public class Main {
    public static void main(String[] args){
        QueueS<Integer> q = new QueueS<>();

        //próba usunięcia elementu z pustej kolejki
        try{
            q.dequeue();
        } catch (EmptyQueueException e){
            System.out.println("Queue is empty!");
        }

        //dodawanie elementów do kolejki
        q.enqueue(12);
        q.enqueue(910000);
        q.enqueue(1823);
        q.enqueue(9813);
        q.enqueue(34);

        //usuwania lub tylko wypisywanie pierwszego elementu
        System.out.println("Elements:");
        System.out.println(q.first());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.first());
        System.out.println(q.first());

        //Czyszczenie kolejki
        q.clear();

        System.out.println("Size: " + q.size());

        //Ponowne dodanie do kolejki
        q.enqueue(143);
        q.enqueue(2553);
        q.enqueue(6134);

        System.out.println("Size: " + q.size());
    }
}
