package main

func findErrorNums(nums []int) []int {
	n := len(nums)
	m := map[int]int{}
	for i := 0; i < n; i++ {
		m[nums[i]] += 1
	}
	res := make([]int, 2)
	for i := 1; i <= n; i++ {
		if m[i] > 1 {
			res[0] = i
		} else if m[i] == 0 {
			res[1] = i
		}
	}
	return res
}
