package Zad2;

import java.util.*;

public class TwoFourTree<V> {
   private TwoFourNode<V> root = new TwoFourNode<>();
   private Comparator<V> comparator;
   static int compares = 0;

   public TwoFourTree(Comparator<V> comparator){
       this.comparator = comparator;
   }

   public boolean find(V value){
       TwoFourNode<V> current = root;

       while(true){
           compares++;
           if(current.findElement(value) > -1)
               return true;
           if(current.isLeaf())
               return false;

           current = getChildSibling(current, value);
       }
   }

   public int getCompares(){
       return compares;
   }

   public static void resetCompares(){
       compares = 0;
   }

   public void insert(V value){
       if (!find(value)) {
           TwoFourNode<V> current = root;
           V currVal = value;

           while (true) {
               if(current.isFull()){
                   split(current);
                   current = getChildSibling(current.parent(), value);
                   continue;
               }
               if(current.isLeaf()){
                   break;
               }

               current = getChildSibling(current, value);
           }

           current.addNewElement(currVal);
       }
   }

   private TwoFourNode<V> getChildSibling(TwoFourNode<V> parent, V value){
       int elements = parent.nElements();

       for(int i = 0; i < elements; i++){
           if(comparator.compare(value, parent.getElement(i)) < 0)
               return parent.getChild(i);
       }

       return parent.getChild(elements);
   }

   private void split(TwoFourNode<V> current){
       V right = current.remove();
       V mid = current.remove();

       TwoFourNode<V> c2 = current.removeEdge(2);
       TwoFourNode<V> c3 = current.removeEdge(3);

       TwoFourNode<V> parent;

       if(root == current)   {
           root = new TwoFourNode<V>();
           parent = root;
           root.createEdge(0, current);
       }

       else {
           parent = current.parent();
       }

       int iAdded = parent.addNewElement(mid);
       int nElements = parent.nElements();

       for(int i = nElements -1; i > iAdded; i--) {
           TwoFourNode<V> tmp = parent.removeEdge(i);
           parent.createEdge(i + 1, tmp);
       }

       TwoFourNode<V> newNode = new TwoFourNode<V>();
       parent.createEdge(iAdded + 1, newNode);

       newNode.addNewElement(right);
       newNode.createEdge(0, c2);
       newNode.createEdge(1, c3);
   }
}
