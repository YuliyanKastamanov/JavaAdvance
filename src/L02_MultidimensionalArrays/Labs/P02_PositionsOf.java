package L02_MultidimensionalArrays.Labs;

import java.util.Arrays;
import java.util.Scanner;

public class P02_PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int rows = Integer.parseInt(input.split("\\s+")[0]);
        String splitPattern = "\\s+";

        int[][] matrix = readMatrix(rows, scanner, splitPattern);

        int numberToFind = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;
        for (int row = 0; row < matrix.length; row++) {
            for (int cow = 0; cow < matrix[row].length; cow++) {
                if (matrix[row][cow] == numberToFind) {
                    System.out.println(row + " " + cow);
                    isFound = true;
                }
            }

        }
        if (!isFound) {
            System.out.println("not found");
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
