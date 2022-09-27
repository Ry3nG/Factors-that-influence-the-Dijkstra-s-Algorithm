import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraUsingPQ extends AdjListGraph {
    // dijkstra's algorithm using priority queue
    int[] d; // distance array
    int[] pi; // parent array
    boolean visited[];
    PriorityQueue<Edge> pq;

    public DijkstraUsingPQ(int V) {
        super(V);
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
    private void initialization(int src) {
        for (int i = 0; i < V; i++) {
            d[i] = Integer.MAX_VALUE;
            pi[i] = -1;
            visited[i] = false;
        }
        d[src] = 0;
    }
    private void printPath(int src, int dest) {
        if (dest == src) {
            System.out.print(src + " ");
            return;
        }
        printPath(src, pi[dest]);
        System.out.print(dest + " ");
    }
    private void printResult(int src) {
        for (int i = 0; i < V; i++) {
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
    //driver code
    public void dijkstraPQStart(int src){
        initialization(src);
        // add source vertice to the priority queue
        pq.add(new Edge(src, src, 0));
        
        while(!pq.isEmpty())
        {
            Edge edge = pq.remove();
            int u = edge.dest;
            if(visited[u])
                continue;
            visited[u] = true;
            for(Edge e: adjList[u])
            {
                int v = e.dest;
                if(!visited[v] && d[u] != Integer.MAX_VALUE && d[u] + e.weight < d[v])
                {
                    d[v] = d[u] + e.weight;
                    pi[v] = u;
                    pq.add(new Edge(u, v, d[v]));
                }
            }
        }
        //printResult(src);
    }

    

}
