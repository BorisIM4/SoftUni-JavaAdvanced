package L3_Sets_and_Maps_Advanced_exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10_Population_Counter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //country       city    population
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
        //sortirame po kliuch
        populationInfo.entrySet()
                //puskame stream po entri seta za da go obhodim
                .stream()
                //sortirame dve dyrjavi
                .sorted((country1, country2) -> {
                    //definirame promenliva koqto da dyrji cqlata populaciq(ot vsichki gradove) na pyrvata dyrjava
                    long population1 = country1
                            //dostypva vytreshniq map v koito se sydryja informaciq za gradovete i populaciqta v tqh
                            .getValue()
                            //dostypva vsichki stojnosti vyv vytreshniq map( dostypva vsichki populacii po gradove)
                            .values()
                            //puskame steam za da moje da obhodim vsichki populacii
                            .stream()
                            //mapvame vsichki populacii kym LONG
                            .mapToLong(l -> l)
                            //sumira vsichki populacii, ot vsichki gradove za da gi izpolzvame za sravnqvaneto
                            .sum();
                    //definirame promenliva koqto da dyrji cqlata populaciq(ot vsichki gradove) na pyrvata dyrjava
                    long population2 = country2
                            //dostypva vytreshniq map v koito se sydryja informaciq za gradovete i populaciqta v tqh
                            .getValue()
                            //dostypva vsichki stojnosti vyv vytreshniq map( dostypva vsichki populacii po gradove)
                            .values()
                            //puskame steam za da moje da obhodim vsichki populacii
                            .stream()
                            //mapvame vsichki populacii kym LONG
                            .mapToLong(e -> e)
                            //sumira vsichki populacii, ot vsichki gradove za da gi izpolzvame za sravnqvaneto
                            .sum();
                    //funkciqta sort vryshtarezulata i tuk mu podavame veche razliakata mejdu populaciite na dvete dyrjavi
                    return Long.compare(population2, population1);
                //tuk obhojdame vsichki dyrvavi
                }).forEach(country -> {
                    //Syzdavame promenliva koqto da dyrji vsichki populacii
            long totalPopulation = country
                    //dostypvame vytreshniq MAP
                    .getValue()
                    //DOstypvame vsichki stojnosti po gradove
                    .values()
                    //Obhodvame vsichki populacii
                    .stream()
                    //mapvame vsichki populacii kym LONG
                    .mapToLong(e -> e)
                    //sumira vsichki populacii, ot vsichki gradove za da printirame populaciq na dyrjavata
                    .sum();
            System.out.println(String.format("%s (total population: %d)"
                    , country.getKey(), totalPopulation));
            Map<String, Long> cityInfo = country.getValue();
            cityInfo.entrySet()
                    .stream()
                    //sortiram gradovete v dyrjavata
                    .sorted((c1, c2) -> Long.compare(c2.getValue(), c1.getValue()))
                    .forEach(s -> System.out.println(String.format("=>%s: %d"
                            , s.getKey(), s.getValue())));
        });
    }
}
