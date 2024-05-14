package main

func getMaximumGold(grid [][]int) int {
	ROWS, COLS := len(grid), len(grid[0])
	used := make(map[[2]int]bool, len(grid)*len(grid[0]))

	ans, maxAns := 0, 0
	dir := [][]int{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}
	var backtrack func(r, c int)
	backtrack = func(r, c int) {
		if r < 0 || r >= ROWS || c < 0 || c >= COLS || used[[...]int{r, c}] || grid[r][c] == 0 {
			return
		}
		ans += grid[r][c]
		maxAns = max(maxAns, ans)
		used[[2]int{r, c}] = true
		for _, d := range dir {
			backtrack(r+d[0], c+d[1])
		}
		ans -= grid[r][c]
		delete(used, [2]int{r, c})
	}

	totalAns := 0

	for i := 0; i < ROWS; i++ {
		for j := 0; j < COLS; j++ {
			if grid[i][j] != 0 {
				clear(used)
				ans, maxAns = 0, 0
				backtrack(i, j)
				totalAns = max(totalAns, maxAns)
			}
		}
	}

	return totalAns
}
