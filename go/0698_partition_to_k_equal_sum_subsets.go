package main

import "sort"

func canPartitionKSubsets(nums []int, k int) bool {
	total := 0
	for i := 0; i < len(nums); i++ {
		total += nums[i]
	}
	if total%k != 0 {
		return false
	}
	size := total / k

	subs := make([]int, k)
	sort.Slice(nums, func(i, j int) bool {
		return nums[i] > nums[j]
	})

	var backtrack func(ind int) bool
	backtrack = func(ind int) bool {
		if ind == len(nums) {
			return true
		}
		for i := 0; i < k; i++ {
			if subs[i]+nums[ind] <= size {
				subs[i] += nums[ind]
				if backtrack(ind + 1) {
					return true
				}
				subs[i] -= nums[ind]
			}
		}
		return false
	}
	return backtrack(0)
}
