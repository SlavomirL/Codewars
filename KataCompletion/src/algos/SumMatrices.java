package algos;

public class SumMatrices {

    public static int[][] matrixAddition(int[][] a, int[][] b) {
        int matLen = a.length;
        int[][] resultMatrix = new int[matLen][matLen];
        for (int i = 0; i < matLen; i++) {
            for (int j = 0; j < matLen; j++) {
                resultMatrix[i][j] = a[i][j] + b[i][j];
            }
        }
        return resultMatrix;
    }

}