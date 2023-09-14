package sliding_window.max_consecutive_ones_II_487;

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currWindow = 0, maxWindow = 0;
        int l = 0;
        boolean flipped = false;
        for (int r = 0; r < nums.length; ++r) {
            if (nums[r] == 0 && flipped) {
                maxWindow = Math.max(currWindow, maxWindow);
                while (nums[l] != 0) {
                    currWindow -= 1;
                    l += 1;
                }
                currWindow -= 1;
                l += 1;
                flipped = false;
            } else if (nums[r] == 0) {
                flipped = true;
                currWindow += 1;
            } else {
                currWindow += 1;
            }
        }
        maxWindow = Math.max(currWindow, maxWindow);
        return maxWindow;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMaxConsecutiveOnes(new int[]{1,0,1,1,0}));
        System.out.println(s.findMaxConsecutiveOnes(new int[]{1,1,1,1,0}));
        System.out.println(s.findMaxConsecutiveOnes(new int[]{1,0,0,0,1,0,0}));
    }
}
