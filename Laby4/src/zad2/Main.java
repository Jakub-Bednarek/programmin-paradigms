package zad2;

import zad1.CycledLinkedList;

public class Main {
    public static void main(String[] args){
        calculateLastPerson(4, 2);
        System.out.println();
        calculateLastPerson(10, 3);
    }

    public static void calculateLastPerson(int n, int k){
        CycledLinkedList<Integer> people = new CycledLinkedList<>();

        System.out.println("Number of people: " + n);
        System.out.println("Which person to delete: " + k);

        k--;
        for(int i = 0; i < n; i++){
            people.addEnd(i + 1);
        }

        int current = k;
        while(people.size() > 1){
            if(current >= people.size()) {
                current -= people.size();
            }

            System.out.println("Deleting people with number: " + people.deleteIndex(current).getValue());

            current += k;
            people.printList();
        }

        System.out.println("After removing people: ");
        people.printList();
    }
}
