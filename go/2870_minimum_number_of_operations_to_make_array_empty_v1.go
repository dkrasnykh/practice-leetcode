package main

import "math"

func minOperations2(nums []int) int {
	count := make(map[int]int)
	for i := 0; i < len(nums); i++ {
		count[nums[i]] += 1
	}
	res := 0
	for _, c := range count {
		if c == 1 {
			return -1
		}
		res += int(math.Ceil(float64(c) / 3.0))
	}
	return res
}
