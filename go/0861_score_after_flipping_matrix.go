package main

func changeRow(grid [][]int, r int) {
	for j := 0; j < len(grid[r]); j++ {
		if grid[r][j] == 0 {
			grid[r][j] = 1
		} else {
			grid[r][j] = 0
		}
	}
}

func changeColumn(grid [][]int, c int) {
	for i := 0; i < len(grid); i++ {
		if grid[i][c] == 0 {
			grid[i][c] = 1
		} else {
			grid[i][c] = 0
		}
	}
}

func isZeroColumn(grid [][]int, c int) bool {
	cnt := 0
	for i := 0; i < len(grid); i++ {
		if grid[i][c] == 0 {
			cnt += 1
		}
	}
	return cnt > len(grid)/2
}

func get10Number(grid [][]int, r int) int {
	ans := 0
	n := len(grid[r])
	for j := 0; j < n; j++ {
		p := n - j - 1
		if grid[r][p] == 1 {
			ans += (1 << j)
		}
	}
	return ans
}

func matrixScore(grid [][]int) int {
	m, n := len(grid), len(grid[0])
	if isZeroColumn(grid, 0) {
		changeColumn(grid, 0)
	}
	for i := 0; i < m; i++ {
		if grid[i][0] == 0 {
			changeRow(grid, i)
		}
	}
	for j := 1; j < n; j++ {
		if isZeroColumn(grid, j) {
			changeColumn(grid, j)
		}
	}
	ans := 0
	for i := 0; i < m; i++ {
		ans += get10Number(grid, i)
	}
	return ans
}
