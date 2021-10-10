package CSCE210.PEZ_Dispenser;
import java.util.Random;

public class PezDispenser {
    
    private Stack mystack = null;                           //implementing the stack into the pez dispenser

    public PezDispenser(int data) {                         //constructor for the pez dispenser
        this.mystack = new Stack(data);
    }

    public int random() {                                   //generates a random interger that will be used to push into the pez dispenser
        Random rand = new Random();                         //uses the random import to generate a random number
        int RandomNum = rand.nextInt(51);
        return RandomNum;
    }

    public void push() {                                    //pushes a random number into the pez dispenser
        mystack.push(random());
    }

    public int pop() {                                      //pops an item out of the pez dispenser
        return mystack.pop();
    }

    public void print() {                                   //prints all items in the pez dispenser
        System.out.print("PEZ In Dispenser: ");
        mystack.print();
    }

    public void ReversePrint() {                            //prints all items in the pez dispenser but in reverse
        System.out.print("Pez In Dispenser Reversed: ");
        mystack.ReversePrint();
    }

    public void sum() {                                     //sums all items in the pez dispenser
        mystack.sum();

    }
}
