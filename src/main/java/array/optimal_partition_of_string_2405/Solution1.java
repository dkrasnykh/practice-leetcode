package array.optimal_partition_of_string_2405;

import java.util.HashSet;
import java.util.Set;

//https://www.youtube.com/watch?v=CKZPdiXiQf0
public class Solution1 {
    public int partitionString(String s) {
        int res = 1;
        Set<Character> curSet = new HashSet<>();
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            if(curSet.contains(c)){
                res += 1;
                curSet = new HashSet<>();
            }
            curSet.add(c);
        }
        return res;
    }
}
