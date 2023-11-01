package math.power_of_four_342;

public class Solution {
    public boolean isPowerOfFour(int n) {
        //return n > 0 && (Math.log(n) / Math.log(4) - (int)(Math.log(n) / Math.log(4)) < 0.00001);
        double res = Math.log(n) / Math.log(4);
        return !Double.isNaN(res) && !Double.isInfinite(res) && (res - (int) res < 0.00001);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.isPowerOfFour(0);
    }
}
