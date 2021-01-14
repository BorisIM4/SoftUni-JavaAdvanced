package L1_Stacks_and_Queues_exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P4_Basic_Queue_Operations_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] operators = scanner.nextLine().split("\\s+");

        int numberOfElement = Integer.parseInt(operators[0]);
        int numberOfPollElement = Integer.parseInt(operators[1]);
        int valueTobeChecked = Integer.parseInt(operators[2]);

        String[] inputData = scanner.nextLine().split("\\s+");
//        ArrayDeque<String> queueOfIntsTest = new ArrayDeque<>(Arrays.asList(inputData));
        ArrayDeque<Integer> queueOfInts = new ArrayDeque<>();


        for (String element : inputData) {
            queueOfInts.addLast(Integer.parseInt(element));
        }

        if (numberOfElement == numberOfPollElement) {
            System.out.println(0);
            return;
        } else {
            for (int i = 0; i < numberOfPollElement; i++) {
                queueOfInts.poll();
            }
        }

        if (queueOfInts.contains(valueTobeChecked)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(queueOfInts));
        }


    }
}
