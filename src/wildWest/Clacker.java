/* 
* Clacker.java 
* application that plays a dice game. 
* Marcus Kubilius & Matthew Edwards
* ICS4UR 
* 4/19/2018 
*/ 
package wildWest;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.objects.Minigame;

import java.awt.Color;

public class Clacker implements ActionListener, Minigame
{
	JFrame frame;
	JPanel contentPane;
	JButton rollDie;
	JButton gameReset;		//initializes  variables required to run the GUI box
	JLabel dieFace;
	JLabel dieFace2;
	JLabel countRolls;
	JButton[] numSelected = new JButton[12];
	
	int die1Value;
	int die2Value;
	int diceValue;		//initializes variables for the buttons and prepares for roll values
	int numRolls;
	int rolls;	
	boolean playerHasWon;

	public Clacker() 
	{
		
	}

	private static void runGUI() //actually runs the GUI
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		Clacker play = new Clacker();
	}


	public void gameReset() //resets the game variables for a new game
	{
		die1Value = 0;
		die2Value = 0;
		diceValue = 0;
		numRolls = 0;
		playerHasWon = false;
		rolls = 0;
	}

	@Override
	public void start() {
		frame = new JFrame("Clacker");
	//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Create and set up the frame

		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(0, 4, 10, 5));
		contentPane.setBorder(BorderFactory.createEmptyBorder(30, 30, 0, 30));// Create a white content pane using grid layout
		contentPane.setBackground(Color.white);

		rollDie = new JButton("Roll Die");
		rollDie.setAlignmentX(JButton.CENTER_ALIGNMENT); //Initializes a Roll button to roll the die
		rollDie.setActionCommand("Roll Die");
		rollDie.addActionListener(this);
		contentPane.add(rollDie);
		dieFace = new JLabel(new ImageIcon(getClass().getResource("../images/minigames/die1.gif")));
		dieFace.setAlignmentX(JLabel.LEFT_ALIGNMENT); 
		dieFace.setBorder(BorderFactory.createEmptyBorder(15, 5, 5, 5));
		contentPane.add(dieFace);	//Initializes 2 labels that each show a die face
		dieFace2 = new JLabel(new ImageIcon(getClass().getResource("../images/minigames/die1.gif")));
		dieFace2.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
		dieFace2.setBorder(BorderFactory.createEmptyBorder(15, 5, 5, 5));
		contentPane.add(dieFace2);

		gameReset = new JButton("Reset Game");
		gameReset.setAlignmentX(JButton.CENTER_ALIGNMENT); //Initializes a reset game button
		gameReset.setActionCommand("Reset Game");
		gameReset.addActionListener(this);
		contentPane.add(gameReset);

		for (int n = 0; n < 12; n++) //sets up number selection
		{
			numSelected[n] = new JButton("" + (n + 1));
			numSelected[n].setAlignmentX(JButton.CENTER_ALIGNMENT);
			numSelected[n].setActionCommand("" + (n + 1));
			numSelected[n].addActionListener(this);
			contentPane.add(numSelected[n]);
		}

		countRolls = new JLabel("Rolls: 0"); // after each game sets rolls to zero so it dosen't say "null
		contentPane.add(countRolls);		//roll count setup

		frame.setContentPane(contentPane); // Adds the content pane to the frame
		frame.pack(); // Sizes and displays the frame
		frame.setVisible(true); //lets the program know that the frame is visible as opposed to invisible

		gameReset(); //calls the gamereset method
	}
	
	/**
	 * When a button click occurs
	 * pre: none 
	 * post: A die has been rolled and an image is shown |or| the game was reset |or| numbers were chosen
	 */
	public void actionPerformed(ActionEvent event) 
	{
		String eventName = event.getActionCommand(); //gets which button the action was initiated by
		if (eventName.equals("Roll Die")) 
		{
			rolls++;
			int newRoll;

			newRoll = (int) (6 * Math.random() + 1);
	        switch (newRoll)  //switches are used to set the dice face values based on a random number (1-6)
	        {
	            case 1:  
						dieFace.setIcon(new ImageIcon(getClass().getResource("../images/minigames/die1.gif")));
						die1Value = 1;
						break;
	            case 2:
					dieFace.setIcon(new ImageIcon(getClass().getResource("../images/minigames/die2.gif")));
					die1Value = 2;
					break;
	            case 3:
					dieFace.setIcon(new ImageIcon(getClass().getResource("../images/minigames/die3.gif")));
					die1Value = 3;
					break;
	            case 4:
					dieFace.setIcon(new ImageIcon(getClass().getResource("../images/minigames/die4.gif")));
					die1Value = 4;
					break;
	            case 5:
					dieFace.setIcon(new ImageIcon(getClass().getResource("../images/minigames/die5.gif")));
					die1Value = 5;
					break;
	            default:
					dieFace.setIcon(new ImageIcon(getClass().getResource("../images/minigames/die6.gif")));
					die1Value = 6;
					break;
	        }
			newRoll = (int) (6 * Math.random() + 1);
	        switch (newRoll) //switches are used to set the dice face values based on a random number (1-6)
	        {
	            case 1:  
						dieFace2.setIcon(new ImageIcon(getClass().getResource("../images/minigames/die1.gif")));
						die2Value = 1;
						break;
	            case 2:
					dieFace2.setIcon(new ImageIcon(getClass().getResource("../images/minigames/die2.gif")));
					die2Value = 2;
					break;
	            case 3:
					dieFace2.setIcon(new ImageIcon(getClass().getResource("../images/minigames/die3.gif")));
					die2Value = 3;
					break;
	            case 4:
					dieFace2.setIcon(new ImageIcon(getClass().getResource("../images/minigames/die4.gif")));
					die2Value = 4;
					break;
	            case 5:
					dieFace2.setIcon(new ImageIcon(getClass().getResource("../images/minigames/die5.gif")));
					die2Value = 5;
					break;
	            default:
					dieFace2.setIcon(new ImageIcon(getClass().getResource("../images/minigames/die6.gif")));
					die2Value = 6;
					break;
	        }
			numRolls++;
			diceValue = die1Value + die2Value;	//gets the total combined values of the rolls in case the user wants to select that button instead of roll 1 and 2 seperatly
			countRolls.setText("Rolls: " + numRolls); // counts up the rolls and displays the number of rolls
		}
		else if (eventName.equals("Reset Game")) 
		{
			gameReset();
			dieFace.setIcon(new ImageIcon(getClass().getResource("../images/minigames/die1.gif"))); //sets the die back to value of 1
			dieFace2.setIcon(new ImageIcon(getClass().getResource("../images/minigames/die1.gif"))); 
			countRolls.setText("Rolls: 0"); //sets roll count to 0 (not null) upon reset

			for (int n = 0; n < 12; n++) //sets the background and buttons
			{
				numSelected[n].setEnabled(true);
				numSelected[n].setBackground(rollDie.getBackground());
			}

		}
		else 
		{
			if (eventName.equals(String.valueOf(die1Value)) || eventName.equals(String.valueOf(die2Value)) || eventName.equals(String.valueOf(diceValue))) 
			{ //very simply: if the buttons selected are valid when choosing the numbers to gray out
				numSelected[Integer.parseInt(eventName) - 1].setEnabled(false);
				numSelected[Integer.parseInt(eventName) - 1].setBackground(Color.gray);
				if (eventName.equals(String.valueOf(die1Value))||eventName.equals(String.valueOf(die2Value))) diceValue = 0;
				//the above if statement is so the user can't use both the total and both individual dice values
				if (eventName.equals(String.valueOf(diceValue))) 
				{
					die1Value = 0;
					die2Value = 0;//sets the values to 0 so they can't be used over again
				}
			}
		}
		playerHasWon = !numSelected[0].isEnabled();
		for (int n = 0; n < 12; n++)//for each number check if it is valid
		{
			if (playerHasWon) playerHasWon = !numSelected[n].isEnabled();
		}

		if (playerHasWon) 
		{ //if the player has won display the win text
			rollDie.setText("WINNER!");
			rollDie.setEnabled(false);//switches out the roll button with the text (a suggestion from grayden)
		}
		else 
		{
			rollDie.setText("Roll Die");//otherwise the roll button stays the same as normal
			rollDie.setEnabled(true);
		}
	}
}