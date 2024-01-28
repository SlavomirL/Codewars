package algos;

public class PascalsTriangle {

    /*
    * Write a function that, given a depth n, returns n top rows of Pascal's Triangle flattened into a one-dimensional list/array.
    * */

    public static long[] generate(int n) {
        int digit = 0;
        for (int i = 0; i <= n; i++) {
            digit += i;
        }
        long[] result = new long[digit];
        int index = 0;

        for (int line = 1; line <= n; line++) {
            long currentValue = 1L;
            for (int i = 1; i <= line; i++) {
                result[index++] = currentValue;
                currentValue = currentValue * (line - i) / i;
            }
        }
        return result;
    }

}