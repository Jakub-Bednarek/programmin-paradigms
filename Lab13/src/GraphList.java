import java.util.*;

public class GraphList {
    class Edge implements Comparable<Edge>{
        int source;
        int destination;
        int weight;

        public void addData(int source, int destination, int weight){
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    class Subset{
        int parent, rank;
    }

    private int vertices;
    private Edge[] edges;

    GraphList(int nVertices, int nEdges){
        this.vertices = nVertices;
        edges = new Edge[nEdges];

        for(int i = 0; i < nEdges; i++){
            edges[i] = new Edge();
        }
    }

    public void addEdge(int edge, int v1, int v2, int weight){
        edges[edge].addData(v1, v2, weight);
    }

    public int kruskal(){
        Edge[] result = new Edge[vertices];
        Subset[] subsets = new Subset[vertices];
        int index = 0;

        Arrays.sort(edges);
        for(int i = 0; i < vertices; i++){
            result[i] = new Edge();
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        int i = 0;
        while(index < vertices - 1){
            Edge current = edges[i++];

            int x = find(subsets, current.source);
            int y = find(subsets, current.destination);

            if(x != y){
                result[index++] = current;
                union(subsets, x, y);
            }
        }


        System.out.println("\nKruskal minimum spanning tree connections");
        int minTree = 0;
        for(int j = 0; j < index; j++){
            System.out.println("Source: " + result[j].source + " dest: " + result[j].destination + " weight: " + result[j].weight);
            minTree += result[j].weight;
        }

        return minTree;
    }

    public void print(){
        for(int i = 0; i < edges.length; i++){
            System.out.println("Source: " + edges[i].source + " connected to: " + edges[i].destination + " weight: " + edges[i].weight);
        }
    }

    private int find(Subset[] subsets, int  i){
        if(subsets[i].parent != i){
            subsets[i].parent = find(subsets, subsets[i].parent);
        }

        return subsets[i].parent;
    }

    private void union(Subset[] subsets, int x, int y){
        int xRoot = find(subsets, x);
        int yRoot = find(subsets, y);

        if(subsets[xRoot].rank < subsets[yRoot].rank){
            subsets[xRoot].parent = yRoot;
        } else if (subsets[xRoot].rank > subsets[yRoot].rank){
            subsets[yRoot].parent = xRoot;
        } else {
            subsets[yRoot].parent = xRoot;
            subsets[xRoot].rank++;
        }
    }
}
