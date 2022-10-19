package L02_MultidimensionalArrays.Labs;

import java.util.Arrays;
import java.util.Scanner;

public class P05_MaximumSumOf2X2SubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine().split(", ")[0]);
        String splitPattern = ",\\s+";

        int maxSum = 0;


        int[][] matrix = readMatrix(rows, scanner, splitPattern);
        int[][] maxMatrix = new int[2][2];


        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1 ; col++) {
                int currentNumber = matrix[row][col];
                int inRight = matrix[row][col + 1];
                int inBottom = matrix[row + 1][col];
                int inBottomRight = matrix[row + 1][col + 1];

                int currentSum = currentNumber + inRight + inBottom + inBottomRight;

                if (maxSum < currentSum) {
                    maxSum = currentSum;
                    maxMatrix = new int[][]{
                            {currentNumber, inRight},
                            {inBottom, inBottomRight}
                    };

                }
            }

        }
        pintMatrix(maxMatrix);
        System.out.println(maxSum);


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

    public static void pintMatrix (int[][] matrix ){

        for (int row = 0; row < matrix.length; row++) {
            for (int cow = 0; cow < matrix[row].length; cow++) {
                System.out.print(matrix[row][cow] + " ");

            }
            System.out.println();

        }

    }

}
