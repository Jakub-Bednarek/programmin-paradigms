package Z1;

public class Main {
    public static void main(String[] args){
        {
            RbTree tree = new RbTree();

            tree.insert(tree, 15);
            tree.insert(tree, 35);
            tree.insert(tree, 3215);
            tree.insert(tree, 15535);
            tree.insert(tree, 42315);
            tree.insert(tree, 3112);
            tree.insert(tree, 5632);
            tree.insert(tree, 132);
            tree.insert(tree, 16);
            tree.insert(tree, 172);
            tree.insert(tree, -90);

            System.out.println("Value 20: " + tree.get(20));
            System.out.println("Value 15: " + tree.get(15));
            tree.printInOrder();
            tree.printPostOrder();
            tree.printPreOrder();

            tree.writeNodesForEveryNode();
            tree.calculateHeight(tree.getRoot(), 0);

            System.out.println("\nTree printed by levels");
            tree.printHorizontally(tree.getRoot());
        }
    }
}
