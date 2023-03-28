package array.continuous_subarray_sum_523;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

//TL
public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] prefix = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; ++i) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        Set<Integer> sums = new HashSet<>();
        sums.add(0);
        for (int i = 2; i <= nums.length; ++i) {
            final int p = prefix[i];
            Optional<Integer> res = sums.stream().filter(s -> (p - s) % k == 0).findFirst();
            if (res.isPresent()) {
                return true;
            }
            sums.add(prefix[i-1]);
        }
        return false;
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println(s.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
        System.out.println(s.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13));
    }
}
