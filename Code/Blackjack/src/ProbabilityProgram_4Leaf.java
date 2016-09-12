import java.sql.*;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class ProbabilityProgram_4Leaf
{
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/bj";

   static final String USER = "root";
   static final String PASS = "4leafco";
   
     public static char StrategyMethod(int playerCard1Value, int playerCard2Value, int totalDealer) {

	      /**
	       * P for split
	       * D for double down
	       * H for hit
	       * S for stand
	       */
	      char bestMove = ' ';
	      // int ace = 11 || 1;

	      int totalPlayer = playerCard1Value + playerCard2Value;
	      
	      /*
	      System.out.println("Dealer Total is: " + totalDealer);
	      System.out.println("Player's 1st Card is: " + playerCard1Value);
	      System.out.println("Player's 2nd Card is: " + playerCard2Value);
	      System.out.println("Player Total is: " + totalPlayer);
		  */
	      /**
	       * if player hand = 8
	       * double on dealer hands 5 to 6
	       * otherwise hit
	       */
	      // int dealerHandfor8 = 5 || 6;

	      if (playerCard1Value <= 8 || totalPlayer <= 8) {
	        if (totalDealer == 5 || totalDealer == 6)
	          bestMove = 'D';
	        else
	          bestMove = 'H';
	      }

	      /**
	       * if player hand = 9
	       * double on dealer hands 2 to 6
	       * otherwise hit
	       */
	      // int dealerHandfor9 = 2 || 3 || 4 || 5 || 6;

	      if (playerCard1Value == 9 || totalPlayer == 9) {
	        if (totalDealer == 2 || totalDealer == 3 || totalDealer == 4 || totalDealer == 5 || totalDealer == 6)
	          bestMove = 'D';
	        else
	          bestMove = 'H';
	      }

	      /**
	       * if player hand = 10
	       * double on dealer hands 2 to 9
	       * otherwise hit
	       */
	      // int dealerHandfor10 = 2 || 3 || 4 || 5 || 6 || 7 || 8 || 9;

	      if (playerCard1Value == 10 || totalPlayer == 10) {
	        if (totalDealer == 2 || totalDealer == 3 || totalDealer == 4 || totalDealer == 5 || totalDealer == 6 || totalDealer == 7 || totalDealer == 8 || totalDealer == 9)
	          bestMove = 'D';
	        else
	          bestMove = 'H';
	      }

	      /**
	       * if player hand = 11
	       * always double
	       */
	      if (playerCard1Value == 11 || totalPlayer == 11)
	        bestMove = 'D';

	      /**
	       * if player hand = 12
	       * stand on dealer hands 4 to 6
	       * otherwise hit
	       */
	      // int dealerHandfor12 = 4 || 5 || 6;

	      if (playerCard1Value == 12 || totalPlayer == 12) {
	        if (totalDealer == 4 || totalDealer == 5 || totalDealer == 6)
	          bestMove = 'S';
	        else
	          bestMove = 'H';
	      }

	      /**
	       * if player hand = 13 to 16
	       * stand on dealer hands 2 to 6
	       * otherwise hit
	       */
	      // int playerHandfor13to16 = 13 || 14 || 15 || 16;
	      // int dealerHandfor13to16 = 2 || 3 || 4 || 5 || 6;

	      if ((playerCard1Value == 13 || playerCard1Value == 14 || playerCard1Value == 15 || playerCard1Value == 16) || (totalPlayer == 13 || totalPlayer == 14 || totalPlayer == 15 || totalPlayer == 16)) {
	        if (totalDealer == 2 || totalDealer == 3 || totalDealer == 4 || totalDealer == 5 || totalDealer == 6)
	          bestMove = 'S';
	        else
	          bestMove = 'H';
	      }

	      /**
	       * if player hand = 17 to 21
	       * always stand
	       */
	      //int playerHandfor17to21 = 17 || 18 || 19 || 20 || 21;

	      if ((playerCard1Value == 17 || playerCard1Value == 18 || playerCard1Value == 19 ||  playerCard1Value == 20 ||  playerCard1Value == 21) || (totalPlayer == 17 || totalPlayer == 18 || totalPlayer == 19 ||  totalPlayer == 20 ||  totalPlayer == 21))
	        bestMove = 'S';

	      /**
	       * if player hand = A, 2 to A, 5
	       * double on dealer hands 4 to 6
	       * otherwise hit
	       */
	      // int playerHand2forA2toA5 = 2 || 3 || 4 || 5;
	      // int dealerHandforA2toA5 = 4 || 5 || 6;

	      if ((playerCard1Value == 11 || playerCard1Value == 1) && (playerCard2Value == 2 || playerCard2Value == 3 || playerCard2Value == 4 || playerCard2Value == 5)) {
	        if (totalDealer == 4 || totalDealer == 5 || totalDealer == 6)
	          bestMove = 'D';
	        else
	          bestMove = 'H';
	      }

	      /**
	       * if player hand = A, 6
	       * double on dealer hands 2 to 6
	       * otherwise hit
	       */
	      // int dealerHandforA6 = 2 || 3 || 4 || 5 || 6;

	      if ((playerCard1Value == 11 || playerCard1Value == 1) && playerCard2Value == 6) {
	        if (totalDealer == 2 || totalDealer == 3 || totalDealer == 4 || totalDealer == 5 || totalDealer == 6)
	          bestMove = 'D';
	        else
	          bestMove = 'H';
	      }

	      /**
	       * if player hand = A, 7
	       * double on dealer hands 3 to 6
	       * stand on dealer hands 2, 7, 8, or Ace
	       * otherwise hit
	       */
	      // int dealerHandforA7_double = 3 || 4 || 5 || 6;
	      // int dealerHandforA7_stand = 2 || 7 || 8 || ace;

	      if ((playerCard1Value == 11 || playerCard1Value == 1) && playerCard2Value == 7) {
	        if (totalDealer == 3 || totalDealer == 4 || totalDealer == 5 || totalDealer == 6)
	          bestMove = 'D';
	        else if (totalDealer == 2 || totalDealer == 7 || totalDealer == 8 || totalDealer == 11 || totalDealer == 1)
	          bestMove = 'S';
	        else
	          bestMove = 'H';
	      }

	      /**
	       * if player hand = A, 8
	       * double on dealer hand 6
	       * otherwise stand
	       */
	      if ((playerCard1Value == 11 || playerCard1Value == 1) && playerCard2Value == 8) {
	        if (totalDealer == 6)
	          bestMove = 'D';
	        else
	          bestMove = 'S';
	      }

	      /**
	       * if player hand = A, 9
	       * always stand
	       */
	      if ((playerCard1Value == 11 || playerCard1Value == 1) && playerCard2Value == 9)
	        bestMove = 'S';

	      /**
	       * if player hand = A, A
	       * always split
	       */
	      if ((playerCard1Value == 11 || playerCard1Value == 1) && (playerCard2Value == 11 || playerCard2Value == 1))
	        bestMove = 'P';

	      /**
	       * if player hand = 2, 2
	       * split on dealer hands 3 to 7
	       * otherwise hit
	       */
	      // int dealerHandfor2_2 = 3 || 4 || 5 || 6 || 7;

	      if (playerCard1Value == 2 && playerCard2Value == 2) {
	        if (totalDealer == 3 || totalDealer == 4 || totalDealer == 5 || totalDealer == 6 || totalDealer == 7)
	          bestMove = 'P';
	        else
	          bestMove = 'H';
	      }

	      /**
	       * if player hand = 3, 3
	       * split on dealer hands 4 to 7
	       * otherwise hit
	       */
	      // int dealerHandfor3_3 = 4 || 5 || 6 || 7;

	      if (playerCard1Value == 3 && playerCard2Value == 3) {
	        if (totalDealer == 4 || totalDealer == 5 || totalDealer == 6 || totalDealer == 7)
	          bestMove = 'P';
	        else
	          bestMove = 'H';
	      }

	      /**
	       * if player hand = 4, 4
	       * double on dealer hands 5 to 6
	       * otherwise hit
	       */
	      //int dealerHandfor4_4 = 5 || 6;

	      if (playerCard1Value == 4 && playerCard2Value == 4) {
	        if (totalDealer == 5 || totalDealer == 6)
	          bestMove = 'D';
	        else
	          bestMove = 'H';
	      }

	      /**
	       * if player hand = 5, 5
	       * double on dealer hands 2 to 9
	       * otherwise hit
	       */
	      //int dealerHandfor5_5 = 2 || 3 || 4 || 5 || 6 || 7 || 8 || 9;

	      if (playerCard1Value == 5 && playerCard2Value == 5) 
	      {
	        if (totalDealer == 2 || totalDealer == 3 || totalDealer == 4 || totalDealer == 5 || totalDealer == 6 || totalDealer == 7 || totalDealer == 8 || totalDealer == 9)
	          bestMove = 'D';
	        else
	          bestMove = 'H';
	      }

	      /**
	       * if player hand = 6, 6
	       * split on dealer hands 2 to 6
	       * otherwise hit
	       */
	      //int dealerHandfor6_6 = 2 || 3 || 4 || 5 || 6;

	      if (playerCard1Value == 6 && playerCard2Value == 6) {
	        if (totalDealer == 2 || totalDealer == 3 || totalDealer == 4 || totalDealer == 5 || totalDealer == 6)
	          bestMove = 'P';
	        else
	          bestMove = 'H';
	      }

	      /**
	       * if player hand = 7, 7
	       * split on dealer hands 2 to 7
	       * stand on 10
	       * otherwise hit
	       */
	      //int dealerHandfor7_7 = 2 || 3 || 4 || 5 || 6 || 7;

	      if (playerCard1Value == 7 && playerCard2Value == 7) {
	        if (totalDealer == 2 || totalDealer == 3 || totalDealer == 4 || totalDealer == 5 || totalDealer == 6 || totalDealer == 7)
	          bestMove = 'P';
	        else if (totalDealer == 10)
	          bestMove = 'S';
	        else
	          bestMove = 'H';
	      }


	      /**
	       * if player hand = 8, 8
	       * always split
	       */
	      if (playerCard1Value == 8 && playerCard2Value == 8)
	        bestMove = 'P';

	      /**
	       * if player hand = 9, 9
	       * split on 2 to 9 except 7
	       * stand on 7, 10, or Ace
	       */
	      //int dealerHandfor9_9 = 2 || 3 || 4 || 5 || 6 || 8 || 9;

	      if (playerCard1Value == 7 && playerCard2Value == 7) {
	        if (totalDealer == 2 || totalDealer == 3 || totalDealer == 4 || totalDealer == 5 || totalDealer == 6 || totalDealer == 8 || totalDealer == 9)
	          bestMove = 'P';
	        else
	          bestMove = 'S';
	      }

	      /**
	       * if player hand = 10, 10
	       * always stand
	       */
	      if (playerCard1Value == 10 && playerCard2Value == 10)
	        bestMove = 'S';

	      /**
	       * return best move
	       */
	      return bestMove;
	    }


   
   public static void main(String[] args) 
   {
      Connection conn = null;
      Statement stmt = null;
      try
      {
         //STEP 2: Register JDBC driver
         Class.forName("com.mysql.jdbc.Driver");
         Scanner keyboard = new Scanner(System.in);
         //STEP 3: Open a connection
         System.out.println("Connecting to database...");
         conn = DriverManager.getConnection(DB_URL,USER,PASS);
         System.out.println("Creating statement...");
         
         stmt = conn.createStatement();
         String sql, sql2;
         ResultSet rs = null, rs2 = null;
         boolean cond = true;
         String UserCard1 = " ", UserCard2 = " ", DealerCard1 = " ", DealerCard2 = " ", SearchCond3 = " ", SearchCond4 = " ", SearchCond5 = " ", SearchCond6 = " ", DealerCardString = " ", SearchCond7 = " "; 
         int U1 = 0, U2 = 0, D1 = 0, D2 = 0, totalU, totalD;
         //int i = 0, j = 0, 
         int index, index2, LessThan8, MoreThan17;
         int i = 0, j = 0, freq = 1000000;
     	String DealerCardString5 = " ";

         int count = 0;
         String[] cards = new String[20];
         String[] tallyArrayUser = {"8", "9", "10", "11", "12", "13", "14", "15", "16", "17","2,2","3,3","4,4","5,5","6,6","7,7","8,8","9,9","10,10","A,2","A,3","A,4","A,5","A,6","A,7","A,8","A,9","A,10","A,A"};
         String[] tallyArrayDealer = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A"};
         char[][] tallyTable = new char[29][10];
         int countT1 =0, countT2=0, countT3=0, countT4=0;

         for (int l = 0; l < tallyTable.length; l++) 
         { 
        	 for (int k = 0; k < tallyTable[l].length; k++) 
        	 { 
        		 tallyTable[l][k] = ' '; 
       		 } 
         }

         //System.out.println("");
         System.out.print("How many decks would you like to use?");
         //System.out.println("");
         
         int decknumber = keyboard.nextInt();
         
         if(decknumber == 1)
         {
              System.out.println("");
              
              
        	  sql = "SELECT * FROM blackjackdatabase";
              rs = stmt.executeQuery(sql);
             
              while(rs.next())
              {
                int id  = rs.getInt("idBlackJackDatabase");
                String CardValue = rs.getString("CardValue");
                   
                //System.out.print("ID: " + id);
                //System.out.println(", CardValue: " + CardValue);
              }
              
              //System.out.println("");

              //System.out.println("");
              /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
              for (int random = 0; random < freq; random++) { //Runs a million times to get frequency table

              count = 0;
              
              sql2 = "SELECT * FROM blackjackdatabase ORDER BY RAND() LIMIT 20;";
              rs2 = stmt.executeQuery(sql2);
              
              while(rs2.next())
              {
            	 
            	int id  = rs2.getInt("idBlackJackDatabase");
            	
            	String CardValue = rs2.getString("CardValue");
            	
            	cards[count] = CardValue;
            	count++;
                                 
                //System.out.print("ID: " + id);
                //System.out.println(", CardValue: " + CardValue);
              }
              
              /*System.out.println("");
              System.out.println("Your cards are....");
              System.out.println("");*/

                UserCard1 = cards[0];
/*              System.out.println("User Card 1 : " + UserCard1);
*/              DealerCard1 = cards[1];
/*              System.out.println("Dealer Card Down.... ");
*/              UserCard2 = cards[2];
/*              System.out.println("User Card 2 : " + UserCard2);
*/              DealerCard2 = cards[3];
/*              System.out.println("Dealer Card Shown: " + DealerCard2);*/
                //System.out.println("");
				/*
				System.out.println("User Card 1: " + UserCard1);
				System.out.println("Dealer Card Down");
				System.out.println("User Card 2: " + UserCard2);
				System.out.println("Dealer Card Up: " + DealerCard2);
				*/
				if(UserCard1.equals("Jack") || UserCard1.equals("Queen") || UserCard1.equals("King"))
				{
					U1 = 10;
				}
				else if(UserCard1.equals("Ace"))
				{
					U1 = 1;
				}
				else
				{
					U1 = Integer.parseInt(UserCard1);
				}
				
				
				
				if(UserCard2.equals("Jack") || UserCard2.equals("Queen") || UserCard2.equals("King"))
				{
					U2 = 10;
				}
				else if(UserCard2.equals("Ace"))
				{
					U2 = 1;
				}
				else
				{
					U2 = Integer.parseInt(UserCard2);
				}
				
				
				
				if(DealerCard1.equals("Jack") || DealerCard1.equals("Queen") || DealerCard1.equals("King"))
				{
					D1 = 10;
				}
				else if(DealerCard1.equals("Ace"))
				{
					D1 = 1;
				}
				else
				{
					D1 = Integer.parseInt(DealerCard1);
				}
				
				
				
				if(DealerCard2.equals("Jack") || DealerCard2.equals("Queen") || DealerCard2.equals("King"))
				{
					D2 = 10;
				}
				else if(DealerCard2.equals("Ace"))
				{
					D2 = 1;
				}
				else
				{
					D2 = Integer.parseInt(DealerCard2);
				}
				
				
				if(UserCard1.equals("Ace") && UserCard2.equals("Ace"))
				{
					totalU = 21;
				}
		 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				if(UserCard1.equals("Ace") && !UserCard2.equals("Ace"))
				{
					U1 = 11;
				}
				
				if(UserCard2.equals("Ace") && !UserCard1.equals("Ace"))
				{
					U2 = 11;
				}
				
				if(DealerCard1.equals("Ace") && !DealerCard2.equals("Ace"))
				{
					D1 = 11;
				}
				
				if(DealerCard2.equals("Ace") && !DealerCard1.equals("Ace"))
				{
					D2 = 11;
				}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
				
	            //System.out.println("");
				totalU = U1 + U2;
	            totalD = D2;
	            int totalDw2 = D1 + D2;
	            /*
	            System.out.println("User Card 1: " + U1);
	            System.out.println("User Card 2: " + U2);
				System.out.println("User Total: " + totalU);
				System.out.println("Dealer Shown: " + D2);
				System.out.println("Dealer Total: " + totalDw2);
                */
              /*  System.out.println("");
                System.out.println("----------");
                
                
                
                //System.out.println(StrategyMethod(U1, U2, totalDw2));
                System.out.println("");
                System.out.println("");
                System.out.println("");*/
       /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
                
                	if(totalU < 8)
                	{
                		SearchCond5 = "8";
                	}
                	else if(totalU > 17)
                	{
                		SearchCond5 = "17";
                	}
                	else
                	{
                		SearchCond5 = String.valueOf(totalU);
                	}
                	
                	
					if(DealerCard2.equals("Jack"))
                	{
                		DealerCardString5 = "10";
                	}
					
					if(DealerCard2.equals("Queen"))
                	{
                		DealerCardString5 = "10";
                	}
					
					if(DealerCard2.equals("King"))
                	{
                		DealerCardString5 = "10";
                	}
					
					if(DealerCard2.equals("Ace"))
                	{
                		DealerCardString5 = "A";
                	}
					
					String U1W, U2W;
					if(UserCard1.equals("Ace"))
					{
						U1W = "A";
					}
					else
					{
						U1W = UserCard1;
					}
					
					if(UserCard2.equals("Ace"))
					{
						U2W = "A";
					}
					else
					{
						U2W = UserCard2;
					}
					
					String UserCheck = U1W + "," + U2W;
					
					
                  for (index = 0; index < 29; index++) 
                  {
                    //if index of user array is equal to the user total
                    if (tallyArrayUser[index].equals(SearchCond5)) 
                    {
                      //initialize i to index
                      //System.out.println("The current i is "+ i);
                      i = index;
                      //reset index value
                      // index = 0;
                    }
                    else if (tallyArrayUser[index].equals(UserCheck)) 
                    {
                      //initialize i to index
                      //System.out.println("The current i is "+ i);
                      i = index;
                      //reset index value
                      // index = 0;
                    } else if (tallyArrayUser[index].equals(UserCheck)) 
                    {
                      //initialize i to index
                      //System.out.println("The current i is "+ i);
                      i = index;
                      //reset index value
                      // index = 0;
                    } 
                    else if (tallyArrayUser[index].equals(UserCheck)) 
                    {
                      //initialize i to index
                      //System.out.println("The current i is "+ i);
                      i = index;
                      //reset index value
                      // index = 0;
                    }
                    else if (tallyArrayUser[index].equals(UserCheck)) 
                    {
                      //initialize i to index
                      //System.out.println("The current i is "+ i);
                      i = index;
                      //reset index value
                      // index = 0;
                    } else if (tallyArrayUser[index].equals(UserCheck)) 
                    {
                      //initialize i to index
                      //System.out.println("The current i is "+ i);
                      i = index;
                      //reset index value
                      // index = 0;
                    } 
                    else if (tallyArrayUser[index].equals(UserCheck)) 
                    {
                      //initialize i to index
                      //System.out.println("The current i is "+ i);
                      i = index;
                      //reset index value
                      // index = 0;
                    }
                    else if (tallyArrayUser[index].equals(UserCheck)) 
                    {
                      //initialize i to index
                      //System.out.println("The current i is "+ i);
                      i = index;
                      //reset index value
                      // index = 0;
                    } else if (tallyArrayUser[index].equals(UserCheck)) 
                    {
                      //initialize i to index
                      //System.out.println("The current i is "+ i);
                      i = index;
                      //reset index value
                      // index = 0;
                    } 
                    else if (tallyArrayUser[index].equals(UserCheck)) 
                    {
                      //initialize i to index
                      //System.out.println("The current i is "+ i);
                      i = index;
                      //reset index value
                      // index = 0;
                    }
                    else if (tallyArrayUser[index].equals(UserCheck)) 
                    {
                      //initialize i to index
                      //System.out.println("The current i is "+ i);
                      i = index;
                      //reset index value
                      // index = 0;
                    } else if (tallyArrayUser[index].equals(UserCheck)) 
                    {
                      //initialize i to index
                      //System.out.println("The current i is "+ i);
                      i = index;
                      //reset index value
                      // index = 0;
                    } 
                    else if (tallyArrayUser[index].equals(UserCheck)) 
                    {
                      //initialize i to index
                      //System.out.println("The current i is "+ i);
                      i = index;
                      //reset index value
                      // index = 0;
                    }
                    else if (tallyArrayUser[index].equals(UserCheck)) 
                    {
                      //initialize i to index
                      //System.out.println("The current i is "+ i);
                      i = index;
                      //reset index value
                      // index = 0;
                    } else if (tallyArrayUser[index].equals(UserCheck)) 
                    {
                      //initialize i to index
                      //System.out.println("The current i is "+ i);
                      i = index;
                      //reset index value
                      // index = 0;
                    } 
                    else if (tallyArrayUser[index].equals(UserCheck)) 
                    {
                      //initialize i to index
                      //System.out.println("The current i is "+ i);
                      i = index;
                      //reset index value
                      // index = 0;
                    }
                    else if (tallyArrayUser[index].equals(UserCheck)) 
                    {
                      //initialize i to index
                      //System.out.println("The current i is "+ i);
                      i = index;
                      //reset index value
                      // index = 0;
                    } else if (tallyArrayUser[index].equals(UserCheck)) 
                    {
                      //initialize i to index
                      //System.out.println("The current i is "+ i);
                      i = index;
                      //reset index value
                      // index = 0;
                    } 
                    else if (tallyArrayUser[index].equals(UserCheck)) 
                    {
                      //initialize i to index
                      //System.out.println("The current i is "+ i);
                      i = index;
                      //reset index value
                      // index = 0;
                    }
                    else if (tallyArrayUser[index].equals(UserCheck)) 
                    {
                      //initialize i to index
                      //System.out.println("The current i is "+ i);
                      i = index;
                      //reset index value
                      // index = 0;
                    }
                    

                    //looping through dealer array
                    for (index2 = 0; index2 < 10; index2++) 
                    {
                      //if index of dealer array is equal to the dealer total
                      if (tallyArrayDealer[index2].equals(DealerCard2) || tallyArrayDealer[index2].equals(DealerCardString5)) 
                      {
                        //initialize j to index
                        //System.out.println("The current j is "+ j );
                        j = index2;
                        //reset index value
                        break;
                        
                      }

                    }
                    tallyTable[i][j] = StrategyMethod(U1, U2, totalDw2);

                    // System.out.println("TALLY BEFORE: " + tallyTable[i][j]);
                    // System.out.println("TALLY AFTER: " + tallyTable[i][j]);
                    // System.out.println("TALLY BEFORE: " + tallyTable[index][index2]);
                    // tallyTable[index][index2]++;
                    // System.out.println("TALLY AFTER: " + tallyTable[index][index2]);
                  }
                }
                
                
         /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
                
                System.out.println("\n\n");
                System.out.println("\t ---------------------------------------------------------------------------");
                System.out.println("\t   2 \t 3 \t 4 \t 5 \t 6 \t 7 \t 8 \t 9 \t 10 \t A ");
                System.out.println("\t ---------------------------------------------------------------------------");

                System.out.println("        |");
                System.out.println("  8     |   " + tallyTable[0][0] + "  \t  " + tallyTable[0][1] + "\t" + tallyTable[0][2] + "\t" + tallyTable[0][3] + "\t" + tallyTable[0][4] + "\t" + tallyTable[0][5] + "\t" + tallyTable[0][6] + "\t" + tallyTable[0][7] + "\t" + tallyTable[0][8] + "\t" + tallyTable[0][9]);
                System.out.println("  9     |   " + tallyTable[1][0] + "  \t  " + tallyTable[1][1] + "\t" + tallyTable[1][2] + "\t" + tallyTable[1][3] + "\t" + tallyTable[1][4] + "\t" + tallyTable[1][5] + "\t" + tallyTable[1][6] + "\t" + tallyTable[1][7] + "\t" + tallyTable[1][8] + "\t" + tallyTable[1][9]);
                System.out.println("  10    |   " + tallyTable[2][0] + "  \t  " + tallyTable[2][1] + "\t" + tallyTable[2][2] + "\t" + tallyTable[2][3] + "\t" + tallyTable[2][4] + "\t" + tallyTable[2][5] + "\t" + tallyTable[2][6] + "\t" + tallyTable[2][7] + "\t" + tallyTable[2][8] + "\t" + tallyTable[2][9]);
                System.out.println("  11    |   " + tallyTable[3][0] + "  \t  " + tallyTable[3][1] + "\t" + tallyTable[3][2] + "\t" + tallyTable[3][3] + "\t" + tallyTable[3][4] + "\t" + tallyTable[3][5] + "\t" + tallyTable[3][6] + "\t" + tallyTable[3][7] + "\t" + tallyTable[3][8] + "\t" + tallyTable[3][9]);
                System.out.println("  12    |   " + tallyTable[4][0] + "  \t  " + tallyTable[4][1] + "\t" + tallyTable[4][2] + "\t" + tallyTable[4][3] + "\t" + tallyTable[4][4] + "\t" + tallyTable[4][5] + "\t" + tallyTable[4][6] + "\t" + tallyTable[4][7] + "\t" + tallyTable[4][8] + "\t" + tallyTable[4][9]);
                System.out.println("  13    |   " + tallyTable[5][0] + "  \t  " + tallyTable[5][1] + "\t" + tallyTable[5][2] + "\t" + tallyTable[5][3] + "\t" + tallyTable[5][4] + "\t" + tallyTable[5][5] + "\t" + tallyTable[5][6] + "\t" + tallyTable[5][7] + "\t" + tallyTable[5][8] + "\t" + tallyTable[5][9]);
                System.out.println("  14    |   " + tallyTable[6][0] + "  \t  " + tallyTable[6][1] + "\t" + tallyTable[6][2] + "\t" + tallyTable[6][3] + "\t" + tallyTable[6][4] + "\t" + tallyTable[6][5] + "\t" + tallyTable[6][6] + "\t" + tallyTable[6][7] + "\t" + tallyTable[6][8] + "\t" + tallyTable[6][9]);
                System.out.println("  15    |   " + tallyTable[7][0] + "  \t  " + tallyTable[7][1] + "\t" + tallyTable[7][2] + "\t" + tallyTable[7][3] + "\t" + tallyTable[7][4] + "\t" + tallyTable[7][5] + "\t" + tallyTable[7][6] + "\t" + tallyTable[7][7] + "\t" + tallyTable[7][8] + "\t" + tallyTable[7][9]);
                System.out.println("  16    |   " + tallyTable[8][0] + "  \t  " + tallyTable[8][1] + "\t" + tallyTable[8][2] + "\t" + tallyTable[8][3] + "\t" + tallyTable[8][4] + "\t" + tallyTable[8][5] + "\t" + tallyTable[8][6] + "\t" + tallyTable[8][7] + "\t" + tallyTable[8][8] + "\t" + tallyTable[8][9]);
                System.out.println("  17    |   " + tallyTable[9][0] + "  \t  " + tallyTable[9][1] + "\t" + tallyTable[9][2] + "\t" + tallyTable[9][3] + "\t" + tallyTable[9][4] + "\t" + tallyTable[9][5] + "\t" + tallyTable[9][6] + "\t" + tallyTable[9][7] + "\t" + tallyTable[9][8] + "\t" + tallyTable[9][9]);
                System.out.println("  2,2   |   " + tallyTable[10][0] + "  \t  " + tallyTable[10][1] + "\t" + tallyTable[10][2] + "\t" + tallyTable[10][3] + "\t" + tallyTable[10][4] + "\t" + tallyTable[10][5] + "\t" + tallyTable[10][6] + "\t" + tallyTable[10][7] + "\t" + tallyTable[10][8] + "\t" + tallyTable[10][9]);
                System.out.println("  3,3   |   " + tallyTable[11][0] + "  \t  " + tallyTable[11][1] + "\t" + tallyTable[11][2] + "\t" + tallyTable[11][3] + "\t" + tallyTable[11][4] + "\t" + tallyTable[11][5] + "\t" + tallyTable[11][6] + "\t" + tallyTable[11][7] + "\t" + tallyTable[11][8] + "\t" + tallyTable[11][9]);
                System.out.println("  4,4   |   " + tallyTable[12][0] + "  \t  " + tallyTable[12][1] + "\t" + tallyTable[12][2] + "\t" + tallyTable[12][3] + "\t" + tallyTable[12][4] + "\t" + tallyTable[12][5] + "\t" + tallyTable[12][6] + "\t" + tallyTable[12][7] + "\t" + tallyTable[12][8] + "\t" + tallyTable[12][9]);
                System.out.println("  5,5   |   " + tallyTable[13][0] + "  \t  " + tallyTable[13][1] + "\t" + tallyTable[13][2] + "\t" + tallyTable[13][3] + "\t" + tallyTable[13][4] + "\t" + tallyTable[13][5] + "\t" + tallyTable[13][6] + "\t" + tallyTable[13][7] + "\t" + tallyTable[13][8] + "\t" + tallyTable[13][9]);
                System.out.println("  6,6   |   " + tallyTable[14][0] + "  \t  " + tallyTable[14][1] + "\t" + tallyTable[14][2] + "\t" + tallyTable[14][3] + "\t" + tallyTable[14][4] + "\t" + tallyTable[14][5] + "\t" + tallyTable[14][6] + "\t" + tallyTable[14][7] + "\t" + tallyTable[14][8] + "\t" + tallyTable[14][9]);
                System.out.println("  7,7   |   " + tallyTable[15][0] + "  \t  " + tallyTable[15][1] + "\t" + tallyTable[15][2] + "\t" + tallyTable[15][3] + "\t" + tallyTable[15][4] + "\t" + tallyTable[15][5] + "\t" + tallyTable[15][6] + "\t" + tallyTable[15][7] + "\t" + tallyTable[15][8] + "\t" + tallyTable[15][9]);
                System.out.println("  8,8   |   " + tallyTable[16][0] + "  \t  " + tallyTable[16][1] + "\t" + tallyTable[16][2] + "\t" + tallyTable[16][3] + "\t" + tallyTable[16][4] + "\t" + tallyTable[16][5] + "\t" + tallyTable[16][6] + "\t" + tallyTable[16][7] + "\t" + tallyTable[16][8] + "\t" + tallyTable[16][9]);
                System.out.println("  9,9   |   " + tallyTable[17][0] + "  \t  " + tallyTable[17][1] + "\t" + tallyTable[17][2] + "\t" + tallyTable[17][3] + "\t" + tallyTable[17][4] + "\t" + tallyTable[17][5] + "\t" + tallyTable[17][6] + "\t" + tallyTable[17][7] + "\t" + tallyTable[17][8] + "\t" + tallyTable[17][9]);
                System.out.println("  10,10 |   " + tallyTable[18][0] + "  \t  " + tallyTable[18][1] + "\t" + tallyTable[18][2] + "\t" + tallyTable[18][3] + "\t" + tallyTable[18][4] + "\t" + tallyTable[18][5] + "\t" + tallyTable[18][6] + "\t" + tallyTable[18][7] + "\t" + tallyTable[18][8] + "\t" + tallyTable[18][9]);
                System.out.println("  A,2   |   " + tallyTable[19][0] + "  \t  " + tallyTable[19][1] + "\t" + tallyTable[19][2] + "\t" + tallyTable[19][3] + "\t" + tallyTable[19][4] + "\t" + tallyTable[19][5] + "\t" + tallyTable[19][6] + "\t" + tallyTable[19][7] + "\t" + tallyTable[19][8] + "\t" + tallyTable[19][9]);
                System.out.println("  A,3   |   " + tallyTable[20][0] + "  \t  " + tallyTable[20][1] + "\t" + tallyTable[20][2] + "\t" + tallyTable[20][3] + "\t" + tallyTable[20][4] + "\t" + tallyTable[20][5] + "\t" + tallyTable[20][6] + "\t" + tallyTable[20][7] + "\t" + tallyTable[20][8] + "\t" + tallyTable[20][9]);
                System.out.println("  A,4   |   " + tallyTable[21][0] + "  \t  " + tallyTable[21][1] + "\t" + tallyTable[21][2] + "\t" + tallyTable[21][3] + "\t" + tallyTable[21][4] + "\t" + tallyTable[21][5] + "\t" + tallyTable[21][6] + "\t" + tallyTable[21][7] + "\t" + tallyTable[21][8] + "\t" + tallyTable[21][9]);
                System.out.println("  A,5   |   " + tallyTable[22][0] + "  \t  " + tallyTable[22][1] + "\t" + tallyTable[22][2] + "\t" + tallyTable[22][3] + "\t" + tallyTable[22][4] + "\t" + tallyTable[22][5] + "\t" + tallyTable[22][6] + "\t" + tallyTable[22][7] + "\t" + tallyTable[22][8] + "\t" + tallyTable[22][9]);
                System.out.println("  A,6   |   " + tallyTable[23][0] + "  \t  " + tallyTable[23][1] + "\t" + tallyTable[23][2] + "\t" + tallyTable[23][3] + "\t" + tallyTable[23][4] + "\t" + tallyTable[23][5] + "\t" + tallyTable[23][6] + "\t" + tallyTable[23][7] + "\t" + tallyTable[23][8] + "\t" + tallyTable[23][9]);
                System.out.println("  A,7   |   " + tallyTable[24][0] + "  \t  " + tallyTable[24][1] + "\t" + tallyTable[24][2] + "\t" + tallyTable[24][3] + "\t" + tallyTable[24][4] + "\t" + tallyTable[24][5] + "\t" + tallyTable[24][6] + "\t" + tallyTable[24][7] + "\t" + tallyTable[24][8] + "\t" + tallyTable[24][9]);
                System.out.println("  A,8   |   " + tallyTable[25][0] + "  \t  " + tallyTable[25][1] + "\t" + tallyTable[25][2] + "\t" + tallyTable[25][3] + "\t" + tallyTable[25][4] + "\t" + tallyTable[25][5] + "\t" + tallyTable[25][6] + "\t" + tallyTable[25][7] + "\t" + tallyTable[25][8] + "\t" + tallyTable[25][9]);
                System.out.println("  A,9   |   " + tallyTable[26][0] + "  \t  " + tallyTable[26][1] + "\t" + tallyTable[26][2] + "\t" + tallyTable[26][3] + "\t" + tallyTable[26][4] + "\t" + tallyTable[26][5] + "\t" + tallyTable[26][6] + "\t" + tallyTable[26][7] + "\t" + tallyTable[26][8] + "\t" + tallyTable[26][9]);
                System.out.println("  A,10  |   " + tallyTable[27][0] + "  \t  " + tallyTable[27][1] + "\t" + tallyTable[27][2] + "\t" + tallyTable[27][3] + "\t" + tallyTable[27][4] + "\t" + tallyTable[27][5] + "\t" + tallyTable[27][6] + "\t" + tallyTable[27][7] + "\t" + tallyTable[27][8] + "\t" + tallyTable[27][9]);
                System.out.println("  A,A   |   " + tallyTable[28][0] + "  \t  " + tallyTable[28][1] + "\t" + tallyTable[28][2] + "\t" + tallyTable[28][3] + "\t" + tallyTable[28][4] + "\t" + tallyTable[28][5] + "\t" + tallyTable[28][6] + "\t" + tallyTable[28][7] + "\t" + tallyTable[28][8] + "\t" + tallyTable[28][9]);
                
                String content ="X\t2\t3\t4\t5\t6\t7\t8\t9\t10\tA";
                String content2 ="8" + "\t" + tallyTable[0][0] + "\t" + tallyTable[0][1] + "\t" + tallyTable[0][2] + "\t" + tallyTable[0][3] + "\t" + tallyTable[0][4] + "\t" + tallyTable[0][5] + "\t" + tallyTable[0][6] + "\t" + tallyTable[0][7] + "\t" + tallyTable[0][8] + "\t" + tallyTable[0][9];
                String content3 ="9" + "\t" + tallyTable[1][0] + "\t" + tallyTable[1][1] + "\t" + tallyTable[1][2] + "\t" + tallyTable[1][3] + "\t" + tallyTable[1][4] + "\t" + tallyTable[1][5] + "\t" + tallyTable[1][6] + "\t" + tallyTable[1][7] + "\t" + tallyTable[1][8] + "\t" + tallyTable[1][9];
                String content4 ="10" + "\t" + tallyTable[2][0] + "\t" + tallyTable[2][1] + "\t" + tallyTable[2][2] + "\t" + tallyTable[2][3] + "\t" + tallyTable[2][4] + "\t" + tallyTable[2][5] + "\t" + tallyTable[2][6] + "\t" + tallyTable[2][7] + "\t" + tallyTable[2][8] + "\t" + tallyTable[2][9];
                String content5 ="11" + "\t" + tallyTable[3][0] + "\t" + tallyTable[3][1] + "\t" + tallyTable[3][2] + "\t" + tallyTable[3][3] + "\t" + tallyTable[3][4] + "\t" + tallyTable[3][5] + "\t" + tallyTable[3][6] + "\t" + tallyTable[3][7] + "\t" + tallyTable[3][8] + "\t" + tallyTable[3][9];
                String content6 ="12" + "\t" + tallyTable[4][0] + "\t" + tallyTable[4][1] + "\t" + tallyTable[4][2] + "\t" + tallyTable[4][3] + "\t" + tallyTable[4][4] + "\t" + tallyTable[4][5] + "\t" + tallyTable[4][6] + "\t" + tallyTable[4][7] + "\t" + tallyTable[4][8] + "\t" + tallyTable[4][9];
                String content7 ="13" + "\t" + tallyTable[5][0] + "\t" + tallyTable[5][1] + "\t" + tallyTable[5][2] + "\t" + tallyTable[5][3] + "\t" + tallyTable[5][4] + "\t" + tallyTable[5][5] + "\t" + tallyTable[5][6] + "\t" + tallyTable[5][7] + "\t" + tallyTable[5][8] + "\t" + tallyTable[5][9];
                String content8 ="14" + "\t" + tallyTable[6][0] + "\t" + tallyTable[6][1] + "\t" + tallyTable[6][2] + "\t" + tallyTable[6][3] + "\t" + tallyTable[6][4] + "\t" + tallyTable[6][5] + "\t" + tallyTable[6][6] + "\t" + tallyTable[6][7] + "\t" + tallyTable[6][8] + "\t" + tallyTable[6][9];
                String content9 ="15" + "\t" + tallyTable[7][0] + "\t" + tallyTable[7][1] + "\t" + tallyTable[7][2] + "\t" + tallyTable[7][3] + "\t" + tallyTable[7][4] + "\t" + tallyTable[7][5] + "\t" + tallyTable[7][6] + "\t" + tallyTable[7][7] + "\t" + tallyTable[7][8] + "\t" + tallyTable[7][9];
                String content10 ="16" + "\t" + tallyTable[8][0] + "\t" + tallyTable[8][1] + "\t" + tallyTable[8][2] + "\t" + tallyTable[8][3] + "\t" + tallyTable[8][4] + "\t" + tallyTable[8][5] + "\t" + tallyTable[8][6] + "\t" + tallyTable[8][7] + "\t" + tallyTable[8][8] + "\t" + tallyTable[8][9];
                String content11 ="17" + "\t" + tallyTable[9][0] + "\t" + tallyTable[9][1] + "\t" + tallyTable[9][2] + "\t" + tallyTable[9][3] + "\t" + tallyTable[9][4] + "\t" + tallyTable[9][5] + "\t" + tallyTable[9][6] + "\t" + tallyTable[9][7] + "\t" + tallyTable[9][8] + "\t" + tallyTable[9][9];
                String content12 ="2,2" + "\t" + tallyTable[10][0] + "\t" + tallyTable[10][1] + "\t" + tallyTable[10][2] + "\t" + tallyTable[10][3] + "\t" + tallyTable[10][4] + "\t" + tallyTable[10][5] + "\t" + tallyTable[10][6] + "\t" + tallyTable[10][7] + "\t" + tallyTable[10][8] + "\t" + tallyTable[10][9];
                String content13 ="3,3" + "\t" + tallyTable[11][0] + "\t" + tallyTable[11][1] + "\t" + tallyTable[11][2] + "\t" + tallyTable[11][3] + "\t" + tallyTable[11][4] + "\t" + tallyTable[11][5] + "\t" + tallyTable[11][6] + "\t" + tallyTable[11][7] + "\t" + tallyTable[11][8] + "\t" + tallyTable[11][9];
                String content14 ="4,4" + "\t" + tallyTable[12][0] + "\t" + tallyTable[12][1] + "\t" + tallyTable[12][2] + "\t" + tallyTable[12][3] + "\t" + tallyTable[12][4] + "\t" + tallyTable[12][5] + "\t" + tallyTable[12][6] + "\t" + tallyTable[12][7] + "\t" + tallyTable[12][8] + "\t" + tallyTable[12][9];
                String content15 ="5,5" + "\t" + tallyTable[13][0] + "\t" + tallyTable[13][1] + "\t" + tallyTable[13][2] + "\t" + tallyTable[13][3] + "\t" + tallyTable[13][4] + "\t" + tallyTable[13][5] + "\t" + tallyTable[13][6] + "\t" + tallyTable[13][7] + "\t" + tallyTable[13][8] + "\t" + tallyTable[13][9];
                String content16 ="6,6" + "\t" + tallyTable[14][0] + "\t" + tallyTable[14][1] + "\t" + tallyTable[14][2] + "\t" + tallyTable[14][3] + "\t" + tallyTable[14][4] + "\t" + tallyTable[14][5] + "\t" + tallyTable[14][6] + "\t" + tallyTable[14][7] + "\t" + tallyTable[14][8] + "\t" + tallyTable[14][9];
                String content17 ="7,7" + "\t" + tallyTable[15][0] + "\t" + tallyTable[15][1] + "\t" + tallyTable[15][2] + "\t" + tallyTable[15][3] + "\t" + tallyTable[15][4] + "\t" + tallyTable[15][5] + "\t" + tallyTable[15][6] + "\t" + tallyTable[15][7] + "\t" + tallyTable[15][8] + "\t" + tallyTable[15][9];
                String content18 ="8,8" + "\t" + tallyTable[16][0] + "\t" + tallyTable[16][1] + "\t" + tallyTable[16][2] + "\t" + tallyTable[16][3] + "\t" + tallyTable[16][4] + "\t" + tallyTable[16][5] + "\t" + tallyTable[16][6] + "\t" + tallyTable[16][7] + "\t" + tallyTable[16][8] + "\t" + tallyTable[16][9];
                String content19 ="9,9" + "\t" + tallyTable[17][0] + "\t" + tallyTable[17][1] + "\t" + tallyTable[17][2] + "\t" + tallyTable[17][3] + "\t" + tallyTable[17][4] + "\t" + tallyTable[17][5] + "\t" + tallyTable[17][6] + "\t" + tallyTable[17][7] + "\t" + tallyTable[17][8] + "\t" + tallyTable[17][9];
                String content20 ="10,10" + "\t" + tallyTable[18][0] +"\t" + tallyTable[18][1] + "\t" + tallyTable[18][2] + "\t" + tallyTable[18][3] + "\t" + tallyTable[18][4] + "\t" + tallyTable[18][5] + "\t" + tallyTable[18][6] + "\t" + tallyTable[18][7] + "\t" + tallyTable[18][8] + "\t" + tallyTable[18][9];
                String content21 ="A,2" + "\t" + tallyTable[19][0] + "\t" + tallyTable[19][1] + "\t" + tallyTable[19][2] + "\t" + tallyTable[19][3] + "\t" + tallyTable[19][4] + "\t" + tallyTable[19][5] + "\t" + tallyTable[19][6] + "\t" + tallyTable[19][7] + "\t" + tallyTable[19][8] + "\t" + tallyTable[19][9];
                String content22 ="A,3" + "\t" + tallyTable[20][0] + "\t" + tallyTable[20][1] + "\t" + tallyTable[20][2] + "\t" + tallyTable[20][3] + "\t" + tallyTable[20][4] + "\t" + tallyTable[20][5] + "\t" + tallyTable[20][6] + "\t" + tallyTable[20][7] + "\t" + tallyTable[20][8] + "\t" + tallyTable[20][9];
                String content23 ="A,4" + "\t" + tallyTable[21][0] + "\t" + tallyTable[21][1] + "\t" + tallyTable[21][2] + "\t" + tallyTable[21][3] + "\t" + tallyTable[21][4] + "\t" + tallyTable[21][5] + "\t" + tallyTable[21][6] + "\t" + tallyTable[21][7] + "\t" + tallyTable[21][8] + "\t" + tallyTable[21][9];
                String content24 ="A,5" + "\t" + tallyTable[22][0] + "\t" + tallyTable[22][1] + "\t" + tallyTable[22][2] + "\t" + tallyTable[22][3] + "\t" + tallyTable[22][4] + "\t" + tallyTable[22][5] + "\t" + tallyTable[22][6] + "\t" + tallyTable[22][7] + "\t" + tallyTable[22][8] + "\t" + tallyTable[22][9];
                String content25 ="A,6" + "\t" + tallyTable[23][0] + "\t" + tallyTable[23][1] + "\t" + tallyTable[23][2] + "\t" + tallyTable[23][3] + "\t" + tallyTable[23][4] + "\t" + tallyTable[23][5] + "\t" + tallyTable[23][6] + "\t" + tallyTable[23][7] + "\t" + tallyTable[23][8] + "\t" + tallyTable[23][9];
                String content26 ="A,7" + "\t" + tallyTable[24][0] + "\t" + tallyTable[24][1] + "\t" + tallyTable[24][2] + "\t" + tallyTable[24][3] + "\t" + tallyTable[24][4] + "\t" + tallyTable[24][5] + "\t" + tallyTable[24][6] + "\t" + tallyTable[24][7] + "\t" + tallyTable[24][8] + "\t" + tallyTable[24][9];
                String content27 ="A,8" + "\t" + tallyTable[25][0] + "\t" + tallyTable[25][1] + "\t" + tallyTable[25][2] + "\t" + tallyTable[25][3] + "\t" + tallyTable[25][4] + "\t" + tallyTable[25][5] + "\t" + tallyTable[25][6] + "\t" + tallyTable[25][7] + "\t" + tallyTable[25][8] + "\t" + tallyTable[25][9];
                String content28 ="A,9" + "\t" + tallyTable[26][0] + "\t" + tallyTable[26][1] + "\t" + tallyTable[26][2] + "\t" + tallyTable[26][3] + "\t" + tallyTable[26][4] + "\t" + tallyTable[26][5] + "\t" + tallyTable[26][6] + "\t" + tallyTable[26][7] + "\t" + tallyTable[26][8] + "\t" + tallyTable[26][9];
                String content29 ="A,10" + "\t" + tallyTable[27][0] + "\t" + tallyTable[27][1] + "\t" + tallyTable[27][2] + "\t" + tallyTable[27][3] + "\t" + tallyTable[27][4] + "\t" + tallyTable[27][5] + "\t" + tallyTable[27][6] + "\t" + tallyTable[27][7] + "\t" + tallyTable[27][8] + "\t" + tallyTable[27][9];
                String content30 ="A,A" + "\t" + tallyTable[28][0] + "\t" + tallyTable[28][1] + "\t" + tallyTable[28][2] + "\t" + tallyTable[28][3] + "\t" + tallyTable[28][4] + "\t" + tallyTable[28][5] + "\t" + tallyTable[28][6] + "\t" + tallyTable[28][7] + "\t" + tallyTable[28][8] + "\t" + tallyTable[28][9];
                
                System.out.println("");
                               
               /* //Hit Percentage
                for (int l = 0; l < tallyTable.length; l++) 
                { 
               	 for (int k = 0; k < tallyTable[l].length; k++) 
               	 { 
               		 if (tallyTable[l][k] == 'H')
               		 {
               		 tallyTable[l][k] = ' '; 
               		 countT1++;
               		 } 
               	 }
                }
                
           		System.out.println("Percent Won Using Hit " + ((countT1/290)*100) + "%");
              	 
                //Stand Percentage
                for (int l = 0; l < tallyTable.length; l++) 
                { 
               	 for (int k = 0; k < tallyTable[l].length; k++) 
               	 { 
               		if (tallyTable[l][k] == 'S')
               		{
               		 tallyTable[l][k] = ' '; 
               		 countT2++;

              		 } 
                }
                }
                
              	 System.out.println("Percent Won Using Stand " + ((countT2/290)*100) + "%");
                
                //Split Percentage
                for (int l = 0; l < tallyTable.length; l++) 
                { 
               	 for (int k = 0; k < tallyTable[l].length; k++) 
               	 { 
               		if (tallyTable[l][k] == 'P')
               		{
               		 tallyTable[l][k] = ' '; 
               		 countT3++;

              		 } 
               	 }
                }
                
              	 System.out.println("Percent Won Using Split " + ((countT3/290)*100) + "%");
                
                //Double Down Percentage                 
                for (int l = 0; l < tallyTable.length; l++) 
                { 
               	 for (int k = 0; k < tallyTable[l].length; k++) 
               	 { 
               		if (tallyTable[l][k] == 'D')
               		{
               		 tallyTable[l][k] = ' '; 
               		 countT4++;

                }
                }
                }
                
              	 System.out.println("Percent Won Using Double Down " + ((countT4/290)*100) + "%");
                System.out.println("\n\n");

               	
               	 int percent1 = ((countT1/totalTT)*100);
               	 int percent2 = ((countT2/totalTT)*100);
               	 int percent3 = ((countT3/totalTT)*100);
               	 int percent4 = ((countT4/totalTT)*100);
                 System.out.println("\n\n");*/

                /*
                System.out.println("X\t2\t3\t4\t5\t6\t7\t8\t9\t10\tA");
                System.out.println("5\tH\tH\tH\tH\tH\tH\tH\tH\tH\tH");
                System.out.println("6\tH\tH\tH\tH\tH\tH\tH\tH\tH\tH");
                System.out.println("8\tH\tH\tH\tH\tH\tH\tH\tH\tH\tH");
                System.out.println("9\tH\tD\tD\tD\tD\tH\tH\tH\tH\tH");
                System.out.println("10\tD\tD\tD\tD\tD\tD\tD\tD\tH\tH");
                System.out.println("11\tD\tD\tD\tD\tD\tD\tD\tD\tD\tH");
                System.out.println("12\tH\tH\tS\tS\tS\tH\tH\tH\tH\tH");
                System.out.println("13\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH");
                System.out.println("14\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH");
                System.out.println("15\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH");
                System.out.println("16\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH");
                System.out.println("17\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                System.out.println("18\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                System.out.println("19\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                System.out.println("20\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                System.out.println("21\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                System.out.println("A,2\tH\tH\tH\tD\tD\tH\tH\tH\tH\tH");
                System.out.println("A,3\tH\tH\tH\tD\tD\tH\tH\tH\tH\tH");
                System.out.println("A,4\tH\tH\tD\tD\tD\tH\tH\tH\tH\tH");
                System.out.println("A,5\tH\tH\tD\tD\tD\tH\tH\tH\tH\tH");
                System.out.println("A,6\tH\tD\tD\tD\tD\tH\tH\tH\tH\tH");
                System.out.println("A,7\tS\tD\tD\tD\tD\tS\tS\tH\tH\tH");
                System.out.println("A,8\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                System.out.println("A,9\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                System.out.println("A,10\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                System.out.println("A,A\tP\tP\tP\tP\tP\tP\tP\tP\tP\tP");
                System.out.println("2,2\tP\tP\tP\tP\tP\tP\tH\tH\tH\tH");
                System.out.println("3,3\tP\tP\tP\tP\tP\tP\tH\tH\tH\tH");
                System.out.println("4,4\tH\tH\tH\tP\tP\tH\tH\tH\tH\tH");
                System.out.println("5,5\tD\tD\tD\tD\tD\tD\tD\tD\tH\tH");
                System.out.println("6,6\tH\tP\tP\tP\tP\tH\tH\tH\tH\tH");
                System.out.println("7,7\tP\tP\tP\tP\tP\tP\tH\tH\tH\tH");
                System.out.println("8,8\tP\tP\tP\tP\tP\tP\tP\tP\tP\tP");
                System.out.println("9,9\tP\tP\tP\tP\tP\tP\tP\tP\tS\tS");
                System.out.println("10,10\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS"); */

                 /*
                String content ="X\t2\t3\t4\t5\t6\t7\t8\t9\t10\tA";
                String content2 ="8\tH\tH\tH\tH\tH\tH\tH\tH\tH\tH";
                String content3 ="9\tH\tD\tD\tD\tD\tH\tH\tH\tH\tH";
                String content4 ="10\tD\tD\tD\tD\tD\tD\tD\tD\tH\tH";
                String content5 ="11\tD\tD\tD\tD\tD\tD\tD\tD\tD\tH";
                String content6 ="12\tH\tH\tS\tS\tS\tH\tH\tH\tH\tH";
                String content7 ="13\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH";
                String content8 ="14\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH";
                String content9 ="15\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH";
                String content10 ="16\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH";
                String content11 ="17\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS";
                String content12 ="A,2\tH\tH\tH\tD\tD\tH\tH\tH\tH\tH";
                String content13 ="A,3\tH\tH\tH\tD\tD\tH\tH\tH\tH\tH";
                String content14 ="A,4\tH\tH\tD\tD\tD\tH\tH\tH\tH\tH";
                String content15 ="A,5\tH\tH\tD\tD\tD\tH\tH\tH\tH\tH";
                String content16 ="A,6\tH\tD\tD\tD\tD\tH\tH\tH\tH\tH";
                String content17 ="A,7\tS\tD\tD\tD\tD\tS\tS\tH\tH\tH";
                String content18 ="A,8\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS";
                String content19 ="A,9\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS";
                String content20 ="A,10\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS";
                String content21 ="A,A\tP\tP\tP\tP\tP\tP\tP\tP\tP\tP";
                String content22 ="2,2\tP\tP\tP\tP\tP\tP\tH\tH\tH\tH";
                String content23 ="3,3\tP\tP\tP\tP\tP\tP\tH\tH\tH\tH";
                String content24 ="4,4\tH\tH\tH\tP\tP\tH\tH\tH\tH\tH";
                String content25 ="5,5\tD\tD\tD\tD\tD\tD\tD\tD\tH\tH";
                String content26 ="6,6\tH\tP\tP\tP\tP\tH\tH\tH\tH\tH";
                String content27 ="7,7\tP\tP\tP\tP\tP\tP\tH\tH\tH\tH";
                String content28 ="8,8\tP\tP\tP\tP\tP\tP\tP\tP\tP\tP";
                String content29 ="9,9\tP\tP\tP\tP\tP\tP\tP\tP\tS\tS";
                String content30 ="10,10\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS";*/                		
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
              System.out.println("");
              System.out.println("");
              
              try 
              {

      			File file = new File("/Users/4leaf/Desktop/strategyCard.txt");

      			// if file doesn't exists, then create it
      			if (!file.exists()) 
      			{
      				file.createNewFile();
      		    }
              
              //////////////////////////////////////////////////////////////////////////////////////////////////////////
              //System.out.println("  |-----------------------------------------------------------------------|");
              //System.out.println("\t   P \t\t   S \t\t    H \t\t        D \t");
              //System.out.println("  |-----------------------------------------------------------------------|");

              //System.out.println("  |               |                 |                  |                  |" );
              //System.out.println("  |       0%      |       55%       |      30%         |       15%        |" );
              //System.out.println("  |               |                 |                  |                  |" );
              //System.out.println("  |               |                 |                  |                  |" );
              //System.out.println("  |-----------------------------------------------------------------------|");

              /*//End Delimeter
              System.out.println("");
              System.out.println("");
    	      String content = "  |-----------------------------------------------------------------------|";
    	      String content2 = "\t   P \t\t   S \t\t    H \t\t        D \t";
    	      String content3 = "  |-----------------------------------------------------------------------|";
    	      String content4 = "  |               |                 |                  |                  |";
    	      String content5 = "  |       0%      |       55%       |      30%         |       15%        |";
    	      String content6 = "  |               |                 |                  |                  |";
    	      String content7 = "  |               |                 |                  |                  |";
    	      String content8 = "  |-----------------------------------------------------------------------|";*/
    	      
              FileWriter fw = new FileWriter(file.getAbsoluteFile());
    		  BufferedWriter bw = new BufferedWriter(fw);
    		  	bw.write(content);
    			bw.newLine();
    			bw.write(content2);
    			bw.newLine();
    			bw.write(content3);
    			bw.newLine();
    			bw.write(content4);
    			bw.newLine();
    			bw.write(content5);
    			bw.newLine();
    			bw.write(content6);
    			bw.newLine();
    			bw.write(content7);
    			bw.newLine();
    			bw.write(content8);
    			bw.newLine();
    			bw.write(content9);
    			bw.newLine();
    			bw.write(content10);
    			bw.newLine();
    			bw.write(content11);
    			bw.newLine();
    			bw.write(content12);
    			bw.newLine();
    			bw.write(content13);
    			bw.newLine();
    			bw.write(content14);
    			bw.newLine();
    			bw.write(content15);
    			bw.newLine();
    			bw.write(content16);
    			bw.newLine();
    			bw.write(content17);
    			bw.newLine();
    			bw.write(content18);
    			bw.newLine();
    			bw.write(content19);
    			bw.newLine();
    			bw.write(content20);
    			bw.newLine();
    			bw.write(content21);
    			bw.newLine();
    			bw.write(content22);
    			bw.newLine();
    			bw.write(content23);
    			bw.newLine();
    			bw.write(content24);
    			bw.newLine();
    			bw.write(content25);
    			bw.newLine();
    			bw.write(content26);
    			bw.newLine();
    			bw.write(content27);
    			bw.newLine();
    			bw.write(content28);
    			bw.newLine();
    			bw.write(content29);
    			bw.newLine();
    			bw.write(content30);
    			bw.newLine();
    			bw.close();
    			System.out.println("Done");

            } 
            catch (IOException e) 
            {
    			e.printStackTrace();
    		  }
      }
         else if (decknumber == 2) /////////////////////////////////////////////////////////////////////////////////////////
         {
        	 sql = "SELECT * FROM blackjackdatabase2";
             rs = stmt.executeQuery(sql);
            
             while(rs.next())
             {
               int id  = rs.getInt("idBlackJackDatabase");
               String CardValue = rs.getString("CardValue");
                  
               /*System.out.print("ID: " + id);
               System.out.println(", CardValue: " + CardValue);*/
             }
             
             /*System.out.println("");
             System.out.println("Frequency Table");
             //System.out.println("Randomized Set of 20 Integers: ");
             System.out.println("");*/
             
             for(int Rnd = 0; Rnd < freq; Rnd++)
             {
           	  
             count = 0;
             
             sql2 = "SELECT * FROM blackjackdatabase2 ORDER BY RAND() LIMIT 20;";
             rs2 = stmt.executeQuery(sql2);
             
             while(rs2.next())
             {
           	 
           	int id  = rs2.getInt("idBlackJackDatabase");
           	
           	String CardValue = rs2.getString("CardValue");
           	
           	cards[count] = CardValue;
           	count++;
                                
               /*System.out.print("ID: " + id);
               System.out.println(", CardValue: " + CardValue);*/
             }
             
             /*System.out.println("");
             System.out.println("Your cards are....");
             System.out.println("");*/

             UserCard1 = cards[0];
             /*              System.out.println("User Card 1 : " + UserCard1);
             */              DealerCard1 = cards[1];
             /*              System.out.println("Dealer Card Down.... ");
             */              UserCard2 = cards[2];
             /*              System.out.println("User Card 2 : " + UserCard2);
             */              DealerCard2 = cards[3];
             /*              System.out.println("Dealer Card Shown: " + DealerCard2);*/
/*                             System.out.println("");
*/             				
             				/*System.out.println("User Card 1: " + UserCard1);
             				System.out.println("Dealer Card Down");
             				System.out.println("User Card 2: " + UserCard2);
             				System.out.println("Dealer Card Up: " + DealerCard2);
             				*/
             				if(UserCard1.equals("Jack") || UserCard1.equals("Queen") || UserCard1.equals("King"))
             				{
             					U1 = 10;
             				}
             				else if(UserCard1.equals("Ace"))
             				{
             					U1 = 1;
             				}
             				else
             				{
             					U1 = Integer.parseInt(UserCard1);
             				}
             				
             				
             				
             				if(UserCard2.equals("Jack") || UserCard2.equals("Queen") || UserCard2.equals("King"))
             				{
             					U2 = 10;
             				}
             				else if(UserCard2.equals("Ace"))
             				{
             					U2 = 1;
             				}
             				else
             				{
             					U2 = Integer.parseInt(UserCard2);
             				}
             				
             				
             				
             				if(DealerCard1.equals("Jack") || DealerCard1.equals("Queen") || DealerCard1.equals("King"))
             				{
             					D1 = 10;
             				}
             				else if(DealerCard1.equals("Ace"))
             				{
             					D1 = 1;
             				}
             				else
             				{
             					D1 = Integer.parseInt(DealerCard1);
             				}
             				
             				
             				
             				if(DealerCard2.equals("Jack") || DealerCard2.equals("Queen") || DealerCard2.equals("King"))
             				{
             					D2 = 10;
             				}
             				else if(DealerCard2.equals("Ace"))
             				{
             					D2 = 1;
             				}
             				else
             				{
             					D2 = Integer.parseInt(DealerCard2);
             				}
             				
             				
             				if(UserCard1.equals("Ace") && UserCard2.equals("Ace"))
             				{
             					totalU = 21;
             				}
             		 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
             		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
             				if(UserCard1.equals("Ace") && !UserCard2.equals("Ace"))
             				{
             					U1 = 11;
             				}
             				
             				if(UserCard2.equals("Ace") && !UserCard1.equals("Ace"))
             				{
             					U2 = 11;
             				}
             				
             				if(DealerCard1.equals("Ace") && !DealerCard2.equals("Ace"))
             				{
             					D1 = 11;
             				}
             				
             				if(DealerCard2.equals("Ace") && !DealerCard1.equals("Ace"))
             				{
             					D2 = 11;
             				}
             		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
            	            //System.out.println("");
            				totalU = U1 + U2;
            	            totalD = D2;
            	            int totalDw2 = D1 + D2;
            	            /*
            	            System.out.println("User Card 1: " + U1);
            	            System.out.println("User Card 2: " + U2);
            				System.out.println("User Total: " + totalU);
            				System.out.println("Dealer Shown: " + D2);
            				System.out.println("Dealer Total: " + totalDw2);
                            */
                          /*  System.out.println("");
                            System.out.println("----------");
                            
                            
                            
                            //System.out.println(StrategyMethod(U1, U2, totalDw2));
                            System.out.println("");
                            System.out.println("");
                            System.out.println("");*/
                   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
                            
                            	if(totalU < 8)
                            	{
                            		SearchCond5 = "8";
                            	}
                            	else if(totalU > 17)
                            	{
                            		SearchCond5 = "17";
                            	}
                            	else
                            	{
                            		SearchCond5 = String.valueOf(totalU);
                            	}
                            	
                            	
            					if(DealerCard2.equals("Jack"))
                            	{
                            		DealerCardString5 = "10";
                            	}
            					
            					if(DealerCard2.equals("Queen"))
                            	{
                            		DealerCardString5 = "10";
                            	}
            					
            					if(DealerCard2.equals("King"))
                            	{
                            		DealerCardString5 = "10";
                            	}
            					
            					if(DealerCard2.equals("Ace"))
                            	{
                            		DealerCardString5 = "A";
                            	}
            					
            					String U1W, U2W;
            					if(UserCard1.equals("Ace"))
            					{
            						U1W = "A";
            					}
            					else
            					{
            						U1W = UserCard1;
            					}
            					
            					if(UserCard2.equals("Ace"))
            					{
            						U2W = "A";
            					}
            					else
            					{
            						U2W = UserCard2;
            					}
            					
            					String UserCheck = U1W + "," + U2W;
            					
            					
                              for (index = 0; index < 29; index++) 
                              {
                                //if index of user array is equal to the user total
                                if (tallyArrayUser[index].equals(SearchCond5)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } 
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } 
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } 
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } 
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } 
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } 
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                

                                //looping through dealer array
                                for (index2 = 0; index2 < 10; index2++) 
                                {
                                  //if index of dealer array is equal to the dealer total
                                  if (tallyArrayDealer[index2].equals(DealerCard2) || tallyArrayDealer[index2].equals(DealerCardString5)) 
                                  {
                                    //initialize j to index
                                    //System.out.println("The current j is "+ j );
                                    j = index2;
                                    //reset index value
                                    break;
                                    
                                  }

                                }
                                tallyTable[i][j] = StrategyMethod(U1, U2, totalDw2);

                                // System.out.println("TALLY BEFORE: " + tallyTable[i][j]);
                                // System.out.println("TALLY AFTER: " + tallyTable[i][j]);
                                // System.out.println("TALLY BEFORE: " + tallyTable[index][index2]);
                                // tallyTable[index][index2]++;
                                // System.out.println("TALLY AFTER: " + tallyTable[index][index2]);
                              }
                            }
                            
                            
                     /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
                            
                            System.out.println("\n\n");
                            System.out.println("\t ---------------------------------------------------------------------------");
                            System.out.println("\t   2 \t 3 \t 4 \t 5 \t 6 \t 7 \t 8 \t 9 \t 10 \t A ");
                            System.out.println("\t ---------------------------------------------------------------------------");

                            System.out.println("        |");
                            System.out.println("  8     |   " + tallyTable[0][0] + "  \t  " + tallyTable[0][1] + "\t" + tallyTable[0][2] + "\t" + tallyTable[0][3] + "\t" + tallyTable[0][4] + "\t" + tallyTable[0][5] + "\t" + tallyTable[0][6] + "\t" + tallyTable[0][7] + "\t" + tallyTable[0][8] + "\t" + tallyTable[0][9]);
                            System.out.println("  9     |   " + tallyTable[1][0] + "  \t  " + tallyTable[1][1] + "\t" + tallyTable[1][2] + "\t" + tallyTable[1][3] + "\t" + tallyTable[1][4] + "\t" + tallyTable[1][5] + "\t" + tallyTable[1][6] + "\t" + tallyTable[1][7] + "\t" + tallyTable[1][8] + "\t" + tallyTable[1][9]);
                            System.out.println("  10    |   " + tallyTable[2][0] + "  \t  " + tallyTable[2][1] + "\t" + tallyTable[2][2] + "\t" + tallyTable[2][3] + "\t" + tallyTable[2][4] + "\t" + tallyTable[2][5] + "\t" + tallyTable[2][6] + "\t" + tallyTable[2][7] + "\t" + tallyTable[2][8] + "\t" + tallyTable[2][9]);
                            System.out.println("  11    |   " + tallyTable[3][0] + "  \t  " + tallyTable[3][1] + "\t" + tallyTable[3][2] + "\t" + tallyTable[3][3] + "\t" + tallyTable[3][4] + "\t" + tallyTable[3][5] + "\t" + tallyTable[3][6] + "\t" + tallyTable[3][7] + "\t" + tallyTable[3][8] + "\t" + tallyTable[3][9]);
                            System.out.println("  12    |   " + tallyTable[4][0] + "  \t  " + tallyTable[4][1] + "\t" + tallyTable[4][2] + "\t" + tallyTable[4][3] + "\t" + tallyTable[4][4] + "\t" + tallyTable[4][5] + "\t" + tallyTable[4][6] + "\t" + tallyTable[4][7] + "\t" + tallyTable[4][8] + "\t" + tallyTable[4][9]);
                            System.out.println("  13    |   " + tallyTable[5][0] + "  \t  " + tallyTable[5][1] + "\t" + tallyTable[5][2] + "\t" + tallyTable[5][3] + "\t" + tallyTable[5][4] + "\t" + tallyTable[5][5] + "\t" + tallyTable[5][6] + "\t" + tallyTable[5][7] + "\t" + tallyTable[5][8] + "\t" + tallyTable[5][9]);
                            System.out.println("  14    |   " + tallyTable[6][0] + "  \t  " + tallyTable[6][1] + "\t" + tallyTable[6][2] + "\t" + tallyTable[6][3] + "\t" + tallyTable[6][4] + "\t" + tallyTable[6][5] + "\t" + tallyTable[6][6] + "\t" + tallyTable[6][7] + "\t" + tallyTable[6][8] + "\t" + tallyTable[6][9]);
                            System.out.println("  15    |   " + tallyTable[7][0] + "  \t  " + tallyTable[7][1] + "\t" + tallyTable[7][2] + "\t" + tallyTable[7][3] + "\t" + tallyTable[7][4] + "\t" + tallyTable[7][5] + "\t" + tallyTable[7][6] + "\t" + tallyTable[7][7] + "\t" + tallyTable[7][8] + "\t" + tallyTable[7][9]);
                            System.out.println("  16    |   " + tallyTable[8][0] + "  \t  " + tallyTable[8][1] + "\t" + tallyTable[8][2] + "\t" + tallyTable[8][3] + "\t" + tallyTable[8][4] + "\t" + tallyTable[8][5] + "\t" + tallyTable[8][6] + "\t" + tallyTable[8][7] + "\t" + tallyTable[8][8] + "\t" + tallyTable[8][9]);
                            System.out.println("  17    |   " + tallyTable[9][0] + "  \t  " + tallyTable[9][1] + "\t" + tallyTable[9][2] + "\t" + tallyTable[9][3] + "\t" + tallyTable[9][4] + "\t" + tallyTable[9][5] + "\t" + tallyTable[9][6] + "\t" + tallyTable[9][7] + "\t" + tallyTable[9][8] + "\t" + tallyTable[9][9]);
                            System.out.println("  2,2   |   " + tallyTable[10][0] + "  \t  " + tallyTable[10][1] + "\t" + tallyTable[10][2] + "\t" + tallyTable[10][3] + "\t" + tallyTable[10][4] + "\t" + tallyTable[10][5] + "\t" + tallyTable[10][6] + "\t" + tallyTable[10][7] + "\t" + tallyTable[10][8] + "\t" + tallyTable[10][9]);
                            System.out.println("  3,3   |   " + tallyTable[11][0] + "  \t  " + tallyTable[11][1] + "\t" + tallyTable[11][2] + "\t" + tallyTable[11][3] + "\t" + tallyTable[11][4] + "\t" + tallyTable[11][5] + "\t" + tallyTable[11][6] + "\t" + tallyTable[11][7] + "\t" + tallyTable[11][8] + "\t" + tallyTable[11][9]);
                            System.out.println("  4,4   |   " + tallyTable[12][0] + "  \t  " + tallyTable[12][1] + "\t" + tallyTable[12][2] + "\t" + tallyTable[12][3] + "\t" + tallyTable[12][4] + "\t" + tallyTable[12][5] + "\t" + tallyTable[12][6] + "\t" + tallyTable[12][7] + "\t" + tallyTable[12][8] + "\t" + tallyTable[12][9]);
                            System.out.println("  5,5   |   " + tallyTable[13][0] + "  \t  " + tallyTable[13][1] + "\t" + tallyTable[13][2] + "\t" + tallyTable[13][3] + "\t" + tallyTable[13][4] + "\t" + tallyTable[13][5] + "\t" + tallyTable[13][6] + "\t" + tallyTable[13][7] + "\t" + tallyTable[13][8] + "\t" + tallyTable[13][9]);
                            System.out.println("  6,6   |   " + tallyTable[14][0] + "  \t  " + tallyTable[14][1] + "\t" + tallyTable[14][2] + "\t" + tallyTable[14][3] + "\t" + tallyTable[14][4] + "\t" + tallyTable[14][5] + "\t" + tallyTable[14][6] + "\t" + tallyTable[14][7] + "\t" + tallyTable[14][8] + "\t" + tallyTable[14][9]);
                            System.out.println("  7,7   |   " + tallyTable[15][0] + "  \t  " + tallyTable[15][1] + "\t" + tallyTable[15][2] + "\t" + tallyTable[15][3] + "\t" + tallyTable[15][4] + "\t" + tallyTable[15][5] + "\t" + tallyTable[15][6] + "\t" + tallyTable[15][7] + "\t" + tallyTable[15][8] + "\t" + tallyTable[15][9]);
                            System.out.println("  8,8   |   " + tallyTable[16][0] + "  \t  " + tallyTable[16][1] + "\t" + tallyTable[16][2] + "\t" + tallyTable[16][3] + "\t" + tallyTable[16][4] + "\t" + tallyTable[16][5] + "\t" + tallyTable[16][6] + "\t" + tallyTable[16][7] + "\t" + tallyTable[16][8] + "\t" + tallyTable[16][9]);
                            System.out.println("  9,9   |   " + tallyTable[17][0] + "  \t  " + tallyTable[17][1] + "\t" + tallyTable[17][2] + "\t" + tallyTable[17][3] + "\t" + tallyTable[17][4] + "\t" + tallyTable[17][5] + "\t" + tallyTable[17][6] + "\t" + tallyTable[17][7] + "\t" + tallyTable[17][8] + "\t" + tallyTable[17][9]);
                            System.out.println("  10,10 |   " + tallyTable[18][0] + "  \t  " + tallyTable[18][1] + "\t" + tallyTable[18][2] + "\t" + tallyTable[18][3] + "\t" + tallyTable[18][4] + "\t" + tallyTable[18][5] + "\t" + tallyTable[18][6] + "\t" + tallyTable[18][7] + "\t" + tallyTable[18][8] + "\t" + tallyTable[18][9]);
                            System.out.println("  A,2   |   " + tallyTable[19][0] + "  \t  " + tallyTable[19][1] + "\t" + tallyTable[19][2] + "\t" + tallyTable[19][3] + "\t" + tallyTable[19][4] + "\t" + tallyTable[19][5] + "\t" + tallyTable[19][6] + "\t" + tallyTable[19][7] + "\t" + tallyTable[19][8] + "\t" + tallyTable[19][9]);
                            System.out.println("  A,3   |   " + tallyTable[20][0] + "  \t  " + tallyTable[20][1] + "\t" + tallyTable[20][2] + "\t" + tallyTable[20][3] + "\t" + tallyTable[20][4] + "\t" + tallyTable[20][5] + "\t" + tallyTable[20][6] + "\t" + tallyTable[20][7] + "\t" + tallyTable[20][8] + "\t" + tallyTable[20][9]);
                            System.out.println("  A,4   |   " + tallyTable[21][0] + "  \t  " + tallyTable[21][1] + "\t" + tallyTable[21][2] + "\t" + tallyTable[21][3] + "\t" + tallyTable[21][4] + "\t" + tallyTable[21][5] + "\t" + tallyTable[21][6] + "\t" + tallyTable[21][7] + "\t" + tallyTable[21][8] + "\t" + tallyTable[21][9]);
                            System.out.println("  A,5   |   " + tallyTable[22][0] + "  \t  " + tallyTable[22][1] + "\t" + tallyTable[22][2] + "\t" + tallyTable[22][3] + "\t" + tallyTable[22][4] + "\t" + tallyTable[22][5] + "\t" + tallyTable[22][6] + "\t" + tallyTable[22][7] + "\t" + tallyTable[22][8] + "\t" + tallyTable[22][9]);
                            System.out.println("  A,6   |   " + tallyTable[23][0] + "  \t  " + tallyTable[23][1] + "\t" + tallyTable[23][2] + "\t" + tallyTable[23][3] + "\t" + tallyTable[23][4] + "\t" + tallyTable[23][5] + "\t" + tallyTable[23][6] + "\t" + tallyTable[23][7] + "\t" + tallyTable[23][8] + "\t" + tallyTable[23][9]);
                            System.out.println("  A,7   |   " + tallyTable[24][0] + "  \t  " + tallyTable[24][1] + "\t" + tallyTable[24][2] + "\t" + tallyTable[24][3] + "\t" + tallyTable[24][4] + "\t" + tallyTable[24][5] + "\t" + tallyTable[24][6] + "\t" + tallyTable[24][7] + "\t" + tallyTable[24][8] + "\t" + tallyTable[24][9]);
                            System.out.println("  A,8   |   " + tallyTable[25][0] + "  \t  " + tallyTable[25][1] + "\t" + tallyTable[25][2] + "\t" + tallyTable[25][3] + "\t" + tallyTable[25][4] + "\t" + tallyTable[25][5] + "\t" + tallyTable[25][6] + "\t" + tallyTable[25][7] + "\t" + tallyTable[25][8] + "\t" + tallyTable[25][9]);
                            System.out.println("  A,9   |   " + tallyTable[26][0] + "  \t  " + tallyTable[26][1] + "\t" + tallyTable[26][2] + "\t" + tallyTable[26][3] + "\t" + tallyTable[26][4] + "\t" + tallyTable[26][5] + "\t" + tallyTable[26][6] + "\t" + tallyTable[26][7] + "\t" + tallyTable[26][8] + "\t" + tallyTable[26][9]);
                            System.out.println("  A,10  |   " + tallyTable[27][0] + "  \t  " + tallyTable[27][1] + "\t" + tallyTable[27][2] + "\t" + tallyTable[27][3] + "\t" + tallyTable[27][4] + "\t" + tallyTable[27][5] + "\t" + tallyTable[27][6] + "\t" + tallyTable[27][7] + "\t" + tallyTable[27][8] + "\t" + tallyTable[27][9]);
                            System.out.println("  A,A   |   " + tallyTable[28][0] + "  \t  " + tallyTable[28][1] + "\t" + tallyTable[28][2] + "\t" + tallyTable[28][3] + "\t" + tallyTable[28][4] + "\t" + tallyTable[28][5] + "\t" + tallyTable[28][6] + "\t" + tallyTable[28][7] + "\t" + tallyTable[28][8] + "\t" + tallyTable[28][9]);
                            
                            String content ="X\t2\t3\t4\t5\t6\t7\t8\t9\t10\tA";
                            String content2 ="8" + "\t" + tallyTable[0][0] + "\t" + tallyTable[0][1] + "\t" + tallyTable[0][2] + "\t" + tallyTable[0][3] + "\t" + tallyTable[0][4] + "\t" + tallyTable[0][5] + "\t" + tallyTable[0][6] + "\t" + tallyTable[0][7] + "\t" + tallyTable[0][8] + "\t" + tallyTable[0][9];
                            String content3 ="9" + "\t" + tallyTable[1][0] + "\t" + tallyTable[1][1] + "\t" + tallyTable[1][2] + "\t" + tallyTable[1][3] + "\t" + tallyTable[1][4] + "\t" + tallyTable[1][5] + "\t" + tallyTable[1][6] + "\t" + tallyTable[1][7] + "\t" + tallyTable[1][8] + "\t" + tallyTable[1][9];
                            String content4 ="10" + "\t" + tallyTable[2][0] + "\t" + tallyTable[2][1] + "\t" + tallyTable[2][2] + "\t" + tallyTable[2][3] + "\t" + tallyTable[2][4] + "\t" + tallyTable[2][5] + "\t" + tallyTable[2][6] + "\t" + tallyTable[2][7] + "\t" + tallyTable[2][8] + "\t" + tallyTable[2][9];
                            String content5 ="11" + "\t" + tallyTable[3][0] + "\t" + tallyTable[3][1] + "\t" + tallyTable[3][2] + "\t" + tallyTable[3][3] + "\t" + tallyTable[3][4] + "\t" + tallyTable[3][5] + "\t" + tallyTable[3][6] + "\t" + tallyTable[3][7] + "\t" + tallyTable[3][8] + "\t" + tallyTable[3][9];
                            String content6 ="12" + "\t" + tallyTable[4][0] + "\t" + tallyTable[4][1] + "\t" + tallyTable[4][2] + "\t" + tallyTable[4][3] + "\t" + tallyTable[4][4] + "\t" + tallyTable[4][5] + "\t" + tallyTable[4][6] + "\t" + tallyTable[4][7] + "\t" + tallyTable[4][8] + "\t" + tallyTable[4][9];
                            String content7 ="13" + "\t" + tallyTable[5][0] + "\t" + tallyTable[5][1] + "\t" + tallyTable[5][2] + "\t" + tallyTable[5][3] + "\t" + tallyTable[5][4] + "\t" + tallyTable[5][5] + "\t" + tallyTable[5][6] + "\t" + tallyTable[5][7] + "\t" + tallyTable[5][8] + "\t" + tallyTable[5][9];
                            String content8 ="14" + "\t" + tallyTable[6][0] + "\t" + tallyTable[6][1] + "\t" + tallyTable[6][2] + "\t" + tallyTable[6][3] + "\t" + tallyTable[6][4] + "\t" + tallyTable[6][5] + "\t" + tallyTable[6][6] + "\t" + tallyTable[6][7] + "\t" + tallyTable[6][8] + "\t" + tallyTable[6][9];
                            String content9 ="15" + "\t" + tallyTable[7][0] + "\t" + tallyTable[7][1] + "\t" + tallyTable[7][2] + "\t" + tallyTable[7][3] + "\t" + tallyTable[7][4] + "\t" + tallyTable[7][5] + "\t" + tallyTable[7][6] + "\t" + tallyTable[7][7] + "\t" + tallyTable[7][8] + "\t" + tallyTable[7][9];
                            String content10 ="16" + "\t" + tallyTable[8][0] + "\t" + tallyTable[8][1] + "\t" + tallyTable[8][2] + "\t" + tallyTable[8][3] + "\t" + tallyTable[8][4] + "\t" + tallyTable[8][5] + "\t" + tallyTable[8][6] + "\t" + tallyTable[8][7] + "\t" + tallyTable[8][8] + "\t" + tallyTable[8][9];
                            String content11 ="17" + "\t" + tallyTable[9][0] + "\t" + tallyTable[9][1] + "\t" + tallyTable[9][2] + "\t" + tallyTable[9][3] + "\t" + tallyTable[9][4] + "\t" + tallyTable[9][5] + "\t" + tallyTable[9][6] + "\t" + tallyTable[9][7] + "\t" + tallyTable[9][8] + "\t" + tallyTable[9][9];
                            String content12 ="2,2" + "\t" + tallyTable[10][0] + "\t" + tallyTable[10][1] + "\t" + tallyTable[10][2] + "\t" + tallyTable[10][3] + "\t" + tallyTable[10][4] + "\t" + tallyTable[10][5] + "\t" + tallyTable[10][6] + "\t" + tallyTable[10][7] + "\t" + tallyTable[10][8] + "\t" + tallyTable[10][9];
                            String content13 ="3,3" + "\t" + tallyTable[11][0] + "\t" + tallyTable[11][1] + "\t" + tallyTable[11][2] + "\t" + tallyTable[11][3] + "\t" + tallyTable[11][4] + "\t" + tallyTable[11][5] + "\t" + tallyTable[11][6] + "\t" + tallyTable[11][7] + "\t" + tallyTable[11][8] + "\t" + tallyTable[11][9];
                            String content14 ="4,4" + "\t" + tallyTable[12][0] + "\t" + tallyTable[12][1] + "\t" + tallyTable[12][2] + "\t" + tallyTable[12][3] + "\t" + tallyTable[12][4] + "\t" + tallyTable[12][5] + "\t" + tallyTable[12][6] + "\t" + tallyTable[12][7] + "\t" + tallyTable[12][8] + "\t" + tallyTable[12][9];
                            String content15 ="5,5" + "\t" + tallyTable[13][0] + "\t" + tallyTable[13][1] + "\t" + tallyTable[13][2] + "\t" + tallyTable[13][3] + "\t" + tallyTable[13][4] + "\t" + tallyTable[13][5] + "\t" + tallyTable[13][6] + "\t" + tallyTable[13][7] + "\t" + tallyTable[13][8] + "\t" + tallyTable[13][9];
                            String content16 ="6,6" + "\t" + tallyTable[14][0] + "\t" + tallyTable[14][1] + "\t" + tallyTable[14][2] + "\t" + tallyTable[14][3] + "\t" + tallyTable[14][4] + "\t" + tallyTable[14][5] + "\t" + tallyTable[14][6] + "\t" + tallyTable[14][7] + "\t" + tallyTable[14][8] + "\t" + tallyTable[14][9];
                            String content17 ="7,7" + "\t" + tallyTable[15][0] + "\t" + tallyTable[15][1] + "\t" + tallyTable[15][2] + "\t" + tallyTable[15][3] + "\t" + tallyTable[15][4] + "\t" + tallyTable[15][5] + "\t" + tallyTable[15][6] + "\t" + tallyTable[15][7] + "\t" + tallyTable[15][8] + "\t" + tallyTable[15][9];
                            String content18 ="8,8" + "\t" + tallyTable[16][0] + "\t" + tallyTable[16][1] + "\t" + tallyTable[16][2] + "\t" + tallyTable[16][3] + "\t" + tallyTable[16][4] + "\t" + tallyTable[16][5] + "\t" + tallyTable[16][6] + "\t" + tallyTable[16][7] + "\t" + tallyTable[16][8] + "\t" + tallyTable[16][9];
                            String content19 ="9,9" + "\t" + tallyTable[17][0] + "\t" + tallyTable[17][1] + "\t" + tallyTable[17][2] + "\t" + tallyTable[17][3] + "\t" + tallyTable[17][4] + "\t" + tallyTable[17][5] + "\t" + tallyTable[17][6] + "\t" + tallyTable[17][7] + "\t" + tallyTable[17][8] + "\t" + tallyTable[17][9];
                            String content20 ="10,10" + "\t" + tallyTable[18][0] +"\t" + tallyTable[18][1] + "\t" + tallyTable[18][2] + "\t" + tallyTable[18][3] + "\t" + tallyTable[18][4] + "\t" + tallyTable[18][5] + "\t" + tallyTable[18][6] + "\t" + tallyTable[18][7] + "\t" + tallyTable[18][8] + "\t" + tallyTable[18][9];
                            String content21 ="A,2" + "\t" + tallyTable[19][0] + "\t" + tallyTable[19][1] + "\t" + tallyTable[19][2] + "\t" + tallyTable[19][3] + "\t" + tallyTable[19][4] + "\t" + tallyTable[19][5] + "\t" + tallyTable[19][6] + "\t" + tallyTable[19][7] + "\t" + tallyTable[19][8] + "\t" + tallyTable[19][9];
                            String content22 ="A,3" + "\t" + tallyTable[20][0] + "\t" + tallyTable[20][1] + "\t" + tallyTable[20][2] + "\t" + tallyTable[20][3] + "\t" + tallyTable[20][4] + "\t" + tallyTable[20][5] + "\t" + tallyTable[20][6] + "\t" + tallyTable[20][7] + "\t" + tallyTable[20][8] + "\t" + tallyTable[20][9];
                            String content23 ="A,4" + "\t" + tallyTable[21][0] + "\t" + tallyTable[21][1] + "\t" + tallyTable[21][2] + "\t" + tallyTable[21][3] + "\t" + tallyTable[21][4] + "\t" + tallyTable[21][5] + "\t" + tallyTable[21][6] + "\t" + tallyTable[21][7] + "\t" + tallyTable[21][8] + "\t" + tallyTable[21][9];
                            String content24 ="A,5" + "\t" + tallyTable[22][0] + "\t" + tallyTable[22][1] + "\t" + tallyTable[22][2] + "\t" + tallyTable[22][3] + "\t" + tallyTable[22][4] + "\t" + tallyTable[22][5] + "\t" + tallyTable[22][6] + "\t" + tallyTable[22][7] + "\t" + tallyTable[22][8] + "\t" + tallyTable[22][9];
                            String content25 ="A,6" + "\t" + tallyTable[23][0] + "\t" + tallyTable[23][1] + "\t" + tallyTable[23][2] + "\t" + tallyTable[23][3] + "\t" + tallyTable[23][4] + "\t" + tallyTable[23][5] + "\t" + tallyTable[23][6] + "\t" + tallyTable[23][7] + "\t" + tallyTable[23][8] + "\t" + tallyTable[23][9];
                            String content26 ="A,7" + "\t" + tallyTable[24][0] + "\t" + tallyTable[24][1] + "\t" + tallyTable[24][2] + "\t" + tallyTable[24][3] + "\t" + tallyTable[24][4] + "\t" + tallyTable[24][5] + "\t" + tallyTable[24][6] + "\t" + tallyTable[24][7] + "\t" + tallyTable[24][8] + "\t" + tallyTable[24][9];
                            String content27 ="A,8" + "\t" + tallyTable[25][0] + "\t" + tallyTable[25][1] + "\t" + tallyTable[25][2] + "\t" + tallyTable[25][3] + "\t" + tallyTable[25][4] + "\t" + tallyTable[25][5] + "\t" + tallyTable[25][6] + "\t" + tallyTable[25][7] + "\t" + tallyTable[25][8] + "\t" + tallyTable[25][9];
                            String content28 ="A,9" + "\t" + tallyTable[26][0] + "\t" + tallyTable[26][1] + "\t" + tallyTable[26][2] + "\t" + tallyTable[26][3] + "\t" + tallyTable[26][4] + "\t" + tallyTable[26][5] + "\t" + tallyTable[26][6] + "\t" + tallyTable[26][7] + "\t" + tallyTable[26][8] + "\t" + tallyTable[26][9];
                            String content29 ="A,10" + "\t" + tallyTable[27][0] + "\t" + tallyTable[27][1] + "\t" + tallyTable[27][2] + "\t" + tallyTable[27][3] + "\t" + tallyTable[27][4] + "\t" + tallyTable[27][5] + "\t" + tallyTable[27][6] + "\t" + tallyTable[27][7] + "\t" + tallyTable[27][8] + "\t" + tallyTable[27][9];
                            String content30 ="A,A" + "\t" + tallyTable[28][0] + "\t" + tallyTable[28][1] + "\t" + tallyTable[28][2] + "\t" + tallyTable[28][3] + "\t" + tallyTable[28][4] + "\t" + tallyTable[28][5] + "\t" + tallyTable[28][6] + "\t" + tallyTable[28][7] + "\t" + tallyTable[28][8] + "\t" + tallyTable[28][9];
                            
                            /*System.out.println("");*/
                                           
                           /* //Hit Percentage
                            for (int l = 0; l < tallyTable.length; l++) 
                            { 
                           	 for (int k = 0; k < tallyTable[l].length; k++) 
                           	 { 
                           		 if (tallyTable[l][k] == 'H')
                           		 {
                           		 tallyTable[l][k] = ' '; 
                           		 countT1++;
                           		 } 
                           	 }
                            }
                            
                       		System.out.println("Percent Won Using Hit " + ((countT1/290)*100) + "%");
                          	 
                            //Stand Percentage
                            for (int l = 0; l < tallyTable.length; l++) 
                            { 
                           	 for (int k = 0; k < tallyTable[l].length; k++) 
                           	 { 
                           		if (tallyTable[l][k] == 'S')
                           		{
                           		 tallyTable[l][k] = ' '; 
                           		 countT2++;

                          		 } 
                            }
                            }
                            
                          	 System.out.println("Percent Won Using Stand " + ((countT2/290)*100) + "%");
                            
                            //Split Percentage
                            for (int l = 0; l < tallyTable.length; l++) 
                            { 
                           	 for (int k = 0; k < tallyTable[l].length; k++) 
                           	 { 
                           		if (tallyTable[l][k] == 'P')
                           		{
                           		 tallyTable[l][k] = ' '; 
                           		 countT3++;

                          		 } 
                           	 }
                            }
                            
                          	 System.out.println("Percent Won Using Split " + ((countT3/290)*100) + "%");
                            
                            //Double Down Percentage                 
                            for (int l = 0; l < tallyTable.length; l++) 
                            { 
                           	 for (int k = 0; k < tallyTable[l].length; k++) 
                           	 { 
                           		if (tallyTable[l][k] == 'D')
                           		{
                           		 tallyTable[l][k] = ' '; 
                           		 countT4++;

                            }
                            }
                            }
                            
                          	 System.out.println("Percent Won Using Double Down " + ((countT4/290)*100) + "%");
                            System.out.println("\n\n");

                           	
                           	 int percent1 = ((countT1/totalTT)*100);
                           	 int percent2 = ((countT2/totalTT)*100);
                           	 int percent3 = ((countT3/totalTT)*100);
                           	 int percent4 = ((countT4/totalTT)*100);
                             System.out.println("\n\n");*/

                            /*
                            System.out.println("X\t2\t3\t4\t5\t6\t7\t8\t9\t10\tA");
                            System.out.println("5\tH\tH\tH\tH\tH\tH\tH\tH\tH\tH");
                            System.out.println("6\tH\tH\tH\tH\tH\tH\tH\tH\tH\tH");
                            System.out.println("8\tH\tH\tH\tH\tH\tH\tH\tH\tH\tH");
                            System.out.println("9\tH\tD\tD\tD\tD\tH\tH\tH\tH\tH");
                            System.out.println("10\tD\tD\tD\tD\tD\tD\tD\tD\tH\tH");
                            System.out.println("11\tD\tD\tD\tD\tD\tD\tD\tD\tD\tH");
                            System.out.println("12\tH\tH\tS\tS\tS\tH\tH\tH\tH\tH");
                            System.out.println("13\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH");
                            System.out.println("14\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH");
                            System.out.println("15\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH");
                            System.out.println("16\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH");
                            System.out.println("17\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("18\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("19\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("20\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("21\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("A,2\tH\tH\tH\tD\tD\tH\tH\tH\tH\tH");
                            System.out.println("A,3\tH\tH\tH\tD\tD\tH\tH\tH\tH\tH");
                            System.out.println("A,4\tH\tH\tD\tD\tD\tH\tH\tH\tH\tH");
                            System.out.println("A,5\tH\tH\tD\tD\tD\tH\tH\tH\tH\tH");
                            System.out.println("A,6\tH\tD\tD\tD\tD\tH\tH\tH\tH\tH");
                            System.out.println("A,7\tS\tD\tD\tD\tD\tS\tS\tH\tH\tH");
                            System.out.println("A,8\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("A,9\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("A,10\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("A,A\tP\tP\tP\tP\tP\tP\tP\tP\tP\tP");
                            System.out.println("2,2\tP\tP\tP\tP\tP\tP\tH\tH\tH\tH");
                            System.out.println("3,3\tP\tP\tP\tP\tP\tP\tH\tH\tH\tH");
                            System.out.println("4,4\tH\tH\tH\tP\tP\tH\tH\tH\tH\tH");
                            System.out.println("5,5\tD\tD\tD\tD\tD\tD\tD\tD\tH\tH");
                            System.out.println("6,6\tH\tP\tP\tP\tP\tH\tH\tH\tH\tH");
                            System.out.println("7,7\tP\tP\tP\tP\tP\tP\tH\tH\tH\tH");
                            System.out.println("8,8\tP\tP\tP\tP\tP\tP\tP\tP\tP\tP");
                            System.out.println("9,9\tP\tP\tP\tP\tP\tP\tP\tP\tS\tS");
                            System.out.println("10,10\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS"); */

                             /*
                            String content ="X\t2\t3\t4\t5\t6\t7\t8\t9\t10\tA";
                            String content2 ="8\tH\tH\tH\tH\tH\tH\tH\tH\tH\tH";
                            String content3 ="9\tH\tD\tD\tD\tD\tH\tH\tH\tH\tH";
                            String content4 ="10\tD\tD\tD\tD\tD\tD\tD\tD\tH\tH";
                            String content5 ="11\tD\tD\tD\tD\tD\tD\tD\tD\tD\tH";
                            String content6 ="12\tH\tH\tS\tS\tS\tH\tH\tH\tH\tH";
                            String content7 ="13\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH";
                            String content8 ="14\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH";
                            String content9 ="15\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH";
                            String content10 ="16\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH";
                            String content11 ="17\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS";
                            String content12 ="A,2\tH\tH\tH\tD\tD\tH\tH\tH\tH\tH";
                            String content13 ="A,3\tH\tH\tH\tD\tD\tH\tH\tH\tH\tH";
                            String content14 ="A,4\tH\tH\tD\tD\tD\tH\tH\tH\tH\tH";
                            String content15 ="A,5\tH\tH\tD\tD\tD\tH\tH\tH\tH\tH";
                            String content16 ="A,6\tH\tD\tD\tD\tD\tH\tH\tH\tH\tH";
                            String content17 ="A,7\tS\tD\tD\tD\tD\tS\tS\tH\tH\tH";
                            String content18 ="A,8\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS";
                            String content19 ="A,9\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS";
                            String content20 ="A,10\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS";
                            String content21 ="A,A\tP\tP\tP\tP\tP\tP\tP\tP\tP\tP";
                            String content22 ="2,2\tP\tP\tP\tP\tP\tP\tH\tH\tH\tH";
                            String content23 ="3,3\tP\tP\tP\tP\tP\tP\tH\tH\tH\tH";
                            String content24 ="4,4\tH\tH\tH\tP\tP\tH\tH\tH\tH\tH";
                            String content25 ="5,5\tD\tD\tD\tD\tD\tD\tD\tD\tH\tH";
                            String content26 ="6,6\tH\tP\tP\tP\tP\tH\tH\tH\tH\tH";
                            String content27 ="7,7\tP\tP\tP\tP\tP\tP\tH\tH\tH\tH";
                            String content28 ="8,8\tP\tP\tP\tP\tP\tP\tP\tP\tP\tP";
                            String content29 ="9,9\tP\tP\tP\tP\tP\tP\tP\tP\tS\tS";
                            String content30 ="10,10\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS";*/                		
                    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                          System.out.println("");
                          System.out.println("");
                          
                          try 
                          {

                  			File file = new File("/Users/4leaf/Desktop/strategyCard.txt");

                  			// if file doesn't exists, then create it
                  			if (!file.exists()) 
                  			{
                  				file.createNewFile();
                  		    }
                          
                          //////////////////////////////////////////////////////////////////////////////////////////////////////////
                          //System.out.println("  |-----------------------------------------------------------------------|");
                          //System.out.println("\t   P \t\t   S \t\t    H \t\t        D \t");
                          //System.out.println("  |-----------------------------------------------------------------------|");

                          //System.out.println("  |               |                 |                  |                  |" );
                          //System.out.println("  |       0%      |       55%       |      30%         |       15%        |" );
                          //System.out.println("  |               |                 |                  |                  |" );
                          //System.out.println("  |               |                 |                  |                  |" );
                          //System.out.println("  |-----------------------------------------------------------------------|");

                          /*//End Delimeter
                          System.out.println("");
                          System.out.println("");
                	      String content = "  |-----------------------------------------------------------------------|";
                	      String content2 = "\t   P \t\t   S \t\t    H \t\t        D \t";
                	      String content3 = "  |-----------------------------------------------------------------------|";
                	      String content4 = "  |               |                 |                  |                  |";
                	      String content5 = "  |       0%      |       55%       |      30%         |       15%        |";
                	      String content6 = "  |               |                 |                  |                  |";
                	      String content7 = "  |               |                 |                  |                  |";
                	      String content8 = "  |-----------------------------------------------------------------------|";*/
                	      
                          FileWriter fw = new FileWriter(file.getAbsoluteFile());
                		  BufferedWriter bw = new BufferedWriter(fw);
                		  	bw.write(content);
                			bw.newLine();
                			bw.write(content2);
                			bw.newLine();
                			bw.write(content3);
                			bw.newLine();
                			bw.write(content4);
                			bw.newLine();
                			bw.write(content5);
                			bw.newLine();
                			bw.write(content6);
                			bw.newLine();
                			bw.write(content7);
                			bw.newLine();
                			bw.write(content8);
                			bw.newLine();
                			bw.write(content9);
                			bw.newLine();
                			bw.write(content10);
                			bw.newLine();
                			bw.write(content11);
                			bw.newLine();
                			bw.write(content12);
                			bw.newLine();
                			bw.write(content13);
                			bw.newLine();
                			bw.write(content14);
                			bw.newLine();
                			bw.write(content15);
                			bw.newLine();
                			bw.write(content16);
                			bw.newLine();
                			bw.write(content17);
                			bw.newLine();
                			bw.write(content18);
                			bw.newLine();
                			bw.write(content19);
                			bw.newLine();
                			bw.write(content20);
                			bw.newLine();
                			bw.write(content21);
                			bw.newLine();
                			bw.write(content22);
                			bw.newLine();
                			bw.write(content23);
                			bw.newLine();
                			bw.write(content24);
                			bw.newLine();
                			bw.write(content25);
                			bw.newLine();
                			bw.write(content26);
                			bw.newLine();
                			bw.write(content27);
                			bw.newLine();
                			bw.write(content28);
                			bw.newLine();
                			bw.write(content29);
                			bw.newLine();
                			bw.write(content30);
                			bw.newLine();
                			bw.close();
                			System.out.println("Done");

                        } 
                        catch (IOException e) 
                        {
                			e.printStackTrace();
                		  }
                  }
             
         
         else if(decknumber == 4) //////////////////////////////////////////////////////////////////////////////////////
         {
        	 sql = "SELECT * FROM blackjackdatabase4";
             rs = stmt.executeQuery(sql);
            
             while(rs.next())
             {
               int id  = rs.getInt("idBlackJackDatabase");
               String CardValue = rs.getString("CardValue");
                  
               /*System.out.print("ID: " + id);
               System.out.println(", CardValue: " + CardValue);*/
             }
             
             /*System.out.println("");
             System.out.println("Frequency Table");
             //System.out.println("Randomized Set of 20 Integers: ");
             System.out.println("");*/
             
             for(int Rnd = 0; Rnd < freq; Rnd++)
             {
           	  
             count = 0;
             
             sql2 = "SELECT * FROM blackjackdatabase4 ORDER BY RAND() LIMIT 20;";
             rs2 = stmt.executeQuery(sql2);
             
             while(rs2.next())
             {
           	 
           	int id  = rs2.getInt("idBlackJackDatabase");
           	
           	String CardValue = rs2.getString("CardValue");
           	
           	cards[count] = CardValue;
           	count++;
                                
               /*System.out.print("ID: " + id);
               System.out.println(", CardValue: " + CardValue);*/
             }
             
             /*System.out.println("");
             System.out.println("Your cards are....");
             System.out.println("");*/

             UserCard1 = cards[0];
             /*              System.out.println("User Card 1 : " + UserCard1);
             */              DealerCard1 = cards[1];
             /*              System.out.println("Dealer Card Down.... ");
             */              UserCard2 = cards[2];
             /*              System.out.println("User Card 2 : " + UserCard2);
             */              DealerCard2 = cards[3];
             /*              System.out.println("Dealer Card Shown: " + DealerCard2);*/
                            /* System.out.println("");*/
             				
             				/*System.out.println("User Card 1: " + UserCard1);
             				System.out.println("Dealer Card Down");
             				System.out.println("User Card 2: " + UserCard2);
             				System.out.println("Dealer Card Up: " + DealerCard2);*/
             				
             				if(UserCard1.equals("Jack") || UserCard1.equals("Queen") || UserCard1.equals("King"))
             				{
             					U1 = 10;
             				}
             				else if(UserCard1.equals("Ace"))
             				{
             					U1 = 1;
             				}
             				else
             				{
             					U1 = Integer.parseInt(UserCard1);
             				}
             				
             				
             				
             				if(UserCard2.equals("Jack") || UserCard2.equals("Queen") || UserCard2.equals("King"))
             				{
             					U2 = 10;
             				}
             				else if(UserCard2.equals("Ace"))
             				{
             					U2 = 1;
             				}
             				else
             				{
             					U2 = Integer.parseInt(UserCard2);
             				}
             				
             				
             				
             				if(DealerCard1.equals("Jack") || DealerCard1.equals("Queen") || DealerCard1.equals("King"))
             				{
             					D1 = 10;
             				}
             				else if(DealerCard1.equals("Ace"))
             				{
             					D1 = 1;
             				}
             				else
             				{
             					D1 = Integer.parseInt(DealerCard1);
             				}
             				
             				
             				
             				if(DealerCard2.equals("Jack") || DealerCard2.equals("Queen") || DealerCard2.equals("King"))
             				{
             					D2 = 10;
             				}
             				else if(DealerCard2.equals("Ace"))
             				{
             					D2 = 1;
             				}
             				else
             				{
             					D2 = Integer.parseInt(DealerCard2);
             				}
             				
             				
             				if(UserCard1.equals("Ace") && UserCard2.equals("Ace"))
             				{
             					totalU = 21;
             				}
             		 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
             		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
             				if(UserCard1.equals("Ace") && !UserCard2.equals("Ace"))
             				{
             					U1 = 11;
             				}
             				
             				if(UserCard2.equals("Ace") && !UserCard1.equals("Ace"))
             				{
             					U2 = 11;
             				}
             				
             				if(DealerCard1.equals("Ace") && !DealerCard2.equals("Ace"))
             				{
             					D1 = 11;
             				}
             				
             				if(DealerCard2.equals("Ace") && !DealerCard1.equals("Ace"))
             				{
             					D2 = 11;
             				}
             		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
             				
            	            //System.out.println("");
            				totalU = U1 + U2;
            	            totalD = D2;
            	            int totalDw2 = D1 + D2;
            	            /*
            	            System.out.println("User Card 1: " + U1);
            	            System.out.println("User Card 2: " + U2);
            				System.out.println("User Total: " + totalU);
            				System.out.println("Dealer Shown: " + D2);
            				System.out.println("Dealer Total: " + totalDw2);
                            */
                          /*  System.out.println("");
                            System.out.println("----------");
                            
                            
                            
                            //System.out.println(StrategyMethod(U1, U2, totalDw2));
                            System.out.println("");
                            System.out.println("");
                            System.out.println("");*/
                   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
                            
                            	if(totalU < 8)
                            	{
                            		SearchCond5 = "8";
                            	}
                            	else if(totalU > 17)
                            	{
                            		SearchCond5 = "17";
                            	}
                            	else
                            	{
                            		SearchCond5 = String.valueOf(totalU);
                            	}
                            	
                            	
            					if(DealerCard2.equals("Jack"))
                            	{
                            		DealerCardString5 = "10";
                            	}
            					
            					if(DealerCard2.equals("Queen"))
                            	{
                            		DealerCardString5 = "10";
                            	}
            					
            					if(DealerCard2.equals("King"))
                            	{
                            		DealerCardString5 = "10";
                            	}
            					
            					if(DealerCard2.equals("Ace"))
                            	{
                            		DealerCardString5 = "A";
                            	}
            					
            					String U1W, U2W;
            					if(UserCard1.equals("Ace"))
            					{
            						U1W = "A";
            					}
            					else
            					{
            						U1W = UserCard1;
            					}
            					
            					if(UserCard2.equals("Ace"))
            					{
            						U2W = "A";
            					}
            					else
            					{
            						U2W = UserCard2;
            					}
            					
            					String UserCheck = U1W + "," + U2W;
            					
            					
                              for (index = 0; index < 29; index++) 
                              {
                                //if index of user array is equal to the user total
                                if (tallyArrayUser[index].equals(SearchCond5)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } 
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } 
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } 
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } 
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } 
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } 
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                

                                //looping through dealer array
                                for (index2 = 0; index2 < 10; index2++) 
                                {
                                  //if index of dealer array is equal to the dealer total
                                  if (tallyArrayDealer[index2].equals(DealerCard2) || tallyArrayDealer[index2].equals(DealerCardString5)) 
                                  {
                                    //initialize j to index
                                    //System.out.println("The current j is "+ j );
                                    j = index2;
                                    //reset index value
                                    break;
                                    
                                  }

                                }
                                tallyTable[i][j] = StrategyMethod(U1, U2, totalDw2);

                                // System.out.println("TALLY BEFORE: " + tallyTable[i][j]);
                                // System.out.println("TALLY AFTER: " + tallyTable[i][j]);
                                // System.out.println("TALLY BEFORE: " + tallyTable[index][index2]);
                                // tallyTable[index][index2]++;
                                // System.out.println("TALLY AFTER: " + tallyTable[index][index2]);
                              }
                            }
                            
                            
                     /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
                            
                            System.out.println("\n\n");
                            System.out.println("\t ---------------------------------------------------------------------------");
                            System.out.println("\t   2 \t 3 \t 4 \t 5 \t 6 \t 7 \t 8 \t 9 \t 10 \t A ");
                            System.out.println("\t ---------------------------------------------------------------------------");

                            System.out.println("        |");
                            System.out.println("  8     |   " + tallyTable[0][0] + "  \t  " + tallyTable[0][1] + "\t" + tallyTable[0][2] + "\t" + tallyTable[0][3] + "\t" + tallyTable[0][4] + "\t" + tallyTable[0][5] + "\t" + tallyTable[0][6] + "\t" + tallyTable[0][7] + "\t" + tallyTable[0][8] + "\t" + tallyTable[0][9]);
                            System.out.println("  9     |   " + tallyTable[1][0] + "  \t  " + tallyTable[1][1] + "\t" + tallyTable[1][2] + "\t" + tallyTable[1][3] + "\t" + tallyTable[1][4] + "\t" + tallyTable[1][5] + "\t" + tallyTable[1][6] + "\t" + tallyTable[1][7] + "\t" + tallyTable[1][8] + "\t" + tallyTable[1][9]);
                            System.out.println("  10    |   " + tallyTable[2][0] + "  \t  " + tallyTable[2][1] + "\t" + tallyTable[2][2] + "\t" + tallyTable[2][3] + "\t" + tallyTable[2][4] + "\t" + tallyTable[2][5] + "\t" + tallyTable[2][6] + "\t" + tallyTable[2][7] + "\t" + tallyTable[2][8] + "\t" + tallyTable[2][9]);
                            System.out.println("  11    |   " + tallyTable[3][0] + "  \t  " + tallyTable[3][1] + "\t" + tallyTable[3][2] + "\t" + tallyTable[3][3] + "\t" + tallyTable[3][4] + "\t" + tallyTable[3][5] + "\t" + tallyTable[3][6] + "\t" + tallyTable[3][7] + "\t" + tallyTable[3][8] + "\t" + tallyTable[3][9]);
                            System.out.println("  12    |   " + tallyTable[4][0] + "  \t  " + tallyTable[4][1] + "\t" + tallyTable[4][2] + "\t" + tallyTable[4][3] + "\t" + tallyTable[4][4] + "\t" + tallyTable[4][5] + "\t" + tallyTable[4][6] + "\t" + tallyTable[4][7] + "\t" + tallyTable[4][8] + "\t" + tallyTable[4][9]);
                            System.out.println("  13    |   " + tallyTable[5][0] + "  \t  " + tallyTable[5][1] + "\t" + tallyTable[5][2] + "\t" + tallyTable[5][3] + "\t" + tallyTable[5][4] + "\t" + tallyTable[5][5] + "\t" + tallyTable[5][6] + "\t" + tallyTable[5][7] + "\t" + tallyTable[5][8] + "\t" + tallyTable[5][9]);
                            System.out.println("  14    |   " + tallyTable[6][0] + "  \t  " + tallyTable[6][1] + "\t" + tallyTable[6][2] + "\t" + tallyTable[6][3] + "\t" + tallyTable[6][4] + "\t" + tallyTable[6][5] + "\t" + tallyTable[6][6] + "\t" + tallyTable[6][7] + "\t" + tallyTable[6][8] + "\t" + tallyTable[6][9]);
                            System.out.println("  15    |   " + tallyTable[7][0] + "  \t  " + tallyTable[7][1] + "\t" + tallyTable[7][2] + "\t" + tallyTable[7][3] + "\t" + tallyTable[7][4] + "\t" + tallyTable[7][5] + "\t" + tallyTable[7][6] + "\t" + tallyTable[7][7] + "\t" + tallyTable[7][8] + "\t" + tallyTable[7][9]);
                            System.out.println("  16    |   " + tallyTable[8][0] + "  \t  " + tallyTable[8][1] + "\t" + tallyTable[8][2] + "\t" + tallyTable[8][3] + "\t" + tallyTable[8][4] + "\t" + tallyTable[8][5] + "\t" + tallyTable[8][6] + "\t" + tallyTable[8][7] + "\t" + tallyTable[8][8] + "\t" + tallyTable[8][9]);
                            System.out.println("  17    |   " + tallyTable[9][0] + "  \t  " + tallyTable[9][1] + "\t" + tallyTable[9][2] + "\t" + tallyTable[9][3] + "\t" + tallyTable[9][4] + "\t" + tallyTable[9][5] + "\t" + tallyTable[9][6] + "\t" + tallyTable[9][7] + "\t" + tallyTable[9][8] + "\t" + tallyTable[9][9]);
                            System.out.println("  2,2   |   " + tallyTable[10][0] + "  \t  " + tallyTable[10][1] + "\t" + tallyTable[10][2] + "\t" + tallyTable[10][3] + "\t" + tallyTable[10][4] + "\t" + tallyTable[10][5] + "\t" + tallyTable[10][6] + "\t" + tallyTable[10][7] + "\t" + tallyTable[10][8] + "\t" + tallyTable[10][9]);
                            System.out.println("  3,3   |   " + tallyTable[11][0] + "  \t  " + tallyTable[11][1] + "\t" + tallyTable[11][2] + "\t" + tallyTable[11][3] + "\t" + tallyTable[11][4] + "\t" + tallyTable[11][5] + "\t" + tallyTable[11][6] + "\t" + tallyTable[11][7] + "\t" + tallyTable[11][8] + "\t" + tallyTable[11][9]);
                            System.out.println("  4,4   |   " + tallyTable[12][0] + "  \t  " + tallyTable[12][1] + "\t" + tallyTable[12][2] + "\t" + tallyTable[12][3] + "\t" + tallyTable[12][4] + "\t" + tallyTable[12][5] + "\t" + tallyTable[12][6] + "\t" + tallyTable[12][7] + "\t" + tallyTable[12][8] + "\t" + tallyTable[12][9]);
                            System.out.println("  5,5   |   " + tallyTable[13][0] + "  \t  " + tallyTable[13][1] + "\t" + tallyTable[13][2] + "\t" + tallyTable[13][3] + "\t" + tallyTable[13][4] + "\t" + tallyTable[13][5] + "\t" + tallyTable[13][6] + "\t" + tallyTable[13][7] + "\t" + tallyTable[13][8] + "\t" + tallyTable[13][9]);
                            System.out.println("  6,6   |   " + tallyTable[14][0] + "  \t  " + tallyTable[14][1] + "\t" + tallyTable[14][2] + "\t" + tallyTable[14][3] + "\t" + tallyTable[14][4] + "\t" + tallyTable[14][5] + "\t" + tallyTable[14][6] + "\t" + tallyTable[14][7] + "\t" + tallyTable[14][8] + "\t" + tallyTable[14][9]);
                            System.out.println("  7,7   |   " + tallyTable[15][0] + "  \t  " + tallyTable[15][1] + "\t" + tallyTable[15][2] + "\t" + tallyTable[15][3] + "\t" + tallyTable[15][4] + "\t" + tallyTable[15][5] + "\t" + tallyTable[15][6] + "\t" + tallyTable[15][7] + "\t" + tallyTable[15][8] + "\t" + tallyTable[15][9]);
                            System.out.println("  8,8   |   " + tallyTable[16][0] + "  \t  " + tallyTable[16][1] + "\t" + tallyTable[16][2] + "\t" + tallyTable[16][3] + "\t" + tallyTable[16][4] + "\t" + tallyTable[16][5] + "\t" + tallyTable[16][6] + "\t" + tallyTable[16][7] + "\t" + tallyTable[16][8] + "\t" + tallyTable[16][9]);
                            System.out.println("  9,9   |   " + tallyTable[17][0] + "  \t  " + tallyTable[17][1] + "\t" + tallyTable[17][2] + "\t" + tallyTable[17][3] + "\t" + tallyTable[17][4] + "\t" + tallyTable[17][5] + "\t" + tallyTable[17][6] + "\t" + tallyTable[17][7] + "\t" + tallyTable[17][8] + "\t" + tallyTable[17][9]);
                            System.out.println("  10,10 |   " + tallyTable[18][0] + "  \t  " + tallyTable[18][1] + "\t" + tallyTable[18][2] + "\t" + tallyTable[18][3] + "\t" + tallyTable[18][4] + "\t" + tallyTable[18][5] + "\t" + tallyTable[18][6] + "\t" + tallyTable[18][7] + "\t" + tallyTable[18][8] + "\t" + tallyTable[18][9]);
                            System.out.println("  A,2   |   " + tallyTable[19][0] + "  \t  " + tallyTable[19][1] + "\t" + tallyTable[19][2] + "\t" + tallyTable[19][3] + "\t" + tallyTable[19][4] + "\t" + tallyTable[19][5] + "\t" + tallyTable[19][6] + "\t" + tallyTable[19][7] + "\t" + tallyTable[19][8] + "\t" + tallyTable[19][9]);
                            System.out.println("  A,3   |   " + tallyTable[20][0] + "  \t  " + tallyTable[20][1] + "\t" + tallyTable[20][2] + "\t" + tallyTable[20][3] + "\t" + tallyTable[20][4] + "\t" + tallyTable[20][5] + "\t" + tallyTable[20][6] + "\t" + tallyTable[20][7] + "\t" + tallyTable[20][8] + "\t" + tallyTable[20][9]);
                            System.out.println("  A,4   |   " + tallyTable[21][0] + "  \t  " + tallyTable[21][1] + "\t" + tallyTable[21][2] + "\t" + tallyTable[21][3] + "\t" + tallyTable[21][4] + "\t" + tallyTable[21][5] + "\t" + tallyTable[21][6] + "\t" + tallyTable[21][7] + "\t" + tallyTable[21][8] + "\t" + tallyTable[21][9]);
                            System.out.println("  A,5   |   " + tallyTable[22][0] + "  \t  " + tallyTable[22][1] + "\t" + tallyTable[22][2] + "\t" + tallyTable[22][3] + "\t" + tallyTable[22][4] + "\t" + tallyTable[22][5] + "\t" + tallyTable[22][6] + "\t" + tallyTable[22][7] + "\t" + tallyTable[22][8] + "\t" + tallyTable[22][9]);
                            System.out.println("  A,6   |   " + tallyTable[23][0] + "  \t  " + tallyTable[23][1] + "\t" + tallyTable[23][2] + "\t" + tallyTable[23][3] + "\t" + tallyTable[23][4] + "\t" + tallyTable[23][5] + "\t" + tallyTable[23][6] + "\t" + tallyTable[23][7] + "\t" + tallyTable[23][8] + "\t" + tallyTable[23][9]);
                            System.out.println("  A,7   |   " + tallyTable[24][0] + "  \t  " + tallyTable[24][1] + "\t" + tallyTable[24][2] + "\t" + tallyTable[24][3] + "\t" + tallyTable[24][4] + "\t" + tallyTable[24][5] + "\t" + tallyTable[24][6] + "\t" + tallyTable[24][7] + "\t" + tallyTable[24][8] + "\t" + tallyTable[24][9]);
                            System.out.println("  A,8   |   " + tallyTable[25][0] + "  \t  " + tallyTable[25][1] + "\t" + tallyTable[25][2] + "\t" + tallyTable[25][3] + "\t" + tallyTable[25][4] + "\t" + tallyTable[25][5] + "\t" + tallyTable[25][6] + "\t" + tallyTable[25][7] + "\t" + tallyTable[25][8] + "\t" + tallyTable[25][9]);
                            System.out.println("  A,9   |   " + tallyTable[26][0] + "  \t  " + tallyTable[26][1] + "\t" + tallyTable[26][2] + "\t" + tallyTable[26][3] + "\t" + tallyTable[26][4] + "\t" + tallyTable[26][5] + "\t" + tallyTable[26][6] + "\t" + tallyTable[26][7] + "\t" + tallyTable[26][8] + "\t" + tallyTable[26][9]);
                            System.out.println("  A,10  |   " + tallyTable[27][0] + "  \t  " + tallyTable[27][1] + "\t" + tallyTable[27][2] + "\t" + tallyTable[27][3] + "\t" + tallyTable[27][4] + "\t" + tallyTable[27][5] + "\t" + tallyTable[27][6] + "\t" + tallyTable[27][7] + "\t" + tallyTable[27][8] + "\t" + tallyTable[27][9]);
                            System.out.println("  A,A   |   " + tallyTable[28][0] + "  \t  " + tallyTable[28][1] + "\t" + tallyTable[28][2] + "\t" + tallyTable[28][3] + "\t" + tallyTable[28][4] + "\t" + tallyTable[28][5] + "\t" + tallyTable[28][6] + "\t" + tallyTable[28][7] + "\t" + tallyTable[28][8] + "\t" + tallyTable[28][9]);
                            
                            String content ="X\t2\t3\t4\t5\t6\t7\t8\t9\t10\tA";
                            String content2 ="8" + "\t" + tallyTable[0][0] + "\t" + tallyTable[0][1] + "\t" + tallyTable[0][2] + "\t" + tallyTable[0][3] + "\t" + tallyTable[0][4] + "\t" + tallyTable[0][5] + "\t" + tallyTable[0][6] + "\t" + tallyTable[0][7] + "\t" + tallyTable[0][8] + "\t" + tallyTable[0][9];
                            String content3 ="9" + "\t" + tallyTable[1][0] + "\t" + tallyTable[1][1] + "\t" + tallyTable[1][2] + "\t" + tallyTable[1][3] + "\t" + tallyTable[1][4] + "\t" + tallyTable[1][5] + "\t" + tallyTable[1][6] + "\t" + tallyTable[1][7] + "\t" + tallyTable[1][8] + "\t" + tallyTable[1][9];
                            String content4 ="10" + "\t" + tallyTable[2][0] + "\t" + tallyTable[2][1] + "\t" + tallyTable[2][2] + "\t" + tallyTable[2][3] + "\t" + tallyTable[2][4] + "\t" + tallyTable[2][5] + "\t" + tallyTable[2][6] + "\t" + tallyTable[2][7] + "\t" + tallyTable[2][8] + "\t" + tallyTable[2][9];
                            String content5 ="11" + "\t" + tallyTable[3][0] + "\t" + tallyTable[3][1] + "\t" + tallyTable[3][2] + "\t" + tallyTable[3][3] + "\t" + tallyTable[3][4] + "\t" + tallyTable[3][5] + "\t" + tallyTable[3][6] + "\t" + tallyTable[3][7] + "\t" + tallyTable[3][8] + "\t" + tallyTable[3][9];
                            String content6 ="12" + "\t" + tallyTable[4][0] + "\t" + tallyTable[4][1] + "\t" + tallyTable[4][2] + "\t" + tallyTable[4][3] + "\t" + tallyTable[4][4] + "\t" + tallyTable[4][5] + "\t" + tallyTable[4][6] + "\t" + tallyTable[4][7] + "\t" + tallyTable[4][8] + "\t" + tallyTable[4][9];
                            String content7 ="13" + "\t" + tallyTable[5][0] + "\t" + tallyTable[5][1] + "\t" + tallyTable[5][2] + "\t" + tallyTable[5][3] + "\t" + tallyTable[5][4] + "\t" + tallyTable[5][5] + "\t" + tallyTable[5][6] + "\t" + tallyTable[5][7] + "\t" + tallyTable[5][8] + "\t" + tallyTable[5][9];
                            String content8 ="14" + "\t" + tallyTable[6][0] + "\t" + tallyTable[6][1] + "\t" + tallyTable[6][2] + "\t" + tallyTable[6][3] + "\t" + tallyTable[6][4] + "\t" + tallyTable[6][5] + "\t" + tallyTable[6][6] + "\t" + tallyTable[6][7] + "\t" + tallyTable[6][8] + "\t" + tallyTable[6][9];
                            String content9 ="15" + "\t" + tallyTable[7][0] + "\t" + tallyTable[7][1] + "\t" + tallyTable[7][2] + "\t" + tallyTable[7][3] + "\t" + tallyTable[7][4] + "\t" + tallyTable[7][5] + "\t" + tallyTable[7][6] + "\t" + tallyTable[7][7] + "\t" + tallyTable[7][8] + "\t" + tallyTable[7][9];
                            String content10 ="16" + "\t" + tallyTable[8][0] + "\t" + tallyTable[8][1] + "\t" + tallyTable[8][2] + "\t" + tallyTable[8][3] + "\t" + tallyTable[8][4] + "\t" + tallyTable[8][5] + "\t" + tallyTable[8][6] + "\t" + tallyTable[8][7] + "\t" + tallyTable[8][8] + "\t" + tallyTable[8][9];
                            String content11 ="17" + "\t" + tallyTable[9][0] + "\t" + tallyTable[9][1] + "\t" + tallyTable[9][2] + "\t" + tallyTable[9][3] + "\t" + tallyTable[9][4] + "\t" + tallyTable[9][5] + "\t" + tallyTable[9][6] + "\t" + tallyTable[9][7] + "\t" + tallyTable[9][8] + "\t" + tallyTable[9][9];
                            String content12 ="2,2" + "\t" + tallyTable[10][0] + "\t" + tallyTable[10][1] + "\t" + tallyTable[10][2] + "\t" + tallyTable[10][3] + "\t" + tallyTable[10][4] + "\t" + tallyTable[10][5] + "\t" + tallyTable[10][6] + "\t" + tallyTable[10][7] + "\t" + tallyTable[10][8] + "\t" + tallyTable[10][9];
                            String content13 ="3,3" + "\t" + tallyTable[11][0] + "\t" + tallyTable[11][1] + "\t" + tallyTable[11][2] + "\t" + tallyTable[11][3] + "\t" + tallyTable[11][4] + "\t" + tallyTable[11][5] + "\t" + tallyTable[11][6] + "\t" + tallyTable[11][7] + "\t" + tallyTable[11][8] + "\t" + tallyTable[11][9];
                            String content14 ="4,4" + "\t" + tallyTable[12][0] + "\t" + tallyTable[12][1] + "\t" + tallyTable[12][2] + "\t" + tallyTable[12][3] + "\t" + tallyTable[12][4] + "\t" + tallyTable[12][5] + "\t" + tallyTable[12][6] + "\t" + tallyTable[12][7] + "\t" + tallyTable[12][8] + "\t" + tallyTable[12][9];
                            String content15 ="5,5" + "\t" + tallyTable[13][0] + "\t" + tallyTable[13][1] + "\t" + tallyTable[13][2] + "\t" + tallyTable[13][3] + "\t" + tallyTable[13][4] + "\t" + tallyTable[13][5] + "\t" + tallyTable[13][6] + "\t" + tallyTable[13][7] + "\t" + tallyTable[13][8] + "\t" + tallyTable[13][9];
                            String content16 ="6,6" + "\t" + tallyTable[14][0] + "\t" + tallyTable[14][1] + "\t" + tallyTable[14][2] + "\t" + tallyTable[14][3] + "\t" + tallyTable[14][4] + "\t" + tallyTable[14][5] + "\t" + tallyTable[14][6] + "\t" + tallyTable[14][7] + "\t" + tallyTable[14][8] + "\t" + tallyTable[14][9];
                            String content17 ="7,7" + "\t" + tallyTable[15][0] + "\t" + tallyTable[15][1] + "\t" + tallyTable[15][2] + "\t" + tallyTable[15][3] + "\t" + tallyTable[15][4] + "\t" + tallyTable[15][5] + "\t" + tallyTable[15][6] + "\t" + tallyTable[15][7] + "\t" + tallyTable[15][8] + "\t" + tallyTable[15][9];
                            String content18 ="8,8" + "\t" + tallyTable[16][0] + "\t" + tallyTable[16][1] + "\t" + tallyTable[16][2] + "\t" + tallyTable[16][3] + "\t" + tallyTable[16][4] + "\t" + tallyTable[16][5] + "\t" + tallyTable[16][6] + "\t" + tallyTable[16][7] + "\t" + tallyTable[16][8] + "\t" + tallyTable[16][9];
                            String content19 ="9,9" + "\t" + tallyTable[17][0] + "\t" + tallyTable[17][1] + "\t" + tallyTable[17][2] + "\t" + tallyTable[17][3] + "\t" + tallyTable[17][4] + "\t" + tallyTable[17][5] + "\t" + tallyTable[17][6] + "\t" + tallyTable[17][7] + "\t" + tallyTable[17][8] + "\t" + tallyTable[17][9];
                            String content20 ="10,10" + "\t" + tallyTable[18][0] +"\t" + tallyTable[18][1] + "\t" + tallyTable[18][2] + "\t" + tallyTable[18][3] + "\t" + tallyTable[18][4] + "\t" + tallyTable[18][5] + "\t" + tallyTable[18][6] + "\t" + tallyTable[18][7] + "\t" + tallyTable[18][8] + "\t" + tallyTable[18][9];
                            String content21 ="A,2" + "\t" + tallyTable[19][0] + "\t" + tallyTable[19][1] + "\t" + tallyTable[19][2] + "\t" + tallyTable[19][3] + "\t" + tallyTable[19][4] + "\t" + tallyTable[19][5] + "\t" + tallyTable[19][6] + "\t" + tallyTable[19][7] + "\t" + tallyTable[19][8] + "\t" + tallyTable[19][9];
                            String content22 ="A,3" + "\t" + tallyTable[20][0] + "\t" + tallyTable[20][1] + "\t" + tallyTable[20][2] + "\t" + tallyTable[20][3] + "\t" + tallyTable[20][4] + "\t" + tallyTable[20][5] + "\t" + tallyTable[20][6] + "\t" + tallyTable[20][7] + "\t" + tallyTable[20][8] + "\t" + tallyTable[20][9];
                            String content23 ="A,4" + "\t" + tallyTable[21][0] + "\t" + tallyTable[21][1] + "\t" + tallyTable[21][2] + "\t" + tallyTable[21][3] + "\t" + tallyTable[21][4] + "\t" + tallyTable[21][5] + "\t" + tallyTable[21][6] + "\t" + tallyTable[21][7] + "\t" + tallyTable[21][8] + "\t" + tallyTable[21][9];
                            String content24 ="A,5" + "\t" + tallyTable[22][0] + "\t" + tallyTable[22][1] + "\t" + tallyTable[22][2] + "\t" + tallyTable[22][3] + "\t" + tallyTable[22][4] + "\t" + tallyTable[22][5] + "\t" + tallyTable[22][6] + "\t" + tallyTable[22][7] + "\t" + tallyTable[22][8] + "\t" + tallyTable[22][9];
                            String content25 ="A,6" + "\t" + tallyTable[23][0] + "\t" + tallyTable[23][1] + "\t" + tallyTable[23][2] + "\t" + tallyTable[23][3] + "\t" + tallyTable[23][4] + "\t" + tallyTable[23][5] + "\t" + tallyTable[23][6] + "\t" + tallyTable[23][7] + "\t" + tallyTable[23][8] + "\t" + tallyTable[23][9];
                            String content26 ="A,7" + "\t" + tallyTable[24][0] + "\t" + tallyTable[24][1] + "\t" + tallyTable[24][2] + "\t" + tallyTable[24][3] + "\t" + tallyTable[24][4] + "\t" + tallyTable[24][5] + "\t" + tallyTable[24][6] + "\t" + tallyTable[24][7] + "\t" + tallyTable[24][8] + "\t" + tallyTable[24][9];
                            String content27 ="A,8" + "\t" + tallyTable[25][0] + "\t" + tallyTable[25][1] + "\t" + tallyTable[25][2] + "\t" + tallyTable[25][3] + "\t" + tallyTable[25][4] + "\t" + tallyTable[25][5] + "\t" + tallyTable[25][6] + "\t" + tallyTable[25][7] + "\t" + tallyTable[25][8] + "\t" + tallyTable[25][9];
                            String content28 ="A,9" + "\t" + tallyTable[26][0] + "\t" + tallyTable[26][1] + "\t" + tallyTable[26][2] + "\t" + tallyTable[26][3] + "\t" + tallyTable[26][4] + "\t" + tallyTable[26][5] + "\t" + tallyTable[26][6] + "\t" + tallyTable[26][7] + "\t" + tallyTable[26][8] + "\t" + tallyTable[26][9];
                            String content29 ="A,10" + "\t" + tallyTable[27][0] + "\t" + tallyTable[27][1] + "\t" + tallyTable[27][2] + "\t" + tallyTable[27][3] + "\t" + tallyTable[27][4] + "\t" + tallyTable[27][5] + "\t" + tallyTable[27][6] + "\t" + tallyTable[27][7] + "\t" + tallyTable[27][8] + "\t" + tallyTable[27][9];
                            String content30 ="A,A" + "\t" + tallyTable[28][0] + "\t" + tallyTable[28][1] + "\t" + tallyTable[28][2] + "\t" + tallyTable[28][3] + "\t" + tallyTable[28][4] + "\t" + tallyTable[28][5] + "\t" + tallyTable[28][6] + "\t" + tallyTable[28][7] + "\t" + tallyTable[28][8] + "\t" + tallyTable[28][9];
                            
                           /* System.out.println("");*/
                                           
                           /* //Hit Percentage
                            for (int l = 0; l < tallyTable.length; l++) 
                            { 
                           	 for (int k = 0; k < tallyTable[l].length; k++) 
                           	 { 
                           		 if (tallyTable[l][k] == 'H')
                           		 {
                           		 tallyTable[l][k] = ' '; 
                           		 countT1++;
                           		 } 
                           	 }
                            }
                            
                       		System.out.println("Percent Won Using Hit " + ((countT1/290)*100) + "%");
                          	 
                            //Stand Percentage
                            for (int l = 0; l < tallyTable.length; l++) 
                            { 
                           	 for (int k = 0; k < tallyTable[l].length; k++) 
                           	 { 
                           		if (tallyTable[l][k] == 'S')
                           		{
                           		 tallyTable[l][k] = ' '; 
                           		 countT2++;

                          		 } 
                            }
                            }
                            
                          	 System.out.println("Percent Won Using Stand " + ((countT2/290)*100) + "%");
                            
                            //Split Percentage
                            for (int l = 0; l < tallyTable.length; l++) 
                            { 
                           	 for (int k = 0; k < tallyTable[l].length; k++) 
                           	 { 
                           		if (tallyTable[l][k] == 'P')
                           		{
                           		 tallyTable[l][k] = ' '; 
                           		 countT3++;

                          		 } 
                           	 }
                            }
                            
                          	 System.out.println("Percent Won Using Split " + ((countT3/290)*100) + "%");
                            
                            //Double Down Percentage                 
                            for (int l = 0; l < tallyTable.length; l++) 
                            { 
                           	 for (int k = 0; k < tallyTable[l].length; k++) 
                           	 { 
                           		if (tallyTable[l][k] == 'D')
                           		{
                           		 tallyTable[l][k] = ' '; 
                           		 countT4++;

                            }
                            }
                            }
                            
                          	 System.out.println("Percent Won Using Double Down " + ((countT4/290)*100) + "%");
                            System.out.println("\n\n");

                           	
                           	 int percent1 = ((countT1/totalTT)*100);
                           	 int percent2 = ((countT2/totalTT)*100);
                           	 int percent3 = ((countT3/totalTT)*100);
                           	 int percent4 = ((countT4/totalTT)*100);
                             System.out.println("\n\n");*/

                            /*
                            System.out.println("X\t2\t3\t4\t5\t6\t7\t8\t9\t10\tA");
                            System.out.println("5\tH\tH\tH\tH\tH\tH\tH\tH\tH\tH");
                            System.out.println("6\tH\tH\tH\tH\tH\tH\tH\tH\tH\tH");
                            System.out.println("8\tH\tH\tH\tH\tH\tH\tH\tH\tH\tH");
                            System.out.println("9\tH\tD\tD\tD\tD\tH\tH\tH\tH\tH");
                            System.out.println("10\tD\tD\tD\tD\tD\tD\tD\tD\tH\tH");
                            System.out.println("11\tD\tD\tD\tD\tD\tD\tD\tD\tD\tH");
                            System.out.println("12\tH\tH\tS\tS\tS\tH\tH\tH\tH\tH");
                            System.out.println("13\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH");
                            System.out.println("14\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH");
                            System.out.println("15\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH");
                            System.out.println("16\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH");
                            System.out.println("17\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("18\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("19\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("20\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("21\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("A,2\tH\tH\tH\tD\tD\tH\tH\tH\tH\tH");
                            System.out.println("A,3\tH\tH\tH\tD\tD\tH\tH\tH\tH\tH");
                            System.out.println("A,4\tH\tH\tD\tD\tD\tH\tH\tH\tH\tH");
                            System.out.println("A,5\tH\tH\tD\tD\tD\tH\tH\tH\tH\tH");
                            System.out.println("A,6\tH\tD\tD\tD\tD\tH\tH\tH\tH\tH");
                            System.out.println("A,7\tS\tD\tD\tD\tD\tS\tS\tH\tH\tH");
                            System.out.println("A,8\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("A,9\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("A,10\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("A,A\tP\tP\tP\tP\tP\tP\tP\tP\tP\tP");
                            System.out.println("2,2\tP\tP\tP\tP\tP\tP\tH\tH\tH\tH");
                            System.out.println("3,3\tP\tP\tP\tP\tP\tP\tH\tH\tH\tH");
                            System.out.println("4,4\tH\tH\tH\tP\tP\tH\tH\tH\tH\tH");
                            System.out.println("5,5\tD\tD\tD\tD\tD\tD\tD\tD\tH\tH");
                            System.out.println("6,6\tH\tP\tP\tP\tP\tH\tH\tH\tH\tH");
                            System.out.println("7,7\tP\tP\tP\tP\tP\tP\tH\tH\tH\tH");
                            System.out.println("8,8\tP\tP\tP\tP\tP\tP\tP\tP\tP\tP");
                            System.out.println("9,9\tP\tP\tP\tP\tP\tP\tP\tP\tS\tS");
                            System.out.println("10,10\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS"); */

                             /*
                            String content ="X\t2\t3\t4\t5\t6\t7\t8\t9\t10\tA";
                            String content2 ="8\tH\tH\tH\tH\tH\tH\tH\tH\tH\tH";
                            String content3 ="9\tH\tD\tD\tD\tD\tH\tH\tH\tH\tH";
                            String content4 ="10\tD\tD\tD\tD\tD\tD\tD\tD\tH\tH";
                            String content5 ="11\tD\tD\tD\tD\tD\tD\tD\tD\tD\tH";
                            String content6 ="12\tH\tH\tS\tS\tS\tH\tH\tH\tH\tH";
                            String content7 ="13\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH";
                            String content8 ="14\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH";
                            String content9 ="15\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH";
                            String content10 ="16\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH";
                            String content11 ="17\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS";
                            String content12 ="A,2\tH\tH\tH\tD\tD\tH\tH\tH\tH\tH";
                            String content13 ="A,3\tH\tH\tH\tD\tD\tH\tH\tH\tH\tH";
                            String content14 ="A,4\tH\tH\tD\tD\tD\tH\tH\tH\tH\tH";
                            String content15 ="A,5\tH\tH\tD\tD\tD\tH\tH\tH\tH\tH";
                            String content16 ="A,6\tH\tD\tD\tD\tD\tH\tH\tH\tH\tH";
                            String content17 ="A,7\tS\tD\tD\tD\tD\tS\tS\tH\tH\tH";
                            String content18 ="A,8\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS";
                            String content19 ="A,9\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS";
                            String content20 ="A,10\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS";
                            String content21 ="A,A\tP\tP\tP\tP\tP\tP\tP\tP\tP\tP";
                            String content22 ="2,2\tP\tP\tP\tP\tP\tP\tH\tH\tH\tH";
                            String content23 ="3,3\tP\tP\tP\tP\tP\tP\tH\tH\tH\tH";
                            String content24 ="4,4\tH\tH\tH\tP\tP\tH\tH\tH\tH\tH";
                            String content25 ="5,5\tD\tD\tD\tD\tD\tD\tD\tD\tH\tH";
                            String content26 ="6,6\tH\tP\tP\tP\tP\tH\tH\tH\tH\tH";
                            String content27 ="7,7\tP\tP\tP\tP\tP\tP\tH\tH\tH\tH";
                            String content28 ="8,8\tP\tP\tP\tP\tP\tP\tP\tP\tP\tP";
                            String content29 ="9,9\tP\tP\tP\tP\tP\tP\tP\tP\tS\tS";
                            String content30 ="10,10\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS";*/                		
                    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                          System.out.println("");
                          System.out.println("");
                          
                          try 
                          {

                  			File file = new File("/Users/4leaf/Desktop/strategyCard.txt");

                  			// if file doesn't exists, then create it
                  			if (!file.exists()) 
                  			{
                  				file.createNewFile();
                  		    }
                          
                          //////////////////////////////////////////////////////////////////////////////////////////////////////////
                          //System.out.println("  |-----------------------------------------------------------------------|");
                          //System.out.println("\t   P \t\t   S \t\t    H \t\t        D \t");
                          //System.out.println("  |-----------------------------------------------------------------------|");

                          //System.out.println("  |               |                 |                  |                  |" );
                          //System.out.println("  |       0%      |       55%       |      30%         |       15%        |" );
                          //System.out.println("  |               |                 |                  |                  |" );
                          //System.out.println("  |               |                 |                  |                  |" );
                          //System.out.println("  |-----------------------------------------------------------------------|");

                          /*//End Delimeter
                          System.out.println("");
                          System.out.println("");
                	      String content = "  |-----------------------------------------------------------------------|";
                	      String content2 = "\t   P \t\t   S \t\t    H \t\t        D \t";
                	      String content3 = "  |-----------------------------------------------------------------------|";
                	      String content4 = "  |               |                 |                  |                  |";
                	      String content5 = "  |       0%      |       55%       |      30%         |       15%        |";
                	      String content6 = "  |               |                 |                  |                  |";
                	      String content7 = "  |               |                 |                  |                  |";
                	      String content8 = "  |-----------------------------------------------------------------------|";*/
                	      
                          FileWriter fw = new FileWriter(file.getAbsoluteFile());
                		  BufferedWriter bw = new BufferedWriter(fw);
                		  	bw.write(content);
                			bw.newLine();
                			bw.write(content2);
                			bw.newLine();
                			bw.write(content3);
                			bw.newLine();
                			bw.write(content4);
                			bw.newLine();
                			bw.write(content5);
                			bw.newLine();
                			bw.write(content6);
                			bw.newLine();
                			bw.write(content7);
                			bw.newLine();
                			bw.write(content8);
                			bw.newLine();
                			bw.write(content9);
                			bw.newLine();
                			bw.write(content10);
                			bw.newLine();
                			bw.write(content11);
                			bw.newLine();
                			bw.write(content12);
                			bw.newLine();
                			bw.write(content13);
                			bw.newLine();
                			bw.write(content14);
                			bw.newLine();
                			bw.write(content15);
                			bw.newLine();
                			bw.write(content16);
                			bw.newLine();
                			bw.write(content17);
                			bw.newLine();
                			bw.write(content18);
                			bw.newLine();
                			bw.write(content19);
                			bw.newLine();
                			bw.write(content20);
                			bw.newLine();
                			bw.write(content21);
                			bw.newLine();
                			bw.write(content22);
                			bw.newLine();
                			bw.write(content23);
                			bw.newLine();
                			bw.write(content24);
                			bw.newLine();
                			bw.write(content25);
                			bw.newLine();
                			bw.write(content26);
                			bw.newLine();
                			bw.write(content27);
                			bw.newLine();
                			bw.write(content28);
                			bw.newLine();
                			bw.write(content29);
                			bw.newLine();
                			bw.write(content30);
                			bw.newLine();
                			bw.close();
                			System.out.println("Done");

                        } 
                        catch (IOException e) 
                        {
                			e.printStackTrace();
                		  }
                  }
         else if(decknumber == 6) /////////////////////////////////////////////////////////////////////////////////////////////////
         {
        	 sql = "SELECT * FROM blackjackdatabase6";
             rs = stmt.executeQuery(sql);
            
             while(rs.next())
             {
               int id  = rs.getInt("idBlackJackDatabase");
               String CardValue = rs.getString("CardValue");
                  
               /*System.out.print("ID: " + id);
               System.out.println(", CardValue: " + CardValue);*/
             }
             
             /*System.out.println("");
             System.out.println("Frequency Table");
             //System.out.println("Randomized Set of 20 Integers: ");
             System.out.println("");*/
             
             for(int Rnd = 0; Rnd < freq; Rnd++)
             {
           	  
             count = 0;
             
             sql2 = "SELECT * FROM blackjackdatabase6 ORDER BY RAND() LIMIT 20;";
             rs2 = stmt.executeQuery(sql2);
             
             while(rs2.next())
             {
           	 
           	int id  = rs2.getInt("idBlackJackDatabase");
           	
           	String CardValue = rs2.getString("CardValue");
           	
           	cards[count] = CardValue;
           	count++;
                                
               /*System.out.print("ID: " + id);
               System.out.println(", CardValue: " + CardValue);*/
             }
             
             /*System.out.println("");
             System.out.println("Your cards are....");
             System.out.println("");*/

             UserCard1 = cards[0];
             /*              System.out.println("User Card 1 : " + UserCard1);
             */              DealerCard1 = cards[1];
             /*              System.out.println("Dealer Card Down.... ");
             */              UserCard2 = cards[2];
             /*              System.out.println("User Card 2 : " + UserCard2);
             */              DealerCard2 = cards[3];
             /*              System.out.println("Dealer Card Shown: " + DealerCard2);*/
                             /*System.out.println("");*/
             				
             				/*System.out.println("User Card 1: " + UserCard1);
             				System.out.println("Dealer Card Down");
             				System.out.println("User Card 2: " + UserCard2);
             				System.out.println("Dealer Card Up: " + DealerCard2);*/
             				
             				if(UserCard1.equals("Jack") || UserCard1.equals("Queen") || UserCard1.equals("King"))
             				{
             					U1 = 10;
             				}
             				else if(UserCard1.equals("Ace"))
             				{
             					U1 = 1;
             				}
             				else
             				{
             					U1 = Integer.parseInt(UserCard1);
             				}
             				
             				
             				
             				if(UserCard2.equals("Jack") || UserCard2.equals("Queen") || UserCard2.equals("King"))
             				{
             					U2 = 10;
             				}
             				else if(UserCard2.equals("Ace"))
             				{
             					U2 = 1;
             				}
             				else
             				{
             					U2 = Integer.parseInt(UserCard2);
             				}
             				
             				
             				
             				if(DealerCard1.equals("Jack") || DealerCard1.equals("Queen") || DealerCard1.equals("King"))
             				{
             					D1 = 10;
             				}
             				else if(DealerCard1.equals("Ace"))
             				{
             					D1 = 1;
             				}
             				else
             				{
             					D1 = Integer.parseInt(DealerCard1);
             				}
             				
             				
             				
             				if(DealerCard2.equals("Jack") || DealerCard2.equals("Queen") || DealerCard2.equals("King"))
             				{
             					D2 = 10;
             				}
             				else if(DealerCard2.equals("Ace"))
             				{
             					D2 = 1;
             				}
             				else
             				{
             					D2 = Integer.parseInt(DealerCard2);
             				}
             				
             				
             				if(UserCard1.equals("Ace") && UserCard2.equals("Ace"))
             				{
             					totalU = 21;
             				}
             		 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
             		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
             				if(UserCard1.equals("Ace") && !UserCard2.equals("Ace"))
             				{
             					U1 = 11;
             				}
             				
             				if(UserCard2.equals("Ace") && !UserCard1.equals("Ace"))
             				{
             					U2 = 11;
             				}
             				
             				if(DealerCard1.equals("Ace") && !DealerCard2.equals("Ace"))
             				{
             					D1 = 11;
             				}
             				
             				if(DealerCard2.equals("Ace") && !DealerCard1.equals("Ace"))
             				{
             					D2 = 11;
             				}
             		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
             				
            	            //System.out.println("");
            				totalU = U1 + U2;
            	            totalD = D2;
            	            int totalDw2 = D1 + D2;
            	            /*
            	            System.out.println("User Card 1: " + U1);
            	            System.out.println("User Card 2: " + U2);
            				System.out.println("User Total: " + totalU);
            				System.out.println("Dealer Shown: " + D2);
            				System.out.println("Dealer Total: " + totalDw2);
                            */
                          /*  System.out.println("");
                            System.out.println("----------");
                            
                            
                            
                            //System.out.println(StrategyMethod(U1, U2, totalDw2));
                            System.out.println("");
                            System.out.println("");
                            System.out.println("");*/
                   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
                            
                            	if(totalU < 8)
                            	{
                            		SearchCond5 = "8";
                            	}
                            	else if(totalU > 17)
                            	{
                            		SearchCond5 = "17";
                            	}
                            	else
                            	{
                            		SearchCond5 = String.valueOf(totalU);
                            	}
                            	
                            	
            					if(DealerCard2.equals("Jack"))
                            	{
                            		DealerCardString5 = "10";
                            	}
            					
            					if(DealerCard2.equals("Queen"))
                            	{
                            		DealerCardString5 = "10";
                            	}
            					
            					if(DealerCard2.equals("King"))
                            	{
                            		DealerCardString5 = "10";
                            	}
            					
            					if(DealerCard2.equals("Ace"))
                            	{
                            		DealerCardString5 = "A";
                            	}
            					
            					String U1W, U2W;
            					if(UserCard1.equals("Ace"))
            					{
            						U1W = "A";
            					}
            					else
            					{
            						U1W = UserCard1;
            					}
            					
            					if(UserCard2.equals("Ace"))
            					{
            						U2W = "A";
            					}
            					else
            					{
            						U2W = UserCard2;
            					}
            					
            					String UserCheck = U1W + "," + U2W;
            					
            					
                              for (index = 0; index < 29; index++) 
                              {
                                //if index of user array is equal to the user total
                                if (tallyArrayUser[index].equals(SearchCond5)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } 
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } 
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } 
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } 
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } 
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } 
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                

                                //looping through dealer array
                                for (index2 = 0; index2 < 10; index2++) 
                                {
                                  //if index of dealer array is equal to the dealer total
                                  if (tallyArrayDealer[index2].equals(DealerCard2) || tallyArrayDealer[index2].equals(DealerCardString5)) 
                                  {
                                    //initialize j to index
                                    //System.out.println("The current j is "+ j );
                                    j = index2;
                                    //reset index value
                                    break;
                                    
                                  }

                                }
                                tallyTable[i][j] = StrategyMethod(U1, U2, totalDw2);

                                // System.out.println("TALLY BEFORE: " + tallyTable[i][j]);
                                // System.out.println("TALLY AFTER: " + tallyTable[i][j]);
                                // System.out.println("TALLY BEFORE: " + tallyTable[index][index2]);
                                // tallyTable[index][index2]++;
                                // System.out.println("TALLY AFTER: " + tallyTable[index][index2]);
                              }
                            }
                            
                            
                     /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
                            
                            System.out.println("\n\n");
                            System.out.println("\t ---------------------------------------------------------------------------");
                            System.out.println("\t   2 \t 3 \t 4 \t 5 \t 6 \t 7 \t 8 \t 9 \t 10 \t A ");
                            System.out.println("\t ---------------------------------------------------------------------------");

                            System.out.println("        |");
                            System.out.println("  8     |   " + tallyTable[0][0] + "  \t  " + tallyTable[0][1] + "\t" + tallyTable[0][2] + "\t" + tallyTable[0][3] + "\t" + tallyTable[0][4] + "\t" + tallyTable[0][5] + "\t" + tallyTable[0][6] + "\t" + tallyTable[0][7] + "\t" + tallyTable[0][8] + "\t" + tallyTable[0][9]);
                            System.out.println("  9     |   " + tallyTable[1][0] + "  \t  " + tallyTable[1][1] + "\t" + tallyTable[1][2] + "\t" + tallyTable[1][3] + "\t" + tallyTable[1][4] + "\t" + tallyTable[1][5] + "\t" + tallyTable[1][6] + "\t" + tallyTable[1][7] + "\t" + tallyTable[1][8] + "\t" + tallyTable[1][9]);
                            System.out.println("  10    |   " + tallyTable[2][0] + "  \t  " + tallyTable[2][1] + "\t" + tallyTable[2][2] + "\t" + tallyTable[2][3] + "\t" + tallyTable[2][4] + "\t" + tallyTable[2][5] + "\t" + tallyTable[2][6] + "\t" + tallyTable[2][7] + "\t" + tallyTable[2][8] + "\t" + tallyTable[2][9]);
                            System.out.println("  11    |   " + tallyTable[3][0] + "  \t  " + tallyTable[3][1] + "\t" + tallyTable[3][2] + "\t" + tallyTable[3][3] + "\t" + tallyTable[3][4] + "\t" + tallyTable[3][5] + "\t" + tallyTable[3][6] + "\t" + tallyTable[3][7] + "\t" + tallyTable[3][8] + "\t" + tallyTable[3][9]);
                            System.out.println("  12    |   " + tallyTable[4][0] + "  \t  " + tallyTable[4][1] + "\t" + tallyTable[4][2] + "\t" + tallyTable[4][3] + "\t" + tallyTable[4][4] + "\t" + tallyTable[4][5] + "\t" + tallyTable[4][6] + "\t" + tallyTable[4][7] + "\t" + tallyTable[4][8] + "\t" + tallyTable[4][9]);
                            System.out.println("  13    |   " + tallyTable[5][0] + "  \t  " + tallyTable[5][1] + "\t" + tallyTable[5][2] + "\t" + tallyTable[5][3] + "\t" + tallyTable[5][4] + "\t" + tallyTable[5][5] + "\t" + tallyTable[5][6] + "\t" + tallyTable[5][7] + "\t" + tallyTable[5][8] + "\t" + tallyTable[5][9]);
                            System.out.println("  14    |   " + tallyTable[6][0] + "  \t  " + tallyTable[6][1] + "\t" + tallyTable[6][2] + "\t" + tallyTable[6][3] + "\t" + tallyTable[6][4] + "\t" + tallyTable[6][5] + "\t" + tallyTable[6][6] + "\t" + tallyTable[6][7] + "\t" + tallyTable[6][8] + "\t" + tallyTable[6][9]);
                            System.out.println("  15    |   " + tallyTable[7][0] + "  \t  " + tallyTable[7][1] + "\t" + tallyTable[7][2] + "\t" + tallyTable[7][3] + "\t" + tallyTable[7][4] + "\t" + tallyTable[7][5] + "\t" + tallyTable[7][6] + "\t" + tallyTable[7][7] + "\t" + tallyTable[7][8] + "\t" + tallyTable[7][9]);
                            System.out.println("  16    |   " + tallyTable[8][0] + "  \t  " + tallyTable[8][1] + "\t" + tallyTable[8][2] + "\t" + tallyTable[8][3] + "\t" + tallyTable[8][4] + "\t" + tallyTable[8][5] + "\t" + tallyTable[8][6] + "\t" + tallyTable[8][7] + "\t" + tallyTable[8][8] + "\t" + tallyTable[8][9]);
                            System.out.println("  17    |   " + tallyTable[9][0] + "  \t  " + tallyTable[9][1] + "\t" + tallyTable[9][2] + "\t" + tallyTable[9][3] + "\t" + tallyTable[9][4] + "\t" + tallyTable[9][5] + "\t" + tallyTable[9][6] + "\t" + tallyTable[9][7] + "\t" + tallyTable[9][8] + "\t" + tallyTable[9][9]);
                            System.out.println("  2,2   |   " + tallyTable[10][0] + "  \t  " + tallyTable[10][1] + "\t" + tallyTable[10][2] + "\t" + tallyTable[10][3] + "\t" + tallyTable[10][4] + "\t" + tallyTable[10][5] + "\t" + tallyTable[10][6] + "\t" + tallyTable[10][7] + "\t" + tallyTable[10][8] + "\t" + tallyTable[10][9]);
                            System.out.println("  3,3   |   " + tallyTable[11][0] + "  \t  " + tallyTable[11][1] + "\t" + tallyTable[11][2] + "\t" + tallyTable[11][3] + "\t" + tallyTable[11][4] + "\t" + tallyTable[11][5] + "\t" + tallyTable[11][6] + "\t" + tallyTable[11][7] + "\t" + tallyTable[11][8] + "\t" + tallyTable[11][9]);
                            System.out.println("  4,4   |   " + tallyTable[12][0] + "  \t  " + tallyTable[12][1] + "\t" + tallyTable[12][2] + "\t" + tallyTable[12][3] + "\t" + tallyTable[12][4] + "\t" + tallyTable[12][5] + "\t" + tallyTable[12][6] + "\t" + tallyTable[12][7] + "\t" + tallyTable[12][8] + "\t" + tallyTable[12][9]);
                            System.out.println("  5,5   |   " + tallyTable[13][0] + "  \t  " + tallyTable[13][1] + "\t" + tallyTable[13][2] + "\t" + tallyTable[13][3] + "\t" + tallyTable[13][4] + "\t" + tallyTable[13][5] + "\t" + tallyTable[13][6] + "\t" + tallyTable[13][7] + "\t" + tallyTable[13][8] + "\t" + tallyTable[13][9]);
                            System.out.println("  6,6   |   " + tallyTable[14][0] + "  \t  " + tallyTable[14][1] + "\t" + tallyTable[14][2] + "\t" + tallyTable[14][3] + "\t" + tallyTable[14][4] + "\t" + tallyTable[14][5] + "\t" + tallyTable[14][6] + "\t" + tallyTable[14][7] + "\t" + tallyTable[14][8] + "\t" + tallyTable[14][9]);
                            System.out.println("  7,7   |   " + tallyTable[15][0] + "  \t  " + tallyTable[15][1] + "\t" + tallyTable[15][2] + "\t" + tallyTable[15][3] + "\t" + tallyTable[15][4] + "\t" + tallyTable[15][5] + "\t" + tallyTable[15][6] + "\t" + tallyTable[15][7] + "\t" + tallyTable[15][8] + "\t" + tallyTable[15][9]);
                            System.out.println("  8,8   |   " + tallyTable[16][0] + "  \t  " + tallyTable[16][1] + "\t" + tallyTable[16][2] + "\t" + tallyTable[16][3] + "\t" + tallyTable[16][4] + "\t" + tallyTable[16][5] + "\t" + tallyTable[16][6] + "\t" + tallyTable[16][7] + "\t" + tallyTable[16][8] + "\t" + tallyTable[16][9]);
                            System.out.println("  9,9   |   " + tallyTable[17][0] + "  \t  " + tallyTable[17][1] + "\t" + tallyTable[17][2] + "\t" + tallyTable[17][3] + "\t" + tallyTable[17][4] + "\t" + tallyTable[17][5] + "\t" + tallyTable[17][6] + "\t" + tallyTable[17][7] + "\t" + tallyTable[17][8] + "\t" + tallyTable[17][9]);
                            System.out.println("  10,10 |   " + tallyTable[18][0] + "  \t  " + tallyTable[18][1] + "\t" + tallyTable[18][2] + "\t" + tallyTable[18][3] + "\t" + tallyTable[18][4] + "\t" + tallyTable[18][5] + "\t" + tallyTable[18][6] + "\t" + tallyTable[18][7] + "\t" + tallyTable[18][8] + "\t" + tallyTable[18][9]);
                            System.out.println("  A,2   |   " + tallyTable[19][0] + "  \t  " + tallyTable[19][1] + "\t" + tallyTable[19][2] + "\t" + tallyTable[19][3] + "\t" + tallyTable[19][4] + "\t" + tallyTable[19][5] + "\t" + tallyTable[19][6] + "\t" + tallyTable[19][7] + "\t" + tallyTable[19][8] + "\t" + tallyTable[19][9]);
                            System.out.println("  A,3   |   " + tallyTable[20][0] + "  \t  " + tallyTable[20][1] + "\t" + tallyTable[20][2] + "\t" + tallyTable[20][3] + "\t" + tallyTable[20][4] + "\t" + tallyTable[20][5] + "\t" + tallyTable[20][6] + "\t" + tallyTable[20][7] + "\t" + tallyTable[20][8] + "\t" + tallyTable[20][9]);
                            System.out.println("  A,4   |   " + tallyTable[21][0] + "  \t  " + tallyTable[21][1] + "\t" + tallyTable[21][2] + "\t" + tallyTable[21][3] + "\t" + tallyTable[21][4] + "\t" + tallyTable[21][5] + "\t" + tallyTable[21][6] + "\t" + tallyTable[21][7] + "\t" + tallyTable[21][8] + "\t" + tallyTable[21][9]);
                            System.out.println("  A,5   |   " + tallyTable[22][0] + "  \t  " + tallyTable[22][1] + "\t" + tallyTable[22][2] + "\t" + tallyTable[22][3] + "\t" + tallyTable[22][4] + "\t" + tallyTable[22][5] + "\t" + tallyTable[22][6] + "\t" + tallyTable[22][7] + "\t" + tallyTable[22][8] + "\t" + tallyTable[22][9]);
                            System.out.println("  A,6   |   " + tallyTable[23][0] + "  \t  " + tallyTable[23][1] + "\t" + tallyTable[23][2] + "\t" + tallyTable[23][3] + "\t" + tallyTable[23][4] + "\t" + tallyTable[23][5] + "\t" + tallyTable[23][6] + "\t" + tallyTable[23][7] + "\t" + tallyTable[23][8] + "\t" + tallyTable[23][9]);
                            System.out.println("  A,7   |   " + tallyTable[24][0] + "  \t  " + tallyTable[24][1] + "\t" + tallyTable[24][2] + "\t" + tallyTable[24][3] + "\t" + tallyTable[24][4] + "\t" + tallyTable[24][5] + "\t" + tallyTable[24][6] + "\t" + tallyTable[24][7] + "\t" + tallyTable[24][8] + "\t" + tallyTable[24][9]);
                            System.out.println("  A,8   |   " + tallyTable[25][0] + "  \t  " + tallyTable[25][1] + "\t" + tallyTable[25][2] + "\t" + tallyTable[25][3] + "\t" + tallyTable[25][4] + "\t" + tallyTable[25][5] + "\t" + tallyTable[25][6] + "\t" + tallyTable[25][7] + "\t" + tallyTable[25][8] + "\t" + tallyTable[25][9]);
                            System.out.println("  A,9   |   " + tallyTable[26][0] + "  \t  " + tallyTable[26][1] + "\t" + tallyTable[26][2] + "\t" + tallyTable[26][3] + "\t" + tallyTable[26][4] + "\t" + tallyTable[26][5] + "\t" + tallyTable[26][6] + "\t" + tallyTable[26][7] + "\t" + tallyTable[26][8] + "\t" + tallyTable[26][9]);
                            System.out.println("  A,10  |   " + tallyTable[27][0] + "  \t  " + tallyTable[27][1] + "\t" + tallyTable[27][2] + "\t" + tallyTable[27][3] + "\t" + tallyTable[27][4] + "\t" + tallyTable[27][5] + "\t" + tallyTable[27][6] + "\t" + tallyTable[27][7] + "\t" + tallyTable[27][8] + "\t" + tallyTable[27][9]);
                            System.out.println("  A,A   |   " + tallyTable[28][0] + "  \t  " + tallyTable[28][1] + "\t" + tallyTable[28][2] + "\t" + tallyTable[28][3] + "\t" + tallyTable[28][4] + "\t" + tallyTable[28][5] + "\t" + tallyTable[28][6] + "\t" + tallyTable[28][7] + "\t" + tallyTable[28][8] + "\t" + tallyTable[28][9]);
                            
                            String content ="X\t2\t3\t4\t5\t6\t7\t8\t9\t10\tA";
                            String content2 ="8" + "\t" + tallyTable[0][0] + "\t" + tallyTable[0][1] + "\t" + tallyTable[0][2] + "\t" + tallyTable[0][3] + "\t" + tallyTable[0][4] + "\t" + tallyTable[0][5] + "\t" + tallyTable[0][6] + "\t" + tallyTable[0][7] + "\t" + tallyTable[0][8] + "\t" + tallyTable[0][9];
                            String content3 ="9" + "\t" + tallyTable[1][0] + "\t" + tallyTable[1][1] + "\t" + tallyTable[1][2] + "\t" + tallyTable[1][3] + "\t" + tallyTable[1][4] + "\t" + tallyTable[1][5] + "\t" + tallyTable[1][6] + "\t" + tallyTable[1][7] + "\t" + tallyTable[1][8] + "\t" + tallyTable[1][9];
                            String content4 ="10" + "\t" + tallyTable[2][0] + "\t" + tallyTable[2][1] + "\t" + tallyTable[2][2] + "\t" + tallyTable[2][3] + "\t" + tallyTable[2][4] + "\t" + tallyTable[2][5] + "\t" + tallyTable[2][6] + "\t" + tallyTable[2][7] + "\t" + tallyTable[2][8] + "\t" + tallyTable[2][9];
                            String content5 ="11" + "\t" + tallyTable[3][0] + "\t" + tallyTable[3][1] + "\t" + tallyTable[3][2] + "\t" + tallyTable[3][3] + "\t" + tallyTable[3][4] + "\t" + tallyTable[3][5] + "\t" + tallyTable[3][6] + "\t" + tallyTable[3][7] + "\t" + tallyTable[3][8] + "\t" + tallyTable[3][9];
                            String content6 ="12" + "\t" + tallyTable[4][0] + "\t" + tallyTable[4][1] + "\t" + tallyTable[4][2] + "\t" + tallyTable[4][3] + "\t" + tallyTable[4][4] + "\t" + tallyTable[4][5] + "\t" + tallyTable[4][6] + "\t" + tallyTable[4][7] + "\t" + tallyTable[4][8] + "\t" + tallyTable[4][9];
                            String content7 ="13" + "\t" + tallyTable[5][0] + "\t" + tallyTable[5][1] + "\t" + tallyTable[5][2] + "\t" + tallyTable[5][3] + "\t" + tallyTable[5][4] + "\t" + tallyTable[5][5] + "\t" + tallyTable[5][6] + "\t" + tallyTable[5][7] + "\t" + tallyTable[5][8] + "\t" + tallyTable[5][9];
                            String content8 ="14" + "\t" + tallyTable[6][0] + "\t" + tallyTable[6][1] + "\t" + tallyTable[6][2] + "\t" + tallyTable[6][3] + "\t" + tallyTable[6][4] + "\t" + tallyTable[6][5] + "\t" + tallyTable[6][6] + "\t" + tallyTable[6][7] + "\t" + tallyTable[6][8] + "\t" + tallyTable[6][9];
                            String content9 ="15" + "\t" + tallyTable[7][0] + "\t" + tallyTable[7][1] + "\t" + tallyTable[7][2] + "\t" + tallyTable[7][3] + "\t" + tallyTable[7][4] + "\t" + tallyTable[7][5] + "\t" + tallyTable[7][6] + "\t" + tallyTable[7][7] + "\t" + tallyTable[7][8] + "\t" + tallyTable[7][9];
                            String content10 ="16" + "\t" + tallyTable[8][0] + "\t" + tallyTable[8][1] + "\t" + tallyTable[8][2] + "\t" + tallyTable[8][3] + "\t" + tallyTable[8][4] + "\t" + tallyTable[8][5] + "\t" + tallyTable[8][6] + "\t" + tallyTable[8][7] + "\t" + tallyTable[8][8] + "\t" + tallyTable[8][9];
                            String content11 ="17" + "\t" + tallyTable[9][0] + "\t" + tallyTable[9][1] + "\t" + tallyTable[9][2] + "\t" + tallyTable[9][3] + "\t" + tallyTable[9][4] + "\t" + tallyTable[9][5] + "\t" + tallyTable[9][6] + "\t" + tallyTable[9][7] + "\t" + tallyTable[9][8] + "\t" + tallyTable[9][9];
                            String content12 ="2,2" + "\t" + tallyTable[10][0] + "\t" + tallyTable[10][1] + "\t" + tallyTable[10][2] + "\t" + tallyTable[10][3] + "\t" + tallyTable[10][4] + "\t" + tallyTable[10][5] + "\t" + tallyTable[10][6] + "\t" + tallyTable[10][7] + "\t" + tallyTable[10][8] + "\t" + tallyTable[10][9];
                            String content13 ="3,3" + "\t" + tallyTable[11][0] + "\t" + tallyTable[11][1] + "\t" + tallyTable[11][2] + "\t" + tallyTable[11][3] + "\t" + tallyTable[11][4] + "\t" + tallyTable[11][5] + "\t" + tallyTable[11][6] + "\t" + tallyTable[11][7] + "\t" + tallyTable[11][8] + "\t" + tallyTable[11][9];
                            String content14 ="4,4" + "\t" + tallyTable[12][0] + "\t" + tallyTable[12][1] + "\t" + tallyTable[12][2] + "\t" + tallyTable[12][3] + "\t" + tallyTable[12][4] + "\t" + tallyTable[12][5] + "\t" + tallyTable[12][6] + "\t" + tallyTable[12][7] + "\t" + tallyTable[12][8] + "\t" + tallyTable[12][9];
                            String content15 ="5,5" + "\t" + tallyTable[13][0] + "\t" + tallyTable[13][1] + "\t" + tallyTable[13][2] + "\t" + tallyTable[13][3] + "\t" + tallyTable[13][4] + "\t" + tallyTable[13][5] + "\t" + tallyTable[13][6] + "\t" + tallyTable[13][7] + "\t" + tallyTable[13][8] + "\t" + tallyTable[13][9];
                            String content16 ="6,6" + "\t" + tallyTable[14][0] + "\t" + tallyTable[14][1] + "\t" + tallyTable[14][2] + "\t" + tallyTable[14][3] + "\t" + tallyTable[14][4] + "\t" + tallyTable[14][5] + "\t" + tallyTable[14][6] + "\t" + tallyTable[14][7] + "\t" + tallyTable[14][8] + "\t" + tallyTable[14][9];
                            String content17 ="7,7" + "\t" + tallyTable[15][0] + "\t" + tallyTable[15][1] + "\t" + tallyTable[15][2] + "\t" + tallyTable[15][3] + "\t" + tallyTable[15][4] + "\t" + tallyTable[15][5] + "\t" + tallyTable[15][6] + "\t" + tallyTable[15][7] + "\t" + tallyTable[15][8] + "\t" + tallyTable[15][9];
                            String content18 ="8,8" + "\t" + tallyTable[16][0] + "\t" + tallyTable[16][1] + "\t" + tallyTable[16][2] + "\t" + tallyTable[16][3] + "\t" + tallyTable[16][4] + "\t" + tallyTable[16][5] + "\t" + tallyTable[16][6] + "\t" + tallyTable[16][7] + "\t" + tallyTable[16][8] + "\t" + tallyTable[16][9];
                            String content19 ="9,9" + "\t" + tallyTable[17][0] + "\t" + tallyTable[17][1] + "\t" + tallyTable[17][2] + "\t" + tallyTable[17][3] + "\t" + tallyTable[17][4] + "\t" + tallyTable[17][5] + "\t" + tallyTable[17][6] + "\t" + tallyTable[17][7] + "\t" + tallyTable[17][8] + "\t" + tallyTable[17][9];
                            String content20 ="10,10" + "\t" + tallyTable[18][0] +"\t" + tallyTable[18][1] + "\t" + tallyTable[18][2] + "\t" + tallyTable[18][3] + "\t" + tallyTable[18][4] + "\t" + tallyTable[18][5] + "\t" + tallyTable[18][6] + "\t" + tallyTable[18][7] + "\t" + tallyTable[18][8] + "\t" + tallyTable[18][9];
                            String content21 ="A,2" + "\t" + tallyTable[19][0] + "\t" + tallyTable[19][1] + "\t" + tallyTable[19][2] + "\t" + tallyTable[19][3] + "\t" + tallyTable[19][4] + "\t" + tallyTable[19][5] + "\t" + tallyTable[19][6] + "\t" + tallyTable[19][7] + "\t" + tallyTable[19][8] + "\t" + tallyTable[19][9];
                            String content22 ="A,3" + "\t" + tallyTable[20][0] + "\t" + tallyTable[20][1] + "\t" + tallyTable[20][2] + "\t" + tallyTable[20][3] + "\t" + tallyTable[20][4] + "\t" + tallyTable[20][5] + "\t" + tallyTable[20][6] + "\t" + tallyTable[20][7] + "\t" + tallyTable[20][8] + "\t" + tallyTable[20][9];
                            String content23 ="A,4" + "\t" + tallyTable[21][0] + "\t" + tallyTable[21][1] + "\t" + tallyTable[21][2] + "\t" + tallyTable[21][3] + "\t" + tallyTable[21][4] + "\t" + tallyTable[21][5] + "\t" + tallyTable[21][6] + "\t" + tallyTable[21][7] + "\t" + tallyTable[21][8] + "\t" + tallyTable[21][9];
                            String content24 ="A,5" + "\t" + tallyTable[22][0] + "\t" + tallyTable[22][1] + "\t" + tallyTable[22][2] + "\t" + tallyTable[22][3] + "\t" + tallyTable[22][4] + "\t" + tallyTable[22][5] + "\t" + tallyTable[22][6] + "\t" + tallyTable[22][7] + "\t" + tallyTable[22][8] + "\t" + tallyTable[22][9];
                            String content25 ="A,6" + "\t" + tallyTable[23][0] + "\t" + tallyTable[23][1] + "\t" + tallyTable[23][2] + "\t" + tallyTable[23][3] + "\t" + tallyTable[23][4] + "\t" + tallyTable[23][5] + "\t" + tallyTable[23][6] + "\t" + tallyTable[23][7] + "\t" + tallyTable[23][8] + "\t" + tallyTable[23][9];
                            String content26 ="A,7" + "\t" + tallyTable[24][0] + "\t" + tallyTable[24][1] + "\t" + tallyTable[24][2] + "\t" + tallyTable[24][3] + "\t" + tallyTable[24][4] + "\t" + tallyTable[24][5] + "\t" + tallyTable[24][6] + "\t" + tallyTable[24][7] + "\t" + tallyTable[24][8] + "\t" + tallyTable[24][9];
                            String content27 ="A,8" + "\t" + tallyTable[25][0] + "\t" + tallyTable[25][1] + "\t" + tallyTable[25][2] + "\t" + tallyTable[25][3] + "\t" + tallyTable[25][4] + "\t" + tallyTable[25][5] + "\t" + tallyTable[25][6] + "\t" + tallyTable[25][7] + "\t" + tallyTable[25][8] + "\t" + tallyTable[25][9];
                            String content28 ="A,9" + "\t" + tallyTable[26][0] + "\t" + tallyTable[26][1] + "\t" + tallyTable[26][2] + "\t" + tallyTable[26][3] + "\t" + tallyTable[26][4] + "\t" + tallyTable[26][5] + "\t" + tallyTable[26][6] + "\t" + tallyTable[26][7] + "\t" + tallyTable[26][8] + "\t" + tallyTable[26][9];
                            String content29 ="A,10" + "\t" + tallyTable[27][0] + "\t" + tallyTable[27][1] + "\t" + tallyTable[27][2] + "\t" + tallyTable[27][3] + "\t" + tallyTable[27][4] + "\t" + tallyTable[27][5] + "\t" + tallyTable[27][6] + "\t" + tallyTable[27][7] + "\t" + tallyTable[27][8] + "\t" + tallyTable[27][9];
                            String content30 ="A,A" + "\t" + tallyTable[28][0] + "\t" + tallyTable[28][1] + "\t" + tallyTable[28][2] + "\t" + tallyTable[28][3] + "\t" + tallyTable[28][4] + "\t" + tallyTable[28][5] + "\t" + tallyTable[28][6] + "\t" + tallyTable[28][7] + "\t" + tallyTable[28][8] + "\t" + tallyTable[28][9];
                            
                            //System.out.println("");
                                           
                           /* //Hit Percentage
                            for (int l = 0; l < tallyTable.length; l++) 
                            { 
                           	 for (int k = 0; k < tallyTable[l].length; k++) 
                           	 { 
                           		 if (tallyTable[l][k] == 'H')
                           		 {
                           		 tallyTable[l][k] = ' '; 
                           		 countT1++;
                           		 } 
                           	 }
                            }
                            
                       		System.out.println("Percent Won Using Hit " + ((countT1/290)*100) + "%");
                          	 
                            //Stand Percentage
                            for (int l = 0; l < tallyTable.length; l++) 
                            { 
                           	 for (int k = 0; k < tallyTable[l].length; k++) 
                           	 { 
                           		if (tallyTable[l][k] == 'S')
                           		{
                           		 tallyTable[l][k] = ' '; 
                           		 countT2++;

                          		 } 
                            }
                            }
                            
                          	 System.out.println("Percent Won Using Stand " + ((countT2/290)*100) + "%");
                            
                            //Split Percentage
                            for (int l = 0; l < tallyTable.length; l++) 
                            { 
                           	 for (int k = 0; k < tallyTable[l].length; k++) 
                           	 { 
                           		if (tallyTable[l][k] == 'P')
                           		{
                           		 tallyTable[l][k] = ' '; 
                           		 countT3++;

                          		 } 
                           	 }
                            }
                            
                          	 System.out.println("Percent Won Using Split " + ((countT3/290)*100) + "%");
                            
                            //Double Down Percentage                 
                            for (int l = 0; l < tallyTable.length; l++) 
                            { 
                           	 for (int k = 0; k < tallyTable[l].length; k++) 
                           	 { 
                           		if (tallyTable[l][k] == 'D')
                           		{
                           		 tallyTable[l][k] = ' '; 
                           		 countT4++;

                            }
                            }
                            }
                            
                          	 System.out.println("Percent Won Using Double Down " + ((countT4/290)*100) + "%");
                            System.out.println("\n\n");

                           	
                           	 int percent1 = ((countT1/totalTT)*100);
                           	 int percent2 = ((countT2/totalTT)*100);
                           	 int percent3 = ((countT3/totalTT)*100);
                           	 int percent4 = ((countT4/totalTT)*100);
                             System.out.println("\n\n");*/

                            /*
                            System.out.println("X\t2\t3\t4\t5\t6\t7\t8\t9\t10\tA");
                            System.out.println("5\tH\tH\tH\tH\tH\tH\tH\tH\tH\tH");
                            System.out.println("6\tH\tH\tH\tH\tH\tH\tH\tH\tH\tH");
                            System.out.println("8\tH\tH\tH\tH\tH\tH\tH\tH\tH\tH");
                            System.out.println("9\tH\tD\tD\tD\tD\tH\tH\tH\tH\tH");
                            System.out.println("10\tD\tD\tD\tD\tD\tD\tD\tD\tH\tH");
                            System.out.println("11\tD\tD\tD\tD\tD\tD\tD\tD\tD\tH");
                            System.out.println("12\tH\tH\tS\tS\tS\tH\tH\tH\tH\tH");
                            System.out.println("13\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH");
                            System.out.println("14\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH");
                            System.out.println("15\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH");
                            System.out.println("16\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH");
                            System.out.println("17\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("18\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("19\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("20\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("21\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("A,2\tH\tH\tH\tD\tD\tH\tH\tH\tH\tH");
                            System.out.println("A,3\tH\tH\tH\tD\tD\tH\tH\tH\tH\tH");
                            System.out.println("A,4\tH\tH\tD\tD\tD\tH\tH\tH\tH\tH");
                            System.out.println("A,5\tH\tH\tD\tD\tD\tH\tH\tH\tH\tH");
                            System.out.println("A,6\tH\tD\tD\tD\tD\tH\tH\tH\tH\tH");
                            System.out.println("A,7\tS\tD\tD\tD\tD\tS\tS\tH\tH\tH");
                            System.out.println("A,8\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("A,9\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("A,10\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("A,A\tP\tP\tP\tP\tP\tP\tP\tP\tP\tP");
                            System.out.println("2,2\tP\tP\tP\tP\tP\tP\tH\tH\tH\tH");
                            System.out.println("3,3\tP\tP\tP\tP\tP\tP\tH\tH\tH\tH");
                            System.out.println("4,4\tH\tH\tH\tP\tP\tH\tH\tH\tH\tH");
                            System.out.println("5,5\tD\tD\tD\tD\tD\tD\tD\tD\tH\tH");
                            System.out.println("6,6\tH\tP\tP\tP\tP\tH\tH\tH\tH\tH");
                            System.out.println("7,7\tP\tP\tP\tP\tP\tP\tH\tH\tH\tH");
                            System.out.println("8,8\tP\tP\tP\tP\tP\tP\tP\tP\tP\tP");
                            System.out.println("9,9\tP\tP\tP\tP\tP\tP\tP\tP\tS\tS");
                            System.out.println("10,10\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS"); */

                             /*
                            String content ="X\t2\t3\t4\t5\t6\t7\t8\t9\t10\tA";
                            String content2 ="8\tH\tH\tH\tH\tH\tH\tH\tH\tH\tH";
                            String content3 ="9\tH\tD\tD\tD\tD\tH\tH\tH\tH\tH";
                            String content4 ="10\tD\tD\tD\tD\tD\tD\tD\tD\tH\tH";
                            String content5 ="11\tD\tD\tD\tD\tD\tD\tD\tD\tD\tH";
                            String content6 ="12\tH\tH\tS\tS\tS\tH\tH\tH\tH\tH";
                            String content7 ="13\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH";
                            String content8 ="14\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH";
                            String content9 ="15\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH";
                            String content10 ="16\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH";
                            String content11 ="17\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS";
                            String content12 ="A,2\tH\tH\tH\tD\tD\tH\tH\tH\tH\tH";
                            String content13 ="A,3\tH\tH\tH\tD\tD\tH\tH\tH\tH\tH";
                            String content14 ="A,4\tH\tH\tD\tD\tD\tH\tH\tH\tH\tH";
                            String content15 ="A,5\tH\tH\tD\tD\tD\tH\tH\tH\tH\tH";
                            String content16 ="A,6\tH\tD\tD\tD\tD\tH\tH\tH\tH\tH";
                            String content17 ="A,7\tS\tD\tD\tD\tD\tS\tS\tH\tH\tH";
                            String content18 ="A,8\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS";
                            String content19 ="A,9\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS";
                            String content20 ="A,10\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS";
                            String content21 ="A,A\tP\tP\tP\tP\tP\tP\tP\tP\tP\tP";
                            String content22 ="2,2\tP\tP\tP\tP\tP\tP\tH\tH\tH\tH";
                            String content23 ="3,3\tP\tP\tP\tP\tP\tP\tH\tH\tH\tH";
                            String content24 ="4,4\tH\tH\tH\tP\tP\tH\tH\tH\tH\tH";
                            String content25 ="5,5\tD\tD\tD\tD\tD\tD\tD\tD\tH\tH";
                            String content26 ="6,6\tH\tP\tP\tP\tP\tH\tH\tH\tH\tH";
                            String content27 ="7,7\tP\tP\tP\tP\tP\tP\tH\tH\tH\tH";
                            String content28 ="8,8\tP\tP\tP\tP\tP\tP\tP\tP\tP\tP";
                            String content29 ="9,9\tP\tP\tP\tP\tP\tP\tP\tP\tS\tS";
                            String content30 ="10,10\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS";*/                		
                    /*/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                          System.out.println("");
                          System.out.println("");*/
                          
                          try 
                          {

                  			File file = new File("/Users/4leaf/Desktop/strategyCard.txt");

                  			// if file doesn't exists, then create it
                  			if (!file.exists()) 
                  			{
                  				file.createNewFile();
                  		    }
                          
                          //////////////////////////////////////////////////////////////////////////////////////////////////////////
                          //System.out.println("  |-----------------------------------------------------------------------|");
                          //System.out.println("\t   P \t\t   S \t\t    H \t\t        D \t");
                          //System.out.println("  |-----------------------------------------------------------------------|");

                          //System.out.println("  |               |                 |                  |                  |" );
                          //System.out.println("  |       0%      |       55%       |      30%         |       15%        |" );
                          //System.out.println("  |               |                 |                  |                  |" );
                          //System.out.println("  |               |                 |                  |                  |" );
                          //System.out.println("  |-----------------------------------------------------------------------|");

                          /*//End Delimeter
                          System.out.println("");
                          System.out.println("");
                	      String content = "  |-----------------------------------------------------------------------|";
                	      String content2 = "\t   P \t\t   S \t\t    H \t\t        D \t";
                	      String content3 = "  |-----------------------------------------------------------------------|";
                	      String content4 = "  |               |                 |                  |                  |";
                	      String content5 = "  |       0%      |       55%       |      30%         |       15%        |";
                	      String content6 = "  |               |                 |                  |                  |";
                	      String content7 = "  |               |                 |                  |                  |";
                	      String content8 = "  |-----------------------------------------------------------------------|";*/
                	      
                          FileWriter fw = new FileWriter(file.getAbsoluteFile());
                		  BufferedWriter bw = new BufferedWriter(fw);
                		  	bw.write(content);
                			bw.newLine();
                			bw.write(content2);
                			bw.newLine();
                			bw.write(content3);
                			bw.newLine();
                			bw.write(content4);
                			bw.newLine();
                			bw.write(content5);
                			bw.newLine();
                			bw.write(content6);
                			bw.newLine();
                			bw.write(content7);
                			bw.newLine();
                			bw.write(content8);
                			bw.newLine();
                			bw.write(content9);
                			bw.newLine();
                			bw.write(content10);
                			bw.newLine();
                			bw.write(content11);
                			bw.newLine();
                			bw.write(content12);
                			bw.newLine();
                			bw.write(content13);
                			bw.newLine();
                			bw.write(content14);
                			bw.newLine();
                			bw.write(content15);
                			bw.newLine();
                			bw.write(content16);
                			bw.newLine();
                			bw.write(content17);
                			bw.newLine();
                			bw.write(content18);
                			bw.newLine();
                			bw.write(content19);
                			bw.newLine();
                			bw.write(content20);
                			bw.newLine();
                			bw.write(content21);
                			bw.newLine();
                			bw.write(content22);
                			bw.newLine();
                			bw.write(content23);
                			bw.newLine();
                			bw.write(content24);
                			bw.newLine();
                			bw.write(content25);
                			bw.newLine();
                			bw.write(content26);
                			bw.newLine();
                			bw.write(content27);
                			bw.newLine();
                			bw.write(content28);
                			bw.newLine();
                			bw.write(content29);
                			bw.newLine();
                			bw.write(content30);
                			bw.newLine();
                			bw.close();
                			System.out.println("Done");

                        } 
                        catch (IOException e) 
                        {
                			e.printStackTrace();
                		  }
                  }
         else if(decknumber == 8) ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         {
        	 sql = "SELECT * FROM blackjackdatabase8";
             rs = stmt.executeQuery(sql);
            
             while(rs.next())
             {
               int id  = rs.getInt("idBlackJackDatabase");
               String CardValue = rs.getString("CardValue");
                  
          /*     System.out.print("ID: " + id);
               System.out.println(", CardValue: " + CardValue);*/
             }
             
             /*System.out.println("");
             System.out.println("Frequency Table");
             //System.out.println("Randomized Set of 20 Integers: ");
             System.out.println("");*/
             
             for(int Rnd = 0; Rnd < freq; Rnd++)
             {
           	  
             count = 0;
             
             sql2 = "SELECT * FROM blackjackdatabase8 ORDER BY RAND() LIMIT 20;";
             rs2 = stmt.executeQuery(sql2);
             
             while(rs2.next())
             {
           	 
           	int id  = rs2.getInt("idBlackJackDatabase");
           	
           	String CardValue = rs2.getString("CardValue");
           	
           	cards[count] = CardValue;
           	count++;
                                
               /*System.out.print("ID: " + id);
               System.out.println(", CardValue: " + CardValue);*/
             }
             
             /*System.out.println("");
             System.out.println("Your cards are....");
             System.out.println("");*/

             UserCard1 = cards[0];
             /*              System.out.println("User Card 1 : " + UserCard1);
             */              DealerCard1 = cards[1];
             /*              System.out.println("Dealer Card Down.... ");
             */              UserCard2 = cards[2];
             /*              System.out.println("User Card 2 : " + UserCard2);
             */              DealerCard2 = cards[3];
             /*              System.out.println("Dealer Card Shown: " + DealerCard2);*/
                             /*System.out.println("");*/
             				
             				/*System.out.println("User Card 1: " + UserCard1);
             				System.out.println("Dealer Card Down");
             				System.out.println("User Card 2: " + UserCard2);
             				System.out.println("Dealer Card Up: " + DealerCard2);*/
             				
             				if(UserCard1.equals("Jack") || UserCard1.equals("Queen") || UserCard1.equals("King"))
             				{
             					U1 = 10;
             				}
             				else if(UserCard1.equals("Ace"))
             				{
             					U1 = 1;
             				}
             				else
             				{
             					U1 = Integer.parseInt(UserCard1);
             				}
             				
             				
             				
             				if(UserCard2.equals("Jack") || UserCard2.equals("Queen") || UserCard2.equals("King"))
             				{
             					U2 = 10;
             				}
             				else if(UserCard2.equals("Ace"))
             				{
             					U2 = 1;
             				}
             				else
             				{
             					U2 = Integer.parseInt(UserCard2);
             				}
             				
             				
             				
             				if(DealerCard1.equals("Jack") || DealerCard1.equals("Queen") || DealerCard1.equals("King"))
             				{
             					D1 = 10;
             				}
             				else if(DealerCard1.equals("Ace"))
             				{
             					D1 = 1;
             				}
             				else
             				{
             					D1 = Integer.parseInt(DealerCard1);
             				}
             				
             				
             				
             				if(DealerCard2.equals("Jack") || DealerCard2.equals("Queen") || DealerCard2.equals("King"))
             				{
             					D2 = 10;
             				}
             				else if(DealerCard2.equals("Ace"))
             				{
             					D2 = 1;
             				}
             				else
             				{
             					D2 = Integer.parseInt(DealerCard2);
             				}
             				
             				
             				if(UserCard1.equals("Ace") && UserCard2.equals("Ace"))
             				{
             					totalU = 21;
             				}
             		 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
             		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
             				if(UserCard1.equals("Ace") && !UserCard2.equals("Ace"))
             				{
             					U1 = 11;
             				}
             				
             				if(UserCard2.equals("Ace") && !UserCard1.equals("Ace"))
             				{
             					U2 = 11;
             				}
             				
             				if(DealerCard1.equals("Ace") && !DealerCard2.equals("Ace"))
             				{
             					D1 = 11;
             				}
             				
             				if(DealerCard2.equals("Ace") && !DealerCard1.equals("Ace"))
             				{
             					D2 = 11;
             				}
             		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
             				
            	            //System.out.println("");
            				totalU = U1 + U2;
            	            totalD = D2;
            	            int totalDw2 = D1 + D2;
            	            /*
            	            System.out.println("User Card 1: " + U1);
            	            System.out.println("User Card 2: " + U2);
            				System.out.println("User Total: " + totalU);
            				System.out.println("Dealer Shown: " + D2);
            				System.out.println("Dealer Total: " + totalDw2);
                            */
                          /*  System.out.println("");
                            System.out.println("----------");
                            
                            
                            
                            //System.out.println(StrategyMethod(U1, U2, totalDw2));
                            System.out.println("");
                            System.out.println("");
                            System.out.println("");*/
                   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
                            
                            	if(totalU < 8)
                            	{
                            		SearchCond5 = "8";
                            	}
                            	else if(totalU > 17)
                            	{
                            		SearchCond5 = "17";
                            	}
                            	else
                            	{
                            		SearchCond5 = String.valueOf(totalU);
                            	}
                            	
                            	
            					if(DealerCard2.equals("Jack"))
                            	{
                            		DealerCardString5 = "10";
                            	}
            					
            					if(DealerCard2.equals("Queen"))
                            	{
                            		DealerCardString5 = "10";
                            	}
            					
            					if(DealerCard2.equals("King"))
                            	{
                            		DealerCardString5 = "10";
                            	}
            					
            					if(DealerCard2.equals("Ace"))
                            	{
                            		DealerCardString5 = "A";
                            	}
            					
            					String U1W, U2W;
            					if(UserCard1.equals("Ace"))
            					{
            						U1W = "A";
            					}
            					else
            					{
            						U1W = UserCard1;
            					}
            					
            					if(UserCard2.equals("Ace"))
            					{
            						U2W = "A";
            					}
            					else
            					{
            						U2W = UserCard2;
            					}
            					
            					String UserCheck = U1W + "," + U2W;
            					
            					
                              for (index = 0; index < 29; index++) 
                              {
                                //if index of user array is equal to the user total
                                if (tallyArrayUser[index].equals(SearchCond5)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } 
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } 
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } 
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } 
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } 
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                } 
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                else if (tallyArrayUser[index].equals(UserCheck)) 
                                {
                                  //initialize i to index
                                  //System.out.println("The current i is "+ i);
                                  i = index;
                                  //reset index value
                                  // index = 0;
                                }
                                

                                //looping through dealer array
                                for (index2 = 0; index2 < 10; index2++) 
                                {
                                  //if index of dealer array is equal to the dealer total
                                  if (tallyArrayDealer[index2].equals(DealerCard2) || tallyArrayDealer[index2].equals(DealerCardString5)) 
                                  {
                                    //initialize j to index
                                    //System.out.println("The current j is "+ j );
                                    j = index2;
                                    //reset index value
                                    break;
                                    
                                  }

                                }
                                tallyTable[i][j] = StrategyMethod(U1, U2, totalDw2);

                                // System.out.println("TALLY BEFORE: " + tallyTable[i][j]);
                                // System.out.println("TALLY AFTER: " + tallyTable[i][j]);
                                // System.out.println("TALLY BEFORE: " + tallyTable[index][index2]);
                                // tallyTable[index][index2]++;
                                // System.out.println("TALLY AFTER: " + tallyTable[index][index2]);
                              }
                            }
                            
                            
                     /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
                            
                            System.out.println("\n\n");
                            System.out.println("\t ---------------------------------------------------------------------------");
                            System.out.println("\t   2 \t 3 \t 4 \t 5 \t 6 \t 7 \t 8 \t 9 \t 10 \t A ");
                            System.out.println("\t ---------------------------------------------------------------------------");

                            System.out.println("        |");
                            System.out.println("  8     |   " + tallyTable[0][0] + "  \t  " + tallyTable[0][1] + "\t" + tallyTable[0][2] + "\t" + tallyTable[0][3] + "\t" + tallyTable[0][4] + "\t" + tallyTable[0][5] + "\t" + tallyTable[0][6] + "\t" + tallyTable[0][7] + "\t" + tallyTable[0][8] + "\t" + tallyTable[0][9]);
                            System.out.println("  9     |   " + tallyTable[1][0] + "  \t  " + tallyTable[1][1] + "\t" + tallyTable[1][2] + "\t" + tallyTable[1][3] + "\t" + tallyTable[1][4] + "\t" + tallyTable[1][5] + "\t" + tallyTable[1][6] + "\t" + tallyTable[1][7] + "\t" + tallyTable[1][8] + "\t" + tallyTable[1][9]);
                            System.out.println("  10    |   " + tallyTable[2][0] + "  \t  " + tallyTable[2][1] + "\t" + tallyTable[2][2] + "\t" + tallyTable[2][3] + "\t" + tallyTable[2][4] + "\t" + tallyTable[2][5] + "\t" + tallyTable[2][6] + "\t" + tallyTable[2][7] + "\t" + tallyTable[2][8] + "\t" + tallyTable[2][9]);
                            System.out.println("  11    |   " + tallyTable[3][0] + "  \t  " + tallyTable[3][1] + "\t" + tallyTable[3][2] + "\t" + tallyTable[3][3] + "\t" + tallyTable[3][4] + "\t" + tallyTable[3][5] + "\t" + tallyTable[3][6] + "\t" + tallyTable[3][7] + "\t" + tallyTable[3][8] + "\t" + tallyTable[3][9]);
                            System.out.println("  12    |   " + tallyTable[4][0] + "  \t  " + tallyTable[4][1] + "\t" + tallyTable[4][2] + "\t" + tallyTable[4][3] + "\t" + tallyTable[4][4] + "\t" + tallyTable[4][5] + "\t" + tallyTable[4][6] + "\t" + tallyTable[4][7] + "\t" + tallyTable[4][8] + "\t" + tallyTable[4][9]);
                            System.out.println("  13    |   " + tallyTable[5][0] + "  \t  " + tallyTable[5][1] + "\t" + tallyTable[5][2] + "\t" + tallyTable[5][3] + "\t" + tallyTable[5][4] + "\t" + tallyTable[5][5] + "\t" + tallyTable[5][6] + "\t" + tallyTable[5][7] + "\t" + tallyTable[5][8] + "\t" + tallyTable[5][9]);
                            System.out.println("  14    |   " + tallyTable[6][0] + "  \t  " + tallyTable[6][1] + "\t" + tallyTable[6][2] + "\t" + tallyTable[6][3] + "\t" + tallyTable[6][4] + "\t" + tallyTable[6][5] + "\t" + tallyTable[6][6] + "\t" + tallyTable[6][7] + "\t" + tallyTable[6][8] + "\t" + tallyTable[6][9]);
                            System.out.println("  15    |   " + tallyTable[7][0] + "  \t  " + tallyTable[7][1] + "\t" + tallyTable[7][2] + "\t" + tallyTable[7][3] + "\t" + tallyTable[7][4] + "\t" + tallyTable[7][5] + "\t" + tallyTable[7][6] + "\t" + tallyTable[7][7] + "\t" + tallyTable[7][8] + "\t" + tallyTable[7][9]);
                            System.out.println("  16    |   " + tallyTable[8][0] + "  \t  " + tallyTable[8][1] + "\t" + tallyTable[8][2] + "\t" + tallyTable[8][3] + "\t" + tallyTable[8][4] + "\t" + tallyTable[8][5] + "\t" + tallyTable[8][6] + "\t" + tallyTable[8][7] + "\t" + tallyTable[8][8] + "\t" + tallyTable[8][9]);
                            System.out.println("  17    |   " + tallyTable[9][0] + "  \t  " + tallyTable[9][1] + "\t" + tallyTable[9][2] + "\t" + tallyTable[9][3] + "\t" + tallyTable[9][4] + "\t" + tallyTable[9][5] + "\t" + tallyTable[9][6] + "\t" + tallyTable[9][7] + "\t" + tallyTable[9][8] + "\t" + tallyTable[9][9]);
                            System.out.println("  2,2   |   " + tallyTable[10][0] + "  \t  " + tallyTable[10][1] + "\t" + tallyTable[10][2] + "\t" + tallyTable[10][3] + "\t" + tallyTable[10][4] + "\t" + tallyTable[10][5] + "\t" + tallyTable[10][6] + "\t" + tallyTable[10][7] + "\t" + tallyTable[10][8] + "\t" + tallyTable[10][9]);
                            System.out.println("  3,3   |   " + tallyTable[11][0] + "  \t  " + tallyTable[11][1] + "\t" + tallyTable[11][2] + "\t" + tallyTable[11][3] + "\t" + tallyTable[11][4] + "\t" + tallyTable[11][5] + "\t" + tallyTable[11][6] + "\t" + tallyTable[11][7] + "\t" + tallyTable[11][8] + "\t" + tallyTable[11][9]);
                            System.out.println("  4,4   |   " + tallyTable[12][0] + "  \t  " + tallyTable[12][1] + "\t" + tallyTable[12][2] + "\t" + tallyTable[12][3] + "\t" + tallyTable[12][4] + "\t" + tallyTable[12][5] + "\t" + tallyTable[12][6] + "\t" + tallyTable[12][7] + "\t" + tallyTable[12][8] + "\t" + tallyTable[12][9]);
                            System.out.println("  5,5   |   " + tallyTable[13][0] + "  \t  " + tallyTable[13][1] + "\t" + tallyTable[13][2] + "\t" + tallyTable[13][3] + "\t" + tallyTable[13][4] + "\t" + tallyTable[13][5] + "\t" + tallyTable[13][6] + "\t" + tallyTable[13][7] + "\t" + tallyTable[13][8] + "\t" + tallyTable[13][9]);
                            System.out.println("  6,6   |   " + tallyTable[14][0] + "  \t  " + tallyTable[14][1] + "\t" + tallyTable[14][2] + "\t" + tallyTable[14][3] + "\t" + tallyTable[14][4] + "\t" + tallyTable[14][5] + "\t" + tallyTable[14][6] + "\t" + tallyTable[14][7] + "\t" + tallyTable[14][8] + "\t" + tallyTable[14][9]);
                            System.out.println("  7,7   |   " + tallyTable[15][0] + "  \t  " + tallyTable[15][1] + "\t" + tallyTable[15][2] + "\t" + tallyTable[15][3] + "\t" + tallyTable[15][4] + "\t" + tallyTable[15][5] + "\t" + tallyTable[15][6] + "\t" + tallyTable[15][7] + "\t" + tallyTable[15][8] + "\t" + tallyTable[15][9]);
                            System.out.println("  8,8   |   " + tallyTable[16][0] + "  \t  " + tallyTable[16][1] + "\t" + tallyTable[16][2] + "\t" + tallyTable[16][3] + "\t" + tallyTable[16][4] + "\t" + tallyTable[16][5] + "\t" + tallyTable[16][6] + "\t" + tallyTable[16][7] + "\t" + tallyTable[16][8] + "\t" + tallyTable[16][9]);
                            System.out.println("  9,9   |   " + tallyTable[17][0] + "  \t  " + tallyTable[17][1] + "\t" + tallyTable[17][2] + "\t" + tallyTable[17][3] + "\t" + tallyTable[17][4] + "\t" + tallyTable[17][5] + "\t" + tallyTable[17][6] + "\t" + tallyTable[17][7] + "\t" + tallyTable[17][8] + "\t" + tallyTable[17][9]);
                            System.out.println("  10,10 |   " + tallyTable[18][0] + "  \t  " + tallyTable[18][1] + "\t" + tallyTable[18][2] + "\t" + tallyTable[18][3] + "\t" + tallyTable[18][4] + "\t" + tallyTable[18][5] + "\t" + tallyTable[18][6] + "\t" + tallyTable[18][7] + "\t" + tallyTable[18][8] + "\t" + tallyTable[18][9]);
                            System.out.println("  A,2   |   " + tallyTable[19][0] + "  \t  " + tallyTable[19][1] + "\t" + tallyTable[19][2] + "\t" + tallyTable[19][3] + "\t" + tallyTable[19][4] + "\t" + tallyTable[19][5] + "\t" + tallyTable[19][6] + "\t" + tallyTable[19][7] + "\t" + tallyTable[19][8] + "\t" + tallyTable[19][9]);
                            System.out.println("  A,3   |   " + tallyTable[20][0] + "  \t  " + tallyTable[20][1] + "\t" + tallyTable[20][2] + "\t" + tallyTable[20][3] + "\t" + tallyTable[20][4] + "\t" + tallyTable[20][5] + "\t" + tallyTable[20][6] + "\t" + tallyTable[20][7] + "\t" + tallyTable[20][8] + "\t" + tallyTable[20][9]);
                            System.out.println("  A,4   |   " + tallyTable[21][0] + "  \t  " + tallyTable[21][1] + "\t" + tallyTable[21][2] + "\t" + tallyTable[21][3] + "\t" + tallyTable[21][4] + "\t" + tallyTable[21][5] + "\t" + tallyTable[21][6] + "\t" + tallyTable[21][7] + "\t" + tallyTable[21][8] + "\t" + tallyTable[21][9]);
                            System.out.println("  A,5   |   " + tallyTable[22][0] + "  \t  " + tallyTable[22][1] + "\t" + tallyTable[22][2] + "\t" + tallyTable[22][3] + "\t" + tallyTable[22][4] + "\t" + tallyTable[22][5] + "\t" + tallyTable[22][6] + "\t" + tallyTable[22][7] + "\t" + tallyTable[22][8] + "\t" + tallyTable[22][9]);
                            System.out.println("  A,6   |   " + tallyTable[23][0] + "  \t  " + tallyTable[23][1] + "\t" + tallyTable[23][2] + "\t" + tallyTable[23][3] + "\t" + tallyTable[23][4] + "\t" + tallyTable[23][5] + "\t" + tallyTable[23][6] + "\t" + tallyTable[23][7] + "\t" + tallyTable[23][8] + "\t" + tallyTable[23][9]);
                            System.out.println("  A,7   |   " + tallyTable[24][0] + "  \t  " + tallyTable[24][1] + "\t" + tallyTable[24][2] + "\t" + tallyTable[24][3] + "\t" + tallyTable[24][4] + "\t" + tallyTable[24][5] + "\t" + tallyTable[24][6] + "\t" + tallyTable[24][7] + "\t" + tallyTable[24][8] + "\t" + tallyTable[24][9]);
                            System.out.println("  A,8   |   " + tallyTable[25][0] + "  \t  " + tallyTable[25][1] + "\t" + tallyTable[25][2] + "\t" + tallyTable[25][3] + "\t" + tallyTable[25][4] + "\t" + tallyTable[25][5] + "\t" + tallyTable[25][6] + "\t" + tallyTable[25][7] + "\t" + tallyTable[25][8] + "\t" + tallyTable[25][9]);
                            System.out.println("  A,9   |   " + tallyTable[26][0] + "  \t  " + tallyTable[26][1] + "\t" + tallyTable[26][2] + "\t" + tallyTable[26][3] + "\t" + tallyTable[26][4] + "\t" + tallyTable[26][5] + "\t" + tallyTable[26][6] + "\t" + tallyTable[26][7] + "\t" + tallyTable[26][8] + "\t" + tallyTable[26][9]);
                            System.out.println("  A,10  |   " + tallyTable[27][0] + "  \t  " + tallyTable[27][1] + "\t" + tallyTable[27][2] + "\t" + tallyTable[27][3] + "\t" + tallyTable[27][4] + "\t" + tallyTable[27][5] + "\t" + tallyTable[27][6] + "\t" + tallyTable[27][7] + "\t" + tallyTable[27][8] + "\t" + tallyTable[27][9]);
                            System.out.println("  A,A   |   " + tallyTable[28][0] + "  \t  " + tallyTable[28][1] + "\t" + tallyTable[28][2] + "\t" + tallyTable[28][3] + "\t" + tallyTable[28][4] + "\t" + tallyTable[28][5] + "\t" + tallyTable[28][6] + "\t" + tallyTable[28][7] + "\t" + tallyTable[28][8] + "\t" + tallyTable[28][9]);
                            
                            String content ="X\t2\t3\t4\t5\t6\t7\t8\t9\t10\tA";
                            String content2 ="8" + "\t" + tallyTable[0][0] + "\t" + tallyTable[0][1] + "\t" + tallyTable[0][2] + "\t" + tallyTable[0][3] + "\t" + tallyTable[0][4] + "\t" + tallyTable[0][5] + "\t" + tallyTable[0][6] + "\t" + tallyTable[0][7] + "\t" + tallyTable[0][8] + "\t" + tallyTable[0][9];
                            String content3 ="9" + "\t" + tallyTable[1][0] + "\t" + tallyTable[1][1] + "\t" + tallyTable[1][2] + "\t" + tallyTable[1][3] + "\t" + tallyTable[1][4] + "\t" + tallyTable[1][5] + "\t" + tallyTable[1][6] + "\t" + tallyTable[1][7] + "\t" + tallyTable[1][8] + "\t" + tallyTable[1][9];
                            String content4 ="10" + "\t" + tallyTable[2][0] + "\t" + tallyTable[2][1] + "\t" + tallyTable[2][2] + "\t" + tallyTable[2][3] + "\t" + tallyTable[2][4] + "\t" + tallyTable[2][5] + "\t" + tallyTable[2][6] + "\t" + tallyTable[2][7] + "\t" + tallyTable[2][8] + "\t" + tallyTable[2][9];
                            String content5 ="11" + "\t" + tallyTable[3][0] + "\t" + tallyTable[3][1] + "\t" + tallyTable[3][2] + "\t" + tallyTable[3][3] + "\t" + tallyTable[3][4] + "\t" + tallyTable[3][5] + "\t" + tallyTable[3][6] + "\t" + tallyTable[3][7] + "\t" + tallyTable[3][8] + "\t" + tallyTable[3][9];
                            String content6 ="12" + "\t" + tallyTable[4][0] + "\t" + tallyTable[4][1] + "\t" + tallyTable[4][2] + "\t" + tallyTable[4][3] + "\t" + tallyTable[4][4] + "\t" + tallyTable[4][5] + "\t" + tallyTable[4][6] + "\t" + tallyTable[4][7] + "\t" + tallyTable[4][8] + "\t" + tallyTable[4][9];
                            String content7 ="13" + "\t" + tallyTable[5][0] + "\t" + tallyTable[5][1] + "\t" + tallyTable[5][2] + "\t" + tallyTable[5][3] + "\t" + tallyTable[5][4] + "\t" + tallyTable[5][5] + "\t" + tallyTable[5][6] + "\t" + tallyTable[5][7] + "\t" + tallyTable[5][8] + "\t" + tallyTable[5][9];
                            String content8 ="14" + "\t" + tallyTable[6][0] + "\t" + tallyTable[6][1] + "\t" + tallyTable[6][2] + "\t" + tallyTable[6][3] + "\t" + tallyTable[6][4] + "\t" + tallyTable[6][5] + "\t" + tallyTable[6][6] + "\t" + tallyTable[6][7] + "\t" + tallyTable[6][8] + "\t" + tallyTable[6][9];
                            String content9 ="15" + "\t" + tallyTable[7][0] + "\t" + tallyTable[7][1] + "\t" + tallyTable[7][2] + "\t" + tallyTable[7][3] + "\t" + tallyTable[7][4] + "\t" + tallyTable[7][5] + "\t" + tallyTable[7][6] + "\t" + tallyTable[7][7] + "\t" + tallyTable[7][8] + "\t" + tallyTable[7][9];
                            String content10 ="16" + "\t" + tallyTable[8][0] + "\t" + tallyTable[8][1] + "\t" + tallyTable[8][2] + "\t" + tallyTable[8][3] + "\t" + tallyTable[8][4] + "\t" + tallyTable[8][5] + "\t" + tallyTable[8][6] + "\t" + tallyTable[8][7] + "\t" + tallyTable[8][8] + "\t" + tallyTable[8][9];
                            String content11 ="17" + "\t" + tallyTable[9][0] + "\t" + tallyTable[9][1] + "\t" + tallyTable[9][2] + "\t" + tallyTable[9][3] + "\t" + tallyTable[9][4] + "\t" + tallyTable[9][5] + "\t" + tallyTable[9][6] + "\t" + tallyTable[9][7] + "\t" + tallyTable[9][8] + "\t" + tallyTable[9][9];
                            String content12 ="2,2" + "\t" + tallyTable[10][0] + "\t" + tallyTable[10][1] + "\t" + tallyTable[10][2] + "\t" + tallyTable[10][3] + "\t" + tallyTable[10][4] + "\t" + tallyTable[10][5] + "\t" + tallyTable[10][6] + "\t" + tallyTable[10][7] + "\t" + tallyTable[10][8] + "\t" + tallyTable[10][9];
                            String content13 ="3,3" + "\t" + tallyTable[11][0] + "\t" + tallyTable[11][1] + "\t" + tallyTable[11][2] + "\t" + tallyTable[11][3] + "\t" + tallyTable[11][4] + "\t" + tallyTable[11][5] + "\t" + tallyTable[11][6] + "\t" + tallyTable[11][7] + "\t" + tallyTable[11][8] + "\t" + tallyTable[11][9];
                            String content14 ="4,4" + "\t" + tallyTable[12][0] + "\t" + tallyTable[12][1] + "\t" + tallyTable[12][2] + "\t" + tallyTable[12][3] + "\t" + tallyTable[12][4] + "\t" + tallyTable[12][5] + "\t" + tallyTable[12][6] + "\t" + tallyTable[12][7] + "\t" + tallyTable[12][8] + "\t" + tallyTable[12][9];
                            String content15 ="5,5" + "\t" + tallyTable[13][0] + "\t" + tallyTable[13][1] + "\t" + tallyTable[13][2] + "\t" + tallyTable[13][3] + "\t" + tallyTable[13][4] + "\t" + tallyTable[13][5] + "\t" + tallyTable[13][6] + "\t" + tallyTable[13][7] + "\t" + tallyTable[13][8] + "\t" + tallyTable[13][9];
                            String content16 ="6,6" + "\t" + tallyTable[14][0] + "\t" + tallyTable[14][1] + "\t" + tallyTable[14][2] + "\t" + tallyTable[14][3] + "\t" + tallyTable[14][4] + "\t" + tallyTable[14][5] + "\t" + tallyTable[14][6] + "\t" + tallyTable[14][7] + "\t" + tallyTable[14][8] + "\t" + tallyTable[14][9];
                            String content17 ="7,7" + "\t" + tallyTable[15][0] + "\t" + tallyTable[15][1] + "\t" + tallyTable[15][2] + "\t" + tallyTable[15][3] + "\t" + tallyTable[15][4] + "\t" + tallyTable[15][5] + "\t" + tallyTable[15][6] + "\t" + tallyTable[15][7] + "\t" + tallyTable[15][8] + "\t" + tallyTable[15][9];
                            String content18 ="8,8" + "\t" + tallyTable[16][0] + "\t" + tallyTable[16][1] + "\t" + tallyTable[16][2] + "\t" + tallyTable[16][3] + "\t" + tallyTable[16][4] + "\t" + tallyTable[16][5] + "\t" + tallyTable[16][6] + "\t" + tallyTable[16][7] + "\t" + tallyTable[16][8] + "\t" + tallyTable[16][9];
                            String content19 ="9,9" + "\t" + tallyTable[17][0] + "\t" + tallyTable[17][1] + "\t" + tallyTable[17][2] + "\t" + tallyTable[17][3] + "\t" + tallyTable[17][4] + "\t" + tallyTable[17][5] + "\t" + tallyTable[17][6] + "\t" + tallyTable[17][7] + "\t" + tallyTable[17][8] + "\t" + tallyTable[17][9];
                            String content20 ="10,10" + "\t" + tallyTable[18][0] +"\t" + tallyTable[18][1] + "\t" + tallyTable[18][2] + "\t" + tallyTable[18][3] + "\t" + tallyTable[18][4] + "\t" + tallyTable[18][5] + "\t" + tallyTable[18][6] + "\t" + tallyTable[18][7] + "\t" + tallyTable[18][8] + "\t" + tallyTable[18][9];
                            String content21 ="A,2" + "\t" + tallyTable[19][0] + "\t" + tallyTable[19][1] + "\t" + tallyTable[19][2] + "\t" + tallyTable[19][3] + "\t" + tallyTable[19][4] + "\t" + tallyTable[19][5] + "\t" + tallyTable[19][6] + "\t" + tallyTable[19][7] + "\t" + tallyTable[19][8] + "\t" + tallyTable[19][9];
                            String content22 ="A,3" + "\t" + tallyTable[20][0] + "\t" + tallyTable[20][1] + "\t" + tallyTable[20][2] + "\t" + tallyTable[20][3] + "\t" + tallyTable[20][4] + "\t" + tallyTable[20][5] + "\t" + tallyTable[20][6] + "\t" + tallyTable[20][7] + "\t" + tallyTable[20][8] + "\t" + tallyTable[20][9];
                            String content23 ="A,4" + "\t" + tallyTable[21][0] + "\t" + tallyTable[21][1] + "\t" + tallyTable[21][2] + "\t" + tallyTable[21][3] + "\t" + tallyTable[21][4] + "\t" + tallyTable[21][5] + "\t" + tallyTable[21][6] + "\t" + tallyTable[21][7] + "\t" + tallyTable[21][8] + "\t" + tallyTable[21][9];
                            String content24 ="A,5" + "\t" + tallyTable[22][0] + "\t" + tallyTable[22][1] + "\t" + tallyTable[22][2] + "\t" + tallyTable[22][3] + "\t" + tallyTable[22][4] + "\t" + tallyTable[22][5] + "\t" + tallyTable[22][6] + "\t" + tallyTable[22][7] + "\t" + tallyTable[22][8] + "\t" + tallyTable[22][9];
                            String content25 ="A,6" + "\t" + tallyTable[23][0] + "\t" + tallyTable[23][1] + "\t" + tallyTable[23][2] + "\t" + tallyTable[23][3] + "\t" + tallyTable[23][4] + "\t" + tallyTable[23][5] + "\t" + tallyTable[23][6] + "\t" + tallyTable[23][7] + "\t" + tallyTable[23][8] + "\t" + tallyTable[23][9];
                            String content26 ="A,7" + "\t" + tallyTable[24][0] + "\t" + tallyTable[24][1] + "\t" + tallyTable[24][2] + "\t" + tallyTable[24][3] + "\t" + tallyTable[24][4] + "\t" + tallyTable[24][5] + "\t" + tallyTable[24][6] + "\t" + tallyTable[24][7] + "\t" + tallyTable[24][8] + "\t" + tallyTable[24][9];
                            String content27 ="A,8" + "\t" + tallyTable[25][0] + "\t" + tallyTable[25][1] + "\t" + tallyTable[25][2] + "\t" + tallyTable[25][3] + "\t" + tallyTable[25][4] + "\t" + tallyTable[25][5] + "\t" + tallyTable[25][6] + "\t" + tallyTable[25][7] + "\t" + tallyTable[25][8] + "\t" + tallyTable[25][9];
                            String content28 ="A,9" + "\t" + tallyTable[26][0] + "\t" + tallyTable[26][1] + "\t" + tallyTable[26][2] + "\t" + tallyTable[26][3] + "\t" + tallyTable[26][4] + "\t" + tallyTable[26][5] + "\t" + tallyTable[26][6] + "\t" + tallyTable[26][7] + "\t" + tallyTable[26][8] + "\t" + tallyTable[26][9];
                            String content29 ="A,10" + "\t" + tallyTable[27][0] + "\t" + tallyTable[27][1] + "\t" + tallyTable[27][2] + "\t" + tallyTable[27][3] + "\t" + tallyTable[27][4] + "\t" + tallyTable[27][5] + "\t" + tallyTable[27][6] + "\t" + tallyTable[27][7] + "\t" + tallyTable[27][8] + "\t" + tallyTable[27][9];
                            String content30 ="A,A" + "\t" + tallyTable[28][0] + "\t" + tallyTable[28][1] + "\t" + tallyTable[28][2] + "\t" + tallyTable[28][3] + "\t" + tallyTable[28][4] + "\t" + tallyTable[28][5] + "\t" + tallyTable[28][6] + "\t" + tallyTable[28][7] + "\t" + tallyTable[28][8] + "\t" + tallyTable[28][9];
                            
                            System.out.println("");
                                           
                           /* //Hit Percentage
                            for (int l = 0; l < tallyTable.length; l++) 
                            { 
                           	 for (int k = 0; k < tallyTable[l].length; k++) 
                           	 { 
                           		 if (tallyTable[l][k] == 'H')
                           		 {
                           		 tallyTable[l][k] = ' '; 
                           		 countT1++;
                           		 } 
                           	 }
                            }
                            
                       		System.out.println("Percent Won Using Hit " + ((countT1/290)*100) + "%");
                          	 
                            //Stand Percentage
                            for (int l = 0; l < tallyTable.length; l++) 
                            { 
                           	 for (int k = 0; k < tallyTable[l].length; k++) 
                           	 { 
                           		if (tallyTable[l][k] == 'S')
                           		{
                           		 tallyTable[l][k] = ' '; 
                           		 countT2++;

                          		 } 
                            }
                            }
                            
                          	 System.out.println("Percent Won Using Stand " + ((countT2/290)*100) + "%");
                            
                            //Split Percentage
                            for (int l = 0; l < tallyTable.length; l++) 
                            { 
                           	 for (int k = 0; k < tallyTable[l].length; k++) 
                           	 { 
                           		if (tallyTable[l][k] == 'P')
                           		{
                           		 tallyTable[l][k] = ' '; 
                           		 countT3++;

                          		 } 
                           	 }
                            }
                            
                          	 System.out.println("Percent Won Using Split " + ((countT3/290)*100) + "%");
                            
                            //Double Down Percentage                 
                            for (int l = 0; l < tallyTable.length; l++) 
                            { 
                           	 for (int k = 0; k < tallyTable[l].length; k++) 
                           	 { 
                           		if (tallyTable[l][k] == 'D')
                           		{
                           		 tallyTable[l][k] = ' '; 
                           		 countT4++;

                            }
                            }
                            }
                            
                          	 System.out.println("Percent Won Using Double Down " + ((countT4/290)*100) + "%");
                            System.out.println("\n\n");

                           	
                           	 int percent1 = ((countT1/totalTT)*100);
                           	 int percent2 = ((countT2/totalTT)*100);
                           	 int percent3 = ((countT3/totalTT)*100);
                           	 int percent4 = ((countT4/totalTT)*100);
                             System.out.println("\n\n");*/

                            /*
                            System.out.println("X\t2\t3\t4\t5\t6\t7\t8\t9\t10\tA");
                            System.out.println("5\tH\tH\tH\tH\tH\tH\tH\tH\tH\tH");
                            System.out.println("6\tH\tH\tH\tH\tH\tH\tH\tH\tH\tH");
                            System.out.println("8\tH\tH\tH\tH\tH\tH\tH\tH\tH\tH");
                            System.out.println("9\tH\tD\tD\tD\tD\tH\tH\tH\tH\tH");
                            System.out.println("10\tD\tD\tD\tD\tD\tD\tD\tD\tH\tH");
                            System.out.println("11\tD\tD\tD\tD\tD\tD\tD\tD\tD\tH");
                            System.out.println("12\tH\tH\tS\tS\tS\tH\tH\tH\tH\tH");
                            System.out.println("13\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH");
                            System.out.println("14\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH");
                            System.out.println("15\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH");
                            System.out.println("16\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH");
                            System.out.println("17\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("18\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("19\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("20\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("21\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("A,2\tH\tH\tH\tD\tD\tH\tH\tH\tH\tH");
                            System.out.println("A,3\tH\tH\tH\tD\tD\tH\tH\tH\tH\tH");
                            System.out.println("A,4\tH\tH\tD\tD\tD\tH\tH\tH\tH\tH");
                            System.out.println("A,5\tH\tH\tD\tD\tD\tH\tH\tH\tH\tH");
                            System.out.println("A,6\tH\tD\tD\tD\tD\tH\tH\tH\tH\tH");
                            System.out.println("A,7\tS\tD\tD\tD\tD\tS\tS\tH\tH\tH");
                            System.out.println("A,8\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("A,9\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("A,10\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS");
                            System.out.println("A,A\tP\tP\tP\tP\tP\tP\tP\tP\tP\tP");
                            System.out.println("2,2\tP\tP\tP\tP\tP\tP\tH\tH\tH\tH");
                            System.out.println("3,3\tP\tP\tP\tP\tP\tP\tH\tH\tH\tH");
                            System.out.println("4,4\tH\tH\tH\tP\tP\tH\tH\tH\tH\tH");
                            System.out.println("5,5\tD\tD\tD\tD\tD\tD\tD\tD\tH\tH");
                            System.out.println("6,6\tH\tP\tP\tP\tP\tH\tH\tH\tH\tH");
                            System.out.println("7,7\tP\tP\tP\tP\tP\tP\tH\tH\tH\tH");
                            System.out.println("8,8\tP\tP\tP\tP\tP\tP\tP\tP\tP\tP");
                            System.out.println("9,9\tP\tP\tP\tP\tP\tP\tP\tP\tS\tS");
                            System.out.println("10,10\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS"); */

                             /*
                            String content ="X\t2\t3\t4\t5\t6\t7\t8\t9\t10\tA";
                            String content2 ="8\tH\tH\tH\tH\tH\tH\tH\tH\tH\tH";
                            String content3 ="9\tH\tD\tD\tD\tD\tH\tH\tH\tH\tH";
                            String content4 ="10\tD\tD\tD\tD\tD\tD\tD\tD\tH\tH";
                            String content5 ="11\tD\tD\tD\tD\tD\tD\tD\tD\tD\tH";
                            String content6 ="12\tH\tH\tS\tS\tS\tH\tH\tH\tH\tH";
                            String content7 ="13\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH";
                            String content8 ="14\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH";
                            String content9 ="15\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH";
                            String content10 ="16\tS\tS\tS\tS\tS\tH\tH\tH\tH\tH";
                            String content11 ="17\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS";
                            String content12 ="A,2\tH\tH\tH\tD\tD\tH\tH\tH\tH\tH";
                            String content13 ="A,3\tH\tH\tH\tD\tD\tH\tH\tH\tH\tH";
                            String content14 ="A,4\tH\tH\tD\tD\tD\tH\tH\tH\tH\tH";
                            String content15 ="A,5\tH\tH\tD\tD\tD\tH\tH\tH\tH\tH";
                            String content16 ="A,6\tH\tD\tD\tD\tD\tH\tH\tH\tH\tH";
                            String content17 ="A,7\tS\tD\tD\tD\tD\tS\tS\tH\tH\tH";
                            String content18 ="A,8\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS";
                            String content19 ="A,9\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS";
                            String content20 ="A,10\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS";
                            String content21 ="A,A\tP\tP\tP\tP\tP\tP\tP\tP\tP\tP";
                            String content22 ="2,2\tP\tP\tP\tP\tP\tP\tH\tH\tH\tH";
                            String content23 ="3,3\tP\tP\tP\tP\tP\tP\tH\tH\tH\tH";
                            String content24 ="4,4\tH\tH\tH\tP\tP\tH\tH\tH\tH\tH";
                            String content25 ="5,5\tD\tD\tD\tD\tD\tD\tD\tD\tH\tH";
                            String content26 ="6,6\tH\tP\tP\tP\tP\tH\tH\tH\tH\tH";
                            String content27 ="7,7\tP\tP\tP\tP\tP\tP\tH\tH\tH\tH";
                            String content28 ="8,8\tP\tP\tP\tP\tP\tP\tP\tP\tP\tP";
                            String content29 ="9,9\tP\tP\tP\tP\tP\tP\tP\tP\tS\tS";
                            String content30 ="10,10\tS\tS\tS\tS\tS\tS\tS\tS\tS\tS";*/                		
                    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                          System.out.println("");
                          System.out.println("");
                          
                          try 
                          {

                  			File file = new File("/Users/4leaf/Desktop/strategyCard.txt");

                  			// if file doesn't exists, then create it
                  			if (!file.exists()) 
                  			{
                  				file.createNewFile();
                  		    }
                          
                          //////////////////////////////////////////////////////////////////////////////////////////////////////////
                          //System.out.println("  |-----------------------------------------------------------------------|");
                          //System.out.println("\t   P \t\t   S \t\t    H \t\t        D \t");
                          //System.out.println("  |-----------------------------------------------------------------------|");

                          //System.out.println("  |               |                 |                  |                  |" );
                          //System.out.println("  |       0%      |       55%       |      30%         |       15%        |" );
                          //System.out.println("  |               |                 |                  |                  |" );
                          //System.out.println("  |               |                 |                  |                  |" );
                          //System.out.println("  |-----------------------------------------------------------------------|");

                          /*//End Delimeter
                          System.out.println("");
                          System.out.println("");
                	      String content = "  |-----------------------------------------------------------------------|";
                	      String content2 = "\t   P \t\t   S \t\t    H \t\t        D \t";
                	      String content3 = "  |-----------------------------------------------------------------------|";
                	      String content4 = "  |               |                 |                  |                  |";
                	      String content5 = "  |       0%      |       55%       |      30%         |       15%        |";
                	      String content6 = "  |               |                 |                  |                  |";
                	      String content7 = "  |               |                 |                  |                  |";
                	      String content8 = "  |-----------------------------------------------------------------------|";*/
                	      
                          FileWriter fw = new FileWriter(file.getAbsoluteFile());
                		  BufferedWriter bw = new BufferedWriter(fw);
                		  	bw.write(content);
                			bw.newLine();
                			bw.write(content2);
                			bw.newLine();
                			bw.write(content3);
                			bw.newLine();
                			bw.write(content4);
                			bw.newLine();
                			bw.write(content5);
                			bw.newLine();
                			bw.write(content6);
                			bw.newLine();
                			bw.write(content7);
                			bw.newLine();
                			bw.write(content8);
                			bw.newLine();
                			bw.write(content9);
                			bw.newLine();
                			bw.write(content10);
                			bw.newLine();
                			bw.write(content11);
                			bw.newLine();
                			bw.write(content12);
                			bw.newLine();
                			bw.write(content13);
                			bw.newLine();
                			bw.write(content14);
                			bw.newLine();
                			bw.write(content15);
                			bw.newLine();
                			bw.write(content16);
                			bw.newLine();
                			bw.write(content17);
                			bw.newLine();
                			bw.write(content18);
                			bw.newLine();
                			bw.write(content19);
                			bw.newLine();
                			bw.write(content20);
                			bw.newLine();
                			bw.write(content21);
                			bw.newLine();
                			bw.write(content22);
                			bw.newLine();
                			bw.write(content23);
                			bw.newLine();
                			bw.write(content24);
                			bw.newLine();
                			bw.write(content25);
                			bw.newLine();
                			bw.write(content26);
                			bw.newLine();
                			bw.write(content27);
                			bw.newLine();
                			bw.write(content28);
                			bw.newLine();
                			bw.write(content29);
                			bw.newLine();
                			bw.write(content30);
                			bw.newLine();
                			bw.close();
                			System.out.println("Done");

                        } 
                        catch (IOException e) 
                        {
                			e.printStackTrace();
                		  }
                  }
         else
         {
        	 System.out.println("Wrong Deck Number!");
        	 System.out.println("This will now close...");
        	 System.exit(0);
         }

          rs.close();
          rs2.close();
          stmt.close();
          conn.close();
          
          }
          catch(SQLException se)
          {
      //Handle errors for JDBC
      se.printStackTrace();
   }
   catch(Exception e)
   {
      //Handle errors for Class.forName
      e.printStackTrace();
   }
   finally
   {
      //finally block used to close resources
      try
      {
         if(stmt!=null)
            stmt.close();
      }
      catch(SQLException se2)
      {
      }// nothing we can do
      try
      {
         if(conn!=null)
            conn.close();
      }
      catch(SQLException se)
      {
         se.printStackTrace();
      }//end finally try
   }//end try
   
   System.out.println("Goodbye!");
  }//end main
}//end FirstExample