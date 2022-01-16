package zad4;

public class ListOperators<E> {
    public void addToEnd(TwoWayLinkedList<E> list1,TwoWayLinkedList<E> list2){
        TwoWayLinkedList<E> output = list1;

        output.get(output.size() - 1).insertWithoutChangingNext(list2.get(0));
    }

    public void addAddAt(TwoWayLinkedList<E> list1, TwoWayLinkedList<E> list2, int index){
        TwoWayLinkedList<E> output = list1;
        TwoWayLinkedList.Element before = list1.get(index - 1);
        TwoWayLinkedList.Element after = list1.get(index);
        TwoWayLinkedList.Element list2Last = list2.get(list2.size() - 1);

        before.insertWithoutChangingNext(list2.get(0));
        list2Last.insertWithoutChangingNext(after);
    }
}
