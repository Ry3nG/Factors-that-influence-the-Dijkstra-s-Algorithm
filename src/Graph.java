import java.util.*;
public class Graph{
    ArrayList<ArrayList<Integer>> graph;
    int V;

    public Graph(int nodes){
        V = nodes;
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<Integer>());
        }
    }
    public void addEdge(int src, int dest){
        graph.get(src).add(dest);
        //graph.get(dest).add(src); //commented because it is a directed graph
    }
    public void printGraph(){
        for(int i = 0; i < V; i++){
            System.out.print("Node " + i + " is connected to: ");
            for(int j = 0; j < graph.get(i).size(); j++){
                System.out.print(graph.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
