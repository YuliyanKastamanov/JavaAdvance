package L02_MultidimensionalArrays.Exercises;

import java.util.Scanner;

public class P01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int dimensions = Integer.parseInt(input.split(", ")[0]);
        String pattern = input.split(", ")[1];

        int[][] matrix = new int[dimensions][dimensions];

        if (pattern.equals("A")){
            readMatrixPatternA(matrix);
        } else if(pattern.equals("B")){
            readMatrixPatternB(matrix);
        }
       printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }


    private static void readMatrixPatternB(int[][] matrix) {
        int startNumber = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0){
                for (int row = 0; row < matrix.length; row++) {

                    matrix[row][col] = startNumber++;
                }
            }else if(col % 2 == 1){
                for (int row = matrix.length - 1; row >= 0 ; row--) {

                    matrix[row][col] = startNumber++;
                }
            }


        }

    }

    private static void readMatrixPatternA(int[][] matrix) {

        int startNumber = 1;

        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = startNumber++;
                
            }
            
        }
    }


}
