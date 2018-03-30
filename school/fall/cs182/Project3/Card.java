
import java.awt.Image;

/**
 * ***************************************************************
 * Class Card, the derived class each card is one object of type Card May be
 * placed in a file named Card.java
 * 
 * Name: Shayna Stewart
 * Date due: 18 October, 2016
 * Date last modified: 17 October, 2016
 * Project 3
 * Description: Card class creates Card objects, which inherits from class Link
*****************************************************************
 */
class Card extends Link {

    private Image cardimage;
    private int cardNumber;
    private int suit;
    private int value;
    // private Card next;

    //public Card getNext() { return next; }
    //public void setNext(Card newnext) { next = newnext; }
    public Card(int cardnum) {
        cardimage = Project3.load_picture("images/gbCard" + cardnum + ".gif");
        setSuit();
        setValue();
        cardNumber = cardnum;
        // code ASSUMES there is an images sub-dir in your project folder
        if (cardimage == null) {
            System.out.println("Error - image failed to load: images/gbCard" + cardnum + ".gif");
            System.exit(-1);
        }
    }

    public Card getNextCard() {
        return (Card) next;
    }

    public Image getCardImage() {
        return cardimage;
    }

    public int getCardNum() {
        return cardNumber;
    }

    public void setValue() {
        if (cardNumber == 0 || cardNumber == 13 || cardNumber == 26 || cardNumber == 39) {
            value = 14;
        }
        if (cardNumber == 1 || cardNumber == 14 || cardNumber == 27 || cardNumber == 40) {
            value = 2;
        }
        if (cardNumber == 2 || cardNumber == 15 || cardNumber == 28 || cardNumber == 41) {
            value = 3;
        }
        if (cardNumber == 3 || cardNumber == 16 || cardNumber == 29 || cardNumber == 42) {
            value = 4;
        }
        if (cardNumber == 4 || cardNumber == 17 || cardNumber == 30 || cardNumber == 43) {
            value = 5;
        }
        if (cardNumber == 5 || cardNumber == 18 || cardNumber == 31 || cardNumber == 44) {
            value = 6;
        }
        if (cardNumber == 6 || cardNumber == 19 || cardNumber == 32 || cardNumber == 45) {
            value = 7;
        }
        if (cardNumber == 7 || cardNumber == 20 || cardNumber == 33 || cardNumber == 46) {
            value = 8;
        }
        if (cardNumber == 8 || cardNumber == 21 || cardNumber == 34 || cardNumber == 47) {
            value = 9;
        }
        if (cardNumber == 9 || cardNumber == 22 || cardNumber == 35 || cardNumber == 48) {
            value = 10;
        }
        if (cardNumber == 10 || cardNumber == 23 || cardNumber == 36 || cardNumber == 49) {
            value = 11;
        }
        if (cardNumber == 11 || cardNumber == 24 || cardNumber == 37 || cardNumber == 50) {
            value = 12;
        }
        if (cardNumber == 12 || cardNumber == 25 || cardNumber == 38 || cardNumber == 51) {
            value = 13;
        }
    }

    public void setSuit() {
        if (cardNumber <= 13) {
            suit = 1;
        }

        if (cardNumber <= 13) {
            suit = 2;
        }
        if (cardNumber <= 13) {
            suit = 3;
        } else {
            suit = 4;
        }
    }
    
    public int getValue(){
    return value;}
    
    public int getSuit(){
    return suit;}

}  //end class Card

