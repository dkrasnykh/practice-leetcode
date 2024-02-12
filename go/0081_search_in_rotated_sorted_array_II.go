package main

func search2(nums []int, target int) bool {
	l, r := 0, len(nums)-1
	for l <= r {
		m := l + (r-l)/2
		if nums[m] == target {
			return true
		}
		if nums[m] >= nums[0] {
			if nums[m] < target || nums[m] > target && target < nums[0] {
				l = m + 1
			} else if nums[m] > target && target >= nums[0] {
				r = m - 1
			}
		} else {
			if nums[m] > target || nums[m] < target && target >= nums[0] {
				r = m - 1
			} else if nums[m] < target && target < nums[0] {
				l = m + 1
			}
		}
	}
	return false
}
