package L1_Stacks_and_Queues_exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P4_Basic_Queue_Operations_v3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokenCommands = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int numberOfElements = tokenCommands[0];
        int numberOfElementsForDeletion = tokenCommands[1];
        int elementToBeCheck = tokenCommands[2];

        int[] elements = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numberOfElements; i++) {
            queue.offer(elements[i]);
        }

        if (numberOfElementsForDeletion > numberOfElements) {
            return;
        } else {
            if (queue.isEmpty()) {
                return;
            } else {
                for (int i = 0; i < numberOfElementsForDeletion; i++) {
                    queue.poll();
                }
            }
        }

        if (queue.contains(elementToBeCheck)) {
            System.out.println("true");
        } else {
            if (numberOfElements == numberOfElementsForDeletion) {
                System.out.println(0);
            } else {
                int minValue = Integer.MAX_VALUE;

                for (Integer integer : queue) {
                    if (integer < minValue) {
                        minValue = integer;
                    }
                }

                System.out.println(minValue);
            }
        }
    }
}
