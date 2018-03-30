
/**
 * *************************************************************
 * Project Number 3 - Comp Sci 182 - Data Structures (w/ Swing)
 * Start Code - Build your program starting with this code
 * Card Game
 * Copyright 2005-2016 Christopher C. Ferguson
 * This code may only be used with the permission of Christopher C. Ferguson
 *
 *
 *
 * Name: Shayna Stewart
 * Date due: 18 October, 2016
 * Date last modified: 17 October, 2016
 * CS 182 Lab Project 3
 * Description: Texas Holdem card game using GUI. Rules of the game: Both the player and dealer are dealt
 * 2 cards, one at a time, with the player being dealt first. Then, three cards are placed in the center which may
 * be used by both the dealer and player along with their own hands in order to form a hand and make card combinations,
 * all of which are worth various points. Each turn, the player is asked to place a bet, which is placed into
 * a bet pool (the dealer matches the be). There are three turns total after the initial deal,
 * and during each turn another card is placed in the center, and another bet is taken which goes to the bet pool.
 * At the end, there will be five cards at the center along with the same cards in the player's hand, and a final bet is placed
 * before both hands are revealed, and points are scored on card combinations, including the cards in the center. If the
 * player wins, they get all of the money in the pool. If not, they lose the money. If there is a tie between the player
 * and dealer, the money is split. The player will start with an amount of money at the beginning of the first game, which carries
 * through to the next game based on how much money they won or lost, and the player may keep going until they lose all their
 * money, when they are forced to start over or quit the program.
 * 
 * To begin, press "new session" button to create a new session and receive 1000 credits. Then press "start button" to begin 
 * a game.
 * Pressing "new session" again will start over with 1000 credits back in the player's possession.
 **************************************************************
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Project3 extends JFrame implements ActionListener {

    private static int winxpos = 0, winypos = 0;      // place window here

    private JButton exitButton, newButton, startButton;
    private JTextArea betPoolArea, userCreditArea;
    private CardList theDeck;
    private CardList playerHand;
    private CardList dealerHand;
    private CardList middleCards;
    private int betPool = 0;
    private int turn = 0;
    private int playerCredits = 0;
    private JPanel northPanel;
    private MyPanel centerPanel;
    private static JFrame myFrame = null;

    ////////////              MAIN      ////////////////////////
    public static void main(String[] args) {
        Project3 tpo = new Project3();
    }

    ////////////            CONSTRUCTOR   /////////////////////
    public Project3() {
        myFrame = this;                 // need a static variable reference to a JFrame object
        northPanel = new JPanel();
        northPanel.setBackground(Color.white);
        startButton = new JButton("Start");
        northPanel.add(startButton);
        startButton.addActionListener(this);
        newButton = new JButton("New Session");
        northPanel.add(newButton);
        newButton.addActionListener(this);
        exitButton = new JButton("Exit");
        northPanel.add(exitButton);
        exitButton.addActionListener(this);
        getContentPane().add("North", northPanel);
        userCreditArea = new JTextArea("player's credits: " + playerCredits + "");
        northPanel.add(userCreditArea);
        betPoolArea = new JTextArea("total bet pool: " + betPool + "");
        northPanel.add(betPoolArea);
        centerPanel = new MyPanel();
        getContentPane().add("Center", centerPanel);

        theDeck = new CardList(52);
        playerHand = new CardList();
        dealerHand = new CardList();
        middleCards = new CardList();

        setSize(800, 700);
        setLocation(winxpos, winypos);

        setVisible(true);
    }

    ////////////   BUTTON CLICKS ///////////////////////////
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == exitButton) {
            dispose();
            System.exit(0);
        }
        if (e.getSource() == startButton) {
            theDeck.shuffle();
            repaint();

            preflop();
        }
        if (e.getSource() == newButton) {
            theDeck = new CardList(52);
            theDeck.shuffle();
            playerHand = new CardList();
            dealerHand = new CardList();
            middleCards = new CardList();
            betPool = 0;
            turn = 0;
            playerCredits = 1000;
            repaint();

        }
    }

    public void preflop() { //two cards are dealt to each hand, pre-flop bet taken

        for (int x = 0; x < 2; x++) {
            playerHand.insertCard(theDeck.deleteCard(0));
            dealerHand.insertCard(theDeck.deleteCard(0));
        }
        repaint();
        placeBet();
        repaint();
        turn++;
        flop();

    }

    public void flop() { //three cards are dealt to middle, bets taken
        for (int x = 0; x < 3; x++) {
            middleCards.insertCard(theDeck.deleteCard(0));
        }
        repaint();
        placeBet();
        repaint();
        turn++;
        turn();
    }

    public void turn() { //one more card to middle, bet taken

        middleCards.insertCard(theDeck.deleteCard(0));

        repaint();
        placeBet();
        repaint();
        turn++;
        river();
    }

    public void river() { //final card to middle, bet taken
        middleCards.insertCard(theDeck.deleteCard(0));

        repaint();
        placeBet();
        repaint();
        turn++;
        postriver();
    }

    public void postriver() {
        repaint();
        scoreCards();
    }

    public void scoreCards() {
        boolean playerPair = false;
        boolean dealerPair = false;
        int playerFinalScore = 0;
        int dealerFinalScore = 0;
        int[] playerSuitsArray = new int[7];
        int[] dealerSuitsArray = new int[7];
        int[] playerValueArray = new int[7];
        int[] dealerValueArray = new int[7];
        Card tempPlayerCard = playerHand.getFirstCard();
        Card tempDealerCard = dealerHand.getFirstCard();
        for (int x = 0; x < 2; x++) {
            playerSuitsArray[x] = tempPlayerCard.getSuit();
            dealerSuitsArray[x] = tempDealerCard.getSuit();
            playerValueArray[x] = tempPlayerCard.getValue();
            dealerValueArray[x] = tempDealerCard.getValue();
            tempPlayerCard = tempPlayerCard.getNextCard();
            tempDealerCard = tempDealerCard.getNextCard();
        }
        Card tempMiddleCard = middleCards.getFirstCard();
        for (int y = 2; y < 7; y++) {
            playerSuitsArray[y] = tempPlayerCard.getSuit();
            dealerSuitsArray[y] = tempDealerCard.getSuit();
            playerValueArray[y] = tempPlayerCard.getValue();
            dealerValueArray[y] = tempDealerCard.getValue();
            tempPlayerCard = tempMiddleCard.getNextCard();
        }
        //scoring the player's hand now
        if (playerValueArray[0] == playerValueArray[1] || playerValueArray[0] == playerValueArray[2]
                || playerValueArray[0] == playerValueArray[3] || playerValueArray[0] == playerValueArray[4]
                || playerValueArray[0] == playerValueArray[5] || playerValueArray[0] == playerValueArray[6]
                || playerValueArray[1] == playerValueArray[2] || playerValueArray[1] == playerValueArray[3]
                || playerValueArray[1] == playerValueArray[4] || playerValueArray[1] == playerValueArray[5]
                || playerValueArray[1] == playerValueArray[6] || playerValueArray[2] == playerValueArray[2]
                || playerValueArray[2] == playerValueArray[3] || playerValueArray[2] == playerValueArray[4]
                || playerValueArray[2] == playerValueArray[5] || playerValueArray[2] == playerValueArray[5]
                || playerValueArray[2] == playerValueArray[6] || playerValueArray[3] == playerValueArray[3]
                || playerValueArray[3] == playerValueArray[4] || playerValueArray[3] == playerValueArray[5]
                || playerValueArray[3] == playerValueArray[6] || playerValueArray[4] == playerValueArray[4]
                || playerValueArray[4] == playerValueArray[5] || playerValueArray[4] == playerValueArray[6]
                || playerValueArray[5] == playerValueArray[5] || playerValueArray[5] == playerValueArray[6]
                || playerValueArray[6] == playerValueArray[6]) {
            playerPair = true;
            playerFinalScore = playerFinalScore + 2;
        }

//end player hand scoring
        // scoring dealer's hand now
        if (dealerValueArray[0] == dealerValueArray[1] || dealerValueArray[0] == dealerValueArray[2]
                || dealerValueArray[0] == dealerValueArray[3] || dealerValueArray[0] == dealerValueArray[4]
                || dealerValueArray[0] == dealerValueArray[5] || dealerValueArray[0] == dealerValueArray[6]
                || dealerValueArray[1] == dealerValueArray[2] || dealerValueArray[1] == dealerValueArray[3]
                || dealerValueArray[1] == dealerValueArray[4] || dealerValueArray[1] == dealerValueArray[5]
                || dealerValueArray[1] == dealerValueArray[6] || dealerValueArray[2] == dealerValueArray[2]
                || dealerValueArray[2] == dealerValueArray[3] || dealerValueArray[2] == dealerValueArray[4]
                || dealerValueArray[2] == dealerValueArray[5] || dealerValueArray[2] == dealerValueArray[5]
                || dealerValueArray[2] == dealerValueArray[6] || dealerValueArray[3] == dealerValueArray[3]
                || dealerValueArray[3] == dealerValueArray[4] || dealerValueArray[3] == dealerValueArray[5]
                || dealerValueArray[3] == dealerValueArray[6] || dealerValueArray[4] == dealerValueArray[4]
                || dealerValueArray[4] == dealerValueArray[5] || dealerValueArray[4] == dealerValueArray[6]
                || dealerValueArray[5] == dealerValueArray[5] || dealerValueArray[5] == dealerValueArray[6]
                || dealerValueArray[6] == dealerValueArray[6]) {
            dealerPair = true;
            dealerFinalScore = dealerFinalScore + 2;
        } else if (dealerValueArray[1] == dealerValueArray[2]) {

        }
        
        //end dealer scoring
        
        JFrame resultWindow = new JFrame();
        if (dealerFinalScore > playerFinalScore){
        JOptionPane.showMessageDialog(resultWindow, "You lose. A new game will begin.");
        newGame();
        }
        else{
            JOptionPane.showMessageDialog(resultWindow, "You win. A new game will begin.");
         playerCredits = playerCredits + betPool;
         newGame();
        }
    }

    public void newGame() {
        theDeck = new CardList(52);
        theDeck.shuffle();
        playerHand = new CardList();
        dealerHand = new CardList();
        middleCards = new CardList();
        betPool = 0;
        turn = 0;
        repaint();
    }

    public void placeBet() {
        JFrame betWindow = new JFrame();
        String input;
        input = JOptionPane.showInputDialog(betWindow, "Enter a bet: ");
        if (input == "") {
            placeBet();
        } else {
            Integer bet = Integer.valueOf(input);

            if (bet <= playerCredits && playerCredits > 0) {
                betPool = betPool + (bet * 2);
                playerCredits = playerCredits - bet;
                repaint();

            } else {
                placeBet();
            }
        }

    }

// This routine will load an image into memory
//
    public static Image load_picture(String fname) {
        // Create a MediaTracker to inform us when the image has
        // been completely loaded.
        Image image;
        MediaTracker tracker = new MediaTracker(myFrame);

        // getImage() returns immediately.  The image is not
        // actually loaded until it is first used.  We use a
        // MediaTracker to make sure the image is loaded
        // before we try to display it.
        image = myFrame.getToolkit().getImage(fname);

        // Add the image to the MediaTracker so that we can wait
        // for it.
        tracker.addImage(image, 0);
        try {
            tracker.waitForID(0);
        } catch (InterruptedException e) {
            System.err.println(e);
        }

        if (tracker.isErrorID(0)) {
            image = null;
        }
        return image;
    }
// --------------   end of load_picture ---------------------------

    class MyPanel extends JPanel {

        ////////////    PAINT   ////////////////////////////////
        public void paintComponent(Graphics g) {

            betPoolArea.setText("total bet pool: " + betPool + "");
            userCreditArea.setText("player's credits: " + playerCredits + "");

            int playerXPos = 320, playerYPos = 500;
            int dealerXPos = 320, dealerYPos = 5;
            int middleXPos = 200, middleYPos = 250;

            if (playerHand == null) {
                return;
            }

            if (turn < 5) {
                Card current = playerHand.getFirstCard();
                while (current != null) {
                    Image tempimage = current.getCardImage();
                    g.drawImage(tempimage, playerXPos, playerYPos, this);
                    // note: tempimage member variable must be set BEFORE paint is called
                    playerXPos += 80;
                    if (playerXPos > 700) {
                        playerXPos = 25;
                        playerYPos += 105;
                    }
                    current = current.getNextCard();
                } //while

                current = dealerHand.getFirstCard();
                while (current != null) {
                    Image tempimage = Project3.load_picture("images/gbCard52.gif");
                    g.drawImage(tempimage, dealerXPos, dealerYPos, this);
                    // note: tempimage member variable must be set BEFORE paint is called
                    dealerXPos += 80;
                    if (dealerXPos > 700) {
                        dealerXPos = 25;
                        dealerYPos += 105;
                    }
                    current = current.getNextCard();
                } //while

                current = middleCards.getFirstCard();
                while (current != null) {
                    Image tempimage = current.getCardImage();
                    g.drawImage(tempimage, middleXPos, middleYPos, this);
                    // note: tempimage member variable must be set BEFORE paint is called
                    middleXPos += 80;
                    if (middleXPos > 700) {
                        middleXPos = 25;
                        middleXPos += 105;
                    }
                    current = current.getNextCard();
                } //while

            } else {
                Card current = playerHand.getFirstCard();
                while (current != null) {
                    Image tempimage = current.getCardImage();
                    g.drawImage(tempimage, playerXPos, playerYPos, this);
                    // note: tempimage member variable must be set BEFORE paint is called
                    playerXPos += 80;
                    if (playerXPos > 700) {
                        playerXPos = 25;
                        playerYPos += 105;
                    }
                    current = current.getNextCard();
                } //while

                current = dealerHand.getFirstCard();
                while (current != null) {
                    Image tempimage = current.getCardImage();
                    g.drawImage(tempimage, dealerXPos, dealerYPos, this);
                    // note: tempimage member variable must be set BEFORE paint is called
                    dealerXPos += 80;
                    if (dealerXPos > 700) {
                        dealerXPos = 25;
                        dealerYPos += 105;
                    }
                    current = current.getNextCard();
                } //while

                current = middleCards.getFirstCard();
                while (current != null) {
                    Image tempimage = current.getCardImage();
                    g.drawImage(tempimage, middleXPos, middleYPos, this);
                    // note: tempimage member variable must be set BEFORE paint is called
                    middleXPos += 80;
                    if (middleXPos > 700) {
                        middleXPos = 25;
                        middleXPos += 105;
                    }
                    current = current.getNextCard();
                } //while
            }
        }
    }
}    // End Of class Project3

