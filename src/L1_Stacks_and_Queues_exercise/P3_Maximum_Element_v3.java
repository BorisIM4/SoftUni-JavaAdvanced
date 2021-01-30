package L1_Stacks_and_Queues_exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P3_Maximum_Element_v3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfRotation = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < numberOfRotation; i++) {
            int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (1 == input[0]) {
                int currentnumber = input[1];
                stack.push(currentnumber);
            } else  if (2 == input[0]) {
                stack.pop();
            } else if (3 == input[0]) {
                int maxValue = Integer.MIN_VALUE;

                for (Integer integer : stack) {
                    if (integer > maxValue) {
                        maxValue = integer;
                    }
                }

                System.out.println(maxValue);
            }
        }
    }
}
