package backtracking.generate_parentheses_22;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private void generate(List<String> result, int n, int open, int close, StringBuilder sb){
        if(open == close && n == open){
            result.add(sb.toString());
        } else {
            if(open < n){
                sb.append("(");
                generate(result, n, open + 1, close, sb);
                sb.delete(sb.length()-1, sb.length());
            }
            if(close < open){
                sb.append(")");
                generate(result, n, open, close + 1, sb);
                sb.delete(sb.length()-1, sb.length());
            }
        }
    }

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        generate(result, n, 0, 0, sb);
        return result;
    }
}
