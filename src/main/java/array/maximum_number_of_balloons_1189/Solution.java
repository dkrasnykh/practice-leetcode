package array.maximum_number_of_balloons_1189;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    private Map<Character, Integer> balloonDict(){
        Map<Character, Integer> res = new HashMap<>();
        res.put('b', 0);
        res.put('a', 0);
        res.put('l', 0);
        res.put('o', 0);
        res.put('n', 0);
        return res;
    }
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> cnt = balloonDict();
        for (int i = 0; i < text.length(); ++i) {
            if (cnt.containsKey(text.charAt(i))) {
                cnt.compute(text.charAt(i), (key, value) -> value + 1);
            }
        }
        cnt.replace('l', cnt.get('l')/2);
        cnt.replace('o', cnt.get('o')/2);
        return cnt.values()
                .stream()
                .min(Comparator.comparingInt(a -> a))
                .get();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxNumberOfBalloons("ballon"));
        System.out.println(s.maxNumberOfBalloons("nlaebolko"));
        System.out.println(s.maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(s.maxNumberOfBalloons("leetcode"));
    }
}
