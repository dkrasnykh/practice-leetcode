package binary_search.guess_number_higher_or_lower_374;

/**
 * Forward declaration of guess API.
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */
class GuessGame{
    int guess(int m){
        return 1;
    }
}

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 0, r = n;
        while(l <= n){
            int m = l + ((r - l) / 2);
            int res = guess(m);
            if(res < 0){
                r = m - 1;
            } else if (res > 0){
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }
}
