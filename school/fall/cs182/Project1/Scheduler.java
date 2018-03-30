
import javax.swing.JOptionPane;


/**
 * Name: Shayna Stewart
 * Date last modified: 9/22/16
 * What: CS 182 Lab Project 1
 * Description: Creates schedule object, adds delivery objects, shifts delivery objects, deletes delivery objects
 */
public class Scheduler {

    private Delivery delivery[] = new Delivery[20];

    private int count;
    //UserInput input = new UserInput();

    public static void main(String[] args) {
        String userBet = JOptionPane.showInputDialog("Enter a bet");

        Integer bet = Integer.valueOf(userBet);
        
            
        
        Scheduler scheduler = new Scheduler();
        scheduler.run();
    }

    Scheduler() {

        delivery[0] = new Delivery("mar", 3, 4, 17, 30, "Pizza");
        delivery[1] = new Delivery("apr", 4, 1, 6, 30, "Special Delivery");
        delivery[2] = new Delivery("may", 5, 6, 12, 00, "Amazon (books)");
        delivery[3] = new Delivery("jun", 6, 3, 11, 15, "Car Parts");
        count = 3;

    }

    public void run() {
        System.out.println("Menu:"
                + "\nA)dd Delivery"
                + "\nD)elete Delivery"
                + "\nL)ist Delivery"
                + "\nE)xit");

        switch (UserInput.getChar()) {
            case 'A': {
                addDelivery();
                break;
            }
            case 'a': {
                addDelivery();
                break;
            }

            case 'D': {
                deleteDelivery();
                break;
            }
            case 'd': {
                deleteDelivery();
                break;
            }
            case 'L': {
                listDelivery();
                break;
            }
            case 'l': {
                listDelivery();
                break;
            }
            case 'E': {
                System.exit(0);
            }
            case 'e': {
                System.exit(0);
                break;
            }
            default:
                run();
        }

    }

    public void insertDelivery(Delivery A1) {
        count++;

        for (int i = 0; i < count + 1; i++) {
            if (delivery[i] == null) {
                delivery[i] = A1;
            } else if (compareDelivery(A1, delivery[i])) {
                Delivery temp = delivery[i];
                delivery[i] = A1;
                A1 = temp;
            }
        }

        run();
    }

    public void listDelivery() {
        for (int d = 0; d < delivery.length; d++) {
            if (delivery[d] != null) {
                System.out.println(d + ": " + delivery[d]);
            }

        }
        run();
    }

    public boolean compareDelivery(Delivery A1, Delivery A2) {

        if (A1.getMonthNum() < A2.getMonthNum()) {
            return true;
        } else if (A1.getMonthNum() == A2.getMonthNum() && A1.getDay() < A2.getDay()) {
            return true;
        } else if (A1.getMonthNum() == A2.getMonthNum() && A1.getDay() == A1.getDay() && A1.getHour() < A2.getHour()) {
            return true;
        } else if (A1.getMonthNum() == A2.getMonthNum() && A1.getDay() == A1.getDay() && A1.getHour() == A2.getHour() && A1.getMinute() < A2.getMinute()) {
            return true;
        } else {
            return false;
        }
    }

    public void deleteDelivery() {
        System.out.println("Enter Item to be deleted.");
        int deleteItem = UserInput.getInt(0, 19);
        for (int i = deleteItem; i <= count - 1; i++) {
            if (delivery != null) {
                delivery[i] = delivery[i + 1];
            }
        }
        delivery[count] = null;
        count--;
        run();
    }

    public void addDelivery() {
        Delivery newDelivery = new Delivery();
        newDelivery.inputDelivery();
        insertDelivery(newDelivery);
    }

}
