
/**
 * ***************************************************************
 * Class CardList, A Linked list of playing cards
 * May be placed in a file named CardList.java
 *
 * Note : This class can be used to create a 'hand' of cards
 * Just Create another CardList object, and delete cards from
 * 'theDeck' and insert the into the new CardList object
 *
 * 
 * Name: Shayna Stewart
 * Date due: 18 October, 2016
 * Date last modified: 17 October, 2016
 * Project 3
 * Description: CardList class creates CardList objects (used as the deck, the player and dealer's hands,
 * and the cards in the center of the table in Texas Holdem)
 *****************************************************************
 */
class CardList {

    private Card firstcard = null;
    private int numcards = 0;
    

    public CardList() {
    }

    public CardList(CardList deck, int num) {
        numcards = num;   //set numcards in the deck
        for (int i = 0; i < num; i++) {  // load the cards
            Card temp = deck.getFirstCard();
            if (firstcard != null) {
                temp.setNext(firstcard);
            }
            firstcard = temp;
            
        }
    }

    public CardList(int num) {
        numcards = num;   //set numcards in the deck
        for (int i = 0; i < num; i++) {  // load the cards
            Card temp = new Card(i);
            if (firstcard != null) {
                temp.setNext(firstcard);
            }
            firstcard = temp;
        }
    }

    public Card getFirstCard() {
        return firstcard;
    }
    
    //public Card deleteCard(Card card){
    
    //}
    

    public Card deleteCard(int cardnum) {
        Card target, targetprevious;

        if (cardnum > numcards) {
            return null;   // not enough cards to delete that one
        } else {
            numcards--;
        }

        target = firstcard;
        targetprevious = null;
        while ((Card) target.getNext() != null) {
            targetprevious = target;
            target = (Card) target.getNext();

        }
        if (targetprevious != null) {
            targetprevious.setNext(target.getNext());
        } else {
            firstcard = (Card) target.getNext();
        }
        return target;
    }

    public void insertCard(Card target) {
        numcards++;
        if (firstcard != null) {
            target.setNext(firstcard);
            
        } else {
            target.setNext(null);
        }
        firstcard = target;
    }

    public void shuffle() {
        for (int i = 0; i < 300; i++) {
            int rand = (int) (Math.random() * 100) % numcards;
            Card temp = deleteCard(rand);
            if (temp != null) {
                insertCard(temp);
            }
        }  // end for loop
    }   // end shuffle

}    // end class CardList

