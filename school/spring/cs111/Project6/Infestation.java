/*
Name: Shayna Stewart
Date: 5/19/16
Project 6
Description: Program that simulates infestation of agents attacking 
humans and procreating. Simulation ends when all humans have been killed, or 
when all agents have been killed.
 */
import java.util.Random;

public class Infestation {

    static int humanCount = 17;
    static int agentCount = 4;

    public static void main(String[] args) {

        Random rand = new Random();

        Agent agent[] = new Agent[4];
        agent[0] = new Agent("Morgause", "claws", rand.nextInt(800), rand.nextInt(600));
        agent[1] = new Agent("Morgana", "teeth", rand.nextInt(800), rand.nextInt(600));
        agent[2] = new Agent("Evil Mordred", "heartbreak and betrayal :(", rand.nextInt(800), rand.nextInt(600));
        agent[3] = new Agent("Merlin", "magic", rand.nextInt(800), rand.nextInt(600));

        Human human[] = new Human[23];
        human[0] = new Knight("Galahad", "sword", rand.nextInt(800), rand.nextInt(600));
        human[1] = new Knight("Ywain", "sword", rand.nextInt(800), rand.nextInt(600));
        human[2] = new Knight("Gawain", "sword", rand.nextInt(800), rand.nextInt(600));
        human[3] = new Knight("Lancelot", "lance", rand.nextInt(800), rand.nextInt(600));
        human[4] = new Knight("Geraint", "sword", rand.nextInt(800), rand.nextInt(600));
        human[5] = new Knight("Percival", "sword", rand.nextInt(800), rand.nextInt(600));
        human[6] = new Knight("Bors the Younger", "sword", rand.nextInt(800), rand.nextInt(600));
        human[7] = new Knight("Lamorak",  "sword", rand.nextInt(800), rand.nextInt(600));
        human[8] = new Knight("Kay", "sword", rand.nextInt(800), rand.nextInt(600));
        human[9] = new Knight("Gareth",  "sword", rand.nextInt(800), rand.nextInt(600));
        human[10] = new Knight("Bedivere",  "sword", rand.nextInt(800), rand.nextInt(600));
        human[11] = new Knight("Gaheris", "sword", rand.nextInt(800), rand.nextInt(600));
        human[12] = new Knight("Tristan", "sword", rand.nextInt(800), rand.nextInt(600));
        human[13] = new Knight("Mordred", "sword", rand.nextInt(800), rand.nextInt(600));
        human[14] = new King("Arthur", "Excalibur", rand.nextInt(800), rand.nextInt(600), "gold");
        human[15] = new Civillian("Meister Cobalt", "deadly fists", rand.nextInt(800), rand.nextInt(600));
        human[16] = new Civillian("Sephiroth", "Masamune", rand.nextInt(800), rand.nextInt(600));
        human[17] = new Knight("Sydney Losstarot", "blood rood", rand.nextInt(800), rand.nextInt(600));
        human[18] = new Civillian("Balthazar", "fire breath", rand.nextInt(800), rand.nextInt(600));
        human[19] = new Civillian("Bob", "stick", rand.nextInt(800), rand.nextInt(600));
        human[20] = new Civillian("Azul", "broadsword", rand.nextInt(800), rand.nextInt(600));
        human[21] = new Civillian("Jeff Carter", "hockey stick", rand.nextInt(800), rand.nextInt(600));
        human[22] = new King("Richard III", "", rand.nextInt(800), rand.nextInt(600), "silver");
        
       

        while (agentCount > 0 && humanCount > 0) {
            for (int x = 0; x < 23; x++) {

                if (human[x].getStatus() == true) {
                    human[x].move(rand.nextInt(50), rand.nextInt(50));
                    System.out.println(human[x].toString());
                }

                for (int i = 0; i < 4; i++) {

                    if (human[x].getStatus() == true && agent[i].getStatus() == true && Math.abs(agent[i].getXPosition() - human[x].getXPosition()) <= 50 && Math.abs(agent[i].getYPosition() - human[x].getYPosition()) <= 50) {

                        agent[i].attack(human[x]);
                        
                        System.out.println(agent[i].getId() + " attacked " +  human[x].getName() + " with their " + agent[i].getWeapon() + " and killed them.");
                        humanCount--;

                        System.out.println("Human " + human[x].getName() + " is dead.");

                    }
                    agent[i].move(human[x].getXPosition(), human[x].getYPosition());

                    if (human[x].getStatus() == true && agent[i].getStatus() == true && Math.abs(human[x].getXPosition() - agent[i].getXPosition()) <= 25 && Math.abs(human[x].getYPosition() - agent[i].getYPosition()) <= 25) {
                        human[x].attack(agent[i]);

                        System.out.println(human[x].getName() + " attacked " + agent[i].getId() + " with their " + human[x].getWeapon() + " and killed them.");
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
