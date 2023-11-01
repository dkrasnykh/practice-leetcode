package sliding_window.fruit_into_baskets_904;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> baskets = new HashMap<>();
        int l = 0, total = 0, max = 0;
        for (int r = 0; r < fruits.length; ++r) {
            if (baskets.size() == 2 && !baskets.containsKey(fruits[r])) {
                max = Math.max(max, total);
                while (l <= r && baskets.size() == 2) {
                    baskets.compute(fruits[l], (k, v) -> v - 1);
                    total -= 1;
                    if (baskets.get(fruits[l]) == 0) {
                        baskets.remove(fruits[l]);
                    }
                    l += 1;
                }
            }
            baskets.compute(fruits[r], (k, v) -> v == null ? 1 : v + 1);
            total += 1;
        }
        max = Math.max(max, total);
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }
}
