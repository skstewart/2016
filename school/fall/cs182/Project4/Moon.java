/*
Name: Shayna Stewart
Date: 11/3/16
Project 4 COMPSCI 182 LAB BeamMeUp
Description: Creates Moon objects and assigns to one Kirk's Macho. Player jumps through the moons entering
passcode and moon name correctly through a push of the stack, or returns to previous moon through a pop of
the stack. Upon finding the macho, they must return to the enterprise by popping the way they came. In order to
win, the stack must be empty, the Macho must be achieved, and they must have reached the enterprise (making it
assigned to the current variable.) 

Moon Class Description: Creates a Moon object, allows passcode to be assigned and retrieved, as well as moon name. 
If it contains the Macho, randomly assigned in the Project4 constructor, then boolean containsMacho is set to true.
containsMacho is set to false upon achieving the Macho (by entering the Moon in project4 (by making it the current))

 */

/**
 *
 * @author Shayna
 */
import java.util.*;
public class Moon {

    private String moonName = null;
    private String passCode = null;
    private boolean containsMacho = false;
    
    public Moon(String moon){ //moon constructor, creates a moon object and sets the moon name and the passcode.
    moonName = moon;
    
    }

    public Moon() { //blank constructor, creates a new moon object but does not set any variables.
    }
    
    
    
    
    
    public boolean containsMacho(){
    return containsMacho;
    }
    
    public void setMacho(boolean macho){
    containsMacho = true;
    }
    
    public void setMoonName(String moon){ //sets the name of the moon
    moonName = moon;
    }
    
    public String getMoonName(){ //returns the name of the moon
    return moonName;
    }
    
    public void setPassCode(String pass){ //only sets if 4 digits
    passCode = pass;
    }
    
    public String getPassCode(){ //returns the passcode currently set to the moon object
    return passCode;
    }
    
     @Override
    public String toString() { //returns the name of the moon object and the passcode set to that moon object.
        
            return moonName + " " + passCode;
        

    }
    
}
