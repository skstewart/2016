/*
Name: Stewart, Shayna
Date: 3/3/16
Project 2
 */

/**
 *
 * @author Student-HSLH133
 */
import java.util.Random;
import java.util.Scanner;
public class GuessingGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int guess = -1;
        int value = rand.nextInt(32)+1;
        int highGuesses = 0;
        int lowGuesses = 0;
        int totalGuesses = 0;
        boolean keepPlaying = true;
        
        
        System.out.println("I'm thinking of a number between 1 and 32."
        + "\nEnter a number between 1 and 32: ");
      
      
        while (keepPlaying == true) {
        
            guess = input.nextInt();
            totalGuesses++;
        
        if (guess == value) {
            System.out.println("You win!");
            keepPlaying = false;
        }
        
        else if (guess == -1){
            System.out.println("Quitting so soon?");
            keepPlaying = false;
            totalGuesses--;
        }
        
        else if (guess > value){
            System.out.println("Your guess is too high, try again: "); 
            highGuesses++;
            
        }
        else {
            System.out.println("Your guess is too low, try again: "); 
            lowGuesses++;
            
        }
        }
                
        
        System.out.println("The number was " + value + "!");
        
        System.out.println("Total guesses: " + totalGuesses);
        
        for (int x = 0; x < totalGuesses; x++)
            System.out.printf("*");
        
        System.out.println("\nLow guesses: " + lowGuesses);
        
        for (int y = 0; y < lowGuesses; y++)
            System.out.printf("*");
        
        System.out.println("\nHigh guesses: " + highGuesses);
        
        for (int z = 0; z < highGuesses; z++)
             System.out.printf("*");
    }}
