package L3_Sets_and_Maps_Advanced;

import java.util.*;
import java.util.stream.Collectors;

public class P7_Cities_by_Continent_and_country {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfInputs = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> citiesCountriesCountinents = new LinkedHashMap<>();

        for (int input = 0; input < numberOfInputs; input++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String countinent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            citiesCountriesCountinents.putIfAbsent(countinent, new LinkedHashMap<>());
            citiesCountriesCountinents.get(countinent).putIfAbsent(country, new LinkedList<>());
            citiesCountriesCountinents.get(countinent).get(country).add(city);

        }

        citiesCountriesCountinents.forEach((continent, rest) -> {
            System.out.printf("%s:%n",continent);
            rest.forEach((country, city) -> {
                System.out.printf(" %s -> " ,country);
                System.out.println(String.join(", ", city));
            });
        });
    }
}
