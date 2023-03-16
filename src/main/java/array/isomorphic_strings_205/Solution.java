package array.isomorphic_strings_205;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> st = new HashMap<>();
        Map<Character, Character> ts = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            Character c = st.get(s.charAt(i));
            Character c1 = ts.get(t.charAt(i));
            if (c != null && t.charAt(i) != c) {
                return false;
            }
            if (c1 != null && s.charAt(i) != c1) {
                return false;
            }
            st.put(s.charAt(i), t.charAt(i));
            ts.put(t.charAt(i), s.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isIsomorphic("egg", "add"));
        System.out.println(s.isIsomorphic("foo", "bar"));
        System.out.println(s.isIsomorphic("paper", "title"));
    }
}
