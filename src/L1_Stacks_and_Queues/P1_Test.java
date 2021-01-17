package L1_Stacks_and_Queues;

import java.util.*;

public class P1_Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(scanner
                    .nextLine()
                    .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(stack::push);

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        Arrays.stream(scanner
                .nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(queue::offer);
        System.out.println();

    }
}
