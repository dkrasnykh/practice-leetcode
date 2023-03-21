package array.largest_number_179;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int res(String s1, String s2) {
        if (s1.length() < s2.length() && s1.equals(s2.substring(0, s1.length()))) {
            return res(s1, s2.substring(s1.length()));
        } else if (s1.length() > s2.length() && s2.equals(s1.substring(0, s2.length()))) {
            return res(s1.substring(s2.length()), s2);
        } else {
            return s2.compareTo(s1);
        }
    }

    public String largestNumber(int[] nums) {
        String[] numstr = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            numstr[i] = String.valueOf(nums[i]);
        }
        Comparator comparator = (o1, o2) -> {
            String s1 = (String) o1;
            String s2 = (String) o2;
            return res(s1, s2);
        };
        Arrays.sort(numstr, comparator);
        String ans = String.join("", numstr);
        return ans.charAt(0) == '0' ? "0" : ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.largestNumber(new int[]{10, 2}));
        System.out.println(s.largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(s.largestNumber(new int[]{111311, 1113}));
        System.out.println(s.largestNumber(new int[]{432, 43243}));
    }
}
