package stack.decode_string_394;

import java.util.ArrayDeque;

public class Solution {
    public String decodeString(String s) {
        ArrayDeque<Integer> numberPos = new ArrayDeque<>();
        ArrayDeque<Integer> bracketPos = new ArrayDeque<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c) && (i == 0 || !Character.isDigit(s.charAt(i - 1)))) {
                numberPos.addLast(builder.length());
                builder.append(c);
            } else if (c == '[') {
                bracketPos.addLast(builder.length());
                builder.append(c);
            } else if (c == ']') {
                int open = bracketPos.pollLast();
                String word = builder.substring(open + 1, builder.length());
                builder.delete(open, builder.length());
                int pnum = numberPos.pollLast();
                int number = Integer.parseInt(builder.substring(pnum, builder.length()));
                builder.delete(pnum, builder.length());
                for(int j = 0; j < number; ++j){
                    builder.append(word);
                }
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.decodeString("3[a]2[bc]"));
        System.out.println(s.decodeString("3[a2[c]]"));
        System.out.println(s.decodeString("2[abc]3[cd]ef"));

        System.out.println(s.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }
}
