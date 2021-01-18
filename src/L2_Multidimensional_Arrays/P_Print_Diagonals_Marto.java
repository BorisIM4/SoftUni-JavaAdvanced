package L2_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P_Print_Diagonals_Marto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*
        Tova e zdacha ot Marto - Da otpechatam diagonalite - pyrvo cifrata 2
        , sled tova cifrite 3 i 4, sled tova 2, 2 i 4 i taka na tatyk.
4
1 2 3 2
1 1 2 4
1 2 1 4
2 2 3 1


3
1 2 3
1 2 3
1 2 3

        */

        int matrixSize = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {
            int[] elementInRow = Arrays
                    .stream(scanner
                            .nextLine()
                            .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int colum = 0; colum < elementInRow.length; colum++) {
                int currentElement = elementInRow[colum];
                matrix[row][colum] = currentElement;
            }
        }

        int row = 0, col = matrixSize - 1;

       while (row < matrixSize) {

           int innerRow = row;
           int innerCol = col;

           while (innerRow < matrixSize && innerCol < matrixSize) {
               System.out.print(matrix[innerRow++][innerCol++] + " ");
           }
           System.out.println();

           col--;
           if (col < 0) {
               col = 0;
               row++;
           }
       }
    }
}
