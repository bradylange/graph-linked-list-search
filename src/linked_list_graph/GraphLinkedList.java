package linked_list_graph;

/*
 * Developer: Brady Lange
 * Course: Data Structures & Algorithms - CSIS 237
 * Class: GraphLinkedList
 * Language: Java
 * Date: 5/2/18
 * Description: This class contains attributes relating to a Graph that uses a Linked List for its adjacency matrix.
 */

// This class contains Graph Linked List attributes
public class GraphLinkedList 
{
	// Instance variables
	LinkedList adjList; 													// Adjacency Linked List
	private final int MAX_VERTS = 20;										// Max size of the Graph Linked List
	private Vertex vertexList[]; 											// List of vertices
	private int nVerts;          											// Current number of vertices
	private Stack theStack;													// Stack for searching the graph (DFS)
// ------------------- Default Constructor -------------------
	// Default Constructor
	public GraphLinkedList()
	{
		vertexList = new Vertex[MAX_VERTS];									// Set max vertices 
		adjList = new LinkedList(); 										//Adjacency list
		nVerts = 0;															// 0 vertices
		theStack = new Stack();												// Instantiate the Stack
	}
// ------------------- End Default Constructor -------------------
	
// ------------------- Add Vertex Method -------------------
	// Method that adds vertex to the Graph 
	public void addVertex(char letter)
	{
		vertexList[nVerts++] = new Vertex(letter);							// Add vertex
	}
// ------------------- End Add Vertex Method -------------------
	
// ------------------- Add Edge Method -------------------
	// Method that adds an edge to the Graph
	public void addEdge(int start, int end)
	{
		adjList.insertAfter(start, end);									// Link start vertex to end vertex
		adjList.insertAfter(end, start);									// Link end vertex to start vertex
	}
// ------------------- End Add Edge Method -------------------
	
// ------------------- Display Adjacency List Method -------------------	
	// Method that displays the adjacency list
	public void displayAdjList()
	{
		adjList.displayList();												// Display the Linked List 
	}
// ------------------- End Display Adjacency List Method -------------------
	
// ------------------- Display Vertex Method -------------------
	// Method that displays the current vertex
	public void displayVertex(int vertex)
	{
		System.out.print(vertexList[vertex].label);							// Display the vertex 		
	}
// ------------------- End Display Vertex Method -------------------
	
// ------------------- Get Adjacent Unvisited Vertex Method -------------------
	// Method that returns the unvisited adjacent vertex
	public int getAdjUnvisitedVertex(int vertex)
	{
		for (int j = vertex; j < nVerts; j++)								// Iterate through adjacent vertices 
		{
			if (adjList.find(vertex).start == adjList.find(j).end && vertexList[j].wasVisited == false)	// If adjacent vertex is unvisited 
			{
				return j;													// Return unvisited vertex 
			}
		}
		return -1;															// No unvisited vertices 
	}  
// ------------------- End Get Adjacent Unvisited Vertex Method -------------------
	
// ------------------- Depth-First Search Method -------------------
	// Depth-First Search Algorithm
	public void DFS()
	{																		// Begin at vertex 0
		vertexList[0].wasVisited = true;  									// Mark it
		theStack.push(0);                 									// Push it
		
		while(!theStack.isEmpty())      									// Until stack empty,
		{
			int currentVertex = theStack.peek();							// Get the current vertex 
			int vertex = getAdjUnvisitedVertex(currentVertex);				// Get an unvisited vertex adjacent to Stack top
			if (vertex == -1)                    							// If no such vertex,
			{
				theStack.pop();												// Remove item from top of the Stack
			}
			else                           									// If it exists,
			{
				vertexList[vertex].wasVisited = true;  						// Mark it
				displayVertex(currentVertex);     							// From current vertex
				displayVertex(vertex);                 						// Display it
				System.out.print(" ");
				theStack.push(vertex);                 						// Push it
			}
		}  
																			// Stack is empty, so we're done
		for (int j = 0; j < nVerts; j++)          							// Reset flags
		{
			vertexList[j].wasVisited = false;								// No vertices visited 
		}
	}
// ------------------- End Depth-First Search Method -------------------
} // End of class GraphLinkedList
