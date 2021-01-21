package L2_Multidimentional_Arrays_exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P2_Matrix_of_Palindromes_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensionsOfMatrix = Arrays
                .stream(scanner
                        .nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int numberOfRows = dimensionsOfMatrix[0];
        int numberOfColums = dimensionsOfMatrix[1];



    }
}
