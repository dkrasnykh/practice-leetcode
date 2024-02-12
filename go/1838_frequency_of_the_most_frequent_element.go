package main

import "sort"

func maxFrequency(nums []int, k int) int {
	sort.Ints(nums)
	l, r, res, total := 0, 0, 0, 0
	for r < len(nums) {
		for l <= r && r < len(nums) && (r-l+1)*nums[r]-(total+nums[r]) <= k {
			total += nums[r]
			r += 1
		}
		res = max(res, r-l)
		l += 1
		r = max(l, r)
	}
	res = max(res, r-l)
	return res
}
