package array.searchInRotatedSortedArray;

public class Solution {
    public int binarySearch(int[] sortedArray, int key, int low, int high) {
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] < key) {
                low = mid + 1;
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
            } else if (sortedArray[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }

    public int search(int[] nums, int target) {
        if (nums[0] < nums[nums.length - 1]) {
            return binarySearch(nums, target, 0, nums.length - 1);
        } else if (nums[0] > target){
            for(int i = nums.length - 1; i >= 0; i--){
                if (nums[i] == target) return i;
            }
        } else {
            for(int i = 0; i < nums.length; i++){
                if (nums[i] == target) return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2}, 6));
    }
}
