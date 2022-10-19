package L02_MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);

        String [][] matrix = new String[rows][cols];

        fillMatrix(matrix, rows, cols);

        printMatrix(matrix);



    }

    private static void fillMatrix(String [][] matrix, int rows, int cols) {


        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char char1And3 = (char) (97 + row);
                char char2 = (char) (97 + row + col);
                String stringToFill = new StringBuilder().append(char1And3).append(char2).append(char1And3).toString();

                matrix[row][col] = stringToFill;

            }

        }

    }
    public static void printMatrix (String[][] matrix ){

        for (int row = 0; row < matrix.length; row++) {
            for (int cow = 0; cow < matrix[row].length; cow++) {
                System.out.print(matrix[row][cow] + " ");

            }
            System.out.println();

        }

    }

}
