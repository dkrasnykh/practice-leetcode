package array.first_missing_positive_41;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length) {
                continue;
            }
            int tmp = nums[i];
            while (true) {
                int j = tmp - 1;
                if (j < 0) {
                    break;
                }
                tmp = nums[j];
                if (nums[j] == j + 1) {
                    break;
                }
                nums[j] = j + 1;
                if (tmp < 0 || tmp > nums.length || j + 1 == tmp) {
                    break;
                }
            }
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return (nums.length == nums[nums.length - 1]) ? nums.length + 1 : nums.length;
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        System.out.println(s.firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(s.firstMissingPositive(new int[]{3, 4, -1, 1}));

        System.out.println(s.firstMissingPositive(new int[]{-5, 0, 1, 10, 8, -4, 9, -8, 6, 2, -5, 3, 0, 4, 5}));

        System.out.println(s.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        System.out.println(s.firstMissingPositive(new int[]{2, 2, 2, 1, 1, 1, 1}));
        System.out.println(s.firstMissingPositive(new int[]{1, 1, 1, 1, 1, 1}));
        System.out.println(s.firstMissingPositive(new int[]{2, 2, 3}));

        System.out.println(s.firstMissingPositive(new int[]{2, 1}));

        //[43,20,39,-7,-8,-2,8,17,10,17,12,6,37,17,50,44,3,11,18,-4,44,37,28,50,15,50,19,0,45,5,37,35,35,21,39,35,27,-8,-1,47,19,22,1,1,47,-4,-7,-3,16,21,2,7,6]
        //output = 3, expected = 4
        //System.out.println(s.firstMissingPositive(new int[]{43,20,39,-7,-8,-2,8,17,10,17,12,6,37,17,50,44,3,11,18,-4,44,37,28,50,15,50,19,0,45,5,37,35,35,21,39,35,27,-8,-1,47,19,22,1,1,47,-4,-7,-3,16,21,2,7,6}));
        //System.out.println(s.firstMissingPositive(new int[]{43, 20, 39, -7, -8, -2,  3, 11, 18, -4, 44, 37, 28, 50, 15, 50, 19, 0, 45, 5, 37, 35, 35, 21, 39, 35, 27, -8, -1, 47, 19, 22, 1, 1, 47, -4, -7, -3, 16, 21, 2, 7, 6}));

        System.out.println(s.firstMissingPositive(new int[]{43, 20, 39, -7, -8, -2, 8, 17, 10, 17, 12, 6, 37, 17, 50, 44, 3, 11, 18, -4, 44, 37, 28, 50, 15, 50, 19, 0, 45, 5, 37, 35, 35, 21, 39, 35, 27, -8, -1, 47, 19, 22, 1, 1, 47, -4, -7, -3, 16, 21, 2, 7, 6}));

        //System.out.println(s.firstMissingPositive(new int[]{3, 11, 18, -4, 44, 37, 28, 50, 15, 50, 19, 0, 45, 5, 37, 35, 35, 21, 39, 35, 27, -8, -1, 47, 19, 22, 1, 1, 47, -4, -7, -3, 16, 21, 2, 7, 6}));
        System.out.println(s.firstMissingPositive(new int[]{3, 11, 18, -4, 44, 37, 28, 50, 15, 50, 19, 0, 45, 5, 37, 35, 35, 21, 39, 35, 27, -8, -1, 47, 19, 22, 1, 1, 47, -4, -7, -3, 16, 21, 2, 7, 6}));

        System.out.println(s.firstMissingPositive(new int[]{1,2,4,5,3}));
    }
}
