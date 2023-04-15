package binary_search.search_suggestions_system_1268;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//two pointers
//https://www.youtube.com/watch?v=D4T2N0yAr20
public class Solution1 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> res = new ArrayList<>();
        int l = 0, r = products.length - 1;
        for (int i = 0; i < searchWord.length(); ++i) {
            char c = searchWord.charAt(i);
            while (l <= r && (products[l].length() <= i || products[l].charAt(i) != c)) {
                l += 1;
            }
            while (l <= r && (products[r].length() <= i || products[r].charAt(i) != c)) {
                r -= 1;
            }
            List<String> ans = new ArrayList<>();
            int remain = r - l + 1;
            for(int j = 0; j < Math.min(3, remain); ++j){
                ans.add(products[l + j]);
            }
            res.add(ans);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
