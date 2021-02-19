package L10_Exam_Preparation_Two.Exam_2019_10_26.P3_Rabbits;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new LinkedList<>();

    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit) {
        if (this.data.size() < this.capacity) {
            data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        boolean isRemoveed = false;
        for (int i = 0; i < data.size(); i++) {
            Rabbit currentRabit = this.data.get(i);
            if (currentRabit.getName().equals(name)) {
                this.data.remove(i);
                isRemoveed = true;
            }
        }
        return isRemoveed;
    }

    public void removeSpecies(String species) {
        for (int i = 0; i < data.size(); i++) {
            Rabbit currentRabit = this.data.get(i);
            if (currentRabit.getSpecies().equals(species)) {
                this.data.remove(i);
            }
        }
    }

    public Rabbit sellRabbit(String name) {
        Rabbit currentRabbit = null;
        for (int i = 0; i < data.size(); i++) {
            currentRabbit = this.data.get(i);
            if (currentRabbit.getName().equals(name)) {
                currentRabbit.setAvailable(false);
                break;
            }
        }
        return currentRabbit;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        Rabbit currentRabbit = null;
        List<Rabbit> speciesList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            currentRabbit = this.data.get(i);
            if (currentRabbit.getSpecies().equals(species)) {
                speciesList.add(currentRabbit);
                currentRabbit.setAvailable(false);
            }
        }
        return speciesList;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Rabbits available at " + this.name + ":");
        stringBuilder.append(System.lineSeparator());
        for (Rabbit rabbit : this.data) {
            if (rabbit.isAvailable()) {
                stringBuilder.append(rabbit.toString())
                        .append(System.lineSeparator());
            }
        }

        return stringBuilder.toString().trim();
    }
}
