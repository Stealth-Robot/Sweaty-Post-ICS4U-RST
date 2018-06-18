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
	public static int interpolationSearch(Integer[] items, int start, int end, int goal) throws Exception 
	{
		//System.out.println("aa" + goal);
		//if(goal > items[end-1] || goal < items[start]) {
				//	error();
				//}
				//System.out.println("\nSTART: " + start + ", END: " + end);
				if (start > end) {
					return (-1);
				} else {
					
					double proportional = ((double)goal - items[start]) / ((double)items[end - 1] -items[start]);
					if(proportional < 0 || proportional > 1) {
						//System.out.println("Looks like ur numbah doesnt exist :(");
						return -1;
					}
					int mid = (int) Math.round(((end - 1) - start) * proportional);
					//System.out.println("PROPORTIONAL: " + proportional);
					//System.out.println("GUESS: Element " + (mid + start) + ", value " + items[mid + start] + ", looking for " + goal);
					if (goal == items[start + mid]) {
						return (start + mid);
					} else if (goal < items[start + mid]) {
						return (interpolationSearch(items, start, start + mid, goal));
					} else {
						return (interpolationSearch(items, start + mid + 1, end, goal));
					}
				}
	}
}