package L5_Functional_Programing_exercise;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P5_Reverse_And_Exclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());
        Collections.reverse(numbers);

        Predicate<Integer> predicate = e -> e % n !=0;

        numbers
                .stream()
                .filter(e -> predicate.test(e))
                .forEach(e -> System.out.print(e + " "));

    }
}
