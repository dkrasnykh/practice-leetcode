package arrays_hashing.top_K_frequent_elements_347;

import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int maxfreq = 0;
        for (int i = 0; i < nums.length; ++i) {
            cnt.compute(nums[i], (key, value) -> (value == null) ? 1 : value + 1);
            maxfreq = Math.max(maxfreq, cnt.get(nums[i]));
        }
        List<Integer>[] bucket = new List[maxfreq + 1];
        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            int n = e.getKey();
            int freq = e.getValue();
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(n);
        }
        int[] ans = new int[k];
        int j = 0;
        for (int i = maxfreq; i >= 0; --i) {
            if (bucket[i] != null) {
                for (Integer e : bucket[i]) {
                    ans[j] = e;
                    ++j;
                    if (j == k) {
                        return ans;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.topKFrequent(new int[]{1,1,1,2,2,3}, 2)));

    }
}
