package zad4;

public class Main {
    public static void main(String[] args){
        TwoWayLinkedList<Integer> list1 = new TwoWayLinkedList<>();

        System.out.println("Is empty: " + list1.isEmpty());
        list1.add(150);
        list1.add(29);
        list1.add(9312);
        list1.add(253);
        list1.add(350);
        System.out.println("List 1:");
        list1.printList();

        //List 2
        TwoWayLinkedList<Integer> list2 = new TwoWayLinkedList<>();
        list2.add(9999);
        list2.add(9559);
        list2.add(9939);
        list2.add(9534);
        list2.add(9834);
        System.out.println("List 2:");
        list2.printList();

        ListOperators<Integer> op = new ListOperators<>();
        op.addToEnd(list1, list2);
        System.out.println("After merging:");
        list2.printList();

        //List 3
        TwoWayLinkedList<Integer> list3 = new TwoWayLinkedList<>();
        list3.add(150);
        list3.add(29);
        list3.add(556);
        list3.add(253);
        list3.add(350);
        System.out.println("List 3:");
        list3.printList();

        //List 4
        TwoWayLinkedList<Integer> list4 = new TwoWayLinkedList<>();
        list4.add(9999);
        list4.add(9559);
        list4.add(9939);
        list4.add(9534);
        list4.add(9834);
        System.out.println("List 4:");
        list4.printList();
        op.addAddAt(list3, list4, 3);

        System.out.println("After merging:");
        list3.printList();
    }
}
