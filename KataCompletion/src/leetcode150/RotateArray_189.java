package leetcode150;

import java.util.Arrays;

public class RotateArray_189 {

    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,6,7};
        int rotation = 3;

        int[] input2 = {1,2,3,4,5,6};
        int rotation2 = 2;

        rotate1(input, rotation);
        rotate1(input2, rotation2);

        int[] input3 = {1, 2, 3, 4, 5, 6, 7};
        int rotation3 = 3;

        int[] input4 = {1, 2, 3};
        int rotation4 = 7;

        rotate2(input3, rotation3);
        rotate2(input4, rotation4);
    }


    // my first solution
    public static void rotate1(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j + 1 < nums.length) {
                    int temp = nums[0];
                    nums[0] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }


    // my second solution - optimized for 0 ms even for big input data
    public static void rotate2(int[] nums, int k) {
        int rotation = 0;
        if (k <= nums.length) {
            rotation = k;
        } else {
            rotation = k % nums.length;
        }

        int[] start = Arrays.copyOfRange(nums, nums.length - rotation, nums.length);
        int[] end = Arrays.copyOfRange(nums, 0, nums.length - rotation);

        System.arraycopy(start, 0, nums, 0, start.length);
        System.arraycopy(end, 0, nums, start.length, end.length);

        System.out.println(Arrays.toString(nums));

    }

}
