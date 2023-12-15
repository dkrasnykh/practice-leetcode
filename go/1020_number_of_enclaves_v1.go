package main

func numEnclaves1(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])
	var dfs func(r, c int)
	dfs = func(r, c int) {
		if r < 0 || r == m || c < 0 || c == n || grid[r][c] == 0 {
			return
		}
		grid[r][c] = 0
		dfs(r-1, c)
		dfs(r+1, c)
		dfs(r, c-1)
		dfs(r, c+1)
	}
	for r := 0; r < m; r++ {
		dfs(r, 0)
		dfs(r, n-1)
	}
	for c := 0; c < n; c++ {
		dfs(0, c)
		dfs(m-1, c)
	}
	res := 0
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			res += grid[i][j]
		}
	}
	return res
}
