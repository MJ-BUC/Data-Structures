//Mark Bucaro / This is a program that creates and uses the doubly linked list data structure.

package CSCE210.PEZ_Dispenser;

public class DoublyLinkedList {

    private MyNode head;
    private MyNode tail;

    public DoublyLinkedList(int data) {     //Doubly linked List constructor interger passed to create first node
        if (head == null) {                 //creates firstode if the list is empty aka head equals null
            head = new MyNode(data);        //set the new node to head and hold the arg passed, data
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

    public void add(int num) {                  //passing num, for any integer, to the method
        MyNode node = new MyNode(num);          //creating new node and setting num to it
        
        MyNode cursor = tail;                   //start the cursor at the tail

        if (size() == 0) {                      //if the first value is null (meaning Linked list is empty) create head with current node
            head = node;                        //sets the node put into the DLL as the head
            tail = node;                        //sets the node put into the doubly linked list as the tail
        }
        else{
            cursor.setNext(node);               //sets the node at the end of the doubly linked list
            node.setPrev(cursor);

            tail = node;                        //newnode becomes the tail
        }
    }

    public void insert(int num, int pos) {        //inerts an item into the doubly linked list
        MyNode node = new MyNode(num);            //creates node

        MyNode cursor = head;                     //cursor used to traverse to position and set to head
        MyNode cursor2 = head.getNext();          //cursor used to offset the first and catch nodes in front of the first cursor
        MyNode cursor3 = tail;                    //cursor to manage the tail

        int count = 0;                            //create counter to keep track of positions traversed
        
        if (pos > size() + 1 || pos < 0) {        //error handing for when someone enters a position that is less than 0 or exceeds the amount of nodes in the list except for size plus 1
            System.out.println("The entered position is invalid, not within list length!");
        }

        else {

            if (pos == 0) {                           //checks if the postion is equal to zero to know if it needs to insert at the head
                node.setNext(cursor);                 //attaches the node to the node that the cursor is pointing to
                cursor.setPrev(node);                 //sets the prev pointer from the node to the cursor to connect the nodes
                head = node;                          //sets the node put into the linked list as the head
            }
            else if (pos == size()) {                 //inserts a node at the end of the list
                cursor3.setNext(node);                //sets the tail pointer to the new node
                node.setPrev(cursor3);                //sets prev pointer from new node to cursor3
                tail = node;                          //new node is set as the tail
            }

            else if (count == pos - 1 || pos == 1) {               //inserts at position 1 of the DLL
                node.setNext(cursor.getNext());                    //sets node to next position
                cursor.setNext(node);                              //saves node to position entered
                node.setPrev(cursor2.getPrev());                   //sets the prev pointer from newnode to cursor2's prev
                cursor2.setPrev(node);                             //sets prev pointer from cursor2 to node
            }

            else{
            
                while (count < pos -1 && cursor != null) {         //loop until the previous node in the linked list
                    cursor = cursor.getNext();                     //traverse the first cursor
                    cursor2 = cursor.getNext();                    //traverses through the linked list
                    count++;                                       //increments counter to keeo track of how many times traversed until position
                    
                    if (count == pos - 1) {                                
                        node.setNext(cursor.getNext());                    //sets node to next position
                        cursor.setNext(node);                              //saves node to position entered
                        node.setPrev(cursor2.getPrev());                   //sets the prev pointer from newnode to cursor2's prev 
                        cursor2.setPrev(node);                             //sets prev pointer from cursor2 to node
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
        
        if (isEmpty()) {                    //error handler for deleting if a list is empty
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

    public void remove(int num) {                         //removes the first instance of a desired num associated with a node
        MyNode cursor = head;                             //creates cursor to pointing to head
        MyNode cursor2 = head.getNext();                  //creates second cursor with similar functionality to the previous cursor, automatically traverse one ahead of first cursor
        MyNode cursor3 = tail;                            //creates cursor pinting to the tail node
        int value = head.getData();                       //saves cursor2 getData() to use in the if statement used for checking if num entered is equal to the getData()
        int value2 = cursor.getData();

        int count = 0;
        
        if (isEmpty()) {
            System.out.println("The list is empty. Cannot Remove!");
        }
        
        else {

            if (cursor.getData() == num) {                                  //when the first cursor is on the desired num this section runs and will only cath the head of the linked list
                head = cursor2;                                             //sets the next node after the pointer "cursor" to the current spot of pointer "cursor"
                cursor2.setPrev(null);
                cursor.setNext(null); // null pointer exception waiting to happen when only one node           
            }

            else{
                
                while ((value != num && value2 != num) && count < size() && cursor2.getNext() != null) {  
                    value2 = cursor2.getData();                                      //runs when cursor2 is on the desired node to remove
                    cursor = cursor.getNext();                                       //traverse the first counter
                    cursor2 = cursor2.getNext();                                     //traverse counter2 which is one node ahead of first cursor
                    value = cursor2.getData();                                            
                                                                                    //cursor2 gets the data from each node to then store it in the varible value
                    count++;

                    if ((count == (size() - 2)) && (value == num)) {                //remove from the tail
                        cursor.setNext(null);
                        cursor3.setPrev(null);
                        tail = cursor;
                    }
                    
                    else if ((count != (size() - 2)) && ((value == num))) {
                        cursor2 = cursor2.getNext();
                        cursor.setNext(cursor2);                                    //sets the node after desitred position to connect to first cursor
                        cursor2.setPrev(cursor);
                    }

                    else if ((count != (size() - 2)) && ((value2 == num))) {
                        cursor = cursor.getPrev();
                        cursor.setNext(cursor2);                                    //sets the node after desitred position to connect to first cursor
                        cursor2.setPrev(cursor);
                    }

                    else if (cursor2.getNext() == null) {
                        System.out.println("The number " + num + " is not in the list!");
                    }
                }
            }
        }
    }

    public void print() {                                       //prints out the linked list
        MyNode cursor = head;
        while (cursor != null) {                                //traverse through the entire linked list
            System.out.print(cursor.getData());
            System.out.print(", ");
            cursor = cursor.getNext();
        }
        System.out.println();
    }

    public void ReversePrint() {
        MyNode cursor = tail;
        while (cursor != null) {
            System.out.print(cursor.getData());
            System.out.print(", ");
            cursor = cursor.getPrev();
        }
        System.out.println();
    }

    public int sum(MyNode node) {
        if (node.getNext() == null) {
            return node.getData();
        }
        return node.getData() + sum(node.getNext());
    }

    public void sumPrint() {
        System.out.println("Sum of list: "+ sum(head));
    }

    public int getHead() {
        MyNode cursor = head;
        int value = cursor.getData();
        return value;
    }

    public static void main(String[] args) {
        DoublyLinkedList mylist = new DoublyLinkedList(1);
        mylist.add(5);                          //adding items to the linked list
        mylist.add(3);                          //-
        mylist.add(0);                          //-
        mylist.add(4);                          //-
        mylist.add(7);                          //-
        mylist.add(1);                          //-
        mylist.add(6);                          //-
        mylist.add(4);                          //-
        mylist.add(8);                          //adding items to the linked list

        mylist.insert(9, 10);                   //inserts 9 at the tail position
        mylist.insert(2, 0);                    //inserts 2 at position zero, which is the head
        mylist.insert(5, 1);                    //inserts at poition 4, a place near the middle of the list

        mylist.remove(2);                             //removes the first instance of 2, removing at the head of the list
        mylist.remove(9);                       //removes the first instance of 9 which is the last position
        mylist.remove(5);                       //removes the first instance of 4 and removes the 4 that comes before the second
        mylist.remove(10);                       //removes the first instance of 2 which is also the head
        
        mylist.delete(9);
        mylist.delete(7);                       //deletes positio 2 of the linked list, 0 is deleted
        mylist.delete(7);
        mylist.delete(0);
        mylist.delete(1);

        System.out.print("Doubly Linked List: ");
        mylist.print();
        System.out.print("Doubly Linked List Reversed: ");
        mylist.ReversePrint();

        System.out.print("Is empty: ");
        System.out.println(mylist.isEmpty());           //print whether or not the linked list is empty, this current linked list: is empty = false the list is not empty
        System.out.print("Size: ");
        System.out.println(mylist.size());              //print the size of the linked list: this current linked list has a size of 6
        System.out.print("Sum Of List: ");
        mylist.sumPrint();
    }
}