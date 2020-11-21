package mst_graph;

/*
 * Developer: Brady Lange
 * Course: Data Structures & Algorithms - CSIS 237
 * Class: GraphSearchApplication
 * Language: Java
 * Date: 5/2/18
 * Description: This program tests the functionality of the Breadth-First Search & Depth-First Search Algorithms.
 */

// This program tests the algorithms that are used in searching a graph data structure
public class GraphSearchApplication
{
// ------------------- Main Method -------------------
	public static void main(String [] args) 
	{
		System.out.println("***************************************** Graphs - Breadth-First Seach & Depth-First Search: *******************************************");
		
		// Instantiate the graph
		Graph theGraph = new Graph();
		
		// Add the vertex's
		theGraph.addVertex('A');    // 0 (Start for BFS/DFS)
		theGraph.addVertex('B');    // 1
		theGraph.addVertex('C');    // 2
		theGraph.addVertex('D');    // 3
		theGraph.addVertex('E');    // 4
		
		// Add the edge's 
		theGraph.addEdge(0, 1);     // AB
		theGraph.addEdge(1, 2);     // BC
		theGraph.addEdge(0, 3);     // AD
		theGraph.addEdge(3, 4);     // DE
		
		// Depth-First Search
		System.out.println("Depth-First Search (DFS): ");
		System.out.println("********************************************************************************************************");
		theGraph.DFS();             
		System.out.println("********************************************************************************************************\n");

		// Breadth-First Search  
		System.out.println("Breadth-First Search (BFS): ");
		System.out.println("********************************************************************************************************");
		theGraph.BFS();             
		System.out.println("********************************************************************************************************\n");
	}
// ------------------- End Main Method -------------------
} // End of class GraphSearchApplication
