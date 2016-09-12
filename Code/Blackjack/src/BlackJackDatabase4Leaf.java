import java.sql.*;
import java.util.Scanner;

public class BlackJackDatabase4Leaf {

  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; //calls database
  static final String DB_URL = "jdbc:mysql://localhost:3306/bj"; //calls database

  static final String USER = "root"; //calls database User
  static final String PASS = "4leafco"; //calls database Password

  public static int sumArray(int[][] arr) {
    int total = 0;
    for (int row = 0; row < 29; row ++) {
      for (int col = 0; col < 10; col ++) {
        total += arr[row][col];
      }
    }
    return total;
  }

  public static void main(String[] args) {

    Connection conn = null;
    Statement stmt = null;

    try {

      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver"); //calls
      Scanner keyboard = new Scanner(System.in); //scanner

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS); //Calls URL, User name & Password
      System.out.println("Creating statement...");

      stmt = conn.createStatement(); //create statement
      String sql, sql2;
      ResultSet rs = null, rs2 = null;
      boolean cond = true;
      String UserCard1 = " ", UserCard2 = " ", DealerCard1 = " ", DealerCard2 = " ";
      String SearchCond3 = " ", SearchCond4 = " ", SearchCond5 = " ", SearchCond6 = " ", SearchCond7 = " ";
      String UserCardString1 = " ", UserCardString2 = " ", DealerCardString = " ", DealerCardString1 = " ", DealerCardString2 = " ", DealerCardString5 = " ";

      int U1 = 0, U2 = 0, D1 = 0, D2 = 0, totalU = 0, totalD = 0;

      //int i = 0, j = 0,
      int index, index2, LessThan8, MoreThan17;

      //int i and j
      int i = 0, j = 0;

      //where we define how many hands there are
      //has to be one million divided by 29 until bug is found = 34482.75862069
      int freq = 34483;
      int count = 0;
      String[] cards = new String[20];

      String[] tallyArrayUser = {
        "8",
        "9",
        "10",
        "11",
        "12",
        "13",
        "14",
        "15",
        "16",
        "17",
        "2,2",
        "3,3",
        "4,4",
        "5,5",
        "6,6",
        "7,7",
        "8,8",
        "9,9",
        "10,10",
        "Ace,2",
        "Ace,3",
        "Ace,4",
        "Ace,5",
        "Ace,6",
        "Ace,7",
        "Ace,8",
        "Ace,9",
        "Ace,10",
        "Ace,Ace",
        "Ace,Ace"
      };

      String[] tallyArrayDealer = {
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "10",
        "Ace"
      };

      int[][] tallyTable = new int[29][10];

      for (int l = 0; l < tallyTable.length; l++) {
        for (int k = 0; k < tallyTable[l].length; k++) {
          tallyTable[l][k] = 0;
        }
      }

      System.out.print("\nHow many decks would you like to use? ");

      int decknumber = keyboard.nextInt();

      /**
       * if deck number is equal to 1
       */

      if (decknumber == 1) {

        System.out.println("BlackJackDatabase : 1 Deck\n");

        sql = "SELECT * FROM blackjackdatabase"; //SQL Statement
        rs = stmt.executeQuery(sql); //Enter SQL statement into Result Set

        while (rs.next()) {
          int id = rs.getInt("idBlackJackDatabase"); //Grabbing the ID value
          String CardValue = rs.getString("CardValue"); //Grabbing the Card Value
          //System.out.print("ID: " + id);
          //System.out.println(", CardValue: " + CardValue);
        }

        //System.out.println("Frequency Table");
        //System.out.println("Randomized Hand Combination: ");

        for (int random = 0; random < freq; random++) { //Runs a million times to get frequency table

          count = 0;
          sql2 = "SELECT * FROM blackjackdatabase ORDER BY RAND() LIMIT 20;"; //Grabs Random 20 Cards
          rs2 = stmt.executeQuery(sql2);

          while (rs2.next()) {
            int id = rs2.getInt("idBlackJackDatabase"); //Random ID
            String CardValue = rs2.getString("CardValue"); //Random Card Value
            cards[count] = CardValue; //Stores Card Value in Array
            count++; //Inc. Count
            //System.out.print("ID: " + id);
            //System.out.println("\t CardValue: " + CardValue);
          }

          //System.out.println("\nYour cards are....");

          UserCard1 = cards[0];
/*          System.out.println("User Card 1 : " + UserCard1);
*/          DealerCard1 = cards[1];
/*          System.out.println("Dealer Card Down.... ");
*/          UserCard2 = cards[2];
/*          System.out.println("User Card 2 : " + UserCard2);
*/          DealerCard2 = cards[3];
/*          System.out.println("Dealer Card Shown: " + DealerCard2);
*/
          //System.out.println("");

          if (UserCard1.equals("Jack") || UserCard1.equals("Queen") || UserCard1.equals("King")) {
            U1 = 10;
            UserCardString1 = "10";
          } else if (UserCard1.equals("Ace")) {
            U1 = 1;
          } else {
            U1 = Integer.parseInt(UserCard1);
          }

          if (UserCard2.equals("Jack") || UserCard2.equals("Queen") || UserCard2.equals("King")) {
            U2 = 10;
            UserCardString2 = "10";
          } else if (UserCard2.equals("Ace")) {
            U2 = 1;
          } else {
            U2 = Integer.parseInt(UserCard2);
          }

          if (DealerCard1.equals("Jack") || DealerCard1.equals("Queen") || DealerCard1.equals("King")) {
            D1 = 10;
            DealerCardString1 = "10";
          } else if (DealerCard1.equals("Ace")) {
            D1 = 1;
          } else {
            D1 = Integer.parseInt(DealerCard1);
          }

          if (DealerCard2.equals("Jack") || DealerCard2.equals("Queen") || DealerCard2.equals("King")) {
            D2 = 10;
            DealerCardString2 = "10";
          } else if (DealerCard2.equals("Ace")) {
            D2 = 1;
          } else {
            D2 = Integer.parseInt(DealerCard2);
          }

          if (UserCard1.equals("Ace") && UserCard2.equals("Ace")) {
            DealerCardString5 = "Ace,Ace";
          }

          if (UserCard1.equals("Ace") && !UserCard2.equals("Ace")) {
            U1 = 11;
          }

          if (UserCard2.equals("Ace") && !UserCard1.equals("Ace")) {
            U2 = 11;
          }

          if (DealerCard1.equals("Ace") && !DealerCard2.equals("Ace")) {
            D1 = 11;
          }

          if (DealerCard2.equals("Ace") && !DealerCard1.equals("Ace")) {
            D2 = 11;
          }

          totalU = U1 + U2;
          totalD = D2;
          int totalDw2 = D1 + D2;
/*          System.out.println("\nYour Total is " + totalU);
          System.out.println("Dealer Total is " + totalD + "\n");*/

          SearchCond3 = UserCard1 + UserCard2;

          //System.out.println("Search Condition 3: " + SearchCond3);

          if (SearchCond3.equals("22") || SearchCond3.equals("33") || SearchCond3.equals("44") || SearchCond3.equals("55") || SearchCond3.equals("66") || SearchCond3.equals("77") || SearchCond3.equals("88") || SearchCond3.equals("99") || SearchCond3.equals("1010") || SearchCond3.equals("Ace2") || SearchCond3.equals("Ace3") || SearchCond3.equals("Ace4") || SearchCond3.equals("Ace4") || SearchCond3.equals("Ace5") || SearchCond3.equals("Ace6") || SearchCond3.equals("Ace7") || SearchCond3.equals("Ace8") || SearchCond3.equals("Ace9") || SearchCond3.equals("Ace10") || SearchCond3.equals("AceAce")) {
            SearchCond4 = UserCard1 + "," + UserCard2;
            //System.out.println("Search Condition 4: " + SearchCond4);
          }

          if (totalU <= 8 && !(SearchCond3.equals("22") || SearchCond3.equals("33") || SearchCond3.equals("44") || SearchCond3.equals("55") || SearchCond3.equals("66") || SearchCond3.equals("77") || SearchCond3.equals("88") || SearchCond3.equals("99") || SearchCond3.equals("1010") || SearchCond3.equals("Ace2") || SearchCond3.equals("Ace3") || SearchCond3.equals("Ace4") || SearchCond3.equals("Ace4") || SearchCond3.equals("Ace5") || SearchCond3.equals("Ace6") || SearchCond3.equals("Ace7") || SearchCond3.equals("Ace8") || SearchCond3.equals("Ace9") || SearchCond3.equals("Ace10") || SearchCond3.equals("AceAce"))) {
            LessThan8 = 8;
            SearchCond6 = String.valueOf(LessThan8);
            //System.out.println("Search Condition 6: " + SearchCond6);
          } else if (totalU == 18 || totalU == 19 || totalU == 20 && !(SearchCond3.equals("22") || SearchCond3.equals("33") || SearchCond3.equals("44") || SearchCond3.equals("55") || SearchCond3.equals("66") || SearchCond3.equals("77") || SearchCond3.equals("88") || SearchCond3.equals("99") || SearchCond3.equals("1010") || SearchCond3.equals("Ace2") || SearchCond3.equals("Ace3") || SearchCond3.equals("Ace4") || SearchCond3.equals("Ace4") || SearchCond3.equals("Ace5") || SearchCond3.equals("Ace6") || SearchCond3.equals("Ace7") || SearchCond3.equals("Ace8") || SearchCond3.equals("Ace9") || SearchCond3.equals("Ace10") || SearchCond3.equals("AceAce"))) {
            MoreThan17 = 17;
            SearchCond7 = String.valueOf(MoreThan17);
            //System.out.println("Search Condition 7: " + SearchCond7);
          } else {
            SearchCond5 = String.valueOf(totalU);
          }

          //System.out.println("Search Condition 5: " + SearchCond5);
          //System.out.println("DealerCard2 afterwards: " + DealerCard2);
          //System.out.println("DealerCardString afterwards: " + DealerCardString);*/

          for (index = 0; index < 29; index++) {
            //if index of user array is equal to the user total
            if (tallyArrayUser[index].equals(SearchCond4)) {
              //initialize i to index
              //System.out.println("The current i is "+ i);
              i = index;
              //reset index value
              // index = 0;
            } else if (tallyArrayUser[index].equals(SearchCond5)) {
              //initialize i to index
              //System.out.println("The current i is "+ i);
              i = index;
              //reset index value
              // index = 0;
            } else if (tallyArrayUser[index].equals(SearchCond6)) {
              //initialize i to index
              //System.out.println("The current i is "+ i);
              i = index;
              //reset index value
              // index = 0;
            } else if (tallyArrayUser[index].equals(SearchCond7)) {
              //initialize i to index
              //System.out.println("The current i is "+ i);
              i = index;
              //reset index value
              // index = 0;
            } else if (tallyArrayUser[index].equals(DealerCardString5)) {
              //initialize i to index
              //System.out.println("The current i is "+ i);
              i = index;
              //reset index value
              // index = 0;
            }

            //looping through dealer array
            for (index2 = 0; index2 < 10; index2++) {
              //if index of dealer array is equal to the dealer total
              if (tallyArrayDealer[index2].equals(DealerCard2) || tallyArrayDealer[index2].equals(DealerCardString)) {
                //initialize j to index
                //System.out.println("The current j is "+ j );
                j = index2;
                //reset index value
                index2 = 0;
                break;
              }

            }
            // System.out.println("TALLY BEFORE: " + tallyTable[i][j]);
            tallyTable[i][j]++;
            // System.out.println("TALLY AFTER: " + tallyTable[i][j]);
            // System.out.println("TALLY BEFORE: " + tallyTable[index][index2]);
            // tallyTable[index][index2]++;
            // System.out.println("TALLY AFTER: " + tallyTable[index][index2]);
          }
        }

        System.out.println("\n\n");
        System.out.println("\t ---------------------------------------------------------------------------");
        System.out.println("\t   2 \t 3 \t 4 \t 5 \t 6 \t 7 \t 8 \t 9 \t 10 \t A ");
        System.out.println("\t ---------------------------------------------------------------------------");

        System.out.println("        |");
        System.out.println("  8     |" + tallyTable[0][0] + "\t" + tallyTable[0][1] + "\t" + tallyTable[0][2] + "\t" + tallyTable[0][3] + "\t" + tallyTable[0][4] + "\t" + tallyTable[0][5] + "\t" + tallyTable[0][6] + "\t" + tallyTable[0][7] + "\t" + tallyTable[0][8] + "\t" + tallyTable[0][9]);
        System.out.println("  9     |" + tallyTable[1][0] + "\t" + tallyTable[1][1] + "\t" + tallyTable[1][2] + "\t" + tallyTable[1][3] + "\t" + tallyTable[1][4] + "\t" + tallyTable[1][5] + "\t" + tallyTable[1][6] + "\t" + tallyTable[1][7] + "\t" + tallyTable[1][8] + "\t" + tallyTable[1][9]);
        System.out.println("  10    |" + tallyTable[2][0] + "\t" + tallyTable[2][1] + "\t" + tallyTable[2][2] + "\t" + tallyTable[2][3] + "\t" + tallyTable[2][4] + "\t" + tallyTable[2][5] + "\t" + tallyTable[2][6] + "\t" + tallyTable[2][7] + "\t" + tallyTable[2][8] + "\t" + tallyTable[2][9]);
        System.out.println("  11    |" + tallyTable[3][0] + "\t" + tallyTable[3][1] + "\t" + tallyTable[3][2] + "\t" + tallyTable[3][3] + "\t" + tallyTable[3][4] + "\t" + tallyTable[3][5] + "\t" + tallyTable[3][6] + "\t" + tallyTable[3][7] + "\t" + tallyTable[3][8] + "\t" + tallyTable[3][9]);
        System.out.println("  12    |" + tallyTable[4][0] + "\t" + tallyTable[4][1] + "\t" + tallyTable[4][2] + "\t" + tallyTable[4][3] + "\t" + tallyTable[4][4] + "\t" + tallyTable[4][5] + "\t" + tallyTable[4][6] + "\t" + tallyTable[4][7] + "\t" + tallyTable[4][8] + "\t" + tallyTable[4][9]);
        System.out.println("  13    |" + tallyTable[5][0] + "\t" + tallyTable[5][1] + "\t" + tallyTable[5][2] + "\t" + tallyTable[5][3] + "\t" + tallyTable[5][4] + "\t" + tallyTable[5][5] + "\t" + tallyTable[5][6] + "\t" + tallyTable[5][7] + "\t" + tallyTable[5][8] + "\t" + tallyTable[5][9]);
        System.out.println("  14    |" + tallyTable[6][0] + "\t" + tallyTable[6][1] + "\t" + tallyTable[6][2] + "\t" + tallyTable[6][3] + "\t" + tallyTable[6][4] + "\t" + tallyTable[6][5] + "\t" + tallyTable[6][6] + "\t" + tallyTable[6][7] + "\t" + tallyTable[6][8] + "\t" + tallyTable[6][9]);
        System.out.println("  15    |" + tallyTable[7][0] + "\t" + tallyTable[7][1] + "\t" + tallyTable[7][2] + "\t" + tallyTable[7][3] + "\t" + tallyTable[7][4] + "\t" + tallyTable[7][5] + "\t" + tallyTable[7][6] + "\t" + tallyTable[7][7] + "\t" + tallyTable[7][8] + "\t" + tallyTable[7][9]);
        System.out.println("  16    |" + tallyTable[8][0] + "\t" + tallyTable[8][1] + "\t" + tallyTable[8][2] + "\t" + tallyTable[8][3] + "\t" + tallyTable[8][4] + "\t" + tallyTable[8][5] + "\t" + tallyTable[8][6] + "\t" + tallyTable[8][7] + "\t" + tallyTable[8][8] + "\t" + tallyTable[8][9]);
        System.out.println("  17    |" + tallyTable[9][0] + "\t" + tallyTable[9][1] + "\t" + tallyTable[9][2] + "\t" + tallyTable[9][3] + "\t" + tallyTable[9][4] + "\t" + tallyTable[9][5] + "\t" + tallyTable[9][6] + "\t" + tallyTable[9][7] + "\t" + tallyTable[9][8] + "\t" + tallyTable[9][9]);
        System.out.println("  2,2   |" + tallyTable[10][0] + "\t" + tallyTable[10][1] + "\t" + tallyTable[10][2] + "\t" + tallyTable[10][3] + "\t" + tallyTable[10][4] + "\t" + tallyTable[10][5] + "\t" + tallyTable[10][6] + "\t" + tallyTable[10][7] + "\t" + tallyTable[10][8] + "\t" + tallyTable[10][9]);
        System.out.println("  3,3   |" + tallyTable[11][0] + "\t" + tallyTable[11][1] + "\t" + tallyTable[11][2] + "\t" + tallyTable[11][3] + "\t" + tallyTable[11][4] + "\t" + tallyTable[11][5] + "\t" + tallyTable[11][6] + "\t" + tallyTable[11][7] + "\t" + tallyTable[11][8] + "\t" + tallyTable[11][9]);
        System.out.println("  4,4   |" + tallyTable[12][0] + "\t" + tallyTable[12][1] + "\t" + tallyTable[12][2] + "\t" + tallyTable[12][3] + "\t" + tallyTable[12][4] + "\t" + tallyTable[12][5] + "\t" + tallyTable[12][6] + "\t" + tallyTable[12][7] + "\t" + tallyTable[12][8] + "\t" + tallyTable[12][9]);
        System.out.println("  5,5   |" + tallyTable[13][0] + "\t" + tallyTable[13][1] + "\t" + tallyTable[13][2] + "\t" + tallyTable[13][3] + "\t" + tallyTable[13][4] + "\t" + tallyTable[13][5] + "\t" + tallyTable[13][6] + "\t" + tallyTable[13][7] + "\t" + tallyTable[13][8] + "\t" + tallyTable[13][9]);
        System.out.println("  6,6   |" + tallyTable[14][0] + "\t" + tallyTable[14][1] + "\t" + tallyTable[14][2] + "\t" + tallyTable[14][3] + "\t" + tallyTable[14][4] + "\t" + tallyTable[14][5] + "\t" + tallyTable[14][6] + "\t" + tallyTable[14][7] + "\t" + tallyTable[14][8] + "\t" + tallyTable[14][9]);
        System.out.println("  7,7   |" + tallyTable[15][0] + "\t" + tallyTable[15][1] + "\t" + tallyTable[15][2] + "\t" + tallyTable[15][3] + "\t" + tallyTable[15][4] + "\t" + tallyTable[15][5] + "\t" + tallyTable[15][6] + "\t" + tallyTable[15][7] + "\t" + tallyTable[15][8] + "\t" + tallyTable[15][9]);
        System.out.println("  8,8   |" + tallyTable[16][0] + "\t" + tallyTable[16][1] + "\t" + tallyTable[16][2] + "\t" + tallyTable[16][3] + "\t" + tallyTable[16][4] + "\t" + tallyTable[16][5] + "\t" + tallyTable[16][6] + "\t" + tallyTable[16][7] + "\t" + tallyTable[16][8] + "\t" + tallyTable[16][9]);
        System.out.println("  9,9   |" + tallyTable[17][0] + "\t" + tallyTable[17][1] + "\t" + tallyTable[17][2] + "\t" + tallyTable[17][3] + "\t" + tallyTable[17][4] + "\t" + tallyTable[17][5] + "\t" + tallyTable[17][6] + "\t" + tallyTable[17][7] + "\t" + tallyTable[17][8] + "\t" + tallyTable[17][9]);
        System.out.println("  10,10 |" + tallyTable[18][0] + "\t" + tallyTable[18][1] + "\t" + tallyTable[18][2] + "\t" + tallyTable[18][3] + "\t" + tallyTable[18][4] + "\t" + tallyTable[18][5] + "\t" + tallyTable[18][6] + "\t" + tallyTable[18][7] + "\t" + tallyTable[18][8] + "\t" + tallyTable[18][9]);
        System.out.println("  A,2   |" + tallyTable[19][0] + "\t" + tallyTable[19][1] + "\t" + tallyTable[19][2] + "\t" + tallyTable[19][3] + "\t" + tallyTable[19][4] + "\t" + tallyTable[19][5] + "\t" + tallyTable[19][6] + "\t" + tallyTable[19][7] + "\t" + tallyTable[19][8] + "\t" + tallyTable[19][9]);
        System.out.println("  A,3   |" + tallyTable[20][0] + "\t" + tallyTable[20][1] + "\t" + tallyTable[20][2] + "\t" + tallyTable[20][3] + "\t" + tallyTable[20][4] + "\t" + tallyTable[20][5] + "\t" + tallyTable[20][6] + "\t" + tallyTable[20][7] + "\t" + tallyTable[20][8] + "\t" + tallyTable[20][9]);
        System.out.println("  A,4   |" + tallyTable[21][0] + "\t" + tallyTable[21][1] + "\t" + tallyTable[21][2] + "\t" + tallyTable[21][3] + "\t" + tallyTable[21][4] + "\t" + tallyTable[21][5] + "\t" + tallyTable[21][6] + "\t" + tallyTable[21][7] + "\t" + tallyTable[21][8] + "\t" + tallyTable[21][9]);
        System.out.println("  A,5   |" + tallyTable[22][0] + "\t" + tallyTable[22][1] + "\t" + tallyTable[22][2] + "\t" + tallyTable[22][3] + "\t" + tallyTable[22][4] + "\t" + tallyTable[22][5] + "\t" + tallyTable[22][6] + "\t" + tallyTable[22][7] + "\t" + tallyTable[22][8] + "\t" + tallyTable[22][9]);
        System.out.println("  A,6   |" + tallyTable[23][0] + "\t" + tallyTable[23][1] + "\t" + tallyTable[23][2] + "\t" + tallyTable[23][3] + "\t" + tallyTable[23][4] + "\t" + tallyTable[23][5] + "\t" + tallyTable[23][6] + "\t" + tallyTable[23][7] + "\t" + tallyTable[23][8] + "\t" + tallyTable[23][9]);
        System.out.println("  A,7   |" + tallyTable[24][0] + "\t" + tallyTable[24][1] + "\t" + tallyTable[24][2] + "\t" + tallyTable[24][3] + "\t" + tallyTable[24][4] + "\t" + tallyTable[24][5] + "\t" + tallyTable[24][6] + "\t" + tallyTable[24][7] + "\t" + tallyTable[24][8] + "\t" + tallyTable[24][9]);
        System.out.println("  A,8   |" + tallyTable[25][0] + "\t" + tallyTable[25][1] + "\t" + tallyTable[25][2] + "\t" + tallyTable[25][3] + "\t" + tallyTable[25][4] + "\t" + tallyTable[25][5] + "\t" + tallyTable[25][6] + "\t" + tallyTable[25][7] + "\t" + tallyTable[25][8] + "\t" + tallyTable[25][9]);
        System.out.println("  A,9   |" + tallyTable[26][0] + "\t" + tallyTable[26][1] + "\t" + tallyTable[26][2] + "\t" + tallyTable[26][3] + "\t" + tallyTable[26][4] + "\t" + tallyTable[26][5] + "\t" + tallyTable[26][6] + "\t" + tallyTable[26][7] + "\t" + tallyTable[26][8] + "\t" + tallyTable[26][9]);
        System.out.println("  A,10  |" + tallyTable[27][0] + "\t" + tallyTable[27][1] + "\t" + tallyTable[27][2] + "\t" + tallyTable[27][3] + "\t" + tallyTable[27][4] + "\t" + tallyTable[27][5] + "\t" + tallyTable[27][6] + "\t" + tallyTable[27][7] + "\t" + tallyTable[27][8] + "\t" + tallyTable[27][9]);
        System.out.println("  A,A   |" + tallyTable[28][0] + "\t" + tallyTable[28][1] + "\t" + tallyTable[28][2] + "\t" + tallyTable[28][3] + "\t" + tallyTable[28][4] + "\t" + tallyTable[28][5] + "\t" + tallyTable[28][6] + "\t" + tallyTable[28][7] + "\t" + tallyTable[28][8] + "\t" + tallyTable[28][9]);

        //End Delimiter
        System.out.println("\n\n");

      }

      else if (decknumber == 2) { /////////////////////////////////////////////////////////////////////////////////////////
        sql = "SELECT * FROM blackjackdatabase2";
        rs = stmt.executeQuery(sql);

        while (rs.next()) {
          int id  = rs.getInt("idBlackJackDatabase");
          String CardValue = rs.getString("CardValue");

          System.out.print("ID: " + id);
          System.out.println(", CardValue: " + CardValue);
        }

        System.out.println("");
        System.out.println("Frequency Table");
        //System.out.println("Randomized Set of 20 Integers: ");
        System.out.println("");

        for (int Rnd = 0; Rnd < freq; Rnd++) {

          count = 0;

          sql2 = "SELECT * FROM blackjackdatabase2 ORDER BY RAND() LIMIT 20;";
          rs2 = stmt.executeQuery(sql2);

          while (rs2.next()) {

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
          /*          System.out.println("User Card 1 : " + UserCard1);
          */          DealerCard1 = cards[1];
          /*          System.out.println("Dealer Card Down.... ");
          */          UserCard2 = cards[2];
          /*          System.out.println("User Card 2 : " + UserCard2);
          */          DealerCard2 = cards[3];
          /*          System.out.println("Dealer Card Shown: " + DealerCard2);
          */
                    //System.out.println("");

                    if (UserCard1.equals("Jack") || UserCard1.equals("Queen") || UserCard1.equals("King")) {
                      U1 = 10;
                      UserCardString1 = "10";
                    } else if (UserCard1.equals("Ace")) {
                      U1 = 1;
                    } else {
                      U1 = Integer.parseInt(UserCard1);
                    }

                    if (UserCard2.equals("Jack") || UserCard2.equals("Queen") || UserCard2.equals("King")) {
                      U2 = 10;
                      UserCardString2 = "10";
                    } else if (UserCard2.equals("Ace")) {
                      U2 = 1;
                    } else {
                      U2 = Integer.parseInt(UserCard2);
                    }

                    if (DealerCard1.equals("Jack") || DealerCard1.equals("Queen") || DealerCard1.equals("King")) {
                      D1 = 10;
                      DealerCardString1 = "10";
                    } else if (DealerCard1.equals("Ace")) {
                      D1 = 1;
                    } else {
                      D1 = Integer.parseInt(DealerCard1);
                    }

                    if (DealerCard2.equals("Jack") || DealerCard2.equals("Queen") || DealerCard2.equals("King")) {
                      D2 = 10;
                      DealerCardString2 = "10";
                    } else if (DealerCard2.equals("Ace")) {
                      D2 = 1;
                    } else {
                      D2 = Integer.parseInt(DealerCard2);
                    }

                    if (UserCard1.equals("Ace") && UserCard2.equals("Ace")) {
                      DealerCardString5 = "Ace,Ace";
                    }

                    if (UserCard1.equals("Ace") && !UserCard2.equals("Ace")) {
                      U1 = 11;
                    }

                    if (UserCard2.equals("Ace") && !UserCard1.equals("Ace")) {
                      U2 = 11;
                    }

                    if (DealerCard1.equals("Ace") && !DealerCard2.equals("Ace")) {
                      D1 = 11;
                    }

                    if (DealerCard2.equals("Ace") && !DealerCard1.equals("Ace")) {
                      D2 = 11;
                    }

                    totalU = U1 + U2;
                    totalD = D2;
                    int totalDw2 = D1 + D2;
          /*          System.out.println("\nYour Total is " + totalU);
                    System.out.println("Dealer Total is " + totalD + "\n");*/

                    SearchCond3 = UserCard1 + UserCard2;

                    //System.out.println("Search Condition 3: " + SearchCond3);

                    if (SearchCond3.equals("22") || SearchCond3.equals("33") || SearchCond3.equals("44") || SearchCond3.equals("55") || SearchCond3.equals("66") || SearchCond3.equals("77") || SearchCond3.equals("88") || SearchCond3.equals("99") || SearchCond3.equals("1010") || SearchCond3.equals("Ace2") || SearchCond3.equals("Ace3") || SearchCond3.equals("Ace4") || SearchCond3.equals("Ace4") || SearchCond3.equals("Ace5") || SearchCond3.equals("Ace6") || SearchCond3.equals("Ace7") || SearchCond3.equals("Ace8") || SearchCond3.equals("Ace9") || SearchCond3.equals("Ace10") || SearchCond3.equals("AceAce")) {
                      SearchCond4 = UserCard1 + "," + UserCard2;
                      //System.out.println("Search Condition 4: " + SearchCond4);
                    }

                    if (totalU <= 8 && !(SearchCond3.equals("22") || SearchCond3.equals("33") || SearchCond3.equals("44") || SearchCond3.equals("55") || SearchCond3.equals("66") || SearchCond3.equals("77") || SearchCond3.equals("88") || SearchCond3.equals("99") || SearchCond3.equals("1010") || SearchCond3.equals("Ace2") || SearchCond3.equals("Ace3") || SearchCond3.equals("Ace4") || SearchCond3.equals("Ace4") || SearchCond3.equals("Ace5") || SearchCond3.equals("Ace6") || SearchCond3.equals("Ace7") || SearchCond3.equals("Ace8") || SearchCond3.equals("Ace9") || SearchCond3.equals("Ace10") || SearchCond3.equals("AceAce"))) {
                      LessThan8 = 8;
                      SearchCond6 = String.valueOf(LessThan8);
                      //System.out.println("Search Condition 6: " + SearchCond6);
                    } else if (totalU == 18 || totalU == 19 || totalU == 20 && !(SearchCond3.equals("22") || SearchCond3.equals("33") || SearchCond3.equals("44") || SearchCond3.equals("55") || SearchCond3.equals("66") || SearchCond3.equals("77") || SearchCond3.equals("88") || SearchCond3.equals("99") || SearchCond3.equals("1010") || SearchCond3.equals("Ace2") || SearchCond3.equals("Ace3") || SearchCond3.equals("Ace4") || SearchCond3.equals("Ace4") || SearchCond3.equals("Ace5") || SearchCond3.equals("Ace6") || SearchCond3.equals("Ace7") || SearchCond3.equals("Ace8") || SearchCond3.equals("Ace9") || SearchCond3.equals("Ace10") || SearchCond3.equals("AceAce"))) {
                      MoreThan17 = 17;
                      SearchCond7 = String.valueOf(MoreThan17);
                      //System.out.println("Search Condition 7: " + SearchCond7);
                    } else {
                      SearchCond5 = String.valueOf(totalU);
                    }

                    //System.out.println("Search Condition 5: " + SearchCond5);
                    //System.out.println("DealerCard2 afterwards: " + DealerCard2);
                    //System.out.println("DealerCardString afterwards: " + DealerCardString);*/

                    for (index = 0; index < 29; index++) {
                      //if index of user array is equal to the user total
                      if (tallyArrayUser[index].equals(SearchCond4)) {
                        //initialize i to index
                        //System.out.println("The current i is "+ i);
                        i = index;
                        //reset index value
                        // index = 0;
                      } else if (tallyArrayUser[index].equals(SearchCond5)) {
                        //initialize i to index
                        //System.out.println("The current i is "+ i);
                        i = index;
                        //reset index value
                        // index = 0;
                      } else if (tallyArrayUser[index].equals(SearchCond6)) {
                        //initialize i to index
                        //System.out.println("The current i is "+ i);
                        i = index;
                        //reset index value
                        // index = 0;
                      } else if (tallyArrayUser[index].equals(SearchCond7)) {
                        //initialize i to index
                        //System.out.println("The current i is "+ i);
                        i = index;
                        //reset index value
                        // index = 0;
                      } else if (tallyArrayUser[index].equals(DealerCardString5)) {
                        //initialize i to index
                        //System.out.println("The current i is "+ i);
                        i = index;
                        //reset index value
                        // index = 0;
                      }

                      //looping through dealer array
                      for (index2 = 0; index2 < 10; index2++) {
                        //if index of dealer array is equal to the dealer total
                        if (tallyArrayDealer[index2].equals(DealerCard2) || tallyArrayDealer[index2].equals(DealerCardString)) {
                          //initialize j to index
                          //System.out.println("The current j is "+ j );
                          j = index2;
                          //reset index value
                          index2 = 0;
                          break;
                        }

                      }
                      // System.out.println("TALLY BEFORE: " + tallyTable[i][j]);
                      tallyTable[i][j]++;
                      // System.out.println("TALLY AFTER: " + tallyTable[i][j]);
                      // System.out.println("TALLY BEFORE: " + tallyTable[index][index2]);
                      // tallyTable[index][index2]++;
                      // System.out.println("TALLY AFTER: " + tallyTable[index][index2]);
                    }
                  }

                  System.out.println("\n\n");
                  System.out.println("\t ---------------------------------------------------------------------------");
                  System.out.println("\t   2 \t 3 \t 4 \t 5 \t 6 \t 7 \t 8 \t 9 \t 10 \t A ");
                  System.out.println("\t ---------------------------------------------------------------------------");

                  System.out.println("        |");
                  System.out.println("  8     |" + tallyTable[0][0] + "\t" + tallyTable[0][1] + "\t" + tallyTable[0][2] + "\t" + tallyTable[0][3] + "\t" + tallyTable[0][4] + "\t" + tallyTable[0][5] + "\t" + tallyTable[0][6] + "\t" + tallyTable[0][7] + "\t" + tallyTable[0][8] + "\t" + tallyTable[0][9]);
                  System.out.println("  9     |" + tallyTable[1][0] + "\t" + tallyTable[1][1] + "\t" + tallyTable[1][2] + "\t" + tallyTable[1][3] + "\t" + tallyTable[1][4] + "\t" + tallyTable[1][5] + "\t" + tallyTable[1][6] + "\t" + tallyTable[1][7] + "\t" + tallyTable[1][8] + "\t" + tallyTable[1][9]);
                  System.out.println("  10    |" + tallyTable[2][0] + "\t" + tallyTable[2][1] + "\t" + tallyTable[2][2] + "\t" + tallyTable[2][3] + "\t" + tallyTable[2][4] + "\t" + tallyTable[2][5] + "\t" + tallyTable[2][6] + "\t" + tallyTable[2][7] + "\t" + tallyTable[2][8] + "\t" + tallyTable[2][9]);
                  System.out.println("  11    |" + tallyTable[3][0] + "\t" + tallyTable[3][1] + "\t" + tallyTable[3][2] + "\t" + tallyTable[3][3] + "\t" + tallyTable[3][4] + "\t" + tallyTable[3][5] + "\t" + tallyTable[3][6] + "\t" + tallyTable[3][7] + "\t" + tallyTable[3][8] + "\t" + tallyTable[3][9]);
                  System.out.println("  12    |" + tallyTable[4][0] + "\t" + tallyTable[4][1] + "\t" + tallyTable[4][2] + "\t" + tallyTable[4][3] + "\t" + tallyTable[4][4] + "\t" + tallyTable[4][5] + "\t" + tallyTable[4][6] + "\t" + tallyTable[4][7] + "\t" + tallyTable[4][8] + "\t" + tallyTable[4][9]);
                  System.out.println("  13    |" + tallyTable[5][0] + "\t" + tallyTable[5][1] + "\t" + tallyTable[5][2] + "\t" + tallyTable[5][3] + "\t" + tallyTable[5][4] + "\t" + tallyTable[5][5] + "\t" + tallyTable[5][6] + "\t" + tallyTable[5][7] + "\t" + tallyTable[5][8] + "\t" + tallyTable[5][9]);
                  System.out.println("  14    |" + tallyTable[6][0] + "\t" + tallyTable[6][1] + "\t" + tallyTable[6][2] + "\t" + tallyTable[6][3] + "\t" + tallyTable[6][4] + "\t" + tallyTable[6][5] + "\t" + tallyTable[6][6] + "\t" + tallyTable[6][7] + "\t" + tallyTable[6][8] + "\t" + tallyTable[6][9]);
                  System.out.println("  15    |" + tallyTable[7][0] + "\t" + tallyTable[7][1] + "\t" + tallyTable[7][2] + "\t" + tallyTable[7][3] + "\t" + tallyTable[7][4] + "\t" + tallyTable[7][5] + "\t" + tallyTable[7][6] + "\t" + tallyTable[7][7] + "\t" + tallyTable[7][8] + "\t" + tallyTable[7][9]);
                  System.out.println("  16    |" + tallyTable[8][0] + "\t" + tallyTable[8][1] + "\t" + tallyTable[8][2] + "\t" + tallyTable[8][3] + "\t" + tallyTable[8][4] + "\t" + tallyTable[8][5] + "\t" + tallyTable[8][6] + "\t" + tallyTable[8][7] + "\t" + tallyTable[8][8] + "\t" + tallyTable[8][9]);
                  System.out.println("  17    |" + tallyTable[9][0] + "\t" + tallyTable[9][1] + "\t" + tallyTable[9][2] + "\t" + tallyTable[9][3] + "\t" + tallyTable[9][4] + "\t" + tallyTable[9][5] + "\t" + tallyTable[9][6] + "\t" + tallyTable[9][7] + "\t" + tallyTable[9][8] + "\t" + tallyTable[9][9]);
                  System.out.println("  2,2   |" + tallyTable[10][0] + "\t" + tallyTable[10][1] + "\t" + tallyTable[10][2] + "\t" + tallyTable[10][3] + "\t" + tallyTable[10][4] + "\t" + tallyTable[10][5] + "\t" + tallyTable[10][6] + "\t" + tallyTable[10][7] + "\t" + tallyTable[10][8] + "\t" + tallyTable[10][9]);
                  System.out.println("  3,3   |" + tallyTable[11][0] + "\t" + tallyTable[11][1] + "\t" + tallyTable[11][2] + "\t" + tallyTable[11][3] + "\t" + tallyTable[11][4] + "\t" + tallyTable[11][5] + "\t" + tallyTable[11][6] + "\t" + tallyTable[11][7] + "\t" + tallyTable[11][8] + "\t" + tallyTable[11][9]);
                  System.out.println("  4,4   |" + tallyTable[12][0] + "\t" + tallyTable[12][1] + "\t" + tallyTable[12][2] + "\t" + tallyTable[12][3] + "\t" + tallyTable[12][4] + "\t" + tallyTable[12][5] + "\t" + tallyTable[12][6] + "\t" + tallyTable[12][7] + "\t" + tallyTable[12][8] + "\t" + tallyTable[12][9]);
                  System.out.println("  5,5   |" + tallyTable[13][0] + "\t" + tallyTable[13][1] + "\t" + tallyTable[13][2] + "\t" + tallyTable[13][3] + "\t" + tallyTable[13][4] + "\t" + tallyTable[13][5] + "\t" + tallyTable[13][6] + "\t" + tallyTable[13][7] + "\t" + tallyTable[13][8] + "\t" + tallyTable[13][9]);
                  System.out.println("  6,6   |" + tallyTable[14][0] + "\t" + tallyTable[14][1] + "\t" + tallyTable[14][2] + "\t" + tallyTable[14][3] + "\t" + tallyTable[14][4] + "\t" + tallyTable[14][5] + "\t" + tallyTable[14][6] + "\t" + tallyTable[14][7] + "\t" + tallyTable[14][8] + "\t" + tallyTable[14][9]);
                  System.out.println("  7,7   |" + tallyTable[15][0] + "\t" + tallyTable[15][1] + "\t" + tallyTable[15][2] + "\t" + tallyTable[15][3] + "\t" + tallyTable[15][4] + "\t" + tallyTable[15][5] + "\t" + tallyTable[15][6] + "\t" + tallyTable[15][7] + "\t" + tallyTable[15][8] + "\t" + tallyTable[15][9]);
                  System.out.println("  8,8   |" + tallyTable[16][0] + "\t" + tallyTable[16][1] + "\t" + tallyTable[16][2] + "\t" + tallyTable[16][3] + "\t" + tallyTable[16][4] + "\t" + tallyTable[16][5] + "\t" + tallyTable[16][6] + "\t" + tallyTable[16][7] + "\t" + tallyTable[16][8] + "\t" + tallyTable[16][9]);
                  System.out.println("  9,9   |" + tallyTable[17][0] + "\t" + tallyTable[17][1] + "\t" + tallyTable[17][2] + "\t" + tallyTable[17][3] + "\t" + tallyTable[17][4] + "\t" + tallyTable[17][5] + "\t" + tallyTable[17][6] + "\t" + tallyTable[17][7] + "\t" + tallyTable[17][8] + "\t" + tallyTable[17][9]);
                  System.out.println("  10,10 |" + tallyTable[18][0] + "\t" + tallyTable[18][1] + "\t" + tallyTable[18][2] + "\t" + tallyTable[18][3] + "\t" + tallyTable[18][4] + "\t" + tallyTable[18][5] + "\t" + tallyTable[18][6] + "\t" + tallyTable[18][7] + "\t" + tallyTable[18][8] + "\t" + tallyTable[18][9]);
                  System.out.println("  A,2   |" + tallyTable[19][0] + "\t" + tallyTable[19][1] + "\t" + tallyTable[19][2] + "\t" + tallyTable[19][3] + "\t" + tallyTable[19][4] + "\t" + tallyTable[19][5] + "\t" + tallyTable[19][6] + "\t" + tallyTable[19][7] + "\t" + tallyTable[19][8] + "\t" + tallyTable[19][9]);
                  System.out.println("  A,3   |" + tallyTable[20][0] + "\t" + tallyTable[20][1] + "\t" + tallyTable[20][2] + "\t" + tallyTable[20][3] + "\t" + tallyTable[20][4] + "\t" + tallyTable[20][5] + "\t" + tallyTable[20][6] + "\t" + tallyTable[20][7] + "\t" + tallyTable[20][8] + "\t" + tallyTable[20][9]);
                  System.out.println("  A,4   |" + tallyTable[21][0] + "\t" + tallyTable[21][1] + "\t" + tallyTable[21][2] + "\t" + tallyTable[21][3] + "\t" + tallyTable[21][4] + "\t" + tallyTable[21][5] + "\t" + tallyTable[21][6] + "\t" + tallyTable[21][7] + "\t" + tallyTable[21][8] + "\t" + tallyTable[21][9]);
                  System.out.println("  A,5   |" + tallyTable[22][0] + "\t" + tallyTable[22][1] + "\t" + tallyTable[22][2] + "\t" + tallyTable[22][3] + "\t" + tallyTable[22][4] + "\t" + tallyTable[22][5] + "\t" + tallyTable[22][6] + "\t" + tallyTable[22][7] + "\t" + tallyTable[22][8] + "\t" + tallyTable[22][9]);
                  System.out.println("  A,6   |" + tallyTable[23][0] + "\t" + tallyTable[23][1] + "\t" + tallyTable[23][2] + "\t" + tallyTable[23][3] + "\t" + tallyTable[23][4] + "\t" + tallyTable[23][5] + "\t" + tallyTable[23][6] + "\t" + tallyTable[23][7] + "\t" + tallyTable[23][8] + "\t" + tallyTable[23][9]);
                  System.out.println("  A,7   |" + tallyTable[24][0] + "\t" + tallyTable[24][1] + "\t" + tallyTable[24][2] + "\t" + tallyTable[24][3] + "\t" + tallyTable[24][4] + "\t" + tallyTable[24][5] + "\t" + tallyTable[24][6] + "\t" + tallyTable[24][7] + "\t" + tallyTable[24][8] + "\t" + tallyTable[24][9]);
                  System.out.println("  A,8   |" + tallyTable[25][0] + "\t" + tallyTable[25][1] + "\t" + tallyTable[25][2] + "\t" + tallyTable[25][3] + "\t" + tallyTable[25][4] + "\t" + tallyTable[25][5] + "\t" + tallyTable[25][6] + "\t" + tallyTable[25][7] + "\t" + tallyTable[25][8] + "\t" + tallyTable[25][9]);
                  System.out.println("  A,9   |" + tallyTable[26][0] + "\t" + tallyTable[26][1] + "\t" + tallyTable[26][2] + "\t" + tallyTable[26][3] + "\t" + tallyTable[26][4] + "\t" + tallyTable[26][5] + "\t" + tallyTable[26][6] + "\t" + tallyTable[26][7] + "\t" + tallyTable[26][8] + "\t" + tallyTable[26][9]);
                  System.out.println("  A,10  |" + tallyTable[27][0] + "\t" + tallyTable[27][1] + "\t" + tallyTable[27][2] + "\t" + tallyTable[27][3] + "\t" + tallyTable[27][4] + "\t" + tallyTable[27][5] + "\t" + tallyTable[27][6] + "\t" + tallyTable[27][7] + "\t" + tallyTable[27][8] + "\t" + tallyTable[27][9]);
                  System.out.println("  A,A   |" + tallyTable[28][0] + "\t" + tallyTable[28][1] + "\t" + tallyTable[28][2] + "\t" + tallyTable[28][3] + "\t" + tallyTable[28][4] + "\t" + tallyTable[28][5] + "\t" + tallyTable[28][6] + "\t" + tallyTable[28][7] + "\t" + tallyTable[28][8] + "\t" + tallyTable[28][9]);

                  //End Delimiter
                  System.out.println("\n\n");


      } else if (decknumber == 4) { //////////////////////////////////////////////////////////////////////////////////////
        sql = "SELECT * FROM blackjackdatabase4";
        rs = stmt.executeQuery(sql);

        while (rs.next()) {
          int id  = rs.getInt("idBlackJackDatabase");
          String CardValue = rs.getString("CardValue");

          System.out.print("ID: " + id);
          System.out.println(", CardValue: " + CardValue);
        }

        System.out.println("");
        System.out.println("Frequency Table");
        //System.out.println("Randomized Set of 20 Integers: ");
        System.out.println("");

        for (int Rnd = 0; Rnd < freq; Rnd++) {

          count = 0;

          sql2 = "SELECT * FROM blackjackdatabase4 ORDER BY RAND() LIMIT 20;";
          rs2 = stmt.executeQuery(sql2);

          while (rs2.next()) {

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
          /*          System.out.println("User Card 1 : " + UserCard1);
          */          DealerCard1 = cards[1];
          /*          System.out.println("Dealer Card Down.... ");
          */          UserCard2 = cards[2];
          /*          System.out.println("User Card 2 : " + UserCard2);
          */          DealerCard2 = cards[3];
          /*          System.out.println("Dealer Card Shown: " + DealerCard2);
          */
                    //System.out.println("");

                    if (UserCard1.equals("Jack") || UserCard1.equals("Queen") || UserCard1.equals("King")) {
                      U1 = 10;
                      UserCardString1 = "10";
                    } else if (UserCard1.equals("Ace")) {
                      U1 = 1;
                    } else {
                      U1 = Integer.parseInt(UserCard1);
                    }

                    if (UserCard2.equals("Jack") || UserCard2.equals("Queen") || UserCard2.equals("King")) {
                      U2 = 10;
                      UserCardString2 = "10";
                    } else if (UserCard2.equals("Ace")) {
                      U2 = 1;
                    } else {
                      U2 = Integer.parseInt(UserCard2);
                    }

                    if (DealerCard1.equals("Jack") || DealerCard1.equals("Queen") || DealerCard1.equals("King")) {
                      D1 = 10;
                      DealerCardString1 = "10";
                    } else if (DealerCard1.equals("Ace")) {
                      D1 = 1;
                    } else {
                      D1 = Integer.parseInt(DealerCard1);
                    }

                    if (DealerCard2.equals("Jack") || DealerCard2.equals("Queen") || DealerCard2.equals("King")) {
                      D2 = 10;
                      DealerCardString2 = "10";
                    } else if (DealerCard2.equals("Ace")) {
                      D2 = 1;
                    } else {
                      D2 = Integer.parseInt(DealerCard2);
                    }

                    if (UserCard1.equals("Ace") && UserCard2.equals("Ace")) {
                      DealerCardString5 = "Ace,Ace";
                    }

                    if (UserCard1.equals("Ace") && !UserCard2.equals("Ace")) {
                      U1 = 11;
                    }

                    if (UserCard2.equals("Ace") && !UserCard1.equals("Ace")) {
                      U2 = 11;
                    }

                    if (DealerCard1.equals("Ace") && !DealerCard2.equals("Ace")) {
                      D1 = 11;
                    }

                    if (DealerCard2.equals("Ace") && !DealerCard1.equals("Ace")) {
                      D2 = 11;
                    }

                    totalU = U1 + U2;
                    totalD = D2;
                    int totalDw2 = D1 + D2;
          /*          System.out.println("\nYour Total is " + totalU);
                    System.out.println("Dealer Total is " + totalD + "\n");*/

                    SearchCond3 = UserCard1 + UserCard2;

                    //System.out.println("Search Condition 3: " + SearchCond3);

                    if (SearchCond3.equals("22") || SearchCond3.equals("33") || SearchCond3.equals("44") || SearchCond3.equals("55") || SearchCond3.equals("66") || SearchCond3.equals("77") || SearchCond3.equals("88") || SearchCond3.equals("99") || SearchCond3.equals("1010") || SearchCond3.equals("Ace2") || SearchCond3.equals("Ace3") || SearchCond3.equals("Ace4") || SearchCond3.equals("Ace4") || SearchCond3.equals("Ace5") || SearchCond3.equals("Ace6") || SearchCond3.equals("Ace7") || SearchCond3.equals("Ace8") || SearchCond3.equals("Ace9") || SearchCond3.equals("Ace10") || SearchCond3.equals("AceAce")) {
                      SearchCond4 = UserCard1 + "," + UserCard2;
                      //System.out.println("Search Condition 4: " + SearchCond4);
                    }

                    if (totalU <= 8 && !(SearchCond3.equals("22") || SearchCond3.equals("33") || SearchCond3.equals("44") || SearchCond3.equals("55") || SearchCond3.equals("66") || SearchCond3.equals("77") || SearchCond3.equals("88") || SearchCond3.equals("99") || SearchCond3.equals("1010") || SearchCond3.equals("Ace2") || SearchCond3.equals("Ace3") || SearchCond3.equals("Ace4") || SearchCond3.equals("Ace4") || SearchCond3.equals("Ace5") || SearchCond3.equals("Ace6") || SearchCond3.equals("Ace7") || SearchCond3.equals("Ace8") || SearchCond3.equals("Ace9") || SearchCond3.equals("Ace10") || SearchCond3.equals("AceAce"))) {
                      LessThan8 = 8;
                      SearchCond6 = String.valueOf(LessThan8);
                      //System.out.println("Search Condition 6: " + SearchCond6);
                    } else if (totalU == 18 || totalU == 19 || totalU == 20 && !(SearchCond3.equals("22") || SearchCond3.equals("33") || SearchCond3.equals("44") || SearchCond3.equals("55") || SearchCond3.equals("66") || SearchCond3.equals("77") || SearchCond3.equals("88") || SearchCond3.equals("99") || SearchCond3.equals("1010") || SearchCond3.equals("Ace2") || SearchCond3.equals("Ace3") || SearchCond3.equals("Ace4") || SearchCond3.equals("Ace4") || SearchCond3.equals("Ace5") || SearchCond3.equals("Ace6") || SearchCond3.equals("Ace7") || SearchCond3.equals("Ace8") || SearchCond3.equals("Ace9") || SearchCond3.equals("Ace10") || SearchCond3.equals("AceAce"))) {
                      MoreThan17 = 17;
                      SearchCond7 = String.valueOf(MoreThan17);
                      //System.out.println("Search Condition 7: " + SearchCond7);
                    } else {
                      SearchCond5 = String.valueOf(totalU);
                    }

                    //System.out.println("Search Condition 5: " + SearchCond5);
                    //System.out.println("DealerCard2 afterwards: " + DealerCard2);
                    //System.out.println("DealerCardString afterwards: " + DealerCardString);*/

                    for (index = 0; index < 29; index++) {
                      //if index of user array is equal to the user total
                      if (tallyArrayUser[index].equals(SearchCond4)) {
                        //initialize i to index
                        //System.out.println("The current i is "+ i);
                        i = index;
                        //reset index value
                        // index = 0;
                      } else if (tallyArrayUser[index].equals(SearchCond5)) {
                        //initialize i to index
                        //System.out.println("The current i is "+ i);
                        i = index;
                        //reset index value
                        // index = 0;
                      } else if (tallyArrayUser[index].equals(SearchCond6)) {
                        //initialize i to index
                        //System.out.println("The current i is "+ i);
                        i = index;
                        //reset index value
                        // index = 0;
                      } else if (tallyArrayUser[index].equals(SearchCond7)) {
                        //initialize i to index
                        //System.out.println("The current i is "+ i);
                        i = index;
                        //reset index value
                        // index = 0;
                      } else if (tallyArrayUser[index].equals(DealerCardString5)) {
                        //initialize i to index
                        //System.out.println("The current i is "+ i);
                        i = index;
                        //reset index value
                        // index = 0;
                      }

                      //looping through dealer array
                      for (index2 = 0; index2 < 10; index2++) {
                        //if index of dealer array is equal to the dealer total
                        if (tallyArrayDealer[index2].equals(DealerCard2) || tallyArrayDealer[index2].equals(DealerCardString)) {
                          //initialize j to index
                          //System.out.println("The current j is "+ j );
                          j = index2;
                          //reset index value
                          index2 = 0;
                          break;
                        }

                      }
                      // System.out.println("TALLY BEFORE: " + tallyTable[i][j]);
                      tallyTable[i][j]++;
                      // System.out.println("TALLY AFTER: " + tallyTable[i][j]);
                      // System.out.println("TALLY BEFORE: " + tallyTable[index][index2]);
                      // tallyTable[index][index2]++;
                      // System.out.println("TALLY AFTER: " + tallyTable[index][index2]);
                    }
                  }

                  System.out.println("\n\n");
                  System.out.println("\t ---------------------------------------------------------------------------");
                  System.out.println("\t   2 \t 3 \t 4 \t 5 \t 6 \t 7 \t 8 \t 9 \t 10 \t A ");
                  System.out.println("\t ---------------------------------------------------------------------------");

                  System.out.println("        |");
                  System.out.println("  8     |" + tallyTable[0][0] + "\t" + tallyTable[0][1] + "\t" + tallyTable[0][2] + "\t" + tallyTable[0][3] + "\t" + tallyTable[0][4] + "\t" + tallyTable[0][5] + "\t" + tallyTable[0][6] + "\t" + tallyTable[0][7] + "\t" + tallyTable[0][8] + "\t" + tallyTable[0][9]);
                  System.out.println("  9     |" + tallyTable[1][0] + "\t" + tallyTable[1][1] + "\t" + tallyTable[1][2] + "\t" + tallyTable[1][3] + "\t" + tallyTable[1][4] + "\t" + tallyTable[1][5] + "\t" + tallyTable[1][6] + "\t" + tallyTable[1][7] + "\t" + tallyTable[1][8] + "\t" + tallyTable[1][9]);
                  System.out.println("  10    |" + tallyTable[2][0] + "\t" + tallyTable[2][1] + "\t" + tallyTable[2][2] + "\t" + tallyTable[2][3] + "\t" + tallyTable[2][4] + "\t" + tallyTable[2][5] + "\t" + tallyTable[2][6] + "\t" + tallyTable[2][7] + "\t" + tallyTable[2][8] + "\t" + tallyTable[2][9]);
                  System.out.println("  11    |" + tallyTable[3][0] + "\t" + tallyTable[3][1] + "\t" + tallyTable[3][2] + "\t" + tallyTable[3][3] + "\t" + tallyTable[3][4] + "\t" + tallyTable[3][5] + "\t" + tallyTable[3][6] + "\t" + tallyTable[3][7] + "\t" + tallyTable[3][8] + "\t" + tallyTable[3][9]);
                  System.out.println("  12    |" + tallyTable[4][0] + "\t" + tallyTable[4][1] + "\t" + tallyTable[4][2] + "\t" + tallyTable[4][3] + "\t" + tallyTable[4][4] + "\t" + tallyTable[4][5] + "\t" + tallyTable[4][6] + "\t" + tallyTable[4][7] + "\t" + tallyTable[4][8] + "\t" + tallyTable[4][9]);
                  System.out.println("  13    |" + tallyTable[5][0] + "\t" + tallyTable[5][1] + "\t" + tallyTable[5][2] + "\t" + tallyTable[5][3] + "\t" + tallyTable[5][4] + "\t" + tallyTable[5][5] + "\t" + tallyTable[5][6] + "\t" + tallyTable[5][7] + "\t" + tallyTable[5][8] + "\t" + tallyTable[5][9]);
                  System.out.println("  14    |" + tallyTable[6][0] + "\t" + tallyTable[6][1] + "\t" + tallyTable[6][2] + "\t" + tallyTable[6][3] + "\t" + tallyTable[6][4] + "\t" + tallyTable[6][5] + "\t" + tallyTable[6][6] + "\t" + tallyTable[6][7] + "\t" + tallyTable[6][8] + "\t" + tallyTable[6][9]);
                  System.out.println("  15    |" + tallyTable[7][0] + "\t" + tallyTable[7][1] + "\t" + tallyTable[7][2] + "\t" + tallyTable[7][3] + "\t" + tallyTable[7][4] + "\t" + tallyTable[7][5] + "\t" + tallyTable[7][6] + "\t" + tallyTable[7][7] + "\t" + tallyTable[7][8] + "\t" + tallyTable[7][9]);
                  System.out.println("  16    |" + tallyTable[8][0] + "\t" + tallyTable[8][1] + "\t" + tallyTable[8][2] + "\t" + tallyTable[8][3] + "\t" + tallyTable[8][4] + "\t" + tallyTable[8][5] + "\t" + tallyTable[8][6] + "\t" + tallyTable[8][7] + "\t" + tallyTable[8][8] + "\t" + tallyTable[8][9]);
                  System.out.println("  17    |" + tallyTable[9][0] + "\t" + tallyTable[9][1] + "\t" + tallyTable[9][2] + "\t" + tallyTable[9][3] + "\t" + tallyTable[9][4] + "\t" + tallyTable[9][5] + "\t" + tallyTable[9][6] + "\t" + tallyTable[9][7] + "\t" + tallyTable[9][8] + "\t" + tallyTable[9][9]);
                  System.out.println("  2,2   |" + tallyTable[10][0] + "\t" + tallyTable[10][1] + "\t" + tallyTable[10][2] + "\t" + tallyTable[10][3] + "\t" + tallyTable[10][4] + "\t" + tallyTable[10][5] + "\t" + tallyTable[10][6] + "\t" + tallyTable[10][7] + "\t" + tallyTable[10][8] + "\t" + tallyTable[10][9]);
                  System.out.println("  3,3   |" + tallyTable[11][0] + "\t" + tallyTable[11][1] + "\t" + tallyTable[11][2] + "\t" + tallyTable[11][3] + "\t" + tallyTable[11][4] + "\t" + tallyTable[11][5] + "\t" + tallyTable[11][6] + "\t" + tallyTable[11][7] + "\t" + tallyTable[11][8] + "\t" + tallyTable[11][9]);
                  System.out.println("  4,4   |" + tallyTable[12][0] + "\t" + tallyTable[12][1] + "\t" + tallyTable[12][2] + "\t" + tallyTable[12][3] + "\t" + tallyTable[12][4] + "\t" + tallyTable[12][5] + "\t" + tallyTable[12][6] + "\t" + tallyTable[12][7] + "\t" + tallyTable[12][8] + "\t" + tallyTable[12][9]);
                  System.out.println("  5,5   |" + tallyTable[13][0] + "\t" + tallyTable[13][1] + "\t" + tallyTable[13][2] + "\t" + tallyTable[13][3] + "\t" + tallyTable[13][4] + "\t" + tallyTable[13][5] + "\t" + tallyTable[13][6] + "\t" + tallyTable[13][7] + "\t" + tallyTable[13][8] + "\t" + tallyTable[13][9]);
                  System.out.println("  6,6   |" + tallyTable[14][0] + "\t" + tallyTable[14][1] + "\t" + tallyTable[14][2] + "\t" + tallyTable[14][3] + "\t" + tallyTable[14][4] + "\t" + tallyTable[14][5] + "\t" + tallyTable[14][6] + "\t" + tallyTable[14][7] + "\t" + tallyTable[14][8] + "\t" + tallyTable[14][9]);
                  System.out.println("  7,7   |" + tallyTable[15][0] + "\t" + tallyTable[15][1] + "\t" + tallyTable[15][2] + "\t" + tallyTable[15][3] + "\t" + tallyTable[15][4] + "\t" + tallyTable[15][5] + "\t" + tallyTable[15][6] + "\t" + tallyTable[15][7] + "\t" + tallyTable[15][8] + "\t" + tallyTable[15][9]);
                  System.out.println("  8,8   |" + tallyTable[16][0] + "\t" + tallyTable[16][1] + "\t" + tallyTable[16][2] + "\t" + tallyTable[16][3] + "\t" + tallyTable[16][4] + "\t" + tallyTable[16][5] + "\t" + tallyTable[16][6] + "\t" + tallyTable[16][7] + "\t" + tallyTable[16][8] + "\t" + tallyTable[16][9]);
                  System.out.println("  9,9   |" + tallyTable[17][0] + "\t" + tallyTable[17][1] + "\t" + tallyTable[17][2] + "\t" + tallyTable[17][3] + "\t" + tallyTable[17][4] + "\t" + tallyTable[17][5] + "\t" + tallyTable[17][6] + "\t" + tallyTable[17][7] + "\t" + tallyTable[17][8] + "\t" + tallyTable[17][9]);
                  System.out.println("  10,10 |" + tallyTable[18][0] + "\t" + tallyTable[18][1] + "\t" + tallyTable[18][2] + "\t" + tallyTable[18][3] + "\t" + tallyTable[18][4] + "\t" + tallyTable[18][5] + "\t" + tallyTable[18][6] + "\t" + tallyTable[18][7] + "\t" + tallyTable[18][8] + "\t" + tallyTable[18][9]);
                  System.out.println("  A,2   |" + tallyTable[19][0] + "\t" + tallyTable[19][1] + "\t" + tallyTable[19][2] + "\t" + tallyTable[19][3] + "\t" + tallyTable[19][4] + "\t" + tallyTable[19][5] + "\t" + tallyTable[19][6] + "\t" + tallyTable[19][7] + "\t" + tallyTable[19][8] + "\t" + tallyTable[19][9]);
                  System.out.println("  A,3   |" + tallyTable[20][0] + "\t" + tallyTable[20][1] + "\t" + tallyTable[20][2] + "\t" + tallyTable[20][3] + "\t" + tallyTable[20][4] + "\t" + tallyTable[20][5] + "\t" + tallyTable[20][6] + "\t" + tallyTable[20][7] + "\t" + tallyTable[20][8] + "\t" + tallyTable[20][9]);
                  System.out.println("  A,4   |" + tallyTable[21][0] + "\t" + tallyTable[21][1] + "\t" + tallyTable[21][2] + "\t" + tallyTable[21][3] + "\t" + tallyTable[21][4] + "\t" + tallyTable[21][5] + "\t" + tallyTable[21][6] + "\t" + tallyTable[21][7] + "\t" + tallyTable[21][8] + "\t" + tallyTable[21][9]);
                  System.out.println("  A,5   |" + tallyTable[22][0] + "\t" + tallyTable[22][1] + "\t" + tallyTable[22][2] + "\t" + tallyTable[22][3] + "\t" + tallyTable[22][4] + "\t" + tallyTable[22][5] + "\t" + tallyTable[22][6] + "\t" + tallyTable[22][7] + "\t" + tallyTable[22][8] + "\t" + tallyTable[22][9]);
                  System.out.println("  A,6   |" + tallyTable[23][0] + "\t" + tallyTable[23][1] + "\t" + tallyTable[23][2] + "\t" + tallyTable[23][3] + "\t" + tallyTable[23][4] + "\t" + tallyTable[23][5] + "\t" + tallyTable[23][6] + "\t" + tallyTable[23][7] + "\t" + tallyTable[23][8] + "\t" + tallyTable[23][9]);
                  System.out.println("  A,7   |" + tallyTable[24][0] + "\t" + tallyTable[24][1] + "\t" + tallyTable[24][2] + "\t" + tallyTable[24][3] + "\t" + tallyTable[24][4] + "\t" + tallyTable[24][5] + "\t" + tallyTable[24][6] + "\t" + tallyTable[24][7] + "\t" + tallyTable[24][8] + "\t" + tallyTable[24][9]);
                  System.out.println("  A,8   |" + tallyTable[25][0] + "\t" + tallyTable[25][1] + "\t" + tallyTable[25][2] + "\t" + tallyTable[25][3] + "\t" + tallyTable[25][4] + "\t" + tallyTable[25][5] + "\t" + tallyTable[25][6] + "\t" + tallyTable[25][7] + "\t" + tallyTable[25][8] + "\t" + tallyTable[25][9]);
                  System.out.println("  A,9   |" + tallyTable[26][0] + "\t" + tallyTable[26][1] + "\t" + tallyTable[26][2] + "\t" + tallyTable[26][3] + "\t" + tallyTable[26][4] + "\t" + tallyTable[26][5] + "\t" + tallyTable[26][6] + "\t" + tallyTable[26][7] + "\t" + tallyTable[26][8] + "\t" + tallyTable[26][9]);
                  System.out.println("  A,10  |" + tallyTable[27][0] + "\t" + tallyTable[27][1] + "\t" + tallyTable[27][2] + "\t" + tallyTable[27][3] + "\t" + tallyTable[27][4] + "\t" + tallyTable[27][5] + "\t" + tallyTable[27][6] + "\t" + tallyTable[27][7] + "\t" + tallyTable[27][8] + "\t" + tallyTable[27][9]);
                  System.out.println("  A,A   |" + tallyTable[28][0] + "\t" + tallyTable[28][1] + "\t" + tallyTable[28][2] + "\t" + tallyTable[28][3] + "\t" + tallyTable[28][4] + "\t" + tallyTable[28][5] + "\t" + tallyTable[28][6] + "\t" + tallyTable[28][7] + "\t" + tallyTable[28][8] + "\t" + tallyTable[28][9]);

                  //End Delimiter
                  System.out.println("\n\n");



      } else if (decknumber == 6) { /////////////////////////////////////////////////////////////////////////////////////////////////
        sql = "SELECT * FROM blackjackdatabase6";
        rs = stmt.executeQuery(sql);

        while (rs.next()) {
          int id  = rs.getInt("idBlackJackDatabase");
          String CardValue = rs.getString("CardValue");

          System.out.print("ID: " + id);
          System.out.println(", CardValue: " + CardValue);
        }

        System.out.println("");
        System.out.println("Frequency Table");
        //System.out.println("Randomized Set of 20 Integers: ");
        System.out.println("");

        for (int Rnd = 0; Rnd < freq; Rnd++) {

          count = 0;

          sql2 = "SELECT * FROM blackjackdatabase6 ORDER BY RAND() LIMIT 20;";
          rs2 = stmt.executeQuery(sql2);

          while (rs2.next()) {

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
          /*          System.out.println("User Card 1 : " + UserCard1);
          */          DealerCard1 = cards[1];
          /*          System.out.println("Dealer Card Down.... ");
          */          UserCard2 = cards[2];
          /*          System.out.println("User Card 2 : " + UserCard2);
          */          DealerCard2 = cards[3];
          /*          System.out.println("Dealer Card Shown: " + DealerCard2);
          */
                    //System.out.println("");

                    if (UserCard1.equals("Jack") || UserCard1.equals("Queen") || UserCard1.equals("King")) {
                      U1 = 10;
                      UserCardString1 = "10";
                    } else if (UserCard1.equals("Ace")) {
                      U1 = 1;
                    } else {
                      U1 = Integer.parseInt(UserCard1);
                    }

                    if (UserCard2.equals("Jack") || UserCard2.equals("Queen") || UserCard2.equals("King")) {
                      U2 = 10;
                      UserCardString2 = "10";
                    } else if (UserCard2.equals("Ace")) {
                      U2 = 1;
                    } else {
                      U2 = Integer.parseInt(UserCard2);
                    }

                    if (DealerCard1.equals("Jack") || DealerCard1.equals("Queen") || DealerCard1.equals("King")) {
                      D1 = 10;
                      DealerCardString1 = "10";
                    } else if (DealerCard1.equals("Ace")) {
                      D1 = 1;
                    } else {
                      D1 = Integer.parseInt(DealerCard1);
                    }

                    if (DealerCard2.equals("Jack") || DealerCard2.equals("Queen") || DealerCard2.equals("King")) {
                      D2 = 10;
                      DealerCardString2 = "10";
                    } else if (DealerCard2.equals("Ace")) {
                      D2 = 1;
                    } else {
                      D2 = Integer.parseInt(DealerCard2);
                    }

                    if (UserCard1.equals("Ace") && UserCard2.equals("Ace")) {
                      DealerCardString5 = "Ace,Ace";
                    }

                    if (UserCard1.equals("Ace") && !UserCard2.equals("Ace")) {
                      U1 = 11;
                    }

                    if (UserCard2.equals("Ace") && !UserCard1.equals("Ace")) {
                      U2 = 11;
                    }

                    if (DealerCard1.equals("Ace") && !DealerCard2.equals("Ace")) {
                      D1 = 11;
                    }

                    if (DealerCard2.equals("Ace") && !DealerCard1.equals("Ace")) {
                      D2 = 11;
                    }

                    totalU = U1 + U2;
                    totalD = D2;
                    int totalDw2 = D1 + D2;
          /*          System.out.println("\nYour Total is " + totalU);
                    System.out.println("Dealer Total is " + totalD + "\n");*/

                    SearchCond3 = UserCard1 + UserCard2;

                    //System.out.println("Search Condition 3: " + SearchCond3);

                    if (SearchCond3.equals("22") || SearchCond3.equals("33") || SearchCond3.equals("44") || SearchCond3.equals("55") || SearchCond3.equals("66") || SearchCond3.equals("77") || SearchCond3.equals("88") || SearchCond3.equals("99") || SearchCond3.equals("1010") || SearchCond3.equals("Ace2") || SearchCond3.equals("Ace3") || SearchCond3.equals("Ace4") || SearchCond3.equals("Ace4") || SearchCond3.equals("Ace5") || SearchCond3.equals("Ace6") || SearchCond3.equals("Ace7") || SearchCond3.equals("Ace8") || SearchCond3.equals("Ace9") || SearchCond3.equals("Ace10") || SearchCond3.equals("AceAce")) {
                      SearchCond4 = UserCard1 + "," + UserCard2;
                      //System.out.println("Search Condition 4: " + SearchCond4);
                    }

                    if (totalU <= 8 && !(SearchCond3.equals("22") || SearchCond3.equals("33") || SearchCond3.equals("44") || SearchCond3.equals("55") || SearchCond3.equals("66") || SearchCond3.equals("77") || SearchCond3.equals("88") || SearchCond3.equals("99") || SearchCond3.equals("1010") || SearchCond3.equals("Ace2") || SearchCond3.equals("Ace3") || SearchCond3.equals("Ace4") || SearchCond3.equals("Ace4") || SearchCond3.equals("Ace5") || SearchCond3.equals("Ace6") || SearchCond3.equals("Ace7") || SearchCond3.equals("Ace8") || SearchCond3.equals("Ace9") || SearchCond3.equals("Ace10") || SearchCond3.equals("AceAce"))) {
                      LessThan8 = 8;
                      SearchCond6 = String.valueOf(LessThan8);
                      //System.out.println("Search Condition 6: " + SearchCond6);
                    } else if (totalU == 18 || totalU == 19 || totalU == 20 && !(SearchCond3.equals("22") || SearchCond3.equals("33") || SearchCond3.equals("44") || SearchCond3.equals("55") || SearchCond3.equals("66") || SearchCond3.equals("77") || SearchCond3.equals("88") || SearchCond3.equals("99") || SearchCond3.equals("1010") || SearchCond3.equals("Ace2") || SearchCond3.equals("Ace3") || SearchCond3.equals("Ace4") || SearchCond3.equals("Ace4") || SearchCond3.equals("Ace5") || SearchCond3.equals("Ace6") || SearchCond3.equals("Ace7") || SearchCond3.equals("Ace8") || SearchCond3.equals("Ace9") || SearchCond3.equals("Ace10") || SearchCond3.equals("AceAce"))) {
                      MoreThan17 = 17;
                      SearchCond7 = String.valueOf(MoreThan17);
                      //System.out.println("Search Condition 7: " + SearchCond7);
                    } else {
                      SearchCond5 = String.valueOf(totalU);
                    }

                    //System.out.println("Search Condition 5: " + SearchCond5);
                    //System.out.println("DealerCard2 afterwards: " + DealerCard2);
                    //System.out.println("DealerCardString afterwards: " + DealerCardString);*/

                    for (index = 0; index < 29; index++) {
                      //if index of user array is equal to the user total
                      if (tallyArrayUser[index].equals(SearchCond4)) {
                        //initialize i to index
                        //System.out.println("The current i is "+ i);
                        i = index;
                        //reset index value
                        // index = 0;
                      } else if (tallyArrayUser[index].equals(SearchCond5)) {
                        //initialize i to index
                        //System.out.println("The current i is "+ i);
                        i = index;
                        //reset index value
                        // index = 0;
                      } else if (tallyArrayUser[index].equals(SearchCond6)) {
                        //initialize i to index
                        //System.out.println("The current i is "+ i);
                        i = index;
                        //reset index value
                        // index = 0;
                      } else if (tallyArrayUser[index].equals(SearchCond7)) {
                        //initialize i to index
                        //System.out.println("The current i is "+ i);
                        i = index;
                        //reset index value
                        // index = 0;
                      } else if (tallyArrayUser[index].equals(DealerCardString5)) {
                        //initialize i to index
                        //System.out.println("The current i is "+ i);
                        i = index;
                        //reset index value
                        // index = 0;
                      }

                      //looping through dealer array
                      for (index2 = 0; index2 < 10; index2++) {
                        //if index of dealer array is equal to the dealer total
                        if (tallyArrayDealer[index2].equals(DealerCard2) || tallyArrayDealer[index2].equals(DealerCardString)) {
                          //initialize j to index
                          //System.out.println("The current j is "+ j );
                          j = index2;
                          //reset index value
                          index2 = 0;
                          break;
                        }

                      }
                      // System.out.println("TALLY BEFORE: " + tallyTable[i][j]);
                      tallyTable[i][j]++;
                      // System.out.println("TALLY AFTER: " + tallyTable[i][j]);
                      // System.out.println("TALLY BEFORE: " + tallyTable[index][index2]);
                      // tallyTable[index][index2]++;
                      // System.out.println("TALLY AFTER: " + tallyTable[index][index2]);
                    }
                  }

                  System.out.println("\n\n");
                  System.out.println("\t ---------------------------------------------------------------------------");
                  System.out.println("\t   2 \t 3 \t 4 \t 5 \t 6 \t 7 \t 8 \t 9 \t 10 \t A ");
                  System.out.println("\t ---------------------------------------------------------------------------");

                  System.out.println("        |");
                  System.out.println("  8     |" + tallyTable[0][0] + "\t" + tallyTable[0][1] + "\t" + tallyTable[0][2] + "\t" + tallyTable[0][3] + "\t" + tallyTable[0][4] + "\t" + tallyTable[0][5] + "\t" + tallyTable[0][6] + "\t" + tallyTable[0][7] + "\t" + tallyTable[0][8] + "\t" + tallyTable[0][9]);
                  System.out.println("  9     |" + tallyTable[1][0] + "\t" + tallyTable[1][1] + "\t" + tallyTable[1][2] + "\t" + tallyTable[1][3] + "\t" + tallyTable[1][4] + "\t" + tallyTable[1][5] + "\t" + tallyTable[1][6] + "\t" + tallyTable[1][7] + "\t" + tallyTable[1][8] + "\t" + tallyTable[1][9]);
                  System.out.println("  10    |" + tallyTable[2][0] + "\t" + tallyTable[2][1] + "\t" + tallyTable[2][2] + "\t" + tallyTable[2][3] + "\t" + tallyTable[2][4] + "\t" + tallyTable[2][5] + "\t" + tallyTable[2][6] + "\t" + tallyTable[2][7] + "\t" + tallyTable[2][8] + "\t" + tallyTable[2][9]);
                  System.out.println("  11    |" + tallyTable[3][0] + "\t" + tallyTable[3][1] + "\t" + tallyTable[3][2] + "\t" + tallyTable[3][3] + "\t" + tallyTable[3][4] + "\t" + tallyTable[3][5] + "\t" + tallyTable[3][6] + "\t" + tallyTable[3][7] + "\t" + tallyTable[3][8] + "\t" + tallyTable[3][9]);
                  System.out.println("  12    |" + tallyTable[4][0] + "\t" + tallyTable[4][1] + "\t" + tallyTable[4][2] + "\t" + tallyTable[4][3] + "\t" + tallyTable[4][4] + "\t" + tallyTable[4][5] + "\t" + tallyTable[4][6] + "\t" + tallyTable[4][7] + "\t" + tallyTable[4][8] + "\t" + tallyTable[4][9]);
                  System.out.println("  13    |" + tallyTable[5][0] + "\t" + tallyTable[5][1] + "\t" + tallyTable[5][2] + "\t" + tallyTable[5][3] + "\t" + tallyTable[5][4] + "\t" + tallyTable[5][5] + "\t" + tallyTable[5][6] + "\t" + tallyTable[5][7] + "\t" + tallyTable[5][8] + "\t" + tallyTable[5][9]);
                  System.out.println("  14    |" + tallyTable[6][0] + "\t" + tallyTable[6][1] + "\t" + tallyTable[6][2] + "\t" + tallyTable[6][3] + "\t" + tallyTable[6][4] + "\t" + tallyTable[6][5] + "\t" + tallyTable[6][6] + "\t" + tallyTable[6][7] + "\t" + tallyTable[6][8] + "\t" + tallyTable[6][9]);
                  System.out.println("  15    |" + tallyTable[7][0] + "\t" + tallyTable[7][1] + "\t" + tallyTable[7][2] + "\t" + tallyTable[7][3] + "\t" + tallyTable[7][4] + "\t" + tallyTable[7][5] + "\t" + tallyTable[7][6] + "\t" + tallyTable[7][7] + "\t" + tallyTable[7][8] + "\t" + tallyTable[7][9]);
                  System.out.println("  16    |" + tallyTable[8][0] + "\t" + tallyTable[8][1] + "\t" + tallyTable[8][2] + "\t" + tallyTable[8][3] + "\t" + tallyTable[8][4] + "\t" + tallyTable[8][5] + "\t" + tallyTable[8][6] + "\t" + tallyTable[8][7] + "\t" + tallyTable[8][8] + "\t" + tallyTable[8][9]);
                  System.out.println("  17    |" + tallyTable[9][0] + "\t" + tallyTable[9][1] + "\t" + tallyTable[9][2] + "\t" + tallyTable[9][3] + "\t" + tallyTable[9][4] + "\t" + tallyTable[9][5] + "\t" + tallyTable[9][6] + "\t" + tallyTable[9][7] + "\t" + tallyTable[9][8] + "\t" + tallyTable[9][9]);
                  System.out.println("  2,2   |" + tallyTable[10][0] + "\t" + tallyTable[10][1] + "\t" + tallyTable[10][2] + "\t" + tallyTable[10][3] + "\t" + tallyTable[10][4] + "\t" + tallyTable[10][5] + "\t" + tallyTable[10][6] + "\t" + tallyTable[10][7] + "\t" + tallyTable[10][8] + "\t" + tallyTable[10][9]);
                  System.out.println("  3,3   |" + tallyTable[11][0] + "\t" + tallyTable[11][1] + "\t" + tallyTable[11][2] + "\t" + tallyTable[11][3] + "\t" + tallyTable[11][4] + "\t" + tallyTable[11][5] + "\t" + tallyTable[11][6] + "\t" + tallyTable[11][7] + "\t" + tallyTable[11][8] + "\t" + tallyTable[11][9]);
                  System.out.println("  4,4   |" + tallyTable[12][0] + "\t" + tallyTable[12][1] + "\t" + tallyTable[12][2] + "\t" + tallyTable[12][3] + "\t" + tallyTable[12][4] + "\t" + tallyTable[12][5] + "\t" + tallyTable[12][6] + "\t" + tallyTable[12][7] + "\t" + tallyTable[12][8] + "\t" + tallyTable[12][9]);
                  System.out.println("  5,5   |" + tallyTable[13][0] + "\t" + tallyTable[13][1] + "\t" + tallyTable[13][2] + "\t" + tallyTable[13][3] + "\t" + tallyTable[13][4] + "\t" + tallyTable[13][5] + "\t" + tallyTable[13][6] + "\t" + tallyTable[13][7] + "\t" + tallyTable[13][8] + "\t" + tallyTable[13][9]);
                  System.out.println("  6,6   |" + tallyTable[14][0] + "\t" + tallyTable[14][1] + "\t" + tallyTable[14][2] + "\t" + tallyTable[14][3] + "\t" + tallyTable[14][4] + "\t" + tallyTable[14][5] + "\t" + tallyTable[14][6] + "\t" + tallyTable[14][7] + "\t" + tallyTable[14][8] + "\t" + tallyTable[14][9]);
                  System.out.println("  7,7   |" + tallyTable[15][0] + "\t" + tallyTable[15][1] + "\t" + tallyTable[15][2] + "\t" + tallyTable[15][3] + "\t" + tallyTable[15][4] + "\t" + tallyTable[15][5] + "\t" + tallyTable[15][6] + "\t" + tallyTable[15][7] + "\t" + tallyTable[15][8] + "\t" + tallyTable[15][9]);
                  System.out.println("  8,8   |" + tallyTable[16][0] + "\t" + tallyTable[16][1] + "\t" + tallyTable[16][2] + "\t" + tallyTable[16][3] + "\t" + tallyTable[16][4] + "\t" + tallyTable[16][5] + "\t" + tallyTable[16][6] + "\t" + tallyTable[16][7] + "\t" + tallyTable[16][8] + "\t" + tallyTable[16][9]);
                  System.out.println("  9,9   |" + tallyTable[17][0] + "\t" + tallyTable[17][1] + "\t" + tallyTable[17][2] + "\t" + tallyTable[17][3] + "\t" + tallyTable[17][4] + "\t" + tallyTable[17][5] + "\t" + tallyTable[17][6] + "\t" + tallyTable[17][7] + "\t" + tallyTable[17][8] + "\t" + tallyTable[17][9]);
                  System.out.println("  10,10 |" + tallyTable[18][0] + "\t" + tallyTable[18][1] + "\t" + tallyTable[18][2] + "\t" + tallyTable[18][3] + "\t" + tallyTable[18][4] + "\t" + tallyTable[18][5] + "\t" + tallyTable[18][6] + "\t" + tallyTable[18][7] + "\t" + tallyTable[18][8] + "\t" + tallyTable[18][9]);
                  System.out.println("  A,2   |" + tallyTable[19][0] + "\t" + tallyTable[19][1] + "\t" + tallyTable[19][2] + "\t" + tallyTable[19][3] + "\t" + tallyTable[19][4] + "\t" + tallyTable[19][5] + "\t" + tallyTable[19][6] + "\t" + tallyTable[19][7] + "\t" + tallyTable[19][8] + "\t" + tallyTable[19][9]);
                  System.out.println("  A,3   |" + tallyTable[20][0] + "\t" + tallyTable[20][1] + "\t" + tallyTable[20][2] + "\t" + tallyTable[20][3] + "\t" + tallyTable[20][4] + "\t" + tallyTable[20][5] + "\t" + tallyTable[20][6] + "\t" + tallyTable[20][7] + "\t" + tallyTable[20][8] + "\t" + tallyTable[20][9]);
                  System.out.println("  A,4   |" + tallyTable[21][0] + "\t" + tallyTable[21][1] + "\t" + tallyTable[21][2] + "\t" + tallyTable[21][3] + "\t" + tallyTable[21][4] + "\t" + tallyTable[21][5] + "\t" + tallyTable[21][6] + "\t" + tallyTable[21][7] + "\t" + tallyTable[21][8] + "\t" + tallyTable[21][9]);
                  System.out.println("  A,5   |" + tallyTable[22][0] + "\t" + tallyTable[22][1] + "\t" + tallyTable[22][2] + "\t" + tallyTable[22][3] + "\t" + tallyTable[22][4] + "\t" + tallyTable[22][5] + "\t" + tallyTable[22][6] + "\t" + tallyTable[22][7] + "\t" + tallyTable[22][8] + "\t" + tallyTable[22][9]);
                  System.out.println("  A,6   |" + tallyTable[23][0] + "\t" + tallyTable[23][1] + "\t" + tallyTable[23][2] + "\t" + tallyTable[23][3] + "\t" + tallyTable[23][4] + "\t" + tallyTable[23][5] + "\t" + tallyTable[23][6] + "\t" + tallyTable[23][7] + "\t" + tallyTable[23][8] + "\t" + tallyTable[23][9]);
                  System.out.println("  A,7   |" + tallyTable[24][0] + "\t" + tallyTable[24][1] + "\t" + tallyTable[24][2] + "\t" + tallyTable[24][3] + "\t" + tallyTable[24][4] + "\t" + tallyTable[24][5] + "\t" + tallyTable[24][6] + "\t" + tallyTable[24][7] + "\t" + tallyTable[24][8] + "\t" + tallyTable[24][9]);
                  System.out.println("  A,8   |" + tallyTable[25][0] + "\t" + tallyTable[25][1] + "\t" + tallyTable[25][2] + "\t" + tallyTable[25][3] + "\t" + tallyTable[25][4] + "\t" + tallyTable[25][5] + "\t" + tallyTable[25][6] + "\t" + tallyTable[25][7] + "\t" + tallyTable[25][8] + "\t" + tallyTable[25][9]);
                  System.out.println("  A,9   |" + tallyTable[26][0] + "\t" + tallyTable[26][1] + "\t" + tallyTable[26][2] + "\t" + tallyTable[26][3] + "\t" + tallyTable[26][4] + "\t" + tallyTable[26][5] + "\t" + tallyTable[26][6] + "\t" + tallyTable[26][7] + "\t" + tallyTable[26][8] + "\t" + tallyTable[26][9]);
                  System.out.println("  A,10  |" + tallyTable[27][0] + "\t" + tallyTable[27][1] + "\t" + tallyTable[27][2] + "\t" + tallyTable[27][3] + "\t" + tallyTable[27][4] + "\t" + tallyTable[27][5] + "\t" + tallyTable[27][6] + "\t" + tallyTable[27][7] + "\t" + tallyTable[27][8] + "\t" + tallyTable[27][9]);
                  System.out.println("  A,A   |" + tallyTable[28][0] + "\t" + tallyTable[28][1] + "\t" + tallyTable[28][2] + "\t" + tallyTable[28][3] + "\t" + tallyTable[28][4] + "\t" + tallyTable[28][5] + "\t" + tallyTable[28][6] + "\t" + tallyTable[28][7] + "\t" + tallyTable[28][8] + "\t" + tallyTable[28][9]);

                  //End Delimiter
                  System.out.println("\n\n");

      } else if (decknumber == 8) { ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        sql = "SELECT * FROM blackjackdatabase8";
        rs = stmt.executeQuery(sql);

        while (rs.next()) {
          int id  = rs.getInt("idBlackJackDatabase");
          String CardValue = rs.getString("CardValue");

          System.out.print("ID: " + id);
          System.out.println(", CardValue: " + CardValue);
        }

        System.out.println("");
        System.out.println("Frequency Table");
        //System.out.println("Randomized Set of 20 Integers: ");
        System.out.println("");

        for (int Rnd = 0; Rnd < freq; Rnd++) {

          count = 0;

          sql2 = "SELECT * FROM blackjackdatabase8 ORDER BY RAND() LIMIT 20;";
          rs2 = stmt.executeQuery(sql2);

          while (rs2.next()) {

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
          /*          System.out.println("User Card 1 : " + UserCard1);
          */          DealerCard1 = cards[1];
          /*          System.out.println("Dealer Card Down.... ");
          */          UserCard2 = cards[2];
          /*          System.out.println("User Card 2 : " + UserCard2);
          */          DealerCard2 = cards[3];
          /*          System.out.println("Dealer Card Shown: " + DealerCard2);
          */
                    //System.out.println("");

                    if (UserCard1.equals("Jack") || UserCard1.equals("Queen") || UserCard1.equals("King")) {
                      U1 = 10;
                      UserCardString1 = "10";
                    } else if (UserCard1.equals("Ace")) {
                      U1 = 1;
                    } else {
                      U1 = Integer.parseInt(UserCard1);
                    }

                    if (UserCard2.equals("Jack") || UserCard2.equals("Queen") || UserCard2.equals("King")) {
                      U2 = 10;
                      UserCardString2 = "10";
                    } else if (UserCard2.equals("Ace")) {
                      U2 = 1;
                    } else {
                      U2 = Integer.parseInt(UserCard2);
                    }

                    if (DealerCard1.equals("Jack") || DealerCard1.equals("Queen") || DealerCard1.equals("King")) {
                      D1 = 10;
                      DealerCardString1 = "10";
                    } else if (DealerCard1.equals("Ace")) {
                      D1 = 1;
                    } else {
                      D1 = Integer.parseInt(DealerCard1);
                    }

                    if (DealerCard2.equals("Jack") || DealerCard2.equals("Queen") || DealerCard2.equals("King")) {
                      D2 = 10;
                      DealerCardString2 = "10";
                    } else if (DealerCard2.equals("Ace")) {
                      D2 = 1;
                    } else {
                      D2 = Integer.parseInt(DealerCard2);
                    }

                    if (UserCard1.equals("Ace") && UserCard2.equals("Ace")) {
                      DealerCardString5 = "Ace,Ace";
                    }

                    if (UserCard1.equals("Ace") && !UserCard2.equals("Ace")) {
                      U1 = 11;
                    }

                    if (UserCard2.equals("Ace") && !UserCard1.equals("Ace")) {
                      U2 = 11;
                    }

                    if (DealerCard1.equals("Ace") && !DealerCard2.equals("Ace")) {
                      D1 = 11;
                    }

                    if (DealerCard2.equals("Ace") && !DealerCard1.equals("Ace")) {
                      D2 = 11;
                    }

                    totalU = U1 + U2;
                    totalD = D2;
                    int totalDw2 = D1 + D2;
          /*          System.out.println("\nYour Total is " + totalU);
                    System.out.println("Dealer Total is " + totalD + "\n");*/

                    SearchCond3 = UserCard1 + UserCard2;

                    //System.out.println("Search Condition 3: " + SearchCond3);

                    if (SearchCond3.equals("22") || SearchCond3.equals("33") || SearchCond3.equals("44") || SearchCond3.equals("55") || SearchCond3.equals("66") || SearchCond3.equals("77") || SearchCond3.equals("88") || SearchCond3.equals("99") || SearchCond3.equals("1010") || SearchCond3.equals("Ace2") || SearchCond3.equals("Ace3") || SearchCond3.equals("Ace4") || SearchCond3.equals("Ace4") || SearchCond3.equals("Ace5") || SearchCond3.equals("Ace6") || SearchCond3.equals("Ace7") || SearchCond3.equals("Ace8") || SearchCond3.equals("Ace9") || SearchCond3.equals("Ace10") || SearchCond3.equals("AceAce")) {
                      SearchCond4 = UserCard1 + "," + UserCard2;
                      //System.out.println("Search Condition 4: " + SearchCond4);
                    }

                    if (totalU <= 8 && !(SearchCond3.equals("22") || SearchCond3.equals("33") || SearchCond3.equals("44") || SearchCond3.equals("55") || SearchCond3.equals("66") || SearchCond3.equals("77") || SearchCond3.equals("88") || SearchCond3.equals("99") || SearchCond3.equals("1010") || SearchCond3.equals("Ace2") || SearchCond3.equals("Ace3") || SearchCond3.equals("Ace4") || SearchCond3.equals("Ace4") || SearchCond3.equals("Ace5") || SearchCond3.equals("Ace6") || SearchCond3.equals("Ace7") || SearchCond3.equals("Ace8") || SearchCond3.equals("Ace9") || SearchCond3.equals("Ace10") || SearchCond3.equals("AceAce"))) {
                      LessThan8 = 8;
                      SearchCond6 = String.valueOf(LessThan8);
                      //System.out.println("Search Condition 6: " + SearchCond6);
                    } else if (totalU == 18 || totalU == 19 || totalU == 20 && !(SearchCond3.equals("22") || SearchCond3.equals("33") || SearchCond3.equals("44") || SearchCond3.equals("55") || SearchCond3.equals("66") || SearchCond3.equals("77") || SearchCond3.equals("88") || SearchCond3.equals("99") || SearchCond3.equals("1010") || SearchCond3.equals("Ace2") || SearchCond3.equals("Ace3") || SearchCond3.equals("Ace4") || SearchCond3.equals("Ace4") || SearchCond3.equals("Ace5") || SearchCond3.equals("Ace6") || SearchCond3.equals("Ace7") || SearchCond3.equals("Ace8") || SearchCond3.equals("Ace9") || SearchCond3.equals("Ace10") || SearchCond3.equals("AceAce"))) {
                      MoreThan17 = 17;
                      SearchCond7 = String.valueOf(MoreThan17);
                      //System.out.println("Search Condition 7: " + SearchCond7);
                    } else {
                      SearchCond5 = String.valueOf(totalU);
                    }

                    //System.out.println("Search Condition 5: " + SearchCond5);
                    //System.out.println("DealerCard2 afterwards: " + DealerCard2);
                    //System.out.println("DealerCardString afterwards: " + DealerCardString);*/

                    for (index = 0; index < 29; index++) {
                      //if index of user array is equal to the user total
                      if (tallyArrayUser[index].equals(SearchCond4)) {
                        //initialize i to index
                        //System.out.println("The current i is "+ i);
                        i = index;
                        //reset index value
                        // index = 0;
                      } else if (tallyArrayUser[index].equals(SearchCond5)) {
                        //initialize i to index
                        //System.out.println("The current i is "+ i);
                        i = index;
                        //reset index value
                        // index = 0;
                      } else if (tallyArrayUser[index].equals(SearchCond6)) {
                        //initialize i to index
                        //System.out.println("The current i is "+ i);
                        i = index;
                        //reset index value
                        // index = 0;
                      } else if (tallyArrayUser[index].equals(SearchCond7)) {
                        //initialize i to index
                        //System.out.println("The current i is "+ i);
                        i = index;
                        //reset index value
                        // index = 0;
                      } else if (tallyArrayUser[index].equals(DealerCardString5)) {
                        //initialize i to index
                        //System.out.println("The current i is "+ i);
                        i = index;
                        //reset index value
                        // index = 0;
                      }

                      //looping through dealer array
                      for (index2 = 0; index2 < 10; index2++) {
                        //if index of dealer array is equal to the dealer total
                        if (tallyArrayDealer[index2].equals(DealerCard2) || tallyArrayDealer[index2].equals(DealerCardString)) {
                          //initialize j to index
                          //System.out.println("The current j is "+ j );
                          j = index2;
                          //reset index value
                          index2 = 0;
                          break;
                        }

                      }
                      // System.out.println("TALLY BEFORE: " + tallyTable[i][j]);
                      tallyTable[i][j]++;
                      // System.out.println("TALLY AFTER: " + tallyTable[i][j]);
                      // System.out.println("TALLY BEFORE: " + tallyTable[index][index2]);
                      // tallyTable[index][index2]++;
                      // System.out.println("TALLY AFTER: " + tallyTable[index][index2]);
                    }
                  }

                  System.out.println("\n\n");
                  System.out.println("\t ---------------------------------------------------------------------------");
                  System.out.println("\t   2 \t 3 \t 4 \t 5 \t 6 \t 7 \t 8 \t 9 \t 10 \t A ");
                  System.out.println("\t ---------------------------------------------------------------------------");

                  System.out.println("        |");
                  System.out.println("  8     |" + tallyTable[0][0] + "\t" + tallyTable[0][1] + "\t" + tallyTable[0][2] + "\t" + tallyTable[0][3] + "\t" + tallyTable[0][4] + "\t" + tallyTable[0][5] + "\t" + tallyTable[0][6] + "\t" + tallyTable[0][7] + "\t" + tallyTable[0][8] + "\t" + tallyTable[0][9]);
                  System.out.println("  9     |" + tallyTable[1][0] + "\t" + tallyTable[1][1] + "\t" + tallyTable[1][2] + "\t" + tallyTable[1][3] + "\t" + tallyTable[1][4] + "\t" + tallyTable[1][5] + "\t" + tallyTable[1][6] + "\t" + tallyTable[1][7] + "\t" + tallyTable[1][8] + "\t" + tallyTable[1][9]);
                  System.out.println("  10    |" + tallyTable[2][0] + "\t" + tallyTable[2][1] + "\t" + tallyTable[2][2] + "\t" + tallyTable[2][3] + "\t" + tallyTable[2][4] + "\t" + tallyTable[2][5] + "\t" + tallyTable[2][6] + "\t" + tallyTable[2][7] + "\t" + tallyTable[2][8] + "\t" + tallyTable[2][9]);
                  System.out.println("  11    |" + tallyTable[3][0] + "\t" + tallyTable[3][1] + "\t" + tallyTable[3][2] + "\t" + tallyTable[3][3] + "\t" + tallyTable[3][4] + "\t" + tallyTable[3][5] + "\t" + tallyTable[3][6] + "\t" + tallyTable[3][7] + "\t" + tallyTable[3][8] + "\t" + tallyTable[3][9]);
                  System.out.println("  12    |" + tallyTable[4][0] + "\t" + tallyTable[4][1] + "\t" + tallyTable[4][2] + "\t" + tallyTable[4][3] + "\t" + tallyTable[4][4] + "\t" + tallyTable[4][5] + "\t" + tallyTable[4][6] + "\t" + tallyTable[4][7] + "\t" + tallyTable[4][8] + "\t" + tallyTable[4][9]);
                  System.out.println("  13    |" + tallyTable[5][0] + "\t" + tallyTable[5][1] + "\t" + tallyTable[5][2] + "\t" + tallyTable[5][3] + "\t" + tallyTable[5][4] + "\t" + tallyTable[5][5] + "\t" + tallyTable[5][6] + "\t" + tallyTable[5][7] + "\t" + tallyTable[5][8] + "\t" + tallyTable[5][9]);
                  System.out.println("  14    |" + tallyTable[6][0] + "\t" + tallyTable[6][1] + "\t" + tallyTable[6][2] + "\t" + tallyTable[6][3] + "\t" + tallyTable[6][4] + "\t" + tallyTable[6][5] + "\t" + tallyTable[6][6] + "\t" + tallyTable[6][7] + "\t" + tallyTable[6][8] + "\t" + tallyTable[6][9]);
                  System.out.println("  15    |" + tallyTable[7][0] + "\t" + tallyTable[7][1] + "\t" + tallyTable[7][2] + "\t" + tallyTable[7][3] + "\t" + tallyTable[7][4] + "\t" + tallyTable[7][5] + "\t" + tallyTable[7][6] + "\t" + tallyTable[7][7] + "\t" + tallyTable[7][8] + "\t" + tallyTable[7][9]);
                  System.out.println("  16    |" + tallyTable[8][0] + "\t" + tallyTable[8][1] + "\t" + tallyTable[8][2] + "\t" + tallyTable[8][3] + "\t" + tallyTable[8][4] + "\t" + tallyTable[8][5] + "\t" + tallyTable[8][6] + "\t" + tallyTable[8][7] + "\t" + tallyTable[8][8] + "\t" + tallyTable[8][9]);
                  System.out.println("  17    |" + tallyTable[9][0] + "\t" + tallyTable[9][1] + "\t" + tallyTable[9][2] + "\t" + tallyTable[9][3] + "\t" + tallyTable[9][4] + "\t" + tallyTable[9][5] + "\t" + tallyTable[9][6] + "\t" + tallyTable[9][7] + "\t" + tallyTable[9][8] + "\t" + tallyTable[9][9]);
                  System.out.println("  2,2   |" + tallyTable[10][0] + "\t" + tallyTable[10][1] + "\t" + tallyTable[10][2] + "\t" + tallyTable[10][3] + "\t" + tallyTable[10][4] + "\t" + tallyTable[10][5] + "\t" + tallyTable[10][6] + "\t" + tallyTable[10][7] + "\t" + tallyTable[10][8] + "\t" + tallyTable[10][9]);
                  System.out.println("  3,3   |" + tallyTable[11][0] + "\t" + tallyTable[11][1] + "\t" + tallyTable[11][2] + "\t" + tallyTable[11][3] + "\t" + tallyTable[11][4] + "\t" + tallyTable[11][5] + "\t" + tallyTable[11][6] + "\t" + tallyTable[11][7] + "\t" + tallyTable[11][8] + "\t" + tallyTable[11][9]);
                  System.out.println("  4,4   |" + tallyTable[12][0] + "\t" + tallyTable[12][1] + "\t" + tallyTable[12][2] + "\t" + tallyTable[12][3] + "\t" + tallyTable[12][4] + "\t" + tallyTable[12][5] + "\t" + tallyTable[12][6] + "\t" + tallyTable[12][7] + "\t" + tallyTable[12][8] + "\t" + tallyTable[12][9]);
                  System.out.println("  5,5   |" + tallyTable[13][0] + "\t" + tallyTable[13][1] + "\t" + tallyTable[13][2] + "\t" + tallyTable[13][3] + "\t" + tallyTable[13][4] + "\t" + tallyTable[13][5] + "\t" + tallyTable[13][6] + "\t" + tallyTable[13][7] + "\t" + tallyTable[13][8] + "\t" + tallyTable[13][9]);
                  System.out.println("  6,6   |" + tallyTable[14][0] + "\t" + tallyTable[14][1] + "\t" + tallyTable[14][2] + "\t" + tallyTable[14][3] + "\t" + tallyTable[14][4] + "\t" + tallyTable[14][5] + "\t" + tallyTable[14][6] + "\t" + tallyTable[14][7] + "\t" + tallyTable[14][8] + "\t" + tallyTable[14][9]);
                  System.out.println("  7,7   |" + tallyTable[15][0] + "\t" + tallyTable[15][1] + "\t" + tallyTable[15][2] + "\t" + tallyTable[15][3] + "\t" + tallyTable[15][4] + "\t" + tallyTable[15][5] + "\t" + tallyTable[15][6] + "\t" + tallyTable[15][7] + "\t" + tallyTable[15][8] + "\t" + tallyTable[15][9]);
                  System.out.println("  8,8   |" + tallyTable[16][0] + "\t" + tallyTable[16][1] + "\t" + tallyTable[16][2] + "\t" + tallyTable[16][3] + "\t" + tallyTable[16][4] + "\t" + tallyTable[16][5] + "\t" + tallyTable[16][6] + "\t" + tallyTable[16][7] + "\t" + tallyTable[16][8] + "\t" + tallyTable[16][9]);
                  System.out.println("  9,9   |" + tallyTable[17][0] + "\t" + tallyTable[17][1] + "\t" + tallyTable[17][2] + "\t" + tallyTable[17][3] + "\t" + tallyTable[17][4] + "\t" + tallyTable[17][5] + "\t" + tallyTable[17][6] + "\t" + tallyTable[17][7] + "\t" + tallyTable[17][8] + "\t" + tallyTable[17][9]);
                  System.out.println("  10,10 |" + tallyTable[18][0] + "\t" + tallyTable[18][1] + "\t" + tallyTable[18][2] + "\t" + tallyTable[18][3] + "\t" + tallyTable[18][4] + "\t" + tallyTable[18][5] + "\t" + tallyTable[18][6] + "\t" + tallyTable[18][7] + "\t" + tallyTable[18][8] + "\t" + tallyTable[18][9]);
                  System.out.println("  A,2   |" + tallyTable[19][0] + "\t" + tallyTable[19][1] + "\t" + tallyTable[19][2] + "\t" + tallyTable[19][3] + "\t" + tallyTable[19][4] + "\t" + tallyTable[19][5] + "\t" + tallyTable[19][6] + "\t" + tallyTable[19][7] + "\t" + tallyTable[19][8] + "\t" + tallyTable[19][9]);
                  System.out.println("  A,3   |" + tallyTable[20][0] + "\t" + tallyTable[20][1] + "\t" + tallyTable[20][2] + "\t" + tallyTable[20][3] + "\t" + tallyTable[20][4] + "\t" + tallyTable[20][5] + "\t" + tallyTable[20][6] + "\t" + tallyTable[20][7] + "\t" + tallyTable[20][8] + "\t" + tallyTable[20][9]);
                  System.out.println("  A,4   |" + tallyTable[21][0] + "\t" + tallyTable[21][1] + "\t" + tallyTable[21][2] + "\t" + tallyTable[21][3] + "\t" + tallyTable[21][4] + "\t" + tallyTable[21][5] + "\t" + tallyTable[21][6] + "\t" + tallyTable[21][7] + "\t" + tallyTable[21][8] + "\t" + tallyTable[21][9]);
                  System.out.println("  A,5   |" + tallyTable[22][0] + "\t" + tallyTable[22][1] + "\t" + tallyTable[22][2] + "\t" + tallyTable[22][3] + "\t" + tallyTable[22][4] + "\t" + tallyTable[22][5] + "\t" + tallyTable[22][6] + "\t" + tallyTable[22][7] + "\t" + tallyTable[22][8] + "\t" + tallyTable[22][9]);
                  System.out.println("  A,6   |" + tallyTable[23][0] + "\t" + tallyTable[23][1] + "\t" + tallyTable[23][2] + "\t" + tallyTable[23][3] + "\t" + tallyTable[23][4] + "\t" + tallyTable[23][5] + "\t" + tallyTable[23][6] + "\t" + tallyTable[23][7] + "\t" + tallyTable[23][8] + "\t" + tallyTable[23][9]);
                  System.out.println("  A,7   |" + tallyTable[24][0] + "\t" + tallyTable[24][1] + "\t" + tallyTable[24][2] + "\t" + tallyTable[24][3] + "\t" + tallyTable[24][4] + "\t" + tallyTable[24][5] + "\t" + tallyTable[24][6] + "\t" + tallyTable[24][7] + "\t" + tallyTable[24][8] + "\t" + tallyTable[24][9]);
                  System.out.println("  A,8   |" + tallyTable[25][0] + "\t" + tallyTable[25][1] + "\t" + tallyTable[25][2] + "\t" + tallyTable[25][3] + "\t" + tallyTable[25][4] + "\t" + tallyTable[25][5] + "\t" + tallyTable[25][6] + "\t" + tallyTable[25][7] + "\t" + tallyTable[25][8] + "\t" + tallyTable[25][9]);
                  System.out.println("  A,9   |" + tallyTable[26][0] + "\t" + tallyTable[26][1] + "\t" + tallyTable[26][2] + "\t" + tallyTable[26][3] + "\t" + tallyTable[26][4] + "\t" + tallyTable[26][5] + "\t" + tallyTable[26][6] + "\t" + tallyTable[26][7] + "\t" + tallyTable[26][8] + "\t" + tallyTable[26][9]);
                  System.out.println("  A,10  |" + tallyTable[27][0] + "\t" + tallyTable[27][1] + "\t" + tallyTable[27][2] + "\t" + tallyTable[27][3] + "\t" + tallyTable[27][4] + "\t" + tallyTable[27][5] + "\t" + tallyTable[27][6] + "\t" + tallyTable[27][7] + "\t" + tallyTable[27][8] + "\t" + tallyTable[27][9]);
                  System.out.println("  A,A   |" + tallyTable[28][0] + "\t" + tallyTable[28][1] + "\t" + tallyTable[28][2] + "\t" + tallyTable[28][3] + "\t" + tallyTable[28][4] + "\t" + tallyTable[28][5] + "\t" + tallyTable[28][6] + "\t" + tallyTable[28][7] + "\t" + tallyTable[28][8] + "\t" + tallyTable[28][9]);

                  //End Delimiter
                  System.out.println("\n\n");
      }


      else {
        System.out.println("Wrong Deck Number!");
        System.out.println("This will now close...");
        System.exit(0);
      }

      rs.close();
      rs2.close();
      stmt.close();
      conn.close();
    } catch (SQLException se) {
      se.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (stmt != null)
          stmt.close();
      } catch (SQLException se2) {}
      try {
        if (conn != null)
          conn.close();
      } catch (SQLException se) {
        se.printStackTrace();
      }
    }
  }

}