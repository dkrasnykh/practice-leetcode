package main

func sortedSquares(nums []int) []int {
	abs := func(n int) int {
		if n < 0 {
			return -n
		}
		return n
	}
	res := make([]int, len(nums))
	l, r, i := 0, len(nums)-1, len(nums)-1
	for l <= r && i >= 0 {
		if abs(nums[l]) > abs(nums[r]) {
			res[i] = nums[l] * nums[l]
			l += 1
		} else {
			res[i] = nums[r] * nums[r]
			r -= 1
		}
		i -= 1
	}
	return res
}
