package stack.backspace_string_compare_844;

public class Solution {
    private String exclude(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); ++i){
            if(sb.length() > 0 && s.charAt(i) == '#'){
                sb.delete(sb.length() - 1, sb.length());
            } else if (s.charAt(i) != '#'){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public boolean backspaceCompare(String s, String t) {
        s = exclude(s);
        t = exclude(t);
        return s.equals(t);
    }
}
