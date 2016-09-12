class Hand {
	/**
	 * defining initial variables
	 */
	String cards[];
	int cardsUsed;
	/**
	 * Hand
	 */
	public Hand() {
		cards = new String[22];
		cardsUsed = 0;
	}
	/**
	 * newHand method
	 */
	public void newHand() {
		int i;
		/**
		 * erase used cards,  in case
		 */
		for (i = 0; i < cardsUsed; i++) {
			cards[i] = "";
		}
		/**
		 * set cards used = 0
		 */
		cardsUsed = 0;
	}
	/**
	 * set hand method
	 * @param oneCard
	 */
	public void setHand(String oneCard) {
		cards[0] = oneCard;
		cardsUsed = 1;
	}
	/**
	 * defining value
	 * @return actualValue
	 */
	public int value() {
		int i;
		int actualValue = 0;
		boolean aceFlag = false;
		String handVal[] = new String[22];
		/**
		 * get value hand
		 */
		handVal = makeValueArray();
		/**
		 * set ace flag
		 */
		for (i = 0; i < cardsUsed; i++) {
			if (handVal[i].equals("A")) {
				aceFlag = true;
			}
		}
		/**
		 * figure out aces, and add values
		 */
		if (aceFlag) {
			/**
			 * add together everything but one ace
			 */
			for (i = 0; i < cardsUsed; i++) {
				if (!(handVal[i].equals("A"))) {
					actualValue = actualValue + Integer.parseInt(handVal[i]);
				}
			}
			/**
			 * if ace should count for 11, do that, else make it one
			 */
			if (actualValue <= 10) {
				actualValue = actualValue + 11;
			} else {
				actualValue = actualValue + 1;
			}
		} else {
			/**
			 * if there are not aces, add all values together
			 */
			for (i = 0; i < cardsUsed; i++) {
				actualValue = actualValue + Integer.parseInt(handVal[i]);
			}
		}
		return actualValue;
	}
	/**
	 * get compare string
	 * @return  returnCompareString
	 */
	public String getCompareString() {
		int i;
		int tempVal = 0;
		boolean aceFlag = false;
		String returnCompareString = "";
		String handVal[] = new String[22];
		if (cardsUsed == 1) {
			handVal = makeValueArray();
			returnCompareString = handVal[0];
		} else if (cardsUsed == 2) {
			/**
			 * make compare string for 2 cards
			 */
			for (i = 0; i < 2; i++) {
				/**
				 * handVal is array with values of each card
				 */
				handVal[i] = cards[i];
				/**
				 * switch face cards to 10, aces will be left as "A"
				 */
				if ((cards[i].equals("J")) | (cards[i].equals("Q")) | (cards[i].equals("K")))
					handVal[i] = "10";
			}
			if (handVal[0].equals(handVal[1])) {
				returnCompareString = handVal[0] + "," + handVal[0];
			} else if (handVal[0].equals("A")) {
				returnCompareString = "A," + handVal[1];
			} else if (handVal[1].equals("A")) {
				returnCompareString = "A," + handVal[0];
			} else {
				returnCompareString = String.valueOf(Integer.parseInt(handVal[0]) + Integer.parseInt(handVal[1]));
			}
		} else {
			/**
			 * more than 2 cards used
			 */
			handVal = makeValueArray();
			for (i = 0; i < cardsUsed; i++) {
				if (handVal[i].equals("A")) {
					aceFlag = true;
				} else {
					tempVal = tempVal + Integer.parseInt(handVal[i]);
				}
			}
			if (aceFlag) {
				if (tempVal <= 10) {
					returnCompareString = "A," + String.valueOf(tempVal);
				} else {
					returnCompareString = String.valueOf(tempVal + 1);
				}
			} else {
				returnCompareString = String.valueOf(tempVal);
			}
		}
		return returnCompareString;
	}
	/**
	 * make Value array
	 * @return hand value
	 */
	private String[] makeValueArray() {
		int i;
		boolean aceFlag = false;
		String handVal[] = new String[22];
		/**
		 * make value hand
		 */
		for (i = 0; i < cardsUsed; i++) {
			/**
			 * handval is array with values of each card
			 */
			handVal[i] = cards[i];
			/**
			 * switch face cards to 10
			 */
			if ((cards[i].equals("J")) | (cards[i].equals("Q")) | (cards[i].equals("K"))) {
				handVal[i] = "10";
			}
			/**
			 * leave first ace as "A", change following aces to 1
			 */
			if (cards[i].equals("A")) {
				if (aceFlag) {
					handVal[i] = "1";
				}
				aceFlag = true;
			}
		}
		return handVal;
	}
	/**
	 * compare hands
	 * @return  null
	 */
	public String compareHands() {
		return null;
	}
	/**
	 * hit method
	 * @param card
	 */
	public void hit(String card) {
		cards[cardsUsed] = card;
		cardsUsed++;
	}
	/**
	 * stand method
	 */
	public void stand() {
	}
	/**
	 * double down method
	 */
	public void doubleDown() {
	}
	/**
	 * split method
	 */
	public void split() {
	}
	/**
	 * return string consisting of all cards in hand separated by spaces
	 * @return tempString
	 */
	public String displayHand() {
		String tempString = "";
		int i;
		for (i = 0; i < cardsUsed; i++) {
			tempString = tempString + cards[i] + "\t";
		}
		return tempString;
	}
	/**
	 * return string consisting of first card in hand
	 * @return tempString
	 */
	public String displayFirst() {
		String tempString = "";
		if (cardsUsed > 0) {
			tempString = cards[0];
		}
		return tempString;
	}
	/**
	 * return string consisting of second card in hand
	 * @return tempString
	 */
	public String displaySecond() {
		String tempString = "";
		if (cardsUsed > 1) {
			tempString = cards[1];
		}
		return tempString;
	}
	/**
	 * return string consisting of first card in hand
	 * @return tempString
	 */
	public String displayFirstValue() {
		String tempString = "";
		if (cardsUsed > 0)
			tempString = cards[0];
		if (tempString.equals("J") | tempString.equals("Q") | tempString.equals("K"))
			tempString = "10";
		return tempString;
	}
	/**
	 * return string consisting of second card in hand
	 * @return tempString
	 */
	public String displaySecondValue() {
		String tempString = "";
		if (cardsUsed > 1) {
			tempString = cards[1];
		}
		if (tempString.equals("J") | tempString.equals("Q") | tempString.equals("K")) {
			tempString = "10";
		}
		return tempString;
	}
	/**
	 * get number of cards in hand
	 * @return cardsUsed
	 */
	public int getNumCardsInHand() {
		return cardsUsed;
	}
}