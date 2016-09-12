package blackjack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.*;
import javax.swing.SwingConstants;

public class Bjack {

	private JFrame frame;
	private JPanel panelMain;
	private JPanel panelRules;
	private JPanel panelMGame;
	/**
	 * @wbp.nonvisual location=63,14
	 */
	private final JLabel label = DefaultComponentFactory.getInstance().createTitle("New JGoodies title");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		
		
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Bjack window = new Bjack();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Bjack() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame("Exile Blackjack Game");
		frame.setBounds(100, 100, 746, 612);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		//These are each of the Panels/Screens the user sees 
		final JPanel panelMain = new JPanel();
		panelMain.setVisible(true);
		panelMain.setBackground(new Color(128, 128, 0));
		panelMain.setBounds(0, 0, 728, 565);
		frame.getContentPane().add(panelMain, "name_1146644301577275");
		panelMain.setLayout(null);
		
		
		final JPanel panelRules = new JPanel();
		panelRules.setVisible(false);
		panelRules.setBackground(new Color(51, 255, 153));
		panelRules.setBounds(0, 0, 728, 565);
		frame.getContentPane().add(panelRules, "name_1146644310170993");
		panelRules.setLayout(null);
		
		JButton rulebtn = new JButton("Done");
		rulebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				panelRules.setVisible(false);
				panelMain.setVisible(true);
			}
		});
		rulebtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		rulebtn.setBounds(291, 447, 148, 48);
		panelRules.add(rulebtn);
		
		JLabel rule1 = new JLabel("PLAYER MAY \"DOUBLE DOWN\" ON VALUES EQUAL TO 9, 10, AND 11");
		rule1.setHorizontalAlignment(SwingConstants.CENTER);
		rule1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		rule1.setBounds(31, 54, 657, 48);
		panelRules.add(rule1);
		
		JLabel rule2 = new JLabel("PLAYER MAY \"ACE\" ANYTHING");
		rule2.setHorizontalAlignment(SwingConstants.CENTER);
		rule2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		rule2.setBounds(31, 115, 657, 48);
		panelRules.add(rule2);
		
		JLabel rule3 = new JLabel("PLAYER CAN DOUBLE DOWN OR SPLIT AGAIN AFTER A SPLIT");
		rule3.setHorizontalAlignment(SwingConstants.CENTER);
		rule3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		rule3.setBounds(31, 178, 657, 48);
		panelRules.add(rule3);
		
		JLabel rule4 = new JLabel("THE DEALER MAY HIT A SOFT 17");
		rule4.setHorizontalAlignment(SwingConstants.CENTER);
		rule4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		rule4.setBounds(31, 239, 657, 48);
		panelRules.add(rule4);
		
		JLabel rule5 = new JLabel("THIS BLACKJACK GAME PAYS ON A 3:2 BASIS");
		rule5.setHorizontalAlignment(SwingConstants.CENTER);
		rule5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		rule5.setBounds(31, 300, 657, 48);
		panelRules.add(rule5);
		
		JLabel rule6 = new JLabel("HAVE FUN AND LEARN (IT'S MANDATORY)!");
		rule6.setHorizontalAlignment(SwingConstants.CENTER);
		rule6.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		rule6.setBounds(31, 361, 657, 48);
		panelRules.add(rule6);
		
		
		final JPanel panelMGame = new JPanel();
		panelMGame.setBounds(0, 0, 10, 10);
		frame.getContentPane().add(panelMGame, "name_1146644319014889");
		panelMGame.setLayout(null);
		
		JButton btnPlayBlackjack = new JButton("PLAY BLACKJACK");
		btnPlayBlackjack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.setVisible(false);
				Gamepage gpage = new Gamepage();
				gpage.setVisible(true);
			}
		});
		btnPlayBlackjack.setBounds(58, 424, 220, 49);
		btnPlayBlackjack.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		panelMain.add(btnPlayBlackjack);
		
		JButton btnBlackjackRules = new JButton("BLACKJACK RULES");
		btnBlackjackRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				panelMain.setVisible(false);
				panelRules.setVisible(true);
			}
		});
		btnBlackjackRules.setBounds(444, 424, 220, 49);
		btnBlackjackRules.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		panelMain.setVisible(false);
		panelRules.setVisible(true);
		panelMain.add(btnBlackjackRules);
		
		JLabel lblBigLogo = new JLabel("");
		lblBigLogo.setBounds(58, 41, 618, 317);
		Image img1 = new ImageIcon(this.getClass().getResource("/blackjack_logo.png")).getImage();
		lblBigLogo.setIcon(new ImageIcon(img1));
		panelMain.add(lblBigLogo);
		
		JLabel exileLogo = new JLabel("");
		exileLogo.setBounds(256, 371, 188, 181);
		Image img3 = new ImageIcon(this.getClass().getResource("/resizedlogo.png")).getImage();
		exileLogo.setIcon(new ImageIcon(img3));
		panelMain.add(exileLogo);
		
		JLabel lblNewLabel = new JLabel("Java Software Application Designed Brought to you by Exile Inc. Software & Development");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 14));
		lblNewLabel.setBounds(12, 530, 704, 22);
		panelMain.add(lblNewLabel);
		
		
		Image img = new ImageIcon(this.getClass().getResource("/logosm.png")).getImage();
		Image img2 = new ImageIcon(this.getClass().getResource("/logosm1.png")).getImage();
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
		//gpage.dispose();
		
		frame.setVisible(true);
		
	}
}
