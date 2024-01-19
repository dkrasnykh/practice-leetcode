package main

// TL
func firstMissingPositive(nums []int) int {
	l, maxv := 0, -100100
	for i := 0; i < len(nums); i++ {
		maxv = max(maxv, nums[i])
		if nums[i] <= 0 {
			nums[l], nums[i] = nums[i], nums[l]
			l += 1
		}
	}
	if l == len(nums) {
		return 1
	}
	prev, inf := 0, 100010
	for prev != inf {
		minv := inf
		for i := l + 1; i < len(nums); i++ {
			if nums[i] < minv && nums[i] > prev {
				minv = nums[i]
			}
		}
		if prev+1 < minv {
			return prev + 1
		}
		prev = minv
	}
	return maxv + 1
}
