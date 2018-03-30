/*Name: Shayna Stewart
 * Date: 11/22/16
 * CS182 Lab Project 5
 * Description: Creates Node objects, which are pieces of data contained by the tree. Contain idata (int data used as
a key), dData (data in the form of a double), and the Node's leftChild and rightChild (or lack thereof).
Also contains boolean findIt, and methods getFind and setFind, which are used to set the node to be found, if it matches the 
key value entered by the user. If it is the node that is to be found, boolean findIt is set to true, which is used
in class Tree to paint the node red.
 */

class Node {

    public boolean findIt = false; // if the node is the one the user wants to find on the screen
    public int iData;              // data item (key)
    public double dData;           // data item
    public Node leftChild;         // this node's left child
    public Node rightChild;        // this node's right child

    public boolean getFind() {

        return findIt; //whether the node is to be found or not
    }

    public void setFind(boolean find) {
        findIt = find; //set the node to be found or not
    }

    public void displayNode() // display ourself
    {
        System.out.print('{');
        System.out.print(iData);
        System.out.print(", ");
        System.out.print(dData);
        System.out.print("} ");
    }
}  // end class Node
