package L5_Functional_Programing_exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P2_Knights_of_Honor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> consumer = name -> System.out.println("Sir " + name);

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(consumer);

    }
}
