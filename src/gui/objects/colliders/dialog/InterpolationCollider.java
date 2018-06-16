package gui.objects.colliders.dialog;

import java.util.ArrayList;
import java.util.Collections;

import dialog.DialogCreator;
import gui.objects.Rectangle;
import gui.objects.colliders.Collider;
import gui.objects.colliders.SpeechCollider;
import wildWest.Searches;

public class InterpolationCollider extends SpeechCollider {

	/**
	 * pre: none
	 * post: action is performed
	 */
	public InterpolationCollider(Rectangle rectangle) {
		super(rectangle);
		// TODO Auto-generated constructor stub
	}
	/**
	 * pre: onCollision
	 * post: action is overridden
	 */
	@Override
	public void onCollision(Collider collision, Collisions direction) {
		do {
			int n; //basic int used for testing
			ArrayList<Integer> num = new ArrayList<Integer>(); //declares the array list to search
			
			for(n=0; n < 10; n++)
				num.add((int)(Math.random() * 100)); //generates 500 random numbers within the scope
			
			
			Integer[] ints = num.toArray(new Integer[num.size()]);
			int i = DialogCreator.createDialog("Interpolation Searcher","Pick a number, well tell you where in the array it is",null,"Exit","" + ints[0],"" + ints[1],"" + ints[2],"" + ints[3],"" + ints[4],"" + ints[5],"" + ints[6],"" + ints[7],"" + ints[8],"" + ints[9]);
			if(i == -1 || i == 0) {
				break;
			}
			Collections.sort(num);
				try {
					 DialogCreator.createDialog("Interpolation Searcher","Number found in position: " + Searches.interpolationSearch(num.toArray(new Integer[num.size()]), 0, ints.length, ints[i-1]),null,"Ok");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
		}while(true);
	}	
}
