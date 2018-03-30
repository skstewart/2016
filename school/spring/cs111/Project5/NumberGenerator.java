/*
Name: Shayna Stewart
Date: 5/17/16
Project 5
Description: Generates an amount (up to 15) of random numbers, and saves the numbers to a text file
called numbers.txt.
 */

import java.util.*;
import java.io.*;

public class NumberGenerator {

    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        int numberOfNumbers = rand.nextInt(15);
        File fileObject = new File("numbers.txt"); // new file
        try (PrintWriter output = new PrintWriter(fileObject) //write file
                ) {
            output.println(numberOfNumbers);

            for (int x = 0; x < numberOfNumbers; x++) {
                output.println(rand.nextInt(100));
            }
        }

    }

}
