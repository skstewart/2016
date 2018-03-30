/*
Name: Shayna Stewart
Date: 5/17/16
Project 5
Description: Imports a text file (names.txt) containing names, alphabetically organizes the names,
and saves the sorted names to a text file called nameout.txt.
 */

import java.io.*;
import java.util.*;

public class Names {

    public static void main(String[] args) throws Exception {
        String[] lastNames;
        String[] firstNames;
        String[] fullNames;
        try (Scanner input = new Scanner(new File("names.txt"))) {
            int numberOfNames = input.nextInt();
            lastNames = new String[numberOfNames];
            firstNames = new String[numberOfNames];
            fullNames = new String[numberOfNames];
            while (input.hasNext()) {
                for (int x = 0; x < numberOfNames; x++) {
                    lastNames[x] = input.next();
                    firstNames[x] = input.next();
                    fullNames[x] = lastNames[x] + " " + firstNames[x];
                }
            }
        }

        sortNames(fullNames);

        writeFile(fullNames);

    }

    public static void writeFile(String[] list) throws Exception {
        File fileObject = new File("nameout.txt"); // new file
        try (PrintWriter output = new PrintWriter(fileObject) //write file
                ) {
            for (String list1 : list) {
                output.println(list1);
            }
            output.close();
        }

    }

    public static void sortNames(String[] x) {
        int i, j;
        String temp;

        for (i = 0; i < x.length; i++) {
            for (j = i + 1; j < x.length; j++) {
                if (x[i].compareToIgnoreCase(x[j]) > 0) {                                             // ascending sort
                    temp = x[i];
                    x[i] = x[j];    // swapping
                    x[j] = temp;

                }
            }
        }
    }
}
