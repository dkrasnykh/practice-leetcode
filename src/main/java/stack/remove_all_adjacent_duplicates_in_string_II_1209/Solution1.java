package stack.remove_all_adjacent_duplicates_in_string_II_1209;

import java.util.ArrayDeque;

//https://www.youtube.com/watch?v=w6LcypDgC4w
public class Solution1 {

    public String removeDuplicates(String s, int k) {
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            if(!stack.isEmpty() && stack.getLast()[0]==c){
                stack.getLast()[1] += 1;
            } else {
                stack.addLast(new int[]{c, 1});
            }
            if(stack.getLast()[1]==k){
                stack.pollLast();
            }
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            int[] e = stack.pollFirst();
            for(int i = 0; i < e[1]; ++i){
                res.append((char)e[0]);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        //System.out.println((char)97);
    }
}
