package L5_Functional_Programing_exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P1_Consumer_Print {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> consumer = (String name) -> System.out.println(name);
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(consumer);
    }
}
