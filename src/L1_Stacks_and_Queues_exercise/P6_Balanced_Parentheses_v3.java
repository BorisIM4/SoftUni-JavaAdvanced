package L1_Stacks_and_Queues_exercise;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class P6_Balanced_Parentheses_v3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        if (!(input.length() % 2 == 0)) {
            System.out.println("NO");
            return;
        }

        ArrayDeque<Character> parantheses = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == '{' || currentChar == '[' || currentChar == '(') {
                parantheses.push(currentChar);
            } else if (currentChar == '}' || currentChar == ']' || currentChar == ')') {
                if (parantheses.isEmpty()) {
                    System.out.println("NO");
                    return;
                }
                char prevuousParanthes = parantheses.peek();

                if ((prevuousParanthes == '{' && currentChar != '}')
                        || (prevuousParanthes == '[' && currentChar != ']')
                        || (prevuousParanthes == '(' && currentChar != ')')) {
                    System.out.println("NO");
                    return;
                } else {
                    char popElement = parantheses.pop();
                }
            }
        }
        System.out.println("YES");
    }
}