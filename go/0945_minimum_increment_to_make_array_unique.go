package main

import "sort"

func minIncrementForUnique(nums []int) int {
	sort.Ints(nums)
	res := 0
	for i := 1; i < len(nums); i++ {
		if nums[i] <= nums[i-1] {
			res += (nums[i-1] + 1 - nums[i])
			nums[i] = nums[i-1] + 1
		}
	}
	return res
}
