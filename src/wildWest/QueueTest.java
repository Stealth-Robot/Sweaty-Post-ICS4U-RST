/*
 * Queue2.java
 * tests the code that sorts ints 
 * Marcus Kubilius
 * ICS4U
 * 5/16/2018
 */
package wildWest;
import java.util.*;

public class QueueTest 
{
	public QueueTest()
	{
		final int MAX_ITEMS = 3; 
		Queue q = new Queue(MAX_ITEMS); 
		Scanner input = new Scanner(System.in);
		String choice; 
		int num; 
		do
		{
			System.out.print("Add/Remove/Count/Front/Quit (Use \'a\',\'r\',\'c\',\'f\',\'q\',): "); 
			choice = input.next(); 
			if(choice.equalsIgnoreCase("a")) 
			{
				if(q.size() < MAX_ITEMS) 
				{ 
					System.out.print("Number to add: "); 
					num = input.nextInt(); 
					q.enqueue(num); 
				}
				else 
				{ 
					System.out.println("Queue is full"); 
				}
			}
			else if(choice.equalsIgnoreCase("r")&&q.size()>0) 
			{ 
				System.out.println("Dequeueing:" + q.dequeue());
			}
			else if(choice.equalsIgnoreCase("c")) 
			{ 
				System.out.println("Items in queue:"+q.size());
			}
			else if(choice.equalsIgnoreCase("f")&&q.size()>0) 
			{	 
				System.out.println("Front of queue:"+q.front());
			}
			else 
			{ 
				System.out.println("...");
			}
		}
		while(!choice.equalsIgnoreCase("q"));
	}
}
