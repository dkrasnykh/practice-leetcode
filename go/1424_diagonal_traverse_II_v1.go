package main

func findDiagonalOrder1(nums [][]int) []int {
	n := len(nums)
	m := len(nums[0])
	for i := 0; i < len(nums); i++ {
		m = max(m, len(nums[i]))
	}
	tmp := make([][]int, n+m)
	for i := n - 1; i >= 0; i-- { 
		for j := 0; j < len(nums[i]); j++ {
			if tmp[i+j] == nil {
				tmp[i+j] = make([]int, 0)
			}
			tmp[i+j] = append(tmp[i+j], nums[i][j])
		}
	}
	result := make([]int, 0)
	for i := 0; i < n+m; i++ {
		if tmp[i] != nil {
			result = append(result, tmp[i]...)
		}
	}
	return result
}
