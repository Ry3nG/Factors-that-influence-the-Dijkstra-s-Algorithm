public class App {
    public static void main(String[] args) throws Exception {
        AdjListGraph g1 = new AdjListGraph(5);
        g1.addEdge(0, 1,4);
        g1.addEdge(0, 2,2);
        g1.addEdge(0, 3,6);
        g1.addEdge(0, 4,8);
        g1.addEdge(1, 3,4);
        g1.addEdge(1, 4,3);
        g1.addEdge(2, 3,1);
        g1.addEdge(3, 1,1);
        g1.printGraph();

        System.out.println();
        AdjMatrixGraph g2 = new AdjMatrixGraph(5);
        g2.addEdge(0, 1,4);
        g2.addEdge(0, 2,2);
        g2.addEdge(0, 3,6);
        g2.addEdge(0, 4,8);
        g2.addEdge(1, 3,4);
        g2.addEdge(1, 4,3);
        g2.addEdge(2, 3,1);
        g2.addEdge(3, 1,1);
        g2.printGraph();
    }
}
