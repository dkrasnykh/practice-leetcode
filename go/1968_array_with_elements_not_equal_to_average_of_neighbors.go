package main

import "sort"

func rearrangeArray(nums []int) []int {
	sort.Ints(nums)
	res := make([]int, len(nums))
	j := 0
	for i := 0; i < len(nums); i += 2 {
		res[i] = nums[j]
		j += 1
	}
	for i := 1; i < len(nums); i += 2 {
		res[i] = nums[j]
		j += 1
	}
	return res
}
