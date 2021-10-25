//Mark Bucaro / This is a program that creates and uses the doubly linked list data structure.

package CSCE210.Phone_Book;

public class DoublyLinkedList {

    private MyNode head;
    private MyNode tail;

    public DoublyLinkedList(MyNode newnode) {     //Doubly linked List constructor node passed to create first node
        if (head == null) {                 //creates firstode if the list is empty aka head equals null
            head = newnode;        //set the new node to head and hold the arg passed, data
            tail = head;                    //set the tail equal to head to make it doubly linked, and make the one node be the head and tail
        }
    }

    public int size() {                     //returns the size of the doubly linked list
        MyNode cursor = head;               //set cursor to head so we can traverse
        int count = 0;                      //initialize counter to 0
        while (cursor != null) {            //check to see if we've
                                            //gotten to the end of the list
            count++;                        //increment counter
            cursor = cursor.getNext();      //move cursor through the list
        }
            return count;                   //return the count (i.e. size of list)
    }

    public boolean isEmpty() {              //returns tru if the list is empty or false if the list is not empty
        if (size() == 0) {                  //check if size of inked list is equal to 0
            return true;                    //true if 0
        } 
        else {
            return false;                   //false if not 0
        }
    }

    public void add(MyNode newnode) {                  //passing num, for any integer, to the method
        
        MyNode cursor = tail;                   //start the cursor at the tail

        if (size() == 0) {                      //if the first value is null (meaning Linked list is empty) create head with current node
            head = newnode;                        //sets the node put into the DLL as the head
            tail = newnode;                        //sets the node put into the doubly linked list as the tail
        }
        else{
            cursor.setNext(newnode);               //sets the node at the end of the doubly linked list
            newnode.setPrev(cursor);

            tail = newnode;                        //newnode becomes the tail
        }
    }

    public void insert(MyNode newnode, int pos) {        //inerts an item into the doubly linked list

        MyNode cursor = head;                     //cursor used to traverse to position and set to head
        MyNode cursor2 = head.getNext();          //cursor used to offset the first and catch nodes in front of the first cursor
        MyNode cursor3 = tail;                    //cursor to manage the tail

        int count = 0;                            //create counter to keep track of positions traversed
        
        if (pos > size() + 1 || pos < 0) {        //error handing for when someone enters a position that is less than 0 or exceeds the amount of nodes in the list except for size plus 1
            System.out.println("The entered position is invalid, not within list length!");
        }

        else {

            if (pos == 0) {                           //checks if the postion is equal to zero to know if it needs to insert at the head
                newnode.setNext(cursor);                 //attaches the node to the node that the cursor is pointing to
                cursor.setPrev(newnode);                 //sets the prev pointer from the node to the cursor to connect the nodes
                head = newnode;                          //sets the node put into the linked list as the head
            }
            else if (pos == size()) {                 //inserts a node at the end of the list
                cursor3.setNext(newnode);                //sets the tail pointer to the new node
                newnode.setPrev(cursor3);                //sets prev pointer from new node to cursor3
                tail = newnode;                          //new node is set as the tail
            }

            else if (count == pos - 1 || pos == 1) {               //inserts at position 1 of the DLL
                newnode.setNext(cursor.getNext());                    //sets node to next position
                cursor.setNext(newnode);                              //saves node to position entered
                newnode.setPrev(cursor2.getPrev());                   //sets the prev pointer from newnode to cursor2's prev
                cursor2.setPrev(newnode);                             //sets prev pointer from cursor2 to node
            }

            else{
            
                while (count < pos -1 && cursor != null) {         //loop until the previous node in the linked list
                    cursor = cursor.getNext();                     //traverse the first cursor
                    cursor2 = cursor.getNext();                    //traverses through the linked list
                    count++;                                       //increments counter to keeo track of how many times traversed until position
                    
                    if (count == pos - 1) {                                
                        newnode.setNext(cursor.getNext());                    //sets node to next position
                        cursor.setNext(newnode);                              //saves node to position entered
                        newnode.setPrev(cursor2.getPrev());                   //sets the prev pointer from newnode to cursor2's prev 
                        cursor2.setPrev(newnode);                             //sets prev pointer from cursor2 to node
                    }
                }
            }
        }
    }

    public void delete(int pos) {           //deletes a node at a specific position that is passed as an argument add deleting at the head
        MyNode cursor = head;               //creates cursor to point to nodes of doubly linked list
        MyNode cursor2 = head.getNext();    //creates second cursor with similar functionality to the previous cursor, automatically traverse one ahead of first cursor
        MyNode cursor3 = tail;              //cursor3 is pointing to the tail node

        int count = 0;                      //creates counter keeps track of how many times traversed
        
        if (isEmpty() || size() < 1) {                    //error handler for deleting if a list is empty
            System.out.println("The list is empty. Cannot Delete!");
        }
        
        else if (pos > size() || pos < 0) {               //error handler for entered position being less than 0 or greater than the overall size of the list
            System.out.println("The entered position is invalid, not within list length!");
        }
        else {

            if (pos == 0) {                             //deleting from the head if position passed is equal to 0
                head = cursor2;                         //sets the head of the list to cursor2
                cursor2.setPrev(null);                  //sets cursor2 prev pointer to null
                cursor.setNext(null);                   //sets sursor next pointer to null this breaks connection to the head node
            }

            else if (pos == size() - 1){                //deleting from the tail
                while (count != pos - 1) {              //traverse to the last node -1
                    cursor = cursor.getNext();          //traversing the cursor
                    count++;                            //incrementing counter
                    if (count == pos - 1) {             //deletes node when cursor is at the correct position
                        cursor.setNext(null);           //cursor sets the next pointer to node to null breaking connection
                        cursor3.setPrev(null);          //cursor3 sets the prev pointer to node to null breaking connection
                        tail = cursor;                  //node of cursor becomes the new tail
                    }
                }
            }
            
            else{

                while (count != pos) {                          //loop until count equals the position entered
                    cursor = cursor.getNext();                  //traverse the first counter
                    cursor2 = cursor2.getNext();                //traverse counter2 which is one node ahead of first cursor
                    count++;                                    //incrementing the counter keeping track of postions traversed
                    if (count == pos) {                         //this section runs when cursor2 is on the position that is requested to delete and cursor is on the previous node
                        cursor = cursor.getPrev();              //cursor traverses back one to get behind node
                        cursor.setNext(cursor2);                //sets the node after desitred position to connect to first cursor
                        cursor2.setPrev(cursor);                //sets the connection from cursor2 to cursor breaking the connection to the node and deleting it
                    }
                }
            }
        }
    }

    public void remove(String key) {                         //removes the first instance of a desired num associated with a node
        MyNode cursor = head;                             //creates cursor to pointing to head
        MyNode cursor2 = head.getNext();                  //creates second cursor with similar functionality to the previous cursor, automatically traverse one ahead of first cursor
        MyNode cursor3 = tail;                            //creates cursor pinting to the tail node
        String value = head.getKey();                       //saves cursor2 getData() to use in the if statement used for checking if num entered is equal to the getData()
        String value2 = cursor.getKey();                    //saves cursor2's getData() used for removing at pos 1

        int count = 0;                                    //establishes a counter
        
        if (isEmpty()) {                                  //error handler for removing in an empty list
            System.out.println("The list is empty. Cannot Remove!");
        }
        
        else {

            if (cursor.getKey() == key && cursor.getNext() == null) {
                head = null;
            }
            
            else if (cursor.getKey() == key) {                                  //when the first cursor is on the desired num this section runs and will only cath the head of the linked list
                head = cursor2;                                             //sets the next node after the pointer "cursor" to the current spot of pointer "cursor"
                cursor2.setPrev(null);                                      //sets the previous pointer from cursor2 to null breaking connection
                cursor.setNext(null);                                       //sets the next pointer from cursor to null breaking connection
            }

            else{
                
                while ((value != key && value2 != key) && count < size() && cursor2.getNext() != null) {  
                    value2 = cursor2.getKey();                                      //runs when cursor2 is on the desired node to remove
                    cursor = cursor.getNext();                                       //traverse the first counter
                    cursor2 = cursor2.getNext();                                     //traverse counter2 which is one node ahead of first cursor
                    value = cursor2.getKey();                                       //records the getData() from each node that cursor2 traverses over
                                                                                     //cursor2 gets the data from each node to then store it in the varible value
                    count++;                                                         //incrementing counter

                    if ((count == (size() - 2)) && (value == key)) {                 //remove from the tail
                        cursor.setNext(null);                                        //sets the pointer next of cursor to null to break the connection to the node
                        cursor3.setPrev(null);                                       //sets the pointer prev of cursor3 to null to break the connectionnto the node
                        tail = cursor;                                               //node of the cursor becomes the new tail
                    }
                    
                    else if ((count != (size() - 2)) && ((value == key))) {          //removes nodes in the list excluding the head, tail, and index 1
                        cursor2 = cursor2.getNext();                                 //traverses cursor2
                        cursor.setNext(cursor2);                                     //sets the node after desitred position to connect to first cursor
                        cursor2.setPrev(cursor);                                     //sets the prev pointer from cursor2 to cursor this breaks connection to the node
                    }

                    else if ((count != (size() - 2)) && ((value2 == key))) {         //removes the node at index 1
                        cursor = cursor.getPrev();                                   //traverse the cursor back 1
                        cursor.setNext(cursor2);                                     //sets the node after desitred position to connect to first cursor
                        cursor2.setPrev(cursor);                                     //sets the prev pointer from cursor2 to cursor this breaks connection to the node
                    }

                    else if (cursor2.getNext() == null) {                            //error handling for a num that is not in the list
                        System.out.println("The number " + key + " is not in the list!");
                    }
                }
            }
        }
    }

    public MyNode NodeFind(String key) {                        //finds a node in the linked list and returns the node
        MyNode cursor = head;                                   //cursor is set to head
        String value = head.getKey();                           //gets the key of the head node and stores it in value

        if (size() == 0) {                                      //returns null if list is empty
            return null;
        }
        else {
            while(value != key && cursor.getNext() != null) {   //finds node until the value equals the key and the next node is not null
                value = cursor.getKey();                        //gets the key of the node
                cursor = cursor.getNext();                      //gets the next item in the list
                if (value == key) {
                    return cursor;
                }
            }
            return null;
        }
    }

    public void print() {                                       //prints out the linked list
        MyNode cursor = head;
        while (cursor != null) {                                //traverse through the entire linked list
            System.out.print(cursor.getKey());
            System.out.print(' ');
            System.out.print(cursor.getValue());
            System.out.print(", ");
            cursor = cursor.getNext();
        }
        System.out.println();
    }

    public void ReversePrint() {                                //prints the list in reverse
        MyNode cursor = tail;                                   
        while (cursor != null) {                                //traverse through the linked list using getPrev()
            System.out.print(cursor.getKey());
            System.out.print(' ');
            System.out.print(cursor.getValue());
            System.out.print(", ");
            cursor = cursor.getPrev();
        }
        System.out.println();
    }

    public MyNode getHead() {                                   //gets the head node in a linked list
        MyNode cursor = head;
        if (size() >= 1 && cursor != null) {                    //returns the head if size of the list is greater than or equal to 1 and of the cursor is not null
            return head;
        }
        return null;
    }


    // public int sum(MyNode node) {                               //recursivly sum the nodes, a node is passed as an argument
    //     if (node.getNext() == null) {                           //returns when the next position of the node is a null value
    //         return node.getData();
    //     }
    //     return node.getData() + sum(node.getNext());            //totals the getData from the node
    // }

    // public void sumPrint() {                                    //prints the sum returned from the sum method
    //     System.out.println("Sum of list: "+ sum(head));
    // }
}