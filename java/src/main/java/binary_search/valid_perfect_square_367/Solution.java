package binary_search.valid_perfect_square_367;

public class Solution {
    public boolean isPerfectSquare(int num) {
        int l = 0, r = num;
        while (l <= r) {
            int m = l + (r - l) / 2;
            long square = (long) m * m;
            if (square < num) {
                l = m + 1;
            } else if (square > num) {
                r = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        Solution s = new Solution();
        System.out.println(s.isPerfectSquare(16));
        System.out.println(s.isPerfectSquare(14));
    }
}
