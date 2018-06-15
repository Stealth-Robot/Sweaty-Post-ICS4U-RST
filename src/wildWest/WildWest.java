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

import java.awt.Color;
import java.awt.Image;

public class WildWest implements ActionListener, Cloneable
{
	JFrame frame;
	JPanel contentPane;
	private JTextArea log;
	private JButton shoot, reload, dodge;
	private JLabel enemySprite, pAmmo, eAmmo;
	private LogQueue logText;

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

		log = new JTextArea();
		logText = new LogQueue(5);
				logText.enqueue("1");
				logText.enqueue("2");
				logText.enqueue("3");
				logText.enqueue("4");
				logText.enqueue("5");
				logText.enqueue("6");

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
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE))
				.addComponent(log)
				
				);

		layout.setHorizontalGroup(layout.createSequentialGroup()
						.addComponent(log)
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

		updateLog();

		frame.setContentPane(contentPane); // Adds the content pane to the frame
		frame.pack(); // Sizes and displays the frame
		frame.setVisible(true); //lets the program know that the frame is visible as opposed to invisible

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		int action = BattleAI.choice(player,enemy);
		if (action == 1) logText.enqueue("The enemy has shoot at you");
		if (action == 2) logText.enqueue("The enemy has reloaded their gun");
		if (action == 3) logText.enqueue("The enemy has attempted to dodge");
		enemy.actions(action);
		String command = event.getActionCommand();
		boolean turn = false;
		if (command.equals("shoot")) {
			player.actions(1);
			logText.enqueue("You have shot at the enemy");
			turn = true;
		}
		if (command.equals("reload")) {
			logText.enqueue("You have reloaded your gun");
			player.actions(2);
			turn = true;
		}
		if (command.equals("dodge")) {
			logText.enqueue("You get in cover to avoid enemy fire");
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
					logText.enqueue("The enemy gotten shot and died");
					shoot.setText("You Win");
					dodge.setText("You Win");
					reload.setText("Continue");
					reload.setActionCommand("Continue");
				} 
				if (loss) {
					logText.enqueue("The enemy has shot you and you died");
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
		updateLog();
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

	private void updateLog() {
		String logString = "";
		LogQueue tempQueue = new LogQueue(5);
		tempQueue = logText;
		for (int i = 0; i < 5; i++) {
			try {
				logString += tempQueue.dequeue() + "\n";
			} catch (Exception e) {}
			log.setText(logString);
		}
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