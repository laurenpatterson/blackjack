/**
 * importing necessary input/output classes and String Tokenizer
 */
import java.io.*;
import java.util.StringTokenizer;

public class Blackjack {

  public static int numberOfSplits = 4;
  static String userAction[][] = new String [30][11]; // size of table of input file (strategy card)

  public static void main(String[] args) {
    // define normal play variables
    Deck theDeck = new Deck();
    Hand player = new Hand();
    Hand dealer = new Hand();
    boolean hasSplit = false;
    // split variables
    Hand playerSplit[] = new Hand[4];
    int numSplits = 0;
    // to display scores
    int dScore = 0, pScore = 0;
    // user input stream reader
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // to analyze player actions
    String playerMove = null, realTemp = "", tempDecisionString = "";
    boolean doubleDownFlag = false;
    // fill array with user action choices
    try {
      fillWhatArray();
    } catch (IOException e) {
      System.out.println("File input error.");
    }
    // welcome message
    System.out.println("Welcome to 4LeafCo's Blackjack!");
    System.out.println("Follow the prompts below to play the game.");
    System.out.println("\nTo quit the game, enter q.");
    startNewGame(player, dealer, pScore, dScore, theDeck);
    // main play loop
    while (true) {
      // print prompt asking for user input
      System.out.print("\nEnter your move of (h)it, (s)tand, (d)ouble, or s(p)lit: ");
      try {
        playerMove = br.readLine();
      } catch (IOException ioe) {
        System.out.println("Error trying to read input, exiting.");
        System.exit(1);
      }
      // if player hits
      if (playerMove.equals("h")) {
        // get decision, and print accordingly
        hint(player, dealer, "hit", theDeck);
        // player hits, set up for bust if > 21
        player.hit(theDeck.deal());
        checkScores(player, dealer, pScore, dScore, theDeck, "false");
        if (player.value() > 21) {
          playerMove = "s";
        }
      }
      // else if player doubles down
      if (playerMove.equals("d")) {
        // only allow double if 2 cards in player hand
        if (player.getNumCardsInHand() >= 2) {
          // check user action
          hint(player, dealer, "doubled down", theDeck);
          // player hits, set up for bust if > 21
          player.hit(theDeck.deal());
          checkScores(player, dealer, pScore, dScore, theDeck, "false");
          // player can't hit again
          playerMove = "s";
          doubleDownFlag = true;
        } else {
          System.out.println("You can't double down with  " + String.valueOf(player.getNumCardsInHand()) + " cards in hand.");
          checkScores(player, dealer, pScore, dScore, theDeck, "false");
        }
      }
      // else if player stands
      if (playerMove.equals("s")) {
        // only check if player didn't bust
        if (player.value() <= 21) {
          // if player doubled, don't need to check what to do if stand
          if (!doubleDownFlag) {
            hint(player, dealer, "stood", theDeck);
          }
        } else {
          System.out.println("\nBust!");
          startNewGame(player, dealer, pScore, dScore, theDeck);
        }
        doubleDownFlag = false;
        // reshuffle deck if more than 45 cards used
        if (theDeck.numCardsUsed() > 45) {
          theDeck.shuffle();
        }
        checkScores(player, dealer, pScore, dScore, theDeck, "false");
      }
      // if player splits
      if (playerMove.equals("p")) {
        String tempString;
        // only allow double if 2 cards in player hand
        if (player.getNumCardsInHand() == 2) {
          if (player.displayFirstValue().equals(player.displaySecondValue())) {
            hint(player, dealer, "split", theDeck);
            hasSplit = true;
            tempString = player.displayFirst();
            player.setHand(tempString);
            player.hit(theDeck.deal());
            System.out.println("You have " + player.displayHand());
            // showHands(player, dealer);
            checkScores(player, dealer, pScore, dScore, theDeck, "false");
          } else {
            System.out.println("YOU CANNOT SPLIT THIS HAND");
            System.out.println("You have " + player.displayHand());
            // showHands(player, dealer);
            checkScores(player, dealer, pScore, dScore, theDeck, "false");
          }
        } else {
          System.out.println("YOU CANNOT SPLIT ANYTHING BUT 2 HANDS");
          System.out.println("You have " + player.displayHand());
          // showHands(player, dealer);
          checkScores(player, dealer, pScore, dScore, theDeck, "false");
        }
      }
      // end game
      if (playerMove.equals("q")) {
        System.out.println("\nTHANKS FOR PLAYING.");
        System.out.println("\nDealer's Score = " + dScore +  ", User's Score = " + pScore);
        break;
      }
    }
  }

    public static void hint(Hand player, Hand dealer, String playerMove, Deck theDeck) {
      String bestMove = returnUserAction(player.getCompareString(), dealer.displayFirstValue());
      if (bestMove.equals(playerMove)) {
        System.out.println("\nGood move!");
        // dealer.hit(theDeck.deal());
      } else {
        System.out.println("\nYikes! Instead you should have " + bestMove + ".");
        // player.hit(theDeck.deal());
      }
    }
    
    public static void showInitialHands(Hand player, Hand dealer) {
      System.out.println();
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println("Dealer Cards\t\t" + dealer.displayFirst());
      System.out.println("Your Cards\t\t\t" + player.displayHand() + " = " + player.value());
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"); 
    }

    public static void showHands(Hand player, Hand dealer) {
      System.out.println();
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println("Dealer Cards\t\t" + dealer.displayHand());
      System.out.println("Your Cards\t\t\t" + player.displayHand() + " = " + player.value());
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void startNewGame(Hand player, Hand dealer, int pScore, int dScore, Deck theDeck) 
    {
      player.newHand();
      dealer.newHand();
      // deal first cards
      player.hit(theDeck.deal());
      dealer.hit(theDeck.deal());
      player.hit(theDeck.deal());
      dealer.hit(theDeck.deal());
      // play results
      // showInitialHands(player, dealer);
      checkScores(player, dealer, pScore, dScore, theDeck, "true");
    }

    public static void checkScores(Hand player, Hand dealer, int pScore, int dScore, Deck theDeck, String firstPlay) {
      if (player.value() > 21) {
        dScore++;
        System.out.println("\nBUST!!! \nSorry. You lost by going over 21 but let's try again.");
        // System.out.println("\nDealer's Score = " + dScore +  ", User's Score = " + pScore);
        startNewGame(player, dealer, pScore, dScore, theDeck);
      } else if (player.value() == 21 || dealer.value() > 21) {
        pScore++;
        System.out.println("Congrats! You won a game.");
        // System.out.println("\nDealer's Score = " + dScore +  ", User's Score = " + pScore);
        startNewGame(player, dealer, pScore, dScore, theDeck);
      } else {
        System.out.println("\nDealer's Score = " + dScore +  ", User's Score = " + pScore);
        if (firstPlay.equals("true")) {
          showInitialHands(player, dealer);
        } else {
          showHands(player, dealer);
        }
      }
    }
   

    public static String returnUserAction(String player, String dealer) {
      String whatString = "";
      int vertSearch = 0, horSearch = 0, i;
      for (i = 0; i < 30; i++) {
        if (userAction[i][0].equals(player))
          vertSearch = i;
      }
      for (i = 0; i < 11; i++) {
        if (userAction[0][i].equals(dealer))
          horSearch = i;
      }
      if (userAction[vertSearch][horSearch].equals("H"))
        whatString = "hit";
      else if (userAction[vertSearch][horSearch].equals("S"))
        whatString = "stood";
      else if (userAction[vertSearch][horSearch].equals("D"))
        whatString = "doubled down";
      else if (userAction[vertSearch][horSearch].equals("P"))
        whatString = "split";
      return whatString;
    }

    public static void fillWhatArray() throws IOException {
      int bInInt = 0, tInt = 0;
      String line = null;
      FileInputStream f = null;
      try {
        f = new FileInputStream("strategyCard.txt");
      } catch (Exception e) {
        System.out.println("There was an error opening the strategy card input file.");
      }
      InputStreamReader fIn  = new InputStreamReader(f);
      BufferedReader bIn = new BufferedReader(fIn);
      while ((line = bIn.readLine()) != null) {
        StringTokenizer t = new StringTokenizer(line);
        while (t.hasMoreTokens()) {
          userAction[bInInt][tInt] = t.nextToken();
          tInt++;
        }
        tInt = 0;
        bInInt++;
      }
    }

  }