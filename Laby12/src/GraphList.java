import java.util.*;

public class GraphList {
    class Node{
        private int key;
        private boolean visited;

        Node(int key){
            this.key = key;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null)
                return false;
            if(obj.getClass() != this.getClass())
                return false;

            Node other = (Node)obj;
            return key - other.key == 0;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(key);
        }

        @Override
        public String toString() {
            return String.valueOf(key);
        }
    }

    private final Map<Node, LinkedList<Node>> adjacencyMap;
    private final boolean directed;

    public GraphList(boolean directed){
        this.adjacencyMap = new HashMap<>();
        this.directed = directed;
    }

    public void addEdge(int v1, int v2){
        Node v1N = new Node(v1);
        Node v2N = new Node(v2);
        if(!adjacencyMap.containsKey(v1N))
            adjacencyMap.put(v1N, null);

        if(!adjacencyMap.containsKey(v2N))
            adjacencyMap.put(v2N, null);

        addNewEdge(v1N, v2N);

        if(!directed)
            addNewEdge(v2N, v1N);
    }

    private void addNewEdge(Node v1, Node v2){
        LinkedList<Node> current = adjacencyMap.get(v1);

        if(current == null)
            current = new LinkedList<>();
        else
            current.remove(v2);

        current.add(v2);
        adjacencyMap.put(v1, current);
    }

    public void BFS(int v){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(v));

        System.out.println("\nBFS w grafie na podstawie listy sąsiedztwa, wypisywany stan kolejki w każdym kroku:");
        while(!queue.isEmpty()){
            System.out.println("Queue: " + queue);
            Node current = queue.poll();
            current.visited = true;

            LinkedList<Node> neighbours = adjacencyMap.get(current);
            if(neighbours != null){
                for(Node n : neighbours){
                    if(!n.visited){
                        queue.add(n);
                    }
                }
            }
        }
    }

    public void DFS(int v){
        System.out.println("\nDFS w grafie na bazie listy sąsiedztwa, wypisane po kolei odwiedzane wierzchołki:");
        Node start = new Node(v);
        DFSrec(start);
        clearVisits();
    }

    private void clearVisits(){
        Set<Node> nodes = adjacencyMap.keySet();
        for(Node n : nodes){
            LinkedList<Node> nieghbours = adjacencyMap.get(n);

            if(nieghbours != null) {
                for(Node current : nieghbours){
                    current.visited = false;
                }
            }
        }
    }

    private void DFSrec(Node v){
        System.out.println("Current vertex: " + v.key);

        v.visited = true;
        LinkedList<Node> neighbours = adjacencyMap.get(v);

        if(neighbours == null)
            return;

        for(Node n : neighbours){
            if(!n.visited){
                DFSrec(n);
            }
        }
    }

    public void printEdges(){
        System.out.println("\nReprezentacja sąsiadujących wierzchołków w macierzy");
        for(Node node : adjacencyMap.keySet()){
            System.out.print("\n" + node.key + ": ");
            if(adjacencyMap.get(node) != null){
                for(Node current : adjacencyMap.get(node))
                    System.out.print(current.key + " ");
            } else{
                System.out.print("none");
            }
        }
        System.out.println();
    }
}
