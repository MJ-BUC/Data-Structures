
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

public void add() {
    MyNode cursor = head;
    int count = 0;
    while (cursor != null) {
        count ++;
        cursor = cursor.getNext();
    }
}

public void insert() {
    MyNode cursor = head;
    int count = 0;
    while (cursor != null) {
        count ++;
        cursor = cursor.getNext();
    }
}

public void delete() {
    MyNode cursor = head;
    int count = 0;
    while (cursor != null) {
        count ++;
        cursor = cursor.getNext();
    }
}

public void remove() {
    MyNode cursor = head;
    int count = 0;
    while (cursor != null) {
        count ++;
        cursor = cursor.getNext();
    }
}

public void print() {
    MyNode cursor = head;
    int count = 0;
    while (cursor != null) {
        count ++;
        System.out.print(cursor);
        cursor = cursor.getNext();
    }
}
public static void main(String[] args) {
    
    }
}