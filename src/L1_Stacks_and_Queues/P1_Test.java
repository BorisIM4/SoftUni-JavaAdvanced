package L1_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P1_Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        System.out.println("Hello World!");

        ArrayDeque<Integer> test = new ArrayDeque<>();

        for (int i = 0; i < 10; i++) {
            test.offer(i);
        }


        System.out.println(test.poll());

        System.out.println(test.pop());
    }
}
