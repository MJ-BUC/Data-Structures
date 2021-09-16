
package LinkedList;

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
        if (cursor == null) {
            head = node;
        }
        else{

            while (cursor.getNext() != null) {
                cursor = cursor.getNext();
            }
            cursor.setNext(node);
        }
    }

    public void insert(int num, int pos) {        //inerts an item into the linkedlist
        MyNode node = new MyNode(num);

        MyNode cursor = head;                     //cursor used to traverse to position
        int count = 0;                            //counter 
        if (pos == 0) {
            node.setNext(cursor);
            head = node;
        }
        else{
        
            while (count < pos -1 && cursor != null) {         //loop until the previous node in the linked list
                cursor = cursor.getNext();
                count++;
            }
            node.setNext(cursor.getNext());
            cursor.setNext(node);
        }
    }

    public void delete(int pos) {           //add removing at the head
        MyNode cursor = head;
        MyNode cursor2 = head.getNext();
        int count = 0;

        while (count != pos - 1) {
            cursor = cursor.getNext();
            cursor2 = cursor2.getNext();
            count++;
            if (count == pos - 1) {
                cursor.setNext(cursor2.getNext());
                cursor2.setNext(null);
            }
        }
    }

    public void remove(int num) {                  //add rmoving at the head
        MyNode cursor = head;
        MyNode cursor2 = head.getNext();
        int value;

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
        mylist.add(5);
        mylist.add(3);
        mylist.add(7);
        mylist.add(4);
        mylist.add(8);

        mylist.insert(9, 3);
        mylist.insert(2, 0);

        mylist.remove(8);
        mylist.remove(4);

        mylist.delete(2);

        mylist.print();
    }
}