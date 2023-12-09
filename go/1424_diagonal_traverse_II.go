package main

//TL 54 test
func findDiagonalOrder(nums [][]int) []int {
	n := len(nums)
	m := len(nums[0])
	for i := 0; i < len(nums); i++ {
		m = max(m, len(nums[i]))
	}
	result := make([]int, 0)

	var traverse func(r, c int)

	traverse = func(r, c int) {
		if r < 0 || c >= m {
			return
		}
		if c < len(nums[r]) {
			result = append(result, nums[r][c])
		}
		traverse(r-1, c+1)
	}

	for i := 0; i < n; i++ {
		traverse(i, 0)
	}
	for j := 1; j < m; j++ {
		traverse(n-1, j)
	}
	return result
}
