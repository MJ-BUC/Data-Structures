//Mark Bucaro / This is a program that creates and uses the doubly linked list data structure.

package CSCE210.PEZ_Dispenser;

public class DoublyLinkedList {

    private MyNode head;
    private MyNode tail;

    public DoublyLinkedList(int data) {
        if (head == null) {
            head = new MyNode(data);
            tail = head;
        }
    }

    public int size() {
        MyNode cursor = head;               //set cursor to head so we can traverse
        int count = 0;                      //initialize counter to 0
        while (cursor != null) {            //check to see if we've
                                            //gotten to the end of the list
            count++;                        //increment counter
            cursor = cursor.getNext();      //move cursor through the list
        }
            return count;                   //return the count (i.e. size of list)
    }

    public boolean isEmpty() {
        if (size() == 0) {                  //check if size of inked list is equal to 0
            return true;                    //true if 0
        } 
        else {
            return false;                   //false if not 0
        }
    }

    public void add(int num) {                  //passing num, for any integer, to the method
        MyNode node = new MyNode(num);          //creating new node and setting num to it
        
        MyNode cursor = tail;                   //start the cursor at the head

        if (size() == 0) {                   //if the first value is null (meaning Linked list is empty) create head with current node
            head = node;
            tail = node;                        //sets the node put into the linked list as the head
        }
        else{
            cursor.setNext(node);               //sets the node at the end of the linked list
            node.setPrev(cursor);

            tail = node;
        }
    }

    //needs to be changed for doubly linked list
    public void insert(int num, int pos) {        //inerts an item into the linkedlist
        MyNode node = new MyNode(num);            //creates node

        MyNode cursor = head;                     //cursor used to traverse to position
        int count = 0;                            //create counter to keep track of positions traversed
        if (pos == 0) {                           //checks if the postion is equal to zero to know if it needs to insert at the head
            node.setNext(cursor);                 //attaches the node to the node that the cursor is pointing to
            head = node;                          //sets the node put into the linked list as the head
        }
        else{
        
            while (count < pos -1 && cursor != null) {         //loop until the previous node in the linked list
                cursor = cursor.getNext();                     //traverses through the linked list
                count++;                                       //increments counter to keeo track of how many times traversed until position
            }
            node.setNext(cursor.getNext());                    //sets node to next position
            cursor.setNext(node);                              //saves node to position entered
        }
    }

    public void delete(int pos) {           //deletes a node at a specific position that is passed as an argument add deleting at the head
        MyNode cursor = head;               //creates cursor to point to nodes of linked list
        MyNode cursor2 = head.getNext();    //creates second cursor with similar functionality to the previous cursor, automatically traverse one ahead of first cursor
        MyNode cursor3 = tail;

        int count = 0;                      //creates counter keeps track of how many times traversed

        if (pos == 0) {                             //deleting from the head if position passed is equal to 0
            head = cursor2;
            cursor2.setPrev(null);
            cursor.setNext(null);
        }

        else if (pos == size() - 1){                //deleting from the tail
            while (count != pos -1) {
                cursor = cursor.getNext();
                count++; 
                if (count == pos - 1) {
                    cursor.setNext(null);
                    cursor3.setPrev(null);
                    tail = cursor;
                }
            }
        }
        
        else{

            while (count != pos - 1) {                      //loop until count equals the position entered
                cursor = cursor.getNext();                  //traverse the first counter
                cursor2 = cursor2.getNext();                //traverse counter2 which is one node ahead of first cursor
                count++;                                    //incrementing the counter keeping track of postions traversed
                if (count == pos - 1) {                     //this section runs when cursor2 is on the position that is requested to delete and cursor is on the previous node
                    cursor = cursor.getPrev();
                    cursor.setNext(cursor2);                //sets the node after desitred position to connect to first cursor
                    cursor2.setPrev(cursor);
                }
            }
        }
    }

    //needs to be changed for doubly linked list
    public void remove(int num) {                  //add removing at the head
        MyNode cursor = head;                      //creates cursor to point to nodes of linked list
        MyNode cursor2 = head.getNext();           //creates second cursor with similar functionality to the previous cursor, automatically traverse one ahead of first cursor
        MyNode cursor3 = tail;
        int value = head.getData();                                 //saves cursor2 getData() to use in the if statement used for checking if num entered is equal to the getData()

        int count = 0;

        if (cursor.getData() == num) {                      //when the first cursor is on the desired num this section runs and will only cath the head of the linked list
            head = cursor2;                                 //sets the next node after the pointer "cursor" to the current spot of pointer "cursor"
            cursor2.setPrev(null);
            cursor.setNext(null); // null pointer exception waiting to happen when only one node           
        }

        else{
            
            while (value != num && count < size()) {  
                value = cursor2.getData();                                      //runs when cursor2 is on the desired node to remove
                cursor = cursor.getNext();                  //traverse the first counter
                cursor2 = cursor2.getNext();                //traverse counter2 which is one node ahead of first cursor
                                                            //cursor2 gets the data from each node to then store it in the varible value
                count++;
                // System.out.println(value +", " +count);

                if ((count == (size() - 2)) && (value == num)) {
                    cursor.setNext(null);
                    cursor3.setPrev(null);
                    tail = cursor;
                }
                
                else if ((count != (size() - 2)) && (value == num)) {
                    cursor = cursor.getPrev();
                    cursor.setNext(cursor2);                //sets the node after desitred position to connect to first cursor
                    cursor2.setPrev(cursor);
                }
            }
        }
    }

    public void print() {                               //prints out the linked list
        MyNode cursor = head;
        System.out.print("Doubly Linked List: ");
        while (cursor != null) {                        //traverse through the entire linked list
            System.out.print(cursor.getData());
            System.out.print(", ");
            cursor = cursor.getNext();
        }
        System.out.println();
    }

    public void ReversePrint() {
        MyNode cursor = tail;
        System.out.print("Doubly Linked List Reversed: ");
        while (cursor != null) {
            System.out.print(cursor.getData());
            System.out.print(", ");
            cursor = cursor.getPrev();
        }
        System.out.println();
    }

    // public int sum(int total) {
    //     MyNode cursor = head;
    //     total = 0;

    //     if (isEmpty() == true) {
    //         return total;
    //     }
    //     else {
            
    //     }

    //     // while (cursor.getNext() != null) {
    //     //     int listData = cursor.getData();
    //     //     cursor.getNext();

    //     //     return sum(total);
    //     // }
    //     return total;
    // }
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

        //mylist.insert(9, 3);                    //inserts 9 at the third position
        //mylist.insert(2, 0);                    //inserts 2 at position zero, which is the head

        // mylist.remove(1);
        // mylist.remove(8);                       //removes the fist instance of 8 which is the last position
        mylist.remove(7);                       //removes the first instance of 4 and removes the 4 that comes before the second
        // mylist.remove(2);                       //removes the first instance of 2 which is also the head

        // mylist.delete(2);                       //deletes positio 2 of the linked list, 0 is deleted
        // mylist.delete(0);                       //deletes position 0 of the linked list, which is the head and deletes 5
        mylist.delete(7);
        // mylist.delete(7);

        mylist.print();
        mylist.ReversePrint();

        System.out.print("Is empty: ");
        System.out.println(mylist.isEmpty());       //print whether or not the linked list is empty, this current linked list: is empty = false the list is not empty
        System.out.print("Size: ");
        System.out.println(mylist.size());            //print the size of the linked list: this current linked list has a size of 6
    }
}