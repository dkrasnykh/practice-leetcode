package two_pointers.reverse_words_in_a_string_III_557;

public class Solution {
    private char[] reverse(String curr){
        char[] arr = curr.toCharArray();
        int l = 0, r = arr.length - 1;
        while(l < r){
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l += 1;
            r -= 1;
        }
        return arr;
    }

    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int length = 0;
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == ' '){
                String curr = s.substring(i - length, i);
                result.append(reverse(curr)).append(' ');
                length = 0;
            } else {
                length += 1;
            }
        }
        String curr = s.substring(s.length() - length);
        result.append(reverse(curr));
        return result.toString();
    }
}
