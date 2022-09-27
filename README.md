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
> the descriptions for each class file is just an overview, for details please check the respective codes
* [Edge.java](src/Edge.java): self-explainatory
* [Graph.java](src/Graph.java): implements graph in both adjList and adjMatrix format, has different constructors for random graph generation
* [DijkstraAlgo.java](src/DijkstraAlgo.java): implements the Dijkstra algorithm in two ways: adjMatrix+Array and adjList+PriorityQueue.
* [Test.java](src/Test.java): holds all unit test sub-routines. Currenly building: empiricalTest1 and empiricalTest2
* [MakeCSV.java](src/MakeCSV.java): copied from our previous project, credit to Joel.
  
For convenience sake, if you want to create new test subroutines, you can directly commit to test.java at main branch

However, if you want to modify the implemented code, make sure to raise an issue and publish on a different branch so that our source code is protected.
## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

