package L5_Functional_Programing;


import java.util.Arrays;
import java.util.Scanner;

public class P1_Sort_Even_Numbers_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .toArray();


        String inputAsString = Arrays.toString(input);

        String replace1 = inputAsString.replace("[", "");
        String replace2 = replace1.replaceAll("]", "");

        System.out.println(replace2);

        int[] result = Arrays.stream(replace2.split(", ")).mapToInt(Integer::parseInt)
                .sorted()
                .toArray();




    }
}
