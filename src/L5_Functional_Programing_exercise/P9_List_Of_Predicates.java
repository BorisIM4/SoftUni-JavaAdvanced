package L5_Functional_Programing_exercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P9_List_Of_Predicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        Set<Integer> numbersSet = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toCollection(HashSet::new));

        Predicate<Integer> intDivisible = num -> {
            for (Integer divider : numbersSet) {
                if (num % divider != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int i = 1; i <= number; i++) {
            if (intDivisible.test(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
