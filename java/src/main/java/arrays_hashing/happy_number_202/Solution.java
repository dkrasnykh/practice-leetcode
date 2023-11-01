package arrays_hashing.happy_number_202;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isHappy(int n) {
        int prev = n;
        Set<Integer> squares = new HashSet<>();
        while (true) {
            String s = Integer.toString(n);
            n = 0;
            for (int j = 0; j < s.length(); ++j) {
                Integer num = Character.getNumericValue(s.charAt(j));
                n += num * num;
            }
            if (n == prev) {
                return true;
            }
            if (squares.contains(n)) {
                return false;
            }
            prev = n;
            squares.add(n);
        }
    }
}
