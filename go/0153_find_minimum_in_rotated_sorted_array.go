package main

func findMin(nums []int) int {
	n := len(nums)
	l, r := 0, n-1
	if nums[0] <= nums[n-1] {
		return nums[0]
	}
	for l <= r {
		m := l + (r-l)/2
		if m > 0 && nums[m] < nums[m-1] {
			return nums[m]
		}
		if nums[m] >= nums[0] {
			l = m + 1
		} else {
			r = m - 1
		}
	}
	return 0
}
