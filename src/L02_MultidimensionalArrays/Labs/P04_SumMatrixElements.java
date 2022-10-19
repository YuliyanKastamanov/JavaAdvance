package L02_MultidimensionalArrays.Labs;

import java.util.Arrays;
import java.util.Scanner;

public class P04_SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int rows = Integer.parseInt(input.split(",\\s+")[0]);
        int cols = Integer.parseInt(input.split(",\\s+")[1]);
        String splitPattern = ",\\s+";

        int[][] matrix = readMatrix(rows, scanner, splitPattern);

        int sum = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int currentNumber = matrix[row][col];
                sum+=currentNumber;

            }

        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);




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
