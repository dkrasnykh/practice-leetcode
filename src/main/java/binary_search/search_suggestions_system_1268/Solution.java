package binary_search.search_suggestions_system_1268;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private int border(String[] products, String prefix, boolean leftBias) {
        int l = 0, r = products.length - 1;
        int i = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (products[m].startsWith(prefix)) {
                i = m;
                if (leftBias) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else if (products[m].compareTo(prefix) < 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return i;
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        StringBuilder prefix = new StringBuilder();
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); ++i) {
            prefix.append(searchWord.charAt(i));
            int l = border(products, prefix.toString(), true);
            int r = border(products, prefix.toString(), false);
            List<String> ans = new ArrayList<>();
            if (l != -1 && l <= r) {
                for (int j = l; j <= Math.min(r, l + 2); ++j) {
                    ans.add(products[j]);
                }
            }
            res.add(ans);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> res = s.suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse");
        for (List<String> l : res) {
            System.out.println(l);
        }
    }
}
