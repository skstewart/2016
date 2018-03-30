/**
 * Name: Shayna Stewart
 * Date: 12/1/16
 * CS182 Lab Project 6: Hash Crash
 * Description: Creates DataItem objects. The DataItem objects contain integer value iData, which is the key created
 * by hashing the String name into an integer value. The String name value is the name of the item before being hashed,
 * which is used for display purposes. Methods getName and getKey return the name
 * value and the iData values respectively. Also contains methods setting and returning fields for the position
 * in the hash array, as well as where the item should have been provided there hadn't been a collision.
 * 
 * */


////////////////////////////////////////////////////////////////

class DataItem {                                // (could have more data)

    private int iData;               // data item (key)
    private String name;            // name 
    private int hashTablePosition; // where the item actually is in the hash table
    private int collided; // where the item collided in the hash table (if applicable)
   
//--------------------------------------------------------------
    public int getPosition(){
    return hashTablePosition;
    }
    public int whereItCollided(){
    return collided;
    }
    
    public void setPosition(int pos){
    hashTablePosition = pos;
    }
    
    public void setWhereItShouldBe(int pos){
    collided = pos;
    }

    public DataItem(int ii, String n) // constructor
    //edited to take both key value AND name value for storage and comparison 
    {
        iData = ii;
        name = n;

    }

    public String getName() { //returns the name variable (String)
        return name;
    }

//--------------------------------------------------------------
    public int getKey() { //returns the iData variable (int)
        return iData;
    }
//--------------------------------------------------------------
}  // end class DataItem
