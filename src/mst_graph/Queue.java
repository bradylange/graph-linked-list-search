package mst_graph;

/*
 * Developer: Brady Lange
 * Course: Data Structures & Algorithms - CSIS 237
 * Class: Queue
 * Language: Java
 * Date: 5/2/18
 * Description: This class contains the data structure Queue features for use within the graph.
 */

// This class contains Queue features
public class Queue
{
	// Instance variables
	private final int SIZE = 20;												// Max size of the Queue
	private int [] queueArray;													// Queue
	private int front;															// Front of the Queue
	private int rear;															// End of the Queue
// ------------------- Default Constructor -------------------
	// Default Constructor
	public Queue()            
	{
		queueArray = new int[SIZE];												// Instantiate the Queue
		front = 0;																// Set front to the first index
		rear = -1;																// Set rear to the last index
	}
// ------------------- End Default Constructor -------------------
		
// ------------------- Insert Method -------------------
	// Method that inserts item at end of Queue
	public void insert(int item) 
	{
		if (rear == SIZE - 1)													// Wrap Queue around if full
		{
			rear = -1;
		}
		queueArray[++rear] = item;												// Insert item 
	}
// ------------------- End Insert Method -------------------
		
// ------------------- Remove Method -------------------
	// Method that removes item from front of Queue
	public int remove()     
	{
		int temp = queueArray[front++];	
		if (front == SIZE)														// Wrap Queue around if full 
		{
			front = 0;
		}
		return temp;															// Remove item 
	}
// ------------------- End Remove Method -------------------
	
// ------------------- Is Empty Method -------------------
	// Method that checks if the Queue is empty
	public boolean isEmpty()  
	{
		return (rear + 1 == front || (front + SIZE - 1 == rear));			// Return if the Queue is empty or not
	}
// ------------------- End Is Empty Method -------------------
}  // End of class Queue