package main

func rob(nums []int) int {
	n := len(nums)
	dp := make([]int, n+1)
	dp[0] = 0
	dp[1] = nums[0]
	for i := 2; i <= n; i++ {
		dp[i] = max(dp[i-1], dp[i-2]+nums[i-1])
	}
	return dp[n]
	/*
		rob1, rob2 := 0, 0

		//[rob1, rob2, n, n+1, ...]
		for _,n:= range nums {
			tmp := max(n + rob1, rob2)
			rob1 = rob2
			rob2 = tmp
		}
		return rob2
	*/
}
