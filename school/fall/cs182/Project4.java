/*
Name: Shayna Stewart
Date: 11/3/16
Project 4 COMPSCI 182 LAB BeamMeUp
Description: Creates Moon objects and assigns to one Kirk's Macho. Player jumps through the moons entering
passcode and moon name correctly through a push of the stack, or returns to previous moon through a pop of
the stack. Upon finding the macho, they must return to the enterprise by popping the way they came. In order to
win, the stack must be empty, the Macho must be achieved, and they must have reached the enterprise (making it
assigned to the current variable.) 

/**
 * *************************************************************
 *
 * Project Number 4 - Comp Sci 182 - Data Structures
 * Start Code - Build your program starting with this code
 *
 * I'm a doctor Jim, Not a Freakin' Programmer   -   Dr. McCoy
 *
 * Copyright 2013-16 Christopher C. Ferguson
 * This code may only be used with the permission of Christopher C. Ferguson
 *
 **************************************************************
 */
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Project4 extends JFrame implements ActionListener {

    Stack theStack = new Stack();
    private static int xpos = 0, ypos = 0;// place window at this position
    private static int xsize = 800, ysize = 500;// set window to this size

// Private state variables.
    private JPanel northPanel, centerPanel;

    private JButton pushButton, popButton, dumpButton, exitButton, newGameButton;
    private JTextField moonField;
    private JTextField codeField;
    private JTextArea outputArea;
    private Moon titan = new Moon("Titan");
    private Moon elara = new Moon("Elara");
    private Moon io = new Moon("Io");
    private Moon europa = new Moon("Europa");
    private Moon rhea = new Moon("Rhea");
    private Moon metis = new Moon("Metis");
    private Moon enterprise = new Moon("Enterprise");
    private Moon current = enterprise;
    private boolean achievedMacho = false;

////////////MAIN////////////////////////
    public static void main(String[] args) {
        Project4 tpo = new Project4();
    }

////////////CONSTRUCTOR/////////////////////
    public Project4() {
        addScreenComponents();   // put the stuff on the screen

        // Exit when the window is closed. i.e. when top right X box pressed
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setSize(xsize, ysize);
        setLocation(xpos, ypos);
        setVisible(true);
        Stack theStack = new Stack(); //create new stack

        enterprise.setPassCode("1234");
        Moon machoArray[] = new Moon[6];
        machoArray[0] = titan;
        machoArray[1] = metis;
        machoArray[2] = rhea;
        machoArray[3] = elara;
        machoArray[4] = io;
        machoArray[5] = europa;
        int rnd = new Random().nextInt(machoArray.length);
        machoArray[rnd].setMacho(true); //assigns the macho to a random moon

    }

    public void addScreenComponents() {
        northPanel = new JPanel();
        northPanel.add(new JLabel("Enter A moon name: "));
        moonField = new JTextField("", 15);
        northPanel.add(moonField);
        northPanel.add(new JLabel("And A Code: "));
        codeField = new JTextField("", 5);
        northPanel.add(codeField);

        pushButton = new JButton("Push");
        northPanel.add(pushButton);
        pushButton.addActionListener(this);
        popButton = new JButton("Pop");
        northPanel.add(popButton);
        popButton.addActionListener(this);
        dumpButton = new JButton("Dump");
        northPanel.add(dumpButton);
        dumpButton.addActionListener(this);
        newGameButton = new JButton("New Game");
        northPanel.add(newGameButton);
        newGameButton.addActionListener(this);
        exitButton = new JButton("Exit");
        northPanel.add(exitButton);
        exitButton.addActionListener(this);

        getContentPane().add("North", northPanel);

        centerPanel = new JPanel();
        outputArea = new JTextArea("Space, the final frontier.... To boldly go find my Muy Mas Macho! \nYou are currently"
                + " on the Enterprise. The passcode to re-enter is 1234.", 20, 60);
        centerPanel.add(outputArea);
        getContentPane().add(centerPanel, "Center");

    }
////////////BUTTON CLICKS ///////////////////////////

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == exitButton) {
            dispose();
            System.exit(0);
        }
        if (e.getSource() == newGameButton) {
            theStack = new Stack(); //create new stack
            achievedMacho = false; //takes away your macho if you have it :(
            
            current = enterprise;
            achievedMacho = false;
            enterprise.setPassCode("1234");
            current = enterprise;
            Moon machoArray[] = new Moon[6];
            machoArray[0] = titan;
            machoArray[1] = metis;
            machoArray[2] = rhea;
            machoArray[3] = elara;
            machoArray[4] = io;
            machoArray[5] = europa;
            int rnd = new Random().nextInt(machoArray.length);
            machoArray[rnd].setMacho(true); //put the macho in a new moon
            outputArea.setText("Space, the final frontier.... To boldly go find my Muy Mas Macho! \nYou are currently"
                    + " on the Enterprise. The passcode to re-enter is 1234.");
        }

        if (e.getSource() == popButton) { //pops moon from stack ONLY if passcode and moon name entered match
            String moonToPop = moonField.getText();
            String codeToPop = codeField.getText();
            moonField.setText("");
            codeField.setText("");
            if (theStack.getTop() != -1) {
                //checks name and passcode
                if (moonToPop.equalsIgnoreCase(theStack.peek().getMoonName()) && codeToPop.equals(theStack.peek().getPassCode())) {
                    outputArea.setText("Pop returning to " + moonToPop + ". ");
                    current = theStack.pop();
                    if (current == enterprise && achievedMacho == true && theStack.getTop() == -1) {
                        outputArea.setText("You win! Select new game to start over.");
//if you get the macho and return to the enterprise, you win!

                    }

                } else {
                    outputArea.setText("invalid entry, you died. Select new game to start over.");
                    theStack.empty();
                    current = enterprise;
                }

            } else {
                outputArea.setText("invalid entry, you died. Select new game to start over.");
                theStack.empty();
                current = enterprise;
            }
        }

        if (e.getSource() == pushButton) {
            String newmoonname = moonField.getText();
            String newmooncode = codeField.getText();
            moonField.setText("");
            codeField.setText("");

            //Tranporting to a moon requires a push onto the stack of a moon object. 
            //The moon object must contain the current moon name and the player supplied code. 
            //So if you leave the Titan moon to transport to the Rhea moon, it is Titan that is pushed onto the stack.
            switch (newmoonname) {
                case "rhea": {
                    if (current == titan || current == europa) {
                        pushMoon(newmooncode, rhea);
                    } else {
                        outputArea.setText("invalid entry, you died. Press new game.");
                        theStack.empty();
                        current = enterprise;
                    }
                }
                break;
                case "Rhea": {
                    if (current == titan || current == europa || current == enterprise) {
                        pushMoon(newmooncode, rhea);
                    } else {
                        outputArea.setText("invalid entry, you died. new game will now be created.");
                        theStack.empty();
                        current = enterprise;
                        //game over;
                    }
                }
                break;
                case "Metis": {
                    if (current == europa || current == elara || current == io) {
                        pushMoon(newmooncode, metis);
                    } else {
                        outputArea.setText("invalid entry, you died. Press new game.");
                        theStack.empty();
                        current = enterprise;
                        //game over;
                    }
                }
                break;
                case "metis": {
                    if (current == europa || current == elara || current == io) {
                        pushMoon(newmooncode, metis);
                    } else {
                        outputArea.setText("invalid entry, you died. Press new game.");
                        theStack.empty();
                        current = enterprise;
                        //game over;
                    }
                }
                break;
                case "elara": {
                    if (current == metis || current == titan) {
                        pushMoon(newmooncode, elara);
                    } else {
                        outputArea.setText("invalid entry, you died. Press new game.");
                        theStack.empty();
                        current = enterprise;
                        //game over;
                    }
                }
                break;
                case "Elara": {
                    if (current == metis || current == titan) {
                        pushMoon(newmooncode, elara);
                    } else {
                        outputArea.setText("invalid entry, you died. Press new game.");
                        theStack.empty();
                        current = enterprise;
                        //game over;

                    }
                }
                break;
                case "io": {
                    if (current == metis) {
                        pushMoon(newmooncode, io);
                    } else {
                        outputArea.setText("invalid entry, you died. Press new game.");
                        theStack.empty();
                        current = enterprise;
                        //game over;
                    }
                }
                break;
                case "Io": {
                    if (current == metis) {
                        pushMoon(newmooncode, io);
                    } else {
                        outputArea.setText("invalid entry, you died. Press new game.");
                        theStack.empty();
                        current = enterprise;
                        //game over;
                    }
                }
                break;
                case "Titan": {
                    if (current == rhea || current == elara || current == enterprise) {
                        pushMoon(newmooncode, titan);
                    } else {
                        outputArea.setText("invalid entry, you died. Press new game.");
                        theStack.empty();
                        current = enterprise;
                        //game over;
                    }
                }
                break;
                case "titan": {
                    if (current == rhea || current == elara || current == enterprise) {
                        pushMoon(newmooncode, titan);
                    } else {
                        outputArea.setText("invalid entry, you died. Press new game.");
                        theStack.empty();
                        current = enterprise;
                        //game over;
                    }
                }
                break;
                case "Europa": {
                    if (current == rhea || current == metis) {
                        pushMoon(newmooncode, europa);
                    } else {
                        outputArea.setText("invalid entry, you died. Press new game.");
                        theStack.empty();
                        current = enterprise;
                        //game over;
                    }
                }
                break;
                case "europa": {
                    if (current == rhea || current == metis) {
                        pushMoon(newmooncode, europa);
                    } else {
                        outputArea.setText("invalid entry, you died. Press new game.");
                        theStack.empty();
                        current = enterprise;

                        //game over;
                    }
                }
                break;

            }

            //push new Moon objects onto stack, only if they either are for a moon within range to go to, or if the moon
            //attempting to be pushed is the same as the one the user came from (utilizing the peek function)?, they must enter
            //the correct moon name and passcode.
        }

        if (e.getSource() == dumpButton) {
            System.out.println("Stack Contents Dump: ");

            // add code to print contents of Stack to the CONSOLE
            Stack dumpStack = new Stack();    //create new stack
/*
            while (theStack.getMoonArray() != null) {
                dumpStack.push(theStack.pop());
                System.out.println(dumpStack.peek().getMoonName() + " " + dumpStack.peek().getPassCode());
            }
            while (dumpStack.getMoonArray() != null) {
                theStack.push(dumpStack.pop());
            }
             */
            dumpStack = theStack;
            for (int x = 0; x < dumpStack.getTop() + 1; x++) {
                System.out.println(dumpStack.getMoonArray()[x].getMoonName() + " " + dumpStack.getMoonArray()[x].getPassCode());
            }
            System.out.println(dumpStack.toString());

            // pop from theStack, push into newStack
            //output the moons
            //then pop from newStack, and push onto theStack
        }

    }

    public void pushMoon(String code, Moon moon) {
        //push the entered moon onto the stack, only if the code entered is 4 digits. 

        if (code.length() < 5 && code.length() > 3 && (code == null ? current.getPassCode() != null : !code.equals(current.getPassCode()))) {

            moon.setPassCode(code);
            outputArea.setText("Push entering " + moon.getMoonName() + " with code " + code);
            theStack.push(current);
            current = moon;
            if (current.containsMacho() == true) {
                outputArea.setText("You got back your muy macho! Pop to go back to the enterprise.");
                current.setMacho(false);
                achievedMacho = true;
            }
        } else {
            outputArea.setText("invalid entry, you died. Press new game.");
            theStack.empty();
            current = enterprise;
            //game over;
        }

    }
}     // End Of Project4
