package leetcode150;

public class RemoveElement_27 {

    public static void main(String[] args) {
        int[] input = {3, 2, 2, 3};
        int val = 3;

        int[] input2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        // 0 1 3 0 4

//        removeElement(input, val);
        removeElement(input2, val2);

        int[] input3 = {0, 1, 2, 2, 3, 0, 4, 2};
        removeElementLT0(input3, val2);
    }

    // my solution - 0 ms
    public static int removeElement(int[] nums, int val) {
        int k = nums.length;
        int endIndex = nums.length - 1;

        for (int i = 0; i <= endIndex; i++) {
            if (nums[i] == val) {
                k--;
                if (i < endIndex) {
                    for (int j = endIndex; j > i; j--) {
                        endIndex--;
                        if (nums[j] != val) {
                            nums[i] = nums[j];
                            nums[j] = val;
                            break;
                        } else {
                            k--;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        System.out.println();
        System.out.println(k);

        return k;
    }

    // leetcode solution - 0 ms
    public static int removeElementLT0(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
