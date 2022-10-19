package MatrixMethods;

public class IsInBounds_IsOutOfBounds {

    public static boolean isInBounds (int row, int col, int[][] matrix){
        return row >=0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    public static boolean isOutOfBounds (int row, int col, int[][] matrix){

        return !isInBounds(row, col, matrix);
    }
}
