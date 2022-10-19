package Exam;

import java.util.Scanner;

public class P02_Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] snakeField = new String[size][size];

        int snakeRow = 0;
        int snakeCol = 0;

        int firstBarrowRow = 0;
        int firstBarrowCol = 0;

        int secondBarrowRow = 0;
        int secondBarrowCol = 0;

        boolean weFoundFirstBarrow = false;

        for (int row = 0; row < size; row++) {
            String[] input = scanner.nextLine().split("");

            for (int col = 0; col < size; col++) {
                snakeField[row][col] = input[col];

                if (snakeField[row][col].equals("S")){
                    snakeRow = row;
                    snakeCol = col;
                }

                if(snakeField[row][col].equals("B") && !weFoundFirstBarrow){
                    firstBarrowRow = row;
                    firstBarrowCol = col;
                    weFoundFirstBarrow = true;
                }

                if (snakeField[row][col].equals("B") && weFoundFirstBarrow){
                    secondBarrowRow = row;
                    secondBarrowCol = col;
                }

            }

        }
        int food = 0;

        while (food < 10){
            String command = scanner.nextLine();

            int oldRows = snakeRow;
            int oldCols = snakeCol;

            if(command.equals("up")){
                snakeRow--;

            }else if (command.equals("down")){
                snakeRow++;

            }else if (command.equals("left")){
                snakeCol--;

            }else if (command.equals("right")){

                snakeCol++;
            }

            if (snakeRow < 0 || snakeCol < 0 || snakeRow >= size || snakeCol >= size){

                snakeField[oldRows][oldCols] = ".";

                break;
            }

            if(snakeRow == firstBarrowRow && snakeCol == firstBarrowCol){
                snakeRow = secondBarrowRow;
                snakeCol = secondBarrowCol;
                snakeField[oldRows][oldCols] = ".";
                snakeField[firstBarrowRow][firstBarrowCol] = ".";
                snakeField[snakeRow][snakeCol] = "S";
            } else if (snakeRow == secondBarrowRow && snakeCol == secondBarrowCol){
                snakeRow = firstBarrowRow;
                snakeCol = firstBarrowCol;
                snakeField[oldRows][oldCols] = ".";
                snakeField[secondBarrowRow][secondBarrowCol] = ".";
                snakeField[snakeRow][snakeCol] = "S";
            }else if (snakeField[snakeRow][snakeCol].equals("-")){
                snakeField[oldRows][oldCols] = ".";
                snakeField[snakeRow][snakeCol] = "S";
            }else {
                food++;
                snakeField[oldRows][oldCols] = ".";
                snakeField[snakeRow][snakeCol] = "S";
            }

        }

        if (food >= 10){
            System.out.println("You won! You fed the snake.");

        }else {
            System.out.println("Game over!");
        }


        System.out.println("Food eaten: " + food);
        printMatrix(snakeField);
    }

    private static void printMatrix(String[][] snakeField) {

        for (int row = 0; row < snakeField.length; row++) {
            for (int cow = 0; cow < snakeField[row].length; cow++) {
                System.out.print(snakeField[row][cow]);

            }
            System.out.println();

        }
    }
}
