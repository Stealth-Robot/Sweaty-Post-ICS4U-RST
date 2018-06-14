/*
 * Queue3.java
 * sorts ints 
 * Marcus Kubilius
 * ICS4U
 * 5/16/2018
 */
package wildWest;

public class Queue 
{
	private int[] data; 
	private int front, rear, maxSize; 

	/** 
	* constructor 
	* pre: none 
	* post: An empty queue that can hold up to maxItems 
	* has been created. 
	*/ 

	public Queue(int maxItems) 
	{
	data = new int[maxItems];
	front = -1; 	//no items in the array 
	rear = -1; 
	maxSize = maxItems;
		} 

	/** 
	* Returns the front item without removing it from 
	* the queue. 
	* pre: Queue contains at least one item. 
	* post: The front item has been returned while leaving 
	* it in the queue. 
	*/

	public int front() 
	{
	return(data[front]);
		}

	/**
	* Removes the front item from the queue and returns it. 
	* pre: Queue contains at least one item. 
	* post: The front item of the queue has been removed 
	* and returned. 
	*/

	public int dequeue() 
	{
	int num; 
	num = data[front]; 	//get front item
	//if dequeueing last item then make empty
	if (front == rear) 
	{ 
	makeEmpty(); 
	}
	else 
	{ 
	// move pointer to next item 
	front = (front + 1) % maxSize; 
	}
	return(num);
		}

		/**
		* Adds an item to the queue if there is room. 
	* pre: none 
	* post: A new item has been added to the queue. 
	*/ 
	public void enqueue(int num) 
	{
	if (isEmpty()) 
	{		//first item queued 
	rear = 0; 
	front = 0; 
	data[rear] = num; 
	}

	else 
	{ 
	rear = (rear + 1) % maxSize; 
	data[rear] = num;
			}
		}
	 
	/** 
	* Determines if there are items on the queue. 
	* pre: none 
	* post: true returned if there are items on the queue, 
	* false returned otherwise. 
	*/ 
	public boolean isEmpty() 
	{ 
	if (front == -1 && rear == -1)
	{ 
	return(true);
			}
	else 
	{ 
	return(false);
			}
		}
	 
	/** 
	* Returns the number of items in the queue. 
	* pre: none 
	* post: The number of items in the queue is returned. 
	*/ 
	public int size() 
	{ 
	if (isEmpty()) 
	{ 
	return(0); 
			}
			else 
			{ 	//front item is “in front” of rear item 
	if (rear > front) 
	{ 
	return(rear - front + 1);
	}
	else if (front == rear + 1)
	{
	 	//queue is full 
	return(maxSize); 
					}
					else 
					{ 	//front item is “behind” rear item 
	return(front - rear + 1);
				}
			}
		}
	 





	/** 
	* Empties the queue. 
	* pre: none 
	* post: There are no items in the queue. 
	*/ 
	public void makeEmpty()
	{
	front = -1; 
	rear = -1;
		}
	}
