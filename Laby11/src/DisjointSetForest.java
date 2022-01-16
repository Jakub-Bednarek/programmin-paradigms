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
        link(findSet(forest[x]), findSet(forest[y]));
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

    public Node findSet(Node current){
        if(current.getParent() != current)
            current.setParent(findSet(current));

        return current.getParent();
    }

    public void printAllParents(){
        for(int i = 0; i < size; i++){
            System.out.println(forest[i].getValue() + ": " + forest[i].getParent().getValue());
        }
    }

    private void makeSet(int size){
        for(int i = 0; i < size; i++){
            forest[i] = new Node(i);
        }
    }
}
