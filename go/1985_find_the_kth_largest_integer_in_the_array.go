package main

import (
	"sort"
)

func kthLargestNumber(nums []string, k int) string {
	sort.Slice(nums, func(i, j int) bool {
		if len(nums[i]) == len(nums[j]) {
			for idx := 0; idx < len(nums[i]); idx++ {
				if nums[i][idx] != nums[j][idx] {
					return nums[i][idx] > nums[j][idx]
				}
			}
			return true
		} else {
			return len(nums[i]) > len(nums[j])
		}
	})
	return nums[k-1]
}
