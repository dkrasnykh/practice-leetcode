package binary_search.koko_eating_bananas_875;

import java.util.Arrays;

public class Solution {
    private boolean check(int k, int[] piles, int h) {
        long hours = 0;
        for (int i = 0; i < piles.length; ++i) {
            hours += (piles[i] / k);
            hours += ((piles[i] % k == 0) ? 0 : 1);
        }
        return (hours <= h);
    }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().orElse(0);
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (check(m, piles, h)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //System.out.println(s.check(5, new int[]{3, 6, 7, 11}, 8));
        System.out.println(s.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(s.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        System.out.println(s.minEatingSpeed(new int[]{332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184}, 823855818));
    }
}
