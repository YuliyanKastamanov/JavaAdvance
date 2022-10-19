package Exam;

import java.util.Scanner;

public class Matrix_Skeleton_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int size = Integer.parseInt(scanner.nextLine());

        String[][] snakeField = new String[size][size];

        int currentRow = 0;
        int currentCol = 0;

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
                    currentRow = row;
                    currentCol = col;
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

            int oldRows = currentRow;
            int oldCols = currentCol;

            if(command.equals("up")){
                currentRow--;

            }else if (command.equals("down")){
                currentRow++;

            }else if (command.equals("left")){
                currentCol--;

            }else if (command.equals("right")){

                currentCol++;
            }
        }
    }

}
