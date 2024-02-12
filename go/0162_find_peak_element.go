package main

func findPeakElement(nums []int) int {
	l, r, n := 0, len(nums)-1, len(nums)
	for l <= r {
		m := l + (r-l)/2
		if n == 1 ||
			m == 0 && nums[m] > nums[m+1] ||
			m == n-1 && nums[m] > nums[m-1] ||
			nums[m] > nums[m+1] && nums[m] > nums[m-1] {
			return m
		}
		if m < n-1 && nums[m] < nums[m+1] {
			l = m + 1
		} else {
			r = m - 1
		}
	}
	return 0
}
