package main

import "sort"

//https://www.youtube.com/watch?v=mBk4I0X46oI
func canPartitionKSubsets1(nums []int, k int) bool {
	total := 0
	for i := 0; i < len(nums); i++ {
		total += nums[i]
	}
	if total%k != 0 {
		return false
	}
	target := total / k
	used := make([]bool, len(nums))
	sort.Slice(nums, func(i, j int) bool {
		return nums[i] > nums[j]
	})

	var backtrack func(i, k, subsetSum int) bool
	backtrack = func(i, k, subsetSum int) bool {
		if k == 0 {
			return true
		}
		if subsetSum == target {
			return backtrack(0, k-1, 0)
		}
		for j := i; j < len(nums); j++ {
			if used[j] || subsetSum+nums[j] > target {
				continue
			}
			used[j] = true
			if backtrack(j+1, k, subsetSum+nums[j]) {
				return true
			}
			used[j] = false
		}
		return false
	}
	return backtrack(0, k, 0)
}
