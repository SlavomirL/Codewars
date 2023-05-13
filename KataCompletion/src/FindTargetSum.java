import java.util.Arrays;

public class FindTargetSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1,2,3,4,5,6,7,8,9}, 9)));
    }

    /* Write a function that takes an array of numbers and a target number. It should find
    two different items in the array that, when added together, give the target value. The indices of these items
    should then be returned in an array */
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                if(numbers[i] + numbers[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }
}