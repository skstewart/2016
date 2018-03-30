/*
Name: Stewart, Shayna
Date: 2/11/16
Project 1
 */

/**
 *
 * @author Student-HSLH133
 */
import java.util.Scanner;
public class ConvertTemp {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);
        double fahrenheit;
        double dCelsius;
        
        System.out.print("Enter your value (celsius): ");
        
        String celsius = scanner.nextLine();
        
        dCelsius = Double.parseDouble(celsius);

        fahrenheit = (((9.0 / 5.0) * dCelsius) + 32.0);
        
        System.out.println(dCelsius + " degrees celsius = " + 
                fahrenheit + " degrees fahrenheit.");
        
       
        
    }
    
}
