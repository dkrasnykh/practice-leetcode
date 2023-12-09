package main

func numIslands(grid [][]byte) int {
	m, n := len(grid), len(grid[0])
	d := [][]int{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}
	var dfs func(r, c int)
	dfs = func(r, c int) {
		if r < 0 || r == m || c < 0 || c == n || grid[r][c] == '0' {
			return
		}
		grid[r][c] = '0'
		for _, v := range d {
			dfs(r+v[0], c+v[1])
		}
	}
	ans := 0
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == '1' {
				dfs(i, j)
				ans += 1
			}
		}
	}
	return ans
}
