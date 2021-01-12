package L1_Stacks_and_Queues;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P2_Simple_Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stringArr = scanner.nextLine().split("\\s+");
        List<String> stringAsList = Arrays.asList(stringArr);

        ArrayDeque<String> stack = new ArrayDeque<>(stringAsList);

        while (stack.size() > 1){
            int first = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int second = Integer.parseInt(stack.pop());

            if (operator.equals("+")){
                int currInt = first + second;
                String currIntAsString = currInt + "";
                stack.push(currIntAsString);
            } else {
                int currInt = first - second;
                String currIntAsString = currInt + "";
                stack.push(currIntAsString);
            }
        }
        System.out.println(stack.peek());
    }
}
