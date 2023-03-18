package array.longest_consecutive_sequence_128;

import java.util.*;

public class Solution {
    private Map<Integer, List<Integer>> adjList;
    private Map<Integer, Boolean> used;
    private int lenght;

    private void dfs(int v) {
        used.replace(v, true);
        ++lenght;
        for (Integer u : adjList.get(v)) {
            if (!used.get(u)) {
                dfs(u);
            }
        }
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for (Integer n : nums) {
            unique.add(n);
        }
        adjList = new HashMap<>();
        used = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (unique.contains(nums[i] - 1)) {
                if (adjList.containsKey(nums[i] - 1)) {
                    adjList.get(nums[i] - 1).add(nums[i]);
                } else {
                    adjList.put(nums[i] - 1, new ArrayList<>(Collections.singletonList(nums[i])));
                }
                if (adjList.containsKey(nums[i])) {
                    adjList.get(nums[i]).add(nums[i] - 1);
                } else {
                    adjList.put(nums[i], new ArrayList<>(Collections.singletonList(nums[i] - 1)));
                }
                used.put(nums[i] - 1, false);
                used.put(nums[i], false);
            }
        }
        int maxlenght = 0;
        for (Integer v : adjList.keySet()) {
            if (used.get(v)) {
                continue;
            }
            lenght = 0;
            dfs(v);
            maxlenght = Math.max(maxlenght, lenght);
        }
        return (maxlenght == 0 && nums.length > 0) ? 1 : maxlenght;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(s.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(s.longestConsecutive(new int[]{0}));
    }
}
