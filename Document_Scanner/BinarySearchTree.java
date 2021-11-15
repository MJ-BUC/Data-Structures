package CSCE210.Document_Scanner;

public class BinarySearchTree {

    private BinarySearchTreeNode root;
    private BinarySearchTreeNode cursor;
    private BinarySearchTreeNode cursor2;
    private Boolean FindParentFlag = false;             //used to determine if findparent is being used in delete.
    LinkedList myList = new LinkedList();               //creates a global linked list to use for tracking the max word

    public BinarySearchTree(String key) {               //BST constructor that takes a key for the argument aka the word from the text file
        BinarySearchTreeNode newnode = new BinarySearchTreeNode(key);
        root = newnode;
       
    }

    public BinarySearchTree() {                         //seperate empty constructor
        
    }

    public int HashGenerator(String key) {              //generates the hash of a string word. Really good at avoiding collisions.
        double hash = 0.0;
        int base;
        int power;
        for (int i=0; i<key.length(); i++) {
        base = (int)key.charAt(i)-96;
        power = (i==0)?3:2;
        hash += Math.pow(base, power)*Math.PI/(i+1);
        }
        return (int)(hash*Math.E*5/key.length());
    }

    public void Insert(BinarySearchTreeNode parentNode, BinarySearchTreeNode newnode, String key) {         //insert method that gets called in the insert method below

        if (root == null) {                                             //inserting when the root is null aka an empty BST
            root = newnode;
        }
        else {
            int hash = HashGenerator(parentNode.getValue());            //saves the hash of the key's parent node
            if (HashGenerator(newnode.getValue()) < hash) {             //insert left of the parent when the newnode is less than the parent
                if (cursor.getLeftNode() != null && cursor.getLeftNode().getValue().equals(key)) {
                    newnode.setLeftNode(parentNode.getLeftNode());
                    parentNode.setLeftNode(newnode);
                }
                else {
                parentNode.setLeftNode(newnode);
                }
            }
            else if (HashGenerator(newnode.getValue()) > hash) {        //insert right og the parent when the newnode is greater than the parent
                if (cursor.getRightNode() != null && cursor.getRightNode().getValue().equals(key)) {
                    newnode.setRightNode(parentNode.getRightNode());
                    parentNode.setRightNode(newnode);
                }
                else {
                parentNode.setRightNode(newnode);
                }
            }
            else {
                parentNode.setLeftNode(newnode);                        //if the node is the same as the parent then it can be inserted to the left of the parent
            }
        }
    }

    public void Insert(String key) {            //This is the main insert method. this program uses method overloading where this method calls the one above
        cursor = root;
        BinarySearchTreeNode newnode = new BinarySearchTreeNode(key);           //creates a new node to be inserted in the BST
        BinarySearchTreeNode parentNode = FindParent(key);                      //saves the parent node of the current key
        Insert(parentNode, newnode, key);            //call to the function above to insert the node to the left or right of the parent node
    }

    public BinarySearchTreeNode FindParent(String key) {            //finds the parent of a node or newnode by using the current key
        if (root == null) {                                         //returns null when the BST is empty
            return null;
        }
        else if (HashGenerator(key) < HashGenerator(root.getValue())) {             //searches for the parent down the left subtree when hash of key is less than the root's hash
            if (FindParentFlag == true && cursor.getLeftNode() != null && cursor.getLeftNode().getValue().equals(key)) {
                return cursor;
            }
            else if (cursor.getLeftNode() != null && cursor.getLeftNode().getValue().equals(key)) {      //chaining the same word when inserting goes to the last occurrence of word
                cursor = cursor.getLeftNode();
                FindParent(key);
            }
            
            else if (cursor.getLeftNode() != null && cursor.getLeftNode() != Search(key) && HashGenerator(key) < HashGenerator(cursor.getValue())) {
                cursor = cursor.getLeftNode();
                FindParent(key);
            }
            else if (cursor.getRightNode() != null && cursor.getRightNode() != Search(key) && HashGenerator(cursor.getRightNode().getValue()) <= HashGenerator(key)) {
                cursor = cursor.getRightNode();
                FindParent(key);
            }
            else {
                FindParentFlag = false;
                return cursor;
            }
        }

        else if (HashGenerator(key) > HashGenerator(root.getValue())) {             //searches for the parent down the left subtree when the hash of key is greater than the root's hash
            if (cursor.getRightNode() != null && cursor.getRightNode() != Search(key) && HashGenerator(key) > HashGenerator(cursor.getValue())) {
                cursor = cursor.getRightNode();
                FindParent(key);
            }
            else if (cursor != root && cursor.getLeftNode() != null && cursor.getLeftNode() != Search(key) && HashGenerator(key) < HashGenerator(cursor.getValue())) {
                cursor = cursor.getLeftNode();
                FindParent(key);
            }
            else {
                FindParentFlag = false;
                return cursor;
            }
        }
        else if (HashGenerator(key) == HashGenerator(root.getValue())) {            //for finding the parent when the hash of key is equal to the hash of the root
            if (cursor.getLeftNode() != null && cursor.getLeftNode().getValue().equals(root.getValue())) {
                cursor = cursor.getLeftNode();
                FindParent(key);
            }
            else {
                FindParentFlag = false;
                return cursor;
            }
        }
        FindParentFlag = false;
        return cursor;
    }

    public BinarySearchTreeNode Search(String key) {            //searches for a node in the BST using a key aka the word you want to search. returns the nede of the key
        cursor2 = root;
        int h = HashGenerator(key);
        if (root == null) {                                     //if the root is null being an empty BST it returns null
            BinarySearchTreeNode node = cursor2;
            return node;
        }
        else if (h == HashGenerator(cursor2.getValue())) {          //if h == hash of root return the root node
            return cursor2;
        }
        else {
            while (cursor2 != null && !(cursor2.getValue().equals(key)))        //loops through the BST to find the node ehen it is not the root
            {
                if (h < HashGenerator(cursor2.getValue()))                      //gets the left node when the key value is less than the current cursor value
                    cursor2 = cursor2.getLeftNode();
                else if (h > HashGenerator(cursor2.getValue()))                 //gets the right node when the key value is greater than the current cursor value
                    cursor2 = cursor2.getRightNode();
                else if (h == HashGenerator(cursor2.getValue()))                 //gets the right node when the key value is greater than the current cursor value
                    cursor2 = cursor2.getLeftNode();
            }

            return cursor2;
        }
    }

    public int SearchForWord(String key) {            //searches for a node in the BST using a key aka the word you want to search. returns the nede of the key
        cursor2 = root;
        int count = 0;
        int h = HashGenerator(key);
        if (root == null) {                                     //if the root is null being an empty BST it returns 0
            return 0;
        }
        else {
            while (cursor2 != null)        //loops through the BST to find the node ehen it is not the root
            {
                if (cursor2.getValue().equals(key)) {
                    count++;
                }
                if (h < HashGenerator(cursor2.getValue()))                      //gets the left node when the key value is less than the current cursor value
                    cursor2 = cursor2.getLeftNode();
                else if (h > HashGenerator(cursor2.getValue()))                 //gets the right node when the key value is greater than the current cursor value
                    cursor2 = cursor2.getRightNode();
                else if (h == HashGenerator(cursor2.getValue()))                 //gets the right node when the key value is greater than the current cursor value
                    cursor2 = cursor2.getLeftNode();
            }

            return count;
        }
    }

    public void splice(String key) {                                            //deletes a node when it has 0 or 1 children and is not an empty root node
        cursor = root;
        FindParentFlag = true;
        BinarySearchTreeNode node = Search(key);                                //finds the first instance of the node to delete
        BinarySearchTreeNode parentOfNode = FindParent(key);                    //fids the parent of the node

        if (parentOfNode.getRightNode() == node) {                                          //if the node to the right of the parent is correct, delete it
            if (node.getLeftNode() != null && node.GetNumberOfChildren() == 1) {            //checks if the node to delete has a left child and only one child
                parentOfNode.setRightNode(node.getLeftNode());
            }
            else if (node.getRightNode() != null && node.GetNumberOfChildren() == 1) {      //checks if the node to delete has a right child and only one child
                parentOfNode.setRightNode(node.getRightNode());
            }
            else if (node.GetNumberOfChildren() == 0) {                                     //checks for 0 children and deletes the node
                parentOfNode.setRightNode(null);
            }
        }
        else if (parentOfNode.getLeftNode() == node) {                                      //if the node to the left of the parent is correct, delete it
            if (node.getLeftNode() != null && node.GetNumberOfChildren() == 1) {            //checks if the node to delete has a left child and only one child
                parentOfNode.setLeftNode(node.getLeftNode());
            }
            else if (node.getRightNode() != null && node.GetNumberOfChildren() == 1) {      //checks if the node to delete has a right child and only one child
                parentOfNode.setLeftNode(node.getRightNode());
            }
            else if (node.GetNumberOfChildren() == 0) {                                     //checks for 0 children and deletes the node
                parentOfNode.setLeftNode(null);
            }
        }
    }

    public void Delete(String key) {                                    //main delete method to delete the first instance of a node
        cursor = root;
        FindParentFlag = true;
        BinarySearchTreeNode node = Search(key);
        BinarySearchTreeNode parentNode = FindParent(key);
        
        if (node != null) {                                             //error handling for if a node is null
            //deleting the root node of BST
            if (root == null) {                                         //error handling for when the root is null and there BST is empty
                System.out.println("Trying to delete nothing!!");
            }
            else if (parentNode == null) {                                       //error handling for when a parent node is null
                System.out.println("parent is null");
            }
            else if (root == Search(key) && root.GetNumberOfChildren() == 0) {          //when the root is the node to delete and it has no children
                root = null;
            }
            else if (root.GetNumberOfChildren() == 1 && root.getValue().equals(key)) {      //for deleting when the root has 1 child node uses the splice method
                splice(key);
            }
            else if (root.GetNumberOfChildren() == 2 && root.getValue().equals(key)) {      //when the root has 2 child nodes it sets the root value to its smallest right node and deletes the smallest right value
                BinarySearchTreeNode rootSmallestRight = root.getRightNode();
                while (rootSmallestRight.getLeftNode() != null) {                           //loops to find the smallest right value of the root node
                    rootSmallestRight = rootSmallestRight.getLeftNode();
                }
                String rootSmallVal = rootSmallestRight.getValue();                 //holds the smallest right value
                splice(rootSmallestRight.getValue());                       //deletes the smallest right node
                root.setValue(rootSmallVal);                                //sets the root value as the smallest right node's
            }
            
            //deleting when node has 1 child else deletes when node has 2 children
            else if (node.getLeftNode() == null || node.getRightNode() == null) {           //calls the splice method when a node has either 1 or 0 children
                splice(key);
            }
            else {
                BinarySearchTreeNode smallestRight = node.getRightNode();                   //deletes a node that has two children other than the root
                while (smallestRight.getLeftNode() != null) {                       //loops to find the node's smallest right child
                    smallestRight = smallestRight.getLeftNode();
                }
                String smallRightVal = smallestRight.getValue();                //holds smallest right node value
                splice(smallestRight.getValue());                           //deletes the smalles right child node
                node.setValue(smallRightVal);                               //sets the node value as the smallest right node's
            }
        }
    }

    //--HELPER FUNCTIONS--
    public void MaxWordHelper(BinarySearchTreeNode cursor) {                //adds the items of the BST to a linked list in an inorder fasion
        if (root == null)                                               //ends if the BST is empty
            return;
        if (cursor.getLeftNode() != null)
            MaxWordHelper(cursor.getLeftNode());
        myList.add(cursor.getValue());                                  //linkedlist add method call 
        if (cursor.getRightNode() != null)
            MaxWordHelper(cursor.getRightNode());
    }

    public void Max_Helper() {                                      //main method for the max word helper creates the linked list and calls the above method
        myList = new LinkedList();
        MaxWordHelper(root);
    }

    public void MaxWordCounter() {                              //finds the max word in the linked list. 
        if (myList.FindMaxWordCount() == 0) {                       //prints when the linked list is empty
            System.out.println("There is no maximum word");
        }
        else {                                                      //prints the max word and the number of times it is in the BST
        System.out.println("The Maximum word '" + myList.FindMaxWord() + "' shows up " + myList.FindMaxWordCount() + " times");
        }
    }
    //--HELPER FUNCTIONS--

    public void Print_Preorder(BinarySearchTreeNode cursor) {           //prints the items of the BST in a preorder fasion
        System.out.print(cursor.getValue() + " ");
        if (cursor.getLeftNode() != null) 
            Print_Preorder(cursor.getLeftNode());
        if (cursor.getRightNode() != null) 
            Print_Preorder(cursor.getRightNode());
    }

    public void Preorder_Helper() {                                     //calls the preorder method above and passes the root to it
        Print_Preorder(root);
    }

    public void Print_Inorder(BinarySearchTreeNode cursor) {            //prints the items of the BST in an inorder fasion
        if (root == null) 
            return;
        if (cursor.getLeftNode() != null)
            Print_Inorder(cursor.getLeftNode());
        System.out.print(cursor.getValue() + " ");
        if (cursor.getRightNode() != null)
            Print_Inorder(cursor.getRightNode());
    }

    public void Inorder_Helper() {                                      //calls the inorder method above and passes the root to it
        Print_Inorder(root);
    }

    public void Print_Postorder(BinarySearchTreeNode cursor) {          //prints the items of the BST in a postorder fasion
        if (cursor.getLeftNode() != null)
            Print_Postorder(cursor.getLeftNode());
        if (cursor.getRightNode() != null)
            Print_Postorder(cursor.getRightNode());
        System.out.print(cursor.getValue() + " ");
    }

    public void Postorder_Helper() {                                    //calls the postorder method above and passes the root to it
        Print_Postorder(root);
    }
}
