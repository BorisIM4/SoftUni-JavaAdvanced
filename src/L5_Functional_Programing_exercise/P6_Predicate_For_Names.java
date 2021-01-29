package L5_Functional_Programing_exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class P6_Predicate_For_Names {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nameMaxLenght = Integer.parseInt(scanner.nextLine());

        Predicate<String> predicate = name -> name.length() <= nameMaxLenght;

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(predicate)
                .forEach(name -> System.out.println(name));
    }
}
