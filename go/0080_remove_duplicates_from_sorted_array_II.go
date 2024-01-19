package main

func removeDuplicates1(nums []int) int {
	if len(nums) < 3 {
		return len(nums)
	}
	l := 2
	for r := 2; r < len(nums); r++ {
		if nums[r] != nums[r-1] || nums[r] == nums[l-1] && nums[r] != nums[l-2] {
			nums[l] = nums[r]
			l += 1
		}
	}
	return l
}
