import java.util.LinkedList;
import java.util.Random;

public class Graph {

    int V;
    int E;
    LinkedList<Edge>[] adjList;
    int adjMatrix[][];

    public Graph(int V) {
        this.V = V;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
        adjMatrix = new int[V][V];
    }

    public Graph(int V, int maxWeight) {
        // random graph generator

        this.V = V;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
        adjMatrix = new int[V][V];

        /*
         * For a randomly chosen number of vertices V,
         * the maximum number of possible edges is
         * V*(V – 1)(with no multiple edges and self-loops).
         */
        Random rand = new Random();
        int maxEdges = V * (V - 1);
        int randEdges = rand.nextInt(maxEdges - 1 + 1) + 1;
        for (int i = 0; i < randEdges; i++) {
            int src = rand.nextInt(V);
            int dest = rand.nextInt(V);
            if (src != dest && !existEdge(src, dest)) {
                int weight = rand.nextInt(maxWeight);
                addEdge(src, dest, weight);
            }
        }
    }

    public void addEdge(int src, int dest, int weight) {
        Edge edge = new Edge(src, dest, weight);
        adjList[src].addFirst(edge);
        adjMatrix[src][dest] = weight;
    }

    public void printGraph() {
        for (int i = 0; i < V; i++) {
            LinkedList<Edge> list = adjList[i];
            for (int j = 0; j < list.size(); j++) {
                System.out.println("vertex " + i + " is connected to " + list.get(j).dest + " with weight "
                        + list.get(j).weight);
            }
        }
    }

    public boolean existEdge(int src, int dest) {
        // check if there is alreeady an edge between src and dest
        if (adjMatrix[src][dest] != 0) {
            return true;
        }
        return false;
    }

}
