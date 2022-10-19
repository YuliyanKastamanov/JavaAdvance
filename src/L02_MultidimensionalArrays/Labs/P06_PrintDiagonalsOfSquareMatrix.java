package L02_MultidimensionalArrays.Labs;


import java.util.Arrays;
import java.util.Scanner;

public class P06_PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String splitPattern = "\\s+";

        int[][] matrix = readMatrix(size, scanner, splitPattern);

        int row = 0;
        int col = 0;

        for (int i = 0; i < matrix.length; i++) {

                System.out.print(matrix[row][col] + " ");
                row++;
                col++;

        }
        System.out.println();

        row = matrix.length - 1;
        col = 0;

        for (int i = 0; i < matrix.length; i++) {

            System.out.print(matrix[row][col] + " ");
            row--;
            col++;

        }





    }
    private static int[][] readMatrix(int rows, Scanner scanner, String splitPattern) {

        int[][] matrix = new int[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine()
                    .split(splitPattern))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        }
        return matrix;

    }

}
