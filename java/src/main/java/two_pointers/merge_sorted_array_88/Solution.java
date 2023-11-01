package two_pointers.merge_sorted_array_88;

import java.util.Arrays;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = Arrays.copyOf(nums1, m);
        int i = 0, j = 0;
        for (int k = 0; k < m + n; ++k) {
            if (j == n || i < m && nums[i] < nums2[j]) {
                nums1[k] = nums[i];
                i += 1;
            } else {
                nums1[k] = nums2[j];
                j += 1;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        s.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
