package main

func singleNonDuplicate(nums []int) int {
	n := len(nums)
	l, r := 0, n-1
	for l <= r {
		m := l + (r-l)/2
		if n == 1 ||
			m == 0 && nums[m] != nums[m+1] ||
			m == n-1 && nums[m] != nums[m-1] ||
			nums[m] != nums[m-1] && nums[m] != nums[m+1] {
			return nums[m]
		}
		var onTheRight int
		if m < n-1 && nums[m] == nums[m+1] {
			onTheRight = n - m
		} else {
			onTheRight = n - m - 1
		}
		if onTheRight%2 == 1 {
			l = m + 1
		} else {
			r = m - 1
		}
	}
	return 0
}
