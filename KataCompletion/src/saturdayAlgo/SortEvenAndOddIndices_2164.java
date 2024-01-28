package saturdayAlgo;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SortEvenAndOddIndices_2164 {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4};
        System.out.println(Arrays.toString(sortEvenOdd(input)));

        int[] input2 = {5, 39, 33, 5, 12, 27, 20, 45, 14, 25, 32, 33, 30, 30, 9, 14, 44, 15, 21};
        System.out.println(Arrays.toString(sortEvenOdd(input2)));

        int[] input3 = {5, 39, 33, 5, 12, 27, 20, 45, 14, 25, 32, 33, 30, 30, 9, 14, 44, 15, 21};
        System.out.println(Arrays.toString(sortEvenOddLC2(input3)));
    }


    // my solution - 11 ms
    public static int[] sortEvenOdd(int[] nums) {

        int evensLength = nums.length % 2 == 0 ? nums.length / 2 : (nums.length / 2) + 1;
        int[] evens = new int[evensLength];
        int[] odds = new int[nums.length / 2];
        int subIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evens[subIndex] = nums[i];
            } else {
                odds[subIndex] = nums[i];
                subIndex++;
            }
        }
        Arrays.sort(evens); // zoradi array ascending order

//        ak chces descending order, tak mas niekolko moznosti:
        // 1. moznost: stream
        int[] sortedArrayOdds = IntStream.of(odds)
                .boxed()
                .sorted((a, b) -> Integer.compare(b, a))
                .mapToInt(Integer::intValue)
                .toArray();

        // 2. moznost: for loop
//        for (int i = 0; i < odds.length / 2; i++) {
//            int temp = odds[i];
//            odds[i] = odds[odds.length - 1 - i];
//            odds[odds.length - 1 - i] = temp;
//        }

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = evens[index];
            } else {
                nums[i] = sortedArrayOdds[index];
                index++;
            }
        }
        return nums;
    }

    // leet code solution - 2 ms
    public static int[] sortEvenOddLC2(int[] nums) {
        int n = nums.length;
        int[] even = new int[(n + 1) / 2];
        int[] odd = new int[n / 2];
        int iE = 0;
        int iO = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                even[iE++] = nums[i];
            } else {
                odd[iO++] = nums[i];
            }
        }
        Arrays.sort(even);
        Arrays.sort(odd);
        iE = 0;
        iO = n / 2 - 1;

        // this solution doesnt sort the odd array in descending order, but rather goes from the end when putting into final array
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = even[iE++];
            } else {
                nums[i] = odd[iO--];
            }
        }
        return nums;
    }

}
