package mst_graph;

/*
 * Developer: Brady Lange
 * Course: Data Structures & Algorithms - CSIS 237
 * Class: Vertex
 * Language: Java
 * Date: 5/2/18
 * Description: This class contains Vertex of a Graph features.
 */

// This class contains Vertex of a graph features
public class Vertex
{
	// Instance variables
	public char label;        												// Vertex label/ID (e.g. 'A')
	public boolean wasVisited;												// If the vertex was visited in search algorithms
// ------------------- Alternate Constructor -------------------
	// Default Constructor
	public Vertex(char lab)   
	{
		label = lab;														// Vertex ID 
		wasVisited = false;													// Default visit state is false
	}
// ------------------- End Alternate Constructor -------------------
} // End of class Vertex