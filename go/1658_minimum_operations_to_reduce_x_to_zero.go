package main

func minOperations3(nums []int, x int) int {
	target := -x
	for i := 0; i < len(nums); i++ {
		target += nums[i]
	}
	if target < 0 {
		return -1
	}
	if target == 0 {
		return len(nums)
	}
	l, total, size := 0, 0, 0
	for r := 0; r < len(nums); r++ {
		total += nums[r]
		for total > target {
			total -= nums[l]
			l += 1
		}
		if total == target {
			size = max(size, r-l+1)
		}
	}
	if size == 0 {
		return -1
	}
	return len(nums) - size
}
