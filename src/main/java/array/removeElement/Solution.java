package array.removeElement;

import java.util.Arrays;

public class Solution {

    public int removeElement(int[] nums, int val) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length - 1;
        int startIndex = -1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] > val) {
                high = mid - 1;
            } else if (nums[mid] == val) {
                startIndex = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        int endIndex = -1;
        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] > val) {
                high = mid - 1;
            } else if (nums[mid] == val) {
                endIndex = mid;
                low = mid + 1;
            } else
                low = mid + 1;
        }
        endIndex++;
        if (startIndex != -1 && endIndex != -1){
            System.arraycopy(nums, endIndex, nums, startIndex, nums.length - endIndex);
            return nums.length - (endIndex - startIndex);
        }
        return nums.length;
    }
}
