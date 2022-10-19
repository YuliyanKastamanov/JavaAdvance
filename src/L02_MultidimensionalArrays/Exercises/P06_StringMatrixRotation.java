package L02_MultidimensionalArrays.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P06_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        String regex = "Rotate\\((?<degrees>[0-9]+)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(command);

        int degrees = 0;

        while (matcher.find()){
            degrees = Integer.parseInt(matcher.group("degrees"));
        }



        String matrixLine = scanner.nextLine();
        List<String> lines = new ArrayList<>();
        int countCommands = 0;
        int maxLength = 0;

        while (!matrixLine.equals("END")){

            lines.add(matrixLine);
            countCommands++;
            if(matrixLine.length() > maxLength){
                maxLength = matrixLine.length();
            }
            matrixLine = scanner.nextLine();

        }
        int rows = 0;
        int cols = 0;

        while (degrees >= 360){
            degrees = degrees % 360;
        }

        if(degrees == 0 || degrees / 90 == 2 || degrees / 90 == 4){
            rows = countCommands;
            cols = maxLength;
        }else if(degrees / 90 == 1 || degrees / 90 == 3){
            rows = maxLength;
            cols = countCommands;
        }
        char[][] matrix = new char[rows][cols];
        if (degrees == 0){
             matrix = fillMatrix0(degrees, rows, cols, lines);
        }else if (degrees / 90 == 1){
            matrix = fillMatrix1(degrees, rows, cols, lines);

        }else if(degrees / 90 == 2){
            matrix = fillMatrix2(degrees, rows, cols, lines);

        }else if (degrees / 90 == 3){
            matrix = fillMatrix3(degrees, rows, cols, lines);

        }else if(degrees / 90 == 4){
            matrix = fillMatrix0(degrees, rows, cols, lines);

        }



        printMatrix(matrix);


    }

    private static char[][] fillMatrix3(int degrees, int rows, int cols, List<String> lines) {

        char[][] matrix = new char[rows][cols];

        int count = 0;
        for (int col = 0; col < cols; col++) {
            String currentLine = lines.get(count);
            int rotation = 0;
            for (int row = rows - 1; row >= 0; row--) {

                char currentChar = ' ';
                if(rotation <currentLine.length()){
                    currentChar = currentLine.charAt(rotation);
                    rotation++;
                }
                matrix[row][col] = currentChar;
            }
            count++;
        }

        return matrix ;


    }

    private static char[][] fillMatrix2(int degrees, int rows, int cols, List<String> lines) {
        char[][] matrix = new char[rows][cols];

        int count = 0;


        for (int row = rows - 1; row >= 0; row--) {
            String currentLine = lines.get(count);
            count++;
            int rotation = 0;
            for (int col = cols - 1; col >= 0; col--) {

                char currentChar = ' ';
                if(rotation < currentLine.length()){
                    currentChar = currentLine.charAt(rotation);
                    rotation++;
                }
                matrix[row][col] = currentChar;
            }

        }



        return matrix ;

    }

    private static char[][] fillMatrix1(int degrees, int rows, int cols, List<String> lines) {
        char[][] matrix = new char[rows][cols];

        int count = 0;
        for (int col = cols - 1; col >= 0; col--) {
            String currentLine = lines.get(count);

            for (int row = 0; row < rows; row++) {

                char currentChar = ' ';
                if(row <currentLine.length()){
                    currentChar = currentLine.charAt(row);
                }
                matrix[row][col] = currentChar;
            }
            count++;
        }

        return matrix ;

    }

    private static char [][] fillMatrix0(int degrees, int rows, int cols, List<String> lines ) {

        char[][] matrix = new char[rows][cols];


        for (int row = 0; row < rows; row++) {
            String currentLine = lines.get(row);
            for (int col = 0; col < cols; col++) {
                char currentChar = ' ';
                if(col <currentLine.length()){
                    currentChar = currentLine.charAt(col);
                }
                matrix[row][col] = currentChar;
            }

        }
        return matrix ;
    }

    public static void printMatrix (char[][] matrix ){

        for (int row = 0; row < matrix.length; row++) {
            for (int cow = 0; cow < matrix[row].length; cow++) {
                System.out.print(matrix[row][cow]);

            }
            System.out.println();

        }

    }

}
