package L2_Multidimentional_Arrays_exercise;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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

        StringBuilder[][] palindromeChars = new StringBuilder[numberOfRows][numberOfColums];
        List<StringBuilder> charWords = new LinkedList<>();

        int counterThree = 0;
        int counterTwo = 0;
        int counterOne = 0;

        StringBuilder stringBuilder = new StringBuilder();
        for (char firstChar = 'a'; firstChar <='z'; firstChar++) {
            counterOne++;
            for (char secondChar = firstChar; secondChar <= 'z'; secondChar++) {
                counterTwo++;
                for (char thirdChar = 'a'; thirdChar <= 'z'; thirdChar++) {
                    counterThree++;
                    if (firstChar == thirdChar) {
                        stringBuilder.append(firstChar);
                        stringBuilder.append(secondChar);
                        stringBuilder.append(thirdChar);

                        charWords.add(stringBuilder);
                    }
                    stringBuilder = new StringBuilder();
//                    if (counterThree == numberOfColums) {
//                        counterThree = 0;
//                        break;
//                    }
                }
                if (counterTwo == numberOfColums) {
                    counterTwo = 0;
                    break;
                }
            }
            if (counterOne == numberOfRows) {
                counterOne = 0;
                break;
            }
        }

        int counter = 0;
        for (int row = 0; row < numberOfRows; row++) {
            for (int colum = 0; colum < numberOfColums; colum++) {
                    StringBuilder word = charWords.get(counter++);
                    palindromeChars[row][colum] = word;

            }
        }
        for (int row = 0; row < palindromeChars.length; row++) {
            for (int colum = 0; colum < palindromeChars[row].length; colum++) {
                System.out.print(palindromeChars[row][colum] + " ");
            }
            System.out.println();
        }

    }
}
