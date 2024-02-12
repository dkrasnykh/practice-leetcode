package main

import "sort"

func divideArray(nums []int, k int) [][]int {
	sort.Ints(nums)
	result := make([][]int, 0)
	i := 0
	for i < len(nums) {
		if nums[i+2]-nums[i] > k {
			return [][]int{}
		}
		result = append(result, []int{nums[i], nums[i+1], nums[i+2]})
		i += 3
	}
	return result
}
