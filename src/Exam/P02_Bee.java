package Exam;

import java.util.Scanner;

public class P02_Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int size = Integer.parseInt(scanner.nextLine());

        String[][] beeField = new String[size][size];

        int currentRow = 0;
        int currentCol = 0;

        for (int row = 0; row < size; row++) {
            String[] input = scanner.nextLine().split("");

            for (int col = 0; col < size; col++) {
                beeField[row][col] = input[col];

                if (beeField[row][col].equals("B")) {
                    currentRow = row;
                    currentCol = col;
                }


            }

        }
        int countFlowers = 0;
        boolean isTrue = false;

        while (true) {
            String command = scanner.nextLine();
            if(command.equals("End")){
                break;
            }

            int oldRows = currentRow;
            int oldCols = currentCol;

            if (command.equals("up")) {
                currentRow--;

            } else if (command.equals("down")) {
                currentRow++;

            } else if (command.equals("left")) {
                currentCol--;

            } else if (command.equals("right")) {

                currentCol++;
            }

            if (currentRow < 0 || currentCol < 0 || currentRow >= size || currentCol >= size) {
                beeField[oldRows][oldCols] = ".";
                isTrue = true;
                break;
            }

            if (beeField[currentRow][currentCol].equals("f")) {
                beeField[oldRows][oldCols] = ".";
                beeField[currentRow][currentCol] = "B";
                countFlowers++;
            } else if (beeField[currentRow][currentCol].equals("O")) {
                beeField[oldRows][oldCols] = ".";
                beeField[currentRow][currentCol] = "B";
                oldRows = currentRow;
                oldCols = currentCol;

                if (command.equals("up")) {
                    currentRow--;

                } else if (command.equals("down")) {
                    currentRow++;

                } else if (command.equals("left")) {
                    currentCol--;

                } else if (command.equals("right")) {

                    currentCol++;
                }
                if (currentRow < 0 || currentCol < 0 || currentRow >= size || currentCol >= size) {
                    beeField[oldRows][oldCols] = ".";

                    isTrue = true;
                    break;
                }
                beeField[oldRows][oldCols] = ".";

                if (beeField[currentRow][currentCol].equals("f")){
                    countFlowers++;
                }
                beeField[currentRow][currentCol] = "B";
            }else {
                beeField[oldRows][oldCols] = ".";
                beeField[currentRow][currentCol] = "B";

            }




        }

        if (isTrue) {
            System.out.println("The bee got lost!");
        }

        if (countFlowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", countFlowers);
        }else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - countFlowers);
        }


            for (int row = 0; row < beeField.length; row++) {
                for (int cow = 0; cow < beeField[row].length; cow++) {
                    System.out.print(beeField[row][cow]);

                }
                System.out.println();

            }
        }
    }

