package L02_MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimensions = Integer.parseInt(scanner.nextLine());
        String splitPattern = "\\s+";

        int[][] matrix = readMatrix(dimensions, scanner, splitPattern);

        int firstDiagonalSum = 0;
        int rows = 0;
        int cols = 0;

        for (int row = 0; row < dimensions; row++) {
            firstDiagonalSum += matrix[rows][cols];
            rows++;
            cols++;

        }
        int secondDiagonalSum = 0;
        rows = 0;
        cols = dimensions - 1;

        for (int row = dimensions - 1; row >= 0; row--) {
            secondDiagonalSum += matrix[rows][cols];
            rows++;
            cols--;


        }
        System.out.println(Math.abs(firstDiagonalSum - secondDiagonalSum));

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
