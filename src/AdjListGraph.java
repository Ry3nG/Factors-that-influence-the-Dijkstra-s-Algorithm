import java.util.LinkedList;

public class AdjListGraph {
    static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    int V;
    int edgeCount;
    LinkedList<Edge>[] adjList;

    public AdjListGraph(int vertices) {
        this.V = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest, int weight) {
        Edge edge = new Edge(src, dest, weight);
        adjList[src].addFirst(edge);
        edgeCount++;
    }

    public void printGraph() {
        for (int i = 0; i < V; i++) {
            LinkedList<Edge> list = adjList[i];
            for (int j = 0; j < list.size(); j++) {
                System.out.println(
                        "vertex " + i + " is connected to " + list.get(j).dest + " with weight " + list.get(j).weight);
            }
        }
    }
}
