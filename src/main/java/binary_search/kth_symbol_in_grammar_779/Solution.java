package binary_search.kth_symbol_in_grammar_779;

public class Solution {
    public int kthGrammar(int n, int k) {
        int cur = 0;
        int left = 1, right = 1 << (n - 1);
        for (int i = 0; i < n - 1; ++i) {
            int mid = left + (right - left)/2;
            if(k <= mid){
                right = mid;
            } else {
                left = mid + 1;
                cur = cur == 1 ? 0 : 1;
            }
        }
        return cur;
    }
}
