package arrays_hashing.sum3Closest;

//#16. 3Sum Closest
//https://leetcode.com/problemset/all/?topicSlugs=array
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        /*
        int i = 0, j = 0, k = 0;
        Arrays.sort(nums);
        //продолжать пока dev убывает
        int dev =Math.abs(nums[0] + nums[1] + nums[2] - target);
        for(i = 0; i < nums.length - 2; i ++) {
            for (j = i + 1; j < nums.length - 1; j++) {
                for (k = j + 1; k < nums.length; k++) {
                    if(Math.abs(nums[i] + nums[j] + nums[k] - target) > dev){
                        break;
                    } else
                        dev = Math.abs(nums[i] + nums[j] + nums[k] - target);
                }
            }
        }
        */

        int result = 0;
        int dev = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 2; i ++){
            for(int j = i + 1; j < nums.length - 1; j++){
                for(int k = j + 1; k < nums.length; k++){
                    int number = nums[i] + nums[j] + nums[k];
                    if (Math.abs(number - target) < dev){
                        dev = Math.abs(number - target);
                        result = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(nums, 1));

    }
}
