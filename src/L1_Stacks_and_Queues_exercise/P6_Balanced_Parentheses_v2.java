package L1_Stacks_and_Queues_exercise;

import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Scanner;

public class P6_Balanced_Parentheses_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputBrackets = scanner.nextLine();

        ArrayDeque<Character> stackOfBracketsLeftSide = new ArrayDeque<>();
        ArrayDeque<Character> queueOfbracketsrightSide = new ArrayDeque<>();

        boolean isBalanced = false;
        if (!(inputBrackets.length() % 2 == 0)) {
            System.out.println("NO");
        } else {
            for (int i = 0; i < inputBrackets.length(); i++) {
                if (i < inputBrackets.length() / 2) {
                    char currentSymbol = inputBrackets.charAt(i);
                    stackOfBracketsLeftSide.push(currentSymbol);
                } else {
                    char currentSymbol = inputBrackets.charAt(i);
                    queueOfbracketsrightSide.offer(currentSymbol);
                }

            }
            for (int i = 0; i < inputBrackets.length() / 2; i++) {
                Character charFromStack = stackOfBracketsLeftSide.pop();
                Character charFromQueue = queueOfbracketsrightSide.poll();

                if (charFromStack == '(' && charFromQueue == ')') {
                    isBalanced = true;
                } else if (charFromStack == '{' && charFromQueue == '}') {
                    isBalanced = true;
                } else if (charFromStack == '[' && charFromQueue == ']') {
                    isBalanced = true;
                } else if (charFromStack == ' ' && charFromQueue == ' ') {
                    isBalanced = true;
                } else{
                    isBalanced = false;
                    break;
                }

            }

        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


    }
}