package Exam;

import java.util.Scanner;

public class P02_PresentDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int presentsCount = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());

        String[][] neighborhood  = new String[size][size];

        int currentRow = 0;
        int currentCol = 0;
        int niceKids = 0;

        for (int row = 0; row < size; row++) {
            String[] input = scanner.nextLine().split("\\s+");

            for (int col = 0; col < size; col++) {
                neighborhood [row][col] = input[col];

                if (neighborhood [row][col].equals("S")){
                    currentRow = row;
                    currentCol = col;
                }
                if(neighborhood [row][col].equals("V")){
                    niceKids++;
                }


            }

        }

        String command = scanner.nextLine();

        int givenGifts = 0;

        boolean isTrue = false;

        while (!command.equals("Christmas morning")){

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

            if (currentRow < 0 || currentCol < 0 || currentRow >= size  || currentCol >= size){

                break;
            }

            if(neighborhood [currentRow][currentCol].equals("X") || neighborhood [currentRow][currentCol].equals("-")){
                neighborhood [oldRows][oldCols] = "-";
                neighborhood [currentRow][currentCol] = "S";
            }else if(neighborhood [currentRow][currentCol].equals("V")){
                presentsCount--;
                givenGifts++;
                niceKids--;
                neighborhood [oldRows][oldCols] = "-";
                neighborhood [currentRow][currentCol] = "S";
            }else if (neighborhood [currentRow][currentCol].equals("C")){
                neighborhood [oldRows][oldCols] = "-";
                neighborhood [currentRow][currentCol] = "S";

                if (neighborhood [currentRow - 1][currentCol].equals("V") || neighborhood [currentRow - 1][currentCol].equals("X")){
                    neighborhood [currentRow - 1][currentCol] = "-";
                    presentsCount--;
                    givenGifts++;
                    if (neighborhood [currentRow - 1][currentCol].equals("V")){
                        niceKids--;
                    }

                }else if (neighborhood [currentRow + 1][currentCol].equals("V") || neighborhood [currentRow + 1][currentCol].equals("X")){
                    neighborhood [currentRow + 1][currentCol] = "-";
                    presentsCount--;
                    givenGifts++;
                    if (neighborhood [currentRow + 1][currentCol].equals("V")){
                        niceKids--;
                    }

                }else if (neighborhood [currentRow][currentCol - 1].equals("V") || neighborhood [currentRow][currentCol - 1].equals("X")){
                    neighborhood [currentRow][currentCol - 1] = "-";
                    presentsCount--;
                    givenGifts++;

                    if(neighborhood [currentRow][currentCol - 1].equals("V")){
                        niceKids--;
                    }

                }else if (neighborhood [currentRow][currentCol + 1].equals("V") || neighborhood [currentRow][currentCol + 1].equals("X")){
                    neighborhood [currentRow][currentCol + 1] = "-";
                    presentsCount--;
                    givenGifts++;
                    if (neighborhood [currentRow][currentCol + 1].equals("V")) {
                        niceKids--;
                    }
                }

                if (niceKids<=0 && presentsCount <=0){
                    isTrue = true;
                }

            }


            if (presentsCount > 0){
                command = scanner.nextLine();
            }else {
                if(!isTrue) {
                    System.out.println("Santa ran out of presents!");
                    break;
                }else {
                    break;
                }
            }

        }
        printMatrix(neighborhood);
        if (niceKids == 0){
            System.out.printf("Good job, Santa! %d happy nice kid/s.%n", givenGifts);
        }else if (niceKids > 0){
            System.out.printf("No presents for %d nice kid/s.%n", niceKids);
        }




    }
    private static void printMatrix(String[][] neighborhood) {

        for (int row = 0; row < neighborhood.length; row++) {
            for (int cow = 0; cow < neighborhood[row].length; cow++) {
                System.out.print(neighborhood[row][cow] + " ");

            }
            System.out.println();

        }
    }
}
