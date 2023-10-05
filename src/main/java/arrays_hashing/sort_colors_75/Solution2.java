package arrays_hashing.sort_colors_75;

//https://www.youtube.com/watch?v=4xbWSRZHqac
public class Solution2 {
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int i = 0;
        while (i <= r) {
            if (nums[i] == 0) {
                swap(nums, i, l);
                l += 1;
            } else if (nums[i] == 2) {
                swap(nums, i, r);
                r -= 1;
                i -= 1;
            }
            i += 1;
        }
    }

    public static void main(String[] args) {

    }
}
