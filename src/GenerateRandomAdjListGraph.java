import java.util.Random;

public class GenerateRandomAdjListGraph extends DijkstraUsingPQ {
    public GenerateRandomAdjListGraph(int V) {
        super(V);
    }
    private boolean existEdge(int src, int dest){
        // check if there is already an edge between src and dest
        for (int i = 0; i < adjList[src].size(); i++) {
            if(adjList[src].get(i).dest == dest){
                return true;
            }
        }
        return false;
    }
    //* driver code
    public void GenerateRandomAdjListGraphStart(int nodes, int maxWeight){
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
            if (src != dest /*&& !existEdge(src, dest)*/) {
                int weight = rand.nextInt(maxWeight);
                addEdge(src, dest, weight);
            }
        }
    }
    
}
    

