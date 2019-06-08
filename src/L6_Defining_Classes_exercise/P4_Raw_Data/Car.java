package L6_Defining_Classes_exercise.P4_Raw_Data;

public class Car {
    private String model;
    private Engine engine = new Engine();
    private Cargo cargo = new Cargo();
    private Tires tires = new Tires();

//    public Car(String model, Engine engine, Cargo cargo, Tires tires){
//        this.model = model;
//        this.engine = engine;
//        this.cargo = cargo;
//        this.tires = tires;
//    }


    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }


    public Cargo getCargo() {
        return cargo;
    }

    public Tires getTires() {
        return tires;
    }

    public String getModel() {
        return this.model;
    }
}
