package leetcode150;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement_169 {

    public static void main(String[] args) {
        int[] input = {2, 2, 1, 1, 1, 2, 2};

        System.out.println(majorityElementLC8(input));
    }

    // my solution - 220 ms
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> numCounts = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
            numCounts.put(nums[i], numCounts.getOrDefault(nums[i], 0) + 1);
        }

//        for (Map.Entry<Integer, Integer> entry : numCounts.entrySet()) {
//            int key = entry.getKey();
//            int value = entry.getValue();
//
//            System.out.println("Key: " + key + ", Value: " + value);
//        }


        int result = -1;
        int currentHighest = 0;
        for (Map.Entry<Integer, Integer> entry : numCounts.entrySet()) {
            if (entry.getValue() > currentHighest) {
                currentHighest = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }

    // leet code solution - 8ms
    public static int majorityElementLC8(int[] nums) {
        return helper(nums, 0, nums[0]);
    }

    public static int helper(int[] nums, int start, int majority) {
        int count = 0;
        for (int i = start; i < nums.length; i++) {
            if (nums[i] == majority)
                count++;
            else
                count--;
            if (count == -1) {
                return helper(nums, i, nums[i]);
            }
        }
        return majority;
    }
}
