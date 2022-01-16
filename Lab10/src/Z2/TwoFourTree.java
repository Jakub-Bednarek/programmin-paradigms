package Z2;

public class TwoFourTree {
    TwoFourNode root = new TwoFourNode();

    public boolean add(int value) {
        if (contains(value)) {
            return false;
        }

        TwoFourNode current = root;
        int tmp = value;

        while(true) {
            if( current.full() )  {
                split(current);
                current= getChildSibling(current.parent(), value);
                continue;
            }

            if( current.leaf() ) {
                break;
            }


            current = getChildSibling(current, value);
        }

        current.addNewElem(tmp);

        return true;
    }

    public boolean contains(int x){
        TwoFourNode current = root;

        while (true) {

            if (current.findElem(x) > -1) {
                return true;
            }
            if (current.leaf()) {
                return false;
            }
            current = getChildSibling(current,x);

        }
    }

    protected TwoFourNode getChildSibling(TwoFourNode parent, int x) {
        int numElems = parent.howManyElems();

        for(int index = 0; index < numElems; index++) {

            if(x - parent.getElem(index) < 0 ) {
                return parent.getChild(index);
            }
        }

        return parent.getChild(numElems);
    }

    protected void split(TwoFourNode node) {
        //Do napisania
        int right = node.remove();
        int mid = node.remove();

        TwoFourNode c2 = node.removeEdge(2);
        TwoFourNode c3 = node.removeEdge(3);

        TwoFourNode parent;

        if (root == node) {
            root = new TwoFourNode();
            parent = root;
            root.createEdge(0, node);
        }
        else {
            parent = node.parent();
        }

        int iAdded = parent.addNewElem(mid);
        int elems = parent.howManyElems();

        for (int i = elems - 1; i > iAdded; i--) {
            TwoFourNode tmp = parent.removeEdge(i);
            parent.createEdge(i + 1, tmp);
        }

        TwoFourNode rnew = new TwoFourNode();
        parent.createEdge(iAdded + 1, rnew);

        rnew.addNewElem(right);
        rnew.createEdge(0, c2);
        rnew.createEdge(1, c3);
    }
}
