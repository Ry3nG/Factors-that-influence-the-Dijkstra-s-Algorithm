import java.util.*;
public class AdjListGraph{
    int V;
    LinkedList<Edge>[] adjList;

    public AdjListGraph(int nodes){
        V = nodes;
        adjList = new LinkedList[V];
        for(int i = 0; i < V; i++){
            adjList[i] = new LinkedList<Edge>();
        }
    }
    public void addEdge(int src, int dest, int weight){
        Edge edge = new Edge(src, dest, weight);
        adjList[src].addFirst(edge); //directed graph
    }
    public void printGraph(){
        for(int i = 0; i < V; i++){
            LinkedList<Edge> list = adjList[i];
            System.out.print("Node " + i + " is connected to: ");
            for(int j = 0; j < list.size(); j++){
                System.out.print(list.get(j).dest + " ");
            }
            System.out.println();
        }
    }
}
