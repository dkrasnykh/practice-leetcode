package array.largest_number_179;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1 {
    public String largestNumber(int[] nums) {
        String[] numstr = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            numstr[i] = String.valueOf(nums[i]);
        }
        Comparator comparator = (o1, o2) -> {
            String s1 = (String) o1;
            String s2 = (String) o2;
            if(s1.concat(s2).compareTo(s2.concat(s1)) > 0 ){
                return -1;
            } else {
                return 1;
            }
        };
        Arrays.sort(numstr, comparator);
        String ans = String.join("", numstr);
        return ans.charAt(0) == '0' ? "0" : ans;
    }

    public static void main(String[] args) {

    }
}
