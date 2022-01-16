package Zad1;

public class DisjointSetForest {
    class Node{
        private Node parent;
        private int rank;
        private int value;

        public Node(int value){
            this.parent = this;
            this.rank = 0;
            this.value = value;
        }

        public Node getParent(){
            return parent;
        }

        public int getRank(){
            return rank;
        }

        public int getValue(){
            return value;
        }

        public void setParent(Node parent){
            this.parent = parent;
        }

        public void incrementRank(){
            rank++;
        }
    }

    private Node[] forest;
    private int size;

    public DisjointSetForest(int size){
        this.forest = new Node[size];
        this.size = size;

        makeSet(size);
    }

    public void union(int x, int y){
        link(findSet(x), findSet(y));
    }

    public void link(Node x, Node y){
        if(x.getRank() > y.getRank())
            y.setParent(x);
        else
        {
            x.setParent(y);
            if(x.getRank() == y.getRank())
                y.incrementRank();
        }
    }

    public Node findSet(int x){
        if(x != forest[x].parent.value)
            forest[x].setParent(findSet(forest[x].parent.getValue()));

        return forest[x].parent;
    }

    public void printAllParents(){
        System.out.println("\nWydrukowany zbiór:");
        for(int i = 0; i < size; i++){
            if(forest[i].parent.value == i)
            {
                System.out.print(i + ": ");

                for(int j = 0; j < size; j++){
                    Node f = findSet(j);
                    if(findSet(j).parent.value == i)
                        System.out.print(j + " ");
                }
                System.out.println();
            }
        }
    }

    private void makeSet(int size){
        for(int i = 0; i < size; i++){
            forest[i] = new Node(i);
        }
    }
}
