//Mark Bucaro / A program that creates and dsplays the vehicles and their specs.

package CSCE210.vehicle;

public class Vehicle {
    String Type;
    int NumberOfWheels;
    float EngineSize;
    boolean UsesGasoline;

    //Sets type of vehicle.
    public void setType(String data){
        Type = data;
    }

    //Sets the number of wheels for said vehicle.
    public void  setNumberOfWheels(int numWheels){
        NumberOfWheels = numWheels;
    }

    //Sets the size of the engine for said vehicle.
    public void setEngineSize(float engine){
        EngineSize = engine;
    }

    //Sets whether or not the vehicle uses gasoline.
    public void setUsesGasoline(boolean gasoline){
        UsesGasoline = gasoline;
    }

    //Gets type of vehicle.
    public String getType(String data){
        return Type;
    }

    //Gets the number of wheels for said vehicle.
    public int  getNumberOfWheels(int numWheels){
        return NumberOfWheels;
    }

    //Gets the size of the engine for said vehicle.
    public float getEngineSize(float engine){
        return EngineSize;
    }

    //Gets whether or not the vehicle uses gasoline.
    public boolean getUsesGasoline(boolean gasoline){
        return UsesGasoline;
    }

    //Prints the information about the vehicle.
    public void print() {
        System.out.println("Type: " + Type);
        System.out.println("Number of Wheels: " + NumberOfWheels);
        System.out.println("Engine Size: " + EngineSize);
        System.out.println("Uses Gasoline: " + UsesGasoline);
        System.out.println();
    }

    public static void main(String[] args) {
        Vehicle mybike = new Vehicle();
        mybike.setType("Bicycle");
        mybike.setNumberOfWheels(2);
        mybike.setEngineSize(0.0f);
        mybike.setUsesGasoline(false);

        Vehicle mycar = new Vehicle();
        mycar.setType("Honda Civic");
        mycar.setNumberOfWheels(4);
        mycar.setEngineSize(6.5f);
        mycar.setUsesGasoline(true);

        Vehicle mytruck = new Vehicle();
        mytruck.setType("Ford F150");
        mytruck.setNumberOfWheels(4);
        mytruck.setEngineSize(8.0f);
        mytruck.setUsesGasoline(true);

        Vehicle mymotorcycle = new Vehicle();
        mymotorcycle.setType("Harley Davidson");
        mymotorcycle.setNumberOfWheels(2);
        mymotorcycle.setEngineSize(4.5f);
        mymotorcycle.setUsesGasoline(true);
        
        Vehicle[] myVehicles = {mybike, mycar, mytruck, mymotorcycle};
        
        for (int i = 0; i < 4; i++) {
            myVehicles[i].print();
        }
    }
}
