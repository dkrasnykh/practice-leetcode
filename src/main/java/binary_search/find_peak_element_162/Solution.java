package binary_search.find_peak_element_162;

public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (m == 0 && nums[m] > nums[m + 1]
                    || m == nums.length - 1 && nums[m] > nums[m - 1]
                    || nums[m] > nums[m + 1] && nums[m] > nums[m - 1]) {
                return m;
            } else if (m + 1 < nums.length && nums[m] < nums[m + 1]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findPeakElement(new int[]{1, 2, 3, 1}));
    }
}
