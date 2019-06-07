package L1_Stacks_and_Queues_exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P1_Reverse_Numbers_with_a_Stack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(stack::push);

        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
