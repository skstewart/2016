/*
Name: Stewart, Shayna
Date: 3/1/16
Project 1
 */

/**
 *
 * @author Student-HSLH133
 */
  import java.util.Scanner;

  public class CalculateTip {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       double dSubtotal;
       double dTipRate;
       double dTip;
       double dTotal;
       Scanner scanner = new Scanner(System.in);
       
       System.out.print("Enter your subtotal: ");
       
       String subtotal = scanner.next();
       
       dSubtotal = Double.parseDouble(subtotal);
       
       System.out.print("Enter the percent you want to tip: ");
       
       String tipRate = scanner.next();
       
       dTipRate = Double.parseDouble(tipRate);
       
       dTip = (dTipRate * dSubtotal);
       
       dTotal = (dTip + dSubtotal);
       
       System.out.println("Tip amount: " + dTip);
       
       System.out.println("Total due: " + dTotal);
       
    }
    
}
