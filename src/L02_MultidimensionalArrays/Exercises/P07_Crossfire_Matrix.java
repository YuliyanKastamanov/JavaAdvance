package L02_MultidimensionalArrays.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P07_Crossfire_Matrix {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String dimensions = scanner.nextLine(); //"3 4" -> split -> ["3", "4"]
        int rows = Integer.parseInt(dimensions.split("\\s+")[0]);
        int cols = Integer.parseInt(dimensions.split("\\s+")[1]);

        int [][] matrix = new int [rows][cols];
        fillMatrix(rows, cols, matrix);

        String command = scanner.nextLine();
        while(!command.equals("Nuke it from orbit")) {
            //command = "3 3 2"
            int row = Integer.parseInt(command.split("\\s+")[0]);
            int col = Integer.parseInt(command.split("\\s+")[1]);
            int radius =  Integer.parseInt(command.split("\\s+")[2]);
            if (row < 0 || col < 0 || row > matrix.length - 1 || col > matrix[row].length - 1){
                command = scanner.nextLine();
               continue;
            }



            //махаме по редове -> започваме от: текущия ред - радиус до текущия ред + радиуса
            for (int rowToRemove = row - radius; rowToRemove <= row + radius ; rowToRemove++) {
                //проверка дали редът, който ще махна е в матрицата
                if (rowToRemove >= 0 && rowToRemove < rows) {
                    int[] currentCols = matrix[rowToRemove];
                    if (currentCols.length > col) {
                        matrix[rowToRemove][col] = 0;
                    }
                }
            }

            //махаме по колони -> започваме от: текуща колона - радиус до текуща колона + радиуса
            for (int colToRemove = col - radius; colToRemove <= col + radius; colToRemove++) {
                //проверка дали колоната, който ще махна е в матрицата
                if (colToRemove >= 0 && colToRemove < cols) {
                    int[] currentRow = matrix[row];
                    if (currentRow.length > colToRemove) {
                        matrix[row][colToRemove] = 0;
                    }
                }
            }


            matrix = removeAllZeroElements(matrix, rows);



            command = scanner.nextLine();
        }

        printMatrix(matrix);



    }

    private static int[][] removeAllZeroElements(int[][] matrix, int rows) {


        //TODO: премахваме всички 0
        //TODO: всички елементи в реда са 0 ->  трябва да премахнем реда
        //1    2   3   4   5
        //6    7   8   0   10
        //11   12  13  0   15
        //16   0   0   0    0
        //21   22  23  0    25
        List<List<Integer>> list = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            List<Integer> currentList = new ArrayList<>();
            for (int col = 0; col < matrix[row].length; col++) {
                int number = matrix[row][col];

                if (number != 0){
                    currentList.add(number);
                }

            }
            if(currentList.size() > 0){
                list.add(currentList);
            }

        }

        int[][] newMatrix = new int[list.size()][];
        for (int row = 0; row < list.size(); row++) {
            List<Integer> currentList = list.get(row);
            newMatrix[row] = currentList.stream().mapToInt(Integer::intValue).toArray();

        }
        return newMatrix;


    }

    private static void fillMatrix(int rows, int cols, int[][] matrix) {
        //fillMatrix
        int startNumber = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = startNumber++;
            }
        }
    }


    public static void printMatrix (int[][] matrix ){

        for (int row = 0; row < matrix.length; row++) {
            for (int cow = 0; cow < matrix[row].length; cow++) {
                System.out.print(matrix[row][cow] + " ");

            }
            System.out.println();

        }

    }
}
