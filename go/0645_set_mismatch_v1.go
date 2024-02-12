package main

func findErrorNums1(nums []int) []int {
	n := len(nums)
	res := make([]int, 2)
	abs := func(num int) int {
		if num < 0 {
			return -num
		}
		return num
	}
	for i := 0; i < n; i++ {
		ind := abs(nums[i]) - 1
		if nums[ind] < 0 {
			res[0] = ind + 1
		} else {
			nums[ind] *= (-1)
		}
	}
	for i := 0; i < n; i++ {
		if nums[i] > 0 {
			res[1] = i + 1
		}
	}
	return res
}
