package arrays_hashing.repeated_DNA_sequences_187;

import java.util.*;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Map<String, Boolean> subs = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if (i < 9) {
                sb.append(s.charAt(i));
            } else {
                sb.append(s.charAt(i));
                if(!subs.containsKey(sb.toString())){
                    subs.put(sb.toString(), false);
                } else if (!subs.get(sb.toString())){
                    res.add(sb.toString());
                    subs.replace(sb.toString(), true);
                }
                sb.delete(0, 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> ans = s.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        System.out.println(ans);
    }
}
