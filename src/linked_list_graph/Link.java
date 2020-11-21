package linked_list_graph;

/*
 * Developer: Brady Lange
 * Course: Data Structures & Algorithms - CSIS 237
 * Class: Link
 * Language: Java
 * Date: 5/2/18
 * Description: This class contains Link attributes which will be used as connecting vertices together.
 */

// This class contains Link attributes 
public class Link 
{
	// Instance variables
	int start;															// Start of edge on vertex
	int end;															// End of edge on vertex
	Link next;															// Next Link
// ------------------- Alternate Constructor -------------------
	// Alternate Constructor
	public Link(int start, int end) 
	{
		this.start = start; 											// Initialize start vertex
		this.end = end;													// Initialize end vertex
	}                          
// ------------------- End Alternate Constructor -------------------
	
// ------------------- Display Link Method -------------------
	// Method that displays the link
	public void displayLink()      
	{
		System.out.print("[ " + start + " , " + end + " ]");			// Print the link data
	}
// ------------------- End Display Link Method -------------------
} // End of class Link
