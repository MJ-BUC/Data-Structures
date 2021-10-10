package CSCE210.PEZ_Dispenser;

public class PezDispenserMain {
    
    public static void main(String[] args) {
        PezDispenser myPez = new PezDispenser(1);
        
        myPez.push();
        myPez.push();
        myPez.push();
        myPez.push();
        myPez.push();
        myPez.push();

        myPez.pop();

        myPez.print();
        myPez.ReversePrint();
        myPez.sum();
    }
}
