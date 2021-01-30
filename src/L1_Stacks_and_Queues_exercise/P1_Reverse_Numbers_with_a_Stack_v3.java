package L1_Stacks_and_Queues_exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P1_Reverse_Numbers_with_a_Stack_v3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            stack.push(input[i]);
        }

        for (int i = 0; i < input.length; i++) {
            String pop = stack.pop();
            System.out.print(pop + " ");
        }
    }
}
