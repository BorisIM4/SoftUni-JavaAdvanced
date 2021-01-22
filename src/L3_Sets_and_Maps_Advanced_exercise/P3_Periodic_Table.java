package L3_Sets_and_Maps_Advanced_exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P3_Periodic_Table {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfinputs = Integer.parseInt(scanner.nextLine());

        Set<String> periodicalTable = new TreeSet<>();

        for (int i = 0; i < numberOfinputs; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            periodicalTable.addAll(Arrays.asList(input));
        }
        periodicalTable.forEach(elemet -> {
            System.out.print(elemet + " ");
        });
    }
}
