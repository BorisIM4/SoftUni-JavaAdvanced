package L2_Multidimentional_Arrays_exercise;

import java.util.Scanner;

public class P3_Diagonal_Difference_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int colum = 0; colum < line.length; colum++) {
                matrix[row][colum] = Integer.parseInt(line[colum]);
            }
        }

        int row = 0, col = 0;
        int primarySum = 0;
        while (row < size && col < size){
            primarySum += matrix[row][col];
            row++;
            col++;
        }

        row--;
        col = 0;

        int secondarySum = 0;
        while ( row >= 0 && col < size){
            secondarySum += matrix[row][col];

            row--;
            col++;
        }

        System.out.println(Math.abs(primarySum - secondarySum));
    }
}
