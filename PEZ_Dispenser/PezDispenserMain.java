package CSCE210.PEZ_Dispenser;

public class PezDispenserMain {
    
    public static void main(String[] args) {                //Demos the pez dispenser by pushing, popping, printing regularly and in reverse, and summing the items in the dispenser
        PezDispenser myPez = new PezDispenser(1);
        
        myPez.push();                     //push random number into the pez dispenser
        myPez.push();                     //-
        myPez.push();                     //-
        myPez.push();                     //-
        myPez.push();                     //-
        myPez.push();                     //push random number into the pez dispenser

        myPez.pop();                      //pops the top item out of the dispensor using LIFO
        myPez.pop();                      //pops the top item out of the dispensor using LIFO

        myPez.print();
        myPez.ReversePrint();
        myPez.sum();
    }
}
