package gui.objects.colliders.dialog;

import java.util.Stack;

import gui.objects.Rectangle;
import gui.objects.colliders.SpeechCollider;

public class CardsGameCollider extends SpeechCollider {

	public CardsGameCollider(Rectangle rectangle) {
		super(rectangle);
		// TODO Auto-generated constructor stub
	}

	public void playCards() {
		 // Creating a Stack
        Stack<String> stackOfCards = new Stack<>();

        // Pushing new items to the Stack
        stackOfCards.push("Jack");
        stackOfCards.push("Queen");
        stackOfCards.push("King");
        stackOfCards.push("Ace");

        System.out.println("Stack => " + stackOfCards);
        System.out.println();

        // Popping items from the Stack
        String cardAtTop = stackOfCards.pop();  // Throws EmptyStackException if the stack is empty
        System.out.println("Stack.pop() => " + cardAtTop);
        System.out.println("Current Stack => " + stackOfCards);
        System.out.println();

        // Get the item at the top of the stack without removing it
        cardAtTop = stackOfCards.peek();
        System.out.println("Stack.peek() => " + cardAtTop);
        System.out.println("Current Stack => " + stackOfCards);

	}
}
