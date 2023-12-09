package main

func islandPerimeter(grid [][]int) int {
	p := 0
	m := len(grid)
	n := len(grid[0])
	d := [][]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}
	var dfs func(r, c int)
	dfs = func(r, c int) {
		if r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0 || grid[r][c] == 2 {
			return
		}
		if r == 0 || grid[r-1][c] == 0 {
			p += 1
		}
		if r+1 == m || grid[r+1][c] == 0 {
			p += 1
		}
		if c == 0 || grid[r][c-1] == 0 {
			p += 1
		}
		if c+1 == n || grid[r][c+1] == 0 {
			p += 1
		}
		grid[r][c] = 2
		for _, v := range d {
			dfs(r+v[0], c+v[1])
		}
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			dfs(i, j)
		}
	}
	return p
}
