package L10_Exam_Preparation_Two.Exam_2019_12_17.P2_Present_Delivery;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPresents = Integer.parseInt(scanner.nextLine());

        int matrixSize = Integer.parseInt(scanner.nextLine());

        int santaPositionRow = -1;
        int santaPositionColum = -1;

        int totalNiceKidsInNeighborhood = 0;

        String[][] matrix = new String[matrixSize][matrixSize];
        for (int row = 0; row < matrixSize; row++) {
            String[] tokens = scanner.nextLine().split(" ");
            for (int colum = 0; colum < matrixSize; colum++) {
                String currentElement = tokens[colum];
                matrix[row][colum] = currentElement;

                // Find Santa position
                if (currentElement.equals("S")) {
                    santaPositionRow = row;
                    santaPositionColum = colum;
                }
                // Count Nice kids
                if (currentElement.equals("V")) {
                    totalNiceKidsInNeighborhood++;
                }
            }
        }
        int niceKidsWithOutPresent = totalNiceKidsInNeighborhood;
        String line = "";
        while (numberOfPresents > 0 && !"Christmas morning".equals(line = scanner.nextLine())) {
            if ("left".equals(line)) {
                if (!isOutOfBounds(santaPositionRow, santaPositionColum - 1, matrix)) {
                    matrix[santaPositionRow][santaPositionColum] = "-";
                    santaPositionColum -= 1;
                    String currentElement = matrix[santaPositionRow][santaPositionColum];
                    matrix[santaPositionRow][santaPositionColum] = "S";
                    if ("V".equals(currentElement)) {
                        numberOfPresents--;
                        niceKidsWithOutPresent--;
                    } else if ("C".equals(currentElement)) {
                        //left to a cooke
                        if (matrix[santaPositionRow][santaPositionColum - 1].equals("X")) {
                            matrix[santaPositionRow][santaPositionColum - 1] = "-";
                            numberOfPresents--;
                        } else if (matrix[santaPositionRow][santaPositionColum - 1].equals("V")) {
                            matrix[santaPositionRow][santaPositionColum - 1] = "-";
                            numberOfPresents--;
                            niceKidsWithOutPresent--;
                        }
                        //right to a cooke
                        if (matrix[santaPositionRow][santaPositionColum + 1].equals("X")) {
                            matrix[santaPositionRow][santaPositionColum + 1] = "-";
                            numberOfPresents--;
                        } else if (matrix[santaPositionRow][santaPositionColum + 1].equals("V")) {
                            matrix[santaPositionRow][santaPositionColum + 1] = "-";
                            numberOfPresents--;
                            niceKidsWithOutPresent--;
                        }
                        //up to a cooke
                        if (matrix[santaPositionRow - 1][santaPositionColum].equals("X")) {
                            matrix[santaPositionRow - 1][santaPositionColum] = "-";
                            numberOfPresents--;
                        } else if (matrix[santaPositionRow - 1][santaPositionColum].equals("V")) {
                            matrix[santaPositionRow - 1][santaPositionColum] = "-";
                            numberOfPresents--;
                            niceKidsWithOutPresent--;
                        }
                        //down to a cooke
                        if (matrix[santaPositionRow + 1][santaPositionColum].equals("X")) {
                            matrix[santaPositionRow + 1][santaPositionColum] = "-";
                            numberOfPresents--;
                        } else if (matrix[santaPositionRow + 1][santaPositionColum].equals("V")) {
                            matrix[santaPositionRow + 1][santaPositionColum] = "-";
                            numberOfPresents--;
                            niceKidsWithOutPresent--;
                        }
                    }
                }
            } else if ("right".equals(line)) {
                if (!isOutOfBounds(santaPositionRow, santaPositionColum + 1, matrix)) {
                    matrix[santaPositionRow][santaPositionColum] = "-";
                    santaPositionColum += 1;
                    String currentElement = matrix[santaPositionRow][santaPositionColum];
                    matrix[santaPositionRow][santaPositionColum] = "S";
                    if (currentElement.equals("V")) {
                        numberOfPresents--;
                        niceKidsWithOutPresent--;
                    } else if ("C".equals(currentElement)) {
                        //left to a cooke
                        if (matrix[santaPositionRow][santaPositionColum - 1].equals("X")) {
                            matrix[santaPositionRow][santaPositionColum - 1] = "-";
                            numberOfPresents--;
                        } else if (matrix[santaPositionRow][santaPositionColum - 1].equals("V")) {
                            matrix[santaPositionRow][santaPositionColum - 1] = "-";
                            numberOfPresents--;
                            niceKidsWithOutPresent--;
                        }
                        //right to a cooke
                        if (matrix[santaPositionRow][santaPositionColum + 1].equals("X")) {
                            matrix[santaPositionRow][santaPositionColum + 1] = "-";
                            numberOfPresents--;
                        } else if (matrix[santaPositionRow][santaPositionColum + 1].equals("V")) {
                            matrix[santaPositionRow][santaPositionColum + 1] = "-";
                            numberOfPresents--;
                            niceKidsWithOutPresent--;
                        }
                        //up to a cooke
                        if (matrix[santaPositionRow - 1][santaPositionColum].equals("X")) {
                            matrix[santaPositionRow - 1][santaPositionColum] = "-";
                            numberOfPresents--;
                        } else if (matrix[santaPositionRow - 1][santaPositionColum].equals("V")) {
                            matrix[santaPositionRow - 1][santaPositionColum] = "-";
                            numberOfPresents--;
                            niceKidsWithOutPresent--;
                        }
                        //down to a cooke
                        if (matrix[santaPositionRow + 1][santaPositionColum].equals("X")) {
                            matrix[santaPositionRow + 1][santaPositionColum] = "-";
                            numberOfPresents--;
                        } else if (matrix[santaPositionRow + 1][santaPositionColum].equals("V")) {
                            matrix[santaPositionRow + 1][santaPositionColum] = "-";
                            numberOfPresents--;
                            niceKidsWithOutPresent--;
                        }
                    }
                }
            } else if ("up".equals(line)) {
                if (!isOutOfBounds(santaPositionRow - 1, santaPositionColum, matrix)) {
                    matrix[santaPositionRow][santaPositionColum] = "-";
                    santaPositionRow -= 1;
                    String currentElement = matrix[santaPositionRow][santaPositionColum];
                    matrix[santaPositionRow][santaPositionColum] = "S";
                    if (currentElement.equals("V")) {
                        numberOfPresents--;
                        niceKidsWithOutPresent--;
                    } else if ("C".equals(currentElement)) {
                        //left to a cooke
                        if (matrix[santaPositionRow][santaPositionColum - 1].equals("X")) {
                            matrix[santaPositionRow][santaPositionColum - 1] = "-";
                            numberOfPresents--;
                        } else if (matrix[santaPositionRow][santaPositionColum - 1].equals("V")) {
                            matrix[santaPositionRow][santaPositionColum - 1] = "-";
                            numberOfPresents--;
                            niceKidsWithOutPresent--;
                        }
                        //right to a cooke
                        if (matrix[santaPositionRow][santaPositionColum + 1].equals("X")) {
                            matrix[santaPositionRow][santaPositionColum + 1] = "-";
                            numberOfPresents--;
                        } else if (matrix[santaPositionRow][santaPositionColum + 1].equals("V")) {
                            matrix[santaPositionRow][santaPositionColum + 1] = "-";
                            numberOfPresents--;
                            niceKidsWithOutPresent--;
                        }
                        //up to a cooke
                        if (matrix[santaPositionRow - 1][santaPositionColum].equals("X")) {
                            matrix[santaPositionRow - 1][santaPositionColum] = "-";
                            numberOfPresents--;
                        } else if (matrix[santaPositionRow - 1][santaPositionColum].equals("V")) {
                            matrix[santaPositionRow - 1][santaPositionColum] = "-";
                            numberOfPresents--;
                            niceKidsWithOutPresent--;
                        }
                        //down to a cooke
                        if (matrix[santaPositionRow + 1][santaPositionColum].equals("X")) {
                            matrix[santaPositionRow + 1][santaPositionColum] = "-";
                            numberOfPresents--;
                        } else if (matrix[santaPositionRow + 1][santaPositionColum].equals("V")) {
                            matrix[santaPositionRow + 1][santaPositionColum] = "-";
                            numberOfPresents--;
                            niceKidsWithOutPresent--;
                        }
                    }
                }
            } else if ("down".equals(line)) {
                if (!isOutOfBounds(santaPositionRow + 1, santaPositionColum, matrix)) {
                    matrix[santaPositionRow][santaPositionColum] = "-";
                    santaPositionRow += 1;
                    String currentElement = matrix[santaPositionRow][santaPositionColum];
                    matrix[santaPositionRow][santaPositionColum] = "S";
                    if (currentElement.equals("V")) {
                        numberOfPresents--;
                        niceKidsWithOutPresent--;
                    } else if ("C".equals(currentElement)) {
                        //left to a cooke
                        if (matrix[santaPositionRow][santaPositionColum - 1].equals("X")) {
                            matrix[santaPositionRow][santaPositionColum - 1] = "-";
                            numberOfPresents--;
                        } else if (matrix[santaPositionRow][santaPositionColum - 1].equals("V")) {
                            matrix[santaPositionRow][santaPositionColum - 1] = "-";
                            numberOfPresents--;
                            niceKidsWithOutPresent--;
                        }
                        //right to a cooke
                        if (matrix[santaPositionRow][santaPositionColum + 1].equals("X")) {
                            matrix[santaPositionRow][santaPositionColum + 1] = "-";
                            numberOfPresents--;
                        } else if (matrix[santaPositionRow][santaPositionColum + 1].equals("V")) {
                            matrix[santaPositionRow][santaPositionColum + 1] = "-";
                            numberOfPresents--;
                            niceKidsWithOutPresent--;
                        }
                        //up to a cooke
                        if (matrix[santaPositionRow - 1][santaPositionColum].equals("X")) {
                            matrix[santaPositionRow - 1][santaPositionColum] = "-";
                            numberOfPresents--;
                        } else if (matrix[santaPositionRow - 1][santaPositionColum].equals("V")) {
                            matrix[santaPositionRow - 1][santaPositionColum] = "-";
                            numberOfPresents--;
                            niceKidsWithOutPresent--;
                        }
                        //down to a cooke
                        if (matrix[santaPositionRow + 1][santaPositionColum].equals("X")) {
                            matrix[santaPositionRow + 1][santaPositionColum] = "-";
                            numberOfPresents--;
                        } else if (matrix[santaPositionRow + 1][santaPositionColum].equals("V")) {
                            matrix[santaPositionRow + 1][santaPositionColum] = "-";
                            numberOfPresents--;
                            niceKidsWithOutPresent--;
                        }
                    }
                }
            }
        }

        //final checks and prints
        if (numberOfPresents == 0) {
            System.out.println("Santa ran out of presents!");
        }
        printMatrix(matrix);
        if (niceKidsWithOutPresent == 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", totalNiceKidsInNeighborhood);
        } else {
            System.out.printf("No presents for %d nice kid/s.", niceKidsWithOutPresent);
        }





    }

    private static boolean isOutOfBounds(int row, int col, String[][] matrix) {
        return row >= matrix.length || row < 0 || col >= matrix[row].length || col < 0;
    }

    private static void printMatrix(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}
