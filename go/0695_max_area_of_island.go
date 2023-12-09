package main

func maxAreaOfIsland(grid [][]int) int {
	m, n := len(grid), len(grid[0])
	d := [][]int{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}
	var dfs func(r, c int) int
	dfs = func(r, c int) int {
		if r < 0 || r == m || c < 0 || c == n || grid[r][c] == 0 {
			return 0
		}
		res := grid[r][c]
		grid[r][c] = 0
		for _, v := range d {
			res += dfs(r+v[0], c+v[1])
		}
		return res
	}
	ans := 0
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			ans = max(ans, dfs(i, j))
		}
	}
	return ans
}
