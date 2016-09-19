/**
 * importing necessary Random utility library
 */
import java.util.Random;
/**
 * Deck class
 */
class Deck {
	/**
	 * defining initial variables
	 */
	String cards[][];
	int cardsUsed;
	Random r;
	/**
	 * defining Deck method
	 */
	public Deck() {
		cards = new String [52][2];
		cardsUsed = 0;
		r = new Random();
		int i, j, k;
		/**
		 * create deck. j is always which card you're on
		 */
		j = 0;
		for (i = 0; i < 4; i++) {
			cards[j][0] = "A";
			j++;
		}
		for (i = 2; i < 11; i++) {
			for (k = 0; k < 4; k++) {
				cards[j][0] = String.valueOf(i);
				j++;
			}
		}
		for (i = 0; i < 4; i++) {
			cards[j][0] = "J";
			j++;
		}
		for (i = 0; i < 4; i++) {
			cards[j][0] = "Q";
			j++;
		}
		for (i = 0; i < 4; i++) {
			cards[j][0] = "K";
			j++;
		}
		/**
		 * done making deck and initializing it
		 */
		cardsUsed = 0;
		for (i = 0; i < 52; i++) {
			cards[i][1] = "notUsed";
		}
	}
	/**
	 * shuffle deck
	 */
	public void shuffle() {
		int i;
		System.out.println("Reshuffle");
		cardsUsed = 0;
		for (i = 0; i < 52; i++) {
			cards[i][1] = "notUsed";
		}
	}
	/**
	 * deal cards
	 * @return  tempString
	 */
	public String deal() {
		int realRandom;
		String tempString;
		/**
		 * pick a card, will hang if no options
		 */
		realRandom = r.nextInt(52);
		while ((cards[realRandom][1].equals("used"))) {
			realRandom++;
			if (realRandom == 52) {
				realRandom = 0;
			}
		}
		cardsUsed++;
		cards[realRandom][1] = "used";
		/**
		 * done picking a card
		 * card will be randomly chosen using external function
		 */
		tempString = cards[realRandom][0];
		return tempString;
	}
	/**
	 * how many cards are left
	 * @return  cards used
	 */
	public int numCardsUsed() {
		return cardsUsed;
	}
}