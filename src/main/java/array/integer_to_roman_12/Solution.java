package array.integer_to_roman_12;

import java.util.Map;
import java.util.HashMap;

public class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        StringBuilder sb = new StringBuilder();
        int[] ranks = {1000, 100, 10, 1};
        for(Integer rank : ranks){
            int n = num/rank;
            if(n == 4 || n == 9){
                sb.append(map.get(n * rank));
            } else {
                if (n >= 5) {
                    sb.append(map.get(5 * rank));
                    n -= 5;
                }
                for(int i = 0; i < n; ++i){
                    sb.append(map.get(rank));
                }
            }
            num %= rank;
        }
        return sb.toString();
    }

}
