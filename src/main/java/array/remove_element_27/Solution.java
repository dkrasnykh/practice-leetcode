package array.remove_element_27;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            if (nums[r] == val) {
                --r;
            } else if (nums[l] == val) {
                nums[l] = nums[r];
                nums[r] = val;
                ++l;
                --r;
            } else {
                ++l;
            }
        }
        return r + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeElement(new int[]{1}, 1));
    }
}
