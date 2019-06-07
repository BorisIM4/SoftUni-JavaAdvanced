package L1_Stacks_and_Queues_exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P4_Basic_Queue_Operations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputArray = input.split("\\s+");

        int sizeOfQueue = Integer.parseInt(inputArray[0]);
        int numberOfPollElements = Integer.parseInt(inputArray[1]);
        int controlNumber = Integer.parseInt(inputArray[2]);

        String elementsAsString = scanner.nextLine();

        ArrayDeque<Integer> elementsAsQueue = new ArrayDeque<>();

        Arrays.stream(elementsAsString.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .limit(sizeOfQueue)
                .forEach(elementsAsQueue::offer);

        for (int i = 0; i < numberOfPollElements; i++) {
            elementsAsQueue.poll();
        }

        if (elementsAsQueue.size() == 0){
            System.out.println(0);
        } else {
            if (elementsAsQueue.contains(controlNumber)){
                System.out.println("true");
            } else {
                System.out.println(Collections.min(elementsAsQueue));
            }
        }
    }
}
