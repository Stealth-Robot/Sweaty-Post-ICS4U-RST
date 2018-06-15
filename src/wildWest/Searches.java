/*
 * InterpolationSearch.java
 * the interpolation search class for regulating binary smart-search
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package wildWest;

public class Searches 
{
	/**
	 * Does a binary interpolation search of an int array, 
	 * estimates approximate location of any given int in the array
	 */
	public static int interpolationSearch(Integer[] actualNums, int arrayStart, int arrayEnd, int targetNum) throws Exception 
	{
		if (arrayStart < arrayEnd)
		{
		/*sets up my special math variables for manipulating and priming the search*/
			double start = (double)targetNum - actualNums[arrayStart];
			double end = (double)actualNums[arrayEnd - 1];
			double actual = actualNums[arrayStart];
			int arrayMid = (int) Math.round(((arrayEnd - 1) - arrayStart) * (start) / (end - actual));
			
			if((start)/(end - actual) < 0 || (start)/(end - actual) > 1) //checks if number exists in the array and exits if necessary
			{
				System.out.println("That number does not exist within the scope of this search:");
				return -1;
			}
			System.out.println("Estimated Location of Element " + targetNum + " is at Position " + (arrayMid + arrayStart));
			 
			if (targetNum == actualNums[arrayStart + arrayMid]) //if it is in the middle of the array
				return (arrayStart + arrayMid);
			else if (targetNum < actualNums[arrayStart + arrayMid])  //if it is in the first section of the array
				return (interpolationSearch(actualNums, arrayStart, arrayStart + arrayMid, targetNum));
			else //if it is in the end section of the array
				return (interpolationSearch(actualNums, arrayStart + arrayMid + 1, arrayEnd, targetNum));
		}
		return (-1); //returns -1 (invalid number code) if the array start isn't smaller than its end (math error)
	}
}