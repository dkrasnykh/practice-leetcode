package binary_search.arranging_coins_441;

public class Solution {
    public int arrangeCoins(int n) {
        int l = 1, r = n;
        while (l <= r) {
            int m = l + (r - l + 1) / 2;
            long total = (long) (1 + m) * m / 2;
            if (total <= n) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.arrangeCoins(1));
    }
}
