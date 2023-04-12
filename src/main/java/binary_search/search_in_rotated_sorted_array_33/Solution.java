package binary_search.search_in_rotated_sorted_array_33;

public class Solution {
    private int findMin(int[] nums) {
        int l = 1, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] < nums[m - 1]) {
                return m;
            } else if (nums[m] < nums[0]) {
                r = m - 1;
            } else if (nums[m] > nums[0]) {
                l = m + 1;
            }
        }
        return 0;
    }
    private int searchInSub(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int m = l + ((r - l) / 2);
            if (nums[m] > target) {
                r = m - 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int ind = findMin(nums);
        int i = searchInSub(nums, 0, ind - 1, target);
        int j = searchInSub(nums, ind, nums.length - 1, target);
        return i != -1 ? i : j;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(s.search(new int[]{1}, 0));
    }
}
