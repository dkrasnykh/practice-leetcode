package backtracking.restore_ip_addresses_93;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private void backtrack(String s, List<String> result, ArrayDeque<String> parts) {
        if (parts.size() == 4 && s.length() == 0) {
            result.add(String.join(".", parts));
        }
        if (s.length() == 0 || (4 - parts.size()) * 3 < s.length()) {
            return;
        }
        for (int i = 1; i <= 3; ++i) {
            if (s.length() >= i) {
                String num = s.substring(0, i);
                if (Integer.parseInt(num) > 255 || num.length() > 1 && num.charAt(0) == '0') {
                    return;
                }
                parts.addLast(num);
                backtrack(s.substring(i), result, parts);
                parts.pollLast();
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, result, new ArrayDeque<>());
        return result;
    }

    public static void main(String[] args) {
        /*
        Input: s = "25525511135"
        Output: ["255.255.11.135","255.255.111.35"]
        */
        Solution s = new Solution();
        List<String> result = s.restoreIpAddresses("25525511135");
        //List<String> result = s.restoreIpAddresses("0000");
    }
}
