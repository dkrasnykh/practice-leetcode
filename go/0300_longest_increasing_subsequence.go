package main

// n^2
func lengthOfLIS(nums []int) int {
	dp := make([]int, len(nums))
	dp[0] = 1
	ans := 1
	for i := 1; i < len(nums); i++ {
		dp[i] = 1
		prev := 0
		for j := i - 1; j >= 0; j-- {
			if nums[j] < nums[i] {
				prev = max(prev, dp[j])
			}
		}
		dp[i] += prev
		ans = max(ans, dp[i])
	}
	return ans
}
