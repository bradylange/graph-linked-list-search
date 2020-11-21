package mst_graph;

/*
 * Developer: Brady Lange
 * Course: Data Structures & Algorithms - CSIS 237
 * Class: Graph
 * Language: Java
 * Date: 5/2/18
 * Description: This class contains graph data structure features/algorithms such as Depth-First Search, Breadth-First Search, and Minimal Spanning Tree's.
 */

// This class contains graph features and algorithms (BFS, DFS, MST)
public class Graph
{
	// Instance variables 
	private final int MAX_VERTS = 20;										// Max size of Graph
	private Vertex vertexList[]; 											// List of vertices
	private int adjMat[][];      											// Adjacency matrix
	private int nVerts;          											// Current number of vertices
	private Stack theStack;													// Stack for searching the Graph (DFS)
	private Queue theQueue;													// Queue for searching the Graph (BFS)
// ------------------- Default Constructor -------------------
	// Default Constructor
	public Graph()             
	{
		vertexList = new Vertex[MAX_VERTS];									// Instantiate vertices 						
		adjMat = new int[MAX_VERTS][MAX_VERTS];								// Adjacency matrix
		nVerts = 0;															// Default of 0 vertices
		for (int y = 0; y < MAX_VERTS; y++)      							// Set adjacency vertices
		{
			for (int x = 0; x < MAX_VERTS; x++)  							// Matrix to 0
			{
				adjMat[x][y] = 0;											// Set default state of vertices 
			}
		}
		
		theStack = new Stack();												// Instantiate the Stack
		theQueue = new Queue();												// Instantiate the Queue
	}
// ------------------- End Default Constructor -------------------
	
// ------------------- Add Vertex Method -------------------
	// Method that adds a vertex to the Graph
	public void addVertex(char lab)
	{
		vertexList[nVerts++] = new Vertex(lab);								// Add vertex to Graph
	}
// ------------------- End Add Vertex Method -------------------
	
// ------------------- Add Edge Method -------------------
	public void addEdge(int start, int end)
	// Method that adds a edge to the Graph
	{
		adjMat[start][end] = 1;												// Link start vertex to end vertex
		adjMat[end][start] = 1;												// Link end vertex to start vertex
	}
// ------------------- End Add Edge Method -------------------
	
// ------------------- Display Vertex Method -------------------
	// Method that displays a vertex 
	public void displayVertex(int vertex)
	{
		System.out.print(vertexList[vertex].label);							// Print the vertex out
	}
// ------------------- End Display Vertex Method -------------------
	
// ------------------- Depth-First Search Method -------------------
	// Method that searches in a graph using the Depth-First Search algorithm (Uses Stack)
	public void DFS()  
	{                                 										// Begin at vertex 0
		vertexList[0].wasVisited = true;  									// Mark it
		displayVertex(0);                 									// Display it
		theStack.push(0);                 									// Push it
		
		while (!theStack.isEmpty())      									// Until Stack empty,
		{																	// Get an unvisited vertex adjacent to stack top
			int vertex = getAdjUnvisitedVertex(theStack.peek());
			if (vertex == -1)                    							// If no such vertex,
			{
				theStack.pop();												// Remove the top item from the Stack
			}
			else                           									// If it exists,
			{
				vertexList[vertex].wasVisited = true;  						// Mark it
				displayVertex(vertex);                 						// Display it
				theStack.push(vertex);                 						// Push it
			}
		} 
																			// Stack is empty, so we're done
		for (int j = 0; j < nVerts; j++)          							// Reset flags
		{
			vertexList[j].wasVisited = false;								// None of the vertices have been visited 
		}
	}
// ------------------- End Depth-First Search Method -------------------
	
// ------------------- Breadth-First Search Method -------------------
	// Method that searches in a graph using the Breadth-First Search algorithm (Uses Queue)
	public void BFS()                  
	{                                										// Begin at vertex 0
		vertexList[0].wasVisited = true; 									// Mark it
		displayVertex(0);                									// Display it
		theQueue.insert(0);              									// Insert at tail
		int vertex2;
		
		while (!theQueue.isEmpty())     									// Until Queue empty,
		{
			int vertex1 = theQueue.remove();   								// Remove vertex at head
																			// Until it has no unvisited neighbors
			while ((vertex2 = getAdjUnvisitedVertex(vertex1)) != -1)
			{                                  								// Get one,
				vertexList[vertex2].wasVisited = true;  					// Mark it
				displayVertex(vertex2);                 					// Display it
				theQueue.insert(vertex2);               					// Insert it
			}   
		}  
																			// Queue is empty, so we're done
		for (int j = 0; j < nVerts; j++)             						// Reset flags
		{
			vertexList[j].wasVisited = false;								// No vertices have been visited 
		}
	} 
// ------------------- End Breadth-First Search Method -------------------
	
// ------------------- Minimal Spanning Tree: Depth-First Search Method -------------------
	// Method that uses the Depth-First Search Minimal Spanning Tree algorithm to search a graph (Uses Stack)
	public void MST_DFS()
	{                                  										// Begin at vertex 0
		vertexList[0].wasVisited = true;   									// Mark it
		theStack.push(0);                  									// Push it
		 
		while (!theStack.isEmpty())       									// Until Stack empty
		{                               									// Get stack top
			int currentVertex = theStack.peek();
																			// Get next unvisited neighbor
			int vertex = getAdjUnvisitedVertex(currentVertex);
			if (vertex == -1)                     							// If no more neighbors
			{
				theStack.pop();             	 							// Pop it away
			}
			else                            								// Got a neighbor
			{
				vertexList[vertex].wasVisited = true;  						// Mark it
				theStack.push(vertex);                 						// Push it
																			// Display edge
				displayVertex(currentVertex);     							// From current vertex 
				displayVertex(vertex);                 						// To vertex
				System.out.print(" ");
			}
		}  
																			// Stack is empty, so we're done
		for (int j = 0; j < nVerts; j++)         							// Reset flags
		{
			vertexList[j].wasVisited = false;								// No vertices are visited 
		}
	}  
// ------------------- End Minimal Spanning Tree: Depth-First Search Method -------------------
	
// ------------------- Minimal Spanning Tree: Breadth-First Search Method -------------------
	// Method that uses the Breadth-First Search Minimal Spanning Tree (Primms Algorithm) to search a graph (Uses Queue)
	public void MST_BFS()
	{																		// Begin at vertex 0
		vertexList[0].wasVisited = true;   									// Mark it
		theQueue.insert(0);                  								// Insert it
		int queueIndex = 0;
		
		while (!theQueue.isEmpty())       									// Until Queue empty
		{                               									// Get current vertex from Queue front
			int currentVertex = queueIndex;														
			int vertex = getAdjUnvisitedVertex(currentVertex);				// Get next unvisited neighbor
			if (vertex == -1)												// If no more neighbors
			{
				theQueue.remove();              							// Remove from the front of the Queue
				queueIndex++;
			}
			else                            								// Got a neighbor
			{
				vertexList[vertex].wasVisited = true;  						// Mark it
				theQueue.insert(vertex);                 					// Insert it
																			// Display edge
				displayVertex(currentVertex);     							// From current vertex
				displayVertex(vertex);                 						// To vertex
				System.out.print(" ");
			}
		}  
																			// Queue is empty, so we're done
		for (int j = 0; j < nVerts; j++)          							// Reset flags
		{	
			vertexList[j].wasVisited = false;								// No vertices are visited 
		}
	}
// ------------------- End Minimal Spanning Tree: Breadth-First Search Method -------------------
	
// ------------------- Get Adjacent Unvisited Vertex Method -------------------
	// Method that returns an unvisited vertex adjacent to vertex
	public int getAdjUnvisitedVertex(int vertex)
	{
		for (int j = 0; j < nVerts; j++)									// Iterate through each vertex
		{
			if (adjMat[vertex][j] == 1 && vertexList[j].wasVisited == false) // If vertex has not been visited 
			{
				return j;													// Return vertex 
			}
		}
		return -1;															// No unvisited vertices 
	}  
// ------------------- End Get Adjacent Unvisited Vertex Method -------------------
} // End of class Graph

