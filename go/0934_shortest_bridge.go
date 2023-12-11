package main

func shortestBridge(grid [][]int) int {
	n := len(grid)
	q := make([][3]int, 0)
	used := make([][]bool, n)
	for i := 0; i < n; i++ {
		used[i] = make([]bool, n)
	}
	d := [][]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}
	var dfs func(r, c int)
	dfs = func(r, c int) {
		if r < 0 || r == n || c < 0 || c == n || used[r][c] || grid[r][c] == 0 {
			return
		}
		q = append(q, [...]int{r, c, 0})
		used[r][c] = true
		grid[r][c] = 0
		for _, v := range d {
			dfs(r+v[0], c+v[1])
		}
	}
	for i := 0; i < n; i++ {
		founded := false
		for j := 0; j < n; j++ {
			if grid[i][j] == 1 {
				dfs(i, j)
				founded = true
				break
			}
		}
		if founded {
			break
		}
	}
	for len(q) > 0 {
		r, c, b := q[0][0], q[0][1], q[0][2]
		q = q[1:]
		if grid[r][c] == 1 {
			return b - 1
		}
		for _, v := range d {
			nextr := r + v[0]
			nextc := c + v[1]
			if nextr >= 0 && nextr < n && nextc >= 0 && nextc < n && !used[nextr][nextc] {
				used[nextr][nextc] = true
				q = append(q, [...]int{nextr, nextc, b + 1})
			}
		}
	}
	return 0
}
