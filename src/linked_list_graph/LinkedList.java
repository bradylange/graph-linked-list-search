package linked_list_graph;

/*
 * Developer: Brady Lange
 * Course: Data Structures & Algorithms - CSIS 237
 * Class: LinkedList
 * Language: Java
 * Date: 5/2/18
 * Description: This class contains Linked List data structure attributes and algorithms to link together vertices (links).
 */

// This class contains Linked List attributes
public class LinkedList
{
	// Instance variables
	private Link first;            												// Reference to first link in list
	private Link current;														// Reference to current link in list
// ------------------- Default Constructor -------------------
	// Default Constructor
	public LinkedList()              									
	{
		first = null;              												// No links on list yet
	}
// ------------------- End Default Constructor -------------------
	
// ------------------- Is Empty Method -------------------
	// Method that returns if the list is empty 
	public boolean isEmpty()       											
	{
		return (first == null);													// Return if the list is empty 				
	}
// ------------------- End Is Empty Method -------------------
	
// ------------------- Insert After Method -------------------
	public void insertAfter(int start, int end)
	{                           // make new link
		Link newLink = new Link(start, end);
		
		if (isEmpty() == true)													// If the list is empty initialize the first link in the list
		{
			first = newLink;													// First link equals the new link
			current = first;													// Current link is now the first link
		}
		else																	// If the list has links, place the links after the first link
		{
			current.next = newLink;												// Next link equals the new link
			current = current.next;												// Current link is now the newly inserted link
		}
		 
	}
// ------------------- End Insert After Method -------------------

// ------------------- Delete First Method -------------------
	public Link deleteFirst()      
	{                          
		if (isEmpty())															// First check whether the list is empty
		{
			return null;
		}
		else																	// List not empty 
		{
			Link temp = first;          										// Save reference to link
			first = first.next;         										// Delete it: first --> old next
			return temp;                										// Return deleted link
		}
	}
// ------------------- End Delete After Method -------------------
	
// ------------------- Delete Method -------------------
	// Method that deletes a link with a key by searching for it 
	public Link delete(int key)   
	{                          
		if (isEmpty())															// First check whether the list is empty
		{
			return null;
		}
		else																	// List not empty
		{
			Link current = first;             	 								// Keep track of current link					
			Link previous = first;												// Keep track of previous link
			while(current.start != key)											// Search for link						
			{
				if (current.next == null)										// Didn't find the link
				{
					return null;                								// Return nothing
				}
				else															// Keep searching for link
				{	
					previous = current;          								// Go to next link
					current = current.next;										// Set new current link
				}
			}                               									// Found it
			if (current == first)               								// If first link,
			{
				first = first.next;             								// Change first
			}
			else                               									// Otherwise,
			{
				previous.next = current.next;   								// Bypass it
			}
			return current;														// Return removed link
		}
	}
// ------------------- End Delete Method -------------------
	
// ------------------- Find Method -------------------
	// Method that searches for a link with a given key
	public Link find(int key)      
	{                           
		if(isEmpty())															// First check whether the list is empty
		{
			return null;
		}
		else																	// List is not empty
		{
			Link current = first;              									// Start at 'first' link
			while (current.start != key)        								// While no match,
			{
				if (current.next == null)        								// If end of list,
				{
					return null;                 								// Didn't find it
				}
				else                            								// Not end of list,
				{
					current = current.next;      								// Go to next link
				}
			}
			return current;                    									// Found it
		}
	}
// ------------------- End Find Method -------------------
	
// ------------------- Display List Method -------------------
	// Method that displays the lists contents
	public void displayList()      
	{
		System.out.print("List (First --> Last): ");
		Link current = first;       											// Start at beginning of list
		while (current != null)      											// Until end of list,
		{
			current.displayLink();   											// Print data
			current = current.next;  											// Move to next link
		}
		System.out.println("");
	}
// ------------------- End Display Method -------------------
} // End of class LinkedList
