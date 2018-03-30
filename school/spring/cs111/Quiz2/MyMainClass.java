/*
Name: Shayna Stewart
Date: 5/31/16
Quiz 2
Description: Main class that contains main method (in which a loop runs 4 times, a 2-element array of objects
is created, and method4() is called) and method4() which calls method() from MyAbstractSuperClass.
 */
import java.util.*;

public class MyMainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rand = new Random();
        int randomInt = rand.nextInt(2);
        MyAbstractSuperClass subClass[] = new MyAbstractSuperClass[2];
        subClass[0] = new MySubClass();
        subClass[1] = new MySubClass2();
        for (int x = 0; x < 10; x++) {
            subClass[randomInt].method2();
        }

        method4(subClass[randomInt]);
    }

    public static void method4(MyAbstractSuperClass object) {
        MyAbstractSuperClass.method();

    }

}
