package main

import (
	"sort"
)

func specialArray(nums []int) int {
	sort.Ints(nums)
	prev, n := -1, len(nums)
	for i := 0; i < n; i++ {
		x := n - i
		if nums[i] >= x && x > prev {
			return x
		}
		prev = nums[i]
	}
	return -1
}
