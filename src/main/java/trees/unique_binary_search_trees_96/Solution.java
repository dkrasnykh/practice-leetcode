package trees.unique_binary_search_trees_96;

public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                int l = (j - 1) == 0 ? 1 : j - 1;
                int r = (i - j) == 0 ? 1 : i - j;
                dp[i] += dp[l] * dp[r];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numTrees(6));
    }
}
