/*
Project 0
Name: Shayna Stewart
Date: 9/6/2016
What: CS182 Lab Project 0
Description: UserInput class that allows user to input values from keyboard, compares values to given parameters.
 */
import java.util.*;

public class UserInput {

    Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Enter an int: ");
        int intValue = getInt();
        System.out.println("You entered: " + intValue);

        System.out.println("Enter a char: ");
        char charValue = getChar();
        System.out.println("You entered: " + charValue);

        System.out.println("Enter a double: ");
        double doubleValue = getDouble();
        System.out.println("You entered: " + doubleValue);

        System.out.println("Enter an int: ");
        String stringValue = getString();
        System.out.println("You entered: " + stringValue);

        System.out.println("Enter an int between 1 and 15: ");
        int intValueTwo = getInt(1, 15);
        System.out.println("You entered: " + intValueTwo);

        System.out.println("Enter a char between A and F: ");
        char charValueTwo = getChar('a', 'F');
        System.out.println("You entered: " + charValueTwo);

        System.out.println("Enter a double between 1.0 and 7.6: ");
        double doubleValueTwo = getDouble(1.0, 7.6);
        System.out.println("You entered: " + doubleValueTwo);

        System.out.println("Enter a string between 1 and 14 characters long: ");
        String stringValueTwo = getString(1, 14);
        System.out.println("You entered: " + stringValueTwo);

    }

    public static int getInt() {

        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static char getChar() {
        Scanner sc = new Scanner(System.in);

        return sc.next().charAt(0);
    }

    public static double getDouble() {
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();

    }

    public static String getString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();

    }

    public static int getInt(int min, int max) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an int between " + min + " and " + max + " value.");
        int intValTwo = sc.nextInt();

        if (intValTwo < min || intValTwo > max) {

            System.out.println("Enter an int between " + min + " and " + max + " value");
            intValTwo = sc.nextInt();
        }
        return intValTwo;
    }

    public static char getChar(char min, char max) // min char 'A', max char 'Z'
    {
        Scanner sc = new Scanner(System.in);
        char charValTwo = sc.next().charAt(0);

        if (charValTwo > max && charValTwo < min) {

            System.out.println("Bad input" + charValTwo + ". Enter a char between " + min + " and " + max + " value");
            charValTwo = sc.next().charAt(0);
        }
        return charValTwo;

    }

    public static double getDouble(double min, double max) {
        Scanner sc = new Scanner(System.in);
        double doubleValTwo = sc.nextDouble();

        if (doubleValTwo < min || doubleValTwo > max) {

            System.out.println("Bad input" + doubleValTwo + ". Enter an int between " + min + " and " + max + " value");
            doubleValTwo = sc.nextDouble();
        }
        return doubleValTwo;
    }

    public static String getString(int min, int max) // min and max length
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String between " + min + " and " + max + " length.");
        String stringVal = sc.nextLine();

        if (stringVal.length() < min || stringVal.length() > max) {

            System.out.println("Enter a String between " + min + " and " + max + " length.");
            stringVal = sc.nextLine();
        }
        return stringVal;

    }

}
