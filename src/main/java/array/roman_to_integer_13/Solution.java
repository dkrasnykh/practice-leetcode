package array.roman_to_integer_13;

import java.util.Map;
import java.util.HashMap;

public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int n = 0;
        n += map.get(s.charAt(0));
        for(int i = 1; i < s.length(); ++i){
            if((s.charAt(i) == 'V' || s.charAt(i) == 'X') && s.charAt(i-1) == 'I'){
                n += (map.get(s.charAt(i)) - 2);
            } else if ((s.charAt(i) == 'L' || s.charAt(i) == 'C') && s.charAt(i-1) == 'X') {
                n += (map.get(s.charAt(i)) - 20);
            } else if ((s.charAt(i) == 'D' || s.charAt(i) == 'M') && s.charAt(i-1) == 'C') {
                n += (map.get(s.charAt(i)) - 200);
            } else {
                n += map.get(s.charAt(i));
            }
        }
        return n;
    }
}
