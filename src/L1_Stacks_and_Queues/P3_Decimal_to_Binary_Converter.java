package L1_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P3_Decimal_to_Binary_Converter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (input == 0){
            stack.push(0);
        }

        while (input != 0){

            if (input % 2 == 0){
                stack.push(0);
                input = input / 2;
            } else {
                stack.push(1);
                input = input / 2;
            }
        }

        for (Integer integer : stack) {
            System.out.print(integer);
        }
    }
}
