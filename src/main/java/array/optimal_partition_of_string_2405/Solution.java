package array.optimal_partition_of_string_2405;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int partitionString(String s) {
        int res = 0;
        Set<Character> sub = new HashSet<>();
        int i = 0;
        while(i < s.length()){
            if(!sub.contains(s.charAt(i))){
                sub.add(s.charAt(i));
                i += 1;
            } else {
                res += 1;
                sub.clear();
            }
        }
        res += (sub.isEmpty() ? 0 : 1);
        return res;
    }

    public static void main(String[] args) {
        //s = "abacaba"
        //s = "ssssss"
        //"shkqbyutdvknyrpjof"
        //output = 3, expected = 2
        Solution s = new Solution();
        //System.out.println(s.partitionString("abacaba"));
        //System.out.println(s.partitionString("ssssss"));
        System.out.println(s.partitionString("shkqbyutdvknyrpjof"));
    }
}
