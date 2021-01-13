package L1_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P4_Matching_Brackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Integer> stackOfindexOfBrackets = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            String element = input.charAt(i) + "";

            if (element.equals("(")) {
                stackOfindexOfBrackets.push(i);
            } else if (element.equals(")")){
                int startOfSubString = stackOfindexOfBrackets.pop();
                int endOdSubString = i;
                String output = input.substring(startOfSubString, endOdSubString + 1);
                System.out.println(output);
            }
        }

    }
}
