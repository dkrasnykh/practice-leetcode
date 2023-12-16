package main

func minPathSum(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])
	dp := make([][]int, m+1)
	for i := 0; i <= m; i++ {
		dp[i] = make([]int, n+1)
		dp[i][0] = 1000
	}
	for j := 0; j <= n; j++ {
		dp[0][j] = 1000
	}
	dp[0][1] = 0
	for i := 1; i <= m; i++ {
		for j := 1; j <= n; j++ {
			dp[i][j] = grid[i-1][j-1] + min(dp[i-1][j], dp[i][j-1])
		}
	}
	return dp[m][n]
}
