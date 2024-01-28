package leetcode150;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray_26 {

    public static void main(String[] args) {
        int[] input1 = {1, 1, 2};
        int[] input2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        removeDuplicates(input1);
        System.out.println("///");
        removeDuplicates(input2);

        System.out.println("LEET CODE below");
        input2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        removeDuplicatesLT0(input2);
        input2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        removeDuplicatesLT1(input2);

    }
    // my solution - 6 ms
    public static int removeDuplicates(int[] nums) {
        int l = nums.length;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = 999;
                l--;
            }
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        System.out.println();
        System.out.println(l);

        return l;
    }
    // leetcode solution - 0 ms
    public static int removeDuplicatesLT0(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 1 || n > nums[i - 1]) {
                nums[i++] = n;
            }
        }
        return i;
    }
    // leetcode solution - 1 ms
    public static int removeDuplicatesLT1(int[] nums) {
        int nextValue = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[nextValue]!= nums[i]){
                nums[nextValue+1] = nums[i];
                nextValue++;
            }
        }
        return nextValue+1;
    }
}
