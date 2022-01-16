import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class BST<V> {
    private class Node<V>{
        private V key;
        private Node left;
        private Node right;
        private int height;
        private int nodes;

        public Node(V key){
            this.key = key;
            this.left = null;
            this.right = null;
            this.height = 0;
            this.nodes = 0;
        }

        @Override
        public String toString() {
            return "[Klucz=" + this.key + ",wysokość=" + this.height + ",liczba węzłów poddrzewa=" + this.nodes + "]";
        }
    }

    private Node root;
    private Comparator<V> comparator;
    static final int DISTANCE = 15;

    public BST(Comparator<V> comparator){
        this.root = null;
        this.comparator = comparator;
    }

    public void insert(V key) {
        root = insert(root, key);
    }

    private Node<V> insert(Node current, V key){
        if(current == null){
            return current = new Node(key);
        } else {
            if(comparator.compare((V) current.key, key) < 0){
                current.left = insert(current.left, key);
            } else if(comparator.compare((V) current.key, key) > 0){
                current.right = insert(current.right, key);
            } else {
                return current;
            }
        }

        return current;
    }

    public Node<V> contains(V key) throws EmptyTreeException{
        if(root == null)
            throw new EmptyTreeException();

        return contains(root, key);
    }

    private Node<V> contains(Node current, V key){
        if(current == null || comparator.compare((V) current.key, key) == 0){
            return current;
        } else {
            if(comparator.compare((V) current.key, key) < 0)
                return contains(current.left, key);
            else
                return contains(current.right, key);
        }
    }

    public int getHeight(){
        return getHeight(root);
    }

    private int getHeight(Node current){
        if(current == null){
            return 0;
        } else {
            int leftHeight = getHeight(current.left);
            int rightHeight = getHeight(current.right);

            if(leftHeight > rightHeight){
                return leftHeight + 1;
            } else {
                return rightHeight + 1;
            }
        }
    }

    public void printHorizontally(){
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        Node node, left, right;

        while(!queue.isEmpty()){
            node = queue.remove();

            System.out.println(node.key + " ");
            left = node.left;
            right = node.right;

            if(left != null)
                queue.add(left);
            if(right != null)
                queue.add(right);
        }

    }

    public int getNodes(){
        return getNodes(root) - 1;
    }

    public void delete(V key){
        delete(root, key);
    }

    private Node delete(Node current, V key){
        if(current == null)
            return null;

        if(comparator.compare((V) current.key, key) < 0){
            current.left = delete(current.left, key);
        } else if (comparator.compare((V) current.key, key) > 0){
            current.right = delete(current.right, key);
        } else {
            if(current.left == null && current.right == null){
                current = null;
            } else if(root.right != null){
                current.key = findSuccessor((V) current.key).key;
                current.right = delete(current.right, (V) current.key);
            } else {
                current.key = findPredecessor((V) current.key).key;
                current.left = delete(current.left, (V) current.key);
            }
        }

        return current;
    }

    public Node findSuccessor(V key) throws EmptyTreeException{
        if(root == null)
            throw new EmptyTreeException();

        Node node = contains(key);

        if(node.right == null)
            return null;

        return findSuccessor(node);
    }

    private Node findSuccessor(Node current){
        current = current.right;

        while(current.left != null)
            current = current.left;

        return current;
    }

    public Node findPredecessor(V key){
        if(root == null)
            throw new EmptyTreeException();

        Node node = contains(key);
        System.out.println(node);

        if(node.left == null)
            return null;

        return findPredecessor(node);
    }

    private Node findPredecessor(Node current){
        current = current.left;

        while(current.right != null)
            current = current.right;

        return current;
    }

    public void writeNodesForEveryNode(){
        writeNodesForEveryNode(root);
    }

    private void writeNodesForEveryNode(Node current){
        current.nodes = getNodes(current);

        if(current.left != null)
            writeNodesForEveryNode(current.left);
        if(current.right != null)
            writeNodesForEveryNode(current.right);
    }

    public void writeHeightForEveryNode(){
        writeHeightForEveryNode(root, 1);
    }

    private void writeHeightForEveryNode(Node current, int currentHeight){
        current.height = currentHeight;

        if(current.left != null)
            writeHeightForEveryNode(current.left, currentHeight + 1);
        if(current.right != null)
            writeHeightForEveryNode(current.right, currentHeight + 1);
    }

    private int getNodes(Node current){
        if(current == null){
            return 0;
        } else {
            return 1 + getNodes(current.left) + getNodes(current.right);
        }
    }

    public int getLeaves(){
        return getLeaves(root);
    }

    private int getLeaves(Node current){
        if(current == null)
            return 0;
        if(current.left == null && current.right == null)
            return 1;
        else
            return getLeaves(current.left) + getLeaves(current.right);
    }

    public Node<V> getMin() throws EmptyTreeException{
        if(root == null)
            throw new EmptyTreeException();

        return getMin(root);
    }

    private Node<V> getMin(Node current){
        if(current.left == null){
            return current;
        } else {
            return getMin(current.left);
        }
    }

    public Node<V> getMax() throws EmptyTreeException{
        if(root == null)
            throw new EmptyTreeException();

        return getMax(root);
    }

    private Node<V> getMax(Node current){
        if(current.right == null){
            return current;
        } else {
            return getMax(current.right);
        }
    }

    public void print()
    {
        print(root, 0);
    }

    private void print(Node current, int space)
    {
        if (root == null)
            return;

        space += DISTANCE;

        if(current.right != null)
            print(current.right, space);

        System.out.print("\n");
        for (int i = DISTANCE; i < space; i++)
            System.out.print(" ");
        System.out.print(current.key + "\n");

        if(current.left != null)
            print(current.left, space);
    }

    public void printInOrder() throws EmptyTreeException{
        if(root == null)
            throw new EmptyTreeException();

        System.out.println("\nIn-order");
        walkInOrder(root);
        System.out.println();
    }

    public void printPreOrder() throws EmptyTreeException{
        if(root == null)
            throw new EmptyTreeException();

        System.out.println("\nPre-order");
        walkPreOrder(root);
        System.out.println();
    }

    public void printPostOrder() throws EmptyTreeException{
        if(root == null)
            throw new EmptyTreeException();

        System.out.println("\nPost-order");
        walkPostOrder(root);
        System.out.println();
    }

    private void walkPostOrder(Node current){
        if(current != null){
            walkPostOrder(current.left);
            walkPostOrder(current.right);
            System.out.print(current.key + ", ");
        }
    }

    private void walkPreOrder(Node current){
        if(current != null){
            System.out.print(current.key + ", ");
            walkPreOrder(current.left);
            walkPreOrder(current.right);
        }
    }

    private void walkInOrder(Node current){
        if(current != null){
            walkInOrder(current.left);
            System.out.print(current.key + ", ");
            walkInOrder(current.right);
        }
    }
}
