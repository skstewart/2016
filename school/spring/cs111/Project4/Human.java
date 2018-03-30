/*
Name: Shayna Stewart
Date: 5/5/16
Project 4
Description: Program that simulates infestation of agents attacking 
humans and procreating. Simulation ends when all humans have been killed, or 
when all agents have been killed.
 */

public class Human {

    public static int humanCount = 15;
    boolean alive = true;
    int xPosition;
    int yPosition;
    private String weapon;
    private String type;
    private String name;

    Human() {

    }

    Human(String name, String type, String weapon, int xPosition, int yPosition) {
        this.name = name;
        this.weapon = weapon;
        this.type = type;
        this.xPosition = xPosition; //800x600
        this.yPosition = yPosition;

    }

    public String getWeapon() {
        return weapon;
    }

    public void setStatus(boolean status) {
        alive = status;
    }

    public void setXPosition(int x) {
        if (x >= 0 && x <= 800) {
            xPosition = x;
        }

    }

    public void setYPosition(int y) {
        if (y >= 0 && y <= 600) {
            yPosition = y;
        }
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public boolean getStatus() {
        return alive;
    }

    public String getName() {

        return name;
    }

    public String getType() {

        return type;
    }

    @Override
    public String toString() {
        return "Human " + type + name + " is at " + xPosition + " , " + yPosition + ".";

    }

    public boolean attack(Agent agent) {
        agent.setStatus(false);

        return false;
    }

    public void move(int x, int y) {
        if (xPosition < 795 && yPosition < 595) {

            xPosition += x;
            yPosition += y;
        } else if (xPosition < 750 && yPosition > 550) {
            xPosition += x;
            yPosition = 0;
            yPosition += y;
        } else if (xPosition > 750 && yPosition < 550) {
            xPosition = 0;
            xPosition += x;
            yPosition += y;

        } else {
            xPosition = 0;
            xPosition += x;
            yPosition = 0;
            xPosition += y;
        }
    }
}
