package wildWest;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import backend.battle.BattleCharacter;

import java.awt.Color;

public class WildWest implements ActionListener 
{
	JFrame frame;
	JPanel contentPane;
	JTextArea log;
	JButton shoot, reload, protect;
	JLabel enemySprite, pAmmo, eAmmo;
	
	BattleCharacter player, enemy;

	public WildWest() 
	{
		frame = new JFrame("Wild Wild West");

		contentPane = new JPanel();

		GroupLayout layout = new GroupLayout(contentPane);
		
		player = new BattleCharacter(6);
		enemy = new BattleCharacter(6);
		
		
		shoot = new JButton("Shoot");
		shoot.setActionCommand("shoot");
		reload = new JButton("Reload");
		reload.setActionCommand("reload");
		protect = new JButton("Protect");
		protect.setActionCommand("protect");
		
		
		contentPane.setLayout(layout);
		contentPane.setBorder(BorderFactory.createEmptyBorder(30, 30, 0, 30));
		contentPane.setBackground(Color.white);

		enemySprite = new JLabel();
		enemySprite.setIcon(new ImageIcon(getClass().getResource("../images/sprites/Player.png")));
		eAmmo = new JLabel();
		eAmmo.setIcon(new ImageIcon(getClass().getResource("../images/sprites/wildWest/AmmoEmpty.png")));
		pAmmo = new JLabel();
		pAmmo.setIcon(new ImageIcon(getClass().getResource("../images/sprites/wildWest/AmmoEmpty.png")));

		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(eAmmo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(enemySprite, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
					.addComponent(pAmmo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(shoot, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addComponent(reload, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addComponent(protect, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		layout.setVerticalGroup(layout.createSequentialGroup()
			    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			        .addComponent(eAmmo).addComponent(enemySprite)
			     .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			        .addComponent(pAmmo).addComponent(shoot)).addComponent(reload)).addComponent(protect));
		
		
		frame.setContentPane(contentPane); // Adds the content pane to the frame
		frame.pack(); // Sizes and displays the frame
		frame.setVisible(true); //lets the program know that the frame is visible as opposed to invisible
	}

	/**
	 * When a button click occurs
	 * pre: none 
	 * post: A die has been rolled and an image is shown |or| the game was reset |or| numbers were chosen
	 */
	public void actionPerformed(ActionEvent event) 
	{
		
	}

	private static void runGUI() //actually runs the GUI
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		WildWest play = new WildWest();
	}

	public static void main(String[] args) // Methods that create and show a GUI should be run from an event-dispatching thread
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() 
			{
				runGUI();
			}
		});
	}

	public void gameReset() //resets the game variables for a new game
	{
	}
}