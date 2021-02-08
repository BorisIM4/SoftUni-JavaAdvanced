package L8_Generics_exercise.P4_Generic_Swap_Method_Integer;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfInputs = Integer.parseInt(scanner.nextLine());
        Box<Integer> box = new Box<>();
        for (int i = 0; i < numberOfInputs; i++) {
            int element = Integer.parseInt(scanner.nextLine());
            box.add(element);
        }
        int[] indexesForSwaping = Arrays
                .stream(scanner
                        .nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int firstIndex = indexesForSwaping[0];
        int secondIndex = indexesForSwaping[1];

        box.swap(firstIndex, secondIndex);

        System.out.println(box);
    }
}
