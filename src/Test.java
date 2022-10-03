import java.io.IOException;

public class Test {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // *unncomment the following line to run the respective test program

        // testPrintGraph();
        // testDijkstraArray();
        //testDijkstraPQ();
        // testGenerateRandomGraph(10,10);
        //empiricalTest(300, 1000, 500, 1000);
        empiricalTestSparse(1000,1000,500,1000);
    }

    /**
     * Test the printGraph method
     */
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

    /**
     * Test the Dijkstra algorithm using an adjMatrix and Array
     */
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

    /**
     * Test the Dijkstra algorithm using an adjList and a PriorityQueue
     */
    private static void testDijkstraPQ() {
        System.out.println("testDijkstraPQ: ");
        Graph g = new Graph(5);
        g.addEdge(0,1,3);
        g.addEdge(0,2,10);
        g.addEdge(0,3,8);
        g.addEdge(0,4,11);
        g.addEdge(1,2,5);
        g.addEdge(1,3,3);
        g.addEdge(1,4,2);
        g.addEdge(2,3,1);
        g.addEdge(3,4,1);
        /*g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 2);
        g.addEdge(0, 3, 6);
        g.addEdge(0, 4, 8);
        g.addEdge(1, 3, 4);
        g.addEdge(1, 4, 3);
        g.addEdge(2, 3, 1);
        g.addEdge(3, 1, 1);
        g.addEdge(3, 4, 3);
        */
        g.printGraph();
        DijkstraAlgo dijkstraTest = new DijkstraAlgo(5);
        dijkstraTest.dijkstraPQStart(5, 0, g.adjList);
    }

    /**
     * Test the generateRandomGraph method
     * 
     * @param maxVertices maximum number of vertices
     * @param maxEdges    maximum number of edges
     */
    private static void testGenerateRandomGraph(int maxVertices, int maxWeight) {
        Graph g = new Graph(maxVertices, maxWeight, 0);
        System.out.println("Random Graph generated, V = " + g.V + ", E = " + g.E);
        g.printGraph();
    }

    /**
     * Test the Dijkstra algorithm on a random graph in two ways: adjMatrix+Array
     * and adjList+PQ. During the test, runtime (in nanoseconds) is recorded and
     * stored.
     * This test shall generate 4 .csv files, containing the results of the
     * empirical test: verticeArr.csv, edgeArr.csv,
     * timeArr(test1).csv, timeArr(test2).csv
     * 
     * @param maxVertices  maximum number of vertices for random graph generation
     * @param maxWeight    maximum weight for random graph generation
     * @param graphCount   number of graphs to be generated
     * @param averageTimes number of times to run the algorithm for each graph
     * @throws IOException
     */
    private static void empiricalTest(int maxVertices, int maxWeight, int graphCount, int averageTimes)
            throws IOException {
        long[] verticeArr = new long[graphCount], edgeArr = new long[graphCount], timeArr1 = new long[graphCount],
                timeArr2 = new long[graphCount];
        for (int i = 0; i < graphCount; i++) {
            System.out.println("Generating graph " + (i + 1) + "...");
            Graph g = new Graph(maxVertices, maxWeight, 0);
            verticeArr[i] = g.V;
            edgeArr[i] = g.E;
            long timeTotal1 = 0;
            long timeTotal2 = 0;
            for (int j = 0; j < averageTimes; j++) {
                DijkstraAlgo dijkstraTest = new DijkstraAlgo(g.V);
                long startTime = System.nanoTime();
                dijkstraTest.dijkstraArrayStart(g.V, 0, g.adjMatrix);
                long endTime = System.nanoTime();
                timeTotal1 += endTime - startTime;

                startTime = System.nanoTime();
                dijkstraTest.dijkstraPQStart(g.V, 0, g.adjList);
                endTime = System.nanoTime();
                timeTotal2 += endTime - startTime;
            }
            timeArr1[i] = timeTotal1 / averageTimes;
            timeArr2[i] = timeTotal2 / averageTimes;

        }
        MakeCSV.CSVprinter(verticeArr, "verticeArr.csv");
        MakeCSV.CSVprinter(edgeArr, "edgeArr.csv");
        MakeCSV.CSVprinter(timeArr1, "timeArr(test1).csv");
        MakeCSV.CSVprinter(timeArr2, "timeArr(test2).csv");
    }

    private static void empiricalTestSparse(int maxVertices, int maxWeight, int graphCount, int averageTimes)
            throws IOException {
        long[] verticeArr = new long[graphCount], edgeArr = new long[graphCount], timeArr1 = new long[graphCount],
                timeArr2 = new long[graphCount];
        for (int i = 0; i < graphCount; i++) {
            System.out.println("Generating graph " + (i + 1) + "...");
            Graph g = new Graph(maxVertices, maxWeight, 1);
            verticeArr[i] = g.V;
            edgeArr[i] = g.E;
            long timeTotal1 = 0;
            long timeTotal2 = 0;
            for (int j = 0; j < averageTimes; j++) {
                DijkstraAlgo dijkstraTest = new DijkstraAlgo(g.V);
                long startTime = System.nanoTime();
                dijkstraTest.dijkstraArrayStart(g.V, 0, g.adjMatrix);
                long endTime = System.nanoTime();
                timeTotal1 += endTime - startTime;

                startTime = System.nanoTime();
                dijkstraTest.dijkstraPQStart(g.V, 0, g.adjList);
                endTime = System.nanoTime();
                timeTotal2 += endTime - startTime;
            }
            timeArr1[i] = timeTotal1 / averageTimes;
            timeArr2[i] = timeTotal2 / averageTimes;

        }
        MakeCSV.CSVprinter(verticeArr, "verticeArr(Sparse).csv");
        MakeCSV.CSVprinter(edgeArr, "edgeArr(Sparse).csv");
        MakeCSV.CSVprinter(timeArr1, "timeArr1(Sparse).csv");
        MakeCSV.CSVprinter(timeArr2, "timeArr2(Sparse).csv");
    }

}