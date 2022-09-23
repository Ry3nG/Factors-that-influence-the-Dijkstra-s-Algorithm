public class DijkstraUsingArray extends AdjMatrixGraph{
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






    //driver code
    public void dijkstraStart(int src){
        // initialization
        for(int i = 0; i < V; i++){
            d[i] = Integer.MAX_VALUE;
            pi[i] = -1;
            visited[i] = false;
        }
        d[src] = 0;
    } 
}
