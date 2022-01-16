package zad3;

import java.util.EmptyStackException;

public class Main {
    public static void main(String[] args){
        System.out.println("------Stack testing------");
        Stack<Integer> stack = new Stack<>();

        stack.push(15);
        stack.push(25);
        stack.push(35);
        stack.push(45);
        stack.push(65);

        System.out.println("Stack size: " + stack.size());
        System.out.println("Stack top: " + stack.top());
        System.out.println("Stack size: " + stack.size());
        System.out.println("Stack pop: " + stack.pop());
        System.out.println("Stack size: " + stack.size());

        while(!stack.isEmpty()){
            System.out.println("Stack pop: " + stack.pop());
        }

        try{
            stack.pop();
        } catch(EmptyStackException e){
            System.out.println("Stack is empty!");
        }

        System.out.println("\n------Queue testing------");
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(150);
        queue.enqueue(4995);
        queue.enqueue(12);
        queue.enqueue(59);
        queue.enqueue(458);

        System.out.println("Queue size: " + queue.size());
        System.out.println("Queue first: " + queue.first());
        System.out.println("Queue size: " + queue.size());
        System.out.println("Queue dequeue: " + queue.dequeue());
        System.out.println("Queue size: " + queue.size());

        while(!queue.isEmpty()){
            System.out.println("Queue dequeue: " + queue.dequeue());
        }

        System.out.println("Queue size: " + queue.size());

        try{
            queue.dequeue();
        } catch(EmptyQueueException e){
            System.out.println("Queue is empty!");
        }
    }
}
