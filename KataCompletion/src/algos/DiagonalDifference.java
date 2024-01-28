package algos;

import java.util.List;

class DiagonalDifference {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        int sum = 0;
        int result = 0;
        for(int i = 0; i < arr.size(); i++) {
            sum = arr.get(i).get(i) - arr.get(i).get(arr.size() -1 - i);
            result += sum;
        }
        return result < 0 ? result * -1 : result;
    }
}