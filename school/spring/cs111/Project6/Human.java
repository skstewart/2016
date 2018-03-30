/*
Name: Shayna Stewart
Date: 5/19/16
Project 6
Description: Program that simulates infestation of agents attacking 
humans and procreating. Simulation ends when all humans have been killed, or 
when all agents have been killed.
 */

public abstract class Human extends Actor  {

    public static int humanCount = 17;
    private static int xPosition;
    private static int yPosition;
    private static String weapon;
    private String type;
    private String name;

    Human() {

    }

    
    
    public void setName(String humanName){
    name = humanName;
    }

    public String getName() {

        return name;
    }

    public String getType() {

        return type;
    }

    @Override
    public String toString() {
        return "Human " + name + " is at " + getXPosition() + " , " + getYPosition() + ".";

    }
    
   public void attack(Actor agent) {
        agent.setStatus(false);

    }

}
