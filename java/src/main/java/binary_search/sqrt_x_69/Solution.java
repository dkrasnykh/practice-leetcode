package binary_search.sqrt_x_69;

public class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x;
        while(l <= r){
            int m = l + (r - l)/2;
            long square = ((long)m)*m;
            if(square <= (long)x){
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r;
    }
}
