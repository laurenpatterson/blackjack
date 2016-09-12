package blackjack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;
import java.awt.Dialog;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.IOException;


public class Gamepage extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		//int yesValue = showConfirmDialog(null, "Press Yes Button");
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gamepage frame = new Gamepage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	char[][] card1 = new char[29][10];

	public void strat_card()
	{
		File file = new File("card.txt");
		
		
	}
	
	
	
	
	//Shuffle method for making the deck of cards array random
	public static void shuffle(Object[] array)
	{
		int noOfElements = array.length;
		
		for(int i = 0; i < noOfElements; i++)
		{
			int s = i + (int)(Math.random() * (noOfElements - i));
			
			Object temp = array[s];
			array[s] = array[i];
			array[i] = temp;
		}
	}
	
	
	/**********************This method checks if the player or dealer's hand is Blackjack 21***********/
	public boolean hasBlackjack()
	{
		b = false;
		
		if (ace_valueCp == 1 || ace_valueDp == 1 || ace_valueHp == 1 || ace_valueSp == 1)
		{
			if (p_total == 21)
			{
				b = true;
			}
			else
			{
				b = false;
			}
		}
		else if (aceyC == 1 || aceyD == 1 || aceyH == 1 || aceyS == 1)
		{
			if (d_total == 21)
			{
				b = true;
			}
			else
			{
				b = false;
			}
		}
		else
		{
			b = false;
		}
		
		return b;
	}
	/*********************************************************************************************/
	boolean b;
	int acey;
	int acey2;
	int aceyC = 0;
	int aceyD = 0;
	int aceyH = 0;
	int aceyS = 0;
	int aceyC2 = 0;
	int aceyD2 = 0;
	int aceyH2 = 0;
	int aceyS2 = 0;
	int pacey;
	int pacey2;
	int card;
	int shuffletracker = 0;
	int cardsused_counter = 0;
	int p_value1;
	int p_value2;
	int p_value3;
	int p_value4;
	int d_value1;
	int d_value2;
	int d_value3;
	int d_value4;
	int ace_valueCp;
	int ace_valueDp;
	int ace_valueHp;
	int ace_valueSp;
	int choice;
	int p_total = 0;
	int d_total;
	int bet = 0;
	int firstDeal = 0;
	int dealNumber = 0;
	int options = 1;
	int balance = 5000; //Starts player out with 5000 dollars
	int canyoubet;
	int subbet = 0;
	boolean d_switch = false;
	int lost_the_game = 0;
	int d_bust = 0;
	int p_bust = 0;
	int hit_num = 0;
	int total = 0;
	
	/**
	 * Create the frame.
	 */
	
	public Gamepage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1001, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelGame = new JPanel();
		panelGame.setBackground(new Color(60, 179, 113));
		panelGame.setBounds(0, 0, 983, 853);
		contentPane.add(panelGame);
		panelGame.setLayout(null);
		
		Image n0 = new ImageIcon(this.getClass().getResource("/nzero.png")).getImage();
		Image n1 = new ImageIcon(this.getClass().getResource("/none.png")).getImage();
		Image n2 = new ImageIcon(this.getClass().getResource("/ntwo.png")).getImage();
		Image n3 = new ImageIcon(this.getClass().getResource("/nthree.png")).getImage();
		Image n4 = new ImageIcon(this.getClass().getResource("/nfour.png")).getImage();
		Image n5 = new ImageIcon(this.getClass().getResource("/nfive.png")).getImage();
		Image n6 = new ImageIcon(this.getClass().getResource("/nsix.png")).getImage();
		Image n7 = new ImageIcon(this.getClass().getResource("/nseven.png")).getImage();
		Image n8 = new ImageIcon(this.getClass().getResource("/neight.png")).getImage();
		Image n9 = new ImageIcon(this.getClass().getResource("/nnine.png")).getImage();
		Image n10 = new ImageIcon(this.getClass().getResource("/nten.png")).getImage();
		Image n11 = new ImageIcon(this.getClass().getResource("/neleven.png")).getImage();
		Image n12 = new ImageIcon(this.getClass().getResource("/ntwelve.png")).getImage();
		Image n13 = new ImageIcon(this.getClass().getResource("/nthirteen.png")).getImage();
		Image n14 = new ImageIcon(this.getClass().getResource("/nfourteen.png")).getImage();
		Image n15 = new ImageIcon(this.getClass().getResource("/nfifthteen.png")).getImage();
		Image n16 = new ImageIcon(this.getClass().getResource("/nsixteen.png")).getImage();
		Image n17 = new ImageIcon(this.getClass().getResource("/nseventeen.png")).getImage();
		Image n18 = new ImageIcon(this.getClass().getResource("/neightteen.png")).getImage();
		Image n19 = new ImageIcon(this.getClass().getResource("/nnineteen.png")).getImage();
		Image n20 = new ImageIcon(this.getClass().getResource("/ntwenty.png")).getImage();
		Image n21 = new ImageIcon(this.getClass().getResource("/ntwentyone.png")).getImage();
		Image n22 = new ImageIcon(this.getClass().getResource("/ntwentytwo.png")).getImage();
		Image n23 = new ImageIcon(this.getClass().getResource("/ntwentythree.png")).getImage();
		Image n24 = new ImageIcon(this.getClass().getResource("/ntwentyfour.png")).getImage();
		Image n25 = new ImageIcon(this.getClass().getResource("/ntwentyfive.png")).getImage();
		Image n26 = new ImageIcon(this.getClass().getResource("/ntwentysix.png")).getImage();
		Image n27 = new ImageIcon(this.getClass().getResource("/ntwentyseven.png")).getImage();
		Image n28 = new ImageIcon(this.getClass().getResource("/ntwentyeight.png")).getImage();
		Image n29 = new ImageIcon(this.getClass().getResource("/ntwentynine.png")).getImage();
		Image n30 = new ImageIcon(this.getClass().getResource("/nthirty.png")).getImage();
		Image n31 = new ImageIcon(this.getClass().getResource("/nthirtyone.png")).getImage();
		Image n32 = new ImageIcon(this.getClass().getResource("/nthirtytwo.png")).getImage();
		
		
		Image glow = new ImageIcon(this.getClass().getResource("/wglow.png")).getImage();
		Image scoreBlock = new ImageIcon(this.getClass().getResource("/scoreBlock.jpg")).getImage();
		JLabel scoreHide = new JLabel("");
		
		scoreHide.setHorizontalAlignment(SwingConstants.CENTER);
		scoreHide.setBounds(274, 119, 68, 64);
		panelGame.add(scoreHide);
		
		JLabel handValue = new JLabel();
		
		JLabel numberbox = new JLabel("");
		numberbox.setHorizontalAlignment(SwingConstants.CENTER);
		numberbox.setBounds(268, 109, 80, 80);
		numberbox.setIcon(new ImageIcon(n0));
		panelGame.add(numberbox);
		
		JLabel numberbox2 = new JLabel("");
		numberbox2.setHorizontalAlignment(SwingConstants.CENTER);
		numberbox2.setBounds(268, 338, 80, 80);
		numberbox2.setIcon(new ImageIcon(n0));
		panelGame.add(numberbox2);
		
		JButton chip5btn = new JButton("");
		JButton chip10btn = new JButton("");
		JButton chip25btn = new JButton("");
		JButton chip50btn = new JButton("");
		JButton chip100btn = new JButton("");
		JButton chip500btn = new JButton("");
		
		JLabel glowy5 = new JLabel("");
		JLabel glowy10 = new JLabel("");
		JLabel glowy25 = new JLabel("");
		JLabel glowy50 = new JLabel("");
		JLabel glowy100 = new JLabel("");
		JLabel glowy500 = new JLabel("");
		
		JLabel betlbl = new JLabel();
		JLabel balancelbl = new JLabel();
		
		//********************************************************************************************************/
		//************************52 Image objects that store each card's png file********************************/
		//********************************************************************************************************/
		//																										///
		//*************************************																	///
		//**LEGEND   - "c" = clubs			***																	///
		//**		 - "d" = diamonds		***																	///
		//**		 - "h" = hearts			***																	///
		//**		 - "s" = spades			***																	///
		//**Example  - "ac" = Ace of Clubs	***																	///
		//**		 - "c2" = Club of 2		***																	///
		//**		 - "cK" = King of Clubs ***																	///
		//**								***																	///
		//*************************************																	///
		//*************************************																	///
		//																										///
		Image ac = new ImageIcon(this.getClass().getResource("/aclub.png")).getImage();							///
		Image ad = new ImageIcon(this.getClass().getResource("/adiamond.png")).getImage();						///
		Image ah = new ImageIcon(this.getClass().getResource("/aheart.png")).getImage();						///
		Image as = new ImageIcon(this.getClass().getResource("/aspade.png")).getImage();						///
																												///
		Image c2 = new ImageIcon(this.getClass().getResource("/2club.png")).getImage();							///
		Image d2 = new ImageIcon(this.getClass().getResource("/2diamond.png")).getImage();						///
		Image h2 = new ImageIcon(this.getClass().getResource("/2heart.png")).getImage();						///
		Image s2 = new ImageIcon(this.getClass().getResource("/2spade.png")).getImage();						///
																												///
		Image c3 = new ImageIcon(this.getClass().getResource("/3club.png")).getImage();							///
		Image d3 = new ImageIcon(this.getClass().getResource("/3diamond.png")).getImage();						///
		Image h3 = new ImageIcon(this.getClass().getResource("/3heart.png")).getImage();						///
		Image s3 = new ImageIcon(this.getClass().getResource("/3spade.png")).getImage();						///
																												///
		Image c4 = new ImageIcon(this.getClass().getResource("/4club.png")).getImage();							///
		Image d4 = new ImageIcon(this.getClass().getResource("/4diamond.png")).getImage();						///
		Image h4 = new ImageIcon(this.getClass().getResource("/4heart.png")).getImage();						///
		Image s4 = new ImageIcon(this.getClass().getResource("/4spade.png")).getImage();						///
																												///
		Image c5 = new ImageIcon(this.getClass().getResource("/5club.png")).getImage();							///
		Image d5 = new ImageIcon(this.getClass().getResource("/5diamond.png")).getImage();						///
		Image h5 = new ImageIcon(this.getClass().getResource("/5heart.png")).getImage();						///
		Image s5 = new ImageIcon(this.getClass().getResource("/5spade.png")).getImage();						///
																												///
		Image c6 = new ImageIcon(this.getClass().getResource("/6club.png")).getImage();							///
		Image d6 = new ImageIcon(this.getClass().getResource("/6diamond.png")).getImage();						///
		Image h6 = new ImageIcon(this.getClass().getResource("/6heart.png")).getImage();						///
		Image s6 = new ImageIcon(this.getClass().getResource("/6spade.png")).getImage();						///
																												///
		Image c7 = new ImageIcon(this.getClass().getResource("/7club.png")).getImage();							///
		Image d7 = new ImageIcon(this.getClass().getResource("/7diamond.png")).getImage();						///
		Image h7 = new ImageIcon(this.getClass().getResource("/7heart.png")).getImage();						///
		Image s7 = new ImageIcon(this.getClass().getResource("/7spade.png")).getImage();						///
																												///
		Image c8 = new ImageIcon(this.getClass().getResource("/8club.png")).getImage();							///
		Image d8 = new ImageIcon(this.getClass().getResource("/8diamond.png")).getImage();						///
		Image h8 = new ImageIcon(this.getClass().getResource("/8heart.png")).getImage();						///
		Image s8 = new ImageIcon(this.getClass().getResource("/8spade.png")).getImage();						///
																												///
		Image c9 = new ImageIcon(this.getClass().getResource("/9club.png")).getImage();							///
		Image d9 = new ImageIcon(this.getClass().getResource("/9diamond.png")).getImage();						///
		Image h9 = new ImageIcon(this.getClass().getResource("/9heart.png")).getImage();						///
		Image s9 = new ImageIcon(this.getClass().getResource("/9spade.png")).getImage();						///
																												///
		Image c10 = new ImageIcon(this.getClass().getResource("/10club.png")).getImage();						///
		Image d10 = new ImageIcon(this.getClass().getResource("/10diamond.png")).getImage();					///
		Image h10 = new ImageIcon(this.getClass().getResource("/10heart.png")).getImage();						///
		Image s10 = new ImageIcon(this.getClass().getResource("/10spade.png")).getImage();						///
																												///
		Image cJ = new ImageIcon(this.getClass().getResource("/Jclub.png")).getImage();							///
		Image dJ = new ImageIcon(this.getClass().getResource("/Jdiamond.png")).getImage();						///
		Image hJ = new ImageIcon(this.getClass().getResource("/Jheart.png")).getImage();						///
		Image sJ = new ImageIcon(this.getClass().getResource("/Jspade.png")).getImage();						///
																												///
		Image cK = new ImageIcon(this.getClass().getResource("/Kclub.png")).getImage();							///
		Image dK = new ImageIcon(this.getClass().getResource("/Kdiamond.png")).getImage();						///
		Image hK = new ImageIcon(this.getClass().getResource("/Kheart.png")).getImage();						///
		Image sK = new ImageIcon(this.getClass().getResource("/Kspade.png")).getImage();						///
																												///
		Image cQ = new ImageIcon(this.getClass().getResource("/Qclub.png")).getImage();							///
		Image dQ = new ImageIcon(this.getClass().getResource("/Qdiamond.png")).getImage();						///
		Image hQ = new ImageIcon(this.getClass().getResource("/Qheart.png")).getImage();						///
		Image sQ = new ImageIcon(this.getClass().getResource("/Qspade.png")).getImage();						///
		Image bback = new ImageIcon(this.getClass().getResource("/bblack.jpg")).getImage();						///
		Image back = new ImageIcon(this.getClass().getResource("/back.png")).getImage();						///
		//																										///
		//********************************************************************************************************/
		//*************Think of these image objects as the virtual Deck of 52 cards*******************************/
		//********************************************************************************************************/		
				
		
		
		//********************************************************************************************************/
		//**************************Slot Frame Images for Dealer and Player Cards*********************************/
		//********************************************************************************************************/
		//Image Objects which hold the Empty Card Slot PNG File													///
		Image slotframe1 = new ImageIcon(this.getClass().getResource("/cardslot.png")).getImage();				///
		Image slotframe2 = new ImageIcon(this.getClass().getResource("/cardslot.png")).getImage();				///
		Image slotframe3 = new ImageIcon(this.getClass().getResource("/cardslot.png")).getImage();				///
		Image slotframe4 = new ImageIcon(this.getClass().getResource("/cardslot.png")).getImage();				///
		Image splitslot1 = new ImageIcon(this.getClass().getResource("/cardslot.png")).getImage();				///
		Image splitslot2 = new ImageIcon(this.getClass().getResource("/cardslot.png")).getImage();				///
				
				JLabel card4p2 = new JLabel("");
				card4p2.setBounds(551, 338, 105, 141);
				panelGame.add(card4p2);
																												///
																												///
		//JLabels which will hold the image objects to show the user on game screen								///
		//There are 4 card placement holder slots as shown on the application									///
				JLabel PlayerSlot2 = new JLabel("");															///
				PlayerSlot2.setBounds(524, 338, 107, 155);														///
				PlayerSlot2.setIcon(new ImageIcon(slotframe1));													///
				panelGame.add(PlayerSlot2);																		///
																												///
				JLabel lblDealerSlot2 = new JLabel("");															///
				lblDealerSlot2.setBounds(524, 109, 107, 155);													///
				lblDealerSlot2.setIcon(new ImageIcon(slotframe2));												///
				panelGame.add(lblDealerSlot2);																	///
																												///
				JLabel lblDealerSlot = new JLabel("");															///
				lblDealerSlot.setBounds(342, 109, 107, 155);													///
				lblDealerSlot.setIcon(new ImageIcon(slotframe3));												///
				panelGame.add(lblDealerSlot);																	///
				
				JLabel lblDealerSlot3 = new JLabel("");
				lblDealerSlot3.setBounds(696, 109, 107, 155);
				lblDealerSlot3.setIcon(new ImageIcon(slotframe1));
				panelGame.add(lblDealerSlot3);
				
				JLabel lblDealerSlot4 = new JLabel("");
				lblDealerSlot4.setBounds(838, 109, 107, 155);
				lblDealerSlot4.setIcon(new ImageIcon(slotframe1));
				panelGame.add(lblDealerSlot4);
				//**/
				//Player Card Slot2																		//**/
				JLabel cards4 = new JLabel("");															//**/
				cards4.setBounds(383, 338, 105, 141);													//**/
				cards4.setIcon(new ImageIcon());														//**/
				panelGame.add(cards4);
																												///
				JLabel PlayerSlot = new JLabel("");																///
				PlayerSlot.setBounds(342, 338, 107, 155);														///
				PlayerSlot.setIcon(new ImageIcon(slotframe4));													///
				panelGame.add(PlayerSlot);
				
				
				JLabel sSlot1 = new JLabel("");
				sSlot1.setBounds(696, 338, 107, 155);
				sSlot1.setIcon(new ImageIcon(splitslot1));
				panelGame.add(sSlot1);
				
				JLabel sSlot2 = new JLabel("");
				sSlot2.setBounds(838, 338, 107, 155);
				sSlot2.setIcon(new ImageIcon(splitslot2));
				panelGame.add(sSlot2);

																												///
		//********************************************************************************************************/
		//********************************************************************************************************/
		
		
		//**************************************************************************************************/
		//*********************Card Slot Spaces - Used to show different Card Images************************/
		//**************************************************************************************************/
				//Dealer Card Slot1																		//**/
				JLabel cards1 = new JLabel("");															//**/
				cards1.setBounds(342, 110, 105, 141);													//**/
				cards1.setIcon(new ImageIcon());														//**/
				panelGame.add(cards1);																	//**/
				
				JLabel cardBack = new JLabel("");
				cardBack.setBounds(524, 109, 105, 141);
				panelGame.add(cardBack);
																										//**/
				//Dealer Card Slot2																		//**/
				JLabel cards2 = new JLabel("");															//**/
				cards2.setBounds(524, 109, 105, 141);													//**/
				cards2.setIcon(new ImageIcon());														//**/
				panelGame.add(cards2);																	//**/
				
				//Dealer Card Slot3
				JLabel dSlot3 = new JLabel("");
				dSlot3.setBounds(696, 110, 105, 141);
				panelGame.add(dSlot3);
				
				//Dealer Card Slot4
				JLabel dSlot4 = new JLabel("");
				dSlot4.setBounds(838, 110, 105, 141);
				panelGame.add(dSlot4);
				
				
				
				
				//Player Card Slot1																		//**/
				JLabel cards3 = new JLabel("");															//**/
				cards3.setBounds(342, 338, 105, 141);													//**/
				cards3.setIcon(new ImageIcon());														//**/
				panelGame.add(cards3);																	//**/																	//**/	
				
				JLabel card3p1 = new JLabel("");
				card3p1.setBounds(524, 338, 105, 141);
				panelGame.add(card3p1);
				
																										//**/
		//**************************************************************************************************/
		//****************Card Slots Initially Shows an Empty space when game opens*************************/
		//**************************************************************************************************/
		
		
		String[] deck = {"ac", "ad", "ah", "as",    "c2", "d2", "h2", "s2",    "c3", "d3", "h3", "s3",
						 "c4", "d4", "h4", "s4",	"c5", "d5", "h5", "s5",	   "c6", "d6", "h6", "s6",
						 "c7", "d7", "h7", "s7", 	"c8", "d8", "h8", "s8",	   "c9", "d9", "h9", "s9",
						 "c10", "d10", "h10", "s10",  "cJ", "dJ", "hJ", "sJ",   "cQ", "dQ", "hQ", "sQ",
						 "cK", "dK", "hK", "sK"};
		
		JLabel bjacklogo = new JLabel("");
		bjacklogo.setBounds(0, 26, 140, 70);
		Image img1 = new ImageIcon(this.getClass().getResource("/bjacksmall.png")).getImage();
		
		
		
		JLabel split2cholder = new JLabel("");
		split2cholder.setIcon(new ImageIcon(bback));
		split2cholder.setBounds(698, 338, 105, 141);
		panelGame.add(split2cholder);
		
		JLabel split3cholder = new JLabel("");
		split3cholder.setIcon(new ImageIcon(bback));
		split3cholder.setBounds(838, 338, 105, 141);
		panelGame.add(split3cholder);
		
		
		bjacklogo.setIcon(new ImageIcon(img1));
		panelGame.add(bjacklogo);
				
		
		JLabel lblNewLabel = new JLabel("BLACKJACK GAME PAYS 3:2");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(151, 25, 685, 40);
		panelGame.add(lblNewLabel);
		
		JLabel lblDealerHitsSoft = new JLabel("DEALER HITS SOFT 17 (ACE COUNTED AS 11)");
		lblDealerHitsSoft.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblDealerHitsSoft.setHorizontalAlignment(SwingConstants.LEFT);
		lblDealerHitsSoft.setBounds(151, 56, 685, 40);
		panelGame.add(lblDealerHitsSoft);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(6, 109, 250, 48);
		panelGame.add(panel);
		panel.setLayout(null);
		
		JLabel lblDealer = new JLabel("DEALER");
		lblDealer.setBounds(0, 13, 244, 27);
		panel.add(lblDealer);
		lblDealer.setBackground(new Color(255, 255, 255));
		lblDealer.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblDealer.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_3.setBounds(6, 301, 250, 48);
		panelGame.add(panel_3);
		
		JLabel lblPlayer = new JLabel("PLAYER");
		lblPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblPlayer.setBackground(Color.WHITE);
		lblPlayer.setBounds(0, 13, 244, 27);
		panel_3.add(lblPlayer);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_4.setBounds(6, 349, 250, 40);
		panelGame.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblPlayerOptions = new JLabel("Player Options");
		lblPlayerOptions.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 14));
		lblPlayerOptions.setBounds(12, 13, 216, 26);
		panel_4.add(lblPlayerOptions);
		lblPlayerOptions.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		Image sp = new ImageIcon(this.getClass().getResource("/sp.png")).getImage();
		JButton btnSplit = new JButton("");
		btnSplit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnSplit.setIcon(new ImageIcon(sp));
		btnSplit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSplit.setBounds(6, 392, 250, 30);
		panelGame.add(btnSplit);
		
		Image sd = new ImageIcon(this.getClass().getResource("/sd.png")).getImage();
		JButton btnStand = new JButton("");
		//**********************************************************************************************************************************
		//**********************************************************************************************************************************
		//**********************************************************************************************************************************
		btnStand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if ( d_switch == true)
				{
					JOptionPane.showMessageDialog(frame, "You choose to STAND! Revealing Dealer Card.");
					
					scoreHide.setIcon(new ImageIcon());
					cardBack.setIcon(new ImageIcon());
					
					
					
					
					hasBlackjack();
					
					
					if (b == true)
					{

					
					if (d_total == 21 && p_total != 21)
					{
						JOptionPane.showMessageDialog(frame, "Dealer has BLACKJACK! You lost your bet.");
						
						balance -= bet;
						bet = 0;
						options = 1;
						d_switch = false;
						dealNumber = 0;
						betlbl.setText(String.valueOf(bet));
						balancelbl.setText(String.valueOf(balance));
						
						if (balance > 0)
						{
							JOptionPane.showMessageDialog(frame, "Place another bet and click DEAL to start a new phase!");
						}
						else
						{
							JOptionPane.showMessageDialog(frame, "You have no more Money!!! Sorry you lose, GAMEOVER!");
							lost_the_game =  1;
						}
					}
					else if (d_total == 21 && p_total == 21)
					{
						JOptionPane.showMessageDialog(frame, "TIE! Both you and the Dealer have BLACKJACK! Returning your bet.");
						
						bet = 0;
						options = 1;
						d_switch = false;
						dealNumber = 0;
						betlbl.setText(String.valueOf(bet));
						
						JOptionPane.showMessageDialog(frame, "Place another bet and click DEAL to start a new phase!");

					}
					else if (p_total == 21 && d_total != 21)
					{
						JOptionPane.showMessageDialog(frame, "You Got BLACKJACK! YOU WIN YOUR BET!");
						
						bet *= 1.5;
						balance += bet;
						bet = 0;
						options = 1;
						d_switch = false;
						dealNumber = 0;
						betlbl.setText(String.valueOf(bet));
						balancelbl.setText(String.valueOf(balance));
						
						JOptionPane.showMessageDialog(frame, "New Balance has been applied. Press DEAL after placing a new bet!");
					}
					else
					{
						
					}
					
					}
					else
					{
						if (d_total < 17)
						{
							
							if(card > 34)
							{
								shuffletracker = 0;
								
								JOptionPane.showMessageDialog(frame, "65% of the Cards has been used. Reshuffling Deck!");
								
								if(shuffletracker == 0)
								{
									shuffle(deck);
									card = 0;
									shuffletracker = 1;
								}
								
								card = 0;
								
								
								JOptionPane.showMessageDialog(frame, "Deck has been Reshuffled!  Continuing phase!");
							}	
								
							if(deck[card].equals("ac"))
							{
							dSlot3.setIcon(new ImageIcon(ac));
							card++;
							
							//ace variable tracker
							aceyC2 = 1;
							
							d_value3 = 11;
							}
							else if (deck[card].equals("ad"))
							{
								dSlot3.setIcon(new ImageIcon(ad));
								card++;
								
								aceyD2 = 1;
								d_value3 = 11;
							}
							else if (deck[card].equals("ah"))
							{
								dSlot3.setIcon(new ImageIcon(ah));
								card++;
								
								aceyH2 = 1;
								d_value3 = 11;
							}
							else if (deck[card].equals("as"))
							{
								dSlot3.setIcon(new ImageIcon(as));
								card++;
								
								aceyS2 = 1;
								d_value3 = 11;
							}
							else if (deck[card].equals("c2"))
							{
								dSlot3.setIcon(new ImageIcon(c2));
								card++;
								
								d_value3 = 2;
							}
							else if (deck[card].equals("d2"))
							{
								dSlot3.setIcon(new ImageIcon(d2));
								card++;
								
								d_value3 = 2;
							}
							else if (deck[card].equals("h2"))
							{
								dSlot3.setIcon(new ImageIcon(h2));
								card++;
								
								d_value3 = 2;
							}
							else if (deck[card].equals("s2"))
							{
								dSlot3.setIcon(new ImageIcon(s2));
								card++;
								
								d_value3 = 2;
							}
							else if (deck[card].equals("c3"))
							{
								dSlot3.setIcon(new ImageIcon(c3));
								card++;
								
								d_value3 = 3;
							}
							else if (deck[card].equals("d3"))
							{
								dSlot3.setIcon(new ImageIcon(d3));
								card++;
								
								d_value3 = 3;
							}
							else if (deck[card].equals("h3"))
							{
								dSlot3.setIcon(new ImageIcon(h3));
								card++;
								
								d_value3 = 3;
							}
							else if (deck[card].equals("s3"))
							{
								dSlot3.setIcon(new ImageIcon(s3));
								card++;
								
								d_value3 = 3;
							}
							else if (deck[card].equals("c4"))
							{
								dSlot3.setIcon(new ImageIcon(c4));
								card++;
								
								d_value3 = 4;
							}
							else if (deck[card].equals("d4"))
							{
								dSlot3.setIcon(new ImageIcon(d4));
								card++;
								
								d_value3 = 4;
							}
							else if (deck[card].equals("h4"))
							{
								dSlot3.setIcon(new ImageIcon(h4));
								card++;
								
								d_value3 = 4;
							}
							else if (deck[card].equals("s4"))
							{
								dSlot3.setIcon(new ImageIcon(s4));
								card++;
								
								d_value3 = 4;
							}
							else if (deck[card].equals("c5"))
							{
								dSlot3.setIcon(new ImageIcon(c5));
								card++;
								
								d_value3 = 5;
							}
							else if (deck[card].equals("d5"))
							{
								dSlot3.setIcon(new ImageIcon(d5));
								card++;
								
								d_value3 = 5;
							}
							else if (deck[card].equals("h5"))
							{
								dSlot3.setIcon(new ImageIcon(h5));
								card++;
								
								d_value3 = 5;
							}
							else if (deck[card].equals("s5"))
							{
								dSlot3.setIcon(new ImageIcon(s5));
								card++;
								
								d_value3 = 5;
							}
							else if (deck[card].equals("c6"))
							{
								dSlot3.setIcon(new ImageIcon(c6));
								card++;
								
								d_value3 = 6;
							}
							else if (deck[card].equals("d6"))
							{
								dSlot3.setIcon(new ImageIcon(d6));
								card++;
								
								d_value3 = 6;
							}
							else if (deck[card].equals("h6"))
							{
								dSlot3.setIcon(new ImageIcon(h6));
								card++;
								
								d_value3 = 6;
							}
							else if (deck[card].equals("s6"))
							{
								dSlot3.setIcon(new ImageIcon(s6));
								card++;
								
								d_value3 = 6;
							}
							else if (deck[card].equals("c7"))
							{
								dSlot3.setIcon(new ImageIcon(c7));
								card++;
								
								d_value3 = 7;
							}
							else if (deck[card].equals("d7"))
							{
								dSlot3.setIcon(new ImageIcon(d7));
								card++;
								
								d_value3 = 7;
							}
							else if (deck[card].equals("h7"))
							{
								dSlot3.setIcon(new ImageIcon(h7));
								card++;
								
								d_value3 = 7;
							}
							else if (deck[card].equals("s7"))
							{
								dSlot3.setIcon(new ImageIcon(s7));
								card++;
								
								d_value3 = 7;
							}
							else if (deck[card].equals("c8"))
							{
								dSlot3.setIcon(new ImageIcon(c8));
								card++;
								
								d_value3 = 8;
							}
							else if (deck[card].equals("d8"))
							{
								dSlot3.setIcon(new ImageIcon(d8));
								card++;
								
								d_value3 = 8;
							}
							else if (deck[card].equals("h8"))
							{
								dSlot3.setIcon(new ImageIcon(h8));
								card++;
								
								d_value3 = 8;
							}
							else if (deck[card].equals("s8"))
							{
								dSlot3.setIcon(new ImageIcon(s8));
								card++;
								
								d_value3 = 8;
							}
							else if (deck[card].equals("c9"))
							{
								dSlot3.setIcon(new ImageIcon(c9));
								card++;
								
								d_value3 = 9;
							}
							else if (deck[card].equals("d9"))
							{
								dSlot3.setIcon(new ImageIcon(d9));
								card++;
								
								d_value3 = 9;
							}
							else if (deck[card].equals("h9"))
							{
								dSlot3.setIcon(new ImageIcon(h9));
								card++;
								
								d_value3 = 9;
							}
							else if (deck[card].equals("s9"))
							{
								dSlot3.setIcon(new ImageIcon(s9));
								card++;
								
								d_value3 = 9;
							}
							else if (deck[card].equals("c10"))
							{
								dSlot3.setIcon(new ImageIcon(c10));
								card++;
								
								d_value3 = 10;
							}
							else if (deck[card].equals("d10"))
							{
								dSlot3.setIcon(new ImageIcon(d10));
								card++;
								
								d_value3 = 10;
							}
							else if (deck[card].equals("h10"))
							{
								dSlot3.setIcon(new ImageIcon(h10));
								card++;
								
								d_value3 = 10;
							}
							else if (deck[card].equals("s10"))
							{
								dSlot3.setIcon(new ImageIcon(s10));
								card++;
								
								d_value3 = 10;
							}
							else if (deck[card].equals("cJ"))
							{
								dSlot3.setIcon(new ImageIcon(cJ));
								card++;
								
								d_value3 = 10;
							}
							else if (deck[card].equals("dJ"))
							{
								dSlot3.setIcon(new ImageIcon(dJ));
								card++;
								
								d_value3 = 10;
							}
							else if (deck[card].equals("hJ"))
							{
								dSlot3.setIcon(new ImageIcon(hJ));
								card++;
								
								d_value3 = 10;
							}
							else if (deck[card].equals("sJ"))
							{
								dSlot3.setIcon(new ImageIcon(sJ));
								card++;
								
								d_value3 = 10;
							}
							else if (deck[card].equals("cQ"))
							{
								dSlot3.setIcon(new ImageIcon(cQ));
								card++;
								
								d_value3 = 10;
							}
							else if (deck[card].equals("dQ"))
							{
								dSlot3.setIcon(new ImageIcon(dQ));
								card++;
								
								d_value3 = 10;
							}
							else if (deck[card].equals("hQ"))
							{
								dSlot3.setIcon(new ImageIcon(hQ));
								card++;
								
								d_value3 = 10;
							}
							else if (deck[card].equals("sQ"))
							{
								dSlot3.setIcon(new ImageIcon(sQ));
								card++;
								
								d_value3 = 10;
							}
							else if (deck[card].equals("cK"))
							{
								dSlot3.setIcon(new ImageIcon(cK));
								card++;
								
								d_value3 = 10;
							}
							else if (deck[card].equals("dK"))
							{
								dSlot3.setIcon(new ImageIcon(dK));
								card++;
								
								d_value3 = 10;
							}
							else if (deck[card].equals("hK"))
							{
								dSlot3.setIcon(new ImageIcon(hK));
								card++;
								
								d_value3 = 10;
							}
							else if (deck[card].equals("sK"))
							{
								dSlot3.setIcon(new ImageIcon(sK));
								card++;
								
								d_value3 = 10;
							}
							else
							{
								dSlot3.setIcon(new ImageIcon());
								card++;
							}
							
							d_total += d_value3;
							
							if(d_total == 0)
							{
								numberbox.setIcon(new ImageIcon(n0));
							}
							else if (d_total == 1)
							{
								numberbox.setIcon(new ImageIcon(n1));
							}
							else if (d_total == 2)
							{
								numberbox.setIcon(new ImageIcon(n2));
							}
							else if (d_total == 3)
							{
								numberbox.setIcon(new ImageIcon(n3));
							}
							else if (d_total == 4)
							{
								numberbox.setIcon(new ImageIcon(n4));
							}
							else if (d_total == 5)
							{
								numberbox.setIcon(new ImageIcon(n5));
							}
							else if (d_total == 6)
							{
								numberbox.setIcon(new ImageIcon(n6));
							}
							else if (d_total == 7)
							{
								numberbox.setIcon(new ImageIcon(n7));
							}
							else if (d_total == 8)
							{
								numberbox.setIcon(new ImageIcon(n8));
							}
							else if (d_total == 9)
							{
								numberbox.setIcon(new ImageIcon(n9));
							}
							else if (d_total == 10)
							{
								numberbox.setIcon(new ImageIcon(n10));
							}
							else if (d_total == 11)
							{
								numberbox.setIcon(new ImageIcon(n11));
							}
							else if (d_total == 12)
							{
								numberbox.setIcon(new ImageIcon(n12));
							}
							else if (d_total == 13)
							{
								numberbox.setIcon(new ImageIcon(n13));
							}
							else if (d_total == 14)
							{
								numberbox.setIcon(new ImageIcon(n14));
							}
							else if (d_total == 15)
							{
								numberbox.setIcon(new ImageIcon(n15));
							}
							else if (d_total == 16)
							{
								numberbox.setIcon(new ImageIcon(n16));
							}
							else if (d_total == 17)
							{
								numberbox.setIcon(new ImageIcon(n17));
							}
							else if (d_total == 18)
							{
								numberbox.setIcon(new ImageIcon(n18));
							}
							else if (d_total == 19)
							{
								numberbox.setIcon(new ImageIcon(n19));
							}
							else if (d_total == 20)
							{
								numberbox.setIcon(new ImageIcon(n20));
							}
							else if (d_total == 21)
							{
								numberbox.setIcon(new ImageIcon(n21));
							}
							else if (d_total == 22)
							{
								numberbox.setIcon(new ImageIcon(n22));
							}
							else if (d_total == 23)
							{
								numberbox.setIcon(new ImageIcon(n23));
							}
							else if (d_total == 24)
							{
								numberbox.setIcon(new ImageIcon(n24));
							}
							else if (d_total == 25)
							{
								numberbox.setIcon(new ImageIcon(n25));
							}
							else if (d_total == 26)
							{
								numberbox.setIcon(new ImageIcon(n26));
							}
							else if (d_total == 27)
							{
								numberbox.setIcon(new ImageIcon(n27));
							}
							else if (d_total == 28)
							{
								numberbox.setIcon(new ImageIcon(n28));
							}
							else if (d_total == 29)
							{
								numberbox.setIcon(new ImageIcon(n29));
							}
							else if (d_total == 30)
							{
								numberbox.setIcon(new ImageIcon(n30));
							}
							else if (d_total == 31)
							{
								numberbox.setIcon(new ImageIcon(n31));
							}
							else if (d_total == 32)
							{
								numberbox.setIcon(new ImageIcon(n32));
							}
							else
							{
								numberbox.setIcon(new ImageIcon());
							}
							
							if (d_total > 21)
							{
								JOptionPane.showMessageDialog(frame, "Dealer BUST! You win your Bet!");
								
							}
							else if (d_total < 17)
							{
								if(card > 34)
								{
									shuffletracker = 0;
									
									JOptionPane.showMessageDialog(frame, "65% of the Cards has been used. Reshuffling Deck!");
									
									if(shuffletracker == 0)
									{
										shuffle(deck);
										card = 0;
										shuffletracker = 1;
									}
									
									card = 0;
									
									
									JOptionPane.showMessageDialog(frame, "Deck has been Reshuffled!  Continuing phase!");
								}
								
								if(deck[card].equals("ac"))
								{
								dSlot4.setIcon(new ImageIcon(ac));
								card++;
								
								//ace variable tracker
								aceyC2 = 1;
								
								d_value4 = 11;
								}
								else if (deck[card].equals("ad"))
								{
									dSlot4.setIcon(new ImageIcon(ad));
									card++;
									
									aceyD2 = 1;
									d_value4 = 11;
								}
								else if (deck[card].equals("ah"))
								{
									dSlot4.setIcon(new ImageIcon(ah));
									card++;
									
									aceyH2 = 1;
									d_value4 = 11;
								}
								else if (deck[card].equals("as"))
								{
									dSlot4.setIcon(new ImageIcon(as));
									card++;
									
									aceyS2 = 1;
									d_value4 = 11;
								}
								else if (deck[card].equals("c2"))
								{
									dSlot4.setIcon(new ImageIcon(c2));
									card++;
									
									d_value4 = 2;
								}
								else if (deck[card].equals("d2"))
								{
									dSlot4.setIcon(new ImageIcon(d2));
									card++;
									
									d_value4 = 2;
								}
								else if (deck[card].equals("h2"))
								{
									dSlot4.setIcon(new ImageIcon(h2));
									card++;
									
									d_value4 = 2;
								}
								else if (deck[card].equals("s2"))
								{
									dSlot4.setIcon(new ImageIcon(s2));
									card++;
									
									d_value4 = 2;
								}
								else if (deck[card].equals("c3"))
								{
									dSlot4.setIcon(new ImageIcon(c3));
									card++;
									
									d_value4 = 3;
								}
								else if (deck[card].equals("d3"))
								{
									dSlot4.setIcon(new ImageIcon(d3));
									card++;
									
									d_value4 = 3;
								}
								else if (deck[card].equals("h3"))
								{
									dSlot4.setIcon(new ImageIcon(h3));
									card++;
									
									d_value4 = 3;
								}
								else if (deck[card].equals("s3"))
								{
									dSlot4.setIcon(new ImageIcon(s3));
									card++;
									
									d_value4 = 3;
								}
								else if (deck[card].equals("c4"))
								{
									dSlot4.setIcon(new ImageIcon(c4));
									card++;
									
									d_value4 = 4;
								}
								else if (deck[card].equals("d4"))
								{
									dSlot4.setIcon(new ImageIcon(d4));
									card++;
									
									d_value4 = 4;
								}
								else if (deck[card].equals("h4"))
								{
									dSlot4.setIcon(new ImageIcon(h4));
									card++;
									
									d_value4 = 4;
								}
								else if (deck[card].equals("s4"))
								{
									dSlot4.setIcon(new ImageIcon(s4));
									card++;
									
									d_value4 = 4;
								}
								else if (deck[card].equals("c5"))
								{
									dSlot4.setIcon(new ImageIcon(c5));
									card++;
									
									d_value4 = 5;
								}
								else if (deck[card].equals("d5"))
								{
									dSlot4.setIcon(new ImageIcon(d5));
									card++;
									
									d_value4 = 5;
								}
								else if (deck[card].equals("h5"))
								{
									dSlot4.setIcon(new ImageIcon(h5));
									card++;
									
									d_value4 = 5;
								}
								else if (deck[card].equals("s5"))
								{
									dSlot4.setIcon(new ImageIcon(s5));
									card++;
									
									d_value4 = 5;
								}
								else if (deck[card].equals("c6"))
								{
									dSlot4.setIcon(new ImageIcon(c6));
									card++;
									
									d_value4 = 6;
								}
								else if (deck[card].equals("d6"))
								{
									dSlot4.setIcon(new ImageIcon(d6));
									card++;
									
									d_value4 = 6;
								}
								else if (deck[card].equals("h6"))
								{
									dSlot4.setIcon(new ImageIcon(h6));
									card++;
									
									d_value4 = 6;
								}
								else if (deck[card].equals("s6"))
								{
									dSlot4.setIcon(new ImageIcon(s6));
									card++;
									
									d_value4 = 6;
								}
								else if (deck[card].equals("c7"))
								{
									dSlot4.setIcon(new ImageIcon(c7));
									card++;
									
									d_value4 = 7;
								}
								else if (deck[card].equals("d7"))
								{
									dSlot4.setIcon(new ImageIcon(d7));
									card++;
									
									d_value4 = 7;
								}
								else if (deck[card].equals("h7"))
								{
									dSlot4.setIcon(new ImageIcon(h7));
									card++;
									
									d_value4 = 7;
								}
								else if (deck[card].equals("s7"))
								{
									dSlot4.setIcon(new ImageIcon(s7));
									card++;
									
									d_value4 = 7;
								}
								else if (deck[card].equals("c8"))
								{
									dSlot4.setIcon(new ImageIcon(c8));
									card++;
									
									d_value4 = 8;
								}
								else if (deck[card].equals("d8"))
								{
									dSlot4.setIcon(new ImageIcon(d8));
									card++;
									
									d_value4 = 8;
								}
								else if (deck[card].equals("h8"))
								{
									dSlot4.setIcon(new ImageIcon(h8));
									card++;
									
									d_value4 = 8;
								}
								else if (deck[card].equals("s8"))
								{
									dSlot4.setIcon(new ImageIcon(s8));
									card++;
									
									d_value4 = 8;
								}
								else if (deck[card].equals("c9"))
								{
									dSlot4.setIcon(new ImageIcon(c9));
									card++;
									
									d_value4 = 9;
								}
								else if (deck[card].equals("d9"))
								{
									dSlot4.setIcon(new ImageIcon(d9));
									card++;
									
									d_value4 = 9;
								}
								else if (deck[card].equals("h9"))
								{
									dSlot4.setIcon(new ImageIcon(h9));
									card++;
									
									d_value4 = 9;
								}
								else if (deck[card].equals("s9"))
								{
									dSlot4.setIcon(new ImageIcon(s9));
									card++;
									
									d_value4 = 9;
								}
								else if (deck[card].equals("c10"))
								{
									dSlot4.setIcon(new ImageIcon(c10));
									card++;
									
									d_value4 = 10;
								}
								else if (deck[card].equals("d10"))
								{
									dSlot4.setIcon(new ImageIcon(d10));
									card++;
									
									d_value4 = 10;
								}
								else if (deck[card].equals("h10"))
								{
									dSlot4.setIcon(new ImageIcon(h10));
									card++;
									
									d_value4 = 10;
								}
								else if (deck[card].equals("s10"))
								{
									dSlot4.setIcon(new ImageIcon(s10));
									card++;
									
									d_value4 = 10;
								}
								else if (deck[card].equals("cJ"))
								{
									dSlot4.setIcon(new ImageIcon(cJ));
									card++;
									
									d_value4 = 10;
								}
								else if (deck[card].equals("dJ"))
								{
									dSlot4.setIcon(new ImageIcon(dJ));
									card++;
									
									d_value4 = 10;
								}
								else if (deck[card].equals("hJ"))
								{
									dSlot4.setIcon(new ImageIcon(hJ));
									card++;
									
									d_value4 = 10;
								}
								else if (deck[card].equals("sJ"))
								{
									dSlot4.setIcon(new ImageIcon(sJ));
									card++;
									
									d_value4 = 10;
								}
								else if (deck[card].equals("cQ"))
								{
									dSlot4.setIcon(new ImageIcon(cQ));
									card++;
									
									d_value4 = 10;
								}
								else if (deck[card].equals("dQ"))
								{
									dSlot4.setIcon(new ImageIcon(dQ));
									card++;
									
									d_value4 = 10;
								}
								else if (deck[card].equals("hQ"))
								{
									dSlot4.setIcon(new ImageIcon(hQ));
									card++;
									
									d_value4 = 10;
								}
								else if (deck[card].equals("sQ"))
								{
									dSlot4.setIcon(new ImageIcon(sQ));
									card++;
									
									d_value4 = 10;
								}
								else if (deck[card].equals("cK"))
								{
									dSlot4.setIcon(new ImageIcon(cK));
									card++;
									
									d_value4 = 10;
								}
								else if (deck[card].equals("dK"))
								{
									dSlot4.setIcon(new ImageIcon(dK));
									card++;
									
									d_value4 = 10;
								}
								else if (deck[card].equals("hK"))
								{
									dSlot4.setIcon(new ImageIcon(hK));
									card++;
									
									d_value4 = 10;
								}
								else if (deck[card].equals("sK"))
								{
									dSlot4.setIcon(new ImageIcon(sK));
									card++;
									
									d_value4 = 10;
								}
								else
								{
									dSlot4.setIcon(new ImageIcon());
									card++;
								}
								
								d_total += d_value4;
								if(d_total == 0)
								{
									numberbox.setIcon(new ImageIcon(n0));
								}
								else if (d_total == 1)
								{
									numberbox.setIcon(new ImageIcon(n1));
								}
								else if (d_total == 2)
								{
									numberbox.setIcon(new ImageIcon(n2));
								}
								else if (d_total == 3)
								{
									numberbox.setIcon(new ImageIcon(n3));
								}
								else if (d_total == 4)
								{
									numberbox.setIcon(new ImageIcon(n4));
								}
								else if (d_total == 5)
								{
									numberbox.setIcon(new ImageIcon(n5));
								}
								else if (d_total == 6)
								{
									numberbox.setIcon(new ImageIcon(n6));
								}
								else if (d_total == 7)
								{
									numberbox.setIcon(new ImageIcon(n7));
								}
								else if (d_total == 8)
								{
									numberbox.setIcon(new ImageIcon(n8));
								}
								else if (d_total == 9)
								{
									numberbox.setIcon(new ImageIcon(n9));
								}
								else if (d_total == 10)
								{
									numberbox.setIcon(new ImageIcon(n10));
								}
								else if (d_total == 11)
								{
									numberbox.setIcon(new ImageIcon(n11));
								}
								else if (d_total == 12)
								{
									numberbox.setIcon(new ImageIcon(n12));
								}
								else if (d_total == 13)
								{
									numberbox.setIcon(new ImageIcon(n13));
								}
								else if (d_total == 14)
								{
									numberbox.setIcon(new ImageIcon(n14));
								}
								else if (d_total == 15)
								{
									numberbox.setIcon(new ImageIcon(n15));
								}
								else if (d_total == 16)
								{
									numberbox.setIcon(new ImageIcon(n16));
								}
								else if (d_total == 17)
								{
									numberbox.setIcon(new ImageIcon(n17));
								}
								else if (d_total == 18)
								{
									numberbox.setIcon(new ImageIcon(n18));
								}
								else if (d_total == 19)
								{
									numberbox.setIcon(new ImageIcon(n19));
								}
								else if (d_total == 20)
								{
									numberbox.setIcon(new ImageIcon(n20));
								}
								else if (d_total == 21)
								{
									numberbox.setIcon(new ImageIcon(n21));
								}
								else if (d_total == 22)
								{
									numberbox.setIcon(new ImageIcon(n22));
								}
								else if (d_total == 23)
								{
									numberbox.setIcon(new ImageIcon(n23));
								}
								else if (d_total == 24)
								{
									numberbox.setIcon(new ImageIcon(n24));
								}
								else if (d_total == 25)
								{
									numberbox.setIcon(new ImageIcon(n25));
								}
								else if (d_total == 26)
								{
									numberbox.setIcon(new ImageIcon(n26));
								}
								else if (d_total == 27)
								{
									numberbox.setIcon(new ImageIcon(n27));
								}
								else if (d_total == 28)
								{
									numberbox.setIcon(new ImageIcon(n28));
								}
								else if (d_total == 29)
								{
									numberbox.setIcon(new ImageIcon(n29));
								}
								else if (d_total == 30)
								{
									numberbox.setIcon(new ImageIcon(n30));
								}
								else if (d_total == 31)
								{
									numberbox.setIcon(new ImageIcon(n31));
								}
								else if (d_total == 32)
								{
									numberbox.setIcon(new ImageIcon(n32));
								}
								else
								{
									numberbox.setIcon(new ImageIcon());
								}
								
							}
							
							
						}
						else
						{
							
							//Dealer Busts
							
						}
						
						
						
						
					}
					
					
					if (d_total > 21)
					{
						d_bust = 1; 
					}
					
					
					
					if (p_total > d_total)
					{
						JOptionPane.showMessageDialog(frame, "You WIN, Dealer loses! YOU WIN YOUR BET!");
						
						
						balance += bet;
						bet = 0;
						options = 1;
						d_switch = false;
						dealNumber = 0;
						d_bust = 0;
						betlbl.setText(String.valueOf(bet));
						balancelbl.setText(String.valueOf(balance));
						
						JOptionPane.showMessageDialog(frame, "New Balance has been applied. Press DEAL after placing a new bet!");
					}
					else if (d_total > p_total && d_bust == 0)
					{
						JOptionPane.showMessageDialog(frame, "Dealer Wins, you Lose! You lost your bet.");
						
						balance -= bet;
						bet = 0;
						options = 1;
						d_switch = false;
						dealNumber = 0;
						d_bust = 0;
						
						betlbl.setText(String.valueOf(bet));
						balancelbl.setText(String.valueOf(balance));
						
						if (balance > 0)
						{
							JOptionPane.showMessageDialog(frame, "Place another bet and click DEAL to start a new phase!");
						}
						else
						{
							JOptionPane.showMessageDialog(frame, "You have no more Money!!! Sorry you lose, GAMEOVER!");
							lost_the_game =  1;
						}
					}
					else if (d_bust == 1)
					{
						JOptionPane.showMessageDialog(frame, "You WIN, Dealer BUST! YOU WIN YOUR BET!");
						
						
						balance += bet;
						bet = 0;
						options = 1;
						d_switch = false;
						dealNumber = 0;
						betlbl.setText(String.valueOf(bet));
						balancelbl.setText(String.valueOf(balance));
						d_bust = 0;
						JOptionPane.showMessageDialog(frame, "New Balance has been applied. Press DEAL after placing a new bet!");
					}
					else if(p_total == d_total)
					{
						JOptionPane.showMessageDialog(frame, "TIE! Bet is returned! ");
						
						bet = 0;
						options = 1;
						d_switch = false;
						dealNumber = 0;
						betlbl.setText(String.valueOf(bet));
					}
					
					
					
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "You cannot do this yet! Please press DEAL to start the player phase!");
				}
			}
		});
		btnStand.setIcon(new ImageIcon(sd));
		btnStand.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnStand.setBounds(6, 423, 250, 30);
		panelGame.add(btnStand);
		

		//*************************************************************************************************************************************
		//*************************************************************************************************************************************
		//*************************************************************************************************************************************
		//*************************************************************************************************************************************
		//*************************************************************************************************************************************
		//*************************************************************************************************************************************
		//*************************************************************************************************************************************
		Image ht = new ImageIcon(this.getClass().getResource("/ht.png")).getImage();
		JButton btnHit = new JButton("");
		btnHit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
			if (d_switch == true)
			{	
				JOptionPane.showMessageDialog(frame, "You choose to HIT! Drawing another card...");
				
				if (p_total < 21)
				{
					if(card > 34)
					{
						shuffletracker = 0;
						
						JOptionPane.showMessageDialog(frame, "65% of the Cards has been used. Reshuffling Deck!");
						
						if(shuffletracker == 0)
						{
							shuffle(deck);
							card = 0;
							shuffletracker = 1;
						}
						
						card = 0;
						
						
						JOptionPane.showMessageDialog(frame, "Deck has been Reshuffled!  Continuing phase!");
					}
					
					
					if (hit_num == 0)
					{
						hit_num = 1;
						p_value3 = 0;
						
					if (deck[card].equals("ac"))
					{
						card3p1.setIcon(new ImageIcon(ac));
						card++;
						
						
						
						
						choice = showConfirmDialog(null, "You Got an ACE! Would you like your card to equal 11? Choose 'yes' for 11 and 'no' for 1");
						
						if(choice == 0)
						{
							showMessageDialog(null, "Your Ace Card's Value is '11'");
							ace_valueCp = 11;
							p_value3 = 11;
						}
						else
						{
							showMessageDialog(null, "Your Ace Card's Value Stands as '1'");
							ace_valueCp = 1;
							p_value3 = 1;
						}
						
					}
					else if (deck[card].equals("ad"))
					{
						card3p1.setIcon(new ImageIcon(ad));
						card++;
						
						choice = showConfirmDialog(null, "You Got an ACE! Would you like your card to equal 11? Choose 'yes' for 11 and 'no' for 1");
						
						if(choice == 0)
						{
							showMessageDialog(null, "Your Ace Card's Value is '11'");
							ace_valueDp = 11;
							p_value3 = 11;
							
						}
						else
						{
							showMessageDialog(null, "Your Ace Card's Value Stands as '1'");
							ace_valueDp = 1;
							p_value3 = 1;
						}
					}
					else if (deck[card].equals("ah"))
					{
						card3p1.setIcon(new ImageIcon(ah));
						card++;
						
						choice = showConfirmDialog(null, "You Got an ACE! Would you like your card to equal 11? Choose 'yes' for 11 and 'no' for 1");
						
						if(choice == 0)
						{
							showMessageDialog(null, "Your Ace Card's Value is '11'");
							ace_valueHp = 11;
							p_value3 = 11;
							
						}
						else
						{
							showMessageDialog(null, "Your Ace Card's Value Stands as '1'");
							ace_valueHp = 1;
							p_value3 = 1;
							
						}
					}
					else if (deck[card].equals("as"))
					{
						card3p1.setIcon(new ImageIcon(as));
						card++;
						
						choice = showConfirmDialog(null, "You Got an ACE! Would you like your card to equal 11? Choose 'yes' for 11 and 'no' for 1");
						
						if(choice == 0)
						{
							showMessageDialog(null, "Your Ace Card's Value is '11'");
							ace_valueSp = 11;
							p_value3 = 11;
						}
						else
						{
							showMessageDialog(null, "Your Ace Card's Value Stands as '1'");
							ace_valueSp = 1;
							p_value3 = 1;
						}
					}
					else if (deck[card].equals("c2"))
					{
						card3p1.setIcon(new ImageIcon(c2));
						card++;
						p_value3 = 2;
					}
					else if (deck[card].equals("d2"))
					{
						card3p1.setIcon(new ImageIcon(d2));
						card++;
						p_value3 = 2;
					}
					else if (deck[card].equals("h2"))
					{
						card3p1.setIcon(new ImageIcon(h2));
						card++;
						p_value3 = 2;
					}
					else if (deck[card].equals("s2"))
					{
						card3p1.setIcon(new ImageIcon(s2));
						card++;
						p_value3 = 2;
					}
					else if (deck[card].equals("c3"))
					{
						card3p1.setIcon(new ImageIcon(c3));
						card++;
						p_value3 = 3;
					}
					else if (deck[card].equals("d3"))
					{
						card3p1.setIcon(new ImageIcon(d3));
						card++;
						p_value3 = 3;
					}
					else if (deck[card].equals("h3"))
					{
						card3p1.setIcon(new ImageIcon(h3));
						card++;
						p_value3 = 3;
					}
					else if (deck[card].equals("s3"))
					{
						card3p1.setIcon(new ImageIcon(s3));
						card++;
						p_value3 = 3;
						
					}
					else if (deck[card].equals("c4"))
					{
						card3p1.setIcon(new ImageIcon(c4));
						card++;
						p_value3 = 4;
					}
					else if (deck[card].equals("d4"))
					{
						card3p1.setIcon(new ImageIcon(d4));
						card++;
						p_value3 = 4;
					}
					else if (deck[card].equals("h4"))
					{
						card3p1.setIcon(new ImageIcon(h4));
						card++;
						p_value3 = 4;
					}
					else if (deck[card].equals("s4"))
					{
						card3p1.setIcon(new ImageIcon(s4));
						card++;
						p_value3 = 4;
					}
					else if (deck[card].equals("c5"))
					{
						card3p1.setIcon(new ImageIcon(c5));
						card++;
						p_value3 = 5;
					}
					else if (deck[card].equals("d5"))
					{
						card3p1.setIcon(new ImageIcon(d5));
						card++;
						p_value3 = 5;
					}
					else if (deck[card].equals("h5"))
					{
						card3p1.setIcon(new ImageIcon(h5));
						card++;
						p_value3 = 5;
					}
					else if (deck[card].equals("s5"))
					{
						card3p1.setIcon(new ImageIcon(s5));
						card++;
						p_value3 = 5;
					}
					else if (deck[card].equals("c6"))
					{
						card3p1.setIcon(new ImageIcon(c6));
						card++;
						p_value3 = 6;
					}
					else if (deck[card].equals("d6"))
					{
						card3p1.setIcon(new ImageIcon(d6));
						card++;
						p_value3 = 6;
					}
					else if (deck[card].equals("h6"))
					{
						card3p1.setIcon(new ImageIcon(h6));
						card++;
						p_value3 = 6;
					}
					else if (deck[card].equals("s6"))
					{
						card3p1.setIcon(new ImageIcon(s6));
						card++;
						p_value3 = 6;
					}
					else if (deck[card].equals("c7"))
					{
						card3p1.setIcon(new ImageIcon(c7));
						card++;
						p_value3 = 7;
					}
					else if (deck[card].equals("d7"))
					{
						card3p1.setIcon(new ImageIcon(d7));
						card++;
						p_value3 = 7;
					}
					else if (deck[card].equals("h7"))
					{
						card3p1.setIcon(new ImageIcon(h7));
						card++;
						p_value3 = 7;
					}
					else if (deck[card].equals("s7"))
					{
						card3p1.setIcon(new ImageIcon(s7));
						card++;
						p_value3 = 7;
					}
					else if (deck[card].equals("c8"))
					{
						card3p1.setIcon(new ImageIcon(c8));
						card++;
						p_value3 = 8;
					}
					else if (deck[card].equals("d8"))
					{
						card3p1.setIcon(new ImageIcon(d8));
						card++;
						p_value3 = 8;
					}
					else if (deck[card].equals("h8"))
					{
						card3p1.setIcon(new ImageIcon(h8));
						card++;
						p_value3 = 8;
					}
					else if (deck[card].equals("s8"))
					{
						card3p1.setIcon(new ImageIcon(s8));
						card++;
						p_value3 = 8;
					}
					else if (deck[card].equals("c9"))
					{
						card3p1.setIcon(new ImageIcon(c9));
						card++;
						p_value3 = 9;
					}
					else if (deck[card].equals("d9"))
					{
						card3p1.setIcon(new ImageIcon(d9));
						card++;
						p_value3 = 9;
					}
					else if (deck[card].equals("h9"))
					{
						card3p1.setIcon(new ImageIcon(h9));
						card++;
						p_value3 = 9;
					}
					else if (deck[card].equals("s9"))
					{
						card3p1.setIcon(new ImageIcon(s9));
						card++;
						p_value3 = 9;
					}
					else if (deck[card].equals("c10"))
					{
						card3p1.setIcon(new ImageIcon(c10));
						card++;
						p_value3 = 10;
					}
					else if (deck[card].equals("d10"))
					{
						card3p1.setIcon(new ImageIcon(d10));
						card++;
						p_value3 = 10;
					}
					else if (deck[card].equals("h10"))
					{
						card3p1.setIcon(new ImageIcon(h10));
						card++;
						p_value3 = 10;
					}
					else if (deck[card].equals("s10"))
					{
						card3p1.setIcon(new ImageIcon(s10));
						card++;
						p_value3 = 10;
					}
					else if (deck[card].equals("cJ"))
					{
						card3p1.setIcon(new ImageIcon(cJ));
						card++;
						p_value3 = 10;
					}
					else if (deck[card].equals("dJ"))
					{
						card3p1.setIcon(new ImageIcon(dJ));
						card++;
						p_value3 = 10;
					}
					else if (deck[card].equals("hJ"))
					{
						card3p1.setIcon(new ImageIcon(hJ));
						card++;
						p_value3 = 10;
					}
					else if (deck[card].equals("sJ"))
					{
						card3p1.setIcon(new ImageIcon(sJ));
						card++;
						p_value3 = 10;
					}
					else if (deck[card].equals("cQ"))
					{
						card3p1.setIcon(new ImageIcon(cQ));
						card++;
						p_value3 = 10;
					}
					else if (deck[card].equals("dQ"))
					{
						card3p1.setIcon(new ImageIcon(dQ));
						card++;
						p_value3 = 10;
					}
					else if (deck[card].equals("hQ"))
					{
						card3p1.setIcon(new ImageIcon(hQ));
						card++;
						p_value3 = 10;
					}
					else if (deck[card].equals("sQ"))
					{
						card3p1.setIcon(new ImageIcon(sQ));
						card++;
						p_value3 = 10;
					}
					else if (deck[card].equals("cK"))
					{
						card3p1.setIcon(new ImageIcon(cK));
						card++;
						p_value3 = 10;
					}
					else if (deck[card].equals("dK"))
					{
						card3p1.setIcon(new ImageIcon(dK));
						card++;
						p_value3 = 10;
					}
					else if (deck[card].equals("hK"))
					{
						card3p1.setIcon(new ImageIcon(hK));
						card++;
						p_value3 = 10;
					}
					else if (deck[card].equals("sK"))
					{
						card3p1.setIcon(new ImageIcon(sK));
						card++;
						p_value3 = 10;
					}
					else
					{
						card3p1.setIcon(new ImageIcon());
						card++;
					}
						p_total += p_value3;
					
					}
					else if (hit_num == 1)
					{
						
						p_value4 = 0;
					//This is the second slot for if the player wants to hit a second time
						if (deck[card].equals("ac"))
						{
							card4p2.setIcon(new ImageIcon(ac));
							card++;
							
							
							
							
							choice = showConfirmDialog(null, "You Got an ACE! Would you like your card to equal 11? Choose 'yes' for 11 and 'no' for 1");
							
							if(choice == 0)
							{
								showMessageDialog(null, "Your Ace Card's Value is '11'");
								ace_valueCp = 11;
								p_value4 = 11;
							}
							else
							{
								showMessageDialog(null, "Your Ace Card's Value Stands as '1'");
								ace_valueCp = 1;
								p_value4 = 1;
							}
							
						}
						else if (deck[card].equals("ad"))
						{
							card4p2.setIcon(new ImageIcon(ad));
							card++;
							
							choice = showConfirmDialog(null, "You Got an ACE! Would you like your card to equal 11? Choose 'yes' for 11 and 'no' for 1");
							
							if(choice == 0)
							{
								showMessageDialog(null, "Your Ace Card's Value is '11'");
								ace_valueDp = 11;
								p_value4 = 11;
								
							}
							else
							{
								showMessageDialog(null, "Your Ace Card's Value Stands as '1'");
								ace_valueDp = 1;
								p_value4 = 1;
							}
						}
						else if (deck[card].equals("ah"))
						{
							card4p2.setIcon(new ImageIcon(ah));
							card++;
							
							choice = showConfirmDialog(null, "You Got an ACE! Would you like your card to equal 11? Choose 'yes' for 11 and 'no' for 1");
							
							if(choice == 0)
							{
								showMessageDialog(null, "Your Ace Card's Value is '11'");
								ace_valueHp = 11;
								p_value4 = 11;
								
							}
							else
							{
								showMessageDialog(null, "Your Ace Card's Value Stands as '1'");
								ace_valueHp = 1;
								p_value4 = 1;
								
							}
						}
						else if (deck[card].equals("as"))
						{
							card4p2.setIcon(new ImageIcon(as));
							card++;
							
							choice = showConfirmDialog(null, "You Got an ACE! Would you like your card to equal 11? Choose 'yes' for 11 and 'no' for 1");
							
							if(choice == 0)
							{
								showMessageDialog(null, "Your Ace Card's Value is '11'");
								ace_valueSp = 11;
								p_value4 = 11;
							}
							else
							{
								showMessageDialog(null, "Your Ace Card's Value Stands as '1'");
								ace_valueSp = 1;
								p_value4 = 1;
							}
						}
						else if (deck[card].equals("c2"))
						{
							card4p2.setIcon(new ImageIcon(c2));
							card++;
							p_value4 = 2;
						}
						else if (deck[card].equals("d2"))
						{
							card4p2.setIcon(new ImageIcon(d2));
							card++;
							p_value4 = 2;
						}
						else if (deck[card].equals("h2"))
						{
							card4p2.setIcon(new ImageIcon(h2));
							card++;
							p_value4 = 2;
						}
						else if (deck[card].equals("s2"))
						{
							card4p2.setIcon(new ImageIcon(s2));
							card++;
							p_value4 = 2;
						}
						else if (deck[card].equals("c3"))
						{
							card4p2.setIcon(new ImageIcon(c3));
							card++;
							p_value4 = 3;
						}
						else if (deck[card].equals("d3"))
						{
							card4p2.setIcon(new ImageIcon(d3));
							card++;
							p_value4 = 3;
						}
						else if (deck[card].equals("h3"))
						{
							card4p2.setIcon(new ImageIcon(h3));
							card++;
							p_value4 = 3;
						}
						else if (deck[card].equals("s3"))
						{
							card4p2.setIcon(new ImageIcon(s3));
							card++;
							p_value4 = 3;
							
						}
						else if (deck[card].equals("c4"))
						{
							card4p2.setIcon(new ImageIcon(c4));
							card++;
							p_value4 = 4;
						}
						else if (deck[card].equals("d4"))
						{
							card4p2.setIcon(new ImageIcon(d4));
							card++;
							p_value4 = 4;
						}
						else if (deck[card].equals("h4"))
						{
							card4p2.setIcon(new ImageIcon(h4));
							card++;
							p_value4 = 4;
						}
						else if (deck[card].equals("s4"))
						{
							card4p2.setIcon(new ImageIcon(s4));
							card++;
							p_value4 = 4;
						}
						else if (deck[card].equals("c5"))
						{
							card4p2.setIcon(new ImageIcon(c5));
							card++;
							p_value4 = 5;
						}
						else if (deck[card].equals("d5"))
						{
							card4p2.setIcon(new ImageIcon(d5));
							card++;
							p_value4 = 5;
						}
						else if (deck[card].equals("h5"))
						{
							card4p2.setIcon(new ImageIcon(h5));
							card++;
							p_value4 = 5;
						}
						else if (deck[card].equals("s5"))
						{
							card4p2.setIcon(new ImageIcon(s5));
							card++;
							p_value4 = 5;
						}
						else if (deck[card].equals("c6"))
						{
							card4p2.setIcon(new ImageIcon(c6));
							card++;
							p_value4 = 6;
						}
						else if (deck[card].equals("d6"))
						{
							card4p2.setIcon(new ImageIcon(d6));
							card++;
							p_value4 = 6;
						}
						else if (deck[card].equals("h6"))
						{
							card4p2.setIcon(new ImageIcon(h6));
							card++;
							p_value4 = 6;
						}
						else if (deck[card].equals("s6"))
						{
							card4p2.setIcon(new ImageIcon(s6));
							card++;
							p_value4 = 6;
						}
						else if (deck[card].equals("c7"))
						{
							card4p2.setIcon(new ImageIcon(c7));
							card++;
							p_value4 = 7;
						}
						else if (deck[card].equals("d7"))
						{
							card4p2.setIcon(new ImageIcon(d7));
							card++;
							p_value4 = 7;
						}
						else if (deck[card].equals("h7"))
						{
							card4p2.setIcon(new ImageIcon(h7));
							card++;
							p_value4 = 7;
						}
						else if (deck[card].equals("s7"))
						{
							card4p2.setIcon(new ImageIcon(s7));
							card++;
							p_value4 = 7;
						}
						else if (deck[card].equals("c8"))
						{
							card4p2.setIcon(new ImageIcon(c8));
							card++;
							p_value4 = 8;
						}
						else if (deck[card].equals("d8"))
						{
							card4p2.setIcon(new ImageIcon(d8));
							card++;
							p_value4 = 8;
						}
						else if (deck[card].equals("h8"))
						{
							card4p2.setIcon(new ImageIcon(h8));
							card++;
							p_value4 = 8;
						}
						else if (deck[card].equals("s8"))
						{
							card4p2.setIcon(new ImageIcon(s8));
							card++;
							p_value4 = 8;
						}
						else if (deck[card].equals("c9"))
						{
							card4p2.setIcon(new ImageIcon(c9));
							card++;
							p_value4 = 9;
						}
						else if (deck[card].equals("d9"))
						{
							card4p2.setIcon(new ImageIcon(d9));
							card++;
							p_value4 = 9;
						}
						else if (deck[card].equals("h9"))
						{
							card4p2.setIcon(new ImageIcon(h9));
							card++;
							p_value4 = 9;
						}
						else if (deck[card].equals("s9"))
						{
							card4p2.setIcon(new ImageIcon(s9));
							card++;
							p_value4 = 9;
						}
						else if (deck[card].equals("c10"))
						{
							card4p2.setIcon(new ImageIcon(c10));
							card++;
							p_value4 = 10;
						}
						else if (deck[card].equals("d10"))
						{
							card4p2.setIcon(new ImageIcon(d10));
							card++;
							p_value4 = 10;
						}
						else if (deck[card].equals("h10"))
						{
							card4p2.setIcon(new ImageIcon(h10));
							card++;
							p_value4 = 10;
						}
						else if (deck[card].equals("s10"))
						{
							card4p2.setIcon(new ImageIcon(s10));
							card++;
							p_value4 = 10;
						}
						else if (deck[card].equals("cJ"))
						{
							card4p2.setIcon(new ImageIcon(cJ));
							card++;
							p_value4 = 10;
						}
						else if (deck[card].equals("dJ"))
						{
							card4p2.setIcon(new ImageIcon(dJ));
							card++;
							p_value4 = 10;
						}
						else if (deck[card].equals("hJ"))
						{
							card4p2.setIcon(new ImageIcon(hJ));
							card++;
							p_value4 = 10;
						}
						else if (deck[card].equals("sJ"))
						{
							card4p2.setIcon(new ImageIcon(sJ));
							card++;
							p_value4 = 10;
						}
						else if (deck[card].equals("cQ"))
						{
							card4p2.setIcon(new ImageIcon(cQ));
							card++;
							p_value4 = 10;
						}
						else if (deck[card].equals("dQ"))
						{
							card4p2.setIcon(new ImageIcon(dQ));
							card++;
							p_value4 = 10;
						}
						else if (deck[card].equals("hQ"))
						{
							card4p2.setIcon(new ImageIcon(hQ));
							card++;
							p_value4 = 10;
						}
						else if (deck[card].equals("sQ"))
						{
							card4p2.setIcon(new ImageIcon(sQ));
							card++;
							p_value4 = 10;
						}
						else if (deck[card].equals("cK"))
						{
							card4p2.setIcon(new ImageIcon(cK));
							card++;
							p_value4 = 10;
						}
						else if (deck[card].equals("dK"))
						{
							card4p2.setIcon(new ImageIcon(dK));
							card++;
							p_value4 = 10;
						}
						else if (deck[card].equals("hK"))
						{
							card4p2.setIcon(new ImageIcon(hK));
							card++;
							p_value4 = 10;
						}
						else if (deck[card].equals("sK"))
						{
							card4p2.setIcon(new ImageIcon(sK));
							card++;
							p_value4 = 10;
						}
						else
						{
							card4p2.setIcon(new ImageIcon());
							card++;
						}
					
						p_total += p_value4;
						hit_num = 0;
					}
					
					
					/*
					if (hit_num == 0)
					{
						total += p_value3;
						handValue.setText(String.valueOf(p_total));
					}
					else
					{
						total += p_value4;
						
					}*/
					
					
					
					handValue.setText(String.valueOf(p_total));
					
					
					
					if(p_total == 0)
					{
						numberbox2.setIcon(new ImageIcon(n0));
					}
					else if (p_total == 1)
					{
						numberbox2.setIcon(new ImageIcon(n1));
					}
					else if (p_total == 2)
					{
						numberbox2.setIcon(new ImageIcon(n2));
					}
					else if (p_total == 3)
					{
						numberbox2.setIcon(new ImageIcon(n3));
					}
					else if (p_total == 4)
					{
						numberbox2.setIcon(new ImageIcon(n4));
					}
					else if (p_total == 5)
					{
						numberbox2.setIcon(new ImageIcon(n5));
					}
					else if (p_total == 6)
					{
						numberbox2.setIcon(new ImageIcon(n6));
					}
					else if (p_total == 7)
					{
						numberbox2.setIcon(new ImageIcon(n7));
					}
					else if (p_total == 8)
					{
						numberbox2.setIcon(new ImageIcon(n8));
					}
					else if (p_total == 9)
					{
						numberbox2.setIcon(new ImageIcon(n9));
					}
					else if (p_total == 10)
					{
						numberbox2.setIcon(new ImageIcon(n10));
					}
					else if (p_total == 11)
					{
						numberbox2.setIcon(new ImageIcon(n11));
					}
					else if (p_total == 12)
					{
						numberbox2.setIcon(new ImageIcon(n12));
					}
					else if (p_total == 13)
					{
						numberbox2.setIcon(new ImageIcon(n13));
					}
					else if (p_total == 14)
					{
						numberbox2.setIcon(new ImageIcon(n14));
					}
					else if (p_total == 15)
					{
						numberbox2.setIcon(new ImageIcon(n15));
					}
					else if (p_total == 16)
					{
						numberbox2.setIcon(new ImageIcon(n16));
					}
					else if (p_total == 17)
					{
						numberbox2.setIcon(new ImageIcon(n17));
					}
					else if (p_total == 18)
					{
						numberbox2.setIcon(new ImageIcon(n18));
					}
					else if (p_total == 19)
					{
						numberbox2.setIcon(new ImageIcon(n19));
					}
					else if (p_total == 20)
					{
						numberbox2.setIcon(new ImageIcon(n20));
					}
					else if (p_total == 21)
					{
						numberbox2.setIcon(new ImageIcon(n21));
					}
					else if (p_total == 22)
					{
						numberbox2.setIcon(new ImageIcon(n22));
					}
					else if (p_total == 23)
					{
						numberbox2.setIcon(new ImageIcon(n23));
					}
					else if (p_total == 24)
					{
						numberbox2.setIcon(new ImageIcon(n24));
					}
					else if (p_total == 25)
					{
						numberbox2.setIcon(new ImageIcon(n25));
					}
					else if (p_total == 26)
					{
						numberbox2.setIcon(new ImageIcon(n26));
					}
					else if (p_total == 27)
					{
						numberbox2.setIcon(new ImageIcon(n27));
					}
					else if (p_total == 28)
					{
						numberbox2.setIcon(new ImageIcon(n28));
					}
					else if (p_total == 29)
					{
						numberbox2.setIcon(new ImageIcon(n29));
					}
					else if (p_total == 30)
					{
						numberbox2.setIcon(new ImageIcon(n30));
					}
					else if (p_total == 31)
					{
						numberbox2.setIcon(new ImageIcon(n29));
					}
					else if (p_total == 32)
					{
						numberbox2.setIcon(new ImageIcon(n32));
					}
					else
					{
						numberbox2.setIcon(new ImageIcon());
					} 
					
					
					
					
					betlbl.setText(String.valueOf(bet));
					balancelbl.setText(String.valueOf(balance));
					
					
					if (p_total > 21)
					{
						JOptionPane.showMessageDialog(frame, "Bust! Your value exceeded 21. You lose your bet. Press Deal for next phase!");
						
						balance -= bet;
						bet = 0;
						options = 1;
						d_switch = false;
						dealNumber = 0;
						
						betlbl.setText(String.valueOf(bet));
						balancelbl.setText(String.valueOf(balance));
						hit_num = 0;
						total = 0;
					}
					
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "You can not Hit for another card! Try to deal a new hand!");
					
					
					
				}
				
			}
			else
			{
				JOptionPane.showMessageDialog(frame, "You cannot do this yet! Please press DEAL to start the player phase!");

			}
				
			}
		});
		btnHit.setIcon(new ImageIcon(ht));
		btnHit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHit.setBounds(6, 454, 250, 30);
		panelGame.add(btnHit);
		
		//*************************************************************************************************************************************
		//*************************************************************************************************************************************
		//*************************************************************************************************************************************
		//*************************************************************************************************************************************
		//*************************************************************************************************************************************
		//*************************************************************************************************************************************
		//*************************************************************************************************************************************
		Image dd = new ImageIcon(this.getClass().getResource("/dd.png")).getImage();
		JButton btnDoubleDown = new JButton("");
		btnDoubleDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(d_switch == true)
				{
				
					
					if(p_total == 9 || p_total == 10 || p_total == 11)
					{
						
						JOptionPane.showMessageDialog(frame, "You choose to Double Down! Doubling Current Bet and drawing another card...");
						JOptionPane.showMessageDialog(frame, "Revealing Dealer Card...");
						scoreHide.setIcon(new ImageIcon());
						cardBack.setIcon(new ImageIcon());
						
						
						
						
						if(card > 34)
						{
							shuffletracker = 0;
							
							JOptionPane.showMessageDialog(frame, "65% of the Cards has been used. Reshuffling Deck!");
							
							if(shuffletracker == 0)
							{
								shuffle(deck);
								card = 0;
								shuffletracker = 1;
							}
							
							card = 0;
							
							
							JOptionPane.showMessageDialog(frame, "Deck has been Reshuffled!  Continuing phase!");
						}					
						
						
						
						bet *= 2;
							
						betlbl.setText(String.valueOf(bet));
						
						if (deck[card].equals("ac"))
						{
							card3p1.setIcon(new ImageIcon(ac));
							card++;
							
							
							
							
							choice = showConfirmDialog(null, "You Got an ACE! Would you like your card to equal 11? Choose 'yes' for 11 and 'no' for 1");
							
							if(choice == 0)
							{
								showMessageDialog(null, "Your Ace Card's Value is '11'");
								ace_valueCp = 11;
								p_value3 = 11;
							}
							else
							{
								showMessageDialog(null, "Your Ace Card's Value Stands as '1'");
								ace_valueCp = 1;
								p_value3 = 1;
							}
							
						}
						else if (deck[card].equals("ad"))
						{
							card3p1.setIcon(new ImageIcon(ad));
							card++;
							
							choice = showConfirmDialog(null, "You Got an ACE! Would you like your card to equal 11? Choose 'yes' for 11 and 'no' for 1");
							
							if(choice == 0)
							{
								showMessageDialog(null, "Your Ace Card's Value is '11'");
								ace_valueDp = 11;
								p_value3 = 11;
								
							}
							else
							{
								showMessageDialog(null, "Your Ace Card's Value Stands as '1'");
								ace_valueDp = 1;
								p_value3 = 1;
							}
						}
						else if (deck[card].equals("ah"))
						{
							card3p1.setIcon(new ImageIcon(ah));
							card++;
							
							choice = showConfirmDialog(null, "You Got an ACE! Would you like your card to equal 11? Choose 'yes' for 11 and 'no' for 1");
							
							if(choice == 0)
							{
								showMessageDialog(null, "Your Ace Card's Value is '11'");
								ace_valueHp = 11;
								p_value3 = 11;
								
							}
							else
							{
								showMessageDialog(null, "Your Ace Card's Value Stands as '1'");
								ace_valueHp = 1;
								p_value3 = 1;
								
							}
						}
						else if (deck[card].equals("as"))
						{
							card3p1.setIcon(new ImageIcon(as));
							card++;
							
							choice = showConfirmDialog(null, "You Got an ACE! Would you like your card to equal 11? Choose 'yes' for 11 and 'no' for 1");
							
							if(choice == 0)
							{
								showMessageDialog(null, "Your Ace Card's Value is '11'");
								ace_valueSp = 11;
								p_value3 = 11;
							}
							else
							{
								showMessageDialog(null, "Your Ace Card's Value Stands as '1'");
								ace_valueSp = 1;
								p_value3 = 1;
							}
						}
						else if (deck[card].equals("c2"))
						{
							card3p1.setIcon(new ImageIcon(c2));
							card++;
							p_value3 = 2;
						}
						else if (deck[card].equals("d2"))
						{
							card3p1.setIcon(new ImageIcon(d2));
							card++;
							p_value3 = 2;
						}
						else if (deck[card].equals("h2"))
						{
							card3p1.setIcon(new ImageIcon(h2));
							card++;
							p_value3 = 2;
						}
						else if (deck[card].equals("s2"))
						{
							card3p1.setIcon(new ImageIcon(s2));
							card++;
							p_value3 = 2;
						}
						else if (deck[card].equals("c3"))
						{
							card3p1.setIcon(new ImageIcon(c3));
							card++;
							p_value3 = 3;
						}
						else if (deck[card].equals("d3"))
						{
							card3p1.setIcon(new ImageIcon(d3));
							card++;
							p_value3 = 3;
						}
						else if (deck[card].equals("h3"))
						{
							card3p1.setIcon(new ImageIcon(h3));
							card++;
							p_value3 = 3;
						}
						else if (deck[card].equals("s3"))
						{
							card3p1.setIcon(new ImageIcon(s3));
							card++;
							p_value3 = 3;
							
						}
						else if (deck[card].equals("c4"))
						{
							card3p1.setIcon(new ImageIcon(c4));
							card++;
							p_value3 = 4;
						}
						else if (deck[card].equals("d4"))
						{
							card3p1.setIcon(new ImageIcon(d4));
							card++;
							p_value3 = 4;
						}
						else if (deck[card].equals("h4"))
						{
							card3p1.setIcon(new ImageIcon(h4));
							card++;
							p_value3 = 4;
						}
						else if (deck[card].equals("s4"))
						{
							card3p1.setIcon(new ImageIcon(s4));
							card++;
							p_value3 = 4;
						}
						else if (deck[card].equals("c5"))
						{
							card3p1.setIcon(new ImageIcon(c5));
							card++;
							p_value3 = 5;
						}
						else if (deck[card].equals("d5"))
						{
							card3p1.setIcon(new ImageIcon(d5));
							card++;
							p_value3 = 5;
						}
						else if (deck[card].equals("h5"))
						{
							card3p1.setIcon(new ImageIcon(h5));
							card++;
							p_value3 = 5;
						}
						else if (deck[card].equals("s5"))
						{
							card3p1.setIcon(new ImageIcon(s5));
							card++;
							p_value3 = 5;
						}
						else if (deck[card].equals("c6"))
						{
							card3p1.setIcon(new ImageIcon(c6));
							card++;
							p_value3 = 6;
						}
						else if (deck[card].equals("d6"))
						{
							card3p1.setIcon(new ImageIcon(d6));
							card++;
							p_value3 = 6;
						}
						else if (deck[card].equals("h6"))
						{
							card3p1.setIcon(new ImageIcon(h6));
							card++;
							p_value3 = 6;
						}
						else if (deck[card].equals("s6"))
						{
							card3p1.setIcon(new ImageIcon(s6));
							card++;
							p_value3 = 6;
						}
						else if (deck[card].equals("c7"))
						{
							card3p1.setIcon(new ImageIcon(c7));
							card++;
							p_value3 = 7;
						}
						else if (deck[card].equals("d7"))
						{
							card3p1.setIcon(new ImageIcon(d7));
							card++;
							p_value3 = 7;
						}
						else if (deck[card].equals("h7"))
						{
							card3p1.setIcon(new ImageIcon(h7));
							card++;
							p_value3 = 7;
						}
						else if (deck[card].equals("s7"))
						{
							card3p1.setIcon(new ImageIcon(s7));
							card++;
							p_value3 = 7;
						}
						else if (deck[card].equals("c8"))
						{
							card3p1.setIcon(new ImageIcon(c8));
							card++;
							p_value3 = 8;
						}
						else if (deck[card].equals("d8"))
						{
							card3p1.setIcon(new ImageIcon(d8));
							card++;
							p_value3 = 8;
						}
						else if (deck[card].equals("h8"))
						{
							card3p1.setIcon(new ImageIcon(h8));
							card++;
							p_value3 = 8;
						}
						else if (deck[card].equals("s8"))
						{
							card3p1.setIcon(new ImageIcon(s8));
							card++;
							p_value3 = 8;
						}
						else if (deck[card].equals("c9"))
						{
							card3p1.setIcon(new ImageIcon(c9));
							card++;
							p_value3 = 9;
						}
						else if (deck[card].equals("d9"))
						{
							card3p1.setIcon(new ImageIcon(d9));
							card++;
							p_value3 = 9;
						}
						else if (deck[card].equals("h9"))
						{
							card3p1.setIcon(new ImageIcon(h9));
							card++;
							p_value3 = 9;
						}
						else if (deck[card].equals("s9"))
						{
							card3p1.setIcon(new ImageIcon(s9));
							card++;
							p_value3 = 9;
						}
						else if (deck[card].equals("c10"))
						{
							card3p1.setIcon(new ImageIcon(c10));
							card++;
							p_value3 = 10;
						}
						else if (deck[card].equals("d10"))
						{
							card3p1.setIcon(new ImageIcon(d10));
							card++;
							p_value3 = 10;
						}
						else if (deck[card].equals("h10"))
						{
							card3p1.setIcon(new ImageIcon(h10));
							card++;
							p_value3 = 10;
						}
						else if (deck[card].equals("s10"))
						{
							card3p1.setIcon(new ImageIcon(s10));
							card++;
							p_value3 = 10;
						}
						else if (deck[card].equals("cJ"))
						{
							card3p1.setIcon(new ImageIcon(cJ));
							card++;
							p_value3 = 10;
						}
						else if (deck[card].equals("dJ"))
						{
							card3p1.setIcon(new ImageIcon(dJ));
							card++;
							p_value3 = 10;
						}
						else if (deck[card].equals("hJ"))
						{
							card3p1.setIcon(new ImageIcon(hJ));
							card++;
							p_value3 = 10;
						}
						else if (deck[card].equals("sJ"))
						{
							card3p1.setIcon(new ImageIcon(sJ));
							card++;
							p_value3 = 10;
						}
						else if (deck[card].equals("cQ"))
						{
							card3p1.setIcon(new ImageIcon(cQ));
							card++;
							p_value3 = 10;
						}
						else if (deck[card].equals("dQ"))
						{
							card3p1.setIcon(new ImageIcon(dQ));
							card++;
							p_value3 = 10;
						}
						else if (deck[card].equals("hQ"))
						{
							card3p1.setIcon(new ImageIcon(hQ));
							card++;
							p_value3 = 10;
						}
						else if (deck[card].equals("sQ"))
						{
							card3p1.setIcon(new ImageIcon(sQ));
							card++;
							p_value3 = 10;
						}
						else if (deck[card].equals("cK"))
						{
							card3p1.setIcon(new ImageIcon(cK));
							card++;
							p_value3 = 10;
						}
						else if (deck[card].equals("dK"))
						{
							card3p1.setIcon(new ImageIcon(dK));
							card++;
							p_value3 = 10;
						}
						else if (deck[card].equals("hK"))
						{
							card3p1.setIcon(new ImageIcon(hK));
							card++;
							p_value3 = 10;
						}
						else if (deck[card].equals("sK"))
						{
							card3p1.setIcon(new ImageIcon(sK));
							card++;
							p_value3 = 10;
						}
						else
						{
							card3p1.setIcon(new ImageIcon());
							card++;
						}
						
						
						p_total += p_value3;
						handValue.setText(String.valueOf(p_total));
						
						if(p_total == 0)
						{
							numberbox2.setIcon(new ImageIcon(n0));
						}
						else if (p_total == 1)
						{
							numberbox2.setIcon(new ImageIcon(n1));
						}
						else if (p_total == 2)
						{
							numberbox2.setIcon(new ImageIcon(n2));
						}
						else if (p_total == 3)
						{
							numberbox2.setIcon(new ImageIcon(n3));
						}
						else if (p_total == 4)
						{
							numberbox2.setIcon(new ImageIcon(n4));
						}
						else if (p_total == 5)
						{
							numberbox2.setIcon(new ImageIcon(n5));
						}
						else if (p_total == 6)
						{
							numberbox2.setIcon(new ImageIcon(n6));
						}
						else if (p_total == 7)
						{
							numberbox2.setIcon(new ImageIcon(n7));
						}
						else if (p_total == 8)
						{
							numberbox2.setIcon(new ImageIcon(n8));
						}
						else if (p_total == 9)
						{
							numberbox2.setIcon(new ImageIcon(n9));
						}
						else if (p_total == 10)
						{
							numberbox2.setIcon(new ImageIcon(n10));
						}
						else if (p_total == 11)
						{
							numberbox2.setIcon(new ImageIcon(n11));
						}
						else if (p_total == 12)
						{
							numberbox2.setIcon(new ImageIcon(n12));
						}
						else if (p_total == 13)
						{
							numberbox2.setIcon(new ImageIcon(n13));
						}
						else if (p_total == 14)
						{
							numberbox2.setIcon(new ImageIcon(n14));
						}
						else if (p_total == 15)
						{
							numberbox2.setIcon(new ImageIcon(n15));
						}
						else if (p_total == 16)
						{
							numberbox2.setIcon(new ImageIcon(n16));
						}
						else if (p_total == 17)
						{
							numberbox2.setIcon(new ImageIcon(n17));
						}
						else if (p_total == 18)
						{
							numberbox2.setIcon(new ImageIcon(n18));
						}
						else if (p_total == 19)
						{
							numberbox2.setIcon(new ImageIcon(n19));
						}
						else if (p_total == 20)
						{
							numberbox2.setIcon(new ImageIcon(n20));
						}
						else if (p_total == 21)
						{
							numberbox2.setIcon(new ImageIcon(n21));
						}
						else if (p_total == 22)
						{
							numberbox2.setIcon(new ImageIcon(n22));
						}
						else if (p_total == 23)
						{
							numberbox2.setIcon(new ImageIcon(n23));
						}
						else if (p_total == 24)
						{
							numberbox2.setIcon(new ImageIcon(n24));
						}
						else if (p_total == 25)
						{
							numberbox2.setIcon(new ImageIcon(n25));
						}
						else if (p_total == 26)
						{
							numberbox2.setIcon(new ImageIcon(n26));
						}
						else if (p_total == 27)
						{
							numberbox2.setIcon(new ImageIcon(n27));
						}
						else if (p_total == 28)
						{
							numberbox2.setIcon(new ImageIcon(n28));
						}
						else if (p_total == 29)
						{
							numberbox2.setIcon(new ImageIcon(n29));
						}
						else if (p_total == 30)
						{
							numberbox2.setIcon(new ImageIcon(n30));
						}
						else if (p_total == 31)
						{
							numberbox2.setIcon(new ImageIcon(n29));
						}
						else if (p_total == 32)
						{
							numberbox2.setIcon(new ImageIcon(n32));
						}
						else
						{
							numberbox2.setIcon(new ImageIcon());
						} 
						
						
						if (p_total > 21)
						{
							JOptionPane.showMessageDialog(frame, "Bust! Your value exceeded 21. You lose your bet. Press Deal for next phase!");
							
							balance -= bet;
							bet = 0;
							options = 1;
							d_switch = false;
							dealNumber = 0;
							
							betlbl.setText(String.valueOf(bet));
							balancelbl.setText(String.valueOf(balance));
					
						}
						else
						{
							if (d_total > 21)
							{
								d_bust = 1; 
							}
							
							
							
							if (p_total > d_total)
							{
								JOptionPane.showMessageDialog(frame, "You WIN, Dealer loses! YOU WIN YOUR BET!");
								
								
								balance += bet;
								bet = 0;
								options = 1;
								d_switch = false;
								dealNumber = 0;
								d_bust = 0;
								betlbl.setText(String.valueOf(bet));
								balancelbl.setText(String.valueOf(balance));
								
								JOptionPane.showMessageDialog(frame, "New Balance has been applied. Press DEAL after placing a new bet!");
							}
							else if (d_total > p_total && d_bust == 0)
							{
								JOptionPane.showMessageDialog(frame, "Dealer Wins, you Lose! You lost your bet.");
								
								balance -= bet;
								bet = 0;
								options = 1;
								d_switch = false;
								dealNumber = 0;
								d_bust = 0;
								
								betlbl.setText(String.valueOf(bet));
								balancelbl.setText(String.valueOf(balance));
								
								if (balance > 0)
								{
									JOptionPane.showMessageDialog(frame, "Place another bet and click DEAL to start a new phase!");
								}
								else
								{
									JOptionPane.showMessageDialog(frame, "You have no more Money!!! Sorry you lose, GAMEOVER!");
									lost_the_game =  1;
								}
							}
							else if (d_bust == 1)
							{
								JOptionPane.showMessageDialog(frame, "You WIN, Dealer BUST! YOU WIN YOUR BET!");
								
								
								balance += bet;
								bet = 0;
								options = 1;
								d_switch = false;
								dealNumber = 0;
								betlbl.setText(String.valueOf(bet));
								balancelbl.setText(String.valueOf(balance));
								d_bust = 0;
								JOptionPane.showMessageDialog(frame, "New Balance has been applied. Press DEAL after placing a new bet!");
							}
							else if(p_total == d_total)
							{
								JOptionPane.showMessageDialog(frame, "TIE! Bet is returned! ");
								
								bet = 0;
								options = 1;
								d_switch = false;
								dealNumber = 0;
								betlbl.setText(String.valueOf(bet));
							}
							
							
							
							
						}
						
						
						
						
					}
					else
					{
						JOptionPane.showMessageDialog(frame, "You cannot do this! Hand Value must be equal to 9, 10, or 11 to Double Down!");
					}
					
					
					
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "You cannot do this yet! Please press DEAL to start the player phase!");

				}
				
				
			}
		});
		btnDoubleDown.setIcon(new ImageIcon(dd));
		btnDoubleDown.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDoubleDown.setBounds(6, 482, 250, 30);
		panelGame.add(btnDoubleDown);
		
		JLabel lblSoftwareApplicationBrought = new JLabel("SOFTWARE APPLICATION BROUGHT TO YOU BY TEAM EXILE INC.     ALL RIGHTS RESERVED COPYRIGHT 2016");
		lblSoftwareApplicationBrought.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblSoftwareApplicationBrought.setBounds(29, 815, 888, 25);
		panelGame.add(lblSoftwareApplicationBrought);
		
		
		
		
		
		
		
		//**************************************************************************************************************
		//**************************************************************************************************************
		//**************************************************************************************************************
		//**************************************************************************************************************
		//**************************************************************************************************************
		//**************************************************************************************************************
		
		JButton btnDeal = new JButton("");
		Image deal = new ImageIcon(this.getClass().getResource("/deal.png")).getImage();
		btnDeal.setIcon(new ImageIcon(deal));
		btnDeal.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e)
			{
				//JDialog d = new JDialog();
				//d.setVisible(true);
				//cards1.setIcon(new ImageIcon(back));
				//cards2.setIcon(new ImageIcon(back));
				
				//Code here initially shuffles the deck before game starts
				//Shuffle the Deck and then Deal Cards to 4 card slots
				if(shuffletracker == 0)
				{
					shuffle(deck);
					card = 0;
					shuffletracker = 1;
				}
				
				
				
				//The first of the 4 cards is dealt to Dealer's card slot
				//This code is all for the first random card dealt to the dealer
				//This conditional if statement makes sure no more than 34 cards are used from the Deck of 52
				//This conditional statement allows for only 65% of cards to be used from the deck
				if (bet == 0)
				{
					JOptionPane.showMessageDialog(frame, "Cannot Deal! You have not placed a bet yet. Click one of the bet chips below and then click DEAL!");
				}
				else if(firstDeal == 0 || dealNumber == 0)
				{
				scoreHide.setIcon(new ImageIcon(scoreBlock));
				numberbox.setIcon(new ImageIcon(n0));
				numberbox2.setIcon(new ImageIcon(n0));
				cards1.setIcon(new ImageIcon());
				cards2.setIcon(new ImageIcon());
				dSlot3.setIcon(new ImageIcon());
				dSlot4.setIcon(new ImageIcon());
				
				cards3.setIcon(new ImageIcon());
				cards4.setIcon(new ImageIcon());
				
				card3p1.setIcon(new ImageIcon());
				card4p2.setIcon(new ImageIcon());
				
				if (card < 34)
				{
					d_switch = true;
				if (deck[card].equals("ac"))
				{
					cards1.setIcon(new ImageIcon(ac));
					card++;
					
					//ace variable tracker
					aceyC = 1;
					
					d_value1 = 11;
					
					
					
				}
				else if (deck[card].equals("ad"))
				{
					cards1.setIcon(new ImageIcon(ad));
					card++;
					
					aceyD = 1;
					d_value1 = 11;
				}
				else if (deck[card].equals("ah"))
				{
					cards1.setIcon(new ImageIcon(ah));
					card++;
					
					aceyH = 1;
					d_value1 = 11;
				}
				else if (deck[card].equals("as"))
				{
					cards1.setIcon(new ImageIcon(as));
					card++;
					
					aceyS = 1;
					d_value1 = 11;
				}
				else if (deck[card].equals("c2"))
				{
					cards1.setIcon(new ImageIcon(c2));
					card++;
					
					d_value1 = 2;
				}
				else if (deck[card].equals("d2"))
				{
					cards1.setIcon(new ImageIcon(d2));
					card++;
					
					d_value1 = 2;
				}
				else if (deck[card].equals("h2"))
				{
					cards1.setIcon(new ImageIcon(h2));
					card++;
					
					d_value1 = 2;
				}
				else if (deck[card].equals("s2"))
				{
					cards1.setIcon(new ImageIcon(s2));
					card++;
					
					d_value1 = 2;
				}
				else if (deck[card].equals("c3"))
				{
					cards1.setIcon(new ImageIcon(c3));
					card++;
					
					d_value1 = 3;
				}
				else if (deck[card].equals("d3"))
				{
					cards1.setIcon(new ImageIcon(d3));
					card++;
					
					d_value1 = 3;
				}
				else if (deck[card].equals("h3"))
				{
					cards1.setIcon(new ImageIcon(h3));
					card++;
					
					d_value1 = 3;
				}
				else if (deck[card].equals("s3"))
				{
					cards1.setIcon(new ImageIcon(s3));
					card++;
					
					d_value1 = 3;
				}
				else if (deck[card].equals("c4"))
				{
					cards1.setIcon(new ImageIcon(c4));
					card++;
					
					d_value1 = 4;
				}
				else if (deck[card].equals("d4"))
				{
					cards1.setIcon(new ImageIcon(d4));
					card++;
					
					d_value1 = 4;
				}
				else if (deck[card].equals("h4"))
				{
					cards1.setIcon(new ImageIcon(h4));
					card++;
					
					d_value1 = 4;
				}
				else if (deck[card].equals("s4"))
				{
					cards1.setIcon(new ImageIcon(s4));
					card++;
					
					d_value1 = 4;
				}
				else if (deck[card].equals("c5"))
				{
					cards1.setIcon(new ImageIcon(c5));
					card++;
					
					d_value1 = 5;
				}
				else if (deck[card].equals("d5"))
				{
					cards1.setIcon(new ImageIcon(d5));
					card++;
					
					d_value1 = 5;
				}
				else if (deck[card].equals("h5"))
				{
					cards1.setIcon(new ImageIcon(h5));
					card++;
					
					d_value1 = 5;
				}
				else if (deck[card].equals("s5"))
				{
					cards1.setIcon(new ImageIcon(s5));
					card++;
					
					d_value1 = 5;
				}
				else if (deck[card].equals("c6"))
				{
					cards1.setIcon(new ImageIcon(c6));
					card++;
					
					d_value1 = 6;
				}
				else if (deck[card].equals("d6"))
				{
					cards1.setIcon(new ImageIcon(d6));
					card++;
					
					d_value1 = 6;
				}
				else if (deck[card].equals("h6"))
				{
					cards1.setIcon(new ImageIcon(h6));
					card++;
					
					d_value1 = 6;
				}
				else if (deck[card].equals("s6"))
				{
					cards1.setIcon(new ImageIcon(s6));
					card++;
					
					d_value1 = 6;
				}
				else if (deck[card].equals("c7"))
				{
					cards1.setIcon(new ImageIcon(c7));
					card++;
					
					d_value1 = 7;
				}
				else if (deck[card].equals("d7"))
				{
					cards1.setIcon(new ImageIcon(d7));
					card++;
					
					d_value1 = 7;
				}
				else if (deck[card].equals("h7"))
				{
					cards1.setIcon(new ImageIcon(h7));
					card++;
					
					d_value1 = 7;
				}
				else if (deck[card].equals("s7"))
				{
					cards1.setIcon(new ImageIcon(s7));
					card++;
					
					d_value1 = 7;
				}
				else if (deck[card].equals("c8"))
				{
					cards1.setIcon(new ImageIcon(c8));
					card++;
					
					d_value1 = 8;
				}
				else if (deck[card].equals("d8"))
				{
					cards1.setIcon(new ImageIcon(d8));
					card++;
					
					d_value1 = 8;
				}
				else if (deck[card].equals("h8"))
				{
					cards1.setIcon(new ImageIcon(h8));
					card++;
					
					d_value1 = 8;
				}
				else if (deck[card].equals("s8"))
				{
					cards1.setIcon(new ImageIcon(s8));
					card++;
					
					d_value1 = 8;
				}
				else if (deck[card].equals("c9"))
				{
					cards1.setIcon(new ImageIcon(c9));
					card++;
					
					d_value1 = 9;
				}
				else if (deck[card].equals("d9"))
				{
					cards1.setIcon(new ImageIcon(d9));
					card++;
					
					d_value1 = 9;
				}
				else if (deck[card].equals("h9"))
				{
					cards1.setIcon(new ImageIcon(h9));
					card++;
					
					d_value1 = 9;
				}
				else if (deck[card].equals("s9"))
				{
					cards1.setIcon(new ImageIcon(s9));
					card++;
					
					d_value1 = 9;
				}
				else if (deck[card].equals("c10"))
				{
					cards1.setIcon(new ImageIcon(c10));
					card++;
					
					d_value1 = 10;
				}
				else if (deck[card].equals("d10"))
				{
					cards1.setIcon(new ImageIcon(d10));
					card++;
					
					d_value1 = 10;
				}
				else if (deck[card].equals("h10"))
				{
					cards1.setIcon(new ImageIcon(h10));
					card++;
					
					d_value1 = 10;
				}
				else if (deck[card].equals("s10"))
				{
					cards1.setIcon(new ImageIcon(s10));
					card++;
					
					d_value1 = 10;
				}
				else if (deck[card].equals("cJ"))
				{
					cards1.setIcon(new ImageIcon(cJ));
					card++;
					
					d_value1 = 10;
				}
				else if (deck[card].equals("dJ"))
				{
					cards1.setIcon(new ImageIcon(dJ));
					card++;
					
					d_value1 = 10;
				}
				else if (deck[card].equals("hJ"))
				{
					cards1.setIcon(new ImageIcon(hJ));
					card++;
					
					d_value1 = 10;
				}
				else if (deck[card].equals("sJ"))
				{
					cards1.setIcon(new ImageIcon(sJ));
					card++;
					
					d_value1 = 10;
				}
				else if (deck[card].equals("cQ"))
				{
					cards1.setIcon(new ImageIcon(cQ));
					card++;
					
					d_value1 = 10;
				}
				else if (deck[card].equals("dQ"))
				{
					cards1.setIcon(new ImageIcon(dQ));
					card++;
					
					d_value1 = 10;
				}
				else if (deck[card].equals("hQ"))
				{
					cards1.setIcon(new ImageIcon(hQ));
					card++;
					
					d_value1 = 10;
				}
				else if (deck[card].equals("sQ"))
				{
					cards1.setIcon(new ImageIcon(sQ));
					card++;
					
					d_value1 = 10;
				}
				else if (deck[card].equals("cK"))
				{
					cards1.setIcon(new ImageIcon(cK));
					card++;
					
					d_value1 = 10;
				}
				else if (deck[card].equals("dK"))
				{
					cards1.setIcon(new ImageIcon(dK));
					card++;
					
					d_value1 = 10;
				}
				else if (deck[card].equals("hK"))
				{
					cards1.setIcon(new ImageIcon(hK));
					card++;
					
					d_value1 = 10;
				}
				else if (deck[card].equals("sK"))
				{
					cards1.setIcon(new ImageIcon(sK));
					card++;
					
					d_value1 = 10;
				}
				else
				{
					cards1.setIcon(new ImageIcon());
					card++;
				}
				
				//The second of the 4 cards is dealt to the Player's card slot
				//This code of 'if-else' statements is for the first random card dealt to the player
				if (deck[card].equals("ac"))
				{
					cards3.setIcon(new ImageIcon(ac));
					card++;
					
					
					
					
					choice = showConfirmDialog(null, "You Got an ACE! Would you like your card to equal 11? Choose 'yes' for 11 and 'no' for 1");
					
					if(choice == 0)
					{
						showMessageDialog(null, "Your Ace Card's Value is '11'");
						ace_valueCp = 11;
						p_value1 = 11;
					}
					else
					{
						showMessageDialog(null, "Your Ace Card's Value Stands as '1'");
						ace_valueCp = 1;
						p_value1 = 1;
					}
					
				}
				else if (deck[card].equals("ad"))
				{
					cards3.setIcon(new ImageIcon(ad));
					card++;
					
					choice = showConfirmDialog(null, "You Got an ACE! Would you like your card to equal 11? Choose 'yes' for 11 and 'no' for 1");
					
					if(choice == 0)
					{
						showMessageDialog(null, "Your Ace Card's Value is '11'");
						ace_valueDp = 11;
						p_value1 = 11;
						
					}
					else
					{
						showMessageDialog(null, "Your Ace Card's Value Stands as '1'");
						ace_valueDp = 1;
						p_value1 = 1;
					}
				}
				else if (deck[card].equals("ah"))
				{
					cards3.setIcon(new ImageIcon(ah));
					card++;
					
					choice = showConfirmDialog(null, "You Got an ACE! Would you like your card to equal 11? Choose 'yes' for 11 and 'no' for 1");
					
					if(choice == 0)
					{
						showMessageDialog(null, "Your Ace Card's Value is '11'");
						ace_valueHp = 11;
						p_value1 = 11;
						
					}
					else
					{
						showMessageDialog(null, "Your Ace Card's Value Stands as '1'");
						ace_valueHp = 1;
						p_value1 = 1;
						
					}
				}
				else if (deck[card].equals("as"))
				{
					cards3.setIcon(new ImageIcon(as));
					card++;
					
					choice = showConfirmDialog(null, "You Got an ACE! Would you like your card to equal 11? Choose 'yes' for 11 and 'no' for 1");
					
					if(choice == 0)
					{
						showMessageDialog(null, "Your Ace Card's Value is '11'");
						ace_valueSp = 11;
						p_value1 = 11;
					}
					else
					{
						showMessageDialog(null, "Your Ace Card's Value Stands as '1'");
						ace_valueSp = 1;
						p_value1 = 1;
					}
				}
				else if (deck[card].equals("c2"))
				{
					cards3.setIcon(new ImageIcon(c2));
					card++;
					p_value1 = 2;
				}
				else if (deck[card].equals("d2"))
				{
					cards3.setIcon(new ImageIcon(d2));
					card++;
					p_value1 = 2;
				}
				else if (deck[card].equals("h2"))
				{
					cards3.setIcon(new ImageIcon(h2));
					card++;
					p_value1 = 2;
				}
				else if (deck[card].equals("s2"))
				{
					cards3.setIcon(new ImageIcon(s2));
					card++;
					p_value1 = 2;
				}
				else if (deck[card].equals("c3"))
				{
					cards3.setIcon(new ImageIcon(c3));
					card++;
					p_value1 = 3;
				}
				else if (deck[card].equals("d3"))
				{
					cards3.setIcon(new ImageIcon(d3));
					card++;
					p_value1 = 3;
				}
				else if (deck[card].equals("h3"))
				{
					cards3.setIcon(new ImageIcon(h3));
					card++;
					p_value1 = 3;
				}
				else if (deck[card].equals("s3"))
				{
					cards3.setIcon(new ImageIcon(s3));
					card++;
					p_value1 = 3;
					
				}
				else if (deck[card].equals("c4"))
				{
					cards3.setIcon(new ImageIcon(c4));
					card++;
					p_value1 = 4;
				}
				else if (deck[card].equals("d4"))
				{
					cards3.setIcon(new ImageIcon(d4));
					card++;
					p_value1 = 4;
				}
				else if (deck[card].equals("h4"))
				{
					cards3.setIcon(new ImageIcon(h4));
					card++;
					p_value1 = 4;
				}
				else if (deck[card].equals("s4"))
				{
					cards3.setIcon(new ImageIcon(s4));
					card++;
					p_value1 = 4;
				}
				else if (deck[card].equals("c5"))
				{
					cards3.setIcon(new ImageIcon(c5));
					card++;
					p_value1 = 5;
				}
				else if (deck[card].equals("d5"))
				{
					cards3.setIcon(new ImageIcon(d5));
					card++;
					p_value1 = 5;
				}
				else if (deck[card].equals("h5"))
				{
					cards3.setIcon(new ImageIcon(h5));
					card++;
					p_value1 = 5;
				}
				else if (deck[card].equals("s5"))
				{
					cards3.setIcon(new ImageIcon(s5));
					card++;
					p_value1 = 5;
				}
				else if (deck[card].equals("c6"))
				{
					cards3.setIcon(new ImageIcon(c6));
					card++;
					p_value1 = 6;
				}
				else if (deck[card].equals("d6"))
				{
					cards3.setIcon(new ImageIcon(d6));
					card++;
					p_value1 = 6;
				}
				else if (deck[card].equals("h6"))
				{
					cards3.setIcon(new ImageIcon(h6));
					card++;
					p_value1 = 6;
				}
				else if (deck[card].equals("s6"))
				{
					cards3.setIcon(new ImageIcon(s6));
					card++;
					p_value1 = 6;
				}
				else if (deck[card].equals("c7"))
				{
					cards3.setIcon(new ImageIcon(c7));
					card++;
					p_value1 = 7;
				}
				else if (deck[card].equals("d7"))
				{
					cards3.setIcon(new ImageIcon(d7));
					card++;
					p_value1 = 7;
				}
				else if (deck[card].equals("h7"))
				{
					cards3.setIcon(new ImageIcon(h7));
					card++;
					p_value1 = 7;
				}
				else if (deck[card].equals("s7"))
				{
					cards3.setIcon(new ImageIcon(s7));
					card++;
					p_value1 = 7;
				}
				else if (deck[card].equals("c8"))
				{
					cards3.setIcon(new ImageIcon(c8));
					card++;
					p_value1 = 8;
				}
				else if (deck[card].equals("d8"))
				{
					cards3.setIcon(new ImageIcon(d8));
					card++;
					p_value1 = 8;
				}
				else if (deck[card].equals("h8"))
				{
					cards3.setIcon(new ImageIcon(h8));
					card++;
					p_value1 = 8;
				}
				else if (deck[card].equals("s8"))
				{
					cards3.setIcon(new ImageIcon(s8));
					card++;
					p_value1 = 8;
				}
				else if (deck[card].equals("c9"))
				{
					cards3.setIcon(new ImageIcon(c9));
					card++;
					p_value1 = 9;
				}
				else if (deck[card].equals("d9"))
				{
					cards3.setIcon(new ImageIcon(d9));
					card++;
					p_value1 = 9;
				}
				else if (deck[card].equals("h9"))
				{
					cards3.setIcon(new ImageIcon(h9));
					card++;
					p_value1 = 9;
				}
				else if (deck[card].equals("s9"))
				{
					cards3.setIcon(new ImageIcon(s9));
					card++;
					p_value1 = 9;
				}
				else if (deck[card].equals("c10"))
				{
					cards3.setIcon(new ImageIcon(c10));
					card++;
					p_value1 = 10;
				}
				else if (deck[card].equals("d10"))
				{
					cards3.setIcon(new ImageIcon(d10));
					card++;
					p_value1 = 10;
				}
				else if (deck[card].equals("h10"))
				{
					cards3.setIcon(new ImageIcon(h10));
					card++;
					p_value1 = 10;
				}
				else if (deck[card].equals("s10"))
				{
					cards3.setIcon(new ImageIcon(s10));
					card++;
					p_value1 = 10;
				}
				else if (deck[card].equals("cJ"))
				{
					cards3.setIcon(new ImageIcon(cJ));
					card++;
					p_value1 = 10;
				}
				else if (deck[card].equals("dJ"))
				{
					cards3.setIcon(new ImageIcon(dJ));
					card++;
					p_value1 = 10;
				}
				else if (deck[card].equals("hJ"))
				{
					cards3.setIcon(new ImageIcon(hJ));
					card++;
					p_value1 = 10;
				}
				else if (deck[card].equals("sJ"))
				{
					cards3.setIcon(new ImageIcon(sJ));
					card++;
					p_value1 = 10;
				}
				else if (deck[card].equals("cQ"))
				{
					cards3.setIcon(new ImageIcon(cQ));
					card++;
					p_value1 = 10;
				}
				else if (deck[card].equals("dQ"))
				{
					cards3.setIcon(new ImageIcon(dQ));
					card++;
					p_value1 = 10;
				}
				else if (deck[card].equals("hQ"))
				{
					cards3.setIcon(new ImageIcon(hQ));
					card++;
					p_value1 = 10;
				}
				else if (deck[card].equals("sQ"))
				{
					cards3.setIcon(new ImageIcon(sQ));
					card++;
					p_value1 = 10;
				}
				else if (deck[card].equals("cK"))
				{
					cards3.setIcon(new ImageIcon(cK));
					card++;
					p_value1 = 10;
				}
				else if (deck[card].equals("dK"))
				{
					cards3.setIcon(new ImageIcon(dK));
					card++;
					p_value1 = 10;
				}
				else if (deck[card].equals("hK"))
				{
					cards3.setIcon(new ImageIcon(hK));
					card++;
					p_value1 = 10;
				}
				else if (deck[card].equals("sK"))
				{
					cards3.setIcon(new ImageIcon(sK));
					card++;
					p_value1 = 10;
				}
				else
				{
					cards3.setIcon(new ImageIcon());
					card++;
				}
				
				
				
				//The third of the 4 cards is dealt to Dealer's card slot
				//This code is all for the second random card dealt to the dealer
				cardBack.setIcon(new ImageIcon(back));
				if (deck[card].equals("ac"))
				{
					cards2.setIcon(new ImageIcon(ac));
					card++;
					
					d_value2 = 11;
				}
				else if (deck[card].equals("ad"))
				{
					cards2.setIcon(new ImageIcon(ad));
					card++;
					d_value2 = 11;
				}
				else if (deck[card].equals("ah"))
				{
					cards2.setIcon(new ImageIcon(ah));
					card++;
					d_value2 = 11;
				}
				else if (deck[card].equals("as"))
				{
					cards2.setIcon(new ImageIcon(as));
					card++;
					d_value2 = 11;
				}
				else if (deck[card].equals("c2"))
				{
					cards2.setIcon(new ImageIcon(c2));
					card++;
					d_value2 = 2;
				}
				else if (deck[card].equals("d2"))
				{
					cards2.setIcon(new ImageIcon(d2));
					card++;
					d_value2 = 2;
				}
				else if (deck[card].equals("h2"))
				{
					cards2.setIcon(new ImageIcon(h2));
					card++;
					d_value2 = 2;
				}
				else if (deck[card].equals("s2"))
				{
					cards2.setIcon(new ImageIcon(s2));
					card++;
					d_value2 = 2;
				}
				else if (deck[card].equals("c3"))
				{
					cards2.setIcon(new ImageIcon(c3));
					card++;
					d_value2 = 3;
				}
				else if (deck[card].equals("d3"))
				{
					cards2.setIcon(new ImageIcon(d3));
					card++;
					d_value2 = 3;
				}
				else if (deck[card].equals("h3"))
				{
					cards2.setIcon(new ImageIcon(h3));
					card++;
					d_value2 = 3;
				}
				else if (deck[card].equals("s3"))
				{
					cards2.setIcon(new ImageIcon(s3));
					card++;
					d_value2 = 3;
				}
				else if (deck[card].equals("c4"))
				{
					cards2.setIcon(new ImageIcon(c4));
					card++;
					d_value2 = 4;
				}
				else if (deck[card].equals("d4"))
				{
					cards2.setIcon(new ImageIcon(d4));
					card++;
					d_value2 = 4;
				}
				else if (deck[card].equals("h4"))
				{
					cards2.setIcon(new ImageIcon(h4));
					card++;
					d_value2 = 4;
				}
				else if (deck[card].equals("s4"))
				{
					cards2.setIcon(new ImageIcon(s4));
					card++;
					d_value2 = 4;
				}
				else if (deck[card].equals("c5"))
				{
					cards2.setIcon(new ImageIcon(c5));
					card++;
					d_value2 = 5;
				}
				else if (deck[card].equals("d5"))
				{
					cards2.setIcon(new ImageIcon(d5));
					card++;
					d_value2 = 5;
				}
				else if (deck[card].equals("h5"))
				{
					cards2.setIcon(new ImageIcon(h5));
					card++;
					d_value2 = 5;
				}
				else if (deck[card].equals("s5"))
				{
					cards2.setIcon(new ImageIcon(s5));
					card++;
					d_value2 = 5;
				}
				else if (deck[card].equals("c6"))
				{
					cards2.setIcon(new ImageIcon(c6));
					card++;
					d_value2 = 6;
				}
				else if (deck[card].equals("d6"))
				{
					cards2.setIcon(new ImageIcon(d6));
					card++;
					d_value2 = 6;
				}
				else if (deck[card].equals("h6"))
				{
					cards2.setIcon(new ImageIcon(h6));
					card++;
					d_value2 = 6;
				}
				else if (deck[card].equals("s6"))
				{
					cards2.setIcon(new ImageIcon(s6));
					card++;
					d_value2 = 6;
				}
				else if (deck[card].equals("c7"))
				{
					cards2.setIcon(new ImageIcon(c7));
					card++;
					d_value2 = 7;
				}
				else if (deck[card].equals("d7"))
				{
					cards2.setIcon(new ImageIcon(d7));
					card++;
					d_value2 = 7;
				}
				else if (deck[card].equals("h7"))
				{
					cards2.setIcon(new ImageIcon(h7));
					card++;
					d_value2 = 7;
				}
				else if (deck[card].equals("s7"))
				{
					cards2.setIcon(new ImageIcon(s7));
					card++;
					d_value2 = 7;
				}
				else if (deck[card].equals("c8"))
				{
					cards2.setIcon(new ImageIcon(c8));
					card++;
					d_value2 = 8;
				}
				else if (deck[card].equals("d8"))
				{
					cards2.setIcon(new ImageIcon(d8));
					card++;
					d_value2 = 8;
				}
				else if (deck[card].equals("h8"))
				{
					cards2.setIcon(new ImageIcon(h8));
					card++;
					d_value2 = 8;
				}
				else if (deck[card].equals("s8"))
				{
					cards2.setIcon(new ImageIcon(s8));
					card++;
					d_value2 = 8;
				}
				else if (deck[card].equals("c9"))
				{
					cards2.setIcon(new ImageIcon(c9));
					card++;
					d_value2 = 9;
				}
				else if (deck[card].equals("d9"))
				{
					cards2.setIcon(new ImageIcon(d9));
					card++;
					d_value2 = 9;
				}
				else if (deck[card].equals("h9"))
				{
					cards2.setIcon(new ImageIcon(h9));
					card++;
					d_value2 = 9;
				}
				else if (deck[card].equals("s9"))
				{
					cards2.setIcon(new ImageIcon(s9));
					card++;
					d_value2 = 9;
				}
				else if (deck[card].equals("c10"))
				{
					cards2.setIcon(new ImageIcon(c10));
					card++;
					d_value2 = 10;
				}
				else if (deck[card].equals("d10"))
				{
					cards2.setIcon(new ImageIcon(d10));
					card++;
					d_value2 = 10;
				}
				else if (deck[card].equals("h10"))
				{
					cards2.setIcon(new ImageIcon(h10));
					card++;
					d_value2 = 10;
				}
				else if (deck[card].equals("s10"))
				{
					cards2.setIcon(new ImageIcon(s10));
					card++;
					d_value2 = 10;
				}
				else if (deck[card].equals("cJ"))
				{
					cards2.setIcon(new ImageIcon(cJ));
					card++;
					d_value2 = 10;
				}
				else if (deck[card].equals("dJ"))
				{
					cards2.setIcon(new ImageIcon(dJ));
					card++;
					d_value2 = 10;
				}
				else if (deck[card].equals("hJ"))
				{
					cards2.setIcon(new ImageIcon(hJ));
					card++;
					d_value2 = 10;
				}
				else if (deck[card].equals("sJ"))
				{
					cards2.setIcon(new ImageIcon(sJ));
					card++;
					d_value2 = 10;
				}
				else if (deck[card].equals("cQ"))
				{
					cards2.setIcon(new ImageIcon(cQ));
					card++;
					d_value2 = 10;
				}
				else if (deck[card].equals("dQ"))
				{
					cards2.setIcon(new ImageIcon(dQ));
					card++;
					d_value2 = 10;
				}
				else if (deck[card].equals("hQ"))
				{
					cards2.setIcon(new ImageIcon(hQ));
					card++;
					d_value2 = 10;
				}
				else if (deck[card].equals("sQ"))
				{
					cards2.setIcon(new ImageIcon(sQ));
					card++;
					d_value2 = 10;
				}
				else if (deck[card].equals("cK"))
				{
					cards2.setIcon(new ImageIcon(cK));
					card++;
					d_value2 = 10;
				}
				else if (deck[card].equals("dK"))
				{
					cards2.setIcon(new ImageIcon(dK));
					card++;
					d_value2 = 10;
				}
				else if (deck[card].equals("hK"))
				{
					cards2.setIcon(new ImageIcon(hK));
					card++;
					d_value2 = 10;
				}
				else if (deck[card].equals("sK"))
				{
					cards2.setIcon(new ImageIcon(sK));
					card++;
					d_value2 = 10;
				}
				else
				{
					cards2.setIcon(new ImageIcon());
					card++;
				}
				
				
				//The last of the 4 cards is dealt to the Player's card slot
				//This code of 'if-else' statements is for the second random card dealt to the player
				if (deck[card].equals("ac"))
				{
					cards4.setIcon(new ImageIcon(ac));
					card++;
					
					
					
					
					choice = showConfirmDialog(null, "You Got an ACE! Would you like your card to equal 11? Choose 'yes' for 11 and 'no' for 1");
					
					if(choice == 0)
					{
						showMessageDialog(null, "Your Ace Card's Value is '11'");
						ace_valueCp = 11;
						p_value2 = 11;
					}
					else
					{
						showMessageDialog(null, "Your Ace Card's Value Stands as '1'");
						ace_valueCp = 1;
						p_value2 = 1;
					}
					
				}
				else if (deck[card].equals("ad"))
				{
					cards4.setIcon(new ImageIcon(ad));
					card++;
					
					choice = showConfirmDialog(null, "You Got an ACE! Would you like your card to equal 11? Choose 'yes' for 11 and 'no' for 1");
					
					if(choice == 0)
					{
						showMessageDialog(null, "Your Ace Card's Value is '11'");
						ace_valueDp = 11;
						p_value2 = 11;
						
					}
					else
					{
						showMessageDialog(null, "Your Ace Card's Value Stands as '1'");
						ace_valueDp = 1;
						p_value2 = 1;
					}
				}
				else if (deck[card].equals("ah"))
				{
					cards4.setIcon(new ImageIcon(ah));
					card++;
					
					choice = showConfirmDialog(null, "You Got an ACE! Would you like your card to equal 11? Choose 'yes' for 11 and 'no' for 1");
					
					if(choice == 0)
					{
						showMessageDialog(null, "Your Ace Card's Value is '11'");
						ace_valueHp = 11;
						p_value2 = 11;
						
					}
					else
					{
						showMessageDialog(null, "Your Ace Card's Value Stands as '1'");
						ace_valueHp = 1;
						p_value2 = 1;
					}
				}
				else if (deck[card].equals("as"))
				{
					cards4.setIcon(new ImageIcon(as));
					card++;
					
					choice = showConfirmDialog(null, "You Got an ACE! Would you like your card to equal 11? Choose 'yes' for 11 and 'no' for 1");
					
					if(choice == 0)
					{
						showMessageDialog(null, "Your Ace Card's Value is '11'");
						ace_valueSp = 11;
						p_value2 = 11;
						
					}
					else
					{
						showMessageDialog(null, "Your Ace Card's Value Stands as '1'");
						ace_valueSp = 1;
						p_value2 = 1;
					}
				}
				else if (deck[card].equals("c2"))
				{
					cards4.setIcon(new ImageIcon(c2));
					card++;
					p_value2 = 2;
				}
				else if (deck[card].equals("d2"))
				{
					cards4.setIcon(new ImageIcon(d2));
					card++;
					p_value2 = 2;
				}
				else if (deck[card].equals("h2"))
				{
					cards4.setIcon(new ImageIcon(h2));
					card++;
					p_value2 = 2;
				}
				else if (deck[card].equals("s2"))
				{
					cards4.setIcon(new ImageIcon(s2));
					card++;
					p_value2 = 2;
				}
				else if (deck[card].equals("c3"))
				{
					cards4.setIcon(new ImageIcon(c3));
					card++;
					p_value2 = 3;
				}
				else if (deck[card].equals("d3"))
				{
					cards4.setIcon(new ImageIcon(d3));
					card++;
					p_value2 = 3;
				}
				else if (deck[card].equals("h3"))
				{
					cards4.setIcon(new ImageIcon(h3));
					card++;
					p_value2 = 3;
				}
				else if (deck[card].equals("s3"))
				{
					cards4.setIcon(new ImageIcon(s3));
					card++;
					p_value2 = 3;
				}
				else if (deck[card].equals("c4"))
				{
					cards4.setIcon(new ImageIcon(c4));
					card++;
					p_value2 = 4;
				}
				else if (deck[card].equals("d4"))
				{
					cards4.setIcon(new ImageIcon(d4));
					card++;
					p_value2 = 4;
				}
				else if (deck[card].equals("h4"))
				{
					cards4.setIcon(new ImageIcon(h4));
					card++;
					p_value2 = 4;
				}
				else if (deck[card].equals("s4"))
				{
					cards4.setIcon(new ImageIcon(s4));
					card++;
					p_value2 = 4;
				}
				else if (deck[card].equals("c5"))
				{
					cards4.setIcon(new ImageIcon(c5));
					card++;
					p_value2 = 5;
				}
				else if (deck[card].equals("d5"))
				{
					cards4.setIcon(new ImageIcon(d5));
					card++;
					p_value2 = 5;
				}
				else if (deck[card].equals("h5"))
				{
					cards4.setIcon(new ImageIcon(h5));
					card++;
					p_value2 = 5;
				}
				else if (deck[card].equals("s5"))
				{
					cards4.setIcon(new ImageIcon(s5));
					card++;
					p_value2 = 5;
				}
				else if (deck[card].equals("c6"))
				{
					cards4.setIcon(new ImageIcon(c6));
					card++;
					p_value2 = 6;
				}
				else if (deck[card].equals("d6"))
				{
					cards4.setIcon(new ImageIcon(d6));
					card++;
					p_value2 = 6;
				}
				else if (deck[card].equals("h6"))
				{
					cards4.setIcon(new ImageIcon(h6));
					card++;
					p_value2 = 6;
				}
				else if (deck[card].equals("s6"))
				{
					cards4.setIcon(new ImageIcon(s6));
					card++;
					p_value2 = 6;
				}
				else if (deck[card].equals("c7"))
				{
					cards4.setIcon(new ImageIcon(c7));
					card++;
					p_value2 = 7;
				}
				else if (deck[card].equals("d7"))
				{
					cards4.setIcon(new ImageIcon(d7));
					card++;
					p_value2 = 7;
				}
				else if (deck[card].equals("h7"))
				{
					cards4.setIcon(new ImageIcon(h7));
					card++;
					p_value2 = 7;
				}
				else if (deck[card].equals("s7"))
				{
					cards4.setIcon(new ImageIcon(s7));
					card++;
					p_value2 = 7;
				}
				else if (deck[card].equals("c8"))
				{
					cards4.setIcon(new ImageIcon(c8));
					card++;
					p_value2 = 8;
				}
				else if (deck[card].equals("d8"))
				{
					cards4.setIcon(new ImageIcon(d8));
					card++;
					p_value2 = 8;
				}
				else if (deck[card].equals("h8"))
				{
					cards4.setIcon(new ImageIcon(h8));
					card++;
					p_value2 = 8;
				}
				else if (deck[card].equals("s8"))
				{
					cards4.setIcon(new ImageIcon(s8));
					card++;
					p_value2 = 8;
				}
				else if (deck[card].equals("c9"))
				{
					cards4.setIcon(new ImageIcon(c9));
					card++;
					p_value2 = 9;
				}
				else if (deck[card].equals("d9"))
				{
					cards4.setIcon(new ImageIcon(d9));
					card++;
					p_value2 = 9;
				}
				else if (deck[card].equals("h9"))
				{
					cards4.setIcon(new ImageIcon(h9));
					card++;
					p_value2 = 9;
				}
				else if (deck[card].equals("s9"))
				{
					cards4.setIcon(new ImageIcon(s9));
					card++;
					p_value2 = 9;
				}
				else if (deck[card].equals("c10"))
				{
					cards4.setIcon(new ImageIcon(c10));
					card++;
					p_value2 = 10;
				}
				else if (deck[card].equals("d10"))
				{
					cards4.setIcon(new ImageIcon(d10));
					card++;
					p_value2 = 10;
				}
				else if (deck[card].equals("h10"))
				{
					cards4.setIcon(new ImageIcon(h10));
					card++;
					p_value2 = 10;
				}
				else if (deck[card].equals("s10"))
				{
					cards4.setIcon(new ImageIcon(s10));
					card++;
					p_value2 = 10;
				}
				else if (deck[card].equals("cJ"))
				{
					cards4.setIcon(new ImageIcon(cJ));
					card++;
					p_value2 = 10;
				}
				else if (deck[card].equals("dJ"))
				{
					cards4.setIcon(new ImageIcon(dJ));
					card++;
					p_value2 = 10;
				}
				else if (deck[card].equals("hJ"))
				{
					cards4.setIcon(new ImageIcon(hJ));
					card++;
					p_value2 = 10;
				}
				else if (deck[card].equals("sJ"))
				{
					cards4.setIcon(new ImageIcon(sJ));
					card++;
					p_value2 = 10;
				}
				else if (deck[card].equals("cQ"))
				{
					cards4.setIcon(new ImageIcon(cQ));
					card++;
					p_value2 = 10;
				}
				else if (deck[card].equals("dQ"))
				{
					cards4.setIcon(new ImageIcon(dQ));
					card++;
					p_value2 = 10;
				}
				else if (deck[card].equals("hQ"))
				{
					cards4.setIcon(new ImageIcon(hQ));
					card++;
					p_value2 = 10;
				}
				else if (deck[card].equals("sQ"))
				{
					cards4.setIcon(new ImageIcon(sQ));
					card++;
					p_value2 = 10;
				}
				else if (deck[card].equals("cK"))
				{
					cards4.setIcon(new ImageIcon(cK));
					card++;
					p_value2 = 10;
				}
				else if (deck[card].equals("dK"))
				{
					cards4.setIcon(new ImageIcon(dK));
					card++;
					p_value2 = 10;
				}
				else if (deck[card].equals("hK"))
				{
					cards4.setIcon(new ImageIcon(hK));
					card++;
					p_value2 = 10;
				}
				else if (deck[card].equals("sK"))
				{
					cards4.setIcon(new ImageIcon(sK));
					card++;
					p_value2 = 10;
				}
				else
				{
					cards4.setIcon(new ImageIcon());
					card++;
				}
				
				p_total = p_value1+p_value2;
				d_total = d_value1+d_value2;
				
					
				
				handValue.setText(String.valueOf(p_total));
				
				if(d_total == 0)
				{
					numberbox.setIcon(new ImageIcon(n0));
				}
				else if (d_total == 1)
				{
					numberbox.setIcon(new ImageIcon(n1));
				}
				else if (d_total == 2)
				{
					numberbox.setIcon(new ImageIcon(n2));
				}
				else if (d_total == 3)
				{
					numberbox.setIcon(new ImageIcon(n3));
				}
				else if (d_total == 4)
				{
					numberbox.setIcon(new ImageIcon(n4));
				}
				else if (d_total == 5)
				{
					numberbox.setIcon(new ImageIcon(n5));
				}
				else if (d_total == 6)
				{
					numberbox.setIcon(new ImageIcon(n6));
				}
				else if (d_total == 7)
				{
					numberbox.setIcon(new ImageIcon(n7));
				}
				else if (d_total == 8)
				{
					numberbox.setIcon(new ImageIcon(n8));
				}
				else if (d_total == 9)
				{
					numberbox.setIcon(new ImageIcon(n9));
				}
				else if (d_total == 10)
				{
					numberbox.setIcon(new ImageIcon(n10));
				}
				else if (d_total == 11)
				{
					numberbox.setIcon(new ImageIcon(n11));
				}
				else if (d_total == 12)
				{
					numberbox.setIcon(new ImageIcon(n12));
				}
				else if (d_total == 13)
				{
					numberbox.setIcon(new ImageIcon(n13));
				}
				else if (d_total == 14)
				{
					numberbox.setIcon(new ImageIcon(n14));
				}
				else if (d_total == 15)
				{
					numberbox.setIcon(new ImageIcon(n15));
				}
				else if (d_total == 16)
				{
					numberbox.setIcon(new ImageIcon(n16));
				}
				else if (d_total == 17)
				{
					numberbox.setIcon(new ImageIcon(n17));
				}
				else if (d_total == 18)
				{
					numberbox.setIcon(new ImageIcon(n18));
				}
				else if (d_total == 19)
				{
					numberbox.setIcon(new ImageIcon(n19));
				}
				else if (d_total == 20)
				{
					numberbox.setIcon(new ImageIcon(n20));
				}
				else if (d_total == 21)
				{
					numberbox.setIcon(new ImageIcon(n21));
				}
				else if (d_total == 22)
				{
					numberbox.setIcon(new ImageIcon(n22));
				}
				else if (d_total == 23)
				{
					numberbox.setIcon(new ImageIcon(n23));
				}
				else if (d_total == 24)
				{
					numberbox.setIcon(new ImageIcon(n24));
				}
				else if (d_total == 25)
				{
					numberbox.setIcon(new ImageIcon(n25));
				}
				else if (d_total == 26)
				{
					numberbox.setIcon(new ImageIcon(n26));
				}
				else if (d_total == 27)
				{
					numberbox.setIcon(new ImageIcon(n27));
				}
				else if (d_total == 28)
				{
					numberbox.setIcon(new ImageIcon(n28));
				}
				else if (d_total == 29)
				{
					numberbox.setIcon(new ImageIcon(n29));
				}
				else if (d_total == 30)
				{
					numberbox.setIcon(new ImageIcon(n30));
				}
				else if (d_total == 31)
				{
					numberbox.setIcon(new ImageIcon(n31));
				}
				else if (d_total == 32)
				{
					numberbox.setIcon(new ImageIcon(n32));
				}
				else
				{
					numberbox.setIcon(new ImageIcon());
				}
					
				
				if(p_total == 0)
				{
					numberbox2.setIcon(new ImageIcon(n0));
				}
				else if (p_total == 1)
				{
					numberbox2.setIcon(new ImageIcon(n1));
				}
				else if (p_total == 2)
				{
					numberbox2.setIcon(new ImageIcon(n2));
				}
				else if (p_total == 3)
				{
					numberbox2.setIcon(new ImageIcon(n3));
				}
				else if (p_total == 4)
				{
					numberbox2.setIcon(new ImageIcon(n4));
				}
				else if (p_total == 5)
				{
					numberbox2.setIcon(new ImageIcon(n5));
				}
				else if (p_total == 6)
				{
					numberbox2.setIcon(new ImageIcon(n6));
				}
				else if (p_total == 7)
				{
					numberbox2.setIcon(new ImageIcon(n7));
				}
				else if (p_total == 8)
				{
					numberbox2.setIcon(new ImageIcon(n8));
				}
				else if (p_total == 9)
				{
					numberbox2.setIcon(new ImageIcon(n9));
				}
				else if (p_total == 10)
				{
					numberbox2.setIcon(new ImageIcon(n10));
				}
				else if (p_total == 11)
				{
					numberbox2.setIcon(new ImageIcon(n11));
				}
				else if (p_total == 12)
				{
					numberbox2.setIcon(new ImageIcon(n12));
				}
				else if (p_total == 13)
				{
					numberbox2.setIcon(new ImageIcon(n13));
				}
				else if (p_total == 14)
				{
					numberbox2.setIcon(new ImageIcon(n14));
				}
				else if (p_total == 15)
				{
					numberbox2.setIcon(new ImageIcon(n15));
				}
				else if (p_total == 16)
				{
					numberbox2.setIcon(new ImageIcon(n16));
				}
				else if (p_total == 17)
				{
					numberbox2.setIcon(new ImageIcon(n17));
				}
				else if (p_total == 18)
				{
					numberbox2.setIcon(new ImageIcon(n18));
				}
				else if (p_total == 19)
				{
					numberbox2.setIcon(new ImageIcon(n19));
				}
				else if (p_total == 20)
				{
					numberbox2.setIcon(new ImageIcon(n20));
				}
				else if (p_total == 21)
				{
					numberbox2.setIcon(new ImageIcon(n21));
				}
				else if (p_total == 22)
				{
					numberbox2.setIcon(new ImageIcon(n22));
				}
				else if (p_total == 23)
				{
					numberbox2.setIcon(new ImageIcon(n23));
				}
				else if (p_total == 24)
				{
					numberbox2.setIcon(new ImageIcon(n24));
				}
				else if (p_total == 25)
				{
					numberbox2.setIcon(new ImageIcon(n25));
				}
				else if (p_total == 26)
				{
					numberbox2.setIcon(new ImageIcon(n26));
				}
				else if (p_total == 27)
				{
					numberbox2.setIcon(new ImageIcon(n27));
				}
				else if (p_total == 28)
				{
					numberbox2.setIcon(new ImageIcon(n28));
				}
				else if (p_total == 29)
				{
					numberbox2.setIcon(new ImageIcon(n29));
				}
				else if (p_total == 30)
				{
					numberbox2.setIcon(new ImageIcon(n30));
				}
				else if (p_total == 31)
				{
					numberbox2.setIcon(new ImageIcon(n29));
				}
				else if (p_total == 32)
				{
					numberbox2.setIcon(new ImageIcon(n32));
				}
				else
				{
					numberbox2.setIcon(new ImageIcon());
				} 
				
					if(p_total == 21 && d_total != 21)
					{
						cardBack.setIcon(new ImageIcon());
						scoreHide.setIcon(new ImageIcon());
						JOptionPane.showMessageDialog(frame, "You got BLACKJACK! YOU WIN YOUR BET and BEAT THE DEALER!");
						
						bet *= 1.5;
						balance += bet;
						bet = 0;
						options = 1;
						d_switch = false;
						betlbl.setText(String.valueOf(bet));
						balancelbl.setText(String.valueOf(balance));
						JOptionPane.showMessageDialog(frame, "Your winnings have been applied to your new balance!");
						
						
					}
					else if (p_total == 21 && d_total == 21)
					{
						cardBack.setIcon(new ImageIcon());
						scoreHide.setIcon(new ImageIcon());
						JOptionPane.showMessageDialog(frame, "TIE! Both you and the Dealer have BLACKJACK. Your bet will be given back.");
						
						bet = 0;
						options = 1;
						d_switch = false;
						
						betlbl.setText(String.valueOf(bet));
						balancelbl.setText(String.valueOf(balance));
					}
					else
					{
						
					}
				
				
				
				}
				else
				{
					shuffletracker = 0;
					
					JOptionPane.showMessageDialog(frame, "65% of the Cards has been used. Reshuffling Deck!");
					
					if(shuffletracker == 0)
					{
						shuffle(deck);
						card = 0;
						shuffletracker = 1;
					}
					
					card = 0;
					
					numberbox.setIcon(new ImageIcon(n0));
					numberbox2.setIcon(new ImageIcon(n0));
					
					cards1.setIcon(new ImageIcon());
					cards2.setIcon(new ImageIcon());
					cards3.setIcon(new ImageIcon());
					cards4.setIcon(new ImageIcon());
					
					JOptionPane.showMessageDialog(frame, "Deck has been Reshuffled!  Press 'Deal' to begin!");
					d_switch = false;
					options = 1;
					dealNumber = 0;
				}
				 	
					firstDeal = 1;
					if (d_switch == true)
					{
						dealNumber = 1;
					}
					else
					{
						dealNumber = 0;
					}
					
					
					if(b == true)
					{
						options = 1;

					}
					else
					{
						options = 0;
					}
				
				}
				else if (options == 0)
				{
					JOptionPane.showMessageDialog(frame, "To Deal another hand, you must choose one of the Player Options!");
				}
				else
				{
					
				}
				
				  
				  
				  
				 
			}
			
			
			
			
			
		});
		btnDeal.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
		btnDeal.setBounds(328, 652, 256, 129);
		panelGame.add(btnDeal);
		
		Image rules = new ImageIcon(this.getClass().getResource("/rules.png")).getImage();
		JButton btnRules = new JButton("");
		btnRules.setIcon(new ImageIcon(rules));
		btnRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Ruleboard screenobj = new Ruleboard();
				screenobj.NewScreen();
				
			}
		});
		btnRules.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
		btnRules.setBounds(593, 652, 256, 129);
		panelGame.add(btnRules);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_5.setBounds(6, 550, 276, 40);
		panelGame.add(panel_5);
		
		JLabel lblPlayerInformation = new JLabel("Player Information");
		lblPlayerInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerInformation.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 14));
		lblPlayerInformation.setBounds(12, 13, 216, 26);
		panel_5.add(lblPlayerInformation);
		
		JLabel lblDealerman = new JLabel("");
		lblDealerman.setBounds(16, 159, 126, 129);
		Image img3 = new ImageIcon(this.getClass().getResource("/blackDealer1.png")).getImage();
		lblDealerman.setIcon(new ImageIcon(img3));
		panelGame.add(lblDealerman);
		
		
		JLabel lblcardholder = new JLabel("");
		lblcardholder.setHorizontalAlignment(SwingConstants.CENTER);
		lblcardholder.setBounds(773, 26, 91, 70);
		Image img8 = new ImageIcon(this.getClass().getResource("/cardholdersm.png")).getImage();
		lblcardholder.setIcon(new ImageIcon(img8));
		panelGame.add(lblcardholder);
		
		JLabel lblProfile = new JLabel("");
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile.setBounds(9, 591, 131, 120);
		Image img9 = new ImageIcon(this.getClass().getResource("/badarse.png")).getImage();
		lblProfile.setIcon(new ImageIcon(img9));
		panelGame.add(lblProfile);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(119, 591, 163, 25);
		panelGame.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblBet = new JLabel("Current Bet:");
		lblBet.setBounds(0, 0, 137, 25);
		panel_6.add(lblBet);
		lblBet.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblBet.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		betlbl.setText(String.valueOf(bet));
		betlbl.setHorizontalAlignment(SwingConstants.CENTER);
		betlbl.setBounds(81, 0, 82, 25);
		panel_6.add(betlbl);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(119, 614, 163, 25);
		panelGame.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblBalance = new JLabel("Balance:");
		lblBalance.setBounds(0, 0, 137, 25);
		panel_7.add(lblBalance);
		lblBalance.setHorizontalAlignment(SwingConstants.LEFT);
		lblBalance.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		
		balancelbl.setText(String.valueOf(balance));
		balancelbl.setHorizontalAlignment(SwingConstants.CENTER);
		balancelbl.setBounds(81, 0, 82, 25);
		panel_7.add(balancelbl);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(119, 640, 163, 25);
		panelGame.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblWin = new JLabel("Winning:");
		lblWin.setBounds(0, 0, 137, 25);
		panel_8.add(lblWin);
		lblWin.setHorizontalAlignment(SwingConstants.LEFT);
		lblWin.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(119, 664, 163, 25);
		panelGame.add(panel_9);
		panel_9.setLayout(null);
		
		
		handValue.setText(String.valueOf(p_total));
		handValue.setHorizontalAlignment(SwingConstants.CENTER);
		handValue.setBounds(81, 0, 82, 25);
		panel_9.add(handValue);
		
		JLabel lblHand = new JLabel("Hand Value:");
		lblHand.setBounds(0, 0, 137, 25);
		panel_9.add(lblHand);
		lblHand.setHorizontalAlignment(SwingConstants.LEFT);
		lblHand.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(848, 13, 100, 77);
		Image img10 = new ImageIcon(this.getClass().getResource("/exileLogosm.png")).getImage();
		lblLogo.setIcon(new ImageIcon(img10));
		panelGame.add(lblLogo);
		
		JLabel lblLogo2 = new JLabel("");
		lblLogo2.setBounds(849, 789, 100, 64);
		Image img11 = new ImageIcon(this.getClass().getResource("/exileLogosm.png")).getImage();
		lblLogo2.setIcon(new ImageIcon(img11));
		panelGame.add(lblLogo2);
		
		
		
		JButton exileHomebtn = new JButton();
		exileHomebtn.setText("Home");
		exileHomebtn.setIcon(new ImageIcon(img11));
		exileHomebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				choice = showConfirmDialog(null, "Are you sure you want to end the current game?");
				
				
				
				if(choice == 0)
				{
					contentPane.setVisible(false);
					Bjack bpage = new Bjack();
					bpage.setVisible(true);
					frame.dispose();
					
					
				}
				else
				{
					showMessageDialog(null, "Returning to Game!");
					
				}
				
			}
		});
		exileHomebtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		exileHomebtn.setBounds(119, 702, 176, 78);
		panelGame.add(exileHomebtn);
		
		JLabel numberBorder = new JLabel("");
		numberBorder.setBounds(268, 109, 80, 80);
		Image numb = new ImageIcon(this.getClass().getResource("/numborder.png")).getImage();
		numberBorder.setIcon(new ImageIcon(numb));
		panelGame.add(numberBorder);
		
		JLabel numberBorder2 = new JLabel("");
		numberBorder2.setBounds(268, 338, 80, 80);
		Image numb2 = new ImageIcon(this.getClass().getResource("/numborder.png")).getImage();
		numberBorder2.setIcon(new ImageIcon(numb2));
		panelGame.add(numberBorder2);
		
		JLabel dealerhand = new JLabel("");
		dealerhand.setHorizontalAlignment(SwingConstants.CENTER);
		dealerhand.setBounds(258, 186, 90, 65);
		Image dealer = new ImageIcon(this.getClass().getResource("/dealerrh.png")).getImage();
		dealerhand.setIcon(new ImageIcon(dealer));
		panelGame.add(dealerhand);
		
		JLabel playerhand = new JLabel("");
		playerhand.setHorizontalAlignment(SwingConstants.CENTER);
		playerhand.setBounds(258, 414, 90, 65);
		Image player = new ImageIcon(this.getClass().getResource("/playerh.png")).getImage();
		playerhand.setIcon(new ImageIcon(player));
		panelGame.add(playerhand);
		
		
	
		
		
		Image chip5 = new ImageIcon(this.getClass().getResource("/chip5.png")).getImage();
		Image chip10 = new ImageIcon(this.getClass().getResource("/chip10.png")).getImage();
		Image chip25 = new ImageIcon(this.getClass().getResource("/chip25.png")).getImage();
		Image chip50 = new ImageIcon(this.getClass().getResource("/chip50.png")).getImage();
		Image chip100 = new ImageIcon(this.getClass().getResource("/chip100n.png")).getImage();
		Image chip500 = new ImageIcon(this.getClass().getResource("/chip500.png")).getImage();
		
		chip5btn.setIcon(new ImageIcon(chip5));
		chip5btn.setBounds(285, 540, 107, 99);
		chip5btn.setFocusPainted(false);
        chip5btn.setMargin(new Insets(0, 0, 0, 0));
        chip5btn.setContentAreaFilled(false);
        chip5btn.setBorderPainted(false);
        chip5btn.setOpaque(false);
		panelGame.add(chip5btn);
		
		glowy5.setHorizontalAlignment(SwingConstants.CENTER);
		glowy5.setBounds(282, 529, 110, 120);
		panelGame.add(glowy5);
		chip5btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (d_switch == true)
				{
					JOptionPane.showMessageDialog(frame, "You cannot bet more money while in a deal play phase until you win/lose your intial bet!");
				}
				else
				{
				glowy5.setIcon(new ImageIcon(glow));
				glowy10.setIcon(new ImageIcon());
				glowy25.setIcon(new ImageIcon());
				glowy50.setIcon(new ImageIcon());
				glowy100.setIcon(new ImageIcon());
				glowy500.setIcon(new ImageIcon());
				canyoubet = balance-bet;
				
				bet += 5;
				betlbl.setText(String.valueOf(bet));
				
				if (canyoubet > -1)
				{
					if(bet > balance)
					{
						JOptionPane.showMessageDialog(frame, "You cannot bet " +bet+ " dollars! Your balance is: " +balance);
						bet -= 5;
						betlbl.setText(String.valueOf(bet));
					}
				}
			}
			}
		});
		
		
		
		
		chip10btn.setIcon(new ImageIcon(chip10));
		chip10btn.setOpaque(false);
		chip10btn.setMargin(new Insets(0, 0, 0, 0));
		chip10btn.setFocusPainted(false);
		chip10btn.setContentAreaFilled(false);
		chip10btn.setBorderPainted(false);
		chip10btn.setBounds(397, 540, 107, 99);
		panelGame.add(chip10btn);
		
		glowy10.setHorizontalAlignment(SwingConstants.CENTER);
		glowy10.setBounds(394, 529, 110, 120);
		panelGame.add(glowy10);
		chip10btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (d_switch == true)
				{
					JOptionPane.showMessageDialog(frame, "You cannot bet more money while in a deal play phase until you win/lose your intial bet!");
				}
				else
				{
					glowy5.setIcon(new ImageIcon());
					glowy10.setIcon(new ImageIcon(glow));
					glowy25.setIcon(new ImageIcon());
					glowy50.setIcon(new ImageIcon());
					glowy100.setIcon(new ImageIcon());
					glowy500.setIcon(new ImageIcon());
					canyoubet = balance-bet;
				
					bet += 10;
					betlbl.setText(String.valueOf(bet));
				
					if (canyoubet > -1)
					{
						if(bet > balance)
						{
							JOptionPane.showMessageDialog(frame, "You cannot bet " +bet+ " dollars! Your balance is: " +balance);
							bet -= 10;
							betlbl.setText(String.valueOf(bet));
						}
					}
				}
			}
		});
		
		
		
		chip25btn.setIcon(new ImageIcon(chip25));
		chip25btn.setOpaque(false);
		chip25btn.setMargin(new Insets(0, 0, 0, 0));
		chip25btn.setFocusPainted(false);
		chip25btn.setContentAreaFilled(false);
		chip25btn.setBorderPainted(false);
		chip25btn.setBounds(505, 540, 107, 99);
		panelGame.add(chip25btn);
		
		glowy25.setHorizontalAlignment(SwingConstants.CENTER);
		glowy25.setBounds(505, 529, 110, 120);
		panelGame.add(glowy25);
		chip25btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (d_switch == true)
				{
					JOptionPane.showMessageDialog(frame, "You cannot bet more money while in a deal play phase until you win/lose your intial bet!");
				}
				else
				{
				glowy5.setIcon(new ImageIcon());
				glowy10.setIcon(new ImageIcon());
				glowy25.setIcon(new ImageIcon(glow));
				glowy50.setIcon(new ImageIcon());
				glowy100.setIcon(new ImageIcon());
				glowy500.setIcon(new ImageIcon());
				canyoubet = balance-bet;
				
				bet += 25;
				betlbl.setText(String.valueOf(bet));
				
				if (canyoubet > -1)
				{
					if(bet > balance)
					{
						JOptionPane.showMessageDialog(frame, "You cannot bet " +bet+ " dollars! Your balance is: " +balance);
						bet -= 25;
						betlbl.setText(String.valueOf(bet));
					}
				}
			}
			}
		});
		
		
		
		chip50btn.setIcon(new ImageIcon(chip50));
		chip50btn.setOpaque(false);
		chip50btn.setMargin(new Insets(0, 0, 0, 0));
		chip50btn.setFocusPainted(false);
		chip50btn.setContentAreaFilled(false);
		chip50btn.setBorderPainted(false);
		chip50btn.setBounds(624, 540, 107, 99);
		panelGame.add(chip50btn);
		
		glowy50.setHorizontalAlignment(SwingConstants.CENTER);
		glowy50.setBounds(621, 529, 110, 120);
		panelGame.add(glowy50);
		chip50btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (d_switch == true)
				{
					JOptionPane.showMessageDialog(frame, "You cannot bet more money while in a deal play phase until you win/lose your intial bet!");
				}
				else
				{
				glowy5.setIcon(new ImageIcon());
				glowy10.setIcon(new ImageIcon());
				glowy25.setIcon(new ImageIcon());
				glowy50.setIcon(new ImageIcon(glow));
				glowy100.setIcon(new ImageIcon());
				glowy500.setIcon(new ImageIcon());
				canyoubet = balance-bet;
				
				bet += 50;
				betlbl.setText(String.valueOf(bet));
				
				if (canyoubet > -1)
				{
					if(bet > balance)
					{
						JOptionPane.showMessageDialog(frame, "You cannot bet " +bet+ " dollars! Your balance is: " +balance);
						bet -= 50;
						betlbl.setText(String.valueOf(bet));
					}
				}
			}
			}
		});
		
		
		
		
		chip100btn.setIcon(new ImageIcon(chip100));
		chip100btn.setOpaque(false);
		chip100btn.setMargin(new Insets(0, 0, 0, 0));
		chip100btn.setFocusPainted(false);
		chip100btn.setContentAreaFilled(false);
		chip100btn.setBorderPainted(false);
		chip100btn.setBounds(743, 540, 107, 99);
		panelGame.add(chip100btn);
		
		glowy100.setHorizontalAlignment(SwingConstants.CENTER);
		glowy100.setBounds(743, 529, 110, 120);
		panelGame.add(glowy100);
		
		chip100btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (d_switch == true)
				{
					JOptionPane.showMessageDialog(frame, "You cannot bet more money while in a deal play phase until you win/lose your intial bet!");
				}
				else
				{
				glowy5.setIcon(new ImageIcon());
				glowy10.setIcon(new ImageIcon());
				glowy25.setIcon(new ImageIcon());
				glowy50.setIcon(new ImageIcon());
				glowy100.setIcon(new ImageIcon(glow));
				glowy500.setIcon(new ImageIcon());
				canyoubet = balance-bet;
				
				bet += 100;
				betlbl.setText(String.valueOf(bet));
				
				if (canyoubet > -1)
				{
					if(bet > balance)
					{
						JOptionPane.showMessageDialog(frame, "You cannot bet " +bet+ " dollars! Your balance is: " +balance);
						bet -= 100;
						betlbl.setText(String.valueOf(bet));
					}
				}
			}
			}
		});
		
		
		
		
		
		
		
		chip500btn.setIcon(new ImageIcon(chip500));
		chip500btn.setOpaque(false);
		chip500btn.setMargin(new Insets(0, 0, 0, 0));
		chip500btn.setFocusPainted(false);
		chip500btn.setContentAreaFilled(false);
		chip500btn.setBorderPainted(false);
		chip500btn.setBounds(865, 540, 107, 99);
		panelGame.add(chip500btn);
		
		glowy500.setHorizontalAlignment(SwingConstants.CENTER);
		glowy500.setIcon(new ImageIcon());
		glowy500.setBounds(862, 529, 110, 120);
		panelGame.add(glowy500);
		chip500btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (d_switch == true)
				{
					JOptionPane.showMessageDialog(frame, "You cannot bet more money while in a deal play phase until you win/lose your intial bet!");
				}
				else
				{
				glowy5.setIcon(new ImageIcon());
				glowy10.setIcon(new ImageIcon());
				glowy25.setIcon(new ImageIcon());
				glowy50.setIcon(new ImageIcon());
				glowy100.setIcon(new ImageIcon());
				glowy500.setIcon(new ImageIcon(glow));
				canyoubet = balance-bet;
				
				bet += 500;
				betlbl.setText(String.valueOf(bet));
				
				if (canyoubet > -1)
				{
					if(bet > balance)
					{
						JOptionPane.showMessageDialog(frame, "You cannot bet " +bet+ " dollars! Your balance is: " +balance);
						bet -= 500;
						betlbl.setText(String.valueOf(bet));
					}
				}
				
				
				
			}
			}
		});
		
		
		
		
		
		JLabel borderLine = new JLabel("");
		borderLine.setHorizontalAlignment(SwingConstants.CENTER);
		borderLine.setBounds(0, 384, 983, 267);
		Image line = new ImageIcon(this.getClass().getResource("/fadel.png")).getImage();
		borderLine.setIcon(new ImageIcon(line));
		panelGame.add(borderLine);
		
		JLabel borderLine2 = new JLabel("");
		borderLine2.setHorizontalAlignment(SwingConstants.CENTER);
		borderLine2.setBounds(0, 151, 983, 267);
		Image line2 = new ImageIcon(this.getClass().getResource("/fade2.png")).getImage();
		borderLine2.setIcon(new ImageIcon(line2));
		panelGame.add(borderLine2);
		
		JLabel banner = new JLabel("");
		banner.setHorizontalAlignment(SwingConstants.CENTER);
		banner.setBounds(114, 506, 857, 135);
		Image banner1 = new ImageIcon(this.getClass().getResource("")).getImage();
		banner.setIcon(new ImageIcon(banner1));
		panelGame.add(banner);
		
		
		
		
		
		
		
		JLabel backgroundlbl = new JLabel("");
		backgroundlbl.setHorizontalAlignment(SwingConstants.CENTER);
		Image backy = new ImageIcon(this.getClass().getResource("/greenyyyed2.png")).getImage();
	
		backgroundlbl.setIcon(new ImageIcon(backy));
		backgroundlbl.setBounds(0, -3, 983, 856);
		panelGame.add(backgroundlbl);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 10, 10);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 10, 10);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
	}
}
