package main

func closedIsland(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])
	result := 0
	used := make([][]bool, m)
	for i := 0; i < m; i++ {
		used[i] = make([]bool, n)
	}
	direct := [][]int{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}
	var dfs func(r, c int) bool
	dfs = func(r, c int) bool {
		if r < 0 || r == m || c < 0 || c == n {
			return false
		}
		if used[r][c] || grid[r][c] == 1 {
			return true
		}
		used[r][c] = true
		ans := true
		for _, d := range direct {
			ans = dfs(r+d[0], c+d[1]) && ans
		}
		return ans
	}
	for r := 0; r < m; r++ {
		for c := 0; c < n; c++ {
			if grid[r][c] == 0 && !used[r][c] {
				if dfs(r, c) {
					result += 1
				}
			}
		}
	}
	return result
}
