public class Main {
    public static void main(String[] args){
        GraphList graph = new GraphList(9, 14);
        graph.addEdge(0, 0, 1, 4);
        graph.addEdge(1, 0, 7, 8);
        graph.addEdge(2, 1, 2, 8);
        graph.addEdge(3, 2, 8, 2);
        graph.addEdge(4, 7, 8, 7);
        graph.addEdge(5, 7, 6, 1);
        graph.addEdge(6, 4, 3, 9);
        graph.addEdge(7, 3, 2, 7);
        graph.addEdge(8, 6, 8, 6);
        graph.addEdge(9, 6, 5, 2);
        graph.addEdge(10, 2, 5, 4);
        graph.addEdge(11, 3, 5, 14);
        graph.addEdge(12, 4, 5, 10);
        graph.addEdge(13, 7, 1, 11);
        graph.print();
        System.out.println("Min tree: " + graph.kruskal());

        GraphMatrix graphMatrix = new GraphMatrix(15, true, 9999);
        graphMatrix.addEdge(0, 1, 4);
        graphMatrix.addEdge(0, 7, 8);
        graphMatrix.addEdge(1, 2, 8);
        graphMatrix.addEdge(2, 8, 2);
        graphMatrix.addEdge(7, 8, 7);
        graphMatrix.addEdge(7, 6, 1);
        graphMatrix.addEdge(4, 3, 9);
        graphMatrix.addEdge(3, 2, 7);
        graphMatrix.addEdge(6, 8, 6);
        graphMatrix.addEdge(6, 5, 2);
        graphMatrix.addEdge( 2, 5, 4);
        graphMatrix.addEdge( 3, 5, 14);
        graphMatrix.addEdge( 4, 5, 10);
        graphMatrix.addEdge( 7, 1, 11);

        graphMatrix.shortestPathFloyd();


        GraphMatrix graphMatrix2 = new GraphMatrix(15, true, 0);
        graphMatrix2.addEdge(0, 1, 4);
        graphMatrix2.addEdge(0, 7, 8);
        graphMatrix2.addEdge(1, 2, 8);
        graphMatrix2.addEdge(2, 8, 2);
        graphMatrix2.addEdge(7, 8, 7);
        graphMatrix2.addEdge(7, 6, 1);
        graphMatrix2.addEdge(4, 3, 9);
        graphMatrix2.addEdge(3, 2, 7);
        graphMatrix2.addEdge(6, 8, 6);
        graphMatrix2.addEdge(6, 5, 2);
        graphMatrix2.addEdge( 2, 5, 4);
        graphMatrix2.addEdge( 3, 5, 14);
        graphMatrix2.addEdge( 4, 5, 10);
        graphMatrix2.addEdge( 7, 1, 11);
        System.out.println("Minimalne drzew rozpinające: " + graphMatrix2.prima());
    }
}
