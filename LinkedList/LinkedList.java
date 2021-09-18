//Mark Bucaro / This is a program that creates and uses the linked list data structure.

package CSCE210.LinkedList;

public class LinkedList {

    private MyNode head;

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
        
        MyNode cursor = head;                   //start the cursor at the head
        if (cursor == null) {                   //if the first value is null (meaning Linked list is empty) create head with current node
            head = node;
        }
        else{

            while (cursor.getNext() != null) {  //checks if the next segment of linkeded list is null before traversing
                cursor = cursor.getNext();      //traverses based on while loop condition
            }
            cursor.setNext(node);               //sets the node at the end of the linked list
        }
    }

    public void insert(int num, int pos) {        //inerts an item into the linkedlist
        MyNode node = new MyNode(num);            //creates node

        MyNode cursor = head;                     //cursor used to traverse to position
        int count = 0;                            //create counter 
        if (pos == 0) {                           //checks if the postion is equal to zero to know if it needs to insert at the head
            node.setNext(cursor);                 
            head = node;
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
        int count = 0;                      //creates counter keeps track of how many times traversed

        if (pos == 0) {                     //deleting from the head if position passed is equal to 0
            cursor.setNext(cursor.getNext());
            cursor.setNext(null);
            head = cursor2;
        }
        else{

            while (count != pos - 1) {              //loop until count equals the position entered
                cursor = cursor.getNext();          //traverse the first counter
                cursor2 = cursor2.getNext();        //traverse counter2 which is one node ahead of first cursor
                count++;                            //incrementing the counter keeping track of postions traversed
                if (count == pos - 1) {
                    cursor.setNext(cursor2.getNext());
                    cursor2.setNext(null);
                }
            }
        }
    }

    public void remove(int num) {                  //add removing at the head
        MyNode cursor = head;
        MyNode cursor2 = head.getNext();
        int value;
        int count = 0;
        
        if (count == 0 && cursor.getData() == num) {
            cursor.setNext(cursor.getNext());
            cursor.setNext(null);
            head = cursor2;
        }
        else{
            
            while (cursor2.getData() != num) {
                cursor = cursor.getNext();
                cursor2 = cursor2.getNext();
                value = cursor2.getData();
                if (value == num) {
                    cursor.setNext(cursor2.getNext());
                    cursor2.setNext(null);
                }
            }
        }
    }

    public void print() {
        MyNode cursor = head;
        System.out.print("Linked List Items; ");
        while (cursor != null) {
            System.out.print(cursor.getData());
            System.out.print(", ");
            cursor = cursor.getNext();
        }
    }
    public static void main(String[] args) {
        LinkedList mylist = new LinkedList();
        mylist.add(5);                          //adding items to the linked list
        mylist.add(3);
        mylist.add(0);
        mylist.add(7);
        mylist.add(1);
        mylist.add(6);
        mylist.add(4);
        mylist.add(8);

        mylist.insert(9, 3);                    //inserts 9 at the third position
        mylist.insert(2, 0);                    //inserts 2 at position zero, which is the head

        mylist.remove(8);
        mylist.remove(4);
        mylist.remove(2);

        mylist.delete(2);
        mylist.delete(0);

        mylist.print();
    }
}