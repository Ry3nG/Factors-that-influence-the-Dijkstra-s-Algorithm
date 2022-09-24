# Factors that influence the Dijkstra's Algorithm
> This is a NTU SC2001 Example Class Project
> 
The objective of this project is to explore factors that influence the performance of the Dijkstra's Algorithm.

In the Dijkstra’s algorithm, the choice of the input graph representation and the priority
queue implementation will affect its time complexity

## Content
(a) Suppose the input graph G = (V, E) is stored in an adjacency matrix and we
use an array for the priority queue. Implement the Dijkstra’s algorithm using this
setting and analyze its time complexity with respect to |V| and |E| both
theoretically and empirically.

(b) Suppose the input graph G = (V, E) is stored in an array of adjacency lists and
we use a minimizing heap for the priority queue. Implement the Dijkstra’s
algorithm using this setting and analyze its time complexity with respect to |V|
and |E| both theoretically and empirically.

(c) Compare the two implementations in (a) and (b). Discuss which implementation
is better and in what circumstances. 

## Development
**[IMPORTANT] Make sure to read through this section before proceeding to develop this project (Updating...)**
1. The three basic classes are Edge, AdjListGraph and AdjMatrixGraph. Their purposes are self-explanatory.
2. I'm currently working on Question (a)(see 'Content' for details) so I created DijkstraUsingArray which extends AdjMatrixGraph.
3. GenerateRandomAdjMatrixGraph extends DijkstraUsingArray, its purpose is also self-explanatory.
4. The Test class will be where we carry out all the empirical tests. I've maintained all the test sub-routines as private methods so you can simply uncomment in 'main' to run the tests. All future tests should also be maintained in the same way.
5. makeCSV file is directly from out last project, credit to Joel. I think we will use that later.
## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

