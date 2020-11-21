package linked_list_graph;

/*
 * Developer: Brady Lange
 * Course: Data Structures & Algorithms - CSIS 237
 * Class: GraphLinkedListApplication
 * Language: Java
 * Date: 5/2/18
 * Description: This program tests the functionality of the Depth-First Search Algorithm for a Graph using a Linked List for an adjacency matrix.
 */

// This program tests the algorithms that are used in searching a graph data structure that is made up of a Linked List 
public class GraphLinkedListApplication
{
// ------------------- Main Method -------------------
	// Method that compiles and runs the program
	public static void main(String [] args) 
	{
		System.out.println("***************************************** Graph with Linked List: *******************************************");
		// Instantiate the graph linked list
		GraphLinkedList graphList = new GraphLinkedList();
		
		// Add vertices
		graphList.addVertex('A');	// 0
		graphList.addVertex('B');	// 1
		graphList.addVertex('C');	// 2
		graphList.addVertex('D');	// 3
		graphList.addVertex('E');	// 4
		graphList.addVertex('F');	// 5
		graphList.addVertex('G');	// 6
		graphList.addVertex('H');	// 7
		graphList.addVertex('I');	// 8
		
		// Add edges
		graphList.addEdge(0, 1);	// AB
		graphList.addEdge(1, 2);	// BC
		graphList.addEdge(0, 3);	// AD
		graphList.addEdge(0, 4);	// AE
		graphList.addEdge(2, 5);	// CF
		graphList.addEdge(2, 6);	// BG
		graphList.addEdge(3, 7);	// DH
		graphList.addEdge(3, 8);	// DI
		
		
		// Display Graph Linked List
		System.out.println("Graph Adjacency Linked List: ");
		System.out.println("********************************************************************************************************");
		graphList.displayAdjList();
		System.out.println("********************************************************************************************************\n");
		
		// Execute a Depth-First Search
		System.out.println("Graph Linked List -- Depth-First Search: ");
		System.out.println("********************************************************************************************************");
		graphList.DFS();
		System.out.println("\n********************************************************************************************************\n");
	}
// ------------------- End Main Method -------------------
} // End of class GraphLinkedListApplication
