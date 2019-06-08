package L6_Defining_Classes_exercise.P4_Raw_Data;

public class Engine {
    private int engineSpeed;
    private int enginePower;

//    public Engine(int engineSpeed, int enginePower){
//        this.engineSpeed = engineSpeed;
//        this.enginePower = enginePower;
//    }

    public void setSpeed(int engineSpeed) {
        this.engineSpeed = engineSpeed;
    }

    public void setPower(int enginePower) {
        this.enginePower = enginePower;
    }

    public int getEnginPower() {
        return this.enginePower;
    }
}
