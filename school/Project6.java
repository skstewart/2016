
/**
 * Name: Shayna Stewart
 * Date: 12/1/16
 * CS182 Lab Project 6: Hash Crash
 * Description: Creates a hash table, the size of which is determined by the user. Inserts array of names (Strings) by
 * hashing them into integer values, creating DataItem objects, and inserting them into the Hash Table (a HashTable
 * object called hashtable). Creates a GUI and prints the array of collisons (from the hashtable object) 
 * onto the GUI with the name, the space they should have been in, and the space they actually were found in. Prints
 * them out in the order they crashed in. Also prints the amount of collisions.
 * Contains error checking for cases where the user: inputs a string rather than an integer number,
 * as well as for cases where the user inputs a number smaller than the number of names in the array.
 * 
 *
 * *************************************************************
 *
 * Project Number 6 - Comp Sci 182 - Data Structures
 * Start Code - Build your program starting with this code
 *
 * Copyright 2005,2016 Christopher C. Ferguson
 * This code may only be used with the permission of Christopher C. Ferguson
 *
 **************************************************************
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project6 extends JFrame implements ActionListener { 

    private static int win_xpos = 0, win_ypos = 0;// place window here
    private HashTable hashtable;
    private static int win_xsize = 700, win_ysize = 700;//  window size
    String[] names = {"fred", "barney", "tom", "jerry", "larry", "moe", "curly",
        "betty", "wilma", "bart", "homer", "marge", "maggie", "lisa",
        "pebbles", "bambam", "smithers", "burns", "milhouse", "george", "astro",
        "dino", "mickey", "minnie", "pluto", "goofy", "donald", "huey",
        "louie", "dewey", "snowwhite", "happy", "doc", "grumpy", "sneezy",
        "dopey", "sleepy", "bambi", "belle", "gaston", "tarzan", "jane",
        "simba", "scar", "mufasa", "ariel", "flounder", "bugs", "daffy",
        "elmer", "foghorn", "chickenhawk", "roger", "jessica", "hank", "bobby",
        "peggy", "spot", "pongo", "perdy", "buzz", "potatohead", "woody",
        "chuckie", "tommy", "phil", "lil", "angelica", "dill", "spike",
        "pepe", "speedy", "yosemite", "sam", "tweety", "sylvester", "granny",
        "spiderman", "batman", "superman", "supergirl", "robin", "jimmy", "olsen",
        "thing", "flash", "silversurfer", "xmen", "pokemon", "joker", "wonderwoman"
    };
// Private state variables.

    private Font boldfont = new Font("TimesRoman", Font.BOLD, 18);
    private Font plainfont = new Font("TimesRoman", Font.PLAIN, 12);

    private JButton hashbutton, exitbutton;
    private JPanel northPanel;
    private MyJPanel centerPanel;
    private JTextField hashsizefield;
    private String thetext = "101";

////////////MAIN////////////////////////
    public static void main(String[] args) {
        Project6 tpo = new Project6();

        tpo.addWindowListener(new WindowAdapter() {   // this exits the program when X box clicked
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

////////////CONSTRUCTOR/////////////////////
    public Project6() {
        northPanel = new JPanel();
        northPanel.add(new Label("Enter a hashtable size: "));
        hashsizefield = new JTextField(thetext, 20);
        northPanel.add(hashsizefield);
        hashbutton = new JButton("CreateHash");
        northPanel.add(hashbutton);
        hashbutton.addActionListener(this);
        exitbutton = new JButton("Exit");
        northPanel.add(exitbutton);
        exitbutton.addActionListener(this);
        getContentPane().add("North", northPanel);
        centerPanel = new MyJPanel();
        getContentPane().add("Center", centerPanel);

        // need more init stuff? try here.
        setSize(win_xsize, win_ysize);
        setLocation(win_xpos, win_ypos);
        setVisible(true);

    }

////////////BUTTON CLICKS ///////////////////////////
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitbutton) {
            dispose();
            System.exit(0);
        }

        if (e.getSource() == hashbutton) {
            DataItem dataItem;
            try {

                int hashSize = Integer.parseInt(hashsizefield.getText());
                if (hashSize < names.length) { //won't allow for a hashtable smaller than the number of names
                    
                    JOptionPane.showMessageDialog(null, "Please enter an integer at least " + names.length + ".");

                } else {
                    hashtable = new HashTable(hashSize);

                    for (String name : names) {
                        hashtable.insert(dataItem = new DataItem(hashtable.hashFunc3(name), name));
                    }
                }
            } catch (NumberFormatException | HeadlessException E) { // if anything other than an integer number is entered, an error pops up and it
                //won't even try to create the hashtable
                JOptionPane.showMessageDialog(null, "Please enter an integer at least " + names.length + ".");

            }

            repaint();

        }
    } // end actionPerformed

    class MyJPanel extends JPanel {

        ////////////    PAINT   ////////////////////////////////
        public void paintComponent(Graphics g) {
            g.setFont(plainfont);

            if (hashtable != null) { //only runs if the hashtable has been created
                int yposition = 45; // yposition. begins at 45, 15 added for each new line (below)

                for (int x = 0; x < hashtable.getCollisionCount(); x++) {
                    
                    if (hashtable.getCollisions()[x] != null) {

                        g.drawString("Hash Collision: " + hashtable.getCollisions()[x].getName() + " should be at "
                                + hashtable.getCollisions()[x].whereItCollided() + " found at " 
                                + hashtable.getCollisions()[x].getPosition(), 20, yposition);
                        yposition += 13;
                    }

                }
                g.drawString("Collision count for hash table size " + hashtable.getArraySize() 
                        + ": " + hashtable.getCollisionCount(), 20, 30); //paint the final collision count 

            }

        }
    } // End Of MyJPanel

}     // End Of Project6
