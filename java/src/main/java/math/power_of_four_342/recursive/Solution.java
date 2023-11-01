package math.power_of_four_342.recursive;

//https://www.youtube.com/watch?v=qEYZPwnlM0U
public class Solution {
    public boolean isPowerOfFour(int n) {
        if (n == 1) {
            return true;
        }
        if (n <= 0 || n % 4 != 0) {
            return false;
        }
        return isPowerOfFour(n / 4);
    }
}
