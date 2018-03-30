/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shayna
 */
public class Knight extends Human implements BattleCry {

    Knight(String name, String weapon, int xPosition, int yPosition) {

        setName(name);
        setWeapon(weapon);
        setXPosition(xPosition);
        setYPosition(yPosition);

    }

    @Override
    public String battleCry() {
        if (getName() == "Mordred") {
            return "Weapons drawn and steel sharp, smiting our foes iTS THE D O DOUBLE G SNOOP DOGG WOOLOOLOOLOO!";
        } else if (getName() == "Sydney Losstarot") {
            return "Have a little more respect for Faerie Tales.";
        }
        else {
            return "Weapons drawn and steel sharp, smiting our foes is the holy art.";
    }
}

@Override
        public String toString() {
        return "Knight " + getName() + " is at " + getXPosition() + " , " + getYPosition() + ".";

    }

    @Override
        public void attack(Actor agent) {
        System.out.println("Knight " + getName() + " yells " + battleCry());
        agent.setStatus(false);
    }

}
