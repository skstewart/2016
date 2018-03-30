    /*
name: Stewart Shayna
Date: 2/16/16
Project 1
 */

/**
 *
 * @author Student-HSLH133
 */
import java.util.Scanner;
public class FeetMeters {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("Enter a value in feet (ft): ");
        double dFeet;
        double meters;
        Scanner scanner = new Scanner(System.in);
        
        String feet = scanner.nextLine();
       
        dFeet = Double.parseDouble(feet);
        
        meters = (dFeet / .305);
        
        System.out.println(dFeet + " feet = " + meters + " meters.");
        
    }
    
}
