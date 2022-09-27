import java.io.IOException;

public class Test {
    public static void main(String[] args) throws Exception {
        // *unncomment the following line to run the respective test program

        // testPrintGraph();
        // testDijkstra();
        // testDijkstraPQ();
        // testGenerateRandomAdjMatrixGraph(5,10);
        // testGenerateRandomAdjListGraph(5, 10);
        // empiricalTest1(1000, 10, 5);
        empiricalTest2(1000, 10, 5);
    }

    private static void empiricalTest2(int maxVertice, int maxWeight, int testCount) throws IOException {
        // ! this is the empirical test for the second question we raised
        /*
         * Suppose the input graph G = (V, E) is stored in an array of adjacency lists
         * and we use a minimizing heap for the priority queue.
         * Implement the Dijkstra’s algorithm using this setting and
         * analyze its time complexity with respect to |V| and |E| both theoretically
         * and empirically.
         */
        long[] verticeArr = new long[maxVertice];
        long[] edgeArr = new long[maxVertice];
        long[] runTimeArr = new long[maxVertice];
        for (int v = 2; v < maxVertice; v++) {
            long verticeTotal = 0, edgeTotal = 0, runTimeTotal = 0;
            for (int i = 0; i < testCount; i++) {
                System.out.println("Empirical test 2: testing graph with " + v + " vertices, test run " + (i + 1));
                GenerateRandomAdjListGraph graph = new GenerateRandomAdjListGraph(v);
                graph.GenerateRandomAdjListGraphStart(v, maxWeight);
                verticeTotal += graph.V;
                edgeTotal += graph.edgeCount;
                long startTime = System.nanoTime();
                graph.dijkstraPQStart(0);
                long endTime = System.nanoTime();
                runTimeTotal += (int) (endTime - startTime);
            }
            verticeArr[v] = verticeTotal / testCount;
            edgeArr[v] = edgeTotal / testCount;
            runTimeArr[v] = runTimeTotal / testCount;
        }
        makeCSV.CSVprinter(verticeArr, "verticeArr(Test2).csv");
        makeCSV.CSVprinter(edgeArr, "edgeArr(Test2).csv");
        makeCSV.CSVprinter(runTimeArr, "runTimeArr(Test2).csv");

    }

    private static void testGenerateRandomAdjListGraph(int nodes, int maxWeight) {
        GenerateRandomAdjListGraph graph = new GenerateRandomAdjListGraph(nodes);
        graph.GenerateRandomAdjListGraphStart(nodes, maxWeight);
        graph.printGraph();
    }

    private static void testDijkstraPQ() {
        DijkstraUsingPQ g = new DijkstraUsingPQ(5);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 2);
        g.addEdge(0, 3, 6);
        g.addEdge(0, 4, 8);
        g.addEdge(1, 3, 4);
        g.addEdge(1, 4, 3);
        g.addEdge(2, 3, 1);
        g.addEdge(3, 1, 1);
        g.addEdge(3, 4, 3);
        g.dijkstraPQStart(0);
    }

    private static void empiricalTest1(int maxVertice, int maxWeight, int testCount) throws IOException {
        // ! this is the empirical test for the first question we raised
        /*
         * Suppose the input graph G = (V, E) is stored in an adjacency matrix
         * and we use an array for the priority queue.
         * Implement the Dijkstra’s algorithm using this setting
         * and analyze its time complexity with respect to |V| and |E|
         * both theoretically and empirically.
         */
        long[] verticeArr = new long[maxVertice];
        long[] edgeArr = new long[maxVertice];
        long[] runTimeArr = new long[maxVertice];
        for (int v = 2; v < maxVertice; v++) {
            long verticeTotal = 0, edgeTotal = 0, runTimeTotal = 0;
            for (int i = 0; i < testCount; i++) {
                System.out.println("Empirical test 1: testing graph with " + v + " vertices, test run " + (i + 1));
                GenerateRandomAdjMatrixGraph graph = new GenerateRandomAdjMatrixGraph(v);
                graph.generateRandomGraphStart(v, maxWeight);
                verticeTotal += graph.V;
                edgeTotal += graph.edgeCount;
                long startTime = System.nanoTime();
                graph.dijkstraStart(0);
                long endTime = System.nanoTime();
                runTimeTotal += (int) (endTime - startTime);
            }
            verticeArr[v] = verticeTotal / testCount;
            edgeArr[v] = edgeTotal / testCount;
            runTimeArr[v] = runTimeTotal / testCount;

        }
        makeCSV.CSVprinter(verticeArr, "verticeArr(test1).csv");
        makeCSV.CSVprinter(edgeArr, "edgeArr(test1).csv");
        makeCSV.CSVprinter(runTimeArr, "runTimeArr(test1).csv");
    }

    private static void testGenerateRandomAdjMatrixGraph(int V, int maxWeight) {
        GenerateRandomAdjMatrixGraph graph = new GenerateRandomAdjMatrixGraph(V);
        graph.generateRandomGraphStart(V, maxWeight);
        graph.printGraph();
    }

    private static void testPrintGraph() {
        AdjListGraph g1 = new AdjListGraph(5);
        g1.addEdge(0, 1, 4);
        g1.addEdge(0, 2, 2);
        g1.addEdge(0, 3, 6);
        g1.addEdge(0, 4, 8);
        g1.addEdge(1, 3, 4);
        g1.addEdge(1, 4, 3);
        g1.addEdge(2, 3, 1);
        g1.addEdge(3, 1, 1);
        g1.addEdge(3, 4, 3);
        g1.printGraph();
        System.out.println();
        /*
         * AdjMatrixGraph g2 = new AdjMatrixGraph(5);
         * g2.addEdge(0, 1, 4);
         * g2.addEdge(0, 2, 2);
         * g2.addEdge(0, 3, 6);
         * g2.addEdge(0, 4, 8);
         * g2.addEdge(1, 3, 4);
         * g2.addEdge(1, 4, 3);
         * g2.addEdge(2, 3, 1);
         * g2.addEdge(3, 1, 1);
         * g2.addEdge(3, 4, 3);
         * g2.printGraph();
         */
    }

    private static void testDijkstra() {
        DijkstraUsingArray g = new DijkstraUsingArray(5);
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
        g.dijkstraStart(0);
    }
}
