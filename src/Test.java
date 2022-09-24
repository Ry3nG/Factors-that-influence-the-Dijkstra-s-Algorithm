public class Test {
    public static void main(String[] args) throws Exception {
        //*unncomment the following line to run the respective test program
        
        //testPrintGraph();
        //testDijkstra();
        //testGenerateRandomAdjMatrixGraph(5,10);
        empiricalTest1(5,10);
    }
    private static void empiricalTest1(int V, int maxWeight){
        //! this is the empirical test for the first question we raised
        /*
         * Suppose the input graph G = (V, E) is stored in an adjacency matrix
         *  and we use an array for the priority queue. 
         * Implement the Dijkstra’s algorithm using this setting
         *  and analyze its time complexity with respect to |V| and |E| 
         * both theoretically and empirically.
         */
        GenerateRandomAdjMatrixGraph graph = new GenerateRandomAdjMatrixGraph(V);
        graph.generateRandomGraphStart(V, maxWeight);
        graph.printGraph();
        System.out.println();
        for(int i = 0; i < V; i++){
            graph.dijkstraStart(i);
            System.out.println();
        }
         
    }
    private static void testGenerateRandomAdjMatrixGraph(int V, int maxWeight) {
        GenerateRandomAdjMatrixGraph graph = new GenerateRandomAdjMatrixGraph(V);
        graph.generateRandomGraphStart(V, maxWeight);
        graph.printGraph();
    }

    private static void testPrintGraph(){
        AdjListGraph g1 = new AdjListGraph(5);
        g1.addEdge(0, 1,4);
        g1.addEdge(0, 2,2);
        g1.addEdge(0, 3,6);
        g1.addEdge(0, 4,8);
        g1.addEdge(1, 3,4);
        g1.addEdge(1, 4,3);
        g1.addEdge(2, 3,1);
        g1.addEdge(3, 1,1);
        g1.addEdge(3, 4,3);
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
        g2.addEdge(3, 4,3);
        g2.printGraph(); 
    }
    private static void testDijkstra(){
        DijkstraUsingArray g = new DijkstraUsingArray(5);
        g.addEdge(0, 1,4);
        g.addEdge(0, 2,2);
        g.addEdge(0, 3,6);
        g.addEdge(0, 4,8);
        g.addEdge(1, 3,4);
        g.addEdge(1, 4,3);
        g.addEdge(2, 3,1);
        g.addEdge(3, 1,1);
        g.addEdge(3, 4,3);
        g.printGraph();
        g.dijkstraStart(0);
    }
}
