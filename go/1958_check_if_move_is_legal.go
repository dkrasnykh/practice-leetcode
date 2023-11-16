package main

import (
	"math"
)

func checkMove(board [][]byte, rMove int, cMove int, color byte) bool {
	d := [8][2]int{{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}}
	var dfs func(r, c, dr, dc int) bool
	dfs = func(r, c, dr, dc int) bool {
		if r == 8 || c == 8 || r < 0 || c < 0 ||
			board[r][c] == '.' ||
			board[r][c] == color && math.Abs(float64(r-rMove)) <= 1 && math.Abs(float64(c-cMove)) <= 1 {
			return false
		}
		if board[r][c] == color {
			return true
		}
		return dfs(r+dr, c+dc, dr, dc)
	}

	for i := 0; i < 8; i++ {
		if dfs(rMove+d[i][0], cMove+d[i][1], d[i][0], d[i][1]) {
			return true
		}
	}

	return dfs(rMove+1, cMove, 1, 0)
}
