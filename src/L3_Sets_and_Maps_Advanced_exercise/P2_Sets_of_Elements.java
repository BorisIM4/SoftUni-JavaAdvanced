package L3_Sets_and_Maps_Advanced_exercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P2_Sets_of_Elements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays
                .stream(scanner
                    .nextLine()
                    .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Set<Integer> set1 = new LinkedHashSet<>();
        Set<Integer> set2 = new LinkedHashSet<>();

        for (int i = 0; i < input[0]; i++) {
            set1.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i < input[1]; i++) {
            set2.add(Integer.parseInt(scanner.nextLine()));
        }
        set1.forEach(e-> {
            if (set2.contains(e)) {
                System.out.print( e + " ");
            }
        });

    }
}
