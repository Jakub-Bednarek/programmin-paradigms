import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphMatrix {
    final private boolean directed;
    private boolean[][] matrix;
    private int nVertices;

    public GraphMatrix(int nVertices, boolean directed){
        this.nVertices = nVertices;
        this.matrix = new boolean[nVertices][nVertices];
        this.directed = directed;
    }

    public void addEdge(int v1, int v2){
        matrix[v1][v2] = true;

        if(!directed)
            matrix[v2][v1] = true;
    }

    public void removeEdge(int v1, int v2){
        matrix[v1][v2] = false;

        if(!directed)
            matrix[v2][v1] = false;
    }

    public void BFS(int v){
        boolean[] visited = new boolean[nVertices];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        System.out.println("\nBFS w grafie na podstawie macierzy sąsiedztwa, wypisywany stan kolejki w każdym kroku:");
        while(!queue.isEmpty()){
            System.out.println("Queue: " + queue);
            int current = queue.poll();

            for(int i = 0; i < nVertices; i++){
                if(matrix[current][i] && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public void DFS(int v){
        boolean visited[] = new boolean[nVertices];

        System.out.println("\nDFS w grafie na podstawie macierzy sąsiedztwa, wypisane kolejno odwiedzane wierzchołki:");
        DFS(v, visited);
    }

    private void DFS(int v, boolean[] visited){
        System.out.println("Vertex: " + v);

        visited[v] = true;
        for(int i = 0; i < nVertices; i++){
            if(matrix[v][i] && !visited[i]){
                DFS(i, visited);
            }
        }
    }

    @Override
    public String toString(){
        StringBuffer buffer = new StringBuffer();

        buffer.append("Reprezentacja graficzna macierzy sąsiedztwa\n");
        buffer.append("  ");
        for(int i = 0; i < nVertices; i++){
            buffer.append(i + " ");
        }
        buffer.append('\n');

        for(int i = 0; i < nVertices; i++){
            buffer.append(i + " ");
            for(int j = 0; j < nVertices; j++){
                if(matrix[i][j])
                    buffer.append("1" + " ");
                else
                    buffer.append("0" + " ");
            }
            buffer.append('\n');
        }

        return buffer.toString();
    }
}
