package leetcode150;

import java.util.Arrays;

public class MergeSortedArrays_88 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);

        nums1 = new int[]{1, 2, 3, 0, 0, 0};
        nums2 = new int[] {2, 5, 6};
        mergeLT1(nums1, m, nums2, n);

    }
    // my solution - 1 ms
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int mn = m+n;
        int nStart = 0;
        for (int i = mn - 1; i >= mn - n; i--) {
            nums1[i] = nums2[nStart];
            nStart++;
        }
        Arrays.sort(nums1);
    }

    // leetcode solution - 1 ms
    public static void mergeLT1(int[] nums1, int m, int[] nums2, int n) {
        int j=0;
        for(int i=m;i<nums2.length+m;i++){
            nums1[i]=nums2[j++];
        }
        Arrays.sort(nums1);
    }
}

