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

import backend.battle.BattleCharacter;

import java.awt.Color;
import java.awt.Image;

public class WildWest implements ActionListener 
{
	JFrame frame;
	JPanel contentPane;
	private JTextArea log;
	private JButton shoot, reload, protect;
	private JLabel enemySprite, pAmmo, eAmmo;

	private BattleCharacter player, enemy;

	private final int AMMOSIZE = 100;
	private final int E = 3;
	
	public WildWest() 
	{
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
		protect = new JButton("Protect");
		protect.setActionCommand("protect");
		protect.addActionListener(this);

		contentPane.setBorder(BorderFactory.createEmptyBorder(30, 30, 0, 30));
		contentPane.setBackground(Color.white);

		enemySprite = new JLabel();
		enemySprite.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("../images/sprites/Player.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
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
						.addComponent(protect))
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
						.addComponent(protect))
				);
		
		frame.setContentPane(contentPane); // Adds the content pane to the frame
		frame.pack(); // Sizes and displays the frame
		frame.setVisible(true); //lets the program know that the frame is visible as opposed to invisible
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		 String command = event.getActionCommand();
		 if (command.equals("shoot")) {
		 }
		 if (command.equals("reload")) {
		 }
		 if (command.equals("protect")) {
		 }
		 

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
}