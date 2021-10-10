package CSCE210.PEZ_Dispenser;

public class Stack {
    
    private DoublyLinkedList mylist = null;               //implement the DLL to create the stack
    
    public Stack(int data) {                              //stack constructor int passed being data
        this.mylist = new DoublyLinkedList(data);
    }

    public void push(int num) {                           //used to push an integer onto the stack
        mylist.insert(num, 0);
    }

    public int pop() {                                    //used to pop an integer off the stack
        int num;
        num = mylist.getHead();
        
        mylist.delete(0);
        return num;
    }

    public boolean isEmpty() {                            //returns tru if empty and false if not empty
        return mylist.isEmpty();
    }

    public void sum() {                                   //prints the sum of the items in the stack
        mylist.sumPrint();
    }

    public void print() {                                 //prints the items in the stack
        mylist.print();
    }

    public void ReversePrint() {                          //prints the items in the stack in reverse
        mylist.ReversePrint();
    }

    public static void main(String[] args) {              //test stack directly
        Stack mystack = new Stack(1);

        mystack.push(5);                                  //pushing items onto stack
        mystack.push(3);                                  //-
        mystack.push(6);                                  //-
        mystack.push(8);                                  //-
        mystack.push(7);                                  //pushing items onto stack
        mystack.pop();                                    //pop item off the stack using LIFO
        
        System.out.print("Stack empty: ");
        System.out.println(mystack.isEmpty());

        System.out.print("Stack: ");
        mystack.print();
        System.out.print("Stack Reversed: ");
        mystack.ReversePrint();

        mystack.sum();
    }

}
