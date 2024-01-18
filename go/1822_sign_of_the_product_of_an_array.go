package main

func arraySign(nums []int) int {
	negative := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] == 0 {
			return 0
		} else if nums[i] < 0 {
			negative += 1
		}
	}
	return 1 - 2*(negative%2)
}
