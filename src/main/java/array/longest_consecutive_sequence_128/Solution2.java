package array.longest_consecutive_sequence_128;

import java.util.HashSet;
import java.util.Set;

//https://www.youtube.com/watch?v=P6RZZMu_maU
public class Solution2 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (Integer n : nums) {
            numSet.add(n);
        }
        int longest = 0;
        for(Integer n : nums){
            if(!numSet.contains(n - 1)){
                int lenght = 0;
                while(numSet.contains(n + lenght)){
                    ++lenght;
                }
                longest = Math.max(lenght, longest);
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(s.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(s.longestConsecutive(new int[]{0}));
    }
}
