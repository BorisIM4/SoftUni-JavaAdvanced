package L8_Generics_exercise.P9_Custom_List_Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomList<E extends Comparable<E>> implements Iterable<E> {
    private List<E> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    public void add(E element) {
        this.data.add(element);
    }

    public E remove(int index) {
        return this.data.remove(index);
    }

    public int size() {
        return this.data.size();
    }

    public E get(int index) {
        return this.data.get(index);
    }

    public boolean contains(E element) {
        return this.data.contains(element);
    }

    public void swap(int index1, int index2) {
        E firstElement = this.data.get(index1);
        this.data.set(index1, this.data.get(index2));
        this.data.set(index2, firstElement);
    }

    public long countGreaterThan(E element) {
        return this.data.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public E getMax() {
        E maxElement = null;
        if (!this.data.isEmpty()) {
            maxElement = this.data.get(0);
            for (E datum : this.data) {
                if (datum.compareTo(maxElement) > 0) {
                    maxElement = datum;
                }
            }
        }
        return maxElement;
    }

    public E getMin() {
        E minElement = null;
        if (!this.data.isEmpty()) {
            minElement = this.data.get(0);
            for (E datum : this.data) {
                if (datum.compareTo(minElement) < 0) {
                    minElement = datum;
                }
            }
        }
        return minElement;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        for (E element : this.data) {
            stringBuilder
                    .append(String.format("%s: %s", element.getClass().getName()
                            , element.toString()))
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < data.size();
            }

            @Override
            public E next() {
                E element = data.get(index);
                index++;
                return element;
            }
        };
    }
}
