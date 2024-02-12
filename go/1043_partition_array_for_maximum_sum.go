package main

func maxSumAfterPartitioning(arr []int, k int) int {
	max := func(n1, n2 int) int {
		if n1 > n2 {
			return n1
		}
		return n2
	}
	n := len(arr)
	dp := make([]int, n+1)
	dp[0] = 0
	for i := 1; i <= n; i++ {
		curr := arr[i-1]
		for j := 1; j <= k; j++ {
			if i-j >= 0 {
				curr = max(curr, arr[i-j])
				dp[i] = max(dp[i], dp[i-j]+curr*j)
			}
		}
	}
	return dp[n]
}
