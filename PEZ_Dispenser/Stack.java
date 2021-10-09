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
        return 0;

    }

    public boolean isEmpty() {
        return mylist.isEmpty();
    }

    public int sum(MyNode node) {                       //needs work not functional
        if (node.getNext() == null) {
            return node.getData();
        }
        return node.getData() + sum(node.getNext());
    }

    public void print() {
        System.out.print("Stack: ");
        mylist.print();
    }

    public void ReversePrint() {
        System.out.print("Stack Reversed: ");
        mylist.ReversePrint();
    }

    public static void main(String[] args) {
        Stack mystack = new Stack(1);

        mystack.push(5);
        mystack.push(3);
        mystack.push(6);
        mystack.push(8);
        mystack.push(7);
        
        System.out.print("Stack empty: ");
        System.out.println(mystack.isEmpty());

        mystack.print();
        mystack.ReversePrint();
    }

}
