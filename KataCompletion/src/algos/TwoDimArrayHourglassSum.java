package algos;

import java.util.List;

class TwoDimArrayHourglassSum {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {

        int maxSum = Integer.MIN_VALUE;

        for(int i = 1; i < arr.size()-1; i++) {
            int interSum = 0;
            for(int j = 1; j < arr.get(i).size()-1; j++) {
                int topLeft = arr.get(i-1).get(j-1);
                int topMid = arr.get(i-1).get(j);
                int topRight = arr.get(i-1).get(j+1);
                int center = arr.get(i).get(j);
                int botLeft = arr.get(i+1).get(j-1);
                int botMid = arr.get(i+1).get(j);
                int botRight = arr.get(i+1).get(j+1);
                interSum = center + topLeft + topMid + topRight + botLeft + botMid + botRight;
                if(interSum > maxSum) {
                    maxSum = interSum;
                }
            }
        }
        return maxSum;
    }
}