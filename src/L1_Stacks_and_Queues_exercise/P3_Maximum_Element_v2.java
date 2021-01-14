package L1_Stacks_and_Queues_exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P3_Maximum_Element_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stackOfInt = new ArrayDeque<>();

        for (int i = 0; i < numberOfCommands; i++) {
            String input = scanner.nextLine();

            if (input.split("\\s+")[0].equals("1")) {
                stackOfInt.push(Integer.parseInt(input.split("\\s+")[1]));
            } else if (Integer.parseInt(input) == 2) {
                stackOfInt.pop();
            } else if (Integer.parseInt(input) == 3) {
                int maxValue = Integer.MIN_VALUE;

                for (Integer integer : stackOfInt) {
                    if (maxValue < integer) {
                        maxValue = integer;
                    }
                }

                System.out.println(maxValue);
            }

        }

    }
}
