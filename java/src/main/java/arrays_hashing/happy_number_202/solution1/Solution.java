package arrays_hashing.happy_number_202.solution1;

import java.util.HashSet;
import java.util.Set;

//https://www.youtube.com/watch?v=ljz85bxOYJ0
public class Solution {
    private int sumOfSquares(int n) {
        int output = 0;
        while (n != 0) {
            int digit = n % 10;
            output += (digit * digit);
            n /= 10;
        }
        return output;
    }

    public boolean isHappy(int n) {
        Set<Integer> visit = new HashSet<>();
        while (!visit.contains(n)) {
            visit.add(n);
            n = sumOfSquares(n);
            if (n == 1) {
                return true;
            }
        }
        return true;
    }
}
