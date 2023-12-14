package main

import "math"

func maxDistance(grid [][]int) int {
	n := len(grid)
	inf := 10000
	d := make([][]int, n)
	for i := 0; i < n; i++ {
		d[i] = make([]int, n)
		for j := 0; j < n; j++ {
			if grid[i][j] == 1 {
				d[i][j] = -1
			} else {
				d[i][j] = inf
			}
		}
	}

	bordered := func(r, c int) bool {
		return grid[r][c] == 1 &&
			(c+1 < n && grid[r][c+1] == 0 ||
				c-1 >= 0 && grid[r][c-1] == 0 ||
				r-1 >= 0 && grid[r-1][c] == 0 ||
				r+1 < n && grid[r+1][c] == 0)
	}

	valid := func(r, c int) bool {
		return r >= 0 && r < n && c >= 0 && c < n
	}

	direct := [][]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}
	bfs := func(x0, y0 int) {
		q := make([][2]int, 0)
		for _, dir := range direct {
			if valid(x0+dir[0], y0+dir[1]) && grid[x0+dir[0]][y0+dir[1]] == 0 {
				q = append(q, [...]int{x0 + dir[0], y0 + dir[1]})
			}
		}
		for len(q) > 0 {
			x1, y1 := q[0][0], q[0][1]
			q = q[1:]
			if int(math.Abs(float64(x0-x1))+math.Abs(float64(y0-y1))) < d[x1][y1] {
				d[x1][y1] = int(math.Abs(float64(x0-x1)) + math.Abs(float64(y0-y1)))
				for _, dir := range direct {
					if valid(x1+dir[0], y1+dir[1]) {
						q = append(q, [...]int{x1 + dir[0], y1 + dir[1]})
					}
				}
			}
		}
	}
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			if bordered(i, j) {
				bfs(i, j)
			}
		}
	}
	ans := 0
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == 0 {
				ans = max(ans, d[i][j])
			}
		}
	}
	if ans == inf || ans == 0 {
		return -1
	}
	return ans
}
