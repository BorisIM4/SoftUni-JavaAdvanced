package L8_Generics_exercise.P4_Generic_Swap_Method_Integer;

import java.util.LinkedList;
import java.util.List;

public class Box<T> {
    private List<T> listOfIntegers;

    public Box() {
        this.listOfIntegers = new LinkedList<>();
    }

    public void add(T element) {
        this.listOfIntegers.add(element);
    }

    public void swap(int indexOne, int indextwo) {
        T firstElement = this.listOfIntegers.get(indexOne);
        T secondElement = this.listOfIntegers.get(indextwo);

        this.listOfIntegers.set(indextwo, firstElement);
        this.listOfIntegers.set(indexOne, secondElement);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (T value : this.listOfIntegers) {
            stringBuilder.append(String.format("%s: %s", value.getClass().getName()
                    , value.toString()))
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
