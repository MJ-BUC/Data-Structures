package CSCE210.PEZ_Dispenser;

public class Stack {
    
    private DoublyLinkedList mylist = null;
    
    public Stack(int data) {
        this.mylist = new DoublyLinkedList(data);
    }

    public void push(int num) {
        mylist.insert(num, 0);
    }

    public int pop() {
        int num;
        num = mylist.getHead();
        
        mylist.delete(0);
        return num;
    }

    public boolean isEmpty() {
        return mylist.isEmpty();
    }

    public void sum() {
        mylist.sumPrint();
    }

    public void print() {
        mylist.print();
    }

    public void ReversePrint() {
        mylist.ReversePrint();
    }

    public static void main(String[] args) {
        Stack mystack = new Stack(1);

        // mystack.push(5);
        // mystack.push(3);
        // mystack.push(6);
        // mystack.push(8);
        // mystack.push(7);
        // mystack.pop();
        
        System.out.print("Stack empty: ");
        System.out.println(mystack.isEmpty());

        System.out.print("Stack: ");
        mystack.print();
        System.out.print("Stack Reversed: ");
        mystack.ReversePrint();
    }

}
