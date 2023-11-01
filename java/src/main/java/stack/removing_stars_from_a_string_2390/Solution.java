package stack.removing_stars_from_a_string_2390;

public class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == '*'){
                sb.delete(sb.length() - 1, sb.length());
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
