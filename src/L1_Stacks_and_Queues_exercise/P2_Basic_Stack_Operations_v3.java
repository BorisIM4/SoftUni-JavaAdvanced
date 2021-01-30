package L1_Stacks_and_Queues_exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P2_Basic_Stack_Operations_v3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] commandsArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int numbersOfElementInStack = commandsArr[0];
        int numbersOfElementToPopFromStack = commandsArr[1];
        int controlNumberForCheck = commandsArr[2];

        if (numbersOfElementToPopFromStack > numbersOfElementInStack) {
            return;
        } else if ( numbersOfElementToPopFromStack == numbersOfElementInStack) {
            System.out.println(0);
            return;
        }

        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer>  stack = new ArrayDeque<>();
        for (int i = 0; i < numbersOfElementInStack; i++) {
            stack.push(tokens[i]);
        }

        for (int i = 0; i < numbersOfElementToPopFromStack; i++) {
            stack.pop();
        }

        if (stack.contains(controlNumberForCheck)) {
            System.out.println("true");
        } else {
            int maxValue = Integer.MAX_VALUE;

            for (Integer integer : stack) {
                if (integer < maxValue && integer > 0) {
                    maxValue = integer;
                }
            }

            System.out.println(maxValue);
        }
    }
}
