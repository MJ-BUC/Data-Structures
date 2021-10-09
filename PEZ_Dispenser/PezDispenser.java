package CSCE210.PEZ_Dispenser;
import java.util.Random;

public class PezDispenser {
    
    private Stack mystack = null;

    public PezDispenser(int data) {
        this.mystack = new Stack(data);
    }

    public int random() {
        Random rand = new Random();
        int RandomNum = rand.nextInt(51);
        return RandomNum;
    }

    public void push() {
        mystack.push(random());
    }

    public int pop() {                      //not working needs work
        return 0;

    }

    public void print() {
        mystack.print();
    }

    public void ReversePrint() {
        mystack.ReversePrint();
    }

    public int sum() {                      //not working needs work
        return 0;

    }

    public static void main(String[] args) {
        PezDispenser mypez = new PezDispenser(1);

        mypez.push();
        mypez.push();
        mypez.push();
        mypez.push();
        mypez.push();
        mypez.push();

        mypez.print();
        mypez.ReversePrint();
    }
}
