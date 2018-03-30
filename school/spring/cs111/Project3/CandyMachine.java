/*
Name: Shayna Stewart
CS 111
Project 3
Description: Creates a virtual candy machine. Gives action choices to user, and allows input. Only delivers the selected candy 
when enough money is inserted. Allows coin return.
 */
import java.util.Scanner;
public class CandyMachine {

    static double credit = 0.0;
    static double snickersPrice = 0.75;
    static double butterFingerPrice = 0.30;
    static double milkyWayPrice = 0.90;
    static int nickelCount = 5;
    static int dimeCount = 7;
    static int quarterCount = 5;
    static int dollarCount = 0;
    static int enterCoin = 0;
    static int snickers = 5;
    static int butterFinger = 5;
    static int milkyWay = 0;
   
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // variables!!!!!!!!!!!!!!!!!!!
        Scanner input = new Scanner(System.in);
        boolean feedMe = true; // pls remember to change this
        int product = 0; // what the user wants to eat
        
         
        // endless while loop????????? menu begin
        while (feedMe = true)
            System.out.println("credit: $" + credit + 
                    "\nEnter a menu item" +
                    "\n0. Snickers...$0.75 \n1. Milky Way...$1.00 \n2. Butterfinger...$1.25" +
                    "\n3. Enter coins \n4. Change Return");
            
            product = input.nextInt();
           
            switch (product) {
                case 0: {
                    if (credit >= 0.75 && snickers >= 1) {
                        
                    System.out.println("Here's your snickers");
                    vend(.075);
                    snickers --;     
                }
                    else if (credit >= 0.75 &&  snickers == 0) {
                    vend("snickers");
                    
                }
                    
                    else 
                       System.out.println("Please insert more money.");
                }
                    
                case 1: {
                    if (credit >= 0.75 && milkyWay >= 1) {
                        
                    System.out.println("Here's your milky way");
                    snickers --;     
                }
                    else if (credit >= 0.75 &&  milkyWay == 0) {
                    vend("milky way");
                    
                }
                    
                    else 
                       System.out.println("Please insert more money.");
                    
                }
                    
                case 2: {
                    if (credit >= 0.75 && butterFinger >= 1) {
                        
                    System.out.println("Here's your butterfinger");
                    snickers --;     
                }
                    else if (credit >= 0.75 &&  butterFinger == 0) {
                    vend("butterfinger");
                    
                }
                    
                    else 
                       System.out.println("Please insert more money.");
                    
                }
                    
                case 3: {
                    System.out.println("Please insert a coin: \n0. insert nickel\n1. insert dime"
                        + "\n2. insert quarter \n3.insert dollar \n4.cancel");
        
                    enterCoin = input.nextInt();
                    
                }
                
                case 4: {
                    System.out.println("Change owed to you: $" + credit);
                    
                }
                
                default:
                    System.out.println("try again dumbdumb");
            
            
            
        }
        
        
             
            
            
            
            
            
        
        
        
            
            
       
        
    }
    
    public static void insertMoney(int num1) {
        Scanner input = new Scanner(System.in);
        
        
        // insert money
        
        
        
        switch (enterCoin) {
            case 0: {
                credit += 0.05;
                nickelCount++;
            }
            
            case 1: { 
                credit += 0.10;
                dimeCount++;
            }
             
            case 2: {
                credit += 0.25;
                quarterCount++;
            }
            
                
            case 3: {
                credit += 1.00;
                dollarCount++;
            }
            
            case 4: ;
            
        }
            
        
    }
    
    public static void vend(String msg) {
        
        
        
        System.out.println("Sold out of" + msg);
                
        
    }
    
    public static void vend(double cost){
        
        credit -= cost;
        
        
    }
    
    public double changeReturn(double blah) {
        credit = 0;
        
    // change return!    
    
    }
    
}

    
    

