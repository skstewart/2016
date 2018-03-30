/*
Name: Shayna Stewart
Date: 5/5/16
Project 4
Description: Program that simulates infestation of agents attacking 
humans and procreating. Simulation ends when all humans have been killed, or 
when all agents have been killed. 
 */

public class Agent {

    boolean alive = true;
    public static int agentCount = 4;
    private int xPosition;
    private int yPosition;
    private String weapon;
    private String id;

    Agent() {

    }

    Agent(String id, String weapon, int xPosition, int yPosition) {
        this.id = id;
        this.xPosition = xPosition; //800x600
        this.yPosition = yPosition;
        this.weapon = weapon;
    }

    public String getId() {
        return id;

    }

    public String getWeapon() {
        return weapon;
    }
    

    public void setXPosition(int x) {
        if (x >= 0 && x <= 800) {
            xPosition = x;
        }

    }

    public boolean getStatus() {
        return alive;
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

    @Override
    public String toString() {

        if (alive == true) {
            return "Agent " + id + " is at " + xPosition + " , " + yPosition + ".";

        } else {
            return "Agent " + id + " is dead.";

        }
    }

    public boolean attack(Human human) {

        human.setStatus(false);
        return false;

    }

    public void setStatus(boolean status) {
        alive = status;
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
