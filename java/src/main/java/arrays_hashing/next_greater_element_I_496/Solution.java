package arrays_hashing.next_greater_element_I_496;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (Integer n : nums2) {
            while (!stack.isEmpty() && stack.getLast() < n) {
                map2.put(stack.removeLast(), n);
            }
            stack.addLast(n);
        }
        while (!stack.isEmpty()) {
            map2.put(stack.removeLast(), -1);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            ans[i] = (map2.get(nums1[i]) > nums1[i]) ? map2.get(nums1[i]) : -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
        System.out.println(Arrays.toString(s.nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4})));
    }
}
