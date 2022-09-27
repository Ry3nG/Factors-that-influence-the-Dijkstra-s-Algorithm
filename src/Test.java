import java.io.IOException;

public class Test {
    public static void main(String[] args) throws Exception {
        // *unncomment the following line to run the respective test program

        //testPrintGraph();
        //testDijkstraArray();
        //testDijkstraPQ();
        //testGenerateRandomGraph(10,10);

    }
    private static void testPrintGraph() {
        Graph g = new Graph(5);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 2);
        g.addEdge(0, 3, 6);
        g.addEdge(0, 4, 8);
        g.addEdge(1, 3, 4);
        g.addEdge(1, 4, 3);
        g.addEdge(2, 3, 1);
        g.addEdge(3, 1, 1);
        g.addEdge(3, 4, 3);
        g.printGraph();
        System.out.println();
    }
    private static void testDijkstraArray() {
        System.out.println("teesDijkstraArray: ");
        Graph g = new Graph(5);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 2);
        g.addEdge(0, 3, 6);
        g.addEdge(0, 4, 8);
        g.addEdge(1, 3, 4);
        g.addEdge(1, 4, 3);
        g.addEdge(2, 3, 1);
        g.addEdge(3, 1, 1);
        g.addEdge(3, 4, 3);
        g.printGraph();
        DijkstraAlgo dijkstraTest = new DijkstraAlgo(5);
        dijkstraTest.dijkstraArrayStart(5, 0, g.adjMatrix);
    }
    
    private static void testDijkstraPQ() {
        System.out.println("testDijkstraPQ: ");
        Graph g = new Graph(5);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 2);
        g.addEdge(0, 3, 6);
        g.addEdge(0, 4, 8);
        g.addEdge(1, 3, 4);
        g.addEdge(1, 4, 3);
        g.addEdge(2, 3, 1);
        g.addEdge(3, 1, 1);
        g.addEdge(3, 4, 3);
        g.printGraph();
        DijkstraAlgo dijkstraTest = new DijkstraAlgo(5);
        dijkstraTest.dijkstraPQStart(5, 0, g.adjList);
    }
    
    private static void testGenerateRandomGraph(int maxVertices, int maxWeight) {
        Graph g = new Graph(maxVertices, maxWeight);
        System.out.println("Random Graph generated, V = " + g.V + ", E = " + g.E);
        g.printGraph();
    }

}