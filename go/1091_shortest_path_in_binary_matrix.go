package main

func shortestPathBinaryMatrix(grid [][]int) int {
	if grid[0][0] == 1 {
		return -1
	}
	n := len(grid)
	used := make([][]bool, n)
	for i := 0; i < n; i++ {
		used[i] = make([]bool, n)
	}
	d := [][]int{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}}
	q := make([][3]int, 0)
	//r, c, length
	q = append(q, [...]int{0, 0, 1})
	used[0][0] = true
	for len(q) > 0 {
		r, c, l := q[0][0], q[0][1], q[0][2]
		q = q[1:]
		if r == n-1 && c == n-1 {
			return l
		}
		for _, v := range d {
			nr := r + v[0]
			nc := c + v[1]
			if nr >= 0 && nr < n && nc >= 0 && nc < n && !used[nr][nc] && grid[nr][nc] == 0 {
				used[nr][nc] = true
				q = append(q, [...]int{nr, nc, l + 1})
			}
		}
	}
	return -1
}
