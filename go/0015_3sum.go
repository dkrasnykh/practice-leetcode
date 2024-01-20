package main

import (
	"sort"
)

func threeSum(nums []int) [][]int {
	sort.Ints(nums)
	res := [][]int{}
	i := 0
	for i < len(nums)-2 {
		l, r := i+1, len(nums)-1

		for l < r {
			total := nums[i] + nums[l] + nums[r]
			if total > 0 {
				r -= 1
			} else if total < 0 {
				l += 1
			} else {
				res = append(res, []int{nums[i], nums[l], nums[r]})
				for l+1 < len(nums) && nums[l] == nums[l+1] {
					l += 1
				}
				l += 1
				r -= 1
			}
		}
		for i+1 < len(nums) && nums[i] == nums[i+1] {
			i += 1
		}
		i += 1
	}
	return res
}
