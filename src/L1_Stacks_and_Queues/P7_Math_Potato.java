package L1_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P7_Math_Potato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queueOfnames = new ArrayDeque<>(
                Arrays.asList(scanner.nextLine()
                        .split("\\s+")));

        int numberOfCycles = Integer.parseInt(scanner.nextLine());
        int counter = 0;

        while (queueOfnames.size() > 1) {
            counter++;

            for (int i = 0; i < numberOfCycles; i++) {
                if (!(i == numberOfCycles - 1)) {
                    String name = queueOfnames.poll();
                    queueOfnames.offer(name);
                } else {
                    boolean isPrime;
                    if (counter < 2) {
                        isPrime = false;
                    } else {
                        isPrime = true;
                    }
                    for (int j = 2; j <= counter / j ; j++) {
                        if ((counter % j) == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                    if (isPrime) {
                        //is prime
                        System.out.printf("Prime %s%n" ,queueOfnames.peek());
                    } else {
                        //is not prime
                        String removeedname = queueOfnames.poll();
                        System.out.printf("Removed %s%n" ,removeedname);
                    }

                }

            }

        }

        System.out.printf("Last is %s%n" ,queueOfnames.peek());

    }
}
