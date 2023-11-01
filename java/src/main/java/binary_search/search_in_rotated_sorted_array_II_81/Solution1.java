package binary_search.search_in_rotated_sorted_array_II_81;

public class Solution1 {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l < r && nums[l] == nums[l + 1]){
            l += 1;
        }
        while(l < r && nums[r] == nums[r - 1]){
            r -= 1;
        }
        while (l<=r) {
            int m = (l+r)/2;
            if(nums[m] == target){
                return true;
            }

            while (nums[l] == nums[m] && l != m){
                l += 1;
            }

            //left sorted
            if (nums[l] <= nums[m]) {
                if(target > nums[m] || target < nums[l]){
                    l = m + 1;
                }else{
                    r = m - 1;
                }
            } else {
                //right sorted
                if(target < nums[m] || target > nums [r]){
                    r = m - 1;
                }else{
                    l = m + 1;
                }
            }
        }
        return false;
    }
}
