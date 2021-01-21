package L3_Sets_and_Maps_Advanced;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P4_Count_Real_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] input = Arrays
                .stream(scanner
                        .nextLine()
                        .split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> mapOfNumbers = new LinkedHashMap<>();

        for (int number = 0; number < input.length; number++) {
            double currentElement = input[number];
            mapOfNumbers.putIfAbsent(currentElement, 0);
            if (mapOfNumbers.containsKey(currentElement)) {
                int currentElementInt = mapOfNumbers.get(currentElement);
                currentElementInt++;
                mapOfNumbers.put(currentElement, currentElementInt);

            }
        }
        for (Map.Entry<Double, Integer> entry:mapOfNumbers.entrySet()) {
            System.out.printf("%.1f -> %d%n" ,entry.getKey() , entry.getValue());
        }

    }
}
