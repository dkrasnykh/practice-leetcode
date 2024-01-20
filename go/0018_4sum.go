package main

import (
	"sort"
)

func fourSum(nums []int, target int) [][]int {
	sort.Ints(nums)
	res := [][]int{}
	for i := 0; i < len(nums)-3; i++ {
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}
		for j := i + 1; j < len(nums)-2; j++ {
			if j > i+1 && nums[j] == nums[j-1] {
				continue
			}
			twoTotal := nums[i] + nums[j]
			l, r := j+1, len(nums)-1
			for l < r {
				if nums[l]+nums[r] > target-twoTotal {
					r -= 1
				} else if nums[l]+nums[r] < target-twoTotal {
					l += 1
				} else {
					res = append(res, []int{nums[i], nums[j], nums[l], nums[r]})
					for l+1 < len(nums) && nums[l] == nums[l+1] {
						l += 1
					}
					l += 1
					r -= 1
				}
			}
		}
	}
	return res
}
