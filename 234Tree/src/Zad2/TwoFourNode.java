package Zad2;

import java.util.Comparator;

public class TwoFourNode<V> {

    //Global data
    protected final TwoFourNode<V> divorcedAndChildless = null;
    protected TwoFourNode<V> children[] = new TwoFourNode[4];

    protected Comparator<V> c;

    private V[] elems = (V[]) new Object[3];


    protected TwoFourNode<V> parent;
    protected int numberOfElems;

    public TwoFourNode() {
        numberOfElems = 0;
        c = new DefaultComparator<V>();
    }

    public TwoFourNode(Comparator<V> ca) {
        numberOfElems = 0;
        c = ca;
    }

    public int nElements() {
        return numberOfElems;
    }

    public boolean isLeaf() {
        TwoFourNode<V> test = firstChild();
        if (test == divorcedAndChildless) {
            return true;
        }else {
            return false;
        }
    }

    public void createEdge(int i, TwoFourNode<V> node) {
        children[i] = node;
        if(node != divorcedAndChildless) node.parent = this;
    }

    public TwoFourNode<V> removeEdge(int i) {
        TwoFourNode<V> tmp = getChild(i);
        children[i] = divorcedAndChildless;
        return tmp;
    }

    public TwoFourNode<V> parent() {
        return parent;
    }

    public TwoFourNode<V> firstChild() {
        return children[0];
    }

    public TwoFourNode<V> getChild(int i) {
        return children[i];
    }

    public V getElement(int i)  {
        return elems[i];
    }

    public boolean isFull() {
        if (numberOfElems >= 3) {
            return true;
        } else {
            return false;
        }
    }

    public int findElement(V x) {
        int flag = - 1;

        for(int i = 0; i < 3; i++)  {
            if(elems[i] == null) {
                break;
            }
            else if( c.compare(elems[i], x) == 0 ) {
                flag = i;
            }
        }
        return flag;
    }

    public V remove() {
        numberOfElems--;
        V elem= elems[numberOfElems];
        elems[numberOfElems] = null;
        return elem;
    }

    public int addNewElement(V obj) {
        numberOfElems++;

        int indexToReturn = 0;
        for(int i = elems.length - 1; i >= 0; i--)  {
            if(elems[i] == null)
                continue;
            else {
                V k = elems[i];
                if(c.compare(obj, k ) < 0)
                    elems[i + 1] = elems[i];
                else {
                    elems[i + 1] = obj;
                    indexToReturn = i + 1;
                    break;
                }
            }
        }

        elems[indexToReturn] = obj;
        return indexToReturn;
    }
}