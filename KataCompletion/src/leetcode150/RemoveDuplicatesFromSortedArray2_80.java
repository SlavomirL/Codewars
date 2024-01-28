package leetcode150;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray2_80 {

    public static void main(String[] args) {
        int[] input = {0, 0, 1, 1, 1, 1, 2, 3, 3};
//        removeDuplicates(input);
        removeDuplicatesLC(input);
    }

    // my solution - 2 ms
    public static int removeDuplicates(int[] nums) {
        int k = nums.length;

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2]) {
                nums[i] = 999;
                k--;
            }
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        System.out.println(k);

        return k;
    }

    // leetcode solution - 0 ms
    public static int removeDuplicatesLC(int[] nums) {
        if(nums.length<3) {
            return nums.length;
        }
        int k=2;
        int c=1;
        int pos=1;
        for(int i=1;i<nums.length;i++) {
            if(nums[i]==nums[i-1]) {
                if(c<k){
                    nums[pos]=nums[i];
                    pos++;
                }
                c++;
            } else {
                nums[pos]=nums[i];
                c=1;
                pos++;
            }

        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

        return pos;
    }
}