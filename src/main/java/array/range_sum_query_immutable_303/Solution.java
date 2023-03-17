package array.range_sum_query_immutable_303;

class NumArray {
    private long[] prefix;

    public NumArray(int[] nums) {
        prefix = new long[nums.length + 1];
        for (int i = 1; i <= nums.length; ++i) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return (int) (prefix[right + 1] - prefix[left]);
    }
}

public class Solution {
    public static void main(String[] args) {
        NumArray obj = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj.sumRange(2, 5));
        System.out.println(obj.sumRange(0, 5));
    }
}
