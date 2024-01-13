package main

func isValidSudoku(board [][]byte) bool {
	isRowValid := func(r int) bool {
		m := map[byte]bool{}
		for j := 0; j < 9; j++ {
			if board[r][j] != '.' && m[board[r][j]] {
				return false
			}
			m[board[r][j]] = true
		}
		return true
	}

	isColValid := func(c int) bool {
		m := map[byte]bool{}
		for i := 0; i < 9; i++ {
			if board[i][c] != '.' && m[board[i][c]] {
				return false
			}
			m[board[i][c]] = true
		}
		return true
	}

	isSubValid := func(n int) bool {
		r := (n / 3) * 3
		c := (n % 3) * 3
		m := map[byte]bool{}
		for i := r; i < r+3; i++ {
			for j := c; j < c+3; j++ {
				if board[i][j] != '.' && m[board[i][j]] {
					return false
				}
				m[board[i][j]] = true
			}
		}
		return true
	}

	for i := 0; i < 9; i++ {
		if !isRowValid(i) || !isColValid(i) || !isSubValid(i) {
			return false
		}
	}
	return true
}
