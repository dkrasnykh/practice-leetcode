package main

func minSubArrayLen(target int, nums []int) int {
	l, n, total := 0, len(nums), 0
	ans := 2 * n
	for r := 0; r < n; r++ {
		total += nums[r]
		for total >= target {
			ans = min(ans, r-l+1)
			total -= nums[l]
			l += 1
		}
	}
	if ans == 2*n {
		return 0
	}
	return ans
}
