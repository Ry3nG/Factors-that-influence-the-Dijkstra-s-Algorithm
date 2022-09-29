import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class DijkstraAlgo {
    static int[] d;
    static int[] pi;
    static boolean[] visited;
    static PriorityQueue<Edge> pq;

    public DijkstraAlgo(int V) {
        d = new int[V];
        pi = new int[V];
        visited = new boolean[V];
        pq = new PriorityQueue<>(V, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                if (o1.weight > o2.weight)
                    return 1;
                else if (o1.weight < o2.weight)
                    return -1;
                else
                    return 0;
            }
        });
    }

    private static void initialization(int vertice, int src) {
        for (int i = 0; i < vertice; i++) {
            d[i] = Integer.MAX_VALUE;
            pi[i] = -1;
            visited[i] = false;
        }
        d[src] = 0;
    }

    private static int findNextNode(int vertice) {
        // returns the index of the next node to be visited
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < vertice; i++) {
            if (!visited[i] && d[i] < min) {
                min = d[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static void printPath(int src, int dest) {
        if (dest == src) {
            System.out.print(src + " ");
            return;
        }
        printPath(src, pi[dest]);
        System.out.print(dest + " ");
    }

    private static void printResult(int vertice, int src) {
        for (int i = 0; i < vertice; i++) {
            if (d[i] == Integer.MAX_VALUE) {
                System.out.println("No path from " + src + " to " + i);
            } else {
                System.out.println("Shortest weight from " + src + " to " + i + " is " + d[i]);
                System.out.print("Path is: ");
                printPath(src, i);
                System.out.println();
            }
        }
    }

    // * driver code
    public void dijkstraArrayStart(int vertice, int src, int[][] adjMatrix) {
        initialization(vertice, src);
        int u;
        while ((u = findNextNode(vertice)) != -1) {
            visited[u] = true;
            for (int v = 0; v < vertice; v++) {
                if (!visited[v] && adjMatrix[u][v] != 0 && d[u] != Integer.MAX_VALUE && d[u] + adjMatrix[u][v] < d[v]) {
                    d[v] = d[u] + adjMatrix[u][v];
                    pi[v] = u;
                }
            }
        }
    }

    public void dijkstraPQStart(int vertice, int src, LinkedList<Edge>[] adjList) {
        initialization(vertice, src);
        pq.add(new Edge(src, src, 0));
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int u = edge.dest;
            if (visited[u])
                continue;
            visited[u] = true;
            for (Edge e : adjList[u]) {
                int v = e.dest;
                if (!visited[v] && d[u] != Integer.MAX_VALUE && d[u] + e.weight < d[v]) {
                    d[v] = d[u] + e.weight;
                    pi[v] = u;
                    pq.add(new Edge(u, v, d[v]));
                }
            }
        }
    }
}
