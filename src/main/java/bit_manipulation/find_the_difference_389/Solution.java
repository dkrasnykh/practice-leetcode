package bit_manipulation.find_the_difference_389;

public class Solution {
    public char findTheDifference(String s, String t) {
        int result = (int)t.charAt(t.length() - 1);
        for(int i = 0; i < s.length(); ++i){
            result ^= (int)(s.charAt(i));
            result ^= (int)(t.charAt(i));
        }
        return (char)result;
    }
}
