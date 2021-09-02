package vehicle;

class Vehicle {
    String Type;
    int NumberOfWheels;
    float EngineSize;
    boolean UsesGasoline;

    public void setType(String data){
        Type = data;
    }

    public void  setNumberOfWheels(int numWheels){
        NumberOfWheels = numWheels;
    }

    public void setEngineSize(float engine){
        EngineSize = engine;
    }

    public boolean setUsesGasoline(boolean gasoline){
        UsesGasoline = gasoline;
    }

    public String getType(String data){
        return Type;
    }

    public int  getNumberOfWheels(int numWheels){
        return NumberOfWheels;
    }

    public float getEngineSize(float engine){
        return EngineSize;
    }

    public boolean getUsesGasoline(boolean gasoline){
        return UsesGasoline;
    }

    public void print() {
        System.out.print("Type: " + Type);
    }

    public static void main(String[] args) {
        Vehicle myCar = new Vehicle();
        myCar.setType("Bicycle");
        System.out.println(myCar.getType());
    }
}
