package main

func numEnclaves(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])
	used := make([][]bool, m)
	for i := 0; i < m; i++ {
		used[i] = make([]bool, n)
	}
	result := 0
	direct := [][]int{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}
	sub := 0
	var dfs func(r, c int) bool
	dfs = func(r, c int) bool {
		if r < 0 || r == m || c < 0 || c == n {
			return false
		}
		if used[r][c] || grid[r][c] == 0 {
			return true
		}
		used[r][c] = true
		sub += 1
		ans := true
		for _, d := range direct {
			ans = dfs(r+d[0], c+d[1]) && ans
		}
		return ans
	}
	for r := 0; r < m; r++ {
		for c := 0; c < n; c++ {
			sub = 0
			if !used[r][c] && dfs(r, c) {
				result += sub
			}
		}
	}
	return result
}
