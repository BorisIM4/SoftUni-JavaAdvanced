package L5_Functional_Programing;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1_Sort_Even_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        List<Integer> intArrayEven = Arrays.stream(input).map(Integer::parseInt).filter(e -> e % 2 == 0).collect(Collectors.toList());
        List<String> stringArrayEven = intArrayEven.stream().map(String::valueOf).collect(Collectors.toList());

        String printEvenElemen = String.join(", ", stringArrayEven);
        System.out.println(printEvenElemen);

        intArrayEven.sort(Integer::compareTo);
        List<String> stringArraySortedEven = intArrayEven.stream().map(String::valueOf).collect(Collectors.toList());

        String printStringArraySortedEven = String.join(", ", stringArraySortedEven);
        System.out.println(printStringArraySortedEven);
    }
}
