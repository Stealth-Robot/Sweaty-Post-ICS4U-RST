/*
 * InterpolationSearch.java
 * the interpolation search class for regulating binary smart-search
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package wildWest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class InterpolationSearch 
{
	public InterpolationSearch()
	{
		try 
		{
			int n; //basic int used for testing
			ArrayList<Integer> num = new ArrayList<Integer>(); //declares the array list to search
			
			for(n=0; n < 500; n++)
				num.add((int)(Math.random() * 10000)); //generates 500 random numbers within the scope
			
			Collections.sort(num); //sorts the numbers for easy array searching use
			Integer[] ints = num.toArray(new Integer[num.size()]); 
			
			for (n=0; n < ints.length; n++) 
			{
				System.out.print(ints[n] + ", "); //prints the array list on the console
				if(n % 20 == 0 && n != 0) 
				{
					System.out.println(""); //ends each line
				}
			}
			while(true) //repeats until the break is hit
			{
				System.out.println("\nWhat number do you want to search for? (Anything else to Exit)");
				Integer number = null; //unassigned number so as to not interfere with any math preemptively
				while (true)
				{
					try 
					{
						number = new Scanner(System.in).nextInt(); //attempts to assign number (if not valid the catch is triggered)
						break;
					}
					catch(Exception e)
					{
						System.out.println("Hope you enjoyed your searching");
						break; //if the user dosen't enter a valid number (ex. letters) the application will close
					}
				}
				System.out.println("Number found in position " + Searches.interpolationSearch(ints, 0, ints.length, number));
			}
		} 
		catch(Exception e) //this catch shuldnt be triggered but you can never have too many fallbacks when coding
		{
			System.out.print("If you need help with basic key input please speak with our support saff (Marcus)");
		}
	}
}
