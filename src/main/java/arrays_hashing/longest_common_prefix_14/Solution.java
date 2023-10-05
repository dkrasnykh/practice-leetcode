package arrays_hashing.longest_common_prefix_14;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strs[0].length(); ++i) {
            for (int j = 0; j < strs.length; ++j) {
                if(i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)){
                    return res.toString();
                }
            }
            res.append(strs[0].charAt(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(s.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}
