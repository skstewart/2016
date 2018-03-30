/*
Name: Shayna Stewart
Date: 5/19/16
Project 6
Description: Program that simulates infestation of agents attacking 
humans and procreating. Simulation ends when all humans have been killed, or 
when all agents have been killed. 
 */

public class Agent extends Actor {

    public static int agentCount = 4;
    
    private static int xPosition;
    private static int yPosition;
    private static String weapon;
    private String id;

    Agent() {

    }

    Agent(String id, String weapon, int xPos, int yPos) {
        this.id = id;

        setXPosition(xPos);
        setYPosition(yPos);
        setWeapon(weapon);
    }

    
    public void attack(Actor human) {

        human.setStatus(false);
        
    }

    public String getId() {
        return id;

    }

    @Override
    public String toString() {

        if (alive == true) {
            return "Agent " + id + " is at " + getXPosition() + " , " + getYPosition() + ".";

        } else {
            return "Agent " + id + " is dead.";

        }
    }

}
