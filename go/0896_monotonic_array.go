package main

func isMonotonic(nums []int) bool {
	inc, decr := false, false
	for i := 1; i < len(nums); i++ {
		if nums[i] > nums[i-1] {
			inc = true
		}
		if nums[i] < nums[i-1] {
			decr = true
		}
	}
	return !(inc && decr)
}
