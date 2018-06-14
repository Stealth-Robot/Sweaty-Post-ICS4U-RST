package wildWest;

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

import backend.battle.BattleAI;
import backend.battle.BattleCharacter;
import backend.player.Player;
import javafx.stage.WindowEvent;

import java.awt.Color;
import java.awt.Image;

public class WildWest implements ActionListener 
{
	JFrame frame;
	JPanel contentPane;
	private JTextArea log;
	private JButton shoot, reload, dodge;
	private JLabel enemySprite, pAmmo, eAmmo;

	private BattleCharacter player, enemy;

	private final int AMMOSIZE = 100;
	private final int ENEMYRATIO = 5;
	boolean win;
	boolean loss;

	public WildWest() 
	{
		win = false;
		loss = false;
		frame = new JFrame("Wild Wild West");

		contentPane = new JPanel();

		player = new BattleCharacter(6);
		enemy = new BattleCharacter(6);

		shoot = new JButton("Shoot");
		shoot.setActionCommand("shoot");
		shoot.addActionListener(this);
		reload = new JButton("Reload");
		reload.setActionCommand("reload");
		reload.addActionListener(this);
		dodge = new JButton("Dodge");
		dodge.setActionCommand("dodge");
		dodge.addActionListener(this);

		contentPane.setBorder(BorderFactory.createEmptyBorder(30, 30, 0, 30));
		contentPane.setBackground(Color.white);

		enemySprite = new JLabel();
		enemySprite.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("../images/sprites/Player.png")).getImage().getScaledInstance((new ImageIcon(getClass().getResource("../images/sprites/Player.png")).getIconWidth() * ENEMYRATIO), new ImageIcon(getClass().getResource("../images/sprites/Player.png")).getIconHeight() * ENEMYRATIO, Image.SCALE_DEFAULT)));
		eAmmo = new JLabel();
		eAmmo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("../images/sprites/wildWest/AmmoEmpty.png")).getImage().getScaledInstance(AMMOSIZE, AMMOSIZE, Image.SCALE_DEFAULT)));
		pAmmo = new JLabel();
		pAmmo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("../images/sprites/wildWest/AmmoEmpty.png")).getImage().getScaledInstance(AMMOSIZE, AMMOSIZE, Image.SCALE_DEFAULT)));


		GroupLayout layout = new GroupLayout(contentPane);
		contentPane.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(eAmmo)
						.addComponent(enemySprite))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(pAmmo)
						.addComponent(shoot)
						.addComponent(reload)
						.addComponent(dodge))
				);

		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(eAmmo)
						.addComponent(pAmmo))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(shoot))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(reload))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(enemySprite)
						.addComponent(dodge))
				);

		frame.setContentPane(contentPane); // Adds the content pane to the frame
		frame.pack(); // Sizes and displays the frame
		frame.setVisible(true); //lets the program know that the frame is visible as opposed to invisible

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		int action = BattleAI.choice(player,enemy);
		System.out.println("AI: " + action);
		enemy.actions(action);
		String command = event.getActionCommand();
		boolean turn = false;
		if (command.equals("shoot")) {
			player.actions(1);
			turn = true;
		}
		if (command.equals("reload")) {
			player.actions(2);
			turn = true;
		}
		if (command.equals("dodge")) {
			player.actions(3);
			turn = true;
		}
		
		if (turn) {
			
			win = player.tick(enemy);
			loss = enemy.tick(player);
			player.resetTurn();
			enemy.resetTurn();	
			replaceImage();
		if (loss || win) {
			shoot.setEnabled(false);
			dodge.setEnabled(false);
			if (win) {
				shoot.setText("You Win");
				dodge.setText("You Win");
				reload.setText("Continue");
				reload.setActionCommand("Continue");
			} 
			if (loss) {
				shoot.setText("You Lose");
				dodge.setText("You Lose");
				reload.setText("Continue");
				reload.setActionCommand("Continue");
			} 
		}
	}
		if (command.equals("Continue")) {
			frame.dispose();
		}
	}

	private static void runGUI() //actually runs the GUI
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		WildWest play = new WildWest();
	}

	private void replaceImage() {
		if (player.bullets == 0)		pAmmo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("../images/sprites/wildWest/AmmoEmpty.png")).getImage().getScaledInstance(AMMOSIZE, AMMOSIZE, Image.SCALE_DEFAULT)));
		else if (player.bullets == 1) 	pAmmo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("../images/sprites/wildWest/AmmoOne.png")).getImage().getScaledInstance(AMMOSIZE, AMMOSIZE, Image.SCALE_DEFAULT)));
		else if (player.bullets == 2) 	pAmmo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("../images/sprites/wildWest/AmmoTwo.png")).getImage().getScaledInstance(AMMOSIZE, AMMOSIZE, Image.SCALE_DEFAULT)));
		else if (player.bullets == 3) 	pAmmo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("../images/sprites/wildWest/AmmoThree.png")).getImage().getScaledInstance(AMMOSIZE, AMMOSIZE, Image.SCALE_DEFAULT)));
		else if (player.bullets == 4) 	pAmmo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("../images/sprites/wildWest/AmmoFour.png")).getImage().getScaledInstance(AMMOSIZE, AMMOSIZE, Image.SCALE_DEFAULT)));
		else if (player.bullets == 5) 	pAmmo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("../images/sprites/wildWest/AmmoFive.png")).getImage().getScaledInstance(AMMOSIZE, AMMOSIZE, Image.SCALE_DEFAULT)));
		else 							pAmmo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("../images/sprites/wildWest/AmmoSix.png")).getImage().getScaledInstance(AMMOSIZE, AMMOSIZE, Image.SCALE_DEFAULT)));
		if (enemy.bullets == 0)			eAmmo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("../images/sprites/wildWest/AmmoEmpty.png")).getImage().getScaledInstance(AMMOSIZE, AMMOSIZE, Image.SCALE_DEFAULT)));
		else if (enemy.bullets == 1) 	eAmmo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("../images/sprites/wildWest/AmmoOne.png")).getImage().getScaledInstance(AMMOSIZE, AMMOSIZE, Image.SCALE_DEFAULT)));
		else if (enemy.bullets == 2) 	eAmmo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("../images/sprites/wildWest/AmmoTwo.png")).getImage().getScaledInstance(AMMOSIZE, AMMOSIZE, Image.SCALE_DEFAULT)));
		else if (enemy.bullets == 3) 	eAmmo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("../images/sprites/wildWest/AmmoThree.png")).getImage().getScaledInstance(AMMOSIZE, AMMOSIZE, Image.SCALE_DEFAULT)));
		else if (enemy.bullets == 4) 	eAmmo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("../images/sprites/wildWest/AmmoFour.png")).getImage().getScaledInstance(AMMOSIZE, AMMOSIZE, Image.SCALE_DEFAULT)));
		else if (enemy.bullets == 5) 	eAmmo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("../images/sprites/wildWest/AmmoFive.png")).getImage().getScaledInstance(AMMOSIZE, AMMOSIZE, Image.SCALE_DEFAULT)));
		else 							eAmmo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("../images/sprites/wildWest/AmmoSix.png")).getImage().getScaledInstance(AMMOSIZE, AMMOSIZE, Image.SCALE_DEFAULT)));
	
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
}