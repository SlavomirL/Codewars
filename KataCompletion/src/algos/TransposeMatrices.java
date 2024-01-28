package algos;

public class TransposeMatrices {

    public static void main(String args[]) {
        int[][] input = {{1, 2, 3}, {4, 5, 6}};
        int[][] transposed = transpose(input);

        System.out.println("ORIGINAL");
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                System.out.print(input[i][j]);
            }
            System.out.println();
        }

        System.out.println("TRANSPOSED");
        for (int i = 0; i < transposed.length; i++) {
            for (int j = 0; j < transposed[i].length; j++) {
                System.out.print(transposed[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] transpose(int[][] matrix) {

        int[][] result = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

}