package mst_graph;

/*
 * Developer: Brady Lange
 * Course: Data Structures & Algorithms - CSIS 237
 * Class: MSTSearchApplication
 * Language: Java
 * Date: 5/2/18
 * Description: This program tests the Graph class's minimal spanning trees (Primms Algorithm).
 */

// This program tests the algorithms used in searching a Minimal Spanning Tree graph
public class MSTSearchApplication
{
// ------------------- Main Method -------------------
	// Method that compiles and runs the program
	public static void main(String [] args) 
	{
		System.out.println("***************************************** Graphs - Minimal Spanning Tree [Primms Algorithm]: *******************************************");
		
		// Instantiate the graph
		Graph theGraph = new Graph();
		
		// Add the vertices
		theGraph.addVertex('A');    // 0 (Start for MST)
		theGraph.addVertex('B');    // 1
		theGraph.addVertex('C');    // 2
		theGraph.addVertex('D');    // 3
		theGraph.addVertex('E');    // 4
		theGraph.addVertex('F');    // 5
		theGraph.addVertex('G');    // 6
		theGraph.addVertex('H');    // 7
		theGraph.addVertex('I');    // 8 
		
		// Add the edges
		theGraph.addEdge(0, 1);     // AB
		theGraph.addEdge(0, 2);     // AC
		theGraph.addEdge(0, 3);     // AD
		theGraph.addEdge(0, 4);     // AE
		theGraph.addEdge(0, 5);     // AF
		theGraph.addEdge(0, 6);     // AG
		theGraph.addEdge(0, 7);     // AH
		theGraph.addEdge(0, 8);     // AI
		theGraph.addEdge(1, 2);     // BC
		theGraph.addEdge(1, 3);     // BD
		theGraph.addEdge(1, 4);     // BE
		theGraph.addEdge(1, 5);     // BF
		  
		// Print out the MST's 
		// Depth-First Search minimal spanning tree (Primms Algorithm)
		System.out.println("Minimum Spanning Tree -- Depth-First Search (DFS): ");
		System.out.println("********************************************************************************************************");
		theGraph.MST_DFS();   
		System.out.println("\n********************************************************************************************************\n");
		  
		// Breadth-First Search minimal spanning tree (Primms Algorithm)
		System.out.println("Minimum Spanning Tree -- Breadth-First Search (BFS): ");
		System.out.println("********************************************************************************************************");
		theGraph.MST_BFS();             							
		System.out.println("\n********************************************************************************************************\n");
	}
// ------------------- End Main Method -------------------
} // End of class MSTSearchApplication
