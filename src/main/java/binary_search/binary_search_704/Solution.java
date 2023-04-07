package binary_search.binary_search_704;

public class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return (nums[l] == target) ? l : -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.search(new int[]{-1,0,3,5,9,12}, 9));
        System.out.println(s.search(new int[]{-1,0,3,5,9,12}, 2));
    }
}
