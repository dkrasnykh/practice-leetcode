package binary_search.single_element_in_a_sorted_array_540;

public class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (m == 0 && nums[m] != nums[m + 1] || m == nums.length - 1 && nums[m] != nums[m - 1] || nums[m] != nums[m - 1] && nums[m] != nums[m + 1]) {
                return nums[m];
            } else if (m % 2 == 0 && m < nums.length - 1 && nums[m] == nums[m + 1] || m % 2 == 1 && nums[m] == nums[m - 1]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
    }
}
