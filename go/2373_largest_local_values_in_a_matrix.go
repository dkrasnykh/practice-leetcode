package main

func max3(r int, c int, grid [][]int) int {
	res := 0
	for i := r; i < r+3; i++ {
		for j := c; j < c+3; j++ {
			res = max(res, grid[i][j])
		}
	}
	return res
}

func largestLocal(grid [][]int) [][]int {
	n := len(grid)
	res := make([][]int, n-2)
	for i := 0; i < n-2; i++ {
		for j := 0; j < n-2; j++ {
			res[i] = append(res[i], max3(i, j, grid))
		}
	}
	return res
}
