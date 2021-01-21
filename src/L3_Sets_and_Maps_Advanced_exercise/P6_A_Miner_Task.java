package L3_Sets_and_Maps_Advanced_exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P6_A_Miner_Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resources = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            int cuantity = Integer.parseInt(scanner.nextLine());

            if (resources.containsKey(input)) {
                resources.put(input, resources.get(input) + cuantity);
            } else {
                resources.put(input, cuantity);
            }

            input = scanner.nextLine();
        }

        resources.entrySet()
                .stream()
                .forEach(entry -> {
                    String resource = entry.getKey();
                    int cuantiry = entry.getValue();

                    System.out.println(String.format("%s -> %d" ,resource ,cuantiry));
                });
//        resources.forEach((resource, cuantity) -> {
//            System.out.println(String.format("%s -> %d" ,resource ,cuantity));
//        });
    }
}
