package arrays_hashing.check_if_a_string_contains_all_binary_codes_of_size_K_1461;

import java.util.Set;
import java.util.HashSet;

public class Solution {
    public boolean hasAllCodes(String s, int k) {
        int unique = (1<<k);
        Set<String> codes = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int r = 0;
        for(int l = 0; l <= s.length() - k; ++l){
            while(r < l + k){
                sb.append(s.charAt(r));
                r += 1;
            }
            codes.add(sb.toString());
            sb.delete(0, 1);
        }
        return codes.size() == unique;
    }

    public static void main(String[] args) {

    }
}
