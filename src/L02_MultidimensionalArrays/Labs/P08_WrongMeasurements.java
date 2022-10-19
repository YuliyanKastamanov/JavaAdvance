package L02_MultidimensionalArrays.Labs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P08_WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        String splitPattern = "\\s+";

        int[][] matrix = readMatrix(rows, scanner, splitPattern);

        String mistakenValue = scanner.nextLine();
        int mistakenNumber = matrix[Integer.parseInt(mistakenValue.split("\\s+")[0])][Integer.parseInt(mistakenValue.split("\\s+")[1])];
        List<int[]> newValues = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentNumber = matrix[row][col];

                if (currentNumber == mistakenNumber){
                    newValues.add(new int[] {row, col, getClosestItemSum(row, col, matrix, mistakenNumber) });
                }
            }
        }

        for (int [] value : newValues) {
            matrix[value[0]][value[1]] = value[2];
        }

        pintMatrix(matrix);
    }

    private static int getClosestItemSum(int row, int col, int[][] matrix, int mistakenNumber) {

        int sum = 0;
        if (isInBounds(row, col + 1, matrix) && matrix[row][col + 1] != mistakenNumber){
            sum += matrix[row][col + 1]; // right
        }

        if(isInBounds(row, col - 1, matrix) && matrix[row][col - 1] != mistakenNumber){
            sum += matrix[row][col - 1]; // left

        }

        if(isInBounds(row + 1, col, matrix) && matrix[row + 1][col] != mistakenNumber){
            sum += matrix[row + 1][col];  // down
        }

        if (isInBounds(row - 1, col, matrix) && matrix[row - 1][col] != mistakenNumber){
            sum += matrix[row - 1][col];  // up
        }
        return sum;



    }
    public static boolean isInBounds (int row, int col, int[][] matrix){
        return row >=0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    public static boolean isOutOfBounds (int row, int col, int[][] matrix){
        return !isInBounds(row, col, matrix);
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
