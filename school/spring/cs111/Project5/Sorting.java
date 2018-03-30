/*
Name: Shayna Stewart
Date: 5/17/16
Project 5
Description: Takes data from numbers.txt, stores as an aray, sorts, then outputs 
as new numout.txt file.
 */

import java.io.*;
import java.util.*;

public class Sorting {

    public static void main(String[] args) throws Exception {
        int[] numbers;
        try (Scanner input = new Scanner(new File("numbers.txt"))) {
            int numberOfNumbers = input.nextInt();
            numbers = new int[numberOfNumbers];
            while (input.hasNext()) {
                for (int x = 0; x < numberOfNumbers; x++) {
                    numbers[x] = input.nextInt();
                }
            }
        }

        selectionSort(numbers);

        writeFile(numbers);
    }

    public static void writeFile(int[] list) throws Exception {
        File fileObject = new File("numout.txt"); // new file
        try (PrintWriter output = new PrintWriter(fileObject) //write file
                ) {
            for (int x = 0; x < list.length; x++) {
                output.println(list[x]);
            }
        }

    }

    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            // Find the minimum in the list[i..list.length-1]
            int currentMin = list[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < list.length; j++) {
                if (currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }

            // Swap list[i] with list[currentMinIndex] if necessary;
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }

    }
}
