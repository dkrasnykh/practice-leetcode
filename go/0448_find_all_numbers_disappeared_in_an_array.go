package main

func findDisappearedNumbers(nums []int) []int {
	res := make([]int, 0)
	abs := func(n int) int {
		if n > 0 {
			return n
		}
		return -n
	}
	for i := 0; i < len(nums); i++ {
		j := abs(nums[i]) - 1
		nums[j] = abs(nums[j]) * (-1)
	}
	for i := 0; i < len(nums); i++ {
		if nums[i] > 0 {
			res = append(res, i+1)
		}
	}
	return res
}
