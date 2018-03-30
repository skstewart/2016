/*
Name: Stewart, Shayna
Date: 2/16/16
Project 1
 */

/**
 *
 * @author Student-HSLH133
 */
import java.util.Scanner;
public class CalculateCylinder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       double dRadius;
       double dLength;
       double area;
       double volume;
        
       Scanner scanner = new Scanner(System.in);
        
       System.out.print("Enter a radius value: ");
        
       String radius = scanner.nextLine();
        
       dRadius = Double.parseDouble(radius);
        
       System.out.print("Enter a length value: ");
        
       String length = scanner.nextLine();
        
       dLength = Double.parseDouble(length);

       area = ((dRadius * dRadius) * 3.14159); 
        
       volume = (area * dLength);
        
       System.out.println("The volume of your cylinder is " + volume);
        
     }
    
}
