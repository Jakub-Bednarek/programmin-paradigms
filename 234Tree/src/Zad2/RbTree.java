package Zad2;

import java.util.LinkedList;
import java.util.List;

class Node {
    private int value;
    private int height;
    private int nodes;
    private String color;
    Node children[];

    public Node(int value)
    {
        this.value = value;
        this.color = "R";
        children = new Node[2];
        children[0] = null;
        children[1] = null;
    }

    public String getColor() { return color; }
    public int getValue() { return value; }
    public int getHeight() { return height; }
    public int getNodes() { return this.nodes; }

    public void setColor(String color) { this.color = color; }
    public void setValue(int value) { this.value = value; }
    public void setHeight(int height) { this.height = height; }
    public void setNodes(int nodes) { this.nodes = nodes; }
}

public class RbTree {
   private Node root = null;
   private static int compares = 0;

    public int height(Node Root) {
        int left, right;

        if (Root == null || (Root.children == null && Root.children[1] == null)) {
            return 0;
        }
        left = height(Root.children[0]);
        right = height(Root.children[1]);

        return (Math.max(left, right) + 1);
    }

    public boolean get(int key) {
        Node current = root;

        while(current != null){
            int difference = key - current.getValue();

            if(difference > 0){
                compares++;
                current = current.children[1];
            }
            else if(difference < 0){
                compares++;
                current = current.children[0];
            }
            else
                return true;
        }

        return false;
    }

    public int getCompares(){
        return compares;
    }

    public static void resetCompares(){
        compares = 0;
    }

    public Node getRoot(){
        return this.root;
    }

    public Node insert(RbTree tree, int value)
    {
        if (tree.root == null) {
            tree.root = new Node(value);

            if (tree.root == null)
                return null;
        }
        else {
            Node temp = new Node(0);

            Node g, t;
            Node p, q;

            int dir = 0, last = 0;

            t = temp;
            g = p = null;
            t.children[1] = tree.root;
            q = t.children[1];

            while (true) {

                if (q == null) {
                    q = new Node(value);
                    p.children[dir] = q;
                }

                else if (isRed(q.children[0]) && isRed(q.children[1])) {
                    q.setColor("R");
                    q.children[0].setColor("B");
                    q.children[1].setColor("B");
                }

                if (isRed(q) && isRed(p)) {

                    int dir2;
                    if (t.children[1] == g)
                        dir2 = 1;
                    else
                        dir2 = 0;

                    if (q == p.children[last])
                        t.children[dir2] = singleRotate(g, last == 0 ? 1 : 0);

                    else
                        t.children[dir2] = doubleRotate(g, last == 0 ? 1 : 0);
                }

                if (q.getValue() == value)
                    break;

                last = dir;
                dir = q.getValue() - value < 0 ? 1 : 0;

                if (g != null)
                    t = g;


                g = p;
                p = q;
                q = q.children[dir];
            }

            tree.root = temp.children[1];
        }

        tree.root.setColor("B");

        return tree.root;
    }

    public void calculateHeight(Node current, int height){
        current.setHeight(height);

        if(current.children[0] != null)
            calculateHeight(current.children[0], height + 1);
        if(current.children[1] != null)
            calculateHeight(current.children[1], height + 1);
    }

    public void writeNodesForEveryNode(){
        writeNodesForEveryNode(root);
    }

    private void writeNodesForEveryNode(Node current){
        current.setNodes(calculateNodes(current) - 1);

        if(current.children[0] != null)
            writeNodesForEveryNode(current.children[0]);
        if(current.children[1] != null)
            writeNodesForEveryNode(current.children[1]);
    }

    private int calculateNodes(Node current){
        if(current == null)
            return 0;
        else
            return 1 + calculateNodes(current.children[0]) + calculateNodes(current.children[1]);
    }

    public void printPreOrder(){
        System.out.println("Tree pre-order");
        printPreOrder(root);
        System.out.println();
    }

    private void printPreOrder(Node current){
        if(current == null)
            return;


        System.out.print(current.getValue() + "[" + current.getColor() + "], ");
        printPostOrder(current.children[0]);
        printPostOrder(current.children[1]);
    }

    public void printInOrder(){
        System.out.println("Tree in-order");
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(Node current){
        if(current == null)
            return;

        printPostOrder(current.children[0]);
        System.out.print(current.getValue() + "[" + current.getColor() + "], ");
        printPostOrder(current.children[1]);
    }

    public void printPostOrder(){
        System.out.println("Tree post-order");
        printPostOrder(root);
        System.out.println();
    }

    private void printPostOrder(Node current){
        if(current == null)
            return;

        printPostOrder(current.children[0]);
        printPostOrder(current.children[1]);
        System.out.print(current.getValue() + "[" + current.getColor() + "], ");
    }

    public void printHorizontally(Node root)
    {
        List<Node> queue = new LinkedList<>();
        queue.add(root);
        Node current, left, right;

        System.out.println("Tree printed horizontally");
        while(!queue.isEmpty()){
            current = queue.remove(0);
            System.out.println("[Value: " + current.getValue() + ", " + current.getColor() + ", height: " + current.getHeight() + ", nodes: " + current.getNodes() + "]");

            if(current.children[0] != null)
                queue.add(current.children[0]);
            if(current.children[1] != null)
                queue.add(current.children[1]);
        }
        System.out.println();
    }

    private int check(int dir) {
        return dir == 0 ? 1 : 0;
    }

    private boolean isRed(Node Node) {
        return Node != null
                && Node.getColor().equals("R");
    }

    private Node singleRotate(Node Node, int dir) {
        Node temp
                = Node.children[check(dir)];
        Node.children[check(dir)]
                = temp.children[dir];
        temp.children[dir] = Node;
        root.setColor("R");
        temp.setColor("B");

        return temp;
    }

    private Node doubleRotate(Node Node, int dir)
    {
        Node.children[check(dir)]
                = singleRotate(Node.children[check(dir)],
                check(dir));
        return singleRotate(Node, dir);
    }
}