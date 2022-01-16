package zad1;

public class Main {
    public static void main(String[] args){
        CycledLinkedList<Integer> list = new CycledLinkedList<>();

        System.out.println("Size: " + list.size());
        list.addEnd(15);
        System.out.println("List contains 15: " + list.contains(15));
        System.out.println("List contains 25: " + list.contains(25));
        list.addEnd(25);
        list.addEnd(35);
        list.addEnd(55);
        list.addEnd(65);
        list.addEnd(75);
        System.out.println("Size: " + list.size());
        list.printList();

        list.insert(3, 15093);
        list.printList();
        list.insert(8, -150);
        list.printList();

        System.out.println("Deleting at index 1: " + list.deleteIndex(1).getValue());
        System.out.println(list.get(3));
        System.out.println(list.get(9));
        System.out.println("Deleting at index 0: " + list.deleteIndex(0).getValue());

        list.set(5, 55555);
        list.set(12, 2251);
        list.printList();

        System.out.println("List contains 25: " + list.contains(25));
        System.out.println("List contains 27: " + list.contains(27));

        System.out.println(list.deleteIndex(3).getValue());
        list.printList();
        System.out.println(list.delete(15093));
        list.printList();
        System.out.println(list.deleteEl(new Element<>(65)));
        list.printList();
        list.clear();
        list.printList();
    }
}
