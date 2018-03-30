/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shayna
 */
public class King extends Human implements BattleCry {

    King(String name, String weapon, int xPosition, int yPosition, String crown) {
        String crownColor = crown;
        setName(name);
        setWeapon(weapon);
        setXPosition(xPosition);
        setYPosition(yPosition);

    }
    @Override
    public String battleCry() {
        if (getName() == "Richard III"){
            return "Loyaulte me.";
            
                }
        else {
            return "Engarde!";
        
        }
        

    }
    
    @Override
    public void attack(Actor actor){
    System.out.println("King " + getName() + " yells " + battleCry());
    actor.setStatus(false);
    }
    
    @Override
    public String toString() {
        return "King " + getName() + " is at " + getXPosition() + " , " + getYPosition() + ".";

    }

}
