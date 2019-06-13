package L6_Defining_Classes_exercise.P6_Pokémon_Trainer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while (!"Tournament".equals(line = reader.readLine())) {

            String[] trainerData = line.split("\\s+");
            String name = trainerData[0];

            Trainer.trainers.putIfAbsent(name, new Trainer(name));
            Trainer trainer = Trainer.trainers.get(name);
            trainer.addPokemon(trainerData[1], trainerData[2], Integer.parseInt(trainerData[3]));
        }

        while (!"End".equals(line = reader.readLine())) {

            String element = line;
            Trainer.trainers
                    .values()
                    .forEach(trainer -> {
                        if (!trainer.containPokemon(element)) {
                            trainer.loseHealth();
                        }
                    });
        }

        Trainer.trainers
                .values()
                .stream()
                .sorted(Comparator.comparingInt(Trainer::getBadges).reversed())
                .forEach( e -> { System.out.println(String.format("%s %d %d", e.getName(), e.getBadges(), e.getPokemons().size())); });
    }
}