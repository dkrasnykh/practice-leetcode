package binary_search.median_of_two_sorted_arrays_4;

public class Solution {
    private static int INF = 1000100;
    private int search(int[] nums, int e) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l + 1) / 2;
            if (nums[m] <= e) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r;
    }

    private boolean checkLessOrEqualK(int[] nums1, int[] nums2, int e, int len) {
        int k = search(nums1, e) + 1;
        k += (search(nums2, e) + 1);
        return k >= len;
    }

    private int medianSearch(int[] nums1, int[] nums2, int lenght) {
        int l = Math.min((nums1.length == 0) ? INF : nums1[0], (nums2.length == 0) ? INF : nums2[0]);
        int r = Math.max((nums1.length == 0) ? -INF : nums1[nums1.length - 1], (nums2.length == 0) ? -INF : nums2[nums2.length - 1]);
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (checkLessOrEqualK(nums1, nums2, m, lenght)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int l = medianSearch(nums1, nums2, (m + n) / 2);
        int r = medianSearch(nums1, nums2, (m + n) / 2 + 1);
        return ((m + n) % 2 == 0) ? (l + r) / 2.0 : r;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMedianSortedArrays(new int[]{1, 4, 6}, new int[]{2, 5, 8}));
        System.out.println(s.findMedianSortedArrays(new int[]{1}, new int[]{}));
        System.out.println(s.findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(s.findMedianSortedArrays(new int[]{}, new int[]{1, 2}));
    }
}
