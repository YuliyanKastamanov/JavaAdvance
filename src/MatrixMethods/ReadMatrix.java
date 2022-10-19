package MatrixMethods;

import java.util.Arrays;
import java.util.Scanner;

public class ReadMatrix {




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
