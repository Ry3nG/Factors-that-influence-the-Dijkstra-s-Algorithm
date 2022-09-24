import java.util.Random;

public class GenerateRandomAdjMatrixGraph extends DijkstraUsingArray {

    public GenerateRandomAdjMatrixGraph(int nodes) {
        super(nodes);
    }
    private boolean existEdge(int src, int dest){
        // check if there is alreeady an edge between src and dest
        if(matrix[src][dest] != 0){
            return true;
        }
        return false;
    }
    
    //* driver code
    public void generateRandomGraphStart(int nodes, int maxWeight) {
        /*
         * For a randomly chosen number of vertices V,
         * the maximum number of possible edges is
         * V*(V – 1)(with no multiple edges and self-loops).
         */
        Random rand = new Random();
        int maxEdges = nodes * (nodes - 1);
        int randEdges = rand.nextInt(maxEdges-1+1) + 1;
        for (int i = 0; i < randEdges; i++) {
            int src = rand.nextInt(nodes);
            int dest = rand.nextInt(nodes);
            if (src != dest && !existEdge(src, dest)) {
                int weight = rand.nextInt(maxWeight);
                addEdge(src, dest, weight);
            }
        }
    }

}
