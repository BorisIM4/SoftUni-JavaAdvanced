package L5_Functional_Programing_exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class P4_Applied_Arithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner
                        .nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], int[]> addOne = arr -> Arrays.stream(arr)
                .map(num -> num += 1)
                .toArray();
        Function<int[], int[]> multiplayBytwo = arr -> Arrays.stream(arr)
                .map(num -> num *= 2)
                .toArray();

        Consumer<int[]> printConsumer = arr -> Arrays.stream(arr)
                .forEach(e -> System.out.print(e + " "));

        String command = "";
        while (!"end".equals(command = scanner.nextLine())) {
            switch (command) {
                case "add":
                    numbers = addOne.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplayBytwo.apply(numbers);
                    break;
                case "subtract":
                    numbers = substractOne(numbers);
                    break;
                case "print":
                    printConsumer.accept(numbers);
                    System.out.println();
                    break;
            }
        }
    }

    public static int[] substractOne(int[] numbers) {
        return Arrays.stream(numbers)
                .map(num -> num -= 1)
                .toArray();
    }


}
