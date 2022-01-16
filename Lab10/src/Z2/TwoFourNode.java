package Z2;

public class TwoFourNode {
    private final TwoFourNode divorcedAndChildless = null;
    private TwoFourNode children[] = new TwoFourNode[4];

    private final Integer[] elems = new Integer[3];


    protected TwoFourNode 	parent;
    protected int	numberOfElems;

    public TwoFourNode() {
        numberOfElems = 0;
    }

    public int howManyElems() {
        return numberOfElems;
    }

    public int size() {
        if (this.leaf() == true) {
            return numberOfElems;
        }

        int sum = numberOfElems;
        for (int i = 0; i < numberOfElems+1; i++) {
            sum += getChild(i).size();
        }

        return sum;
    }

    public boolean leaf() {
        TwoFourNode test = firstChild();
        if (test == divorcedAndChildless) {
            return true;
        }else {
            return false;
        }
    }


    public void createEdge(int i, TwoFourNode node) {
        children[i] = node;
        if(node != divorcedAndChildless) node.parent = this;
    }

    public TwoFourNode removeEdge(int i) {
        TwoFourNode tmp = getChild(i);
        children[i] = divorcedAndChildless;
        return tmp;
    }

    public TwoFourNode parent() {
        return parent;
    }

    public TwoFourNode firstChild() {
        return children[0];
    }
    public TwoFourNode lastChild() {
        return children[numberOfElems];
    }

    public TwoFourNode getChild(int i) {
        return children[i];
    }

    public int getElem(int i )  {
        return elems[i];
    }

    public int smallestElem()  {
        return elems[0];
    }

    public int largestElem()  {
        return elems[numberOfElems - 1];
    }

    public boolean full() {
        if (numberOfElems >= 3) {
            return true;
        } else {
            return false;
        }
    }

    public int findElem(int x) {
        int flag = -1;

        for(int i=0; i<3; i++)  {
            if(elems[i] == null) {
                break;
            }
            else if( elems[i] - x == 0) {
                flag = i;
            }
        }
        return flag;
    }

    public int addNewElem(int value) {
        numberOfElems++;

        int indexToReturn = 0;
        for(int i = elems.length - 1; i >= 0; i--)  {
            if(elems[i] == null)
                continue;
            else {

                int k = elems[i];
                if(value - k < 0)
                    elems[i + 1] = elems[i];

                else {
                    elems[i + 1] = value;
                    indexToReturn = i + 1;
                    break;
                }
            }
        }
        elems[indexToReturn] = value;
        return indexToReturn;
    }

    int removeElem(int index) {
        int toReturn = getElem(index);
        int i;
        for (i = index; i < numberOfElems-1; i++) {
            elems[i] = elems[i+1];
        }
        elems[i] = null;
        numberOfElems--;

        return toReturn;

    }
}