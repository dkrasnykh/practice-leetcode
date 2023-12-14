package main

func maxDistance1(grid [][]int) int {
	N := len(grid)
	q := make([][2]int, 0)
	for r := 0; r < N; r++ {
		for c := 0; c < N; c++ {
			if grid[r][c] == 1 {
				q = append(q, [...]int{r, c})
			}
		}
	}
	res := -1
	direct := [][]int{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}

	for len(q) > 0 {
		r, c := q[0][0], q[0][1]
		q = q[1:]
		res = grid[r][c]
		for _, d := range direct {
			newR, newC := r+d[0], c+d[1]
			if min(newR, newC) >= 0 &&
				max(newR, newC) < N &&
				grid[newR][newC] == 0 {
				q = append(q, [...]int{newR, newC})
				grid[newR][newC] = grid[r][c] + 1
			}
		}
	}
	if res > 1 {
		return res - 1
	}
	return -1
}
