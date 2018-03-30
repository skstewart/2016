/**
 * Name: Shayna Stewart
 * Date: 12/1/16
 * CS182 Lab Project 6: Hash Crash
 * Description: Creates a HashTable object, which contains an array of DataItems called hashArray, the int
 * value arraySize which contains the size of the array (starts at -1 to signify that it has not been created yet), and
 * the DataItem object nonItem which is used for deleted items. 
 * Contains methods for inserting DataItem objects into the array, deleting items from the array, finding an element
 * in the array by using a key, and hashing keys to fill spaces within the array. Also contains a method to convert
 * a String value into an integer value to be used as a key.
 * Also added into the insert method is insertion into an array holding all of the crashes.
 */


class HashTable {

    private DataItem[] hashArray;    // array holds hash table
    private int arraySize = -1;
    private DataItem nonItem;        // for deleted items
    private DataItem[] collisionArray = new DataItem[92];
    private int collisions = -1;
  
// -------------------------------------------------------------
    public HashTable(){
    arraySize = -1;
    hashArray = null;
    }
    public HashTable(int size) // constructor
    {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1, null);   // deleted item key is -1
    }
// -------------------------------------------------------------

    public DataItem[] getTable() { //returns the array containing DataItem objects
        return hashArray;
    }
    
     public DataItem[] getCollisions() { //returns the array containing the collisions
        return collisionArray;
    }
     
     public int getCollisionCount(){
     return collisions + 1;
     }

    public int getArraySize() { //returns the int value of the size of the array
        return arraySize;
    }

    public void displayTable() {
        System.out.print("Table: ");
        for (int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null) {
                System.out.print(hashArray[j].getKey() + " ");
            } else {
                System.out.print("** ");
            }
        }
        System.out.println("");
    }
// -------------------------------------------------------------

    public int hashFunc(int key) {
        return key % arraySize;       // hash function
    }
// -------------------------------------------------------------

    public void insert(DataItem item) // insert a DataItem
    // (assumes table not full)
    {
        int key = item.getKey();      // extract key
        int hashVal = hashFunc(key);  // hash the key
        item.setWhereItShouldBe(hashVal);
        // until empty cell or -1,
        while (hashArray[hashVal] != null
                && hashArray[hashVal].getKey() != -1) {
            ++hashVal;                 // go to next cell
            hashVal %= arraySize;      // wraparound if necessary
        }
        item.setPosition(hashVal);
        hashArray[hashVal] = item;    // insert item
        if (item.whereItCollided() != item.getPosition()){
        collisionArray[++collisions] = item;
        }
    }  // end insert()
// -------------------------------------------------------------

    public DataItem delete(int key) // delete a DataItem
    {
        int hashVal = hashFunc(key);  // hash the key

        while (hashArray[hashVal] != null) // until empty cell,
        {                               // found the key?
            if (hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal]; // save item
                hashArray[hashVal] = nonItem;       // delete item
                return temp;                        // return item
            }
            ++hashVal;                 // go to next cell
            hashVal %= arraySize;      // wraparound if necessary
        }
        return null;                  // can't find item
    }  // end delete()

    public int findRealKey(int key) // find item with key
    {
        int hashVal = hashFunc(key);  // hash the key

        while (hashArray[hashVal] != null) // until empty cell,
        {                               // found the key?
            if (hashArray[hashVal].getKey() == key) {
                return hashVal;   // yes, return item
            }
            ++hashVal;                 // go to next cell
            hashVal %= arraySize;      // wraparound if necessary
        }
        return -1;                  // can't find item
    }

// -------------------------------------------------------------
    public DataItem find(int key) // find item with key
    {
        int hashVal = hashFunc(key);  // hash the key

        while (hashArray[hashVal] != null) // until empty cell,
        {                               // found the key?
            if (hashArray[hashVal].getKey() == key) {
                return hashArray[hashVal];   // yes, return item
            }
            ++hashVal;                 // go to next cell
            hashVal %= arraySize;      // wraparound if necessary
        }
        return null;                  // can't find item
    }

    ////////////////////////////////////////////////////////////////  
    public int hashFunc3(String key) {
        int hashVal = 0;
        for (int j = 0; j < key.length(); j++) // left to right
        {
            int letter = key.charAt(j) - 96;  // get char code
            hashVal = (hashVal * 27 + letter) % arraySize; // mod
        }
        return hashVal;                      // no mod
    }  // end hashFunc3()
////////////////////////////////////////////////////////////////

// -------------------------------------------------------------
}  // end class HashTable
////////////////////////////////////////////////////////////////

