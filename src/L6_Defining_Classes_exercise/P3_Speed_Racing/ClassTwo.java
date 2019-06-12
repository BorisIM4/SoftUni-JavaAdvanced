package L6_Defining_Classes_exercise.P3_Speed_Racing;

public class ClassTwo {
    private ClassThree classThree = new ClassThree();
    private int startNumber;

    public void setStartnumber(int startNumber) {
        this.startNumber = startNumber;
    }

    public ClassThree getClassThree() {
        return this.classThree;
    }

    public int getStartNumber() {
        return this.startNumber;
    }
}
