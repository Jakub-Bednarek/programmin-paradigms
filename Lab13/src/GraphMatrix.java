import java.util.Arrays;

public class GraphMatrix {
    final private boolean directed;
    private int[][] matrix;
    private int nVertices;

    public GraphMatrix(int nVertices, boolean directed, int baseValue){
        this.nVertices = nVertices;
        this.matrix = new int[nVertices][nVertices];
        this.directed = directed;

        for(int i = 0; i < nVertices; i++){
            Arrays.fill(matrix[i], baseValue);
        }
    }

    public void addEdge(int v1, int v2, int weight){
        matrix[v1][v2] = weight;

        if(!directed)
            matrix[v2][v1] = weight;
    }

    public void removeEdge(int v1, int v2, int weight){
        matrix[v1][v2] = weight;

        if(!directed)
            matrix[v2][v1] = weight;
    }

    public int prima(){
        int[] parent = new int[nVertices];
        int[] key = new int[nVertices];
        int spanningTreeSum = 0;
        boolean[] mstSet = new boolean[nVertices];

        for(int i = 0; i < nVertices; i++){
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for(int i = 0; i < nVertices - 1; i++){
            int minIndex = minIndex(key, mstSet);

            try{
                mstSet[minIndex] = true;
            } catch(ArrayIndexOutOfBoundsException e){
                minIndex = 0;
                System.out.println("Nie wiem dlaczego tutaj wyrzuca wyjątek i nie udało mi się znaleźć przyczyny :(");
            }

            for(int j = 0; j < nVertices; j++){
                if(matrix[minIndex][j] != 0 && !mstSet[j] && matrix[minIndex][j] < key[j]){
                    parent[j] = minIndex;
                    key[j] = matrix[minIndex][j];
                }
            }
        }

        for (int j : key) {
            spanningTreeSum += j;
        }

        System.out.println("Spanning tree weights sum: " + spanningTreeSum);

        return 0;
    }

    public void shortestPathFloyd(){
        int[][] shortestGraph = new int[matrix.length][matrix.length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                shortestGraph[i][j] = matrix[i][j];
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                for(int k = 0; k < matrix.length; k++){
                    if(shortestGraph[j][i] + shortestGraph[i][k] < shortestGraph[j][k])
                        shortestGraph[j][k] = shortestGraph[j][i] + shortestGraph[i][k];
                }
            }
        }

        printShortestPathMatrix(shortestGraph);
    }

    private void printShortestPathMatrix(int[][] graph){
        System.out.println("\nReprezentacja grafu najkrótszych ścieżek:");
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].length; j++){
                if(graph[i][j] != 9999)
                    System.out.printf("%2d ", graph[i][j]);
                else
                    System.out.printf("%2d ", 0);
            }
            System.out.println();
        }
    }

    private int minIndex(int[] keys, boolean[] mstSet){
        int min = Integer.MAX_VALUE;
        int index = -1;

        for(int i = 0; i < nVertices; i++){
            if(!mstSet[i] && keys[i] < min) {
                min = keys[i];
                index = i;
            }
        }

        return index;
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
        }

        return buffer.toString();
    }
}
