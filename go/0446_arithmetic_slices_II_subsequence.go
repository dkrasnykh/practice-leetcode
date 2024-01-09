package main

func numberOfArithmeticSlices(nums []int) int {
	res, n := 0, len(nums)
	dp := make([]map[int]int, n)
	for i := 0; i < n; i++ {
		dp[i] = make(map[int]int)
	}
	for i := 0; i < n; i++ {
		for j := 0; j < i; j++ {
			diff := (nums[i] - nums[j])
			dp[i][diff] += 1 + dp[j][diff]
			res += 1 + dp[j][diff]
		}
	}
	return res - (n * (n - 1) / 2)
}
