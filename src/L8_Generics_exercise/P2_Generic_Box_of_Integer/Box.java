package L8_Generics_exercise.P2_Generic_Box_of_Integer;

public class Box<T> {
    private T number;

    public Box(T number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("%s: %d"
                , this.number.getClass().getName()
                , this.number);
    }
}
