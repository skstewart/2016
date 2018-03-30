/*
Name: Shayna Stewart
Date: 5/5/16
Project 4
Description: Program that simulates infestation of agents attacking 
humans and procreating. Simulation ends when all humans have been killed, or 
when all agents have been killed.
 */
import java.util.Random;

public class Infestation {

    static int humanCount = 15;
    static int agentCount = 4;

    public static void main(String[] args) {

        Random rand = new Random();

        Agent agent[] = new Agent[4];
        agent[0] = new Agent("Morgause", "claws", rand.nextInt(800), rand.nextInt(600));
        agent[1] = new Agent("Morgana", "teeth", rand.nextInt(800), rand.nextInt(600));
        agent[2] = new Agent("Evil Mordred", "heartbreak and betrayal :(", rand.nextInt(800), rand.nextInt(600));
        agent[3] = new Agent("Merlin", "magic", rand.nextInt(800), rand.nextInt(600));

        Human human[] = new Human[15];
        human[0] = new Human("Galahad", "Knight ", "sword", rand.nextInt(800), rand.nextInt(600));
        human[1] = new Human("Ywain", "Knight ", "sword", rand.nextInt(800), rand.nextInt(600));
        human[2] = new Human("Gawain", "Knight ", "sword", rand.nextInt(800), rand.nextInt(600));
        human[3] = new Human("Lancelot", "Knight ", "sword", rand.nextInt(800), rand.nextInt(600));
        human[4] = new Human("Geraint", "Knight ", "sword", rand.nextInt(800), rand.nextInt(600));
        human[5] = new Human("Percival", "Knight ", "sword", rand.nextInt(800), rand.nextInt(600));
        human[6] = new Human("Bors the Younger", "Knight ", "sword", rand.nextInt(800), rand.nextInt(600));
        human[7] = new Human("Lamorak", "Knight ", "sword", rand.nextInt(800), rand.nextInt(600));
        human[8] = new Human("Kay", "Knight ", "sword", rand.nextInt(800), rand.nextInt(600));
        human[9] = new Human("Gareth", "Knight ", "sword", rand.nextInt(800), rand.nextInt(600));
        human[10] = new Human("Bedivere", "Knight ", "sword", rand.nextInt(800), rand.nextInt(600));
        human[11] = new Human("Gaheris", "Knight ", "sword", rand.nextInt(800), rand.nextInt(600));
        human[12] = new Human("Tristan", "King ", "sword", rand.nextInt(800), rand.nextInt(600));
        human[13] = new Human("Mordred", "Knight ", "sword", rand.nextInt(800), rand.nextInt(600));
        human[14] = new Human("Arthur", "King ", "Excalibur", rand.nextInt(800), rand.nextInt(600));

        while (agentCount > 0 && humanCount > 0) {
            for (int x = 0; x < 15; x++) {

                if (human[x].getStatus() == true) {
                    human[x].move(rand.nextInt(50), rand.nextInt(50));
                    System.out.println(human[x].toString());
                }

                for (int i = 0; i < 4; i++) {

                    if (human[x].getStatus() == true && agent[i].getStatus() == true && Math.abs(agent[i].getXPosition() - human[x].getXPosition()) <= 50 && Math.abs(agent[i].getYPosition() - human[x].getYPosition()) <= 50) {

                        agent[i].attack(human[x]);
                        System.out.println(agent[i].getId() + " attacked " + human[x].getType() + human[x].getName() + " with their " + agent[i].getWeapon() + " and killed them.");
                        humanCount--;

                        System.out.println("Human " + human[x].getType() + human[x].getName() + " is dead.");

                    }
                    agent[i].move(human[x].getXPosition(), human[x].getYPosition());

                    if (human[x].getStatus() == true && agent[i].getStatus() == true && Math.abs(human[x].getXPosition() - agent[i].getXPosition()) <= 25 && Math.abs(human[x].getYPosition() - agent[i].getYPosition()) <= 25) {
                        human[x].attack(agent[i]);

                        System.out.println(human[x].getType() + human[x].getName() + " attacked " + agent[i].getId() + " with " + human[x].getWeapon() + " and killed them.");
                        agentCount--;

                        System.out.println("Agent " + agent[i].getId() + " is dead.");
                    }

                }
            }
        }

        if (humanCount == 0) {
            System.out.println("All humans have been defeated.");

        } else if (agentCount == 0) {
            System.out.println("All agents have been defeated.");
        }

    }

}
