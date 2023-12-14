package main

func onesMinusZeros(grid [][]int) [][]int {
	m := len(grid)
	n := len(grid[0])
	onesRow := make([]int, m)
	onesCol := make([]int, n)
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == 1 {
				onesRow[i] += 1
				onesCol[j] += 1
			}
		}
	}
	diff := make([][]int, m)
	for i := 0; i < m; i++ {
		diff[i] = make([]int, n)
		for j := 0; j < n; j++ {
			zerosRow := m - onesRow[i]
			zerosCol := n - onesCol[j]
			diff[i][j] = onesRow[i] + onesCol[j] - zerosRow - zerosCol
		}
	}
	return diff
}
