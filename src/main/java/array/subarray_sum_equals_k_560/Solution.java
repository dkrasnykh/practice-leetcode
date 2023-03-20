package array.subarray_sum_equals_k_560;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefix = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; ++i) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        int total = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 1; i < prefix.length; ++i) {
            if (map.containsKey(prefix[i] - k)) {
                total += map.get(prefix[i] - k);
            }
            map.compute(prefix[i], (key, value) -> value == null ? 1 : value + 1);
        }
        return total;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(s.subarraySum(new int[]{1, 2, 3}, 3));
    }
}
