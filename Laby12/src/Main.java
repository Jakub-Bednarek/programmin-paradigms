public class Main {
    public static void main(String[] args){
        GraphMatrix graph = new GraphMatrix(22, true);

        graph.addEdge(4, 5);
        graph.addEdge(4, 8);
        graph.addEdge(4, 9);
        graph.addEdge(8, 13);
        graph.addEdge(8, 16);
        graph.addEdge(13, 15);
        graph.addEdge(5, 1);
        graph.addEdge(1, 19);
        graph.addEdge(1, 20);
        graph.addEdge(1, 21);
        graph.addEdge(5, 2);
        graph.addEdge(9, 12);
        graph.addEdge(12, 6);
        graph.addEdge(6, 10);
        System.out.println(graph);

        graph.DFS(4);
        graph.BFS(4);


        GraphList graphList = new GraphList(true);
        graphList.addEdge(4, 5);
        graphList.addEdge(4, 8);
        graphList.addEdge(4, 9);
        graphList.addEdge(8, 13);
        graphList.addEdge(8, 16);
        graphList.addEdge(13, 15);
        graphList.addEdge(5, 1);
        graphList.addEdge(1, 19);
        graphList.addEdge(1, 20);
        graphList.addEdge(1, 21);
        graphList.addEdge(5, 2);
        graphList.addEdge(9, 12);
        graphList.addEdge(12, 6);
        graphList.addEdge(6, 10);
        graphList.printEdges();

        graphList.DFS(4);
        graphList.BFS(4);
    }
}
