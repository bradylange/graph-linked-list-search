package linked_list_graph;

/*
 * Developer: Brady Lange
 * Course: Data Structures & Algorithms - CSIS 237
 * Class: Stack
 * Language: Java
 * Date: 5/2/18
 * Description: This class contains the data structure Stack features for use within the graph.
 */

// This class contains Stack features
public class Stack
{
	// Instance variables
	private final int SIZE = 20;									// Max size of the Stack
	private int [] stackArray;										// Stack
	private int top;												// Top of the Stack
// ------------------- Default Constructor -------------------
	// Default Constructor
	public Stack()          
	{
		stackArray = new int[SIZE];    								// Instantiate Stack
		top = -1;													// Set top of the stack as the last item pushed
	}
// ------------------- End Default Constructor -------------------
	
// ------------------- Push Method -------------------
	// Method that pushes item onto Stack
	public void push(int item)   
	{ 
		stackArray[++top] = item; 									// Insert item into the Stack
	}
// ------------------- End Push Method -------------------
	
// ------------------- Pop Method -------------------
	// Method that removes item from Stack
	public int pop()          
	{ 
		return stackArray[top--]; 									// Remove item from the Stack
	}
// ------------------- End Pop Method -------------------
	
// ------------------- Peek Method -------------------
	// Method that peeks the top of the Stack
	public int peek()       
	{ 
		return stackArray[top]; 									// Look at item at the top of the Stack
	}
// ------------------- End Pop Method -------------------
	
// ------------------- Is Empty Method -------------------
	// Method that checks if the Stack is empty 
	public boolean isEmpty()  
	{ 
		return (top == -1); 										// Return if the Stack is empty 
	}
// ------------------- End Is Empty Method -------------------
} // End of class Stack






