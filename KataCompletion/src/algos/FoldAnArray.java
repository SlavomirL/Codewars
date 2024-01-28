package algos;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FoldAnArray {

    public static void main(String[] args) {
        int[] input1 = {1, 2, 3, 4, 5};
        int runs1 = 3;

        int[] input2 = {9, 6};
        int runs2 = 3;

        int[] input3 = {-9, 9, -8, 8, 66, 23};
        int runs3 = 1;

        int[] result1 = foldArray(input1, runs1);
//        int[] result2 = foldArray(input2, runs2);
//        int[] result3 = foldArray(input3, runs3);

        for (int i = 0; i < result1.length; i++) {
            System.out.println(result1[i]);
        }
    }


    // my solution
    public static int[] foldArray(int[] array, int runs) {

        int[] beforeArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            beforeArray[i] = array[i];
        }

        boolean odd = false;
        int[] subArray;
        for (int i = 0; i < runs; i++) {
            odd = false;
            int length = beforeArray.length;

            if (length % 2 == 0) {
                subArray = new int[beforeArray.length / 2];
            } else {
                subArray = new int[beforeArray.length / 2 + 1];
                odd = true;
            }

            for (int j = 0; j < subArray.length; j++) {
                if (odd && j == subArray.length - 1) {
                    subArray[j] = beforeArray[j];
                } else {
                    subArray[j] = beforeArray[j] + beforeArray[beforeArray.length - j - 1];
                }
            }

            beforeArray = new int[subArray.length];
            for (int j = 0; j < subArray.length; j++) {
                beforeArray[j] = subArray[j];
            }

            if (i == runs - 1) {
                return subArray;
            }
        }
        return null;
    }

    // another solution from codewars
    public static int[] foldArrayCW1(int[] array, int runs) {
        int[] f = java.util.Arrays.copyOfRange(array, 0, (int) Math.ceil(array.length / 2.));
        for (int i = 0; i < array.length / 2; i++) {
            f[i] += array[array.length - 1 - i];
        }
        return f.length == 1 | runs == 1 ? f : foldArrayCW1(f, --runs);
    }

    // yet another solution from codewars
    public static int[] foldArrayCW2(int[] array, int runs) {
        final int[] result = Arrays.copyOfRange(array, 0, Math.round(array.length / 2.0f));

        IntStream.range(0, array.length / 2)
                .forEach(i -> result[i] = array[i] + array[array.length - 1 - i]);

        return runs > 1 ? foldArrayCW2(result, --runs) : result;
    }
}
