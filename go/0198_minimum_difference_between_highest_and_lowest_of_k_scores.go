package main

import "sort"

func minimumDifference(nums []int, k int) int {
	sort.Slice(nums, func(i, j int) bool {
		return nums[i] < nums[j]
	})
	res := nums[len(nums)-1] - nums[0]
	for i := k - 1; i < len(nums); i++ {
		res = min(res, nums[i]-nums[i+1-k])
	}
	return res
}
