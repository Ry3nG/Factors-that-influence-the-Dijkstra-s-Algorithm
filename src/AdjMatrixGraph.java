public class AdjMatrixGraph {
    int V;
    int matrix[][];
    public AdjMatrixGraph(int nodes){
        V = nodes;
        matrix = new int[V][V];
    }
    public void addEdge(int src, int dest){
        matrix[src][dest] = 1;
        //matrix[dest][src] = 1; //commented because it is a directed graph
    }
    public void printGraph(){
        for(int i = 0; i < V; i++){
            System.out.print("Node " + i + " is connected to: ");
            for(int j = 0; j < V; j++){
                if(matrix[i][j] == 1){
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }
}
