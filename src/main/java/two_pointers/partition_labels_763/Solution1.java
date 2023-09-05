package two_pointers.partition_labels_763;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=B7m8UmZE-vw
public class Solution1 {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int size = 0, end = 0;
        for (int i = 0; i < s.length(); ++i) {
            size += 1;
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
            if (i == end) {
                result.add(size);
                size = 0;
            }
        }
        return result;
    }
}
