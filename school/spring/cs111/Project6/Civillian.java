/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shayna
 */
public class Civillian extends Human {

    Civillian(String name, String weapon, int xPosition, int yPosition) {
        
        setName(name);
        setWeapon(weapon);
        setXPosition(xPosition);
        setYPosition(yPosition);

    }

    
    @Override
    public void attack(Actor object) {
        if (getName() == "miz"){
        System.out.println("AAAAAAAWESSOMMEMEE");
        }
        System.out.println("The civillian attempted to attack, and failed.");
        setStatus(false);
        
    }
    
    @Override
    public String toString() {
        return "Civillian " + getName() + " is at " + getXPosition() + " , " + getYPosition() + ".";

    }
    
}


