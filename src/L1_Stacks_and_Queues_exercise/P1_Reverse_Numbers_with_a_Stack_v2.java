package L1_Stacks_and_Queues_exercise;

import java.util.*;

public class P1_Reverse_Numbers_with_a_Stack_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputAsArr = input.split("\\s+");

        ArrayDeque<String> numbers = new ArrayDeque<>();

        for (int i = 0; i < inputAsArr.length; i++) {
            numbers.push(inputAsArr[i]);
        }

        for (int i = 0; i < inputAsArr.length; i++) {
            System.out.print(numbers.pop() + " ");
        }

    }
}
