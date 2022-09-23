public class DijkstraUsingArray extends AdjMatrixGraph {
    int[] d;
    int[] pi;
    boolean[] visited;

    // constructor
    public DijkstraUsingArray(int nodes) {
        super(nodes);
        d = new int[nodes];
        pi = new int[nodes];
        visited = new boolean[nodes];
    }

    private void initialization(int src) {
        for (int i = 0; i < V; i++) {
            d[i] = Integer.MAX_VALUE;
            pi[i] = -1;
            visited[i] = false;
        }
        d[src] = 0;
    }

    private int findNextNode() {
        // returns the index of the next node to be visited
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < V; i++) {
            if (!visited[i] && d[i] < min) {
                min = d[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private void printPath(int src, int dest){
        if(dest == src){
            System.out.print(src + " ");
            return;
        }
        printPath(src, pi[dest]);
        System.out.print(dest + " ");
    }

    private void printResult(int src){
        for(int i = 0; i < V; i++){
            System.out.println("Shortest weight from "+src+" to " + i + " is " + d[i]);
            System.out.print("Path is: ");
            printPath(0, i);
            System.out.println();
        }
    } 

    // driver code
    public void dijkstraStart(int src) {
        initialization(src);
        int u;
        while ((u = findNextNode()) != -1) {
            visited[u] = true;
            for (int v = 0; v < V; v++) {
                if (!visited[v] && matrix[u][v] != 0 && d[u] != Integer.MAX_VALUE && d[u] + matrix[u][v] < d[v]) {
                    d[v] = d[u] + matrix[u][v];
                    pi[v] = u;
                }
            }
        }
        printResult(src);
    }
}
