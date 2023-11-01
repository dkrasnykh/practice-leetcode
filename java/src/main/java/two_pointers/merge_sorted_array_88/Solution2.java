package two_pointers.merge_sorted_array_88;

import java.util.Arrays;

public class Solution2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < n + m; ++i) {
            nums1[i] = Integer.MAX_VALUE;
        }
        int i = 0, j = 0;
        while (i < m + n) {
            if (j == n || nums1[i] < nums2[j]) {
                i += 1;
            } else {
                for (int k = m + n - 1; k > i; --k) {
                    nums1[k] = nums1[k - 1];
                }
                nums1[i] = nums2[j];
                i += 1;
                j += 1;
            }
        }
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        s.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

    }
}
