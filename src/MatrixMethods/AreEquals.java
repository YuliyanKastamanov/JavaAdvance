package MatrixMethods;

public class AreEquals {

    private static boolean areEqual(int[][] firstMatrix, int[][] secondMatrix) {

        if(firstMatrix.length != secondMatrix.length){
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {

            int[] firstArr = firstMatrix[row];
            int[] secondArr = secondMatrix[row];

            if(firstArr.length != secondArr.length){
                return false;
            }

            for (int index = 0; index < firstArr.length; index++) {

                if (firstArr[index] != secondArr[index]){
                    return false;
                }

            }

        }
        return true;
    }
}
