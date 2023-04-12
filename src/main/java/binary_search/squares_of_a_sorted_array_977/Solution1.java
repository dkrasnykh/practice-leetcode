package binary_search.squares_of_a_sorted_array_977;

//https://www.youtube.com/watch?v=FPCZsG_AkUg
public class Solution1 {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int l = 0, r = nums.length - 1, j = nums.length - 1;
        while (l <= r) {
            if (nums[l] * nums[l] > nums[r] * nums[r]) {
                res[j] = nums[l] * nums[l];
                l += 1;
                j -= 1;
            } else {
                res[j] = nums[r] * nums[r];
                r -= 1;
                j -= 1;
            }
        }
        return res;
    }
}
