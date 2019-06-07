package L6_Defining_Classes_exercise.P4_Raw_Data_2;

public class Car {
    private String model;
//    private Engine engine;
//    private Cargo cargo;
//    private Tires tires;
    //engine
    private int engineSpeed;
    private int enginePower;
    //cargo
    private int cargoWeight;
    private String cargoType;
    //tires
    private double tire1Presure;
    private int tire1Age;
    private double tire2Presure;
    private int tire2Age;
    private double tire3Presure;
    private int tire3Age;
    private double tire4Presure;
    private int tire4Age;

//    public Car(String model, Engine engine, Cargo cargo, Tires tires){
//        this.model = model;
//        this.engine = engine;
//        this.cargo = cargo;
//        this.tires = tires;
//    }
    //set model
    public void setModel(String model) {
        this.model = model;
    }

//    public Engine getEngine() {
//        return engine;
//    }
//
//
//    public Cargo getCargo() {
//        return cargo;
//    }
//
//    public Tires getTires() {
//        return tires;
//    }

    //set engine
    public void setSpeed(int engineSpeed) {
        this.engineSpeed = engineSpeed;
    }

    public void setPower(int enginePower) {
        this.enginePower = enginePower;
    }

    public int getEnginePower() {
        return enginePower;
    }

    //set cargo + get cargo
    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public String getCargoType(){
        return cargoType;
    }

    //set tires
    public void setTire1Presure(double tire1Presure) {
        this.tire1Presure = tire1Presure;
    }

    public void setTire1Age(int tire1Age) {
        this.tire1Age = tire1Age;
    }

    public void setTire2Presure(double tire2Presure) {
        this.tire2Presure = tire2Presure;
    }

    public void setTire2Age(int tire2Age) {
        this.tire2Age = tire2Age;
    }

    public void setTire3Presure(double tire3Presure) {
        this.tire3Presure = tire3Presure;
    }

    public void setTire3Age(int tire3Age) {
        this.tire3Age = tire3Age;
    }

    public void setTire4Presure(double tire4Presure) {
        this.tire4Presure = tire4Presure;
    }

    public void setTire4Age(int tire4Age) {
        this.tire4Age = tire4Age;
    }

    public double getTire1Presure() {
        return tire1Presure;
    }

    public double getTire2Presure() {
        return tire2Presure;
    }

    public double getTire3Presure(){
        return tire3Presure;
    }

    public double getTire4Presure() {
        return tire4Presure;
    }

}
