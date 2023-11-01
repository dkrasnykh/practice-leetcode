package arrays_hashing.find_pivot_index_724;

public class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 1; i <= n; ++i) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < n; ++i) {
            if (prefix[i] == prefix[n] - prefix[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(s.pivotIndex(new int[]{1, 1, 2, 2, -6}));
    }
}
