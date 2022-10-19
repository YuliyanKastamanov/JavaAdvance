package Exam;

import java.util.Scanner;

public class P02_PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = 8;

        String[][] chessBoard = new String[size][size];



        int whitePawnRow = 0;
        int whitePawnCol = 0;
        int blackPawnRow = 0;
        int blackPawnCol = 0;

        for (int row = 0; row < size; row++) {
            String[] input = scanner.nextLine().split("");

            for (int col = 0; col < size; col++) {
                chessBoard[row][col] = input[col];

                if (chessBoard[row][col].equals("w")) {
                    whitePawnRow = row;
                    whitePawnCol = col;
                }

                if (chessBoard[row][col].equals("b")){
                    blackPawnRow = row;
                    blackPawnCol = col;
                }
            }

        }

        while (true){

            int oldWhiteRows = whitePawnRow;
            int oldWhiteCols = whitePawnCol;
            int oldBlackRows = blackPawnRow;
            int oldBlackCols = blackPawnCol;

            whitePawnRow--;
            blackPawnRow++;


            if (isInMatrix(whitePawnRow , whitePawnCol -1 ) && chessBoard[whitePawnRow][whitePawnCol - 1].equals("b")){

                String whitePawnPos = getPositionOfPawn(whitePawnRow, whitePawnCol - 1);
                System.out.printf("Game over! White capture on %s.", whitePawnPos);
                break;

            }else if(isInMatrix(whitePawnRow, whitePawnCol + 1) && chessBoard[whitePawnRow][whitePawnCol + 1].equals("b")){

                String whitePawnPos = getPositionOfPawn(whitePawnRow, whitePawnCol + 1);
                System.out.printf("Game over! White capture on %s.", whitePawnPos);
                break;

            }else {
                chessBoard[oldWhiteRows][oldWhiteCols] = "-";
                chessBoard[whitePawnRow][whitePawnCol] = "w";
                if (whitePawnRow == 0){
                    String whitePawnPos = getPositionOfPawn(whitePawnRow, whitePawnCol);
                    System.out.printf("Game over! White pawn is promoted to a queen at %s.", whitePawnPos);
                    break;
                }
            }

            if (isInMatrix(blackPawnRow, blackPawnCol - 1 ) && chessBoard[blackPawnRow][blackPawnCol - 1].equals("w")){

                String blackPawnPos = getPositionOfPawn(blackPawnRow, blackPawnCol - 1);
                System.out.printf("Game over! Black capture on %s.", blackPawnPos);
                break;

            }else if(isInMatrix(blackPawnRow, blackPawnCol + 1) && chessBoard[blackPawnRow][blackPawnCol + 1].equals("w")){

                String blackPawnPos = getPositionOfPawn(blackPawnRow, blackPawnCol + 1);
                System.out.printf("Game over! Black capture on %s.", blackPawnPos);
                break;

            }else {
                chessBoard[oldBlackRows][oldBlackCols] = "-";
                chessBoard[blackPawnRow][blackPawnCol] = "b";
                if (blackPawnRow == 7){
                    String blackPawnPos = getPositionOfPawn(blackPawnRow, blackPawnCol);
                    System.out.printf("Game over! Black pawn is promoted to a queen at %s.", blackPawnPos);
                    break;
                }
            }



        }





    }

    private static String getPositionOfPawn(int currentPawnRow, int currentPawnCol) {

        StringBuilder stringBuilder =  new StringBuilder();
        for (int col = 8; col >=0 ; col--) {

            if (currentPawnCol == col){
                stringBuilder.append((char)(col + 97));
            }

        }

        int count = 8;

        for (int row = 0; row < 8; row++) {

            if(currentPawnRow == row){
                stringBuilder.append(count);
            }
            count--;
        }

        return  stringBuilder.toString();
    }

    private static boolean isInMatrix(int rows, int cols) {

        if (rows >= 0 && rows <= 7 && cols >= 0 && cols <= 7){
            return true;
        }
        return false;

    }
}
