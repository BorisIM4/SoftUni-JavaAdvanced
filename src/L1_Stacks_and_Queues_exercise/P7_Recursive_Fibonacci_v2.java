package L1_Stacks_and_Queues_exercise;

import java.util.Scanner;

public class P7_Recursive_Fibonacci_v2 {

    public static long[] fibonacciArr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        fibonacciArr = new long[number + 1];

        long result = getFionacci(number);

        System.out.println(result);
    }

    public static long getFionacci(int n) {
        if (n == 1 || n == 0) {
            return  1;
        }

        if (fibonacciArr[n] != 0) {
            return fibonacciArr[n];
        }

        return fibonacciArr[n] =  getFionacci(n - 1) + getFionacci(n - 2);

    }
}
