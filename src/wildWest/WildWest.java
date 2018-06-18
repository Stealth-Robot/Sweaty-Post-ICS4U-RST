/*
 * WildWest.java
 * runs the game of wild west
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package wildWest;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import PresentationClasses.Villain;
import backend.battle.BattleAI;
import backend.battle.BattleCharacter;
import dialog.DialogCreator;
import gui.scenes.locations.SceneMaster;
import main.Main;

public class WildWest implements ActionListener, Cloneable
{
	JFrame frame;
	JPanel contentPane;
	private JLabel eAmmo,enemySprite,logIntro;
	private javax.swing.JScrollPane jScrollPane1,jScrollPane2;
	private JTextArea jTextArea1,log;
	private JLabel pAmmo;
	private JButton reload,shoot,dodge;
	private LogQueue logText;
	private Villain cVil;

	private BattleCharacter player, enemy;

	private final int AMMOSIZE = 125;
	private final int ENEMYRATIO = 5;
	boolean win,loss;

	public WildWest(Villain villain) 
	{
		villain.ready = false;
		Main.paused = true;
		setCVil(villain);
		win = false;
		loss = false;
		player = new BattleCharacter(6);
		enemy = new BattleCharacter(6);
		logText = new LogQueue(100);

		frame = new JFrame("Wild Wild West");	
		contentPane = new JPanel();	
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane2 = new javax.swing.JScrollPane();

		jTextArea1 = new JTextArea();
		log = new JTextArea();

		eAmmo = new JLabel();
		pAmmo = new JLabel();
		enemySprite = new JLabel();
		logIntro = new JLabel();

		dodge = new JButton();
		reload = new JButton();
		shoot = new JButton();
		jScrollPane1.setViewportView(jTextArea1);
		System.out.println("../images/sprites/enemies/" + villain.path + ".png");
		URL enemySpriteU = getClass().getResource("../images/sprites/enemies/" + villain.path + ".png");
		enemySprite.setIcon(new ImageIcon(new ImageIcon(enemySpriteU).getImage().getScaledInstance((new ImageIcon(enemySpriteU).getIconWidth()) * ENEMYRATIO, (new ImageIcon(enemySpriteU).getIconHeight()) * ENEMYRATIO, Image.SCALE_DEFAULT)));
		eAmmo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("../images/sprites/wildWest/AmmoEmpty.png")).getImage().getScaledInstance(AMMOSIZE, AMMOSIZE, Image.SCALE_DEFAULT)));
		pAmmo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("../images/sprites/wildWest/AmmoEmpty.png")).getImage().getScaledInstance(AMMOSIZE, AMMOSIZE, Image.SCALE_DEFAULT)));

		dodge.setText(Main.game.player.say("Dodge"));
		dodge.addActionListener(this);
		dodge.setActionCommand("dodge");
		reload.setText(Main.game.player.say("Reload"));
		reload.addActionListener(this);
		reload.setActionCommand("reload");
		shoot.setText(Main.game.player.say("Shoot"));
		shoot.addActionListener(this);
		shoot.setActionCommand("shoot");

		frame.setResizable(false);

		log.setColumns(20);
		log.setRows(10);
		log.setEditable(false);
		log.setText(Main.game.player.say("This is the log"));
		logIntro.setText(Main.game.player.say("Log:"));
		jScrollPane1.setViewportView(log);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(contentPane);
        contentPane.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(eAmmo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(enemySprite))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logIntro)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pAmmo)
                                .addGap(60, 60, 60)
                                .addComponent(shoot, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(reload, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(dodge, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addGap(43, 43, 43))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eAmmo)
                    .addComponent(enemySprite))
                .addGap(200, 200, 200)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pAmmo)
                    .addComponent(reload, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shoot, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dodge, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(logIntro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
		updateLog();

		frame.setContentPane(contentPane); // Adds the content pane to the frame
		frame.pack(); // Sizes and displays the frame
		frame.setVisible(true); //lets the program know that the frame is visible as opposed to invisible
		logText.enqueue(Main.game.player.say(cVil.name + " has arived riding " + cVil.horseName));
		logText.enqueue(Main.game.player.say(cVil.name + " plans to drink some delicous " + cVil.whiskeyPreference + " after they kill you"));
		logText.enqueue(Main.game.player.say(""));
		updateLog();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		int action = BattleAI.choice(player,enemy);
		if (action == 1) logText.enqueue(Main.game.player.say(cVil.name + " has shot at you"));
		if (action == 2) logText.enqueue(Main.game.player.say(cVil.name + " has reloaded their gun"));
		if (action == 3) logText.enqueue(Main.game.player.say(cVil.name + " has attempted to dodge"));
		enemy.actions(action);
		String command = event.getActionCommand();
		boolean turn = false;
		if (command.equals("shoot")) {
			player.actions(1);
			logText.enqueue(Main.game.player.say("You have shot at "+ cVil.name));
			turn = true;
		}
		if (command.equals("reload")) {
			logText.enqueue(Main.game.player.say("You have reloaded your gun"));
			updateLog();
			player.actions(2);
			turn = true;
		}
		if (command.equals("dodge")) {
			logText.enqueue(Main.game.player.say("You get in cover to avoid enemy fire"));
			updateLog();
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
				Main.paused = false;
				if (win) {
					logText.enqueue(Main.game.player.say(cVil.name + " has died to your well aimed shot. You have gained his " + cVil.damselNum + " damsels!"));
					Main.game.player.damsels += cVil.damselNum;
					cVil.damselNum = 0;
					shoot.setText(Main.game.player.say("You Win"));
					dodge.setText(Main.game.player.say("You Win"));
					reload.setText(Main.game.player.say("Continue"));
					reload.setActionCommand("Continue");
				} 
				if (loss) {
					logText.enqueue(Main.game.player.say(cVil.name + " shot you and you have died. He has taken your " + Main.game.player.damsels + " damsels."));
					shoot.setText(Main.game.player.say("You Lose"));
					dodge.setText(Main.game.player.say("You Lose"));
					reload.setText(Main.game.player.say("Continue"));
					reload.setActionCommand("Continue");
					cVil.damselNum += Main.game.player.damsels;
					Main.game.player.damsels = 0;
					SceneMaster.hotelIScene.initialize();
					
				} 
			}
		}
		if (command.equals("Continue")) {
			frame.dispose();
			if(loss) {
				DialogCreator.createDialog("Hotel Bro","You died dude... We brought u to the hotel so u could live again :) \n(the person that killed you ran away...)",null,"Wait what I didnt die then");
			}
		}
		updateLog();
	}

	private static void runGUI() //actually runs the GUI
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		WildWest play = new WildWest(Main.Slimy);
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
		LogQueue tempQueue = new LogQueue(logText);
		for (int i = 0; i < logText.maxSize; i++) {
			try {
				logString += tempQueue.dequeue() + "\n";
			} catch (Exception e) {}
			log.setText(logString);
		}
	}

	/*public static void main(String[] args) // Methods that create and show a GUI should be run from an event-dispatching thread
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() 
			{
				runGUI();
			}
		});
	}*/

	public Villain getCVill() {
		return cVil;
	}

	public void setCVil(Villain cVil) {
		this.cVil = cVil;
	}
}