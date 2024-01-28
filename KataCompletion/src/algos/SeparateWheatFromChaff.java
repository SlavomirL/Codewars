package algos;

import java.util.Arrays;

public class SeparateWheatFromChaff {

    // my initial approach
    public static long[] wheatFromChaff(long[] values) {
        long[] result = Arrays.copyOf(values, values.length);
        for (int i = 0; i < result.length; i++) {
            if (result[i] > 0) {
                for (int j = result.length - 1; j > i; j--) {
                    if (result[j] < 0) {
                        long temp = result[i];
                        result[i] = result[j];
                        result[j] = temp;
                        break;
                    }
                }
            }
        }
        return result;
    }

    // improved version
    public static long[] wheatFromChaffImproved(long[] values) {
        int left = 0;
        int right = values.length - 1;
        long[] result = Arrays.copyOf(values, values.length);

        while (left < right) {
            while (result[left] < 0 && left < right) {
                left++;
            }
            while (result[right] >= 0 && left < right) {
                right--;
            }
            if (left < right) {
                long temp = result[left];
                result[left] = result[right];
                result[right] = temp;
                left++;
                right--;
            }
        }
        return result;
    }

    // CodeWars solution:
    static long[] wheatFromChaffCW(long[] values) {
        values = Arrays.copyOf(values, values.length);
        for (int l = 0, r = values.length - 1; l < r; l++) {
            while (values[l] > 0 && l < r) {
                if (values[r--] < 0) {
                    values[l] += values[r + 1] - (values[r + 1] = values[l]);
                }
            }
        }
        return values;
    }

}