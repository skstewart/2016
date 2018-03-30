/*
Name: Shayna Stewart
Date: 4/12/16
Quiz 1
 */

/**
 *
 * @author Shayna
 */
import java.util.Scanner;
public class Quiz1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       int menuNumber = 0;
       int numberOfEntries = 0;
       double sum = 0;
       double average = 0;
       
       while (menuNumber != 3){
       System.out.println("1. Calculate average of Isaac's level per playthrough"
       + "\n2. Display information about the game\n3. Quit");
       menuNumber = input.nextInt();
       
       
       
       
       switch (menuNumber) {
        case 1: {
        System.out.println("How many playthroughs of the first Golden Sun game have you completed?");
        
        numberOfEntries = input.nextInt();
        
        System.out.println("Please enter Isaac's ending level for each individual playthough,"
        + " one at a time.");
        
        for (int x = 0; x < numberOfEntries; x++){
            int entry = input.nextInt();
            sum += entry;
        }
        
        average = (sum/numberOfEntries);
        
        System.out.println("The average level of Isaac through your completed playthroughs"
        + " is " + average + ".");
        
        break;
        }
        
        case 2: {
            System.out.println("Golden Sun is a JRPG series composed of three games."
                + "\nThe first two games, Golden Sun and Golden Sun: The Lost Age, are"
                + "\ndirectly related, with the second game being set directly after the first."
                + "\nThey are both playable on the Gameboy Advance."
                + "\nThe third game is a sequel set years after the first two games, and is"
                + "\ncentered around the children of the protagonists of the two main games."
                + "\nIt is playable on the Nintendo DS."
                + "\nThe games involve leveling characters by defeating both randomly encountered"
                + "\nenemies, story bosses, and extra bosses. The player guides the characters through the"
                + "\nstory by moving through the world map to arrive at each story destination,"
                + "\nsometimes placing puzzles in the player's way which they must solve to"
                + "\nmove on in the game. The game has a unique system for changing and improving"
                + "\nthe characters' abilities and stats, where special equipment may be"
                + "\nswitched around between characters to change abilities and stats."
                + "\nweapons, armor, shields, and accessories can also be acquired and equipped"
                + "\nto improve the stats of the characters. The story goes between two protagonists,"
                + "\nIsaac and Felix, though Isaac is considered the main protagonist.");
        break;
        }
        
        case 3: {
        System.exit(0);
        break;
        }
        
        default: { 
            
            break;
        }
        
    }
    }
    }
        
        
        
    }
    

