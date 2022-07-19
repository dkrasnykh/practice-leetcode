package array.sum3;

import java.util.*;

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

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;

        Set<List<Integer>> set = new HashSet<>();
        int zero = 0;
        while (i < nums.length) {
            if (nums[i] > 0) break;
            if (nums[i] == 0) {
                zero++;
            }
            int j = nums.length - 1;
            while (j >= 0) {
                if (nums[j] <= 0) break;
                int target = -(nums[i] + nums[j]);
                int k = binarySearch(nums, target, i + 1, j - 1);
                if (k != -1) {
                    List<Integer> temp = Arrays.asList(nums[i], target, nums[j]);
                    set.add(temp);
                }
                j--;
            }
            i++;
        }
        if (zero >= 3) set.add(Arrays.asList(0, 0, 0));
        result.addAll(set);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        //int[] nums = new int[]{1,2,-2,-1};
        //int[] nums = new int[]{0, 0, 0};
        Solution solution = new Solution();
        List<List<Integer>> result = solution.threeSum(nums);
        for (List<Integer> res : result) {
            System.out.println(res);
        }
    }
}
