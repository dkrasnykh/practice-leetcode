package two_pointers.partition_labels_763;

import java.util.ArrayList;
import java.util.List;

//it is better (in leetcode) than Solution1
public class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] entry = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            entry[s.charAt(i) - 'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int l = 0, r = 0;
        while (l < s.length()) {
            int start = l;
            while (l <= r) {
                r = Math.max(r, entry[s.charAt(l) - 'a']);
                l += 1;
            }
            result.add(l - start);
            r = l;
        }
        return result;
    }
}
