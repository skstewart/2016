
/**
 * *************************************************************
 * Name: Shayna Stewart
 * Date: 11/22/16
 * CS182 Lab Project 5
 * Project Description: Constructs a GUI object to display a Binary Tree using Java Swing.
 * Calls the displayTree method within Tree to display the Binary Tree to the GUI screen, and also
 * displays the Binary Tree on the console. Allows insertion and deletion from the tree by taking in
 * the number the user wants to insert or delete, finding its space it needs to go (or the space where it needs
 * to be deleted from) and either inserting the new value or deleting the value from the tree.
 * Also finds a value entered by the user, and highlights it in red.
 *
 *
 *
 * Project Number 5 - Comp Sci 182 - Data Structures
 * Start Code - Build your program starting with this code
 *
 * Copyright 2016 Christopher C. Ferguson
 * This code may only be used with the permission of Christopher C. Ferguson
 *
 **************************************************************
 */
import com.sun.xml.internal.ws.util.StringUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Project5 extends JFrame implements ActionListener {

    private static int winxpos = 0, winypos = 0;// place window here

// Private state variables.
    private Font boldfont = new Font("TimesRoman", Font.BOLD, 18);
    private Font plainfont = new Font("TimesRoman", Font.PLAIN, 12);

    private JButton insertbutton, exitbutton, deletebutton, findbutton;
    private JTextField infield;
    private JPanel northPanel;
    private MyPanel centerPanel;
    private static final int WINWIDTH = 1200; // make it BIGGER if you have higher resolution, full screen 
    private static final int WINHEIGHT = 800;
    private Tree theTree = new Tree();

////////////MAIN////////////////////////
    public static void main(String[] args) {
        Project5 tpo = new Project5();

        tpo.addWindowListener(new WindowAdapter() {   // this exits the program when X box clicked 
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

////////////CONSTRUCTOR/////////////////////
    public Project5() {
        northPanel = new JPanel();
        northPanel.add(new Label("Enter a number to insert: "));
        infield = new JTextField("", 20);
        northPanel.add(infield);
        insertbutton = new JButton("Insert");
        northPanel.add(insertbutton);
        insertbutton.addActionListener(this);
        findbutton = new JButton("Find");
        northPanel.add(findbutton);
        findbutton.addActionListener(this);
        deletebutton = new JButton("Delete");
        northPanel.add(deletebutton);
        deletebutton.addActionListener(this);
        exitbutton = new JButton("Exit");
        northPanel.add(exitbutton);
        exitbutton.addActionListener(this);
        getContentPane().add("North", northPanel);

        centerPanel = new MyPanel();
        getContentPane().add("Center", centerPanel);

        theTree.insert(50, 1.5);
        theTree.insert(25, 1.2);
        theTree.insert(75, 1.7);
        theTree.insert(12, 1.5);
        theTree.insert(37, 1.2);
        theTree.insert(43, 1.7);
        theTree.insert(30, 1.5);
        theTree.insert(33, 1.2);
        theTree.insert(87, 1.7);
        theTree.insert(93, 1.5);
        theTree.insert(97, 1.5);
        theTree.displayTree();

        setSize(WINWIDTH, WINHEIGHT);
        setLocation(winxpos, winypos);
        setVisible(true);

    }

////////////BUTTON CLICKS ///////////////////////////
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == exitbutton) { //close the window
            dispose();
            System.exit(0);

        }

        if (e.getSource() == insertbutton) { //insert a new node into the tree in its correct place
           try{
            theTree.insert(Integer.parseInt(infield.getText()), 2.1);
           }
           catch(Exception E){ //if an integer is not entered
           JOptionPane.showMessageDialog(null, "Please enter a valid integer.");
           infield.setText("");
           }
            repaint();
        }

        if (e.getSource() == findbutton) { //find a specific node in the tree
            try{
                if (theTree.find(Integer.parseInt(infield.getText())) != null){
            theTree.find(Integer.parseInt(infield.getText())).setFind(true);}
                else {
                JOptionPane.showMessageDialog(null, "Item not found.");
                 infield.setText("");
                }
            }
            catch (Exception E){//if an integer is not entered
            JOptionPane.showMessageDialog(null, "Please enter a valid integer.");
            infield.setText("");
            }
            repaint();
        }

        if (e.getSource() == deletebutton) { //delete a specific node from the tree
            try{ 
                if (theTree.find(Integer.parseInt(infield.getText())) != null){
            theTree.delete(Integer.parseInt(infield.getText()));}
                else {
                    JOptionPane.showMessageDialog(null, "Item not found.");
                     infield.setText("");
                }
            }
            catch (Exception E){ //if an integer is not entered
            JOptionPane.showMessageDialog(null, "Please enter a valid integer.");
            infield.setText("");
            }
            repaint();
        }

    }

    
    class MyPanel extends JPanel {

        ////////////    PAINT   //////////////////////////////// 
        public void paintComponent(Graphics g) {

            theTree.displayTree(); //displays tree to the console
            theTree.displayTree(g, theTree.getRoot(), WINWIDTH / 2, 80, 1); //displays the tree to the GUI
        }
    }

}     // End Of Project5 
