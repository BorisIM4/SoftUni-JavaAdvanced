package L8_Generics_exercise.P3_Generic_Swap_Method_String;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> value;

    public Box() {
        this.value = new ArrayList<>();
    }

    public void addValue (T value) {
        this.value.add(value);
    }

    public void swap(int index1, int index2) {
        T firstElement = this.value.get(index1);
        this.value.set(index1, this.value.get(index2));
        this.value.set(index2, firstElement);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (T value : this.value) {
            stringBuilder.append(String.format("%s: %s", value.getClass().getName()
                    , value.toString()))
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
