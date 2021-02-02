package L5_Functional_Programing_exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11_The_Party_Reservation_Filter_Module {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Map<String, Predicate<String>> predicates = new HashMap<>();

        String line = "";
        while (!"Print".equals(line = scanner.nextLine())) {
            String[] tokens = line.split(";");
            String predicateName = tokens[1] + tokens[2];

            if (tokens[0].contains("Add")) {
                Predicate<String> predicate = getPredicate(tokens);
                predicates.put(predicateName, predicate);
            } else {
                //remove
                predicates.remove(predicateName);
            }
        }

        guests.stream().filter(guest -> {
            boolean isValid = true;
            for (Predicate<String> predicate : predicates.values()) {
                if (predicate.test(guest)) {
                    isValid = false;
                    break;
                }
            }

            return isValid;
        }).forEach(e -> System.out.print(e + " "));
    }

    private static Predicate<String> getPredicate(String[] tokens) {
        Predicate<String> predicate = null;

        switch (tokens[1]) {
            case "Starts with":
                predicate = name -> name.startsWith(tokens[2]);
                break;
            case "Ends with":
                predicate = name -> name.endsWith(tokens[2]);
                break;
            case "Lenght":
                predicate = name -> name.length() == Integer.parseInt(tokens[2]);
                break;
            default:
                //contains
                predicate = name -> name.contains(tokens[2]);
                break;
        }

        return predicate;
    }
}
