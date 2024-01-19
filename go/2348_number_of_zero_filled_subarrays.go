package main

func zeroFilledSubarray(nums []int) int64 {
	var res int64
	l := -1
	for i := 0; i < len(nums); i++ {
		if nums[i] == 0 && l == -1 {
			l = i
			res += 1
		} else if nums[i] == 0 {
			res += int64(i - l + 1)
		} else if i > 0 && nums[i] != 0 && nums[i-1] == 0 {
			l = -1
		}
	}
	return res
}
