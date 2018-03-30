/*
Name: Shayna Stewart
Date last modified:
Date due: 3 November, 2016
CS182 Lab Project 4
Description: Stack class that makes array of Moon objects, and contains functions to push, pop, peek, and delete. 
Stack is used in Project4 to keep track of moons traversed. The current is not added to the top of the stack 
until user pushes to another moon. 
 */

/**
 *
 * @author Shayna
 */
public class Stack {

    private Moon[] moonArray;
    private int top;
    private int size;

    public Stack() { //constructor
        moonArray = new Moon[20];
        top = -1;

    }

    public Moon[] getMoonArray() {
        return moonArray;
    }

    public int getTop() {
        return top;
    }

    public void push(Moon moon) { //push Moon object onto top of Stack
        //push it push it to the limit limit
        moonArray[++top] = moon;
    }

    public void empty() { //delete entire Stack
        moonArray = null;
        top = -1;
    }

    public Moon pop() { //Return top Moon object, delete from top of stack

        return moonArray[top--];
        
    }

    public Moon peek() { //Return top Moon object, but don't delete from top of stack
        return moonArray[top];
    }

    /*public void dump() {
        if (top > 0) {
            for (int x = 0; x == top; x++) {
                System.out.println(moonArray[x].getMoonName() + " " + moonArray[x].getPassCode());
            }
        } else if (top == 0) {
            System.out.println(moonArray[0].getMoonName() + " " + moonArray[0].getPassCode());
        } else {
            System.out.println("Stack empty");
        }
    } */

    @Override
    public String toString() { //sounds amount of items in stack
        return "Stack contains " + top+1 + "items.";
    }
}
