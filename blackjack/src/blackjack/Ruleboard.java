package blackjack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ruleboard {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ruleboard window = new Ruleboard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ruleboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 760, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panelRules = new JPanel();
		frame.getContentPane().add(panelRules, "name_1166086854308790");
		panelRules.setLayout(null);
		
		JButton btnNewButton = new JButton("More Information");
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnNewButton.setBounds(12, 476, 177, 53);
		panelRules.add(btnNewButton);
		
		JButton btnCloseHelp = new JButton("Close Help");
		btnCloseHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
			}
		});
		btnCloseHelp.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnCloseHelp.setBounds(563, 476, 167, 53);
		panelRules.add(btnCloseHelp);
		
		JLabel lblicon = new JLabel("");
		lblicon.setHorizontalAlignment(SwingConstants.CENTER);
		lblicon.setBounds(12, 13, 137, 64);
		Image img1 = new ImageIcon(this.getClass().getResource("/Blackjack-icon.png")).getImage();
		lblicon.setIcon(new ImageIcon(img1));
		panelRules.add(lblicon);
		
		JLabel lblicon2 = new JLabel("");
		lblicon2.setHorizontalAlignment(SwingConstants.CENTER);
		lblicon2.setBounds(605, 13, 137, 64);
		Image img2 = new ImageIcon(this.getClass().getResource("/Blackjack-icon.png")).getImage();
		lblicon2.setIcon(new ImageIcon(img2));
		panelRules.add(lblicon2);
		
		JLabel lblBlacklogo = new JLabel("");
		lblBlacklogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBlacklogo.setBounds(262, 13, 226, 64);
		Image img3 = new ImageIcon(this.getClass().getResource("/bjacksmall.png")).getImage();
		lblBlacklogo.setIcon(new ImageIcon(img3));
		panelRules.add(lblBlacklogo);
		
		JLabel label = new JLabel("PLAYER MAY \"DOUBLE DOWN\" ON VALUES EQUAL TO 9, 10, AND 11");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		label.setBounds(46, 108, 657, 48);
		panelRules.add(label);
		
		JLabel label_1 = new JLabel("PLAYER MAY \"ACE\" ANYTHING");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		label_1.setBounds(46, 169, 657, 48);
		panelRules.add(label_1);
		
		JLabel label_2 = new JLabel("PLAYER CAN DOUBLE DOWN OR SPLIT AGAIN AFTER A SPLIT");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		label_2.setBounds(46, 232, 657, 48);
		panelRules.add(label_2);
		
		JLabel label_3 = new JLabel("THE DEALER MAY HIT A SOFT 17");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		label_3.setBounds(46, 293, 657, 48);
		panelRules.add(label_3);
		
		JLabel label_4 = new JLabel("THIS BLACKJACK GAME PAYS ON A 3:2 BASIS");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		label_4.setBounds(46, 354, 657, 48);
		panelRules.add(label_4);
		
		JLabel label_5 = new JLabel("HAVE FUN AND LEARN (IT'S MANDATORY)!");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		label_5.setBounds(46, 415, 657, 48);
		panelRules.add(label_5);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, "name_1166090418281205");
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, "name_1166092464697545");
	}

}
