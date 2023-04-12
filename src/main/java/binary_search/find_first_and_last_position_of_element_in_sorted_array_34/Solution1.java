package binary_search.find_first_and_last_position_of_element_in_sorted_array_34;

//https://www.youtube.com/watch?v=4sQL7R5ySUU
public class Solution1 {
    private int binsearch(int[] nums, int target, boolean leftBias){
        int l = 0, r = nums.length - 1;
        int i = -1;
        while(l <= r){
            int m = l + (r - l)/2;
            if(target > nums[m]){
                l = m + 1;
            } else if (target < nums[m]){
                r = m - 1;
            } else {
                i = m;
                if (leftBias)
                    r = m - 1;
                else
                    l = m + 1;
            }
        }
        return i;
    }
    public int[] searchRange(int[] nums, int target) {
        int left = binsearch(nums, target, true);
        int right = binsearch(nums, target, false);
        return new int[]{left, right};
    }

    public static void main(String[] args) {

    }
}
