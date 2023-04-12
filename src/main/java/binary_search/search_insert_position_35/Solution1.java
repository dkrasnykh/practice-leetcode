package binary_search.search_insert_position_35;

public class Solution1 {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] > target) {
                r = m - 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, -1));
    }
}
