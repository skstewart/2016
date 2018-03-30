/*
Name: Shayna Stewart
Date: 5/19/16
Project 6
Description: Program that simulates infestation of agents attacking 
humans and procreating. Simulation ends when all humans have been killed, or 
when all agents have been killed. 
 */

public abstract class Actor {
    boolean alive = true;
    private int xPosition;
    private int yPosition;
    private String weapon;
    

    public static void main(String[] args) {

    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
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

    public void setStatus(boolean status) {
        alive = status;
    }

    public abstract String toString();

    

    public void move(int x, int y) {
        if (xPosition < 750 && yPosition < 550) {

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
