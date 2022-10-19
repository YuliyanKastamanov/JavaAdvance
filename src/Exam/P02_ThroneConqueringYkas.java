package Exam;

import java.util.Arrays;
import java.util.Scanner;

public class P02_ThroneConqueringYkas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[rows][];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        int parisRow = 0;
        int parisCol = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 'P'){
                    parisRow = row;
                    parisCol = col;
                }
            }
        }

        while (true){
            String[] command = scanner.nextLine().split("\\s+");

            String direction = command[0];
            int enemyRow = Integer.parseInt(command[1]);
            int enemyCol = Integer.parseInt(command[2]);

            matrix[parisRow][parisCol] = '-';
            matrix[enemyRow][enemyCol] = 'S';
            //преместване
            switch (direction) {
                case "up":
                    if (parisRow - 1 >= 0) {
                        parisRow--;
                    }
                    break;
                case "down":
                    if (parisRow + 1 < matrix.length) {
                        parisRow++;
                    }
                    break;
                case "left":
                    if (parisCol - 1 >= 0) {
                        parisCol--;
                    }
                    break;
                case "right":
                    if(parisCol + 1 < matrix.length) {
                        parisCol++;
                    }

                    break;
            }
            energy--;

            //2. проверка дали е умрял
            if (energy <= 0) {
                parisDead(matrix, parisRow, parisCol);
                return;
            }

            //3. има ли спартанец там където се е преместил
            if (matrix[parisRow][parisCol] == 'S') {
                //3.1. победа над спартанеца -> намаляме енергията с 2
                energy -= 2;
                //3.2 проверка дали е умрял -> ако енергията <= 0
                if (energy <= 0) {
                    parisDead(matrix, parisRow, parisCol);
                    return;
                } else {
                    matrix[parisRow][parisCol] = '-';
                }
            }
            //4. има ли Елена там където се е преместил
            else if (matrix[parisRow][parisCol] == 'H') {
                //4.1. на мястото, където е Елена -> слагаме -
                matrix[parisRow][parisCol] = '-';
                //4.2. отпечатване -> останала енергия
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
                //4.3. отпечатваме матрицата
                printField(matrix);
                return;
            }



        }


    }

    public static void parisDead(char[][] matrix, int parisRow, int parisCol) {
        //Парис умира
        //1. там където е бил слагаме X
        matrix[parisRow][parisCol] = 'X';
        //2. отпечатване -> къде е умрял
        System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
        //3. отпечатваме матрицата
        printField(matrix);
    }

    private static void printField(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }


}
