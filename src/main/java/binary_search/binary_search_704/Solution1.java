package binary_search.binary_search_704;

//https://www.youtube.com/watch?v=s4DPM8ct1pI
public class Solution1 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
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

    public static void main(String[] args) {

    }
}
