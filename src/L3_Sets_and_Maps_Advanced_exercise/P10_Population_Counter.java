package L3_Sets_and_Maps_Advanced_exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10_Population_Counter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Long>> populationInfo = new LinkedHashMap<>();

        String line = "";
        while (!"report".equals(line = scanner.nextLine())) {
            String[] tokens = line.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            populationInfo.putIfAbsent(country, new LinkedHashMap<>());
            populationInfo.get(country).putIfAbsent(city, population);

        }
        populationInfo.entrySet()
                .stream()
                .sorted((country1, country2) -> {
                    long population1 = country1.getValue()
                            .values()
                            .stream()
                            .mapToLong(l -> l)
                            .sum();
                    long population2 = country2.getValue()
                            .values()
                            .stream()
                            .mapToLong(e -> e)
                            .sum();

                    return Long.compare(population2, population1);
                }).forEach(c -> {
            long totalPopulation = c.getValue()
                    .values()
                    .stream()
                    .mapToLong(e -> e)
                    .sum();
            System.out.println(String.format("%s (total population: %d)"
                    ,c.getKey() ,totalPopulation));
            Map<String, Long> cityInfo = c.getValue();
            cityInfo.entrySet()
                    .stream()
                    .sorted((c1, c2) -> Long.compare(c2.getValue(), c1.getValue()))
                    .forEach(s -> System.out.println(String.format("=>%s: %d"
                            ,s.getKey() ,s.getValue())));
        });
    }
}
