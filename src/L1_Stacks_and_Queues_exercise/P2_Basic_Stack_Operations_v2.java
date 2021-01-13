package L1_Stacks_and_Queues_exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P2_Basic_Stack_Operations_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] operationNumbers = Arrays
                .stream(scanner
                        .nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int numberInputElements = operationNumbers[0];
        int numberPopElements = operationNumbers[1];
        int numberIsItContains = operationNumbers[2];

        int[] sequenceOfNumbers = Arrays
                .stream(scanner
                        .nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> stackOfInt = new ArrayDeque<>();

        for (int i = 0; i < sequenceOfNumbers.length; i++) {
            stackOfInt.push(sequenceOfNumbers[i]);
        }

        for (int i = 0; i < numberPopElements; i++) {
            stackOfInt.pop();
        }

        boolean contains = stackOfInt.contains(numberIsItContains);

        if (!stackOfInt.isEmpty()) {
            if (contains) {
                System.out.println(contains);
            } else {
                Integer min = Collections.min(stackOfInt);
                System.out.println(min);
            }
        } else {
            System.out.println("0");
        }
    }
}
